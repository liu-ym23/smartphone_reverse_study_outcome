package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use CacheBuilder.newBuilder().build()")
@ElementTypesAreNonnullByDefault
public interface c<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K r100, Callable<? extends V> r101) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> r100);

    @CheckForNull
    V getIfPresent(Object r100);

    void invalidate(Object r100);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> r100);

    void put(K r100, V r101);

    void putAll(Map<? extends K, ? extends V> r100);

    long size();

    e stats();
}
