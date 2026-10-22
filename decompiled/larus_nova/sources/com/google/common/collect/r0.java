package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class r0<K, V> extends k0<K, V> implements SortedMap<K, V> {
    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.SortedMap
    @ParametricNullness
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    @ParametricNullness
    public K lastKey() {
        return delegate().lastKey();
    }

    public r0() {
    }

    @Override // com.google.common.collect.k0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    public SortedMap<K, V> headMap(@ParametricNullness K r100) {
        return delegate().headMap(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.k0
    public boolean standardContainsKey(@CheckForNull Object r100) {
        K r101 = tailMap(r100).firstKey();     // Catch: Throwable -> L7
        if (unsafeCompare(comparator(), r101, r100) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K r100) {
        return delegate().tailMap(r100);
    }

    public SortedMap<K, V> standardSubMap(K r100, K r101) {
        if (unsafeCompare(comparator(), r100, r101) > 0) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.c(r102, "fromKey must be <= toKey");
        return tailMap(r100).headMap(r101);
    L5:
        r102 = false;
        goto L6
    }

    public SortedMap<K, V> subMap(@ParametricNullness K r100, @ParametricNullness K r101) {
        return delegate().subMap(r100, r101);
    }

    public static int unsafeCompare(@CheckForNull Comparator<?> r100, @CheckForNull Object r101, @CheckForNull Object r102) {
        if (r100 != null) goto L6;
        return ((Comparable) r101).compareTo(r102);
    L6:
        return r100.compare(r101, r102);
    }
}
