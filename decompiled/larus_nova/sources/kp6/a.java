package kp6;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class a<E> extends AbstractSet<E> implements Set<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<E, Boolean> f505512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Set<E> f505513b;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        ((ConcurrentHashMap) this.f505512a).clear();
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f505513b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return ((ConcurrentHashMap) this.f505512a).isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return this.f505513b.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return ((ConcurrentHashMap) this.f505512a).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return this.f505513b.toArray();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.f505513b.toString();
    }

    public a() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        this.f505512a = r100;
        this.f505513b = r100.keySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E r100) {
        Map<E, Boolean> r101 = this.f505512a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        if (r102.put(r100, Boolean.TRUE) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r100) {
        return ((ConcurrentHashMap) this.f505512a).containsKey(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> r100) {
        return this.f505513b.containsAll(r100);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (this.f505513b.equals(r100) == true) goto L7;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r100) {
        if (((ConcurrentHashMap) this.f505512a).remove(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> r100) {
        return this.f505513b.removeAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> r100) {
        return this.f505513b.retainAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] r100) {
        return (T[]) this.f505513b.toArray(r100);
    }
}
