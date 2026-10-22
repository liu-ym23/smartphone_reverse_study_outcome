package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class FlexByteArrayPool {
    final SoftRefByteArrayPool mDelegatePool;
    private final ResourceReleaser<byte[]> mResourceReleaser;

    public static class SoftRefByteArrayPool extends GenericByteArrayPool {
        @Override // com.facebook.imagepipeline.memory.BasePool
        public Bucket<byte[]> newBucket(int r100) {
            return new OOMSoftReferenceBucket(getSizeInBytes(r100), this.mPoolParams.maxNumThreads, 0);
        }

        public SoftRefByteArrayPool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
            super(r100, r101, r102);
        }
    }

    public int getMinBufferSize() {
        return this.mDelegatePool.getMinBufferSize();
    }

    public Map<String, Integer> getStats() {
        return this.mDelegatePool.getStats();
    }

    public CloseableReference<byte[]> get(int r100) {
        return CloseableReference.of(this.mDelegatePool.get(r100), this.mResourceReleaser);
    }

    public void release(byte[] r100) {
        this.mDelegatePool.release(r100);
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry r100, PoolParams r101) {
        if (r101.maxNumThreads <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        this.mDelegatePool = new SoftRefByteArrayPool(r100, r101, NoOpPoolStatsTracker.getInstance());
        this.mResourceReleaser = new AnonymousClass1(this);
        return;
    L5:
        r102 = false;
        goto L6
    }
}
