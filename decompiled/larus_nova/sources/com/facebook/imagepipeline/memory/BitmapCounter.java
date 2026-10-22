package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapCounter {
    private int mCount;
    private final int mMaxCount;
    private final int mMaxSize;
    private long mSize;
    private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    public synchronized int getCount() {
        monitor-enter(this);
        int r100 = this.mCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getMaxCount() {
        monitor-enter(this);
        int r100 = this.mMaxCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getMaxSize() {
        monitor-enter(this);
        int r100 = this.mMaxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getSize() {
        monitor-enter(this);
        long r100 = this.mSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        return this.mUnpooledBitmapsReleaser;
    }

    public synchronized void decrease(Bitmap r110) {
        monitor-enter(this);
        int r111 = BitmapUtil.getSizeInBytes(r110);     // Catch: Throwable -> L14
        if (this.mCount <= 0) goto L6;
        boolean r100 = true;
    L7:
        Preconditions.checkArgument(r100, "No bitmaps registered.");     // Catch: Throwable -> L14
        long r101 = r111;
        if (r101 > this.mSize) goto L10;
        boolean r102 = true;
    L11:
        Preconditions.checkArgument(r102, "Bitmap size bigger than the total registered size: %d, %d", new Object[]{Integer.valueOf(r111), Long.valueOf(this.mSize)});     // Catch: Throwable -> L14
        this.mSize -= r101;     // Catch: Throwable -> L14
        this.mCount--;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r102 = false;
        goto L11
    L6:
        r100 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized boolean increase(Bitmap r110) {
        monitor-enter(this);
        int r111 = BitmapUtil.getSizeInBytes(r110);     // Catch: Throwable -> L14
        int r100 = this.mCount;     // Catch: Throwable -> L14
        if (r100 >= this.mMaxCount) goto L11;
        long r101 = this.mSize;     // Catch: Throwable -> L14
        long r102 = r111;
        if ((r101 + r102) > this.mMaxSize) goto L11;
        this.mCount = r100 + 1;     // Catch: Throwable -> L14
        this.mSize = r101 + r102;     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L11:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public BitmapCounter(int r100, int r101) {
        boolean r102 = true;
        if (r100 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r101 > 0) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102);
        this.mMaxCount = r100;
        this.mMaxSize = r101;
        this.mUnpooledBitmapsReleaser = new AnonymousClass1(this);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
