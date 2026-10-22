package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.o0;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class f<K, V> extends o0 implements c<K, V> {
    @Override // com.google.common.collect.o0
    public abstract c<K, V> delegate();

    @Override // com.google.common.cache.c
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.c
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.cache.c
    public void invalidateAll() {
        delegate().invalidateAll();
    }

    @Override // com.google.common.cache.c
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.c
    public e stats() {
        return delegate().stats();
    }

    public f() {
    }

    @Override // com.google.common.cache.c
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> r100) {
        return delegate().getAllPresent(r100);
    }

    @Override // com.google.common.cache.c
    @CheckForNull
    public V getIfPresent(Object r100) {
        return delegate().getIfPresent(r100);
    }

    @Override // com.google.common.cache.c
    public void invalidate(Object r100) {
        delegate().invalidate(r100);
    }

    @Override // com.google.common.cache.c
    public void invalidateAll(Iterable<? extends Object> r100) {
        delegate().invalidateAll(r100);
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<? extends K, ? extends V> r100) {
        delegate().putAll(r100);
    }

    @Override // com.google.common.cache.c
    public V get(K r100, Callable<? extends V> r101) throws ExecutionException {
        return delegate().get(r100, r101);
    }

    @Override // com.google.common.cache.c
    public void put(K r100, V r101) {
        delegate().put(r100, r101);
    }
}
