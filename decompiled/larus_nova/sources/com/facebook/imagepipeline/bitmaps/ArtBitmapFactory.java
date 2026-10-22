package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes3.dex */
public class ArtBitmapFactory extends PlatformBitmapFactory {
    private final BitmapPool mBitmapPool;

    public BitmapPool getBitmapPool() {
        return this.mBitmapPool;
    }

    public ArtBitmapFactory(BitmapPool r100) {
        this.mBitmapPool = r100;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int r100, int r101, Bitmap.Config r102) {
        int r103 = BitmapUtil.getSizeInByteForBitmap(r100, r101, r102);
        Bitmap r104 = this.mBitmapPool.get(r103);
        if (r104.getAllocationByteCount() < ((r100 * r101) * BitmapUtil.getPixelSizeForBitmapConfig(r102))) goto L5;
        boolean r105 = true;
    L6:
        Preconditions.checkArgument(r105);
        r104.reconfigure(r100, r101, r102);
        return CloseableReference.of(r104, this.mBitmapPool);
    L5:
        r105 = false;
        goto L6
    }
}
