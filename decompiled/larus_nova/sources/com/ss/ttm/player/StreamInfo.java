package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public class StreamInfo {
    private int mBitrate;
    private int mChannels;
    private String mCodecName;
    private long mDuration;
    private int mFrameRate;
    private int mHeight;
    private int mRotation;
    private int mSampleRate;
    private int mStreamIndex;
    private int mStreamType;
    private int mWidth;

    public MediaPlayer.TrackInfo convertToTrackInfo() {
        MediaFormat r100 = new MediaFormat();
        r100.setInteger(MediaFormat.KEY_TRACK_ID, this.mStreamIndex);
        r100.setInteger(MediaFormat.KEY_FRAME_RATE, this.mFrameRate);
        r100.setInteger("bitrate", this.mBitrate);
        r100.setInteger("width", this.mWidth);
        r100.setInteger("height", this.mHeight);
        r100.setInteger(MediaFormat.KEY_SAMPLE_RATE, this.mSampleRate);
        r100.setInteger(MediaFormat.KEY_CHANNEL_COUNT, this.mChannels);
        r100.setLong("duration", this.mDuration);
        r100.setLong("rotation", this.mRotation);
        r100.setString(MediaFormat.KEY_CODEC_NAME, this.mCodecName);
        return new MediaPlayer.TrackInfo(this.mStreamType, r100);
    }

    public String toString() {
        return "StreamInfo{mStreamType=" + this.mStreamType + ", mStreamIndex=" + this.mStreamIndex + ", mCodecName='" + this.mCodecName + "', mFrameRate=" + this.mFrameRate + ", mBitrate=" + this.mBitrate + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mSampleRate=" + this.mSampleRate + ", mChannels=" + this.mChannels + ", mDuration=" + this.mDuration + ", mRotation=" + this.mRotation + '}';
    }

    public StreamInfo(int r100, int r101, String r102, int r103, int r104, int r105, int r106, int r107, int r108, long r110, int r111) {
        this.mStreamType = r100;
        this.mStreamIndex = r101;
        this.mCodecName = r102;
        this.mFrameRate = r103;
        this.mBitrate = r104;
        this.mWidth = r105;
        this.mHeight = r106;
        this.mSampleRate = r107;
        this.mChannels = r108;
        this.mDuration = r110;
        this.mRotation = r111;
    }
}
