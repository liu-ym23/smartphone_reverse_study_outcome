package com.ss.android.ttve.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.ss.android.vesdk.VELogUtil;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioHwDecoder {
    private static final int FLUSH_DECODER_EXCEPTION = -211;
    private static final int INIT_DECODER_INVALID_PARAM = -101;
    private static long INPUT_DEQUEUE_TIMEOUT_US = 10000;
    private static final int MEDIACODEC_CONFIGURE_EXCEPTION = -203;
    private static final int MEDIACODEC_CREATE_FAILURE = -201;
    private static final int MEDIACODEC_NULL = -204;
    private static final int MEDIA_CODEC_DEQUEUE_INPUT_BUFFER_EXCEPTION = -5000;
    private static final int MEDIA_CODEC_DEQUEUE_OUTPUT_BUFFER_EXCEPTION = -6000;
    private static final int SUCCESS = 0;
    private static final String TAG = "TEAudioHwDecoder";
    private MediaCodec audioDecoder;
    private byte[] curAsc;
    private int curChannelCount;
    private String curMimeType;
    private int curSampleRate;
    private volatile boolean decoderStarted;
    private volatile long inputCountQueued;
    private volatile boolean inputEof;
    private MediaFormat inputFormat;
    private MediaCodec.BufferInfo outputBufferInfo;
    private volatile long outputCountDequeued;
    private volatile boolean outputEof;
    private MediaFormat outputFormat;
    private LinkedBlockingQueue<a> pcmQueue;
    private a theOldestPcmData;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f449854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f449855b;

        public a() {
        }
    }

    private int closeDecoder() {
        VELogUtil.i(TAG, "closeDecoder, " + hashCode());
        releaseDecoder();
        this.curMimeType = null;
        this.curSampleRate = -1;
        this.curChannelCount = -1;
        this.curAsc = null;
        return 0;
    }

    private int drainOutputBuffer() {
    L31:
    L28:
        th = move-exception;
        VELogUtil.e(TAG, "drainOutputBuffer error: " + th.getMessage());
        return MEDIA_CODEC_DEQUEUE_OUTPUT_BUFFER_EXCEPTION;
    L4:
        if (this.outputEof == true) goto L27;
        int r100 = this.audioDecoder.dequeueOutputBuffer(this.outputBufferInfo, 0);     // Catch: Throwable -> L28
        if (r100 >= 0) goto L8;
        if (r100 == (-3)) goto L15;
        if (r100 != (-2)) goto L24;
        this.outputFormat = this.audioDecoder.getOutputFormat();     // Catch: Throwable -> L28
        VELogUtil.i(TAG, "output buffer format changed: " + this.outputFormat);     // Catch: Throwable -> L28
        int r101 = this.outputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: Throwable -> L28
        int r102 = this.outputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: Throwable -> L28
        if (this.curSampleRate != r101) goto L22;
        if (this.curChannelCount == r102) goto L31;
    L22:
        VELogUtil.e(TAG, "audio meta info changed, error error error !!!");     // Catch: Throwable -> L28
        goto L31
    L24:
        if (r100 == (-1)) goto L27;
        VELogUtil.d(TAG, "not available output buffer");     // Catch: Throwable -> L28
        goto L27
    L15:
        VELogUtil.i(TAG, "output buffer changed, need to getOutputBuffers again");     // Catch: Throwable -> L28
        goto L31
    L8:
        if (this.outputBufferInfo.size <= 0) goto L10;
        ByteBuffer r103 = geOutputBufferByIndex(r100);     // Catch: Throwable -> L28
        r103.position(this.outputBufferInfo.offset);     // Catch: Throwable -> L28
        MediaCodec.BufferInfo r104 = this.outputBufferInfo;     // Catch: Throwable -> L28
        r103.limit(r104.offset + r104.size);     // Catch: Throwable -> L28
        byte[] r105 = new byte[this.outputBufferInfo.size];     // Catch: Throwable -> L28
        r103.get(r105);     // Catch: Throwable -> L28
        addPcmData(r105);     // Catch: Throwable -> L28
        this.outputCountDequeued++;     // Catch: Throwable -> L28
    L10:
        this.audioDecoder.releaseOutputBuffer(r100, false);     // Catch: Throwable -> L28
        if ((this.outputBufferInfo.flags & 4) == 0) goto L31;
        VELogUtil.i(TAG, "output buffer eof");     // Catch: Throwable -> L28
        this.outputEof = true;     // Catch: Throwable -> L28
    L27:
        return 0;
    }

    private int flushDecoder() {
        VELogUtil.i(TAG, "flushDecoder, inputEof: " + this.inputEof + ", outputEof: " + this.outputEof + ", inputCountQueued: " + this.inputCountQueued + ", " + hashCode());
        if (this.audioDecoder != null) goto L29;
        return -204;
    L29:
    L20:
        th = move-exception;
        VELogUtil.e(TAG, "flushDecoder error: " + th.getMessage());     // Catch: Throwable -> L24
        this.pcmQueue.clear();
        this.theOldestPcmData = null;
        return -211;
    L24:
        th = move-exception;
        this.pcmQueue.clear();
        this.theOldestPcmData = null;
        throw th;
    L8:
        if (this.inputEof == false) goto L10;
    L17:
        int r100 = restartDecoder();     // Catch: Throwable -> L20
        this.pcmQueue.clear();
        this.theOldestPcmData = null;
        return r100;
    L10:
        if (this.outputEof == true) goto L17;
        if (this.inputCountQueued <= 0) goto L15;
        this.audioDecoder.flush();     // Catch: Throwable -> L20
        this.inputCountQueued = 0;     // Catch: Throwable -> L20
        this.outputCountDequeued = 0;     // Catch: Throwable -> L20
    L15:
        this.pcmQueue.clear();
        this.theOldestPcmData = null;
        return 0;
    }

    private MediaCodecInfo getGoogleMediaCodecInfo() {
        if (TextUtils.isEmpty(this.curMimeType) == false) goto L31;
        return null;
    L31:
        MediaCodecInfo[] r100 = new MediaCodecList(1).getCodecInfos();
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L29;
        MediaCodecInfo r103 = r100[r102];
        if (r103.isEncoder() == true) goto L28;
        if (r103.getName().contains("OMX.google") == false) goto L28;
        String[] r104 = r103.getSupportedTypes();
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L19;
        if (r104[r106].equalsIgnoreCase(this.curMimeType) == true) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L28;
        MediaCodecInfo.AudioCapabilities r108 = r103.getCapabilitiesForType(this.curMimeType).getAudioCapabilities();
        if (r108.isSampleRateSupported(this.curSampleRate) == true) goto L25;
        VELogUtil.e(TAG, r103.getName() + " not support SampleRate: " + this.curSampleRate);
        goto L28
    L25:
        if (this.curChannelCount <= r108.getMaxInputChannelCount()) goto L27;
        VELogUtil.e(TAG, r103.getName() + " not support ChannelCount: " + this.curChannelCount + ", max channel count is " + r108.getMaxInputChannelCount());
        goto L28
    L27:
        return r103;
    L19:
        r107 = false;
    L28:
        r102 = r102 + 1;
    L29:
        return null;
    }

    private byte[] getPcmData() {
        a r100 = this.theOldestPcmData;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f449854a;
    }

    private long getPcmPts() {
        a r100 = this.theOldestPcmData;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f449855b;
    }

    private void releaseDecoder() {
        if (this.audioDecoder != null) goto L6;
        return;
    L6:
        if (this.decoderStarted == true) goto L14;
    L12:
        this.audioDecoder.release();
        this.audioDecoder = null;
        resetCodecInfo();
        return;
    L14:
        this.audioDecoder.stop();     // Catch: Exception -> L9
    L11:
        this.decoderStarted = false;
    L9:
        e = move-exception;
        VELogUtil.e(TAG, "MediaCodec stop exception: " + e.getMessage());
        goto L11
    }

    private void resetCodecInfo() {
        this.inputCountQueued = 0;
        this.outputCountDequeued = 0;
        this.inputEof = false;
        this.outputEof = false;
    }

    private MediaCodec selectMediaCodec() {
        MediaCodec r100 = null;
        if (TextUtils.isEmpty(this.curMimeType) == false) goto L5;
        return null;
    L5:
        MediaCodecInfo r101 = getGoogleMediaCodecInfo();
        if (r101 != null) goto L21;
    L7:
        MediaCodec r102 = null;
    L12:
        if (r102 == null) goto L23;
        r100 = r102;
    L18:
        if (r100 == null) goto L20;
        VELogUtil.i(TAG, "selectMediaCodec, decoder name: " + r100.getName());
    L20:
        return r100;
    L23:
        r100 = MediaCodec.createDecoderByType(this.curMimeType);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        VELogUtil.e(TAG, "createDecoderByType error: " + e.getMessage());
        goto L18
    L21:
        r102 = MediaCodec.createByCodecName(r101.getName());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        VELogUtil.e(TAG, "createByCodecName error: " + e.getMessage());
        goto L7
    }

    private int startDecoder() {
        MediaCodec r100 = selectMediaCodec();     // Catch: Exception -> L9
        this.audioDecoder = r100;     // Catch: Exception -> L9
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "create decoder failure, mime: " + this.curMimeType);     // Catch: Exception -> L9
        return -201;
    L7:
        r100.configure(this.inputFormat, null, null, 0);     // Catch: Exception -> L9
        this.audioDecoder.start();     // Catch: Exception -> L9
        this.decoderStarted = true;     // Catch: Exception -> L9
        return 0;
    L9:
        e = move-exception;
        VELogUtil.e(TAG, "startDecoder: " + e.getMessage());
        return -203;
    }

    private TEAudioHwDecoder() {
        this.curSampleRate = -1;
        this.curChannelCount = -1;
        this.decoderStarted = false;
        this.inputCountQueued = 0;
        this.outputCountDequeued = 0;
        this.inputEof = false;
        this.outputEof = false;
        this.theOldestPcmData = null;
        this.pcmQueue = new LinkedBlockingQueue();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
    }

    private int restartDecoder() {
        releaseDecoder();
        return startDecoder();
    }

    private void addPcmData(byte[] r100) {
        a r101 = new a();
        r101.f449854a = r100;
        MediaCodec.BufferInfo r102 = this.outputBufferInfo;
        r101.f449855b = r102.presentationTimeUs;
        int r103 = r102.flags;
        this.pcmQueue.add(r101);
    }

    private ByteBuffer geOutputBufferByIndex(int r100) {
        return this.audioDecoder.getOutputBuffer(r100);
    }

    private ByteBuffer getInputBufferByIndex(int r100) {
        return this.audioDecoder.getInputBuffer(r100);
    }

    private boolean sameAsc(byte[] r100) {
        byte[] r101 = this.curAsc;
        if (r101 != null) goto L7;
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r101 == null) goto L21;
        if (r100 == null) goto L21;
        if (r101.length == r100.length) goto L13;
        return false;
    L13:
        int r102 = 0;
    L14:
        byte[] r103 = this.curAsc;
        if (r102 >= r103.length) goto L20;
        if (r103[r102] != r100[r102]) goto L18;
        r102 = r102 + 1;
        goto L14
    L18:
        return false;
    L20:
        return true;
    L21:
        return false;
    }

    private int[] decodeFrame(byte[] r110, long r210) {
        if (r110 != null) goto L5;
    L8:
        int r100 = 0;
        int r101 = 0;
        boolean r102 = true;
    L32:
    L24:
        th = move-exception;
        VELogUtil.e(TAG, "drainOutputBuffer error: " + th.getMessage());
        int r103 = -5000;
    L26:
        a r104 = this.pcmQueue.poll();
        this.theOldestPcmData = r104;
        if (r104 == null) goto L29;
        int r105 = r104.f449854a.length;
    L31:
        return new int[]{r103, r101, r105};
    L29:
        r105 = 0;
        goto L31
    L10:
        if (this.inputEof == true) goto L22;
        if (r101 < r100) goto L13;
        if (r102 == false) goto L22;
    L13:
        int r111 = this.audioDecoder.dequeueInputBuffer(INPUT_DEQUEUE_TIMEOUT_US);     // Catch: Throwable -> L24
        if (r111 < 0) goto L19;
        if (r102 == true) goto L16;
        ByteBuffer r106 = getInputBufferByIndex(r111);     // Catch: Throwable -> L24
        r106.clear();     // Catch: Throwable -> L24
        int r112 = Math.min(r100 - r101, r106.remaining());     // Catch: Throwable -> L24
        r106.put(r110, r101, r112);     // Catch: Throwable -> L24
        r101 = r101 + r112;     // Catch: Throwable -> L24
        this.audioDecoder.queueInputBuffer(r111, 0, r112, r210, 0);     // Catch: Throwable -> L24
        this.inputCountQueued++;     // Catch: Throwable -> L24
        goto L32
    L16:
        this.audioDecoder.queueInputBuffer(r111, 0, 0, r210, 4);     // Catch: Throwable -> L24
        this.inputEof = true;     // Catch: Throwable -> L24
        VELogUtil.i(TAG, "input buffer eof");     // Catch: Throwable -> L24
        goto L22
    L19:
        if (r111 != (-1)) goto L21;
        VELogUtil.d(TAG, "dequeue input buffer timeout, try again later");     // Catch: Throwable -> L24
        goto L22
    L21:
        VELogUtil.d(TAG, "not available input buffer");     // Catch: Throwable -> L24
    L22:
        r103 = drainOutputBuffer();     // Catch: Throwable -> L24
        goto L26
    L5:
        if (r110.length <= 0) goto L8;
        r100 = r110.length;
        r101 = 0;
        r102 = false;
        goto L32
    }

    private int initDecoder(String r100, int r101, int r102, byte[] r103) {
        if (TextUtils.isEmpty(r100) == true) goto L36;
        if (r101 <= 0) goto L38;
        if (r102 > 0) goto L8;
        return -101;
    L8:
        if (r100.equals(this.curMimeType) == true) goto L10;
    L17:
        boolean r104 = true;
    L18:
        this.curMimeType = r100;
        this.curSampleRate = r101;
        this.curChannelCount = r102;
        this.curAsc = r103;
        StringBuilder r105 = new StringBuilder("initDecoder, mimeType: ");
        r105.append(r100);
        r105.append(", sampleRate: ");
        r105.append(r101);
        r105.append(", channelCount: ");
        r105.append(r102);
        r105.append(", asc size: ");
        if (r103 == null) goto L21;
        int r106 = r103.length;
    L22:
        r105.append(r106);
        r105.append(", this: ");
        r105.append(hashCode());
        VELogUtil.i(TAG, r105.toString());
        if (r104 == false) goto L25;
    L28:
        MediaFormat r107 = MediaFormat.createAudioFormat(r100, r101, r102);
        this.inputFormat = r107;
        if (r103 != null) goto L31;
    L33:
        r107.setInteger("is-adts", 1);
    L35:
        return restartDecoder();
    L31:
        if (r103.length <= 0) goto L33;
        r107.setByteBuffer("csd-0", ByteBuffer.wrap(r103));
        goto L35
    L25:
        if (this.decoderStarted == false) goto L28;
        return 0;
    L21:
        r106 = -1;
        goto L22
    L10:
        if (this.curSampleRate != r101) goto L17;
        if (this.curChannelCount != r102) goto L17;
        if (sameAsc(r103) == false) goto L17;
        r104 = false;
        goto L18
    L38:
        return -101;
    L36:
        return -101;
    }
}
