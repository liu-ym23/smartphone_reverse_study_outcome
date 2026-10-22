package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Predicates;
import com.google.common.util.concurrent.Service;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Maps {

    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.m<A, B> bimap;

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }

        public BiMapConverter(com.google.common.collect.m<A, B> r100) {
            r100.getClass();
            this.bimap = r100;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B r100) {
            A r101 = this.bimap.inverse().get(r100);
            if (r101 == null) goto L5;
            boolean r102 = true;
        L6:
            com.google.common.base.m.h(r102, "No non-null mapping present for input: %s", r100);
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.google.common.base.Converter
        public B doForward(A r100) {
            B r101 = this.bimap.get(r100);
            if (r101 == null) goto L5;
            boolean r102 = true;
        L6:
            com.google.common.base.m.h(r102, "No non-null mapping present for input: %s", r100);
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof BiMapConverter) == true) goto L5;
            return false;
        L5:
            return this.bimap.equals(((BiMapConverter) r100).bimap);
        }
    }

    public static abstract enum EntryFunction extends Enum<EntryFunction> implements com.google.common.base.g<Map.Entry<?, ?>, Object> {
        public static final EntryFunction KEY = null;
        public static final EntryFunction VALUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntryFunction[] f275244a = null;

        public EntryFunction() {
            throw null;
        }

        @Override // com.google.common.base.g
        @com.google.common.base.ParametricNullness
        public abstract /* synthetic */ Object apply(@com.google.common.base.ParametricNullness Map.Entry<?, ?> r100);

        static {
            final String r100 = "KEY";
            final int r101 = 0;
            EntryFunction r102 = new AnonymousClass1(r100, r101);
            KEY = r102;
            final String r103 = "VALUE";
            final int r104 = 1;
            EntryFunction r105 = new AnonymousClass2(r103, r104);
            VALUE = r105;
            f275244a = new EntryFunction[]{r102, r105};
        }

        public static EntryFunction[] values() {
            return (EntryFunction[]) f275244a.clone();
        }

        public static EntryFunction valueOf(String r100) {
            return (EntryFunction) r27.a.a(EntryFunction.class, r100);
        }

        public EntryFunction(String r100, int r101, i1 r102) {
            super(r100, r101);
        }
    }

    public static class UnmodifiableBiMap<K, V> extends k0<K, V> implements com.google.common.collect.m<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.m<? extends K, ? extends V> delegate;

        @CheckForNull
        com.google.common.collect.m<V, K> inverse;
        final Map<K, V> unmodifiableMap;

        @CheckForNull
        transient Set<V> values;

        @Override // com.google.common.collect.m
        public com.google.common.collect.m<V, K> inverse() {
            com.google.common.collect.m<V, K> r100 = this.inverse;
            if (r100 != null) goto L6;
            UnmodifiableBiMap r101 = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.k0, java.util.Map
        public Set<V> values() {
            Set<V> r100 = this.values;
            if (r100 != null) goto L6;
            Set<V> r101 = Collections.unmodifiableSet(this.delegate.values());
            this.values = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.k0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.k0, com.google.common.collect.o0
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.k0, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        public UnmodifiableBiMap(com.google.common.collect.m<? extends K, ? extends V> r100, @CheckForNull com.google.common.collect.m<V, K> r101) {
            this.unmodifiableMap = Collections.unmodifiableMap(r100);
            this.delegate = r100;
            this.inverse = r101;
        }

        @Override // com.google.common.collect.m
        @CheckForNull
        public V forcePut(@ParametricNullness K r100, @ParametricNullness V r101) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableNavigableMap<K, V> extends r0<K, V> implements NavigableMap<K, V>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient UnmodifiableNavigableMap<K, V> f275245a;
        private final NavigableMap<K, ? extends V> delegate;

        @Override // com.google.common.collect.r0, com.google.common.collect.k0, com.google.common.collect.o0
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.f(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> r100 = this.f275245a;
            if (r100 != null) goto L6;
            UnmodifiableNavigableMap<K, V> r101 = new UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
            this.f275245a = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return Maps.a(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return Maps.a(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.f(this.delegate.navigableKeySet());
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

        @Override // com.google.common.collect.k0, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // com.google.common.collect.r0, com.google.common.collect.k0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.r0, com.google.common.collect.k0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r100) {
            this.delegate = r100;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K r100) {
            return Maps.a(this.delegate.ceilingEntry(r100));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K r100) {
            return this.delegate.ceilingKey(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K r100) {
            return Maps.a(this.delegate.floorEntry(r100));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K r100) {
            return this.delegate.floorKey(r100);
        }

        @Override // com.google.common.collect.r0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(@ParametricNullness K r100) {
            return headMap(r100, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K r100) {
            return Maps.a(this.delegate.higherEntry(r100));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K r100) {
            return this.delegate.higherKey(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K r100) {
            return Maps.a(this.delegate.lowerEntry(r100));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K r100) {
            return this.delegate.lowerKey(r100);
        }

        @Override // com.google.common.collect.r0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(@ParametricNullness K r100) {
            return tailMap(r100, true);
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r100, UnmodifiableNavigableMap<K, V> r101) {
            this.delegate = r100;
            this.f275245a = r101;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@ParametricNullness K r100, boolean r101) {
            NavigableMap<K, ? extends V> r102 = this.delegate.headMap(r100, r101);
            r102.getClass();
            if ((r102 instanceof UnmodifiableNavigableMap) == false) goto L6;
            return r102;
        L6:
            return new UnmodifiableNavigableMap(r102);
        }

        @Override // com.google.common.collect.r0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(@ParametricNullness K r100, @ParametricNullness K r101) {
            return subMap(r100, true, r101, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@ParametricNullness K r100, boolean r101) {
            NavigableMap<K, ? extends V> r102 = this.delegate.tailMap(r100, r101);
            r102.getClass();
            if ((r102 instanceof UnmodifiableNavigableMap) == false) goto L6;
            return r102;
        L6:
            return new UnmodifiableNavigableMap(r102);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@ParametricNullness K r100, boolean r101, @ParametricNullness K r102, boolean r103) {
            NavigableMap<K, ? extends V> r104 = this.delegate.subMap(r100, r101, r102, r103);
            r104.getClass();
            if ((r104 instanceof UnmodifiableNavigableMap) == false) goto L6;
            return r104;
        L6:
            return new UnmodifiableNavigableMap(r104);
        }
    }

    public static abstract class a<K, V> extends q<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<K, V> f275246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.google.common.base.n<? super Map.Entry<K, V>> f275247e;

        @Override // com.google.common.collect.Maps.q
        public final Collection<V> c() {
            return new g(this, this.f275246d, this.f275247e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r100) {
            if (this.f275246d.containsKey(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (d(r100, this.f275246d.get(r100)) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V get(@CheckForNull Object r100) {
            V r101 = this.f275246d.get(r100);
            if (r101 != null) goto L5;
        L7:
            return null;
        L5:
            if (d(r100, r101) == false) goto L7;
            return r101;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void putAll(Map<? extends K, ? extends V> r100) {
            Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry<? extends K, ? extends V> r102 = r101.next();
            com.google.common.base.m.b(d(r102.getKey(), r102.getValue()));
            goto L4
        L6:
            this.f275246d.putAll(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V remove(@CheckForNull Object r100) {
            if (containsKey(r100) == true) goto L7;
            return null;
        L7:
            return this.f275246d.remove(r100);
        }

        public a(Map<K, V> r100, com.google.common.base.n<? super Map.Entry<K, V>> r101) {
            this.f275246d = r100;
            this.f275247e = r101;
        }

        public final boolean d(@CheckForNull Object r100, @ParametricNullness V r101) {
            return this.f275247e.apply(new ImmutableEntry(r100, r101));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V put(@ParametricNullness K r100, @ParametricNullness V r101) {
            com.google.common.base.m.b(d(r100, r101));
            return this.f275246d.put(r100, r101);
        }
    }

    public static abstract class b<K, V> extends k0<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient Ordering f275248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public transient o1 f275249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public transient j f275250c;

        @Override // com.google.common.collect.k0, com.google.common.collect.o0
        public final Object delegate() {
            return ((com.google.common.collect.e.a) this).f275460d;
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> descendingKeySet() {
            com.google.common.collect.e r100 = ((com.google.common.collect.e.a) this).f275460d;
            r100.getClass();
            return new j(r100);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, V> descendingMap() {
            return ((com.google.common.collect.e.a) this).f275460d;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> firstEntry() {
            return ((com.google.common.collect.e.a) this).f275460d.lastEntry();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public final K firstKey() {
            return (K) ((com.google.common.collect.e.a) this).f275460d.lastKey();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> lastEntry() {
            return ((com.google.common.collect.e.a) this).f275460d.firstEntry();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public final K lastKey() {
            return (K) ((com.google.common.collect.e.a) this).f275460d.firstKey();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> pollFirstEntry() {
            return ((com.google.common.collect.e.a) this).f275460d.pollLastEntry();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> pollLastEntry() {
            return ((com.google.common.collect.e.a) this).f275460d.pollFirstEntry();
        }

        @Override // java.util.SortedMap
        public final Comparator<? super K> comparator() {
            Ordering r100 = this.f275248a;
            if (r100 != null) goto L9;
            Comparator<? super K> r101 = ((com.google.common.collect.e.a) this).f275460d.comparator();
            if (r101 != null) goto L7;
            r101 = Ordering.natural();
        L7:
            Ordering r102 = Ordering.from(r101).reverse();
            this.f275248a = r102;
            return r102;
        L9:
            return r100;
        }

        @Override // com.google.common.collect.k0, java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            o1 r100 = this.f275249b;
            if (r100 != null) goto L6;
            o1 r101 = new o1(this);
            this.f275249b = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> navigableKeySet() {
            j r100 = this.f275250c;
            if (r100 != null) goto L6;
            j r101 = new j(this);
            this.f275250c = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.k0, java.util.Map
        public final Collection<V> values() {
            return new p(this);
        }

        @Override // com.google.common.collect.k0, java.util.Map
        public final Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // com.google.common.collect.o0
        public final String toString() {
            return standardToString();
        }

        public b() {
        }

        @Override // com.google.common.collect.k0, com.google.common.collect.o0
        public final Map<K, V> delegate() {
            return ((com.google.common.collect.e.a) this).f275460d;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> ceilingEntry(@ParametricNullness K r100) {
            return ((com.google.common.collect.e.a) this).f275460d.floorEntry(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K ceilingKey(@ParametricNullness K r100) {
            return (K) ((com.google.common.collect.e.a) this).f275460d.floorKey(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> floorEntry(@ParametricNullness K r100) {
            return ((com.google.common.collect.e.a) this).f275460d.ceilingEntry(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K floorKey(@ParametricNullness K r100) {
            return (K) ((com.google.common.collect.e.a) this).f275460d.ceilingKey(r100);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public final SortedMap<K, V> headMap(@ParametricNullness K r100) {
            return headMap(r100, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> higherEntry(@ParametricNullness K r100) {
            return ((com.google.common.collect.e.a) this).f275460d.lowerEntry(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K higherKey(@ParametricNullness K r100) {
            return (K) ((com.google.common.collect.e.a) this).f275460d.lowerKey(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, V> lowerEntry(@ParametricNullness K r100) {
            return ((com.google.common.collect.e.a) this).f275460d.higherEntry(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K lowerKey(@ParametricNullness K r100) {
            return (K) ((com.google.common.collect.e.a) this).f275460d.higherKey(r100);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public final SortedMap<K, V> tailMap(@ParametricNullness K r100) {
            return tailMap(r100, true);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, V> headMap(@ParametricNullness K r100, boolean r101) {
            return ((com.google.common.collect.e.a) this).f275460d.tailMap(r100, r101).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public final SortedMap<K, V> subMap(@ParametricNullness K r100, @ParametricNullness K r101) {
            return subMap(r100, true, r101, false);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, V> tailMap(@ParametricNullness K r100, boolean r101) {
            return ((com.google.common.collect.e.a) this).f275460d.headMap(r100, r101).descendingMap();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, V> subMap(@ParametricNullness K r100, boolean r101, @ParametricNullness K r102, boolean r103) {
            return ((com.google.common.collect.e.a) this).f275460d.subMap(r102, r103, r100, r101).descendingMap();
        }
    }

    public static abstract class c<K, V> extends Sets.c<Map.Entry<K, V>> {
        public abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L11;
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            Object r103 = Maps.h(a(), r102);
            if (com.google.common.base.k.a(r103, r101.getValue()) == false) goto L12;
            if (r103 == null) goto L8;
        L9:
            return true;
        L8:
            if (a().containsKey(r102) == true) goto L9;
            return false;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r100) {
            if (contains(r100) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof Map.Entry) == true) goto L7;
            return false;
        L7:
            return a().keySet().remove(((Map.Entry) r100).getKey());
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r100) {
            r100.getClass();
            return Sets.d(this, r100);
        L6:
            return Sets.e(this, r100.iterator());
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r100) {
            r100.getClass();
            return super.retainAll(r100);
        L5:
            HashSet r101 = new HashSet(Maps.b(r100.size()));
            Iterator<?> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L14;
            Object r103 = r102.next();
            if (contains(r103) == false) goto L7;
            if ((r103 instanceof Map.Entry) == false) goto L7;
            r101.add(((Map.Entry) r103).getKey());
            goto L7
        L14:
            return a().keySet().retainAll(r101);
        }
    }

    public interface d<K, V1, V2> {
        @ParametricNullness
        Object a(@ParametricNullness Object r100);
    }

    public static class e<K, V> extends a<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Sets.a f275251f;

        public class a extends q0<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f275252a;

            /* JADX INFO: renamed from: com.google.common.collect.Maps$e$a$a, reason: collision with other inner class name */
            public class C3849a extends v2<Map.Entry<K, V>, Map.Entry<K, V>> {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f275253b;

                @Override // com.google.common.collect.v2
                public final Object a(Object r100) {
                    return new p1(this, (Map.Entry) r100);
                }

                public C3849a(a r100, Iterator r101) {
                    this.f275253b = r100;
                    super(r101);
                }
            }

            @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
            public final Object delegate() {
                return this.f275252a.f275251f;
            }

            @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, V>> iterator() {
                return new C3849a(this, this.f275252a.f275251f.iterator());
            }

            @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
            public final Collection delegate() {
                return this.f275252a.f275251f;
            }

            @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
            public final Set<Map.Entry<K, V>> delegate() {
                return this.f275252a.f275251f;
            }

            public a(e r100) {
                this.f275252a = r100;
            }
        }

        public class b extends i<K, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f275254b;

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final Object[] toArray() {
                return Lists.c(iterator()).toArray();
            }

            public b(e r100) {
                this.f275254b = r100;
                super(r100);
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if (this.f275254b.containsKey(r100) == false) goto L6;
                this.f275254b.f275246d.remove(r100);
                return true;
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection<?> r100) {
                e r101 = this.f275254b;
                Map<K, V> r102 = r101.f275246d;
                com.google.common.base.n<? super Map.Entry<K, V>> r103 = r101.f275247e;
                Iterator<Map.Entry<K, V>> r104 = r102.entrySet().iterator();
                boolean r105 = false;
            L4:
                if (r104.hasNext() == false) goto L10;
                Map.Entry<K, V> r106 = r104.next();
                if (r103.apply(r106) == false) goto L4;
                if (r100.contains(r106.getKey()) == false) goto L4;
                r104.remove();
                r105 = true;
                goto L4
            L10:
                return r105;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                e r101 = this.f275254b;
                Map<K, V> r102 = r101.f275246d;
                com.google.common.base.n<? super Map.Entry<K, V>> r103 = r101.f275247e;
                Iterator<Map.Entry<K, V>> r104 = r102.entrySet().iterator();
                boolean r105 = false;
            L4:
                if (r104.hasNext() == false) goto L10;
                Map.Entry<K, V> r106 = r104.next();
                if (r103.apply(r106) == false) goto L4;
                if (r100.contains(r106.getKey()) == true) goto L4;
                r104.remove();
                r105 = true;
                goto L4
            L10:
                return r105;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final <T> T[] toArray(T[] r100) {
                return (T[]) Lists.c(iterator()).toArray(r100);
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<K, V>> a() {
            return new a(this);
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<K> b() {
            return new b(this);
        }

        public e(Map<K, V> r100, com.google.common.base.n<? super Map.Entry<K, V>> r101) {
            super(r100, r101);
            this.f275251f = Sets.b(r100.entrySet(), this.f275247e);
        }
    }

    public static class f<K, V> extends a<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.google.common.base.n<? super K> f275255f;

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<K, V>> a() {
            return Sets.b(this.f275246d.entrySet(), this.f275247e);
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<K> b() {
            return Sets.b(this.f275246d.keySet(), this.f275255f);
        }

        @Override // com.google.common.collect.Maps.a, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            if (this.f275246d.containsKey(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f275255f.apply(r100) == false) goto L7;
            return true;
        }

        public f(Map<K, V> r100, com.google.common.base.n<? super K> r101, com.google.common.base.n<? super Map.Entry<K, V>> r102) {
            super(r100, r102);
            this.f275255f = r101;
        }
    }

    public static final class g<K, V> extends p<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<K, V> f275256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.common.base.n<? super Map.Entry<K, V>> f275257c;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return Lists.c(iterator()).toArray();
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
        public final boolean remove(@CheckForNull Object r100) {
            Iterator<Map.Entry<K, V>> r101 = this.f275256b.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            Map.Entry<K, V> r102 = r101.next();
            if (this.f275257c.apply(r102) == false) goto L4;
            if (com.google.common.base.k.a(r102.getValue(), r100) == false) goto L4;
            r101.remove();
            return true;
        L11:
            return false;
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection<?> r100) {
            Iterator<Map.Entry<K, V>> r101 = this.f275256b.entrySet().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L10;
            Map.Entry<K, V> r103 = r101.next();
            if (this.f275257c.apply(r103) == false) goto L4;
            if (r100.contains(r103.getValue()) == false) goto L4;
            r101.remove();
            r102 = true;
            goto L4
        L10:
            return r102;
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection<?> r100) {
            Iterator<Map.Entry<K, V>> r101 = this.f275256b.entrySet().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L10;
            Map.Entry<K, V> r103 = r101.next();
            if (this.f275257c.apply(r103) == false) goto L4;
            if (r100.contains(r103.getValue()) == true) goto L4;
            r101.remove();
            r102 = true;
            goto L4
        L10:
            return r102;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final <T> T[] toArray(T[] r100) {
            return (T[]) Lists.c(iterator()).toArray(r100);
        }

        public g(Map<K, V> r100, Map<K, V> r101, com.google.common.base.n<? super Map.Entry<K, V>> r102) {
            super(r100);
            this.f275256b = r101;
            this.f275257c = r102;
        }
    }

    public static abstract class h<K, V> extends AbstractMap<K, V> {

        public class a extends c<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f275258a;

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, V>> iterator() {
                return this.f275258a.a();
            }

            @Override // com.google.common.collect.Maps.c
            public final Map<K, V> a() {
                return this.f275258a;
            }

            public a(h r100) {
                this.f275258a = r100;
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            return new a(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.b(a());
        }

        public h() {
        }
    }

    public static class i<K, V> extends Sets.c<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f275259a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i1(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return a().size();
        }

        public Map<K, V> a() {
            return this.f275259a;
        }

        public i(Map<K, V> r100) {
            r100.getClass();
            this.f275259a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            return a().containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r100) {
            if (contains(r100) == false) goto L6;
            a().remove(r100);
            return true;
        L6:
            return false;
        }
    }

    public static class j<K, V> extends k<K, V> implements NavigableSet<K> {
        @Override // com.google.common.collect.Maps.k, com.google.common.collect.Maps.i
        public final Map a() {
            return (NavigableMap) this.f275259a;
        }

        @Override // com.google.common.collect.Maps.k
        public final SortedMap c() {
            return (NavigableMap) this.f275259a;
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> descendingSet() {
            return ((NavigableMap) this.f275259a).descendingKeySet();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K pollFirst() {
            return (K) Maps.e(((NavigableMap) this.f275259a).pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K pollLast() {
            return (K) Maps.e(((NavigableMap) this.f275259a).pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public final Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public j(NavigableMap<K, V> r100) {
            super(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K ceiling(@ParametricNullness K r100) {
            return (K) ((NavigableMap) this.f275259a).ceilingKey(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K floor(@ParametricNullness K r100) {
            return (K) ((NavigableMap) this.f275259a).floorKey(r100);
        }

        @Override // com.google.common.collect.Maps.k, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet<K> headSet(@ParametricNullness K r100) {
            return headSet(r100, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K higher(@ParametricNullness K r100) {
            return (K) ((NavigableMap) this.f275259a).higherKey(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K lower(@ParametricNullness K r100) {
            return (K) ((NavigableMap) this.f275259a).lowerKey(r100);
        }

        @Override // com.google.common.collect.Maps.k, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet<K> tailSet(@ParametricNullness K r100) {
            return tailSet(r100, true);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> headSet(@ParametricNullness K r100, boolean r101) {
            return ((NavigableMap) this.f275259a).headMap(r100, r101).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.k, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet<K> subSet(@ParametricNullness K r100, @ParametricNullness K r101) {
            return subSet(r100, true, r101, false);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> tailSet(@ParametricNullness K r100, boolean r101) {
            return ((NavigableMap) this.f275259a).tailMap(r100, r101).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> subSet(@ParametricNullness K r100, boolean r101, @ParametricNullness K r102, boolean r103) {
            return ((NavigableMap) this.f275259a).subMap(r100, r101, r102, r103).navigableKeySet();
        }
    }

    public static class k<K, V> extends i<K, V> implements SortedSet<K> {
        public SortedMap<K, V> c() {
            return (SortedMap) this.f275259a;
        }

        @Override // com.google.common.collect.Maps.i
        public /* bridge */ /* synthetic */ Map a() {
            return c();
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public final Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final K first() {
            return c().firstKey();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final K last() {
            return c().lastKey();
        }

        public k(SortedMap<K, V> r100) {
            super(r100);
        }

        public SortedSet<K> headSet(@ParametricNullness K r100) {
            return new k(c().headMap(r100));
        }

        public SortedSet<K> tailSet(@ParametricNullness K r100) {
            return new k(c().tailMap(r100));
        }

        public SortedSet<K> subSet(@ParametricNullness K r100, @ParametricNullness K r101) {
            return new k(c().subMap(r100, r101));
        }
    }

    public static class l<K, V1, V2> extends h<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V1> f275260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d<? super K, ? super V1, V2> f275261b;

        @Override // com.google.common.collect.Maps.h
        public final Iterator<Map.Entry<K, V2>> a() {
            Iterator<Map.Entry<K, V1>> r100 = this.f275260a.entrySet().iterator();
            d<? super K, ? super V1, V2> r101 = this.f275261b;
            r101.getClass();
            return new c1(r100, new h1(r101));
        }

        @Override // com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f275260a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set<K> keySet() {
            return this.f275260a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f275260a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Collection<V2> values() {
            return new p(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return this.f275260a.containsKey(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V2 get(@CheckForNull Object r100) {
            V1 r101 = this.f275260a.get(r100);
            if (r101 != null) goto L10;
            if (this.f275260a.containsKey(r100) == true) goto L10;
            return null;
        L10:
            return (V2) this.f275261b.a(r101);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V2 remove(@CheckForNull Object r100) {
            if (this.f275260a.containsKey(r100) == true) goto L7;
            return null;
        L7:
            return (V2) this.f275261b.a(this.f275260a.remove(r100));
        }

        public l(Map<K, V1> r100, d<? super K, ? super V1, V2> r101) {
            r100.getClass();
            this.f275260a = r100;
            r101.getClass();
            this.f275261b = r101;
        }
    }

    public static class m<K, V1, V2> extends l<K, V1, V2> implements SortedMap<K, V2> {
        @Override // java.util.SortedMap
        @CheckForNull
        public final Comparator<? super K> comparator() {
            return ((SortedMap) this.f275260a).comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public final K firstKey() {
            return (K) ((SortedMap) this.f275260a).firstKey();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public final K lastKey() {
            return (K) ((SortedMap) this.f275260a).lastKey();
        }

        @Override // java.util.SortedMap
        public final SortedMap<K, V2> headMap(@ParametricNullness K r100) {
            return new m(((SortedMap) this.f275260a).headMap(r100), this.f275261b);
        }

        @Override // java.util.SortedMap
        public final SortedMap<K, V2> tailMap(@ParametricNullness K r100) {
            return new m(((SortedMap) this.f275260a).tailMap(r100), this.f275261b);
        }

        public m(SortedMap<K, V1> r100, d<? super K, ? super V1, V2> r101) {
            super(r100, r101);
        }

        @Override // java.util.SortedMap
        public final SortedMap<K, V2> subMap(@ParametricNullness K r100, @ParametricNullness K r101) {
            return new m(((SortedMap) this.f275260a).subMap(r100, r101), this.f275261b);
        }
    }

    public static class n<K, V> extends f0<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Map.Entry<K, V>> f275262a;

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new m1(this.f275262a.iterator());
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.o0
        public final Object delegate() {
            return this.f275262a;
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection<Map.Entry<K, V>> delegate() {
            return this.f275262a;
        }

        public n(Collection<Map.Entry<K, V>> r100) {
            this.f275262a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] r100) {
            return (T[]) standardToArray(r100);
        }
    }

    public static class o<K, V> extends n<K, V> implements Set<Map.Entry<K, V>> {
        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.c(this);
        }

        public o(Set<Map.Entry<K, V>> r100) {
            super(r100);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(@CheckForNull Object r100) {
            return Sets.a(this, r100);
        }
    }

    public static class p<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f275263a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f275263a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return this.f275263a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new j1(this.f275263a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f275263a.size();
        }

        public p(Map<K, V> r100) {
            r100.getClass();
            this.f275263a = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275263a.containsValue(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object r100) {
            return super.remove(r100);
        L4:
            Iterator<Map.Entry<K, V>> r101 = this.f275263a.entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L11;
            Map.Entry<K, V> r102 = r101.next();
            if (com.google.common.base.k.a(r100, r102.getValue()) == false) goto L6;
            this.f275263a.remove(r102.getKey());
            return true;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            r100.getClass();
            return super.removeAll(r100);
        L5:
            HashSet r101 = new HashSet();
            Iterator<Map.Entry<K, V>> r102 = this.f275263a.entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<K, V> r103 = r102.next();
            if (r100.contains(r103.getValue()) == false) goto L7;
            r101.add(r103.getKey());
            goto L7
        L12:
            return this.f275263a.keySet().removeAll(r101);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            r100.getClass();
            return super.retainAll(r100);
        L5:
            HashSet r101 = new HashSet();
            Iterator<Map.Entry<K, V>> r102 = this.f275263a.entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<K, V> r103 = r102.next();
            if (r100.contains(r103.getValue()) == false) goto L7;
            r101.add(r103.getKey());
            goto L7
        L12:
            return this.f275263a.keySet().retainAll(r101);
        }
    }

    public static abstract class q<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient Set<Map.Entry<K, V>> f275264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public transient Set<K> f275265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public transient Collection<V> f275266c;

        public abstract Set<Map.Entry<K, V>> a();

        public Set<K> b() {
            return new i(this);
        }

        public Collection<V> c() {
            return new p(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r100 = this.f275264a;
            if (r100 != null) goto L6;
            Set<Map.Entry<K, V>> r101 = a();
            this.f275264a = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> r100 = this.f275265b;
            if (r100 != null) goto L6;
            Set<K> r101 = b();
            this.f275265b = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Collection<V> values() {
            Collection<V> r100 = this.f275266c;
            if (r100 != null) goto L6;
            Collection<V> r101 = c();
            this.f275266c = r101;
            return r101;
        L6:
            return r100;
        }

        public q() {
        }
    }

    public static l1 a(Map.Entry r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new l1(r100);
    }

    public static int b(int r100) {
        if (r100 >= 3) goto L7;
        com.google.common.collect.o.b(r100, "expectedSize");
        return r100 + 1;
    L7:
        if (r100 < 1073741824) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return (int) Math.ceil(((double) r100) / 0.75d);
    }

    public static <E> ImmutableMap<E, Integer> d(Collection<E> r100) {
        ImmutableMap.b r101 = new ImmutableMap.b(r100.size());
        Iterator<E> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L7;
        int r104 = r103 + 1;
        r101.e(r102.next(), Integer.valueOf(r103));
        r103 = r104;
        goto L4
    L7:
        return r101.b(true);
    }

    @CheckForNull
    public static <K> K e(@CheckForNull Map.Entry<K, ?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getKey();
    }

    public static <K> com.google.common.base.n<Map.Entry<K, ?>> f(com.google.common.base.n<? super K> r100) {
        return Predicates.d(r100, EntryFunction.KEY);
    }

    public static String i(Map<?, ?> r100) {
        int r101 = r100.size();
        com.google.common.collect.o.b(r101, "size");
        StringBuilder r102 = new StringBuilder((int) Math.min(((long) r101) * 8, 1073741824));
        r102.append('{');
        Iterator<Map.Entry<?, ?>> r103 = r100.entrySet().iterator();
        boolean r104 = true;
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<?, ?> r105 = r103.next();
        if (r104 == true) goto L8;
        r102.append(", ");
    L8:
        r102.append(r105.getKey());
        r102.append(com.alipay.sdk.m.n.a.f25612h);
        r102.append(r105.getValue());
        r104 = false;
        goto L4
    L9:
        r102.append('}');
        return r102.toString();
    }

    public static <V> com.google.common.base.n<Map.Entry<?, V>> k(com.google.common.base.n<? super V> r100) {
        return Predicates.d(r100, EntryFunction.VALUE);
    }

    public static Map.Entry c(@ParametricNullness Service r100, @ParametricNullness Object r101) {
        return new ImmutableEntry(r100, r101);
    }

    public static boolean g(Map<?, ?> r100, @CheckForNull Object r101) {
        r100.getClass();
        return r100.containsKey(r101);
    L5:
        return false;
    }

    @CheckForNull
    public static <V> V h(Map<?, V> r100, @CheckForNull Object r101) {
        r100.getClass();
        return r100.get(r101);
    L5:
        return null;
    }

    public static l j(Map r100, com.google.common.base.g r101) {
        return new l(r100, new n1(r101));
    }
}
