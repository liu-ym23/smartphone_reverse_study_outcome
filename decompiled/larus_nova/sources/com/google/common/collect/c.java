package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class c<K, V> implements q1<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Collection<Map.Entry<K, V>> f275430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Set<K> f275431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient y1<K> f275432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Collection<V> f275433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Map<K, Collection<V>> f275434e;

    public class a extends Multimaps.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f275435a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return this.f275435a.entryIterator();
        }

        public a(c r100) {
            this.f275435a = r100;
        }
    }

    public class b extends c<K, V>.a implements Set<Map.Entry<K, V>> {
        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.c(this);
        }

        public b(c r100) {
            super(r100);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(@CheckForNull Object r100) {
            return Sets.a(this, r100);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    public class C3856c extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f275436a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f275436a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return this.f275436a.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f275436a.size();
        }

        public C3856c(c r100) {
            this.f275436a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275436a.containsValue(r100);
        }
    }

    public c() {
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract y1<K> createKeys();

    public abstract Collection<V> createValues();

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // com.google.common.collect.q1
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> r100 = this.f275434e;
        if (r100 != null) goto L6;
        Map<K, Collection<V>> r101 = createAsMap();
        this.f275434e = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.q1
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> r100 = this.f275430a;
        if (r100 != null) goto L6;
        Collection<Map.Entry<K, V>> r101 = createEntries();
        this.f275430a = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.q1
    public Set<K> keySet() {
        Set<K> r100 = this.f275431b;
        if (r100 != null) goto L6;
        Set<K> r101 = createKeySet();
        this.f275431b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.q1
    public y1<K> keys() {
        y1<K> r100 = this.f275432c;
        if (r100 != null) goto L6;
        y1<K> r101 = createKeys();
        this.f275432c = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.q1
    public Collection<V> values() {
        Collection<V> r100 = this.f275433d;
        if (r100 != null) goto L6;
        Collection<V> r101 = createValues();
        this.f275433d = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.q1
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.q1
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return new j1(entries().iterator());
    }

    @Override // com.google.common.collect.q1
    public boolean containsValue(@CheckForNull Object r100) {
        Iterator<Collection<V>> r101 = asMap().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().contains(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.q1
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L5;
        return true;
    L5:
        if ((r100 instanceof q1) == true) goto L10;
        return false;
    L10:
        return asMap().equals(((q1) r100).asMap());
    }

    @Override // com.google.common.collect.q1
    public boolean putAll(q1<? extends K, ? extends V> r100) {
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entries().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r103 = r101.next();
        r102 = r102 | put(r103.getKey(), r103.getValue());
        goto L4
    L6:
        return r102;
    }

    @Override // com.google.common.collect.q1
    public boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101) {
        Collection<V> r102 = asMap().get(r100);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.contains(r101) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.q1
    public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
        return get(r100).add(r101);
    }

    @Override // com.google.common.collect.q1
    public boolean putAll(@ParametricNullness K r100, Iterable<? extends V> r101) {
        r101.getClass();
        if ((r101 instanceof Collection) == false) goto L11;
        Collection<? extends V> r102 = (Collection) r101;
        if (r102.isEmpty() == false) goto L7;
    L9:
        return false;
    L7:
        if (get(r100).addAll(r102) == false) goto L9;
        return true;
    L11:
        Iterator<? extends V> r103 = r101.iterator();
        if (r103.hasNext() == true) goto L14;
    L16:
        return false;
    L14:
        if (Iterators.a(get(r100), r103) == false) goto L16;
        return true;
    }

    @Override // com.google.common.collect.q1
    public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        Collection<V> r102 = asMap().get(r100);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.remove(r101) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.q1
    public Collection<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
        r101.getClass();
        Collection<V> r102 = removeAll(r100);
        putAll(r100, r101);
        return r102;
    }
}
