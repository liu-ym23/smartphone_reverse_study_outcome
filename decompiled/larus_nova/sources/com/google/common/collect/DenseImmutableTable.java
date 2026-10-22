package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@Immutable(containerOf = {"R", "C", "V"})
@ElementTypesAreNonnullByDefault
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    public final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        @CheckForNull
        public V getValue(int r100) {
            return (V) DenseImmutableTable.access$400(this.this$0)[r100][this.columnIndex];
        }

        public Column(DenseImmutableTable r100, int r101) {
            this.this$0 = r100;
            super(DenseImmutableTable.access$500(r100)[r101]);
            this.columnIndex = r101;
        }
    }

    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, V> getValue(int r100) {
            return new Column(this.this$0, r100);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r100) {
            return getValue(r100);
        }

        public ColumnMap(DenseImmutableTable r100, a r101) {
            this.this$0 = r100;
            super(DenseImmutableTable.access$500(r100).length);
        }
    }

    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        public class a extends AbstractIterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f275005c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f275006d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ImmutableArrayMap f275007e;

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public final Object a() {
            L2:
                int r100 = this.f275005c + 1;
                this.f275005c = r100;
                if (r100 >= this.f275006d) goto L7;
                Object r101 = this.f275007e.getValue(r100);
                if (r101 == null) goto L2;
                return new ImmutableEntry(this.f275007e.getKey(this.f275005c), r101);
            L7:
                this.f274902a = AbstractIterator.State.DONE;
                return null;
            }

            public a(ImmutableArrayMap r100) {
                this.f275007e = r100;
                this.f275005c = -1;
                this.f275006d = r100.keyToIndex().size();
            }
        }

        @CheckForNull
        public abstract V getValue(int r100);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            if (this.size != keyToIndex().size()) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L9;
            return keyToIndex().keySet();
        L9:
            return super.createKeySet();
        L5:
            r100 = false;
            goto L6
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public z2<Map.Entry<K, V>> entryIterator() {
            return new a(this);
        }

        @Override // java.util.Map
        public int size() {
            return this.size;
        }

        public ImmutableArrayMap(int r100) {
            this.size = r100;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object r100) {
            Integer r101 = keyToIndex().get(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return getValue(r101.intValue());
        }

        public K getKey(int r100) {
            return keyToIndex().keySet().asList().get(r100);
        }
    }

    public final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        @CheckForNull
        public V getValue(int r100) {
            return (V) DenseImmutableTable.access$400(this.this$0)[this.rowIndex][r100];
        }

        public Row(DenseImmutableTable r100, int r101) {
            this.this$0 = r100;
            super(DenseImmutableTable.access$200(r100)[r101]);
            this.rowIndex = r101;
        }
    }

    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, V> getValue(int r100) {
            return new Row(this.this$0, r100);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r100) {
            return getValue(r100);
        }

        public RowMap(DenseImmutableTable r100, a r101) {
            this.this$0 = r100;
            super(DenseImmutableTable.access$200(r100).length);
        }
    }

    public static /* synthetic */ class a {
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    public static /* synthetic */ int[] access$200(DenseImmutableTable r100) {
        return r100.rowCounts;
    }

    public static /* synthetic */ ImmutableMap access$300(DenseImmutableTable r100) {
        return r100.columnKeyToIndex;
    }

    public static /* synthetic */ Object[][] access$400(DenseImmutableTable r100) {
        return r100.values;
    }

    public static /* synthetic */ int[] access$500(DenseImmutableTable r100) {
        return r100.columnCounts;
    }

    public static /* synthetic */ ImmutableMap access$600(DenseImmutableTable r100) {
        return r100.rowKeyToIndex;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public t2.a<R, C, V> getCell(int r100) {
        int r101 = this.cellRowIndices[r100];
        int r102 = this.cellColumnIndices[r100];
        R r103 = rowKeySet().asList().get(r101);
        C r104 = columnKeySet().asList().get(r102);
        V r105 = this.values[r101][r102];
        Objects.requireNonNull(r105);
        return ImmutableTable.cellOf(r103, r104, r105);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int r100) {
        V r101 = this.values[this.cellRowIndices[r100]][this.cellColumnIndices[r100]];
        Objects.requireNonNull(r101);
        return r101;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V get(@CheckForNull Object r100, @CheckForNull Object r101) {
        Integer r102 = this.rowKeyToIndex.get(r100);
        Integer r103 = this.columnKeyToIndex.get(r101);
        if (r102 == null) goto L7;
        if (r103 == null) goto L7;
        return this.values[r102.intValue()][r103.intValue()];
    L7:
        return null;
    }

    public DenseImmutableTable(ImmutableList<t2.a<R, C, V>> r110, ImmutableSet<R> r111, ImmutableSet<C> r112) {
        int r100 = 0;
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r111.size(), r112.size()}));
        ImmutableMap<R, Integer> r113 = Maps.d(r111);
        this.rowKeyToIndex = r113;
        ImmutableMap<C, Integer> r114 = Maps.d(r112);
        this.columnKeyToIndex = r114;
        this.rowCounts = new int[r113.size()];
        this.columnCounts = new int[r114.size()];
        int[] r115 = new int[r110.size()];
        int[] r116 = new int[r110.size()];
    L4:
        if (r100 >= r110.size()) goto L6;
        t2.a<R, C, V> r101 = r110.get(r100);
        R r102 = r101.getRowKey();
        C r103 = r101.getColumnKey();
        Integer r104 = this.rowKeyToIndex.get(r102);
        Objects.requireNonNull(r104);
        int r105 = r104.intValue();
        Integer r106 = this.columnKeyToIndex.get(r103);
        Objects.requireNonNull(r106);
        int r107 = r106.intValue();
        checkNoDuplicate(r102, r103, this.values[r105][r107], r101.getValue());
        this.values[r105][r107] = r101.getValue();
        int[] r108 = this.rowCounts;
        r108[r105] = r108[r105] + 1;
        int[] r109 = this.columnCounts;
        r109[r107] = r109[r107] + 1;
        r115[r100] = r105;
        r116[r100] = r107;
        r100 = r100 + 1;
        goto L4
    L6:
        this.cellRowIndices = r115;
        this.cellColumnIndices = r116;
        this.rowMap = new RowMap(this, null);
        this.columnMap = new ColumnMap(this, null);
    }
}
