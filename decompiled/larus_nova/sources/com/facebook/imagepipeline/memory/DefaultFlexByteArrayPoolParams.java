package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultFlexByteArrayPoolParams {
    public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
    public static final int DEFAULT_MAX_NUM_THREADS = 0;
    private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;

    public static PoolParams get() {
        int r100 = DEFAULT_MAX_NUM_THREADS;
        return new PoolParams(4194304, r100 * 4194304, generateBuckets(131072, 4194304, r100), 131072, 4194304, r100);
    }

    static {
        DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    }

    private DefaultFlexByteArrayPoolParams() {
    }

    public static SparseIntArray generateBuckets(int r100, int r101, int r102) {
        SparseIntArray r103 = new SparseIntArray();
    L3:
        if (r100 > r101) goto L5;
        r103.put(r100, r102);
        r100 = r100 * 2;
        goto L3
    L5:
        return r103;
    }
}
