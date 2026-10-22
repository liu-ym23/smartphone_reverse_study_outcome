package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    public final class CellSet extends IndexedImmutableSet<t2.a<R, C, V>> {
        final /* synthetic */ RegularImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof t2.a) == false) goto L10;
            t2.a r101 = (t2.a) r100;
            Object r102 = this.this$0.get(r101.getRowKey(), r101.getColumnKey());
            if (r102 != null) goto L7;
            return false;
        L7:
            if (r102.equals(r101.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public t2.a<R, C, V> get(int r100) {
            return this.this$0.getCell(r100);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        public CellSet(RegularImmutableTable r100, a r101) {
            this.this$0 = r100;
        }
    }

    public final class Values extends ImmutableList<V> {
        final /* synthetic */ RegularImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.List
        public V get(int r100) {
            return (V) this.this$0.getValue(r100);
        }

        public Values(RegularImmutableTable r100, a r101) {
            this.this$0 = r100;
        }
    }

    public static /* synthetic */ class a {
    }

    public abstract t2.a<R, C, V> getCell(int r100);

    public abstract V getValue(int r100);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t2
    public abstract /* synthetic */ int size();

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public final ImmutableSet<t2.a<R, C, V>> createCellSet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public final ImmutableCollection<V> createValues() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return new Values(this, null);
    }

    public RegularImmutableTable() {
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<t2.a<R, C, V>> r100) {
        return a(r100, null, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> a(Iterable<t2.a<R, C, V>> r100, @CheckForNull Comparator<? super R> r101, @CheckForNull Comparator<? super C> r102) {
        LinkedHashSet r103 = new LinkedHashSet();
        LinkedHashSet r104 = new LinkedHashSet();
        ImmutableList r105 = ImmutableList.copyOf(r100);
        Iterator<t2.a<R, C, V>> r106 = r100.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        t2.a<R, C, V> r107 = r106.next();
        r103.add(r107.getRowKey());
        r104.add(r107.getColumnKey());
        goto L4
    L6:
        if (r101 != null) goto L8;
        ImmutableSet r108 = ImmutableSet.copyOf(r103);
    L9:
        if (r102 != null) goto L11;
        ImmutableSet r109 = ImmutableSet.copyOf(r104);
    L13:
        return forOrderedComponents(r105, r108, r109);
    L11:
        r109 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r102, r104));
        goto L13
    L8:
        r108 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r101, r103));
        goto L9
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<t2.a<R, C, V>> r100, @CheckForNull final Comparator<? super R> r101, @CheckForNull final Comparator<? super C> r102) {
        r100.getClass();
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
    L7:
        return a(r100, r101, r102);
    L5:
        Collections.sort(r100, new h2(r101, r102));
        goto L7
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<t2.a<R, C, V>> r100, ImmutableSet<R> r101, ImmutableSet<C> r102) {
        if (r100.size() <= ((((long) r101.size()) * ((long) r102.size())) / 2)) goto L6;
        return new DenseImmutableTable(r100, r101, r102);
    L6:
        return new SparseImmutableTable(r100, r101, r102);
    }

    public final void checkNoDuplicate(R r100, C r101, @CheckForNull V r102, V r103) {
        if (r102 != null) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(com.google.common.base.s.a("Duplicate key: (row=%s, column=%s), values: [%s, %s].", new Object[]{r100, r101, r103, r102}));
    L5:
        r104 = false;
        goto L6
    }
}
