package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.MemoryCacheHitTracker;

/* JADX INFO: loaded from: classes3.dex */
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    private final MemoryCache<K, V> mDelegate;
    private final MemoryCacheTracker mTracker;

    public MemoryCache<K, V> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate<K> r100) {
        return this.mDelegate.contains(r100);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> get(K r100) {
        CloseableReference<V> r101 = this.mDelegate.get(r100);
        if (r101 != null) goto L5;
        this.mTracker.onCacheMiss();
    L9:
        return r101;
    L5:
        this.mTracker.onCacheHit(r100);
        V r102 = r101.get();
        if ((r102 instanceof CloseableStaticBitmap) == false) goto L8;
        ((MemoryCacheHitTracker) r102).hitBitmapMemoryCache();
        goto L9
    L8:
        ((MemoryCacheHitTracker) r102).hitEncodeMemoryCache();
        goto L9
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> r100) {
        return this.mDelegate.removeAll(r100);
    }

    public InstrumentedMemoryCache(MemoryCache<K, V> r100, MemoryCacheTracker r101) {
        this.mDelegate = r100;
        this.mTracker = r101;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K r100, CloseableReference<V> r101) {
        this.mTracker.onCachePut();
        return this.mDelegate.cache(r100, r101);
    }
}
