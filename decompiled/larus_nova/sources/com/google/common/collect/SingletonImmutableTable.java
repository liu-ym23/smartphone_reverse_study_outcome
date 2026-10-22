package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public ImmutableSet<t2.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    public SingletonImmutableTable(t2.a<R, C, V> r100) {
        this(r100.getRowKey(), r100.getColumnKey(), r100.getValue());
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<R, V> column(C r100) {
        r100.getClass();
        if (containsColumn(r100) == false) goto L6;
        return ImmutableMap.of(this.singleRowKey, this.singleValue);
    L6:
        return ImmutableMap.of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map column(Object r100) {
        return column(r100);
    }

    public SingletonImmutableTable(R r100, C r101, V r102) {
        r100.getClass();
        this.singleRowKey = r100;
        r101.getClass();
        this.singleColumnKey = r101;
        r102.getClass();
        this.singleValue = r102;
    }
}
