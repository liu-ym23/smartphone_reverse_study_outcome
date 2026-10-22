package com.facebook.imagepipeline.cache;

import androidx.collection.SieveCacheKt;
import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    private static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;

    public DefaultEncodedMemoryCacheParamsSupplier() {
    }

    private int getMaxCacheSize() {
        int r100 = (int) Math.min(Runtime.getRuntime().maxMemory(), SieveCacheKt.NodeLinkMask);
        if (r100 >= 16777216) goto L7;
        return 1048576;
    L7:
        if (r100 >= 33554432) goto L10;
        return 2097152;
    L10:
        return 4194304;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        int r100 = getMaxCacheSize();
        return new MemoryCacheParams(r100, Integer.MAX_VALUE, r100, Integer.MAX_VALUE, r100 / 8);
    }

    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ MemoryCacheParams get() {
        return get();
    }
}
