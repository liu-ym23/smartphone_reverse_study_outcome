package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapCountingMemoryCacheFactory {
    public BitmapCountingMemoryCacheFactory() {
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> r100, MemoryTrimmableRegistry r101) {
        return get(r100, r101, new BitmapMemoryCacheTrimStrategy());
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> r100, MemoryTrimmableRegistry r101, CountingMemoryCache.CacheTrimStrategy r102) {
        CountingMemoryCache<CacheKey, CloseableImage> r103 = new CountingMemoryCache(new AnonymousClass1(), r102, r100);
        r101.registerMemoryTrimmable(r103);
        return r103;
    }
}
