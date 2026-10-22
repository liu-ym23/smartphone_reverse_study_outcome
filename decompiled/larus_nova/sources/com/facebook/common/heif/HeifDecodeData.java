package com.facebook.common.heif;

/* JADX INFO: loaded from: classes22.dex */
public class HeifDecodeData {
    private boolean mHasAlpha;
    private int mHdrType;
    private int mHeifDecError;
    private int mHeight;
    private boolean mSizeAbnormal;
    private int mWidth;

    public HeifDecodeData() {
    }

    public int getHdrType() {
        return this.mHdrType;
    }

    public int getHeifDecError() {
        return this.mHeifDecError;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasAlpha() {
        return this.mHasAlpha;
    }

    public boolean isSizeAbnormal() {
        return this.mSizeAbnormal;
    }

    public void setHasAlpha(boolean r100) {
        this.mHasAlpha = r100;
    }

    public void setHdrType(int r100) {
        this.mHdrType = r100;
    }

    public void setHeifDecError(int r100) {
        this.mHeifDecError = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setSizeAbnormal(boolean r100) {
        this.mSizeAbnormal = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }
}
