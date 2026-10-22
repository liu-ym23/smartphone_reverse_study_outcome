package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes23.dex */
public class SharedByteArray implements MemoryTrimmable {
    final OOMSoftReference<byte[]> mByteArraySoftRef;
    final int mMaxByteArraySize;
    final int mMinByteArraySize;
    private final ResourceReleaser<byte[]> mResourceReleaser;
    final Semaphore mSemaphore;

    private synchronized byte[] allocateByteArray(int r100) {
        monitor-enter(this);
        this.mByteArraySoftRef.clear();     // Catch: Throwable -> L6
        byte[] r101 = new byte[r100];     // Catch: Throwable -> L6
        this.mByteArraySoftRef.set(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    private byte[] getByteArray(int r100) {
        int r101 = getBucketedSize(r100);
        byte[] r102 = this.mByteArraySoftRef.get();
        if (r102 == null) goto L7;
        if (r102.length < r101) goto L7;
        return r102;
    L7:
        return allocateByteArray(r101);
    }

    public CloseableReference<byte[]> get(int r100) {
        boolean r101 = true;
        if (r100 <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "Size must be greater than zero");
        if (r100 <= this.mMaxByteArraySize) goto L10;
        r101 = false;
    L10:
        Preconditions.checkArgument(r101, "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
        return CloseableReference.of(getByteArray(r100), this.mResourceReleaser);
    L13:
        th = move-exception;
        this.mSemaphore.release();
        throw Throwables.propagate(th);
    L5:
        r102 = false;
        goto L6
    }

    public int getBucketedSize(int r100) {
        return Integer.highestOneBit(Math.max(r100, this.mMinByteArraySize) - 1) * 2;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType r100) {
        if (this.mSemaphore.tryAcquire() == true) goto L11;
        return;
    L11:
        this.mByteArraySoftRef.clear();     // Catch: Throwable -> L8
        this.mSemaphore.release();
        return;
    L8:
        th = move-exception;
        this.mSemaphore.release();
        throw th;
    }

    public SharedByteArray(MemoryTrimmableRegistry r100, PoolParams r101) {
        Preconditions.checkNotNull(r100);
        boolean r102 = false;
        if (r101.minBucketSize <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r101.maxBucketSize < r101.minBucketSize) goto L9;
        r102 = true;
    L9:
        Preconditions.checkArgument(r102);
        this.mMaxByteArraySize = r101.maxBucketSize;
        this.mMinByteArraySize = r101.minBucketSize;
        this.mByteArraySoftRef = new OOMSoftReference();
        this.mSemaphore = new Semaphore(1);
        this.mResourceReleaser = new AnonymousClass1(this);
        r100.registerMemoryTrimmable(this);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
