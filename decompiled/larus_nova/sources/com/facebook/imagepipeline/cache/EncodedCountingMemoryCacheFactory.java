package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class EncodedCountingMemoryCacheFactory {
    public EncodedCountingMemoryCacheFactory() {
    }

    public static CountingMemoryCache<CacheKey, PooledByteBuffer> get(Supplier<MemoryCacheParams> r100, MemoryTrimmableRegistry r101) {
        CountingMemoryCache<CacheKey, PooledByteBuffer> r102 = new CountingMemoryCache(new AnonymousClass1(), new NativeMemoryCacheTrimStrategy(), r100);
        r101.registerMemoryTrimmable(r102);
        return r102;
    }
}
