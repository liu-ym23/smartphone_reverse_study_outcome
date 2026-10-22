package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.bytedance.realx.base.RXLogging;
import com.obric.sva.sdk.controller.RecordingsMgr;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes47.dex */
public class MediaCodecAACEncoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACEncoder";
    private MediaCodec mAACEncoder;
    private int mBitrate;
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannels;
    private byte[] mEncodedData;
    private int mFrameSize;
    private ByteBuffer[] mInputBuffers;
    private String mMimeType;
    private ByteBuffer[] mOutputBuffers;
    private int mProfile;
    private int mSampleRate;

    public void closeEncoder() {
        MediaCodec r100 = this.mAACEncoder;     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        r100.stop();     // Catch: Exception -> L7
        this.mAACEncoder.release();     // Catch: Exception -> L7
        this.mAACEncoder = null;     // Catch: Exception -> L7
        RXLogging.e(TAG, "close AAC encoder success");     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "close AAC encoder failed");
    }

    public boolean configAndStartEncoder() {
        MediaFormat r100 = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);     // Catch: Exception -> L5
        r100.setInteger("bitrate", this.mBitrate);     // Catch: Exception -> L5
        r100.setInteger("aac-profile", this.mProfile);     // Catch: Exception -> L5
        r100.setInteger("profile", this.mProfile);     // Catch: Exception -> L5
        r100.setInteger("max-input-size", (this.mChannels * this.mFrameSize) * 100);     // Catch: Exception -> L5
        this.mAACEncoder.configure(r100, null, null, 1);     // Catch: Exception -> L5
        this.mAACEncoder.start();     // Catch: Exception -> L5
        this.mBufferInfo = new MediaCodec.BufferInfo();     // Catch: Exception -> L5
        RXLogging.e(TAG, "config AAC encoder success");     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Config and Start Encoder Error");
        return false;
    }

    public boolean openEncoder() {
        this.mAACEncoder = MediaCodec.createEncoderByType(this.mMimeType);     // Catch: Exception -> L9
        RXLogging.e(TAG, "open AAC encoder success");     // Catch: Exception -> L9
        if (this.mAACEncoder == null) goto L8;
        return true;
    L8:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        this.mAACEncoder = null;
        RXLogging.e(TAG, "Open AAC encoder failed");
        return false;
    }

    public MediaCodecAACEncoder() {
        this.mMimeType = "audio/mp4a-latm";
        this.mSampleRate = 44100;
        this.mChannels = 1;
        this.mProfile = 2;
        this.mBitrate = RecordingsMgr.SAMPLE_SIZE_SENCOND;
        this.mFrameSize = 1024;
        this.mAACEncoder = null;
        RXLogging.e(TAG, "MediaCodecAAC Encoder Created");
    }

    public byte[] getEncodedData() {
        return this.mEncodedData;
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public boolean encodeProcess(byte[] r110) {
        MediaCodec r100 = this.mAACEncoder;     // Catch: Exception -> L18
        if (r100 != null) goto L6;
        return false;
    L6:
        this.mEncodedData = null;     // Catch: Exception -> L18
        int r101 = r100.dequeueInputBuffer(300);     // Catch: Exception -> L18
        if (r101 < 0) goto L9;
        ByteBuffer r102 = this.mAACEncoder.getInputBuffer(r101);     // Catch: Exception -> L18
        r102.clear();     // Catch: Exception -> L18
        r102.put(r110);     // Catch: Exception -> L18
        this.mAACEncoder.queueInputBuffer(r101, 0, r110.length, 0, 0);     // Catch: Exception -> L18
    L9:
        int r111 = this.mAACEncoder.dequeueOutputBuffer(this.mBufferInfo, 0);     // Catch: Exception -> L18
        MediaCodec.BufferInfo r103 = this.mBufferInfo;     // Catch: Exception -> L18
        int r104 = r103.size;     // Catch: Exception -> L18
        int r105 = r103.flags & 2;     // Catch: Exception -> L18
        if (r104 <= 0) goto L17;
        if (r111 < 0) goto L17;
        if (r105 != 2) goto L16;
        this.mAACEncoder.releaseOutputBuffer(r111, false);     // Catch: Exception -> L18
        return true;
    L16:
        ByteBuffer r106 = this.mAACEncoder.getOutputBuffer(r111);     // Catch: Exception -> L18
        byte[] r107 = new byte[r104];     // Catch: Exception -> L18
        this.mEncodedData = r107;     // Catch: Exception -> L18
        r106.get(r107, this.mBufferInfo.offset, r104);     // Catch: Exception -> L18
        r106.clear();     // Catch: Exception -> L18
        this.mAACEncoder.releaseOutputBuffer(r111, false);     // Catch: Exception -> L18
    L17:
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "AAC Encoder Encode failed");
        return false;
    }

    public void setBitRateValue(int r100) {
        this.mBitrate = r100;
    }

    public boolean setBitrate(int r100) {
        MediaCodec r101 = this.mAACEncoder;     // Catch: Exception -> L9
        if (r101 != null) goto L6;
        return false;
    L6:
        r101.stop();     // Catch: Exception -> L9
        MediaFormat r102 = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);     // Catch: Exception -> L9
        r102.setInteger("bitrate", r100);     // Catch: Exception -> L9
        r102.setInteger("aac-profile", this.mProfile);     // Catch: Exception -> L9
        this.mAACEncoder.configure(r102, null, null, 1);     // Catch: Exception -> L9
        this.mAACEncoder.start();     // Catch: Exception -> L9
        this.mBitrate = r100;
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Config and Start Encoder Error");
        return false;
    }

    public void setChannelsValue(int r100) {
        this.mChannels = r100;
    }

    public void setProfileValue(String r100) {
        if (r100.equals("he_aac") == false) goto L6;
        this.mProfile = 5;
        this.mFrameSize = 2048;
        return;
    L6:
        if (r100.equals("he_aac_v2") == false) goto L8;
        this.mProfile = 29;
        this.mFrameSize = 2048;
        return;
    L8:
        this.mProfile = 2;
        this.mFrameSize = 1024;
    }

    public void setSampeRateValue(int r100) {
        this.mSampleRate = r100;
    }
}
