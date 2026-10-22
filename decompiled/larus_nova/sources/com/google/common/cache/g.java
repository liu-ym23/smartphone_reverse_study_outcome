package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface g<K, V> extends c<K, V>, com.google.common.base.g<K, V> {
    @Override // com.google.common.base.g
    V apply(K r100);

    V get(K r100) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> r100) throws ExecutionException;

    V getUnchecked(K r100);

    void refresh(K r100);
}
