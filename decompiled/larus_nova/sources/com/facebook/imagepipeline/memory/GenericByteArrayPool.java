package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes3.dex */
public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {
    private final int[] mBucketSizes;

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int r100) {
        return r100;
    }

    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ byte[] alloc(int r100) {
        return alloc2(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ void free(byte[] r100) {
        free2(r100);
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

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ int getBucketedSizeForValue(byte[] r100) {
        return getBucketedSizeForValue2(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: alloc, reason: avoid collision after fix types in other method */
    public byte[] alloc2(int r100) {
        return new byte[r100];
    }

    /* JADX INFO: renamed from: free, reason: avoid collision after fix types in other method */
    public void free2(byte[] r100) {
        Preconditions.checkNotNull(r100);
    }

    /* JADX INFO: renamed from: getBucketedSizeForValue, reason: avoid collision after fix types in other method */
    public int getBucketedSizeForValue2(byte[] r100) {
        Preconditions.checkNotNull(r100);
        return r100.length;
    }

    public GenericByteArrayPool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
        super(r100, r101, r102);
        SparseIntArray r103 = r101.bucketSizes;
        this.mBucketSizes = new int[r103.size()];
        int r104 = 0;
    L4:
        if (r104 >= r103.size()) goto L6;
        this.mBucketSizes[r104] = r103.keyAt(r104);
        r104 = r104 + 1;
        goto L4
    L6:
        initialize();
    }
}
