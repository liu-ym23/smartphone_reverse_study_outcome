package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CloseableBitmap extends CloseableImage {
    public abstract Bitmap getUnderlyingBitmap();

    public CloseableBitmap() {
    }
}
