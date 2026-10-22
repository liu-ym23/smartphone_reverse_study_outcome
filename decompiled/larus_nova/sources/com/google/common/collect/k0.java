package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class k0<K, V> extends o0 implements Map<K, V> {
    @Override // com.google.common.collect.o0
    public abstract Map<K, V> delegate();

    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.b(entrySet().iterator());
    }

    public int standardHashCode() {
        return Sets.c(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public String standardToString() {
        return Maps.i(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public k0() {
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object r100) {
        return delegate().containsKey(r100);
    }

    public boolean containsValue(@CheckForNull Object r100) {
        return delegate().containsValue(r100);
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r100) == true) goto L7;
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        return delegate().get(r100);
    }

    public void putAll(Map<? extends K, ? extends V> r100) {
        delegate().putAll(r100);
    }

    @CheckForNull
    public V remove(@CheckForNull Object r100) {
        return delegate().remove(r100);
    }

    public boolean standardContainsKey(@CheckForNull Object r100) {
        return Iterators.c(new i1(entrySet().iterator()), r100);
    }

    public boolean standardContainsValue(@CheckForNull Object r100) {
        return Iterators.c(new j1(entrySet().iterator()), r100);
    }

    public boolean standardEquals(@CheckForNull Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if ((r100 instanceof Map) == true) goto L10;
        return false;
    L10:
        return entrySet().equals(((Map) r100).entrySet());
    }

    public void standardPutAll(Map<? extends K, ? extends V> r100) {
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L4
    }

    @CheckForNull
    public V standardRemove(@CheckForNull Object r100) {
        Iterator<Map.Entry<K, V>> r101 = entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<K, V> r102 = r101.next();
        if (com.google.common.base.k.a(r102.getKey(), r100) == false) goto L4;
        V r103 = r102.getValue();
        r101.remove();
        return r103;
    L9:
        return null;
    }

    @CheckForNull
    public V put(@ParametricNullness K r100, @ParametricNullness V r101) {
        return delegate().put(r100, r101);
    }
}
