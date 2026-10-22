package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class PoolParams {
    public static final int IGNORE_THREADS = -1;
    public String bitmapPoolType;
    public final SparseIntArray bucketSizes;
    public boolean fixBucketsReinitialization;
    public final int maxBucketSize;
    public final int maxNumThreads;
    public final int maxSizeHardCap;
    public final int maxSizeSoftCap;
    public final int minBucketSize;

    public PoolParams(int r100, @Nullable SparseIntArray r101) {
        this(r100, r100, r101, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int r100, int r101, @Nullable SparseIntArray r110) {
        this(r100, r101, r110, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int r100, int r101, @Nullable SparseIntArray r102, int r103, int r104, int r105) {
        boolean r106 = true;
        this.fixBucketsReinitialization = true;
        if (r100 < 0) goto L6;
        if (r101 < r100) goto L6;
    L7:
        Preconditions.checkState(r106);
        this.maxSizeSoftCap = r100;
        this.maxSizeHardCap = r101;
        this.bucketSizes = r102;
        this.minBucketSize = r103;
        this.maxBucketSize = r104;
        this.maxNumThreads = r105;
        return;
    L6:
        r106 = false;
        goto L7
    }
}
