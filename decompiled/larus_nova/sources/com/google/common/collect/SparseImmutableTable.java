package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes23.dex */
@Immutable(containerOf = {"R", "C", "V"})
@ElementTypesAreNonnullByDefault
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = null;
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    static {
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap r100 = Maps.d(columnKeySet());
        int[] r101 = new int[cellSet().size()];
        z2<t2.a<R, C, V>> r102 = cellSet().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L7;
        Integer r104 = (Integer) r100.get(r102.next().getColumnKey());
        Objects.requireNonNull(r104);
        r101[r103] = r104.intValue();
        r103 = r103 + 1;
        goto L4
    L7:
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, r101);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public t2.a<R, C, V> getCell(int r100) {
        int r101 = this.cellRowIndices[r100];
        Map.Entry<R, ImmutableMap<C, V>> r102 = this.rowMap.entrySet().asList().get(r101);
        ImmutableMap<C, V> r103 = r102.getValue();
        int r104 = this.cellColumnInRowIndices[r100];
        Map.Entry<C, V> r105 = r103.entrySet().asList().get(r104);
        return ImmutableTable.cellOf(r102.getKey(), r105.getKey(), r105.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int r100) {
        int r101 = this.cellRowIndices[r100];
        ImmutableMap<C, V> r102 = this.rowMap.values().asList().get(r101);
        int r103 = this.cellColumnInRowIndices[r100];
        return r102.values().asList().get(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<t2.a<R, C, V>> r110, ImmutableSet<R> r111, ImmutableSet<C> r112) {
        ImmutableMap r100 = Maps.d(r111);
        LinkedHashMap r101 = new LinkedHashMap();
        z2<R> r113 = r111.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        r101.put(r113.next(), new LinkedHashMap());
        goto L4
    L6:
        LinkedHashMap r114 = new LinkedHashMap();
        z2<C> r115 = r112.iterator();
    L8:
        if (r115.hasNext() == false) goto L10;
        r114.put(r115.next(), new LinkedHashMap());
        goto L8
    L10:
        int[] r116 = new int[r110.size()];
        int[] r102 = new int[r110.size()];
        int r103 = 0;
    L12:
        if (r103 >= r110.size()) goto L14;
        t2.a<R, C, V> r104 = r110.get(r103);
        R r105 = r104.getRowKey();
        C r106 = r104.getColumnKey();
        V r107 = r104.getValue();
        Integer r108 = (Integer) r100.get(r105);
        Objects.requireNonNull(r108);
        r116[r103] = r108.intValue();
        Map r109 = (Map) r101.get(r105);
        Objects.requireNonNull(r109);
        Map r117 = r109;
        r102[r103] = r117.size();
        checkNoDuplicate(r105, r106, r117.put(r106, r107), r107);
        Map r118 = (Map) r114.get(r106);
        Objects.requireNonNull(r118);
        r118.put(r105, r107);
        r103 = r103 + 1;
        goto L12
    L14:
        this.cellRowIndices = r116;
        this.cellColumnInRowIndices = r102;
        ImmutableMap.b r119 = new ImmutableMap.b(r101.size());
        Iterator r120 = r101.entrySet().iterator();
    L16:
        if (r120.hasNext() == false) goto L18;
        Map.Entry r121 = (Map.Entry) r120.next();
        r119.e(r121.getKey(), ImmutableMap.copyOf((Map) r121.getValue()));
        goto L16
    L18:
        this.rowMap = r119.b(true);
        ImmutableMap.b r122 = new ImmutableMap.b(r114.size());
        Iterator r123 = r114.entrySet().iterator();
    L20:
        if (r123.hasNext() == false) goto L22;
        Map.Entry r124 = (Map.Entry) r123.next();
        r122.e(r124.getKey(), ImmutableMap.copyOf((Map) r124.getValue()));
        goto L20
    L22:
        this.columnMap = r122.b(true);
    }
}
