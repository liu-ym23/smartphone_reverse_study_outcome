package com.ss.android.ttve.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.ss.android.ttve.monitor.i;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.VERuntimeConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioHwEncoder {
    private static final int AAC_HE = 2;
    private static final int AAC_LC = 1;
    private static final int INIT_ENCODER_INVALID_PARAM = -101;
    private static long INPUT_DEQUEUE_TIMEOUT_US = 10000;
    private static final int MEDIACODEC_CONFIGURE_EXCEPTION = -203;
    private static final int MEDIACODEC_CREATE_FAILURE = -201;
    private static final int MEDIA_CODEC_DEQUEUE_INPUT_BUFFER_EXCEPTION = -50010;
    private static final int MEDIA_CODEC_DEQUEUE_OUTPUT_BUFFER_EXCEPTION = -60010;
    private static final int SUCCESS = 0;
    private static final String TAG = "TEAudioHwEncoder";
    private static int TRY_AGAIN_LATER_COUNT_LIMIT = 5;
    private MediaCodec audioEncoder;
    private LinkedBlockingQueue<a> audioQueue;
    private int curBitrate;
    private int curChannelCount;
    private int curCodecInfoAACProfile;
    private String curMimeType;
    private int curSampleNumPerChannel;
    private int curSampleRate;
    private volatile boolean encoderStarted;
    private volatile long inputCountDequeued;
    private volatile boolean inputEof;
    private MediaFormat inputFormat;
    private byte[] outputAsc;
    private MediaCodec.BufferInfo outputBufferInfo;
    private volatile long outputCountDequeued;
    private volatile boolean outputEof;
    private MediaFormat outputFormat;
    private int recordInputBufferSize;
    private LinkedBlockingQueue<b> remainingPcmQueue;
    private a theOldestAudioData;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f449856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f449857b;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f449858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f449859b;

        public b() {
        }
    }

    private int closeEncoder() {
        VELogUtil.i(TAG, "closeEncoder, remainingPcmQueue size: " + this.remainingPcmQueue.size() + ", audioQueue size: " + this.audioQueue.size() + ", inputCountDequeued: " + this.inputCountDequeued + ", outputCountDequeued: " + this.outputCountDequeued);
        releaseEncoder();
        this.curMimeType = null;
        this.curChannelCount = -1;
        this.curSampleRate = -1;
        this.curCodecInfoAACProfile = -1;
        this.curSampleNumPerChannel = -1;
        this.outputAsc = null;
        return 0;
    }

    private byte[] getAudioData() {
        a r100 = this.theOldestAudioData;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f449856a;
    }

    private long getAudioPts() {
        a r100 = this.theOldestAudioData;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f449857b;
    }

    private MediaCodecInfo getGoogleEncoderCodecInfo() {
        if (TextUtils.isEmpty(this.curMimeType) == false) goto L36;
        return null;
    L36:
        MediaCodecInfo[] r100 = new MediaCodecList(1).getCodecInfos();
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L34;
        MediaCodecInfo r103 = r100[r102];
        if (r103.isEncoder() == false) goto L33;
        if (r103.getName().contains("OMX.google") == false) goto L33;
        String[] r104 = r103.getSupportedTypes();
        if (r104 == null) goto L21;
        int r105 = r104.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L21;
        if (r104[r106].equalsIgnoreCase(this.curMimeType) == true) goto L19;
        r106 = r106 + 1;
        goto L16
    L19:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L33;
        MediaCodecInfo.AudioCapabilities r108 = r103.getCapabilitiesForType(this.curMimeType).getAudioCapabilities();
        if (r108 != null) goto L27;
        VELogUtil.e(TAG, r103.getName() + " null audio capabilities");
        goto L33
    L27:
        if (r108.isSampleRateSupported(this.curSampleRate) == true) goto L30;
        VELogUtil.e(TAG, r103.getName() + " not support SampleRate: " + this.curSampleRate);
        goto L33
    L30:
        if (this.curChannelCount <= r108.getMaxInputChannelCount()) goto L32;
        VELogUtil.e(TAG, r103.getName() + " not support ChannelCount: " + this.curChannelCount + ", max channel count is " + r108.getMaxInputChannelCount());
        goto L33
    L32:
        return r103;
    L21:
        r107 = false;
    L33:
        r102 = r102 + 1;
    L34:
        return null;
    }

    private void releaseEncoder() {
        if (this.audioEncoder != null) goto L22;
        return;
    L22:
    L16:
        e = move-exception;
        VELogUtil.e(TAG, "releaseEncoder: " + e.getMessage());     // Catch: Throwable -> L14
    L13:
        resetCodecInfo();
        return;
    L14:
        th = move-exception;
        resetCodecInfo();
        throw th;
    L6:
        if (this.encoderStarted == true) goto L25;
    L12:
        this.audioEncoder.release();     // Catch: Throwable -> L14 Exception -> L16
        this.audioEncoder = null;     // Catch: Throwable -> L14 Exception -> L16
    L25:
        this.audioEncoder.stop();     // Catch: Exception -> L9 Throwable -> L14
    L11:
        this.encoderStarted = false;     // Catch: Throwable -> L14 Exception -> L16
    L9:
        e = move-exception;
        VELogUtil.e(TAG, "MediaCodec stop exception: " + e.getMessage());     // Catch: Throwable -> L14 Exception -> L16
        goto L11
    }

    private void resetCodecInfo() {
        this.inputCountDequeued = 0;
        this.outputCountDequeued = 0;
        this.inputEof = false;
        this.outputEof = false;
        this.remainingPcmQueue.clear();
        this.audioQueue.clear();
    }

    private MediaCodec selectMediaCodec() {
        MediaCodec r100 = null;
        if (TextUtils.isEmpty(this.curMimeType) == false) goto L5;
        return null;
    L5:
        MediaCodecInfo r101 = getGoogleEncoderCodecInfo();
        if (r101 != null) goto L32;
    L7:
        MediaCodec r102 = null;
    L12:
        if (r102 == null) goto L34;
        r100 = r102;
    L18:
        if (r100 == null) goto L31;
        VELogUtil.i(TAG, "selectMediaCodec, encoder name: " + r100.getName());
        if (this.inputFormat == null) goto L31;
        MediaCodecInfo.CodecProfileLevel[] r103 = r100.getCodecInfo().getCapabilitiesForType(this.curMimeType).profileLevels;
        boolean r104 = false;
        if (r103 == null) goto L29;
        int r105 = r103.length;
        int r106 = 0;
    L24:
        if (r106 >= r105) goto L29;
        if (r103[r106].profile == this.curCodecInfoAACProfile) goto L27;
        r106 = r106 + 1;
        goto L24
    L27:
        r104 = true;
    L29:
        if (r104 == false) goto L31;
        this.inputFormat.setInteger("aac-profile", this.curCodecInfoAACProfile);
        VELogUtil.i(TAG, "final profile: " + this.curCodecInfoAACProfile);
    L31:
        return r100;
    L34:
        r100 = MediaCodec.createEncoderByType(this.curMimeType);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        VELogUtil.e(TAG, "createEncoderByType error: " + e.getMessage());
        goto L18
    L32:
        r102 = MediaCodec.createByCodecName(r101.getName());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        VELogUtil.e(TAG, "createByCodecName error: " + e.getMessage());
        goto L7
    }

    private int startEncoder() {
        MediaCodec r100 = selectMediaCodec();     // Catch: Exception -> L10
        this.audioEncoder = r100;     // Catch: Exception -> L10
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "create encoder failure, mime: " + this.curMimeType);     // Catch: Exception -> L10
        return -201;
    L7:
        r100.configure(this.inputFormat, null, null, 1);     // Catch: Exception -> L10
        this.audioEncoder.start();     // Catch: Exception -> L10
        this.encoderStarted = true;     // Catch: Exception -> L10
        return 0;
    L10:
        e = move-exception;
        VELogUtil.e(TAG, "startEncoder: " + e.getMessage());
        return -203;
    }

    private TEAudioHwEncoder() {
        this.curSampleRate = -1;
        this.curChannelCount = -1;
        this.curCodecInfoAACProfile = -1;
        this.curBitrate = -1;
        this.curSampleNumPerChannel = -1;
        this.encoderStarted = false;
        this.inputCountDequeued = 0;
        this.outputCountDequeued = 0;
        this.inputEof = false;
        this.outputEof = false;
        this.recordInputBufferSize = -1;
        this.remainingPcmQueue = new LinkedBlockingQueue();
        this.theOldestAudioData = null;
        this.audioQueue = new LinkedBlockingQueue();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
    }

    private int restartEncoder() {
        releaseEncoder();
        return startEncoder();
    }

    private byte[] getOutputAsc() {
        return this.outputAsc;
    }

    private void addAudioData(byte[] r100) {
        a r101 = new a();
        r101.f449856a = r100;
        MediaCodec.BufferInfo r102 = this.outputBufferInfo;
        r101.f449857b = r102.presentationTimeUs;
        int r103 = r102.flags;
        this.audioQueue.add(r101);
    }

    private int drainOutputBuffer(boolean r110) {
    L3:
        int r100 = 0;
    L59:
    L56:
        th = move-exception;
        VELogUtil.e(TAG, "drainOutputBuffer error: " + th.getMessage());
        return MEDIA_CODEC_DEQUEUE_OUTPUT_BUFFER_EXCEPTION;
    L5:
        if (this.outputEof == true) goto L55;
        MediaCodec r101 = this.audioEncoder;     // Catch: Throwable -> L56
        MediaCodec.BufferInfo r102 = this.outputBufferInfo;     // Catch: Throwable -> L56
        if (r100 <= 0) goto L9;
        long r103 = 10000;
    L10:
        int r104 = r101.dequeueOutputBuffer(r102, r103);     // Catch: Throwable -> L56
        if (r104 >= 0) goto L13;
        if (r104 == (-3)) goto L29;
        if (r104 == (-2)) goto L32;
        if (r104 != (-1)) goto L54;
        if (r110 == false) goto L45;
        VELogUtil.d(TAG, "dequeue output buffer timeout, try again later");     // Catch: Throwable -> L56
    L45:
        if (this.inputEof == true) goto L51;
        if (r110 == false) goto L55;
        byte[] r105 = this.outputAsc;     // Catch: Throwable -> L56
        if (r105 == null) goto L51;
        if (r105.length > 0) goto L55;
    L51:
        r100 = r100 + 1;     // Catch: Throwable -> L56
        VELogUtil.i(TAG, "inputEof, tryAgainLaterCount: " + r100);     // Catch: Throwable -> L56
        if (r100 <= TRY_AGAIN_LATER_COUNT_LIMIT) goto L59;
        VELogUtil.d(TAG, "dequeue output buffer timeout, tryAgainLaterCount: " + r100);     // Catch: Throwable -> L56
        goto L55
    L54:
        VELogUtil.d(TAG, "not available output buffer");     // Catch: Throwable -> L56
        goto L55
    L32:
        this.outputFormat = this.audioEncoder.getOutputFormat();     // Catch: Throwable -> L56
        VELogUtil.i(TAG, "output buffer format changed: " + this.outputFormat);     // Catch: Throwable -> L56
        int r106 = this.outputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: Throwable -> L56
        int r107 = this.outputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: Throwable -> L56
        if (this.curSampleRate == r106) goto L35;
    L36:
        VELogUtil.e(TAG, "audio meta info changed, error error error !!!");     // Catch: Throwable -> L56
    L37:
        ByteBuffer r108 = this.outputFormat.getByteBuffer("csd-0");     // Catch: Throwable -> L56
        if (r108.remaining() <= 0) goto L3;
        byte[] r109 = new byte[r108.remaining()];     // Catch: Throwable -> L56
        r108.get(r109);     // Catch: Throwable -> L56
        this.outputAsc = r109;     // Catch: Throwable -> L56
        goto L3
    L35:
        if (this.curChannelCount == r107) goto L37;
    L29:
        VELogUtil.i(TAG, "output buffer changed, need to getOutputBuffers again");     // Catch: Throwable -> L56
        goto L3
    L13:
        if (this.outputBufferInfo.size <= 0) goto L24;
        ByteBuffer r111 = geOutputBufferByIndex(r104);     // Catch: Throwable -> L56
        r111.position(this.outputBufferInfo.offset);     // Catch: Throwable -> L56
        MediaCodec.BufferInfo r112 = this.outputBufferInfo;     // Catch: Throwable -> L56
        r111.limit(r112.offset + r112.size);     // Catch: Throwable -> L56
        byte[] r113 = new byte[this.outputBufferInfo.size];     // Catch: Throwable -> L56
        r111.get(r113);     // Catch: Throwable -> L56
        if ((this.outputBufferInfo.flags & 2) == 0) goto L19;
        this.outputAsc = r113;     // Catch: Throwable -> L56
        VELogUtil.i(TAG, "output BUFFER_FLAG_CODEC_CONFIG, asc size: " + this.outputBufferInfo.size + ", pts: " + this.outputBufferInfo.presentationTimeUs);     // Catch: Throwable -> L56
        goto L24
    L19:
        if (this.outputCountDequeued > 0) goto L21;
    L23:
        addAudioData(r113);     // Catch: Throwable -> L56
        this.outputCountDequeued++;     // Catch: Throwable -> L56
        goto L24
    L21:
        if (this.outputBufferInfo.presentationTimeUs > 0) goto L23;
        VELogUtil.e(TAG, "outputCountDequeued: " + this.outputCountDequeued + ", size: " + this.outputBufferInfo.size + ", pts: " + this.outputBufferInfo.presentationTimeUs);     // Catch: Throwable -> L56
    L24:
        this.audioEncoder.releaseOutputBuffer(r104, false);     // Catch: Throwable -> L56
        if ((this.outputBufferInfo.flags & 4) == 0) goto L3;
        VELogUtil.i(TAG, "output buffer eof");     // Catch: Throwable -> L56
        this.outputEof = true;     // Catch: Throwable -> L56
        goto L55
    L9:
        r103 = 0;
    L55:
        return 0;
    }

    private ByteBuffer geOutputBufferByIndex(int r100) {
        return this.audioEncoder.getOutputBuffer(r100);
    }

    private ByteBuffer getInputBufferByIndex(int r100) {
        return this.audioEncoder.getInputBuffer(r100);
    }

    private void addPcmData(byte[] r100, long r101) {
        b r102 = new b();
        r102.f449858a = r100;
        r102.f449859b = r101;
        this.remainingPcmQueue.add(r102);
    }

    public int encodeFrame(byte[] r110, long r111) {
        int r100 = VERuntimeConfig.f455713e;
        int r101 = VERuntimeConfig.HwEncFallBackMode.AUDIO_ENC_ENCODING_FALLBACK.getValue();
        int r102 = MEDIA_CODEC_DEQUEUE_INPUT_BUFFER_EXCEPTION;
        if (r100 != r101) goto L55;
        VELogUtil.e(TAG, "TESTING! HW AUDIO ENC ENCODING FALLBACK");
        return MEDIA_CODEC_DEQUEUE_INPUT_BUFFER_EXCEPTION;
    L55:
    L41:
        th = move-exception;
        VELogUtil.e(TAG, "drainOutputBuffer error: " + th.getMessage());
    L43:
        if (r102 >= 0) goto L46;
        return r102;
    L46:
        if (this.audioQueue.isEmpty() == true) goto L48;
    L51:
        a r103 = this.audioQueue.poll();
        this.theOldestAudioData = r103;
        if (r103 != null) goto L54;
        return 0;
    L54:
        return r103.f449856a.length;
    L48:
        if (this.outputEof == false) goto L51;
        VELogUtil.i(TAG, "encoder all EOF");
        return -1024;
    L8:
        if (this.inputEof == true) goto L10;
        addPcmData(r110, r111);     // Catch: Throwable -> L41
    L10:
        int r104 = 0;
    L12:
        if (this.inputEof == true) goto L39;
        if (this.remainingPcmQueue.isEmpty() == true) goto L39;
        b r105 = this.remainingPcmQueue.poll();     // Catch: Throwable -> L41
        if (r105 == null) goto L39;
        int r112 = this.audioEncoder.dequeueInputBuffer(INPUT_DEQUEUE_TIMEOUT_US);     // Catch: Throwable -> L41
        if (r112 >= 0) goto L20;
        if (r112 != (-1)) goto L38;
        VELogUtil.d(TAG, "dequeue input buffer timeout, try again later");     // Catch: Throwable -> L41
        r104 = r104 + 1;     // Catch: Throwable -> L41
        if (r104 <= TRY_AGAIN_LATER_COUNT_LIMIT) goto L12;
        VELogUtil.d(TAG, "dequeue input buffer timeout, tryAgainLaterCount: " + r104);     // Catch: Throwable -> L41
        goto L39
    L38:
        VELogUtil.d(TAG, "not available input buffer");     // Catch: Throwable -> L41
        goto L39
    L20:
        byte[] r106 = r105.f449858a;     // Catch: Throwable -> L41
        if (r106 == null) goto L32;
        if (r106.length <= 0) goto L32;
        int r107 = r106.length;     // Catch: Throwable -> L41
        ByteBuffer r108 = getInputBufferByIndex(r112);     // Catch: Throwable -> L41
        r108.clear();     // Catch: Throwable -> L41
        int r109 = r108.remaining();     // Catch: Throwable -> L41
        if (r107 <= r109) goto L29;
        VELogUtil.e(TAG, "input buffer not enough, audio data size: " + r107 + ", buffer available size: " + r109);     // Catch: Throwable -> L41
    L31:
        int r113 = Math.min(r107, r109);     // Catch: Throwable -> L41
        r108.put(r105.f449858a, 0, r113);     // Catch: Throwable -> L41
        this.audioEncoder.queueInputBuffer(r112, 0, r113, r105.f449859b, 0);     // Catch: Throwable -> L41
        this.inputCountDequeued++;     // Catch: Throwable -> L41
        goto L12
    L29:
        if (r109 == this.recordInputBufferSize) goto L31;
        VELogUtil.i(TAG, "recordInputBufferSize changed, old: " + this.recordInputBufferSize + ", new: " + r109);     // Catch: Throwable -> L41
        this.recordInputBufferSize = r109;     // Catch: Throwable -> L41
    L32:
        this.audioEncoder.queueInputBuffer(r112, 0, 0, r105.f449859b, 4);     // Catch: Throwable -> L41
        this.inputEof = true;     // Catch: Throwable -> L41
        VELogUtil.i(TAG, "input buffer eof, remainingPcmQueue size: " + this.remainingPcmQueue.size());     // Catch: Throwable -> L41
    L39:
        r102 = drainOutputBuffer(false);     // Catch: Throwable -> L41
        goto L43
    }

    private int initEncoder(String r110, int r111, int r210, int r211, int r212, int r213) {
        if (VERuntimeConfig.f455713e != VERuntimeConfig.HwEncFallBackMode.AUDIO_ENC_INIT_FALLBACK.getValue()) goto L7;
        VELogUtil.e(TAG, "TESTING! HW AUDIO ENC INIT FALLBACK");
        return -203;
    L7:
        if (TextUtils.isEmpty(r110) == true) goto L46;
        if (r111 <= 0) goto L46;
        if (r210 <= 0) goto L46;
        if (r211 <= 0) goto L46;
        if (r212 <= 0) goto L46;
        if (r213 <= 0) goto L46;
        if (r111 != 2) goto L17;
        int r100 = 5;
    L19:
        if (r110.equals(this.curMimeType) == true) goto L21;
    L30:
        boolean r112 = true;
    L31:
        this.curMimeType = r110;
        this.curCodecInfoAACProfile = r100;
        this.curSampleRate = r210;
        this.curChannelCount = r211;
        this.curBitrate = r212;
        this.curSampleNumPerChannel = r213;
        VELogUtil.i(TAG, "initEncoder, mimeType: " + r110 + ", codecInfoAACProfile: " + r100 + ", sampleRate: " + r210 + ", channelCount: " + r211 + ", bitrate: " + r212 + ", sampleNumPerChannel: " + r213);
        if (r112 == false) goto L34;
    L37:
        MediaFormat r101 = MediaFormat.createAudioFormat(r110, r210, r211);
        this.inputFormat = r101;
        r101.setInteger("bitrate", r212);
        this.inputFormat.setInteger("aac-profile", 2);
        int r102 = ((this.curChannelCount * r213) * 2) * 2;
        this.inputFormat.setInteger("max-input-size", r102);
        VELogUtil.i(TAG, "KEY_MAX_INPUT_SIZE: " + r102);
        int r103 = restartEncoder();
    L38:
        if (r103 != 0) goto L43;
        VELogUtil.i(TAG, "initEncoder, try to get asc start");
        int r104 = 1;
        r103 = drainOutputBuffer(true);
        VELogUtil.i(TAG, "initEncoder, try to get asc end");
        if (r103 != 0) goto L42;
        int r105 = 0;
    L44:
        i.f(r104, "te_composition_audio_create_hw_encoder", r105);
        VELogUtil.i(TAG, "initEncoder, result: " + r103 + ", monitor: " + r105);
        return r103;
    L42:
        r105 = 3;
        goto L44
    L43:
        r104 = 1;
        r105 = 1;
        goto L44
    L34:
        if (this.encoderStarted == false) goto L37;
        r103 = 0;
        goto L38
    L21:
        if (this.curCodecInfoAACProfile != r100) goto L30;
        if (this.curSampleRate != r210) goto L30;
        if (this.curChannelCount != r211) goto L30;
        if (this.curSampleNumPerChannel != r213) goto L30;
        r112 = false;
        goto L31
    L17:
        r100 = 2;
    L46:
        VELogUtil.e(TAG, "initEncoder invalid param, mimeType: " + r110 + ", profile: " + r111 + ", sampleRate: " + r210 + ", channelCount: " + r211 + ", bitrate: " + r212 + ", sampleNumPerChannel: " + r213);
        i.f(1, "te_composition_audio_create_hw_encoder", 2);
        return -101;
    }
}
