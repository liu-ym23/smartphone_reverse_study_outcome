package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class NoOpCache implements BitmapFrameCache {
    public NoOpCache() {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void clear(ImageFormat r100, int r101, boolean r102) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean contains(int r100, ImageFormat r101, boolean r102) {
        return false;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int r100, int r101, int r102, ImageFormat r103, boolean r104) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getCachedFrame(int r100, ImageFormat r101, boolean r102) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getFallbackFrame(int r100) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFrameRendered(int r100, CloseableReference<Bitmap> r101, int r102, ImageFormat r103, boolean r104) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener r100) {
    }
}
