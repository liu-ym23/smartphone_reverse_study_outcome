package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    private static final int MAX_CACHE_ENTRIES = 256;
    private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
    private final ActivityManager mActivityManager;

    private int getMaxCacheSize() {
        int r100 = Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r100 >= 33554432) goto L7;
        return 4194304;
    L7:
        if (r100 >= 67108864) goto L11;
        return BmLocated.ALIGN_LEFT_BOTTOM;
    L11:
        return r100 / 4;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        return new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ MemoryCacheParams get() {
        return get();
    }

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager r100) {
        this.mActivityManager = r100;
    }
}
