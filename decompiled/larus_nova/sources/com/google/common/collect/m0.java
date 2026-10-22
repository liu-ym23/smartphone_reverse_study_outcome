package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class m0<K, V> extends o0 implements q1<K, V> {
    @Override // com.google.common.collect.o0
    public abstract q1<K, V> delegate();

    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // com.google.common.collect.q1
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.q1
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public y1<K> keys() {
        return delegate().keys();
    }

    @Override // com.google.common.collect.q1
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public m0() {
    }

    @Override // com.google.common.collect.q1
    public boolean containsKey(@CheckForNull Object r100) {
        return delegate().containsKey(r100);
    }

    @Override // com.google.common.collect.q1
    public boolean containsValue(@CheckForNull Object r100) {
        return delegate().containsValue(r100);
    }

    @Override // com.google.common.collect.q1
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r100) == true) goto L7;
        return false;
    }

    public Collection<V> get(@ParametricNullness K r100) {
        return delegate().get(r100);
    }

    public boolean putAll(q1<? extends K, ? extends V> r100) {
        return delegate().putAll(r100);
    }

    public Collection<V> removeAll(@CheckForNull Object r100) {
        return delegate().removeAll(r100);
    }

    @Override // com.google.common.collect.q1
    public boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101) {
        return delegate().containsEntry(r100, r101);
    }

    public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
        return delegate().put(r100, r101);
    }

    public boolean putAll(@ParametricNullness K r100, Iterable<? extends V> r101) {
        return delegate().putAll(r100, r101);
    }

    public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        return delegate().remove(r100, r101);
    }

    public Collection<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
        return delegate().replaceValues(r100, r101);
    }
}
