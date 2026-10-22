package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultBitmapPoolParams {
    private static final SparseIntArray DEFAULT_BUCKETS = null;
    private static final int MAX_SIZE_SOFT_CAP = 0;

    static {
        DEFAULT_BUCKETS = new SparseIntArray(0);
    }

    public static PoolParams get() {
        return new PoolParams(0, getMaxSizeHardCap(), DEFAULT_BUCKETS);
    }

    private static int getMaxSizeHardCap() {
        int r100 = (int) Math.min(Runtime.getRuntime().maxMemory(), SieveCacheKt.NodeLinkMask);
        if (r100 <= 16777216) goto L7;
        return (r100 / 4) * 3;
    L7:
        return r100 / 2;
    }

    private DefaultBitmapPoolParams() {
    }
}
