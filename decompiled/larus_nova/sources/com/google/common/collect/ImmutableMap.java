package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableMap.of or another implementation")
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSet<Map.Entry<K, V>> f275065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSet<K> f275066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableCollection<V> f275067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSetMultimap<K, V> f275068d;

    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        public abstract z2<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        public IteratorBasedImmutableMap() {
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        final /* synthetic */ ImmutableMap this$0;

        public class a extends z2<Map.Entry<K, ImmutableSet<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f275069a;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f275069a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return new v0((Map.Entry) this.f275069a.next());
            }

            public a(z2 r100) {
                this.f275069a = r100;
            }
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return this.this$0.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public z2<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this.this$0.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return this.this$0.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r100) {
            return this.this$0.containsKey(r100);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public ImmutableSet<V> get(@CheckForNull Object r100) {
            Object r101 = this.this$0.get(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return ImmutableSet.of(r101);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r100) {
            return get(r100);
        }

        public MapViewOfValuesAsSingletonSets(ImmutableMap r100, a r101) {
            this.this$0 = r100;
        }
    }

    public static class SerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        /* JADX WARN: Multi-variable type inference failed */
        public final Object legacyReadResolve() {
            Object[] r100 = (Object[]) this.keys;
            Object[] r101 = (Object[]) this.values;
            b<K, V> r102 = makeBuilder(r100.length);
            int r103 = 0;
        L4:
            if (r103 >= r100.length) goto L7;
            r102.e(r100[r103], r101[r103]);
            r103 = r103 + 1;
            goto L4
        L7:
            return r102.d();
        }

        public final Object readResolve() {
            Object r100 = this.keys;
            if ((r100 instanceof ImmutableSet) == false) goto L5;
            ImmutableSet r101 = (ImmutableSet) r100;
            ImmutableCollection r102 = (ImmutableCollection) this.values;
            b<K, V> r103 = makeBuilder(r101.size());
            z2 r104 = r101.iterator();
            z2 r105 = r102.iterator();
        L8:
            if (r104.hasNext() == false) goto L11;
            r103.e(r104.next(), r105.next());
            goto L8
        L11:
            return r103.d();
        L5:
            return legacyReadResolve();
        }

        public SerializedForm(ImmutableMap<K, V> r100) {
            Object[] r101 = new Object[r100.size()];
            Object[] r102 = new Object[r100.size()];
            z2<Map.Entry<K, V>> r103 = r100.entrySet().iterator();
            int r104 = 0;
        L4:
            if (r103.hasNext() == false) goto L6;
            Map.Entry<K, V> r105 = r103.next();
            r101[r104] = r105.getKey();
            r102[r104] = r105.getValue();
            r104 = r104 + 1;
            goto L4
        L6:
            this.keys = r101;
            this.values = r102;
        }

        public b<K, V> makeBuilder(int r100) {
            return new b(r100);
        }
    }

    public class a extends z2<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z2 f275070a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f275070a.hasNext();
        }

        @Override // java.util.Iterator
        public final K next() {
            return (K) ((Map.Entry) this.f275070a.next()).getKey();
        }

        public a(z2 r100) {
            this.f275070a = r100;
        }
    }

    @DoNotMock
    public static class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f275071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f275073c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f275074a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f275075b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f275076c;

            public final IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f275074a + ContainerUtils.KEY_VALUE_DELIMITER + this.f275075b + " and " + this.f275074a + ContainerUtils.KEY_VALUE_DELIMITER + this.f275076c);
            }

            public a(Object r100, Object r101, Object r102) {
                this.f275074a = r100;
                this.f275075b = r101;
                this.f275076c = r102;
            }
        }

        public ImmutableMap<K, V> c() {
            return b(false);
        }

        public ImmutableMap<K, V> d() {
            return b(true);
        }

        public ImmutableMap<K, V> a() {
            return d();
        }

        public b(int r100) {
            this.f275071a = new Object[r100 * 2];
            this.f275072b = 0;
        }

        public final ImmutableMap<K, V> b(boolean r100) {
            if (r100 == false) goto L8;
            a r101 = this.f275073c;
            if (r101 == null) goto L8;
            throw r101.a();
        L8:
            RegularImmutableMap r102 = RegularImmutableMap.create(this.f275072b, this.f275071a, this);
            if (r100 == false) goto L15;
            a r103 = this.f275073c;
            if (r103 == null) goto L15;
            throw r103.a();
        L15:
            return r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void f(Map.Entry r100) {
            e(r100.getKey(), r100.getValue());
        }

        public b<K, V> g(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
            if ((r100 instanceof Collection) == false) goto L7;
            int r101 = (this.f275072b + ((Collection) r100).size()) * 2;
            Object[] r102 = this.f275071a;
            if (r101 <= r102.length) goto L7;
            this.f275071a = Arrays.copyOf(r102, ImmutableCollection.b.a(r102.length, r101));
        L7:
            Iterator<? extends Map.Entry<? extends K, ? extends V>> r103 = r100.iterator();
        L9:
            if (r103.hasNext() == false) goto L11;
            f(r103.next());
            goto L9
        L11:
            return this;
        }

        public void h(ImmutableMap r100) {
            g(r100.entrySet());
        }

        public b<K, V> e(K r100, V r101) {
            int r102 = (this.f275072b + 1) * 2;
            Object[] r103 = this.f275071a;
            if (r102 <= r103.length) goto L5;
            this.f275071a = Arrays.copyOf(r103, ImmutableCollection.b.a(r103.length, r102));
        L5:
            o.a(r100, r101);
            Object[] r104 = this.f275071a;
            int r105 = this.f275072b;
            int r106 = r105 * 2;
            r104[r106] = r100;
            r104[r106 + 1] = r101;
            this.f275072b = r105 + 1;
            return this;
        }
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    public ImmutableMap() {
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object r100);

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public static <K, V> b<K, V> builder() {
        return new b(4);
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> r100 = this.f275065a;
        if (r100 != null) goto L6;
        ImmutableSet<Map.Entry<K, V>> r101 = createEntrySet();
        this.f275065a = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> r100 = this.f275066b;
        if (r100 != null) goto L6;
        ImmutableSet<K> r101 = createKeySet();
        this.f275066b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> r100 = this.f275067c;
        if (r100 != null) goto L6;
        ImmutableCollection<V> r101 = createValues();
        this.f275067c = r101;
        return r101;
    L6:
        return r100;
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty() == true) goto L5;
        ImmutableSetMultimap<K, V> r100 = this.f275068d;
        if (r100 != null) goto L10;
        ImmutableSetMultimap<K, V> r101 = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.f275068d = r101;
        return r101;
    L10:
        return r100;
    L5:
        return ImmutableSetMultimap.of();
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.c(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public z2<K> keyIterator() {
        return new a(entrySet().iterator());
    }

    public String toString() {
        return Maps.i(this);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int r100) {
        o.b(r100, "expectedSize");
        return new b(r100);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r100) {
        if ((r100 instanceof ImmutableMap) == false) goto L10;
        if ((r100 instanceof SortedMap) == true) goto L10;
        ImmutableMap<K, V> r101 = (ImmutableMap) r100;
        if (r101.isPartialView() == true) goto L10;
        return r101;
    L10:
        return copyOf(r100.entrySet());
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r100) {
        return copyOf(Arrays.asList(r100));
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object r100) {
        if (get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object r100) {
        return values().contains(r100);
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if ((r100 instanceof Map) == true) goto L10;
        return false;
    L10:
        return entrySet().equals(((Map) r100).entrySet());
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    public final V remove(@CheckForNull Object r100) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
        if ((r100 instanceof Collection) == false) goto L5;
        int r101 = ((Collection) r100).size();
    L6:
        b r102 = new b(r101);
        r102.g(r100);
        return r102.d();
    L5:
        r101 = 4;
        goto L6
    }

    public static <K, V> Map.Entry<K, V> entryOf(K r100, V r101) {
        o.a(r100, r101);
        return new AbstractMap.SimpleImmutableEntry(r100, r101);
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101) {
        o.a(r100, r101);
        return RegularImmutableMap.create(1, new Object[]{r100, r101});
    }

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object r100, @CheckForNull V r101) {
        V r102 = get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r101;
    }

    @Override // java.util.Map
    @CheckForNull
    public final V put(K r100, V r101) {
        throw new UnsupportedOperationException();
    }

    public static IllegalArgumentException conflictException(String r100, Object r101, Object r102) {
        return new IllegalArgumentException("Multiple entries with same " + r100 + ": " + r101 + " and " + r102);
    }

    public static void checkNoConflict(boolean r100, String r101, Object r102, Object r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw conflictException(r101, r102, r103);
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103) {
        o.a(r100, r101);
        o.a(r102, r103);
        return RegularImmutableMap.create(2, new Object[]{r100, r101, r102, r103});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        return RegularImmutableMap.create(3, new Object[]{r100, r101, r102, r103, r104, r105});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r107);
        return RegularImmutableMap.create(4, new Object[]{r100, r101, r102, r103, r104, r105, r106, r107});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r110, V r111) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r107);
        o.a(r110, r111);
        return RegularImmutableMap.create(5, new Object[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r110, V r111, K r112, V r113) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r107);
        o.a(r110, r111);
        o.a(r112, r113);
        return RegularImmutableMap.create(6, new Object[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r110, V r111, K r112, V r113, K r114, V r115) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r107);
        o.a(r110, r111);
        o.a(r112, r113);
        o.a(r114, r115);
        return RegularImmutableMap.create(7, new Object[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r110, K r111, V r112, K r113, V r114, K r115, V r116, K r117, V r118) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r110);
        o.a(r111, r112);
        o.a(r113, r114);
        o.a(r115, r116);
        o.a(r117, r118);
        return RegularImmutableMap.create(8, new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r110, K r111, V r112, K r113, V r114, K r115, V r116, K r117, V r118, K r119, V r210) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r110);
        o.a(r111, r112);
        o.a(r113, r114);
        o.a(r115, r116);
        o.a(r117, r118);
        o.a(r119, r210);
        return RegularImmutableMap.create(9, new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210});
    }

    public static <K, V> ImmutableMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r110, K r111, V r112, K r113, V r114, K r115, V r116, K r117, V r118, K r119, V r210, K r211, V r212) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r110);
        o.a(r111, r112);
        o.a(r113, r114);
        o.a(r115, r116);
        o.a(r117, r118);
        o.a(r119, r210);
        o.a(r211, r212);
        return RegularImmutableMap.create(10, new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212});
    }
}
