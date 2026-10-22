package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    private static final long serialVersionUID = 0;

    public static class Factory<C, V> implements com.google.common.base.t<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final int expectedSize;

        @Override // com.google.common.base.t
        public Map<C, V> get() {
            return new LinkedHashMap(Maps.b(this.expectedSize));
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public Factory(int r100) {
            this.expectedSize = r100;
        }
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable(new LinkedHashMap(), new Factory(0));
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(t2<? extends R, ? extends C, ? extends V> r100) {
        HashBasedTable<R, C, V> r101 = create();
        r101.putAll(r100);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map column(Object r100) {
        return super.column(r100);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object r100) {
        return super.containsColumn(r100);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object r100) {
        return super.containsRow(r100);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object r100) {
        return super.containsValue(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ void putAll(t2 r100) {
        super.putAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map row(Object r100) {
        return super.row(r100);
    }

    public HashBasedTable(Map<R, Map<C, V>> r100, Factory<C, V> r101) {
        super(r100, r101);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int r100, int r101) {
        o.b(r101, "expectedCellsPerRow");
        return new HashBasedTable(new LinkedHashMap(Maps.b(r100)), new Factory(r101));
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.contains(r100, r101);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.get(r100, r101);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.remove(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object r100, Object r101, Object r102) {
        return super.put(r100, r101, r102);
    }
}
