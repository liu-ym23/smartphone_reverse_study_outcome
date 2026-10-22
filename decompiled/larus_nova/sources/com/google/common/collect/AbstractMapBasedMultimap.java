package com.google.common.collect;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Map<K, Collection<V>> f274906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int f274907g;

    public class a extends AbstractMapBasedMultimap<K, V>.d<V> {
        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        @ParametricNullness
        public final V a(@ParametricNullness K r100, @ParametricNullness V r101) {
            return r101;
        }

        public a(AbstractMapBasedMultimap r100) {
            super(r100);
        }
    }

    public class b extends AbstractMapBasedMultimap<K, V>.d<Map.Entry<K, V>> {
        public b(AbstractMapBasedMultimap r100) {
            super(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        public final Object a(@ParametricNullness Object r100, @ParametricNullness Object r101) {
            return new ImmutableEntry(r100, r101);
        }
    }

    public class c extends Maps.q<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Map<K, Collection<V>> f274908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274909e;

        public class a extends Maps.c<K, Collection<V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f274910a;

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b(this.f274910a);
            }

            @Override // com.google.common.collect.Maps.c
            public final Map<K, Collection<V>> a() {
                return this.f274910a;
            }

            public a(c r100) {
                this.f274910a = r100;
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object r100) {
                Set<Map.Entry<K, Collection<V>>> r101 = this.f274910a.f274908d.entrySet();
                r101.getClass();
                return r101.contains(r100);
            L5:
                return false;
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if (contains(r100) == true) goto L6;
                return false;
            L6:
                Map.Entry r101 = (Map.Entry) r100;
                Objects.requireNonNull(r101);
                AbstractMapBasedMultimap.access$300(this.f274910a.f274909e, r101.getKey());
                return true;
            }
        }

        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f274911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @CheckForNull
            public Collection<V> f274912b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f274913c;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f274911a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                Map.Entry<K, Collection<V>> r100 = this.f274911a.next();
                this.f274912b = r100.getValue();
                return this.f274913c.d(r100);
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (this.f274912b == null) goto L5;
                boolean r100 = true;
            L6:
                com.google.common.base.m.p(r100, "no calls to next() since the last call to remove()");
                this.f274911a.remove();
                AbstractMapBasedMultimap.access$220(this.f274913c.f274909e, this.f274912b.size());
                this.f274912b.clear();
                this.f274912b = null;
                return;
            L5:
                r100 = false;
                goto L6
            }

            public b(c r100) {
                this.f274913c = r100;
                this.f274911a = r100.f274908d.entrySet().iterator();
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<K, Collection<V>>> a() {
            return new a(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            if (this.f274908d != AbstractMapBasedMultimap.access$000(this.f274909e)) goto L5;
            this.f274909e.clear();
            return;
        L5:
            Iterators.b(new b(this));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int hashCode() {
            return this.f274908d.hashCode();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f274909e.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f274908d.size();
        }

        @Override // java.util.AbstractMap
        public final String toString() {
            return this.f274908d.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return Maps.g(this.f274908d, r100);
        }

        public final Map.Entry<K, Collection<V>> d(Map.Entry<K, Collection<V>> r100) {
            K r101 = r100.getKey();
            return new ImmutableEntry(r101, this.f274909e.wrapCollection(r101, r100.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean equals(@CheckForNull Object r100) {
            if (this != r100) goto L4;
        L7:
            return true;
        L4:
            if (this.f274908d.equals(r100) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object get(@CheckForNull Object r100) {
            Collection<V> r101 = (Collection) Maps.h(this.f274908d, r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return this.f274909e.wrapCollection(r100, r101);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object remove(@CheckForNull Object r100) {
            Collection<V> r101 = this.f274908d.remove(r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            Collection<V> r102 = this.f274909e.createCollection();
            r102.addAll(r101);
            AbstractMapBasedMultimap.access$220(this.f274909e, r101.size());
            r101.clear();
            return r102;
        }

        public c(AbstractMapBasedMultimap r100, Map<K, Collection<V>> r101) {
            this.f274909e = r100;
            this.f274908d = r101;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f274914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public K f274915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public Collection<V> f274916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Iterator<V> f274917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274918e;

        public abstract T a(@ParametricNullness K r100, @ParametricNullness V r101);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f274914a.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f274917d.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final T next() {
            if (this.f274917d.hasNext() == true) goto L6;
            Map.Entry<K, Collection<V>> r100 = this.f274914a.next();
            this.f274915b = r100.getKey();
            Collection<V> r101 = r100.getValue();
            this.f274916c = r101;
            this.f274917d = r101.iterator();
        L6:
            return a(this.f274915b, this.f274917d.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f274917d.remove();
            Collection<V> r100 = this.f274916c;
            Objects.requireNonNull(r100);
            if (r100.isEmpty() == false) goto L5;
            this.f274914a.remove();
        L5:
            AbstractMapBasedMultimap.access$210(this.f274918e);
        }

        public d(AbstractMapBasedMultimap r100) {
            this.f274918e = r100;
            this.f274914a = AbstractMapBasedMultimap.access$000(r100).entrySet().iterator();
            this.f274915b = null;
            this.f274916c = null;
            this.f274917d = Iterators.EmptyModifiableIterator.INSTANCE;
        }
    }

    public class e extends Maps.i<K, Collection<V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274919b;

        public class a implements Iterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @CheckForNull
            public Map.Entry<K, Collection<V>> f274920a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f274921b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f274922c;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f274921b.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public final K next() {
                Map.Entry<K, Collection<V>> r100 = (Map.Entry) this.f274921b.next();
                this.f274920a = r100;
                return r100.getKey();
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (this.f274920a == null) goto L5;
                boolean r100 = true;
            L6:
                com.google.common.base.m.p(r100, "no calls to next() since the last call to remove()");
                Collection<V> r101 = this.f274920a.getValue();
                this.f274921b.remove();
                AbstractMapBasedMultimap.access$220(this.f274922c.f274919b, r101.size());
                r101.clear();
                this.f274920a = null;
                return;
            L5:
                r100 = false;
                goto L6
            }

            public a(e r100, Iterator r101) {
                this.f274922c = r100;
                this.f274921b = r101;
            }
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            return this.f275259a.keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new a(this, this.f275259a.entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            Iterators.b(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> r100) {
            return this.f275259a.keySet().containsAll(r100);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final boolean equals(@CheckForNull Object r100) {
            if (this != r100) goto L4;
        L7:
            return true;
        L4:
            if (this.f275259a.keySet().equals(r100) == true) goto L7;
            return false;
        }

        @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            Collection r101 = (Collection) this.f275259a.remove(r100);
            if (r101 == null) goto L5;
            int r102 = r101.size();
            r101.clear();
            AbstractMapBasedMultimap.access$220(this.f274919b, r102);
        L6:
            if (r102 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r102 = 0;
            goto L6
        }

        public e(AbstractMapBasedMultimap r100, Map<K, Collection<V>> r101) {
            this.f274919b = r100;
            super(r101);
        }
    }

    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274923h;

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.Maps.q
        public final Set b() {
            return new g(this.f274923h, i());
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> descendingMap() {
            return new f(this.f274923h, i().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        public final SortedSet e() {
            return new g(this.f274923h, i());
        }

        public final NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) ((SortedMap) this.f274908d);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> descendingKeySet() {
            return ((f) descendingMap()).navigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        public final SortedSet f() {
            return (NavigableSet) super.f();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> r100 = i().firstEntry();
            if (r100 != null) goto L6;
            return null;
        L6:
            return d(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        public final /* bridge */ /* synthetic */ SortedMap g() {
            return i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return (NavigableSet) super.f();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> r100 = i().lastEntry();
            if (r100 != null) goto L6;
            return null;
        L6:
            return d(r100);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> navigableKeySet() {
            return (NavigableSet) super.f();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> pollFirstEntry() {
            return h(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> pollLastEntry() {
            return h(((Maps.q) descendingMap()).entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K r100) {
            Map.Entry<K, Collection<V>> r101 = i().ceilingEntry(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return d(r101);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K ceilingKey(@ParametricNullness K r100) {
            return i().ceilingKey(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K r100) {
            Map.Entry<K, Collection<V>> r101 = i().floorEntry(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return d(r101);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K floorKey(@ParametricNullness K r100) {
            return i().floorKey(r100);
        }

        @CheckForNull
        public final Map.Entry<K, Collection<V>> h(Iterator<Map.Entry<K, Collection<V>>> r100) {
            if (r100.hasNext() == true) goto L6;
            return null;
        L6:
            Map.Entry<K, Collection<V>> r101 = r100.next();
            Collection<V> r102 = this.f274923h.createCollection();
            r102.addAll(r101.getValue());
            r100.remove();
            return new ImmutableEntry(r101.getKey(), this.f274923h.unmodifiableCollectionSubclass(r102));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap headMap(@ParametricNullness Object r100) {
            return headMap(r100, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K r100) {
            Map.Entry<K, Collection<V>> r101 = i().higherEntry(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return d(r101);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K higherKey(@ParametricNullness K r100) {
            return i().higherKey(r100);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K r100) {
            Map.Entry<K, Collection<V>> r101 = i().lowerEntry(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return d(r101);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K lowerKey(@ParametricNullness K r100) {
            return i().lowerKey(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap tailMap(@ParametricNullness Object r100) {
            return tailMap(r100, true);
        }

        public f(AbstractMapBasedMultimap r100, NavigableMap<K, Collection<V>> r101) {
            this.f274923h = r100;
            super(r100, r101);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> headMap(@ParametricNullness K r100, boolean r101) {
            return new f(this.f274923h, i().headMap(r100, r101));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap subMap(@ParametricNullness Object r100, @ParametricNullness Object r101) {
            return subMap(r100, true, r101, false);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K r100, boolean r101) {
            return new f(this.f274923h, i().tailMap(r100, r101));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> subMap(@ParametricNullness K r100, boolean r101, @ParametricNullness K r102, boolean r103) {
            return new f(this.f274923h, i().subMap(r100, r101, r102, r103));
        }
    }

    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274924d;

        public final NavigableMap<K, Collection<V>> d() {
            return (NavigableMap) ((SortedMap) this.f275259a);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> descendingSet() {
            return new g(this.f274924d, d().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        public final /* bridge */ /* synthetic */ SortedMap c() {
            return d();
        }

        @Override // java.util.NavigableSet
        public final Iterator<K> descendingIterator() {
            return ((e) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K pollFirst() {
            return (K) Iterators.f(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K pollLast() {
            return (K) Iterators.f(descendingIterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K ceiling(@ParametricNullness K r100) {
            return d().ceilingKey(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K floor(@ParametricNullness K r100) {
            return d().floorKey(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet headSet(@ParametricNullness Object r100) {
            return headSet(r100, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K higher(@ParametricNullness K r100) {
            return d().higherKey(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K lower(@ParametricNullness K r100) {
            return d().lowerKey(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet tailSet(@ParametricNullness Object r100) {
            return tailSet(r100, true);
        }

        public g(AbstractMapBasedMultimap r100, NavigableMap<K, Collection<V>> r101) {
            this.f274924d = r100;
            super(r100, r101);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> headSet(@ParametricNullness K r100, boolean r101) {
            return new g(this.f274924d, d().headMap(r100, r101));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet subSet(@ParametricNullness Object r100, @ParametricNullness Object r101) {
            return subSet(r100, true, r101, false);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> tailSet(@ParametricNullness K r100, boolean r101) {
            return new g(this.f274924d, d().tailMap(r100, r101));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> subSet(@ParametricNullness K r100, boolean r101, @ParametricNullness K r102, boolean r103) {
            return new g(this.f274924d, d().subMap(r100, r101, r102, r103));
        }
    }

    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        public h(@ParametricNullness AbstractMapBasedMultimap r100, K r101, @CheckForNull List<V> r102, AbstractMapBasedMultimap<K, V>.k r103) {
            super(r100, r101, r102, r103);
        }
    }

    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @CheckForNull
        public SortedSet<K> f274925f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274926g;

        public SortedSet<K> e() {
            return new j(this.f274926g, g());
        }

        public SortedSet<K> f() {
            SortedSet<K> r100 = this.f274925f;
            if (r100 != null) goto L6;
            SortedSet<K> r101 = e();
            this.f274925f = r101;
            return r101;
        L6:
            return r100;
        }

        public SortedMap<K, Collection<V>> g() {
            return (SortedMap) this.f274908d;
        }

        @Override // com.google.common.collect.Maps.q
        public /* bridge */ /* synthetic */ Set b() {
            return e();
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public final Comparator<? super K> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public final K firstKey() {
            return g().firstKey();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return f();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public final K lastKey() {
            return g().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(@ParametricNullness K r100) {
            return new i(this.f274926g, g().headMap(r100));
        }

        public SortedMap<K, Collection<V>> tailMap(@ParametricNullness K r100) {
            return new i(this.f274926g, g().tailMap(r100));
        }

        public i(AbstractMapBasedMultimap r100, SortedMap<K, Collection<V>> r101) {
            this.f274926g = r100;
            super(r100, r101);
        }

        public SortedMap<K, Collection<V>> subMap(@ParametricNullness K r100, @ParametricNullness K r101) {
            return new i(this.f274926g, g().subMap(r100, r101));
        }
    }

    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274927c;

        public SortedMap<K, Collection<V>> c() {
            return (SortedMap) this.f275259a;
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

        public SortedSet<K> headSet(@ParametricNullness K r100) {
            return new j(this.f274927c, c().headMap(r100));
        }

        public SortedSet<K> tailSet(@ParametricNullness K r100) {
            return new j(this.f274927c, c().tailMap(r100));
        }

        public j(AbstractMapBasedMultimap r100, SortedMap<K, Collection<V>> r101) {
            this.f274927c = r100;
            super(r100, r101);
        }

        public SortedSet<K> subSet(@ParametricNullness K r100, @ParametricNullness K r101) {
            return new j(this.f274927c, c().subMap(r100, r101));
        }
    }

    public class k extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f274928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Collection<V> f274929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public final AbstractMapBasedMultimap<K, V>.k f274930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @CheckForNull
        public final Collection<V> f274931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274932e;

        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<V> f274933a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Collection<V> f274934b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ k f274935c;

            public final void a() {
                this.f274935c.c();
                if (this.f274935c.f274929b != this.f274934b) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                this.f274933a.remove();
                AbstractMapBasedMultimap.access$210(this.f274935c.f274932e);
                this.f274935c.d();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                a();
                return this.f274933a.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public final V next() {
                a();
                return this.f274933a.next();
            }

            public a(k r100) {
                this.f274935c = r100;
                Collection<V> r101 = r100.f274929b;
                this.f274934b = r101;
                this.f274933a = AbstractMapBasedMultimap.access$100(r101);
            }

            public a(k r100, Iterator<V> r101) {
                this.f274935c = r100;
                this.f274934b = r100.f274929b;
                this.f274933a = r101;
            }
        }

        public final void a() {
            AbstractMapBasedMultimap<K, V>.k r100 = this.f274930c;
            if (r100 == null) goto L5;
            r100.a();
            return;
        L5:
            AbstractMapBasedMultimap.access$000(this.f274932e).put(this.f274928a, this.f274929b);
        }

        public final void c() {
            AbstractMapBasedMultimap<K, V>.k r100 = this.f274930c;
            if (r100 == null) goto L10;
            r100.c();
            if (this.f274930c.f274929b != this.f274931d) goto L8;
            return;
        L8:
            throw new ConcurrentModificationException();
        L10:
            if (this.f274929b.isEmpty() == false) goto L15;
            Collection<V> r101 = (Collection) AbstractMapBasedMultimap.access$000(this.f274932e).get(this.f274928a);
            if (r101 == null) goto L16;
            this.f274929b = r101;
            return;
        L16:
            return;
        }

        public final void d() {
            AbstractMapBasedMultimap<K, V>.k r100 = this.f274930c;
            if (r100 == null) goto L6;
            r100.d();
            return;
        L6:
            if (this.f274929b.isEmpty() == false) goto L10;
            AbstractMapBasedMultimap.access$000(this.f274932e).remove(this.f274928a);
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            int r100 = size();
            if (r100 != 0) goto L5;
            return;
        L5:
            this.f274929b.clear();
            AbstractMapBasedMultimap.access$220(this.f274932e, r100);
            d();
        }

        @Override // java.util.Collection
        public final int hashCode() {
            c();
            return this.f274929b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            c();
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            c();
            return this.f274929b.size();
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            c();
            return this.f274929b.toString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean add(@ParametricNullness V r100) {
            c();
            boolean r101 = this.f274929b.isEmpty();
            boolean r102 = this.f274929b.add(r100);
            if (r102 == false) goto L7;
            AbstractMapBasedMultimap.access$208(this.f274932e);
            if (r101 == false) goto L7;
            a();
        L7:
            return r102;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean addAll(Collection<? extends V> r100) {
            if (r100.isEmpty() == false) goto L6;
            return false;
        L6:
            int r101 = size();
            boolean r102 = this.f274929b.addAll(r100);
            if (r102 == false) goto L11;
            int r103 = this.f274929b.size();
            AbstractMapBasedMultimap.access$212(this.f274932e, r103 - r101);
            if (r101 != 0) goto L11;
            a();
        L11:
            return r102;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object r100) {
            c();
            return this.f274929b.contains(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean containsAll(Collection<?> r100) {
            c();
            return this.f274929b.containsAll(r100);
        }

        @Override // java.util.Collection
        public final boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            c();
            return this.f274929b.equals(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(@CheckForNull Object r100) {
            c();
            boolean r101 = this.f274929b.remove(r100);
            if (r101 == false) goto L5;
            AbstractMapBasedMultimap.access$210(this.f274932e);
            d();
        L5:
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            if (r100.isEmpty() == false) goto L6;
            return false;
        L6:
            int r101 = size();
            boolean r102 = this.f274929b.removeAll(r100);
            if (r102 == false) goto L9;
            int r103 = this.f274929b.size();
            AbstractMapBasedMultimap.access$212(this.f274932e, r103 - r101);
            d();
        L9:
            return r102;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection<?> r100) {
            r100.getClass();
            int r101 = size();
            boolean r102 = this.f274929b.retainAll(r100);
            if (r102 == false) goto L5;
            int r103 = this.f274929b.size();
            AbstractMapBasedMultimap.access$212(this.f274932e, r103 - r101);
            d();
        L5:
            return r102;
        }

        public k(@ParametricNullness AbstractMapBasedMultimap r100, K r101, @CheckForNull Collection<V> r102, AbstractMapBasedMultimap<K, V>.k r103) {
            this.f274932e = r100;
            this.f274928a = r101;
            this.f274929b = r102;
            this.f274930c = r103;
            if (r103 != null) goto L5;
            Collection<V> r104 = null;
        L6:
            this.f274931d = r104;
            return;
        L5:
            r104 = r103.f274929b;
            goto L6
        }
    }

    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274936f;

        public class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ l f274937d;

            public final ListIterator<V> b() {
                a();
                return (ListIterator) this.f274933a;
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return b().hasPrevious();
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return b().nextIndex();
            }

            @Override // java.util.ListIterator
            @ParametricNullness
            public final V previous() {
                return b().previous();
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return b().previousIndex();
            }

            public a(l r100) {
                this.f274937d = r100;
                super(r100);
            }

            @Override // java.util.ListIterator
            public final void add(@ParametricNullness V r100) {
                boolean r101 = this.f274937d.isEmpty();
                b().add(r100);
                AbstractMapBasedMultimap.access$208(this.f274937d.f274936f);
                if (r101 == false) goto L6;
                this.f274937d.a();
                return;
            }

            @Override // java.util.ListIterator
            public final void set(@ParametricNullness V r100) {
                b().set(r100);
            }

            public a(l r100, int r101) {
                this.f274937d = r100;
                super(r100, ((List) r100.f274929b).listIterator(r101));
            }
        }

        @Override // java.util.List
        public final ListIterator<V> listIterator() {
            c();
            return new a(this);
        }

        @Override // java.util.List
        @ParametricNullness
        public final V get(int r100) {
            c();
            return (V) ListProtector.get((List) this.f274929b, r100);
        }

        @Override // java.util.List
        public final int indexOf(@CheckForNull Object r100) {
            c();
            return ((List) this.f274929b).indexOf(r100);
        }

        @Override // java.util.List
        public final int lastIndexOf(@CheckForNull Object r100) {
            c();
            return ((List) this.f274929b).lastIndexOf(r100);
        }

        @Override // java.util.List
        public final ListIterator<V> listIterator(int r100) {
            c();
            return new a(this, r100);
        }

        @Override // java.util.List
        @ParametricNullness
        public final V remove(int r100) {
            c();
            V r101 = (V) ListProtector.remove((List) this.f274929b, r100);
            AbstractMapBasedMultimap.access$210(this.f274936f);
            d();
            return r101;
        }

        @Override // java.util.List
        public final void add(int r100, @ParametricNullness V r101) {
            c();
            boolean r102 = this.f274929b.isEmpty();
            ListProtector.add((List) this.f274929b, r100, r101);
            AbstractMapBasedMultimap.access$208(this.f274936f);
            if (r102 == false) goto L6;
            a();
            return;
        }

        @Override // java.util.List
        public final boolean addAll(int r100, Collection<? extends V> r101) {
            if (r101.isEmpty() == false) goto L6;
            return false;
        L6:
            int r102 = size();
            boolean r103 = ((List) this.f274929b).addAll(r100, r101);
            if (r103 == false) goto L11;
            int r104 = this.f274929b.size();
            AbstractMapBasedMultimap.access$212(this.f274936f, r104 - r102);
            if (r102 != 0) goto L11;
            a();
        L11:
            return r103;
        }

        @Override // java.util.List
        @ParametricNullness
        public final V set(int r100, @ParametricNullness V r101) {
            c();
            return (V) ListProtector.set((List) this.f274929b, r100, r101);
        }

        @Override // java.util.List
        public final List<V> subList(int r100, int r101) {
            c();
            AbstractMapBasedMultimap r102 = this.f274936f;
            K r103 = this.f274928a;
            List<V> r104 = ((List) this.f274929b).subList(r100, r101);
            AbstractMapBasedMultimap<K, V>.k r105 = this.f274930c;
            if (r105 != null) goto L6;
            r105 = this;
        L6:
            return r102.wrapList(r103, r104, r105);
        }

        public l(@ParametricNullness AbstractMapBasedMultimap r100, K r101, @CheckForNull List<V> r102, AbstractMapBasedMultimap<K, V>.k r103) {
            this.f274936f = r100;
            super(r100, r101, r102, r103);
        }
    }

    public class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274938g;

        @Override // java.util.NavigableSet
        public final Iterator<V> descendingIterator() {
            return new k.a(this, f().descendingIterator());
        }

        public final NavigableSet<V> f() {
            return (NavigableSet) ((SortedSet) this.f274929b);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<V> descendingSet() {
            return g(f().descendingSet());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        public final /* bridge */ /* synthetic */ SortedSet e() {
            return f();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final V pollFirst() {
            return (V) Iterators.f(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final V pollLast() {
            return (V) Iterators.f(descendingIterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final V ceiling(@ParametricNullness V r100) {
            return f().ceiling(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final V floor(@ParametricNullness V r100) {
            return f().floor(r100);
        }

        public final m g(NavigableSet r100) {
            AbstractMapBasedMultimap r101 = this.f274938g;
            K r102 = this.f274928a;
            AbstractMapBasedMultimap<K, V>.k r103 = this.f274930c;
            if (r103 != null) goto L6;
            r103 = this;
        L6:
            return new m(r101, r102, r100, r103);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final V higher(@ParametricNullness V r100) {
            return f().higher(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final V lower(@ParametricNullness V r100) {
            return f().lower(r100);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<V> headSet(@ParametricNullness V r100, boolean r101) {
            return g(f().headSet(r100, r101));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<V> tailSet(@ParametricNullness V r100, boolean r101) {
            return g(f().tailSet(r100, r101));
        }

        public m(@ParametricNullness AbstractMapBasedMultimap r100, K r101, @CheckForNull NavigableSet<V> r102, AbstractMapBasedMultimap<K, V>.k r103) {
            this.f274938g = r100;
            super(r100, r101, r102, r103);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<V> subSet(@ParametricNullness V r100, boolean r101, @ParametricNullness V r102, boolean r103) {
            return g(f().subSet(r100, r101, r102, r103));
        }
    }

    public class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274939f;

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection<?> r100) {
            if (r100.isEmpty() == false) goto L6;
            return false;
        L6:
            int r101 = size();
            boolean r102 = Sets.d((Set) this.f274929b, r100);
            if (r102 == false) goto L9;
            int r103 = this.f274929b.size();
            AbstractMapBasedMultimap.access$212(this.f274939f, r103 - r101);
            d();
        L9:
            return r102;
        }

        public n(@ParametricNullness AbstractMapBasedMultimap r100, K r101, Set<V> r102) {
            this.f274939f = r100;
            super(r100, r101, r102, null);
        }
    }

    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f274940f;

        public SortedSet<V> e() {
            return (SortedSet) this.f274929b;
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public final Comparator<? super V> comparator() {
            return e().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final V first() {
            c();
            return e().first();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final V last() {
            c();
            return e().last();
        }

        @Override // java.util.SortedSet
        public final SortedSet<V> headSet(@ParametricNullness V r100) {
            c();
            AbstractMapBasedMultimap r101 = this.f274940f;
            K r102 = this.f274928a;
            SortedSet<V> r103 = e().headSet(r100);
            AbstractMapBasedMultimap<K, V>.k r104 = this.f274930c;
            if (r104 != null) goto L6;
            r104 = this;
        L6:
            return new o(r101, r102, r103, r104);
        }

        @Override // java.util.SortedSet
        public final SortedSet<V> tailSet(@ParametricNullness V r100) {
            c();
            AbstractMapBasedMultimap r101 = this.f274940f;
            K r102 = this.f274928a;
            SortedSet<V> r103 = e().tailSet(r100);
            AbstractMapBasedMultimap<K, V>.k r104 = this.f274930c;
            if (r104 != null) goto L6;
            r104 = this;
        L6:
            return new o(r101, r102, r103, r104);
        }

        @Override // java.util.SortedSet
        public final SortedSet<V> subSet(@ParametricNullness V r100, @ParametricNullness V r101) {
            c();
            AbstractMapBasedMultimap r102 = this.f274940f;
            K r103 = this.f274928a;
            SortedSet<V> r104 = e().subSet(r100, r101);
            AbstractMapBasedMultimap<K, V>.k r105 = this.f274930c;
            if (r105 != null) goto L6;
            r105 = this;
        L6:
            return new o(r102, r103, r104, r105);
        }

        public o(@ParametricNullness AbstractMapBasedMultimap r100, K r101, @CheckForNull SortedSet<V> r102, AbstractMapBasedMultimap<K, V>.k r103) {
            this.f274940f = r100;
            super(r100, r101, r102, r103);
        }
    }

    public abstract Collection<V> createCollection();

    @Override // com.google.common.collect.q1
    public void clear() {
        Iterator<Collection<V>> r100 = this.f274906f.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().clear();
        goto L4
    L6:
        this.f274906f.clear();
        this.f274907g = 0;
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return new c(this, this.f274906f);
    }

    @Override // com.google.common.collect.c
    public Collection<Map.Entry<K, V>> createEntries() {
        if ((this instanceof k2) == false) goto L7;
        return new com.google.common.collect.c.b(this);
    L7:
        return new com.google.common.collect.c.a(this);
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        return new e(this, this.f274906f);
    }

    @Override // com.google.common.collect.c
    public y1<K> createKeys() {
        return new Multimaps.c(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> r100 = this.f274906f;
        if ((r100 instanceof NavigableMap) == false) goto L7;
        return new f(this, (NavigableMap) this.f274906f);
    L7:
        if ((r100 instanceof SortedMap) == false) goto L11;
        return new i(this, (SortedMap) this.f274906f);
    L11:
        return new c(this, this.f274906f);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> r100 = this.f274906f;
        if ((r100 instanceof NavigableMap) == false) goto L7;
        return new g(this, (NavigableMap) this.f274906f);
    L7:
        if ((r100 instanceof SortedMap) == false) goto L11;
        return new j(this, (SortedMap) this.f274906f);
    L11:
        return new e(this, this.f274906f);
    }

    @Override // com.google.common.collect.c
    public Collection<V> createValues() {
        return new com.google.common.collect.c.C3856c(this);
    }

    @Override // com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // com.google.common.collect.c
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public Collection<V> values() {
        return super.values();
    }

    public Map<K, Collection<V>> backingMap() {
        return this.f274906f;
    }

    @Override // com.google.common.collect.q1
    public int size() {
        return this.f274907g;
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> r100) {
        com.google.common.base.m.b(r100.isEmpty());
        this.f274906f = r100;
    }

    public static /* synthetic */ Map access$000(AbstractMapBasedMultimap r100) {
        return r100.f274906f;
    }

    public static Iterator access$100(Collection r100) {
        if ((r100 instanceof List) == false) goto L6;
        return ((List) r100).listIterator();
    L6:
        return r100.iterator();
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap r100) {
        int r101 = r100.f274907g;
        r100.f274907g = r101 + 1;
        return r101;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap r100) {
        int r101 = r100.f274907g;
        r100.f274907g = r101 - 1;
        return r101;
    }

    @Override // com.google.common.collect.q1
    public boolean containsKey(@CheckForNull Object r100) {
        return this.f274906f.containsKey(r100);
    }

    public Collection<V> createCollection(@ParametricNullness K r100) {
        return createCollection();
    }

    @Override // com.google.common.collect.q1
    public Collection<V> get(@ParametricNullness K r100) {
        Collection<V> r101 = this.f274906f.get(r100);
        if (r101 != null) goto L6;
        r101 = createCollection(r100);
    L6:
        return wrapCollection(r100, r101);
    }

    @Override // com.google.common.collect.q1
    public Collection<V> removeAll(@CheckForNull Object r100) {
        Collection<V> r101 = this.f274906f.remove(r100);
        if (r101 == null) goto L5;
        Collection r102 = createCollection();
        r102.addAll(r101);
        this.f274907g -= r101.size();
        r101.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(r102);
    L5:
        return createUnmodifiableEmptyCollection();
    }

    final void setMap(Map<K, Collection<V>> r100) {
        this.f274906f = r100;
        this.f274907g = 0;
        Iterator<Collection<V>> r101 = r100.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Collection<V> r102 = r101.next();
        com.google.common.base.m.b(!r102.isEmpty());
        this.f274907g += r102.size();
        goto L4
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r100) {
        return Collections.unmodifiableCollection(r100);
    }

    public static /* synthetic */ int access$212(AbstractMapBasedMultimap r100, int r101) {
        int r102 = r100.f274907g + r101;
        r100.f274907g = r102;
        return r102;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap r100, int r101) {
        int r102 = r100.f274907g - r101;
        r100.f274907g = r102;
        return r102;
    }

    public static void access$300(AbstractMapBasedMultimap r100, Object r101) {
        Map<K, Collection<V>> r102 = r100.f274906f;
        r102.getClass();
        Collection<V> r103 = r102.remove(r101);     // Catch: Throwable -> L5
    L6:
        Collection<V> r104 = r103;
        if (r104 == null) goto L12;
        int r105 = r104.size();
        r104.clear();
        r100.f274907g -= r105;
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
        Collection<V> r102 = this.f274906f.get(r100);
        if (r102 != null) goto L11;
        Collection<V> r103 = createCollection(r100);
        if (r103.add(r101) == false) goto L9;
        this.f274907g++;
        this.f274906f.put(r100, r103);
        return true;
    L9:
        throw new AssertionError("New Collection violated the Collection spec");
    L11:
        if (r102.add(r101) == false) goto L14;
        this.f274907g++;
        return true;
    L14:
        return false;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public Collection<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
        Iterator<? extends V> r102 = r101.iterator();
        if (r102.hasNext() == false) goto L5;
        Collection<V> r103 = this.f274906f.get(r100);
        if (r103 != null) goto L9;
        r103 = createCollection(r100);
        this.f274906f.put(r100, r103);
    L9:
        Collection r104 = createCollection();
        r104.addAll(r103);
        this.f274907g -= r103.size();
        r103.clear();
    L11:
        if (r102.hasNext() == false) goto L16;
        if (r103.add(r102.next()) == false) goto L11;
        this.f274907g++;
        goto L11
    L16:
        return (Collection<V>) unmodifiableCollectionSubclass(r104);
    L5:
        return removeAll(r100);
    }

    public Collection<V> wrapCollection(@ParametricNullness K r100, Collection<V> r101) {
        return new k(this, r100, r101, null);
    }

    public final List<V> wrapList(@ParametricNullness K r100, List<V> r101, @CheckForNull AbstractMapBasedMultimap<K, V>.k r102) {
        if ((r101 instanceof RandomAccess) == false) goto L6;
        return new h(this, r100, r101, r102);
    L6:
        return new l(this, r100, r101, r102);
    }
}
