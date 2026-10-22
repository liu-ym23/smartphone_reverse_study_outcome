package com.facebook.fresco.ui.common;

/* JADX INFO: loaded from: classes23.dex */
public class DimensionsInfo {
    private final int mDecodedImageHeight;
    private final int mDecodedImageWidth;
    private final int mEncodedImageHeight;
    private final int mEncodedImageWidth;
    private final String mScaleType;
    private final int mViewportHeight;
    private final int mViewportWidth;

    public String toString() {
        return "DimensionsInfo{mViewportWidth=" + this.mViewportWidth + ", mViewportHeight=" + this.mViewportHeight + ", mEncodedImageWidth=" + this.mEncodedImageWidth + ", mEncodedImageHeight=" + this.mEncodedImageHeight + ", mDecodedImageWidth=" + this.mDecodedImageWidth + ", mDecodedImageHeight=" + this.mDecodedImageHeight + ", mScaleType='" + this.mScaleType + "'}";
    }

    public int getDecodedImageHeight() {
        return this.mDecodedImageHeight;
    }

    public int getDecodedImageWidth() {
        return this.mDecodedImageWidth;
    }

    public int getEncodedImageHeight() {
        return this.mEncodedImageHeight;
    }

    public int getEncodedImageWidth() {
        return this.mEncodedImageWidth;
    }

    public String getScaleType() {
        return this.mScaleType;
    }

    public int getViewportHeight() {
        return this.mViewportHeight;
    }

    public int getViewportWidth() {
        return this.mViewportWidth;
    }

    public DimensionsInfo(int r100, int r101, int r102, int r103, int r104, int r105, String r106) {
        this.mViewportWidth = r100;
        this.mViewportHeight = r101;
        this.mEncodedImageWidth = r102;
        this.mEncodedImageHeight = r103;
        this.mDecodedImageWidth = r104;
        this.mDecodedImageHeight = r105;
        this.mScaleType = r106;
    }
}
