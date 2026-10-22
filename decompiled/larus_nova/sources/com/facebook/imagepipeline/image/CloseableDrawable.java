package com.facebook.imagepipeline.image;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes23.dex */
public class CloseableDrawable extends CloseableImage {
    private Drawable mDrawable;

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDrawable = null;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getImageCount() {
        return 1;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        Drawable r100 = this.mDrawable;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Math.max(0, r100.getIntrinsicHeight());
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        Drawable r100 = this.mDrawable;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Math.max(0, r100.getIntrinsicWidth());
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isClosed() {
        if (this.mDrawable != null) goto L5;
        return true;
    L5:
        return false;
    }

    public Drawable getUnderlyingDrawable() {
        return this.mDrawable;
    }

    public CloseableDrawable(Drawable r100) {
        this.mDrawable = r100;
    }
}
