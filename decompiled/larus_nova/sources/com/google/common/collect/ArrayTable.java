package com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    public transient ArrayTable<R, C, V>.e f274947c;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    public transient ArrayTable<R, C, V>.g f274948d;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    public class a extends com.google.common.collect.a<t2.a<R, C, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayTable f274949c;

        @Override // com.google.common.collect.a
        public final Object a(int r100) {
            return ArrayTable.access$000(this.f274949c, r100);
        }

        public a(ArrayTable r100, int r101) {
            this.f274949c = r100;
            super(r101, 0);
        }
    }

    public class b extends com.google.common.collect.a<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayTable f274950c;

        @Override // com.google.common.collect.a
        @CheckForNull
        public final V a(int r100) {
            return (V) ArrayTable.access$800(this.f274950c, r100);
        }

        public b(ArrayTable r100, int r101) {
            this.f274950c = r100;
            super(r101, 0);
        }
    }

    public static abstract class c<K, V> extends Maps.h<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<K, Integer> f274951a;

        public class a extends com.google.common.collect.a<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f274952c;

            @Override // com.google.common.collect.a
            public final Object a(int r100) {
                c r101 = this.f274952c;
                com.google.common.base.m.j(r100, r101.size());
                return new k(r101, r100);
            }

            public a(c r100, int r101) {
                this.f274952c = r100;
                super(r101, 0);
            }
        }

        public abstract String b();

        @ParametricNullness
        public abstract V c(int r100);

        @ParametricNullness
        public abstract V d(int r100, @ParametricNullness V r101);

        @Override // com.google.common.collect.Maps.h
        public final Iterator<Map.Entry<K, V>> a() {
            return new a(this, size());
        }

        @Override // com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            return this.f274951a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set<K> keySet() {
            return this.f274951a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f274951a.size();
        }

        public c(ImmutableMap r100) {
            this.f274951a = r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return this.f274951a.containsKey(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V get(@CheckForNull Object r100) {
            Integer r101 = this.f274951a.get(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return c(r101.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V remove(@CheckForNull Object r100) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(K r100, @ParametricNullness V r101) {
            Integer r102 = this.f274951a.get(r100);
            if (r102 == null) goto L7;
            return d(r102.intValue(), r101);
        L7:
            throw new IllegalArgumentException(b() + " " + r100 + " not in " + this.f274951a.keySet());
        }
    }

    public class d extends c<R, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayTable f274954c;

        @Override // com.google.common.collect.ArrayTable.c
        public final String b() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.c
        @CheckForNull
        public final V c(int r100) {
            return (V) this.f274954c.at(r100, this.f274953b);
        }

        public d(ArrayTable r100, int r101) {
            this.f274954c = r100;
            super(ArrayTable.access$300(r100));
            this.f274953b = r101;
        }

        @Override // com.google.common.collect.ArrayTable.c
        @CheckForNull
        public final V d(int r100, @CheckForNull V r101) {
            return (V) this.f274954c.set(r100, this.f274953b, r101);
        }
    }

    public class e extends c<C, Map<R, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayTable f274955b;

        @Override // com.google.common.collect.ArrayTable.c
        public final String b() {
            return "Column";
        }

        public e(ArrayTable r100) {
            this.f274955b = r100;
            super(ArrayTable.access$600(r100));
        }

        @Override // com.google.common.collect.ArrayTable.c
        public final Object c(int r100) {
            return new d(this.f274955b, r100);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public final Object d(int r100, Object r101) {
            Map r102 = (Map) r101;
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object put(Object r100, Object r101) {
            Map r102 = (Map) r101;
            throw new UnsupportedOperationException();
        }
    }

    public class f extends c<C, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayTable f274957c;

        @Override // com.google.common.collect.ArrayTable.c
        public final String b() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.c
        @CheckForNull
        public final V c(int r100) {
            return (V) this.f274957c.at(this.f274956b, r100);
        }

        public f(ArrayTable r100, int r101) {
            this.f274957c = r100;
            super(ArrayTable.access$600(r100));
            this.f274956b = r101;
        }

        @Override // com.google.common.collect.ArrayTable.c
        @CheckForNull
        public final V d(int r100, @CheckForNull V r101) {
            return (V) this.f274957c.set(this.f274956b, r100, r101);
        }
    }

    public class g extends c<R, Map<C, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayTable f274958b;

        @Override // com.google.common.collect.ArrayTable.c
        public final String b() {
            return "Row";
        }

        public g(ArrayTable r100) {
            this.f274958b = r100;
            super(ArrayTable.access$300(r100));
        }

        @Override // com.google.common.collect.ArrayTable.c
        public final Object c(int r100) {
            return new f(this.f274958b, r100);
        }

        @Override // com.google.common.collect.ArrayTable.c
        public final Object d(int r100, Object r101) {
            Map r102 = (Map) r101;
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.c, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object put(Object r100, Object r101) {
            Map r102 = (Map) r101;
            throw new UnsupportedOperationException();
        }
    }

    public ArrayTable() {
        throw null;
    }

    @Override // com.google.common.collect.i
    public Iterator<t2.a<R, C, V>> cellIterator() {
        return new a(this, size());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.t2
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.e r100 = this.f274947c;
        if (r100 != null) goto L6;
        ArrayTable<R, C, V>.e r101 = new e(this);
        this.f274947c = r101;
        return r101;
    L6:
        return r100;
    }

    public void eraseAll() {
        V[][] r100 = this.array;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Arrays.fill(r100[r102], null);
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean isEmpty() {
        if (this.rowList.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.columnList.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.t2
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.g r100 = this.f274948d;
        if (r100 != null) goto L6;
        ArrayTable<R, C, V>.g r101 = new g(this);
        this.f274948d = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.t2
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @Override // com.google.common.collect.i
    public Iterator<V> valuesIterator() {
        return new b(this, size());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public Set<t2.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public Collection<V> values() {
        return super.values();
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    public ArrayTable(ArrayTable<R, C, V> r100) {
        ImmutableList<R> r101 = r100.rowList;
        this.rowList = r101;
        ImmutableList<C> r102 = r100.columnList;
        this.columnList = r102;
        this.rowKeyToIndex = r100.rowKeyToIndex;
        this.columnKeyToIndex = r100.columnKeyToIndex;
        V[][] r103 = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r101.size(), r102.size()}));
        this.array = r103;
        int r104 = 0;
    L4:
        if (r104 >= this.rowList.size()) goto L6;
        V[] r105 = r100.array[r104];
        System.arraycopy(r105, 0, r103[r104], 0, r105.length);
        r104 = r104 + 1;
        goto L4
    }

    public static /* synthetic */ ImmutableList access$100(ArrayTable r100) {
        return r100.columnList;
    }

    public static /* synthetic */ ImmutableList access$200(ArrayTable r100) {
        return r100.rowList;
    }

    public static /* synthetic */ ImmutableMap access$300(ArrayTable r100) {
        return r100.rowKeyToIndex;
    }

    public static /* synthetic */ ImmutableMap access$600(ArrayTable r100) {
        return r100.columnKeyToIndex;
    }

    public static <R, C, V> ArrayTable<R, C, V> create(t2<R, C, ? extends V> r100) {
        if ((r100 instanceof ArrayTable) == true) goto L7;
        ArrayTable<R, C, V> r101 = new ArrayTable(r100.rowKeySet(), r100.columnKeySet());
        r101.putAll(r100);
        return r101;
    L7:
        return new ArrayTable((ArrayTable) r100);
    }

    @Override // com.google.common.collect.t2
    public Map<R, V> column(C r100) {
        r100.getClass();
        Integer r101 = this.columnKeyToIndex.get(r100);
        if (r101 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new d(this, r101.intValue());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsColumn(@CheckForNull Object r100) {
        return this.columnKeyToIndex.containsKey(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsRow(@CheckForNull Object r100) {
        return this.rowKeyToIndex.containsKey(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsValue(@CheckForNull Object r100) {
        V[][] r101 = this.array;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        V[] r104 = r101[r103];
        int r105 = r104.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L11;
        if (com.google.common.base.k.a(r100, r104[r106]) == true) goto L8;
        r106 = r106 + 1;
        goto L5
    L8:
        return true;
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public void putAll(t2<? extends R, ? extends C, ? extends V> r100) {
        super.putAll(r100);
    }

    @Override // com.google.common.collect.t2
    public Map<C, V> row(R r100) {
        r100.getClass();
        Integer r101 = this.rowKeyToIndex.get(r100);
        if (r101 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new f(this, r101.intValue());
    }

    public V[][] toArray(Class<V> r100) {
        V[][] r101 = (V[][]) ((Object[][]) Array.newInstance(r100, new int[]{this.rowList.size(), this.columnList.size()}));
        int r102 = 0;
    L4:
        if (r102 >= this.rowList.size()) goto L6;
        V[] r103 = this.array[r102];
        System.arraycopy(r103, 0, r101[r102], 0, r103.length);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public ArrayTable(Iterable<? extends R> r100, Iterable<? extends C> r101) {
        ImmutableList<R> r102 = ImmutableList.copyOf(r100);
        this.rowList = r102;
        ImmutableList<C> r103 = ImmutableList.copyOf(r101);
        this.columnList = r103;
        if (r102.isEmpty() != r103.isEmpty()) goto L5;
        boolean r104 = true;
    L6:
        com.google.common.base.m.b(r104);
        this.rowKeyToIndex = Maps.d(r102);
        this.columnKeyToIndex = Maps.d(r103);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r102.size(), r103.size()}));
        eraseAll();
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static t2.a access$000(ArrayTable r100, int r101) {
        r100.getClass();
        return new j(r100, r101);
    }

    public static Object access$800(ArrayTable r100, int r101) {
        return r100.at(r101 / r100.columnList.size(), r101 % r100.columnList.size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> r100, Iterable<? extends C> r101) {
        return new ArrayTable(r100, r101);
    }

    @CheckForNull
    public V at(int r100, int r101) {
        com.google.common.base.m.j(r100, this.rowList.size());
        com.google.common.base.m.j(r101, this.columnList.size());
        return this.array[r100][r101];
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (containsRow(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (containsColumn(r101) == false) goto L7;
        return true;
    }

    @CheckForNull
    public V erase(@CheckForNull Object r100, @CheckForNull Object r101) {
        Integer r102 = this.rowKeyToIndex.get(r100);
        Integer r103 = this.columnKeyToIndex.get(r101);
        if (r102 == null) goto L8;
        if (r103 == null) goto L8;
        return set(r102.intValue(), r103.intValue(), null);
    L8:
        return null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V get(@CheckForNull Object r100, @CheckForNull Object r101) {
        Integer r102 = this.rowKeyToIndex.get(r100);
        Integer r103 = this.columnKeyToIndex.get(r101);
        if (r102 == null) goto L7;
        if (r103 == null) goto L7;
        return at(r102.intValue(), r103.intValue());
    L7:
        return null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V put(R r100, C r101, @CheckForNull V r102) {
        r100.getClass();
        r101.getClass();
        Integer r103 = this.rowKeyToIndex.get(r100);
        boolean r104 = true;
        if (r103 == null) goto L5;
        boolean r105 = true;
    L6:
        com.google.common.base.m.i(r105, "Row %s not in %s", r100, this.rowList);
        Integer r106 = this.columnKeyToIndex.get(r101);
        if (r106 != null) goto L10;
        r104 = false;
    L10:
        com.google.common.base.m.i(r104, "Column %s not in %s", r101, this.columnList);
        return set(r103.intValue(), r106.intValue(), r102);
    L5:
        r105 = false;
        goto L6
    }

    @CheckForNull
    public V set(int r100, int r101, @CheckForNull V r102) {
        com.google.common.base.m.j(r100, this.rowList.size());
        com.google.common.base.m.j(r101, this.columnList.size());
        V[] r103 = this.array[r100];
        V r104 = r103[r101];
        r103[r101] = r102;
        return r104;
    }
}
