package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class t0<R, C, V> extends o0 implements t2<R, C, V> {
    @Override // com.google.common.collect.o0
    public abstract t2<R, C, V> delegate();

    public Set<t2.a<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.t2
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.t2
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.t2
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public t0() {
    }

    public Map<R, V> column(@ParametricNullness C r100) {
        return delegate().column(r100);
    }

    @Override // com.google.common.collect.t2
    public boolean containsColumn(@CheckForNull Object r100) {
        return delegate().containsColumn(r100);
    }

    @Override // com.google.common.collect.t2
    public boolean containsRow(@CheckForNull Object r100) {
        return delegate().containsRow(r100);
    }

    @Override // com.google.common.collect.t2
    public boolean containsValue(@CheckForNull Object r100) {
        return delegate().containsValue(r100);
    }

    @Override // com.google.common.collect.t2
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r100) == true) goto L7;
        return false;
    }

    public void putAll(t2<? extends R, ? extends C, ? extends V> r100) {
        delegate().putAll(r100);
    }

    public Map<C, V> row(@ParametricNullness R r100) {
        return delegate().row(r100);
    }

    @Override // com.google.common.collect.t2
    public boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
        return delegate().contains(r100, r101);
    }

    @Override // com.google.common.collect.t2
    @CheckForNull
    public V get(@CheckForNull Object r100, @CheckForNull Object r101) {
        return delegate().get(r100, r101);
    }

    @CheckForNull
    public V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        return delegate().remove(r100, r101);
    }

    @CheckForNull
    public V put(@ParametricNullness R r100, @ParametricNullness C r101, @ParametricNullness V r102) {
        return delegate().put(r100, r101, r102);
    }
}
