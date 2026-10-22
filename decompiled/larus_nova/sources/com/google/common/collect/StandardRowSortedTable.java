package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements i2<R, C, V> {
    private static final long serialVersionUID = 0;

    public class a extends StandardTable<R, C, V>.g implements SortedMap<R, Map<C, V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ StandardRowSortedTable f275327e;

        @Override // com.google.common.collect.Maps.q
        public final Set b() {
            return new Maps.k(this);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public final Comparator<? super R> comparator() {
            return StandardRowSortedTable.access$100(this.f275327e).comparator();
        }

        @Override // java.util.SortedMap
        public final R firstKey() {
            return (R) StandardRowSortedTable.access$100(this.f275327e).firstKey();
        }

        @Override // java.util.SortedMap
        public final R lastKey() {
            return (R) StandardRowSortedTable.access$100(this.f275327e).lastKey();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return (SortedSet) super.keySet();
        }

        public a(StandardRowSortedTable r100) {
            this.f275327e = r100;
            super(r100);
        }

        @Override // java.util.SortedMap
        public final SortedMap<R, Map<C, V>> headMap(R r100) {
            r100.getClass();
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.f275327e).headMap(r100), this.f275327e.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public final SortedMap<R, Map<C, V>> tailMap(R r100) {
            r100.getClass();
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.f275327e).tailMap(r100), this.f275327e.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public final SortedMap<R, Map<C, V>> subMap(R r100, R r101) {
            r100.getClass();
            r101.getClass();
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.f275327e).subMap(r100, r101), this.f275327e.factory).rowMap();
        }
    }

    @Override // com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new a(this);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map createRowMap() {
        return createRowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    public static SortedMap access$100(StandardRowSortedTable r100) {
        return (SortedMap) r100.backingMap;
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> r100, com.google.common.base.t<? extends Map<C, V>> r101) {
        super(r100, r101);
    }
}
