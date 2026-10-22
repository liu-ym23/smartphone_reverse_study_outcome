package com.bytedance.jedi.model.guava.cache;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes19.dex */
public interface Cache<K, V> {
    ConcurrentMap<K, V> asMap();

    V getIfPresent(K r100);

    void invalidate(K r100);

    void put(K r100, V r101);
}
