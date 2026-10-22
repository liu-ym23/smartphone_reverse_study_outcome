package com.facebook.imagepipeline.request;

import com.facebook.imagepipeline.image.ColorCalculator;

/* JADX INFO: loaded from: classes23.dex */
public class CalculateColorConfig {
    private final int mCalculateHeight;
    private final ColorCalculator.PhotoBgColorStyle mPhotoBgColorStyle;
    private final int mResizeBitmapTo;

    public int getCalculateHeight() {
        return this.mCalculateHeight;
    }

    public ColorCalculator.PhotoBgColorStyle getPhotoBgColorStyle() {
        return this.mPhotoBgColorStyle;
    }

    public int getResizeBitmapTo() {
        return this.mResizeBitmapTo;
    }

    public CalculateColorConfig(int r100, int r101, ColorCalculator.PhotoBgColorStyle r102) {
        this.mCalculateHeight = r100;
        this.mResizeBitmapTo = r101;
        this.mPhotoBgColorStyle = r102;
    }
}
