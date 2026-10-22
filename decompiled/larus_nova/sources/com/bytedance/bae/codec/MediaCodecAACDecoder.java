package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.bytedance.realx.base.RXLogging;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes47.dex */
public class MediaCodecAACDecoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACDecoder";
    private long input_ts;
    private MediaCodec mAACDecoder;
    private byte[] mAsc;
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannels;
    private byte[] mDecodedData;
    private int mHasADTS;
    private ByteBuffer[] mInputBuffers;
    private String mMimeType;
    private ByteBuffer[] mOutputBuffers;
    private MediaFormat mOutputFormat;
    private int mProfile;
    private int mSampleRate;
    private long output_ts;

    public boolean configAndStartDecoder() {
        MediaFormat r100 = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);     // Catch: Exception -> L6
        r100.setInteger("aac-profile", this.mProfile);     // Catch: Exception -> L6
        r100.setInteger("is-adts", this.mHasADTS);     // Catch: Exception -> L6
        r100.setInteger("aac-max-output-channel_count", this.mChannels);     // Catch: Exception -> L6
        genAsc();     // Catch: Exception -> L6
        r100.setByteBuffer("csd-0", ByteBuffer.wrap(this.mAsc));     // Catch: Exception -> L6
        this.mAACDecoder.configure(r100, null, null, 0);     // Catch: Exception -> L6
        this.mAACDecoder.start();     // Catch: Exception -> L6
        this.mBufferInfo = new MediaCodec.BufferInfo();     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        closeDecoder();
        RXLogging.e(TAG, "Config and Start Decoder Error");
        return false;
    }

    public boolean openEncoder() {
        MediaCodec r100 = MediaCodec.createDecoderByType(this.mMimeType);     // Catch: Exception -> L7
        this.mAACDecoder = r100;     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        this.mAACDecoder = null;
        RXLogging.e(TAG, "Open AAC Decoder failed");
        return false;
    }

    private void genAsc() {
        int r100 = this.mProfile;
        int r101 = 4;
        if (r100 != 2) goto L5;
        this.mAsc = new byte[2];
    L6:
        int r102 = this.mSampleRate;
        if (48000 != r102) goto L10;
        r101 = 3;
        int r103 = 6;
    L16:
        int r104 = this.mChannels;
        if (1 != r104) goto L19;
        int r105 = 1;
    L22:
        byte r110 = (byte) r100;
        if (2 != r100) goto L25;
        byte[] r106 = this.mAsc;
        r106[0] = (byte) ((r110 << 3) | (r101 >> 1));
        r106[1] = (byte) ((r101 << 7) | (r105 << 3));
        return;
    L25:
        if (5 != r100) goto L28;
        byte[] r107 = this.mAsc;
        r107[0] = (byte) ((r110 << 3) | (r103 >> 1));
        r107[1] = (byte) (((r103 << 7) | (r105 << 3)) | (r101 >> 1));
        r107[2] = (byte) ((r101 << 7) | 8);
        r107[3] = 0;
        return;
    L28:
        if (29 != r100) goto L33;
        byte[] r108 = this.mAsc;
        r108[0] = (byte) ((r110 << 3) | (r103 >> 1));
        r108[1] = (byte) (((r103 << 7) | 8) | (r101 >> 1));
        r108[2] = (byte) ((r101 << 7) | 8);
        r108[3] = 0;
        return;
    L33:
        return;
    L19:
        if (2 != r104) goto L21;
        r105 = 2;
        goto L22
    L21:
        r105 = 0;
        goto L22
    L10:
        if (44100 != r102) goto L13;
        r103 = 7;
        goto L16
    L13:
        if (32000 != r102) goto L15;
        r101 = 5;
        r103 = 8;
        goto L16
    L15:
        r101 = 0;
        r103 = 0;
        goto L16
    L5:
        this.mAsc = new byte[4];
        goto L6
    }

    public void closeDecoder() {
        MediaCodec r100 = this.mAACDecoder;     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.stop();     // Catch: Exception -> L6
        this.mAACDecoder.release();     // Catch: Exception -> L6
        this.mAACDecoder = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "close AAC decoder failed");
    }

    public int getOutputChannels() {
        return this.mOutputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);
    }

    public int getOutputSampleRate() {
        return this.mOutputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);
    }

    public MediaCodecAACDecoder() {
        this.mMimeType = "audio/mp4a-latm";
        this.mSampleRate = 44100;
        this.mChannels = 1;
        this.mProfile = 2;
        this.mHasADTS = 0;
        this.input_ts = 0;
        this.output_ts = 0;
        this.mAACDecoder = null;
        RXLogging.e(TAG, "MediaCodecAAC Decoder Created");
    }

    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    public long getOutputTs() {
        return this.output_ts;
    }

    public boolean decodeProcess(byte[] r110) {
        MediaCodec r100 = this.mAACDecoder;     // Catch: Exception -> L15
        if (r100 != null) goto L6;
        return false;
    L6:
        this.mDecodedData = null;     // Catch: Exception -> L15
        int r101 = r100.dequeueInputBuffer(300);     // Catch: Exception -> L15
        if (r101 < 0) goto L9;
        ByteBuffer r102 = this.mAACDecoder.getInputBuffer(r101);     // Catch: Exception -> L15
        r102.clear();     // Catch: Exception -> L15
        r102.put(r110);     // Catch: Exception -> L15
        this.mAACDecoder.queueInputBuffer(r101, 0, r110.length, (this.input_ts * 1000000) / ((long) this.mSampleRate), 0);     // Catch: Exception -> L15
    L9:
        int r111 = this.mAACDecoder.dequeueOutputBuffer(this.mBufferInfo, 0);     // Catch: Exception -> L15
        MediaCodec.BufferInfo r103 = this.mBufferInfo;     // Catch: Exception -> L15
        int r104 = r103.size;     // Catch: Exception -> L15
        if (r104 <= 0) goto L14;
        if (r111 < 0) goto L14;
        this.output_ts = (r103.presentationTimeUs * ((long) this.mSampleRate)) / 1000000;     // Catch: Exception -> L15
        ByteBuffer r105 = this.mAACDecoder.getOutputBuffer(r111);     // Catch: Exception -> L15
        byte[] r106 = new byte[r104];     // Catch: Exception -> L15
        this.mDecodedData = r106;     // Catch: Exception -> L15
        MediaCodec.BufferInfo r107 = this.mBufferInfo;     // Catch: Exception -> L15
        r105.get(r106, r107.offset, r107.size);     // Catch: Exception -> L15
        r105.clear();     // Catch: Exception -> L15
        this.mOutputFormat = this.mAACDecoder.getOutputFormat(r111);     // Catch: Exception -> L15
        this.mAACDecoder.releaseOutputBuffer(r111, false);     // Catch: Exception -> L15
    L14:
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "AAC Decoder Decode failed");
        return false;
    }

    public void setADTSValue(int r100) {
        this.mHasADTS = r100;
    }

    public void setChannelsValue(int r100) {
        this.mChannels = r100;
    }

    public void setInputTs(long r100) {
        this.input_ts = r100;
    }

    public void setProfileValue(String r100) {
        if (r100.equals("he_aac") == false) goto L6;
        this.mProfile = 5;
        return;
    L6:
        if (r100.equals("he_aac_v2") == false) goto L8;
        this.mProfile = 29;
        return;
    L8:
        this.mProfile = 2;
    }

    public void setSampeRateValue(int r100) {
        this.mSampleRate = r100;
    }
}
