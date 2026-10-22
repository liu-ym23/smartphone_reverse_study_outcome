package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class KeepLastFrameCache implements BitmapFrameCache {
    private static final int FRAME_NUMBER_UNSET = -1;

    @Nullable
    private BitmapFrameCache.FrameCacheListener mFrameCacheListener;

    @Nullable
    private CloseableReference<Bitmap> mLastBitmapReference;
    private int mLastFrameNumber;

    private synchronized void closeAndResetLastBitmapReference() {
        monitor-enter(this);
        BitmapFrameCache.FrameCacheListener r100 = this.mFrameCacheListener;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        int r101 = this.mLastFrameNumber;     // Catch: Throwable -> L11
        if (r101 == (-1)) goto L8;
        r100.onFrameEvicted(this, r101);     // Catch: Throwable -> L11
    L8:
        CloseableReference.closeSafely(this.mLastBitmapReference);     // Catch: Throwable -> L11
        this.mLastBitmapReference = null;     // Catch: Throwable -> L11
        this.mLastFrameNumber = -1;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        monitor-enter(this);
        CloseableReference<Bitmap> r100 = this.mLastBitmapReference;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        int r101 = 0;
    L7:
        monitor-exit(this);
        return r101;
    L6:
        r101 = BitmapUtil.getSizeInBytes(r100.get());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104) {
    }

    public KeepLastFrameCache() {
        this.mLastFrameNumber = -1;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int r100) {
        monitor-enter(this);
        CloseableReference<Bitmap> r101 = CloseableReference.cloneOrNull(this.mLastBitmapReference);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener r100) {
        this.mFrameCacheListener = r100;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear(ImageFormat r100, int r101, boolean r102) {
        monitor-enter(this);
        closeAndResetLastBitmapReference();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int r100, ImageFormat r101, boolean r102) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.mLastFrameNumber) goto L8;
        if (CloseableReference.isValid(this.mLastBitmapReference) == false) goto L8;
        boolean r103 = true;
    L9:
        monitor-exit(this);
        return r103;
    L8:
        r103 = false;
        goto L9
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int r100, ImageFormat r101, boolean r102) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mLastFrameNumber != r100) goto L8;
        CloseableReference<Bitmap> r103 = CloseableReference.cloneOrNull(this.mLastBitmapReference);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L8:
        monitor-exit(this);
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int r100, int r101, int r102, ImageFormat r103, boolean r104) {
        monitor-enter(this);
        CloseableReference<Bitmap> r105 = CloseableReference.cloneOrNull(this.mLastBitmapReference);     // Catch: Throwable -> L7
        closeAndResetLastBitmapReference();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L10:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        closeAndResetLastBitmapReference();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104) {
        monitor-enter(this);
        if (r101 != null) goto L24;
    L10:
        CloseableReference.closeSafely(this.mLastBitmapReference);     // Catch: Throwable -> L21
        BitmapFrameCache.FrameCacheListener r105 = this.mFrameCacheListener;     // Catch: Throwable -> L21
        if (r105 == null) goto L15;
        int r106 = this.mLastFrameNumber;     // Catch: Throwable -> L21
        if (r106 == (-1)) goto L15;
        r105.onFrameEvicted(this, r106);     // Catch: Throwable -> L21
    L15:
        this.mLastBitmapReference = CloseableReference.cloneOrNull(r101);     // Catch: Throwable -> L21
        BitmapFrameCache.FrameCacheListener r107 = this.mFrameCacheListener;     // Catch: Throwable -> L21
        if (r107 == null) goto L18;
        r107.onFrameCached(this, r100);     // Catch: Throwable -> L21
    L18:
        this.mLastFrameNumber = r100;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        if (this.mLastBitmapReference == null) goto L10;
        if (r101.get().equals(this.mLastBitmapReference.get()) == false) goto L10;
        monitor-exit(this);
    }
}
