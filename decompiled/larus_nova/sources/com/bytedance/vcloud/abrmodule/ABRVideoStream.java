package com.bytedance.vcloud.abrmodule;

/* JADX INFO: loaded from: classes22.dex */
public class ABRVideoStream implements IVideoStream {
    public int mBandWidth;
    private String mCodec;
    private int mFrameRate;
    private int mHeight;
    private int mRealBitrate;
    private int mResolution;
    private int mSegmentDuration;
    private String mStreamId;
    private int mSupportSR;
    private int mWidth;

    @Override // com.bytedance.vcloud.abrmodule.IVideoStream
    public float getFrameRate() {
        return this.mFrameRate;
    }

    public ABRVideoStream() {
        this.mStreamId = "";
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public int getBandwidth() {
        return this.mBandWidth;
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public String getCodec() {
        return this.mCodec;
    }

    @Override // com.bytedance.vcloud.abrmodule.IVideoStream
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public int getRealBitrate() {
        return this.mRealBitrate;
    }

    @Override // com.bytedance.vcloud.abrmodule.IVideoStream
    public int getResolution() {
        return this.mResolution;
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public int getSegmentDuration() {
        return this.mSegmentDuration;
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public String getStreamId() {
        return this.mStreamId;
    }

    @Override // com.bytedance.vcloud.abrmodule.IVideoStream
    public int getSupportSR() {
        return this.mSupportSR;
    }

    @Override // com.bytedance.vcloud.abrmodule.IVideoStream
    public int getWidth() {
        return this.mWidth;
    }

    public void setBandWidth(int r100) {
        this.mBandWidth = r100;
    }

    public void setCodec(String r100) {
        this.mCodec = r100;
    }

    public void setFrameRate(int r100) {
        this.mFrameRate = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setRealBitrate(int r100) {
        this.mRealBitrate = r100;
    }

    public void setResolution(int r100) {
        this.mResolution = r100;
    }

    public void setSegmentDuration(int r100) {
        this.mSegmentDuration = r100;
    }

    public void setStreamId(String r100) {
        this.mStreamId = r100;
    }

    public void setSupportSR(int r100) {
        this.mSupportSR = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }
}
