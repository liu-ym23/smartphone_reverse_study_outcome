package com.google.common.collect;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableTable<R, C, V> extends i<R, C, V> implements Serializable {

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        public Object readResolve() {
            Object[] r100 = this.cellValues;
            if (r100.length == 0) goto L5;
            int r101 = 0;
            if (r100.length == 1) goto L9;
            int r102 = r100.length;
            o.b(r102, "initialCapacity");
            Object[] r103 = new Object[r102];
            int r104 = 0;
        L11:
            Object[] r105 = this.cellValues;
            if (r101 >= r105.length) goto L18;
            t2.a r106 = ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[r101]], this.columnKeys[this.cellColumnIndices[r101]], r105[r101]);
            r106.getClass();
            int r107 = r104 + 1;
            if (r103.length >= r107) goto L16;
            r103 = Arrays.copyOf(r103, ImmutableCollection.b.a(r103.length, r107));
        L16:
            r103[r104] = r106;
            r101 = r101 + 1;
            r104 = r107;
            goto L11
        L18:
            return RegularImmutableTable.forOrderedComponents(ImmutableList.asImmutableList(r103, r104), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
        L9:
            return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], r100[0]);
        L5:
            return ImmutableTable.of();
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> r100, int[] r101, int[] r102) {
            return new SerializedForm(r100.rowKeySet().toArray(), r100.columnKeySet().toArray(), r100.values().toArray(), r101, r102);
        }

        public SerializedForm(Object[] r100, Object[] r101, Object[] r102, int[] r103, int[] r104) {
            this.rowKeys = r100;
            this.columnKeys = r101;
            this.cellValues = r102;
            this.cellRowIndices = r103;
            this.cellColumnIndices = r104;
        }
    }

    @DoNotMock
    public static final class a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<t2.a<R, C, V>> f275134a;

        public a() {
            this.f275134a = new ArrayList();
        }
    }

    @Override // com.google.common.collect.t2
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.i
    public abstract ImmutableSet<t2.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.i
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.t2
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.t2
    public abstract /* synthetic */ int size();

    public static <R, C, V> a<R, C, V> builder() {
        return new a();
    }

    @Override // com.google.common.collect.i
    public final z2<t2.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public ImmutableSet<t2.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public ImmutableTable() {
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ Iterator cellIterator() {
        return cellIterator();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set cellSet() {
        return cellSet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends t2.a<? extends R, ? extends C, ? extends V>> r100) {
        a r101 = builder();
        Iterator<? extends t2.a<? extends R, ? extends C, ? extends V>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        t2.a<? extends R, ? extends C, ? extends V> r103 = r102.next();
        r101.getClass();
        if ((r103 instanceof Tables.ImmutableCell) == true) goto L7;
        R r104 = r103.getRowKey();
        C r105 = r103.getColumnKey();
        V r106 = r103.getValue();
        List<t2.a<R, C, V>> r107 = r101.f275134a;
        ArrayList r108 = (ArrayList) r107;
        r108.add(cellOf(r104, r105, r106));
        goto L4
    L7:
        com.google.common.base.m.l(r103.getRowKey(), SlcFlexDirection.FLEX_ROW);
        com.google.common.base.m.l(r103.getColumnKey(), "column");
        com.google.common.base.m.l(r103.getValue(), "value");
        ((ArrayList) r101.f275134a).add(r103);
        goto L4
    L9:
        int r109 = ((ArrayList) r101.f275134a).size();
        if (r109 == 0) goto L16;
        if (r109 == 1) goto L24;
        return RegularImmutableTable.forCells(r101.f275134a, null, null);
    L24:
        return new SingletonImmutableTable((t2.a) a1.b(r101.f275134a));
    L16:
        return of();
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.t2
    public ImmutableMap<R, V> column(C r100) {
        com.google.common.base.m.l(r100, "columnKey");
        return (ImmutableMap) com.google.common.base.j.a((ImmutableMap) columnMap().get(r100), ImmutableMap.of());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object r100) {
        return super.containsColumn(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object r100) {
        return super.containsRow(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsValue(@CheckForNull Object r100) {
        return values().contains(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public final void putAll(t2<? extends R, ? extends C, ? extends V> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t2
    public ImmutableMap<C, V> row(R r100) {
        com.google.common.base.m.l(r100, "rowKey");
        return (ImmutableMap) com.google.common.base.j.a((ImmutableMap) rowMap().get(r100), ImmutableMap.of());
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(t2<? extends R, ? extends C, ? extends V> r100) {
        if ((r100 instanceof ImmutableTable) == false) goto L7;
        return (ImmutableTable) r100;
    L7:
        return copyOf(r100.cellSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map column(Object r100) {
        return column(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map row(Object r100) {
        return row(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (get(r100, r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.get(r100, r101);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public final V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        throw new UnsupportedOperationException();
    }

    public static <R, C, V> t2.a<R, C, V> cellOf(R r100, C r101, V r102) {
        com.google.common.base.m.l(r100, "rowKey");
        com.google.common.base.m.l(r101, "columnKey");
        com.google.common.base.m.l(r102, "value");
        Tables.a r103 = Tables.f275364a;
        return new Tables.ImmutableCell(r100, r101, r102);
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r100, C r101, V r102) {
        return new SingletonImmutableTable(r100, r101, r102);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public final V put(R r100, C r101, V r102) {
        throw new UnsupportedOperationException();
    }
}
