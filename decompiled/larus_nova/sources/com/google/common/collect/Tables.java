package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Tables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275364a = null;

    public static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        private final C columnKey;

        @ParametricNullness
        private final R rowKey;

        @ParametricNullness
        private final V value;

        @Override // com.google.common.collect.t2.a
        @ParametricNullness
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.t2.a
        @ParametricNullness
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.t2.a
        @ParametricNullness
        public V getValue() {
            return this.value;
        }

        public ImmutableCell(@ParametricNullness R r100, @ParametricNullness C r101, @ParametricNullness V r102) {
            this.rowKey = r100;
            this.columnKey = r101;
            this.value = r102;
        }
    }

    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements i2<R, C, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.t2
        public SortedMap<R, Map<C, V>> rowMap() {
            a r100 = Tables.f275364a;
            return Collections.unmodifiableSortedMap(new Maps.m(delegate().rowMap(), new n1(r100)));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.o0
        public i2<R, C, V> delegate() {
            return (i2) super.delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.t2
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ t2 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.t2
        public /* bridge */ /* synthetic */ Set rowKeySet() {
            return rowKeySet();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.t2
        public /* bridge */ /* synthetic */ Map rowMap() {
            return rowMap();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.t0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public UnmodifiableRowSortedMap(i2<R, ? extends C, ? extends V> r100) {
            super(r100);
        }
    }

    public static class UnmodifiableTable<R, C, V> extends t0<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final t2<? extends R, ? extends C, ? extends V> delegate;

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Map<C, Map<R, V>> columnMap() {
            a r100 = Tables.f275364a;
            return Collections.unmodifiableMap(Maps.j(super.columnMap(), r100));
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Map<R, Map<C, V>> rowMap() {
            a r100 = Tables.f275364a;
            return Collections.unmodifiableMap(Maps.j(super.rowMap(), r100));
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Set<t2.a<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.o0
        public t2<R, C, V> delegate() {
            return this.delegate;
        }

        public UnmodifiableTable(t2<? extends R, ? extends C, ? extends V> r100) {
            r100.getClass();
            this.delegate = r100;
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Map<R, V> column(@ParametricNullness C r100) {
            return Collections.unmodifiableMap(super.column(r100));
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public void putAll(t2<? extends R, ? extends C, ? extends V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        public Map<C, V> row(@ParametricNullness R r100) {
            return Collections.unmodifiableMap(super.row(r100));
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        @CheckForNull
        public V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.t0, com.google.common.collect.t2
        @CheckForNull
        public V put(@ParametricNullness R r100, @ParametricNullness C r101, @ParametricNullness V r102) {
            throw new UnsupportedOperationException();
        }
    }

    public class a implements com.google.common.base.g<Map<Object, Object>, Map<Object, Object>> {
        public a() {
        }

        @Override // com.google.common.base.g
        public final Map<Object, Object> apply(Map<Object, Object> r100) {
            return Collections.unmodifiableMap(r100);
        }
    }

    public static abstract class b<R, C, V> implements t2.a<R, C, V> {
        public b() {
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{getRowKey(), getColumnKey(), getValue()});
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }

        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof t2.a) == false) goto L16;
            t2.a r101 = (t2.a) r100;
            if (com.google.common.base.k.a(getRowKey(), r101.getRowKey()) == true) goto L10;
        L14:
            return false;
        L10:
            if (com.google.common.base.k.a(getColumnKey(), r101.getColumnKey()) == false) goto L14;
            if (com.google.common.base.k.a(getValue(), r101.getValue()) == false) goto L14;
            return true;
        L16:
            return false;
        }
    }

    static {
        f275364a = new a();
    }
}
