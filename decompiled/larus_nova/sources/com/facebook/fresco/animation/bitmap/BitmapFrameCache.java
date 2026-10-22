package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface BitmapFrameCache {

    public interface FrameCacheListener {
        void onFrameCached(BitmapFrameCache r100, int r101);

        void onFrameEvicted(BitmapFrameCache r100, int r101);
    }

    void clear(ImageFormat r100, int r101, boolean r102);

    boolean contains(int r100, ImageFormat r101, boolean r102);

    @Nullable
    CloseableReference<Bitmap> getBitmapToReuseForFrame(int r100, int r101, int r102, ImageFormat r103, boolean r104);

    @Nullable
    CloseableReference<Bitmap> getCachedFrame(int r100, ImageFormat r101, boolean r102);

    @Nullable
    CloseableReference<Bitmap> getFallbackFrame(int r100);

    int getSizeInBytes();

    void onFramePrepared(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104);

    void onFrameRendered(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104);

    void setFrameCacheListener(FrameCacheListener r100);
}
