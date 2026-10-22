package com.facebook.imagepipeline.blurhash2;

/* JADX INFO: loaded from: classes23.dex */
public final class PreviewHashConfig {
    public static final int DEFAULT_BLUR_RADIUS = 1;
    public static final int DEFAULT_HEIGHT = 0;
    public static final int DEFAULT_ITERATIONS = 1;
    public static final int DEFAULT_WIDTH = 0;
    public static final int JPEG_PREVIEW = 0;
    public static final int VVIC_PREVIEW = 1;
    final int mBlurRadius;
    final int mHeight;
    final boolean mIsOptVvic;
    final int mIterations;
    final int mWidth;

    public int getBlurRadius() {
        return this.mBlurRadius;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getIterations() {
        return this.mIterations;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOptVvic() {
        return this.mIsOptVvic;
    }

    public PreviewHashConfig(int r100, int r101) {
        this(r100, r101, 0, 0);
    }

    public PreviewHashConfig(int r100, int r101, int r110) {
        if (r100 != 1) goto L5;
        boolean r102 = true;
    L6:
        this(r102, r101, r110, 0, 0);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public PreviewHashConfig(boolean r100, int r101, int r102) {
        this(r100, r101, r102, 0, 0);
    }

    public PreviewHashConfig(int r100, int r101, int r102, int r110) {
        this(false, r100, r101, r102, r110);
    }

    public PreviewHashConfig(int r100, int r101, int r102, int r103, int r104) {
        boolean r105 = true;
        if (r100 == 1) goto L6;
        r105 = false;
    L6:
        this.mIsOptVvic = r105;
        this.mIterations = r101;
        this.mBlurRadius = r102;
        this.mWidth = r103;
        this.mHeight = r104;
    }

    public PreviewHashConfig(boolean r100, int r101, int r102, int r103, int r104) {
        this.mIsOptVvic = r100;
        this.mIterations = r101;
        this.mBlurRadius = r102;
        this.mWidth = r103;
        this.mHeight = r104;
    }
}
