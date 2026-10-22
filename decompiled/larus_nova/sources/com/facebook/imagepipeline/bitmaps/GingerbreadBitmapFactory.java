package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes23.dex */
public class GingerbreadBitmapFactory extends PlatformBitmapFactory {
    public GingerbreadBitmapFactory() {
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int r100, int r101, Bitmap.Config r102) {
        return CloseableReference.of(Bitmap.createBitmap(r100, r101, r102), SimpleBitmapReleaser.getInstance());
    }
}
