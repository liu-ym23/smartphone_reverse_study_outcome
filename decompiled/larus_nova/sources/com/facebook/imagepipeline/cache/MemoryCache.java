package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCache<K, V> {
    @Nullable
    CloseableReference<V> cache(K r100, CloseableReference<V> r101);

    boolean contains(Predicate<K> r100);

    @Nullable
    CloseableReference<V> get(K r100);

    int removeAll(Predicate<K> r100);
}
