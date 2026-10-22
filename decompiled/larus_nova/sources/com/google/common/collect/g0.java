package com.google.common.collect;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class g0<K, V> extends k0<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public abstract ConcurrentMap<K, V> delegate();

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public g0() {
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V putIfAbsent(K r100, V r101) {
        return delegate().putIfAbsent(r100, r101);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        return delegate().remove(r100, r101);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V replace(K r100, V r101) {
        return delegate().replace(r100, r101);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r100, V r101, V r102) {
        return delegate().replace(r100, r101, r102);
    }
}
