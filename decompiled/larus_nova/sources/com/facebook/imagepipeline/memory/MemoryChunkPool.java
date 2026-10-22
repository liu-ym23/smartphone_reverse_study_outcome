package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {
    private final int[] mBucketSizes;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public abstract MemoryChunk alloc(int r100);

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int r100) {
        return r100;
    }

    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ MemoryChunk alloc(int r100) {
        return alloc(r100);
    }

    /* JADX INFO: renamed from: free, reason: avoid collision after fix types in other method */
    public void free2(MemoryChunk r100) {
        Preconditions.checkNotNull(r100);
        r100.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int r100) {
        if (r100 <= 0) goto L11;
        int[] r101 = this.mBucketSizes;
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        int r104 = r101[r103];
        if (r104 >= r100) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return r104;
    L9:
        return r100;
    L11:
        throw new BasePool.InvalidSizeException(Integer.valueOf(r100));
    }

    /* JADX INFO: renamed from: getBucketedSizeForValue, reason: avoid collision after fix types in other method */
    public int getBucketedSizeForValue2(MemoryChunk r100) {
        Preconditions.checkNotNull(r100);
        return r100.getSize();
    }

    /* JADX INFO: renamed from: isReusable, reason: avoid collision after fix types in other method */
    public boolean isReusable2(MemoryChunk r100) {
        Preconditions.checkNotNull(r100);
        return !r100.isClosed();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ void free(MemoryChunk r100) {
        free2(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ int getBucketedSizeForValue(MemoryChunk r100) {
        return getBucketedSizeForValue2(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ boolean isReusable(MemoryChunk r100) {
        return isReusable2(r100);
    }

    public MemoryChunkPool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
        super(r100, r101, r102);
        SparseIntArray r103 = r101.bucketSizes;
        this.mBucketSizes = new int[r103.size()];
        int r104 = 0;
    L3:
        int[] r105 = this.mBucketSizes;
        if (r104 >= r105.length) goto L6;
        r105[r104] = r103.keyAt(r104);
        r104 = r104 + 1;
        goto L3
    L6:
        initialize();
    }
}
