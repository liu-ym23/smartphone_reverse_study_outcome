package com.bytedance.vcloud.abrmodule;

/* JADX INFO: loaded from: classes22.dex */
public class ABRAudioStream implements IAudioStream {
    public int mBandWidth;
    private String mCodec;
    private int mRealBitrate;
    private int mSampleRate;
    private int mSegmentDuration;
    private String mStreamId;

    public ABRAudioStream() {
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

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public int getRealBitrate() {
        return this.mRealBitrate;
    }

    @Override // com.bytedance.vcloud.abrmodule.IAudioStream
    public int getSampleRate() {
        return this.mSampleRate;
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public int getSegmentDuration() {
        return this.mSegmentDuration;
    }

    @Override // com.bytedance.vcloud.abrmodule.IStream
    public String getStreamId() {
        return this.mStreamId;
    }

    public void setBandWidth(int r100) {
        this.mBandWidth = r100;
    }

    public void setCodec(String r100) {
        this.mCodec = r100;
    }

    public void setRealBitrate(int r100) {
        this.mRealBitrate = r100;
    }

    public void setSampleRate(int r100) {
        this.mSampleRate = r100;
    }

    public void setSegmentDuration(int r100) {
        this.mSegmentDuration = r100;
    }

    public void setStreamId(String r100) {
        this.mStreamId = r100;
    }
}
