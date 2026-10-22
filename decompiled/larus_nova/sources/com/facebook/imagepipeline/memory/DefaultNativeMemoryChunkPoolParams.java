package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import androidx.collection.SieveCacheKt;
import com.baidu.platform.comapi.bmsdk.BmLocated;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultNativeMemoryChunkPoolParams {
    private static final int LARGE_BUCKET_LENGTH = 2;
    private static final int SMALL_BUCKET_LENGTH = 5;

    public DefaultNativeMemoryChunkPoolParams() {
    }

    public static PoolParams get() {
        SparseIntArray r100 = new SparseIntArray();
        r100.put(1024, 5);
        r100.put(2048, 5);
        r100.put(4096, 5);
        r100.put(8192, 5);
        r100.put(16384, 5);
        r100.put(32768, 5);
        r100.put(65536, 5);
        r100.put(131072, 5);
        r100.put(262144, 2);
        r100.put(524288, 2);
        r100.put(1048576, 2);
        return new PoolParams(getMaxSizeSoftCap(), getMaxSizeHardCap(), r100);
    }

    private static int getMaxSizeHardCap() {
        int r100 = (int) Math.min(Runtime.getRuntime().maxMemory(), SieveCacheKt.NodeLinkMask);
        if (r100 >= 16777216) goto L7;
        return r100 / 2;
    L7:
        return (r100 / 4) * 3;
    }

    private static int getMaxSizeSoftCap() {
        int r100 = (int) Math.min(Runtime.getRuntime().maxMemory(), SieveCacheKt.NodeLinkMask);
        if (r100 >= 16777216) goto L7;
        return 3145728;
    L7:
        if (r100 >= 33554432) goto L10;
        return BmLocated.ALIGN_LEFT_BOTTOM;
    L10:
        return 12582912;
    }
}
