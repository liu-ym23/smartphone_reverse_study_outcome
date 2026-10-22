package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Ordering f275120h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ImmutableSortedMap<Comparable, Object> f275121i = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient RegularImmutableSortedSet<K> f275122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient ImmutableList<V> f275123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @CheckForNull
    public final transient ImmutableSortedMap<K, V> f275124g;

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public SerializedForm(ImmutableSortedMap<K, V> r100) {
            super(r100);
            this.comparator = r100.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public a<K, V> makeBuilder(int r100) {
            return new a(this.comparator);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public /* bridge */ /* synthetic */ ImmutableMap.b makeBuilder(int r100) {
            return makeBuilder(r100);
        }
    }

    public static class a<K, V> extends ImmutableMap.b<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public transient Object[] f275125d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public transient Object[] f275126e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Comparator<? super K> f275127f;

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap c() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        public final ImmutableSortedMap<K, V> i() {
            int r100 = this.f275072b;
            if (r100 == 0) goto L21;
            int r101 = 0;
            if (r100 == 1) goto L18;
            Object[] r102 = Arrays.copyOf(this.f275125d, r100);
            Arrays.sort(r102, this.f275127f);
            Object[] r103 = new Object[this.f275072b];
        L8:
            if (r101 >= this.f275072b) goto L17;
            if (r101 <= 0) goto L15;
            int r104 = r101 - 1;
            if (this.f275127f.compare(r102[r104], r102[r101]) != 0) goto L15;
            throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + r102[r104] + " and " + r102[r101]);
        L15:
            Object r105 = this.f275125d[r101];
            Objects.requireNonNull(r105);
            int r106 = Arrays.binarySearch(r102, r105, this.f275127f);
            Object r107 = this.f275126e[r101];
            Objects.requireNonNull(r107);
            r103[r106] = r107;
            r101 = r101 + 1;
            goto L8
        L17:
            return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.asImmutableList(r102), this.f275127f), ImmutableList.asImmutableList(r103));
        L18:
            Comparator<? super K> r108 = this.f275127f;
            Object r109 = this.f275125d[0];
            Objects.requireNonNull(r109);
            Object r110 = this.f275126e[0];
            Objects.requireNonNull(r110);
            return ImmutableSortedMap.access$000(r108, r109, r110);
        L21:
            return ImmutableSortedMap.emptyMap(this.f275127f);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap a() {
            return i();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final /* bridge */ /* synthetic */ ImmutableMap d() {
            return i();
        }

        public a(Comparator<? super K> r100) {
            super(4);
            r100.getClass();
            this.f275127f = r100;
            this.f275125d = new Object[4];
            this.f275126e = new Object[4];
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final void f(Map.Entry r100) {
            super.f(r100);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap.b g(Iterable r100) {
            super.g(r100);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final void h(ImmutableMap r100) {
            super.g(r100.entrySet());
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap.b e(Object r100, Object r101) {
            int r102 = this.f275072b + 1;
            Object[] r103 = this.f275125d;
            if (r102 <= r103.length) goto L5;
            int r104 = ImmutableCollection.b.a(r103.length, r102);
            this.f275125d = Arrays.copyOf(this.f275125d, r104);
            this.f275126e = Arrays.copyOf(this.f275126e, r104);
        L5:
            o.a(r100, r101);
            Object[] r105 = this.f275125d;
            int r106 = this.f275072b;
            r105[r106] = r100;
            this.f275126e[r106] = r101;
            this.f275072b = r106 + 1;
            return this;
        }
    }

    public static <K extends Comparable<?>, V> a<K, V> naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <K extends Comparable<?>, V> a<K, V> reverseOrder() {
        return new a(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.f275122e.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> r100 = this.f275124g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (isEmpty() == false) goto L9;
        return emptyMap(Ordering.from(comparator()).reverse());
    L9:
        return new ImmutableSortedMap((RegularImmutableSortedSet) this.f275122e.descendingSet(), this.f275123f.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        if (this.f275122e.isPartialView() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f275123f.isPartialView() == true) goto L8;
        return false;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f275123f.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    static {
        f275120h = Ordering.natural();
        f275121i = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new C1EntrySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableSet keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet navigableKeySet() {
        return navigableKeySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) f275121i;
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        return descendingMap();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.f275122e;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.f275123f;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f275122e;
    }

    public static /* synthetic */ RegularImmutableSortedSet access$100(ImmutableSortedMap r100) {
        return r100.f275122e;
    }

    public static /* synthetic */ ImmutableList access$200(ImmutableSortedMap r100) {
        return r100.f275123f;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> c(Map.Entry<K, V>... r100) {
        return b(Ordering.natural(), false, r100, r100.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
        return copyOf(r100, f275120h);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> r100) {
        Comparator<? super K> r101 = r100.comparator();
        if (r101 != null) goto L6;
        r101 = f275120h;
    L6:
        if ((r100 instanceof ImmutableSortedMap) == false) goto L10;
        ImmutableSortedMap<K, V> r102 = (ImmutableSortedMap) r100;
        if (r102.isPartialView() == true) goto L10;
        return r102;
    L10:
        Set<Map.Entry<K, ? extends V>> r103 = r100.entrySet();
        Map.Entry<?, ?>[] r104 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r103 instanceof Collection) == false) goto L13;
        Set<Map.Entry<K, ? extends V>> r105 = r103;
    L14:
        Map.Entry[] r106 = (Map.Entry[]) r105.toArray(r104);
        return b(r101, true, r106, r106.length);
    L13:
        r105 = Lists.c(r103.iterator());
        goto L14
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> r100) {
        if (Ordering.natural().equals(r100) == false) goto L7;
        return of();
    L7:
        return new ImmutableSortedMap(ImmutableSortedSet.emptySet(r100), ImmutableList.of());
    }

    public static <K, V> a<K, V> orderedBy(Comparator<K> r100) {
        return new a(r100);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K r100) {
        return tailMap(r100, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(K r100) {
        return (K) Maps.e(ceilingEntry(r100));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(K r100) {
        return headMap(r100, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(K r100) {
        return (K) Maps.e(floorEntry(r100));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        int r101 = this.f275122e.indexOf(r100);
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        return this.f275123f.get(r101);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K r100) {
        return headMap(r100, false);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(K r100) {
        return tailMap(r100, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(K r100) {
        return (K) Maps.e(higherEntry(r100));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K r100) {
        return headMap(r100, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(K r100) {
        return (K) Maps.e(lowerEntry(r100));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K r100) {
        return tailMap(r100, true);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r100) {
        return a(r100, f275120h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object r100) {
        return headMap(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object r100) {
        return tailMap(r100);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> r100, ImmutableList<V> r101) {
        this(r100, r101, null);
    }

    public static <K, V> ImmutableSortedMap<K, V> a(Map<? extends K, ? extends V> r100, Comparator<? super K> r101) {
        if ((r100 instanceof SortedMap) == false) goto L10;
        Comparator<? super K> r102 = ((SortedMap) r100).comparator();
        if (r102 == null) goto L7;
        boolean r103 = r101.equals(r102);
    L11:
        if (r103 == true) goto L13;
    L17:
        Set<Map.Entry<? extends K, ? extends V>> r104 = r100.entrySet();
        Map.Entry<?, ?>[] r105 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r104 instanceof Collection) == false) goto L20;
        Set<Map.Entry<? extends K, ? extends V>> r106 = r104;
    L21:
        Map.Entry[] r107 = (Map.Entry[]) r106.toArray(r105);
        return b(r101, r103, r107, r107.length);
    L20:
        r106 = Lists.c(r104.iterator());
        goto L21
    L13:
        if ((r100 instanceof ImmutableSortedMap) == false) goto L17;
        ImmutableSortedMap<K, V> r108 = (ImmutableSortedMap) r100;
        if (r108.isPartialView() == true) goto L17;
        return r108;
    L7:
        if (r101 != f275120h) goto L10;
        r103 = true;
    L10:
        r103 = false;
        goto L11
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100, Comparator<? super K> r101) {
        r101.getClass();
        Map.Entry<?, ?>[] r102 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r100 instanceof Collection) == false) goto L5;
        Collection r103 = (Collection) r100;
    L6:
        Map.Entry[] r104 = (Map.Entry[]) r103.toArray(r102);
        return b(r101, false, r104, r104.length);
    L5:
        r103 = Lists.c(r100.iterator());
        goto L6
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101) {
        return e(Ordering.natural(), r100, r101);
    }

    public final ImmutableSortedMap<K, V> d(int r100, int r101) {
        if (r100 == 0) goto L4;
    L6:
        if (r100 != r101) goto L10;
        return emptyMap(comparator());
    L10:
        return new ImmutableSortedMap(this.f275122e.getSubSet(r100, r101), this.f275123f.subList(r100, r101));
    L4:
        if (r101 != size()) goto L6;
        return this;
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K r100, boolean r101) {
        RegularImmutableSortedSet<K> r102 = this.f275122e;
        r100.getClass();
        return d(0, r102.headIndex(r100, r101));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K r100, K r101) {
        return subMap(r100, true, r101, false);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K r100, boolean r101) {
        RegularImmutableSortedSet<K> r102 = this.f275122e;
        r100.getClass();
        return d(r102.tailIndex(r100, r101), size());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r100, Comparator<? super K> r101) {
        r101.getClass();
        return a(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object r100, boolean r101) {
        return headMap(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap subMap(Object r100, Object r101) {
        return subMap(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r100, boolean r101) {
        return tailMap(r100, r101);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> r100, ImmutableList<V> r101, @CheckForNull ImmutableSortedMap<K, V> r102) {
        this.f275122e = r100;
        this.f275123f = r101;
        this.f275124g = r102;
    }

    public static /* synthetic */ ImmutableSortedMap access$000(Comparator r100, Object r101, Object r102) {
        return e(r100, r101, r102);
    }

    public static <K, V> ImmutableSortedMap<K, V> e(Comparator<? super K> r100, K r101, V r102) {
        ImmutableList r103 = ImmutableList.of(r101);
        r100.getClass();
        return new ImmutableSortedMap(new RegularImmutableSortedSet(r103, r100), ImmutableList.of(r102));
    }

    public static <K, V> ImmutableSortedMap<K, V> b(final Comparator<? super K> r100, boolean r110, Map.Entry<K, V>[] r111, int r112) {
        if (r112 == 0) goto L21;
        int r101 = 0;
        if (r112 == 1) goto L18;
        Object[] r102 = new Object[r112];
        Object[] r103 = new Object[r112];
        if (r110 == false) goto L9;
    L7:
        if (r101 >= r112) goto L17;
        Map.Entry<K, V> r113 = r111[r101];
        Objects.requireNonNull(r113);
        Map.Entry<K, V> r114 = r113;
        K r104 = r114.getKey();
        V r115 = r114.getValue();
        o.a(r104, r115);
        r102[r101] = r104;
        r103[r101] = r115;
        r101 = r101 + 1;
    L17:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.asImmutableList(r102), r100), ImmutableList.asImmutableList(r103));
    L9:
        Arrays.sort(r111, 0, r112, new w0(r100));
        Map.Entry<K, V> r116 = r111[0];
        Objects.requireNonNull(r116);
        Map.Entry<K, V> r117 = r116;
        Object r105 = r117.getKey();
        r102[0] = r105;
        V r118 = r117.getValue();
        r103[0] = r118;
        o.a(r102[0], r118);
        int r119 = 1;
    L10:
        if (r119 >= r112) goto L17;
        Map.Entry<K, V> r106 = r111[r119 - 1];
        Objects.requireNonNull(r106);
        Map.Entry<K, V> r107 = r106;
        Map.Entry<K, V> r108 = r111[r119];
        Objects.requireNonNull(r108);
        Map.Entry<K, V> r109 = r108;
        Object r120 = r109.getKey();
        V r121 = r109.getValue();
        o.a(r120, r121);
        r102[r119] = r120;
        r103[r119] = r121;
        if (r100.compare(r105, r120) == 0) goto L14;
        boolean r122 = true;
    L15:
        ImmutableMap.checkNoConflict(r122, "key", r107, r109);
        r119 = r119 + 1;
        r105 = r120;
        goto L10
    L14:
        r122 = false;
        goto L15
    L18:
        Map.Entry<K, V> r123 = r111[0];
        Objects.requireNonNull(r123);
        Map.Entry<K, V> r124 = r123;
        return e(r100, r124.getKey(), r124.getValue());
    L21:
        return emptyMap(r100);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K r100, boolean r101, K r102, boolean r103) {
        r100.getClass();
        r102.getClass();
        if (comparator().compare(r100, r102) > 0) goto L5;
        boolean r104 = true;
    L6:
        com.google.common.base.m.i(r104, "expected fromKey <= toKey but %s > %s", r100, r102);
        return headMap(r102, r103).tailMap(r100, r101);
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object r100, boolean r101, Object r102, boolean r103) {
        return subMap(r100, r101, r102, r103);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r107) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r107)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r107, Comparable r110, Object r111) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r107), ImmutableMap.entryOf(r110, r111)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r107, Comparable r110, Object r111, Comparable r112, Object r113) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r107), ImmutableMap.entryOf(r110, r111), ImmutableMap.entryOf(r112, r113)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r107, Comparable r110, Object r111, Comparable r112, Object r113, Comparable r114, Object r115) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r107), ImmutableMap.entryOf(r110, r111), ImmutableMap.entryOf(r112, r113), ImmutableMap.entryOf(r114, r115)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r110, Comparable r111, Object r112, Comparable r113, Object r114, Comparable r115, Object r116, Comparable r117, Object r118) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r110), ImmutableMap.entryOf(r111, r112), ImmutableMap.entryOf(r113, r114), ImmutableMap.entryOf(r115, r116), ImmutableMap.entryOf(r117, r118)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r110, Comparable r111, Object r112, Comparable r113, Object r114, Comparable r115, Object r116, Comparable r117, Object r118, Comparable r119, Object r210) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r110), ImmutableMap.entryOf(r111, r112), ImmutableMap.entryOf(r113, r114), ImmutableMap.entryOf(r115, r116), ImmutableMap.entryOf(r117, r118), ImmutableMap.entryOf(r119, r210)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r100, Object r101, Comparable r102, Object r103, Comparable r104, Object r105, Comparable r106, Object r110, Comparable r111, Object r112, Comparable r113, Object r114, Comparable r115, Object r116, Comparable r117, Object r118, Comparable r119, Object r210, Comparable r211, Object r212) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r100, r101), ImmutableMap.entryOf(r102, r103), ImmutableMap.entryOf(r104, r105), ImmutableMap.entryOf(r106, r110), ImmutableMap.entryOf(r111, r112), ImmutableMap.entryOf(r113, r114), ImmutableMap.entryOf(r115, r116), ImmutableMap.entryOf(r117, r118), ImmutableMap.entryOf(r119, r210), ImmutableMap.entryOf(r211, r212)});
    }
}
