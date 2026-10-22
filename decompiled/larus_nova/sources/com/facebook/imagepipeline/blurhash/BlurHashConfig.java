package com.facebook.imagepipeline.blurhash;

/* JADX INFO: loaded from: classes23.dex */
public final class BlurHashConfig {
    private static final int MAX_BLUR_HASH_HEIGHT = 100;
    private static final int MAX_BLUR_HASH_WIDTH = 100;
    final int mHeight;
    final float mPunch;
    final boolean mUseCache;
    final int mWidth;
    final int targetHeight;
    final int targetWidth;

    public int getHeight() {
        return this.mHeight;
    }

    public float getPunch() {
        return this.mPunch;
    }

    public int getTargetHeight() {
        return this.targetHeight;
    }

    public int getTargetWidth() {
        return this.targetWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isUseCache() {
        return this.mUseCache;
    }

    public BlurHashConfig(int r100, int r101) {
        this(r100, r101, 1.0f, true);
    }

    public BlurHashConfig(int r100, int r101, float r110, boolean r111) {
        this(r100, r101, r110, r111, 0, 0);
    }

    public BlurHashConfig(int r100, int r101, float r102, boolean r103, int r104, int r105) {
        this.mWidth = Math.min(r100, 100);
        this.mHeight = Math.min(r101, 100);
        this.mPunch = r102;
        this.mUseCache = r103;
        this.targetWidth = r104;
        this.targetHeight = r105;
    }
}
