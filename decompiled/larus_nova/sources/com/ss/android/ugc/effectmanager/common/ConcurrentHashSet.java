package com.ss.android.ugc.effectmanager.common;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class ConcurrentHashSet<E> extends AbstractSet<E> implements Set<E> {
    private transient Set<E> _keys;
    private final Map<E, Boolean> _map;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this._map.clear();
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this._keys.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this._map.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this._keys.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._map.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this._keys.toArray();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this._keys.toString();
    }

    public ConcurrentHashSet() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        this._map = r100;
        this._keys = r100.keySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r100) {
        if (this._map.put(r100, Boolean.TRUE) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r100) {
        return this._map.containsKey(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r100) {
        return this._keys.containsAll(r100);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (this._keys.equals(r100) == true) goto L7;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r100) {
        if (this._map.remove(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> r100) {
        return this._keys.removeAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> r100) {
        return this._keys.retainAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r100) {
        return (T[]) this._keys.toArray(r100);
    }
}
