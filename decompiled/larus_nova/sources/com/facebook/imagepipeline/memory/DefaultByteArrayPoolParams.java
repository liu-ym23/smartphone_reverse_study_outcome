package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultByteArrayPoolParams {
    private static final int DEFAULT_BUCKET_SIZE = 5;
    private static final int DEFAULT_IO_BUFFER_SIZE = 16384;
    private static final int MAX_SIZE_HARD_CAP = 1048576;
    private static final int MAX_SIZE_SOFT_CAP = 81920;

    public DefaultByteArrayPoolParams() {
    }

    public static PoolParams get() {
        SparseIntArray r100 = new SparseIntArray();
        r100.put(16384, 5);
        return new PoolParams(MAX_SIZE_SOFT_CAP, 1048576, r100);
    }
}
