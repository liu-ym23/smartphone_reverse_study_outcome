package com.lynx.tasm.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class NullableConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f383232a = null;

    public class a implements Set<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f383233a;

        /* JADX INFO: renamed from: com.lynx.tasm.common.NullableConcurrentHashMap$a$a, reason: collision with other inner class name */
        public class C4570a implements Iterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f383234a;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f383234a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return new com.lynx.tasm.common.a((Map.Entry) this.f383234a.next());
            }

            public C4570a(Iterator r100) {
                this.f383234a = r100;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            this.f383233a.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return this.f383233a.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new C4570a(this.f383233a.iterator());
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return this.f383233a.size();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            Object[] r100 = this.f383233a.toArray();
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L9;
            if (r100[r101] != NullableConcurrentHashMap.access$000()) goto L8;
            r100[r101] = null;
        L8:
            r101 = r101 + 1;
            goto L4
        L9:
            return r100;
        }

        public a(Set r100) {
            this.f383233a = r100;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object r100) {
            Set r101 = this.f383233a;
            return r101.add((Map.Entry) r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> r100) {
            return this.f383233a.addAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object r100) {
            Set r101 = this.f383233a;
            if (r100 != null) goto L6;
            r100 = NullableConcurrentHashMap.access$000();
        L6:
            return r101.contains(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> r100) {
            return this.f383233a.containsAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object r100) {
            return this.f383233a.remove(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> r100) {
            return this.f383233a.retainAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> r100) {
            return this.f383233a.retainAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] r100) {
            return (T[]) this.f383233a.toArray(r100);
        }
    }

    static {
        f383232a = new Object();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new a(super.entrySet());
    }

    public NullableConcurrentHashMap() {
    }

    public static /* synthetic */ Object access$000() {
        return f383232a;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        Object r101 = f383232a;
        if (r100 != null) goto L5;
        r100 = r101;
    L5:
        V r102 = (V) super.get(r100);
        if (r102 != r101) goto L9;
        return null;
    L9:
        return r102;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L6
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        Object r102 = f383232a;
        if (r100 != null) goto L5;
        r100 = (K) r102;
    L5:
        if (r101 != null) goto L7;
        r101 = (V) r102;
    L7:
        V r103 = (V) super.put(r100, r101);
        if (r103 != r102) goto L11;
        return null;
    L11:
        return r103;
    }
}
