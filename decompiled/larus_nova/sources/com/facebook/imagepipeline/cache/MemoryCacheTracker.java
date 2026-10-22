package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCacheTracker<K> {
    void onCacheHit(K r100);

    void onCacheMiss();

    void onCachePut();
}
