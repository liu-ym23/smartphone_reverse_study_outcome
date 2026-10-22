package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimType;

/* JADX INFO: loaded from: classes23.dex */
public class LruBitmapPool implements BitmapPool {
    private int mCurrentSize;
    private int mMaxBitmapSize;
    private final int mMaxPoolSize;
    private final PoolStatsTracker mPoolStatsTracker;
    protected final PoolBackend<Bitmap> mStrategy;

    private Bitmap alloc(int r100) {
        this.mPoolStatsTracker.onAlloc(r100);
        return Bitmap.createBitmap(1, r100, Bitmap.Config.ALPHA_8);
    }

    private synchronized void trimTo(int r100) {
        monitor-enter(this);
    L15:
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentSize <= r100) goto L10;
        Bitmap r101 = this.mStrategy.pop();     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        int r102 = this.mStrategy.getSize(r101);     // Catch: Throwable -> L12
        this.mCurrentSize -= r102;     // Catch: Throwable -> L12
        this.mPoolStatsTracker.onFree(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int r100) {
        monitor-enter(this);
        int r101 = this.mCurrentSize;     // Catch: Throwable -> L14
        int r102 = this.mMaxPoolSize;     // Catch: Throwable -> L14
        if (r101 <= r102) goto L6;
        trimTo(r102);     // Catch: Throwable -> L14
    L6:
        Bitmap r103 = this.mStrategy.get(r100);     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        int r104 = this.mStrategy.getSize(r103);     // Catch: Throwable -> L14
        this.mCurrentSize -= r104;     // Catch: Throwable -> L14
        this.mPoolStatsTracker.onValueReuse(r104);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return r103;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        return alloc(r100);
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void release(Bitmap r100) {
        monitor-enter(this);
        int r101 = this.mStrategy.getSize(r100);     // Catch: Throwable -> L8
        if (r101 > this.mMaxBitmapSize) goto L6;
        this.mPoolStatsTracker.onValueRelease(r101);     // Catch: Throwable -> L8
        this.mStrategy.put(r100);     // Catch: Throwable -> L8
        this.mCurrentSize += r101;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType r100) {
        trimTo((int) (((double) this.mMaxPoolSize) * (1.0d - r100.getSuggestedTrimRatio())));
    }

    @Override // com.facebook.common.memory.Pool
    public /* bridge */ /* synthetic */ Bitmap get(int r100) {
        return get(r100);
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public /* bridge */ /* synthetic */ void release(Object r100) {
        release((Bitmap) r100);
    }

    public LruBitmapPool(int r100, int r101, PoolStatsTracker r102) {
        this.mStrategy = new BitmapPoolBackend();
        this.mMaxPoolSize = r100;
        this.mMaxBitmapSize = r101;
        this.mPoolStatsTracker = r102;
    }
}
