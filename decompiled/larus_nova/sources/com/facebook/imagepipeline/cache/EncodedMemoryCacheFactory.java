package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class EncodedMemoryCacheFactory {
    public EncodedMemoryCacheFactory() {
    }

    public static InstrumentedMemoryCache<CacheKey, PooledByteBuffer> get(CountingMemoryCache<CacheKey, PooledByteBuffer> r100, final ImageCacheStatsTracker r101) {
        r101.registerEncodedMemoryCache(r100);
        return new InstrumentedMemoryCache(r100, new AnonymousClass1(r101));
    }
}
