package com.ss.ttvideoengine.strategrycenter;

/* JADX INFO: loaded from: classes35.dex */
public class Representation {
    private int mBitrate;
    private String mCodec;
    private String mFileID;
    private int mFileSize;
    private int mHeight;
    private String mMediaType;
    private String mQuality;
    private int mWidth;

    public Representation() {
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public String getFileID() {
        return this.mFileID;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setBitrate(int r100) {
        this.mBitrate = r100;
    }

    public void setFileID(String r100) {
        this.mFileID = r100;
    }

    public void setFileSize(int r100) {
        this.mFileSize = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setMediaType(String r100) {
        this.mMediaType = r100;
    }

    public void setQuality(String r100) {
        this.mQuality = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }
}
