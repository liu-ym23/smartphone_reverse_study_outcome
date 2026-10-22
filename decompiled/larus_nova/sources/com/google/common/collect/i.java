package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class i<R, C, V> implements t2<R, C, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Set<t2.a<R, C, V>> f275472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Collection<V> f275473b;

    public class a extends v2<t2.a<R, C, V>, V> {
        public a(Iterator r100) {
            super(r100);
        }

        @Override // com.google.common.collect.v2
        @ParametricNullness
        public final Object a(Object r100) {
            return ((t2.a) r100).getValue();
        }
    }

    public class b extends AbstractSet<t2.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f275474a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f275474a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<t2.a<R, C, V>> iterator() {
            return this.f275474a.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f275474a.size();
        }

        public b(i r100) {
            this.f275474a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof t2.a) == false) goto L15;
            t2.a r101 = (t2.a) r100;
            Map r102 = (Map) Maps.h(this.f275474a.rowMap(), r101.getRowKey());
            if (r102 == null) goto L16;
            Set r103 = r102.entrySet();
            ImmutableEntry r104 = new ImmutableEntry(r101.getColumnKey(), r101.getValue());
            r103.getClass();
            boolean r105 = r103.contains(r104);     // Catch: Throwable -> L9
        L10:
            if (r105 == false) goto L17;
            return true;
        L17:
            return false;
        L9:
            r105 = false;
            goto L10
        L16:
            return false;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if ((r100 instanceof t2.a) == false) goto L15;
            t2.a r101 = (t2.a) r100;
            Map r102 = (Map) Maps.h(this.f275474a.rowMap(), r101.getRowKey());
            if (r102 == null) goto L16;
            Set r103 = r102.entrySet();
            ImmutableEntry r104 = new ImmutableEntry(r101.getColumnKey(), r101.getValue());
            r103.getClass();
            boolean r105 = r103.remove(r104);     // Catch: Throwable -> L9
        L10:
            if (r105 == false) goto L17;
            return true;
        L17:
            return false;
        L9:
            r105 = false;
            goto L10
        L16:
            return false;
        L15:
            return false;
        }
    }

    public class c extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f275475a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f275475a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return this.f275475a.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f275475a.size();
        }

        public c(i r100) {
            this.f275475a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275475a.containsValue(r100);
        }
    }

    public i() {
    }

    public abstract Iterator<t2.a<R, C, V>> cellIterator();

    @Override // com.google.common.collect.t2
    public Set<t2.a<R, C, V>> cellSet() {
        Set<t2.a<R, C, V>> r100 = this.f275472a;
        if (r100 != null) goto L6;
        Set<t2.a<R, C, V>> r101 = createCellSet();
        this.f275472a = r101;
        return r101;
    L6:
        return r100;
    }

    public Set<t2.a<R, C, V>> createCellSet() {
        return new b(this);
    }

    public Collection<V> createValues() {
        return new c(this);
    }

    @Override // com.google.common.collect.t2
    public Collection<V> values() {
        Collection<V> r100 = this.f275473b;
        if (r100 != null) goto L6;
        Collection<V> r101 = createValues();
        this.f275473b = r101;
        return r101;
    L6:
        return r100;
    }

    public Iterator<V> valuesIterator() {
        return new a(cellSet().iterator());
    }

    @Override // com.google.common.collect.t2
    public void clear() {
        Iterators.b(cellSet().iterator());
    }

    @Override // com.google.common.collect.t2
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.t2
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.t2
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.t2
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.t2
    public boolean containsColumn(@CheckForNull Object r100) {
        return Maps.g(columnMap(), r100);
    }

    @Override // com.google.common.collect.t2
    public boolean containsRow(@CheckForNull Object r100) {
        return Maps.g(rowMap(), r100);
    }

    @Override // com.google.common.collect.t2
    public boolean containsValue(@CheckForNull Object r100) {
        Iterator<Map<C, V>> r101 = rowMap().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().containsValue(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.t2
    public boolean equals(@CheckForNull Object r100) {
        Tables.a r101 = Tables.f275364a;
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof t2) == true) goto L11;
        return false;
    L11:
        return cellSet().equals(((t2) r100).cellSet());
    }

    @Override // com.google.common.collect.t2
    public void putAll(t2<? extends R, ? extends C, ? extends V> r100) {
        Iterator<t2.a<? extends R, ? extends C, ? extends V>> r101 = r100.cellSet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        t2.a<? extends R, ? extends C, ? extends V> r102 = r101.next();
        put(r102.getRowKey(), r102.getColumnKey(), r102.getValue());
        goto L4
    }

    @Override // com.google.common.collect.t2
    public boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
        Map r102 = (Map) Maps.h(rowMap(), r100);
        if (r102 == null) goto L12;
        boolean r103 = r102.containsKey(r101);     // Catch: Throwable -> L6
    L7:
        if (r103 == false) goto L13;
        return true;
    L13:
        return false;
    L6:
        r103 = false;
        goto L7
    L12:
        return false;
    }

    @Override // com.google.common.collect.t2
    @CheckForNull
    public V get(@CheckForNull Object r100, @CheckForNull Object r101) {
        Map r102 = (Map) Maps.h(rowMap(), r100);
        if (r102 == null) goto L10;
        return (V) r102.get(r101);
    L11:
        return null;
    L10:
        return null;
    }

    @Override // com.google.common.collect.t2
    @CheckForNull
    public V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        Map r102 = (Map) Maps.h(rowMap(), r100);
        if (r102 == null) goto L10;
        return (V) r102.remove(r101);
    L11:
        return null;
    L10:
        return null;
    }

    @Override // com.google.common.collect.t2
    @CheckForNull
    public V put(@ParametricNullness R r100, @ParametricNullness C r101, @ParametricNullness V r102) {
        return row(r100).put(r101, r102);
    }
}
