package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Multimaps {

    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.t<? extends List<V>> factory;

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            this.factory = (com.google.common.base.t) r100.readObject();
            setMap((Map) r100.readObject());
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            r100.writeObject(this.factory);
            r100.writeObject(backingMap());
        }

        public CustomListMultimap(Map<K, Collection<V>> r100, com.google.common.base.t<? extends List<V>> r101) {
            super(r100);
            r101.getClass();
            this.factory = r101;
        }
    }

    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.t<? extends Collection<V>> factory;

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            this.factory = (com.google.common.base.t) r100.readObject();
            setMap((Map) r100.readObject());
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            r100.writeObject(this.factory);
            r100.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r100) {
            if ((r100 instanceof NavigableSet) == false) goto L7;
            return Sets.f((NavigableSet) r100);
        L7:
            if ((r100 instanceof SortedSet) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) r100);
        L11:
            if ((r100 instanceof Set) == false) goto L15;
            return Collections.unmodifiableSet((Set) r100);
        L15:
            if ((r100 instanceof List) == false) goto L19;
            return Collections.unmodifiableList((List) r100);
        L19:
            return Collections.unmodifiableCollection(r100);
        }

        public CustomMultimap(Map<K, Collection<V>> r100, com.google.common.base.t<? extends Collection<V>> r101) {
            super(r100);
            r101.getClass();
            this.factory = r101;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(@ParametricNullness K r100, Collection<V> r101) {
            if ((r101 instanceof List) == false) goto L7;
            return wrapList(r100, (List) r101, null);
        L7:
            if ((r101 instanceof NavigableSet) == false) goto L11;
            return new AbstractMapBasedMultimap.m(this, r100, (NavigableSet) r101, null);
        L11:
            if ((r101 instanceof SortedSet) == false) goto L15;
            return new AbstractMapBasedMultimap.o(this, r100, (SortedSet) r101, null);
        L15:
            if ((r101 instanceof Set) == false) goto L19;
            return new AbstractMapBasedMultimap.n(this, r100, (Set) r101);
        L19:
            return new AbstractMapBasedMultimap.k(this, r100, r101, null);
        }
    }

    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.t<? extends Set<V>> factory;

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            this.factory = (com.google.common.base.t) r100.readObject();
            setMap((Map) r100.readObject());
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            r100.writeObject(this.factory);
            r100.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r100) {
            if ((r100 instanceof NavigableSet) == false) goto L7;
            return Sets.f((NavigableSet) r100);
        L7:
            if ((r100 instanceof SortedSet) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) r100);
        L11:
            return Collections.unmodifiableSet((Set) r100);
        }

        public CustomSetMultimap(Map<K, Collection<V>> r100, com.google.common.base.t<? extends Set<V>> r101) {
            super(r100);
            r101.getClass();
            this.factory = r101;
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(@ParametricNullness K r100, Collection<V> r101) {
            if ((r101 instanceof NavigableSet) == false) goto L7;
            return new AbstractMapBasedMultimap.m(this, r100, (NavigableSet) r101, null);
        L7:
            if ((r101 instanceof SortedSet) == false) goto L11;
            return new AbstractMapBasedMultimap.o(this, r100, (SortedSet) r101, null);
        L11:
            return new AbstractMapBasedMultimap.n(this, r100, (Set) r101);
        }
    }

    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.t<? extends SortedSet<V>> factory;

        @CheckForNull
        transient Comparator<? super V> valueComparator;

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.p2
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Set createCollection() {
            return createCollection();
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            com.google.common.base.t<? extends SortedSet<V>> r101 = (com.google.common.base.t) r100.readObject();
            this.factory = r101;
            this.valueComparator = r101.get().comparator();
            setMap((Map) r100.readObject());
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            r100.writeObject(this.factory);
            r100.writeObject(backingMap());
        }

        public CustomSortedSetMultimap(Map<K, Collection<V>> r100, com.google.common.base.t<? extends SortedSet<V>> r101) {
            super(r100);
            r101.getClass();
            this.factory = r101;
            this.valueComparator = r101.get().comparator();
        }
    }

    public static class MapMultimap<K, V> extends com.google.common.collect.c<K, V> implements k2<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        public class a extends Sets.c<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f275268a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MapMultimap f275269b;

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a, reason: collision with other inner class name */
            public class C3850a implements Iterator<V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f275270a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f275271b;

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    if (this.f275270a != 0) goto L7;
                    a r100 = this.f275271b;
                    if (r100.f275269b.map.containsKey(r100.f275268a) == false) goto L7;
                    return true;
                L7:
                    return false;
                }

                @Override // java.util.Iterator
                public final void remove() {
                    boolean r100 = true;
                    if (this.f275270a == 1) goto L6;
                    r100 = false;
                L6:
                    o.e(r100);
                    this.f275270a = -1;
                    a r101 = this.f275271b;
                    r101.f275269b.map.remove(r101.f275268a);
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public final V next() {
                    if (hasNext() == false) goto L7;
                    this.f275270a++;
                    a r100 = this.f275271b;
                    return r100.f275269b.map.get(r100.f275268a);
                L7:
                    throw new NoSuchElementException();
                }

                public C3850a(a r100) {
                    this.f275271b = r100;
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<V> iterator() {
                return new C3850a(this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return this.f275269b.map.containsKey(this.f275268a) ? 1 : 0;
            }

            public a(MapMultimap r100, Object r101) {
                this.f275269b = r100;
                this.f275268a = r101;
            }
        }

        @Override // com.google.common.collect.q1
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // com.google.common.collect.c
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.c
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.c
        public y1<K> createKeys() {
            return new c(this);
        }

        @Override // com.google.common.collect.c
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.q1
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        public MapMultimap(Map<K, V> r100) {
            r100.getClass();
            this.map = r100;
        }

        @Override // com.google.common.collect.q1
        public boolean containsKey(@CheckForNull Object r100) {
            return this.map.containsKey(r100);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public boolean containsValue(@CheckForNull Object r100) {
            return this.map.containsValue(r100);
        }

        @Override // com.google.common.collect.q1
        public Set<V> get(@ParametricNullness K r100) {
            return new a(this, r100);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public boolean putAll(q1<? extends K, ? extends V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.q1
        public Set<V> removeAll(@CheckForNull Object r100) {
            HashSet r101 = new HashSet(2);
            if (this.map.containsKey(r100) == true) goto L5;
            return r101;
        L5:
            r101.add(this.map.remove(r100));
            return r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101) {
            return this.map.entrySet().contains(new ImmutableEntry(r100, r101));
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public boolean putAll(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
            return this.map.entrySet().remove(new ImmutableEntry(r100, r101));
        }

        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public Set<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.c, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements f1<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public f1<K, V> delegate() {
            return (f1) super.delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ q1 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public UnmodifiableListMultimap(f1<K, V> r100) {
            super(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public List<V> get(@ParametricNullness K r100) {
            return Collections.unmodifiableList(delegate().get(r100));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public List<V> removeAll(@CheckForNull Object r100) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public List<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static class UnmodifiableMultimap<K, V> extends m0<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final q1<K, V> delegate;

        @CheckForNull
        @LazyInit
        transient Collection<Map.Entry<K, V>> entries;

        @CheckForNull
        @LazyInit
        transient Set<K> keySet;

        @CheckForNull
        @LazyInit
        transient y1<K> keys;

        @CheckForNull
        @LazyInit
        transient Map<K, Collection<V>> map;

        @CheckForNull
        @LazyInit
        transient Collection<V> values;

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> r100 = this.map;
            if (r100 != null) goto L6;
            Map<K, Collection<V>> r101 = Collections.unmodifiableMap(Maps.j(this.delegate.asMap(), new x1()));
            this.map = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> r100 = this.entries;
            if (r100 != null) goto L10;
            Collection<Map.Entry<K, V>> r101 = this.delegate.entries();
            if ((r101 instanceof Set) == false) goto L7;
            Collection<Map.Entry<K, V>> r102 = new Maps.o(Collections.unmodifiableSet((Set) r101));
        L8:
            Collection<Map.Entry<K, V>> r103 = r102;
            this.entries = r103;
            return r103;
        L7:
            r102 = new Maps.n(Collections.unmodifiableCollection(r101));
            goto L8
        L10:
            return r100;
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Set<K> keySet() {
            Set<K> r100 = this.keySet;
            if (r100 != null) goto L6;
            Set<K> r101 = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public y1<K> keys() {
            y1<K> r100 = this.keys;
            if (r100 != null) goto L11;
            r100 = this.delegate.keys();
            if ((r100 instanceof Multisets.UnmodifiableMultiset) == false) goto L7;
        L10:
            this.keys = r100;
            goto L11
        L7:
            if ((r100 instanceof ImmutableMultiset) == true) goto L10;
            r100.getClass();
            r100 = new Multisets.UnmodifiableMultiset(r100);
        L11:
            return r100;
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Collection<V> values() {
            Collection<V> r100 = this.values;
            if (r100 != null) goto L6;
            Collection<V> r101 = Collections.unmodifiableCollection(this.delegate.values());
            this.values = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.o0
        public q1<K, V> delegate() {
            return this.delegate;
        }

        public UnmodifiableMultimap(q1<K, V> r100) {
            r100.getClass();
            this.delegate = r100;
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Collection<V> get(@ParametricNullness K r100) {
            return Multimaps.a(this.delegate.get(r100));
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public boolean putAll(q1<? extends K, ? extends V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Collection<V> removeAll(@CheckForNull Object r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public boolean putAll(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.m0, com.google.common.collect.q1
        public Collection<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements k2<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public k2<K, V> delegate() {
            return (k2) super.delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public Set<Map.Entry<K, V>> entries() {
            return new Maps.o(Collections.unmodifiableSet(delegate().entries()));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ q1 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public UnmodifiableSetMultimap(k2<K, V> r100) {
            super(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public Set<V> get(@ParametricNullness K r100) {
            return Collections.unmodifiableSet(delegate().get(r100));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public Set<V> removeAll(@CheckForNull Object r100) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public Set<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements p2<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public p2<K, V> delegate() {
            return (p2) super.delegate();
        }

        @Override // com.google.common.collect.p2
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ k2 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ q1 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public UnmodifiableSortedSetMultimap(p2<K, V> r100) {
            super(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public SortedSet<V> get(@ParametricNullness K r100) {
            return Collections.unmodifiableSortedSet(delegate().get(r100));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public SortedSet<V> removeAll(@CheckForNull Object r100) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public SortedSet<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.m0, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Set replaceValues(@ParametricNullness Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static final class a<K, V> extends Maps.q<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q1<K, V> f275272d;

        /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        public class C3851a extends Maps.c<K, Collection<V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f275273a;

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                Set<K> r100 = this.f275273a.f275272d.keySet();
                com.google.common.base.g r101 = new v1(this);
                return new k1(r100.iterator(), r101);
            }

            @Override // com.google.common.collect.Maps.c
            public final Map<K, Collection<V>> a() {
                return this.f275273a;
            }

            public C3851a(a r100) {
                this.f275273a = r100;
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if (contains(r100) == true) goto L6;
                return false;
            L6:
                Map.Entry r101 = (Map.Entry) r100;
                Objects.requireNonNull(r101);
                a r102 = this.f275273a;
                Object r103 = r101.getKey();
                r102.f275272d.keySet().remove(r103);
                return true;
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<K, Collection<V>>> a() {
            return new C3851a(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f275272d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            return this.f275272d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public final Set<K> keySet() {
            return this.f275272d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f275272d.keySet().size();
        }

        public a(q1<K, V> r100) {
            r100.getClass();
            this.f275272d = r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return this.f275272d.containsKey(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object get(@CheckForNull Object r100) {
            if (containsKey(r100) == true) goto L7;
            return null;
        L7:
            return this.f275272d.get(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object remove(@CheckForNull Object r100) {
            if (containsKey(r100) == true) goto L7;
            return null;
        L7:
            return this.f275272d.removeAll(r100);
        }
    }

    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            ((com.google.common.collect.c.a) this).f275435a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return ((com.google.common.collect.c.a) this).f275435a.size();
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L6;
            Map.Entry r101 = (Map.Entry) r100;
            return ((com.google.common.collect.c.a) this).f275435a.containsEntry(r101.getKey(), r101.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L6;
            Map.Entry r101 = (Map.Entry) r100;
            return ((com.google.common.collect.c.a) this).f275435a.remove(r101.getKey(), r101.getValue());
        L6:
            return false;
        }
    }

    public static class c<K, V> extends d<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q1<K, V> f275274c;

        public class a extends v2<Map.Entry<K, Collection<V>>, y1.a<K>> {
            public a(Iterator r100) {
                super(r100);
            }

            @Override // com.google.common.collect.v2
            public final Object a(Object r100) {
                return new w1((Map.Entry) r100);
            }
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f275274c.clear();
        }

        @Override // com.google.common.collect.d
        public final int distinctElements() {
            return this.f275274c.asMap().size();
        }

        @Override // com.google.common.collect.d
        public final Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.d, com.google.common.collect.y1
        public final Set<K> elementSet() {
            return this.f275274c.keySet();
        }

        @Override // com.google.common.collect.d
        public final Iterator<y1.a<K>> entryIterator() {
            return new a(this.f275274c.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.y1
        public final Iterator<K> iterator() {
            return new i1(this.f275274c.entries().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
        public final int size() {
            return this.f275274c.size();
        }

        public c(q1<K, V> r100) {
            this.f275274c = r100;
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275274c.containsKey(r100);
        }

        @Override // com.google.common.collect.y1
        public final int count(@CheckForNull Object r100) {
            Collection r101 = (Collection) Maps.h(this.f275274c.asMap(), r100);
            if (r101 != null) goto L6;
            return 0;
        L6:
            return r101.size();
        }

        @Override // com.google.common.collect.d, com.google.common.collect.y1
        public int remove(@CheckForNull Object r100, int r101) {
            o.b(r101, "occurrences");
            if (r101 == 0) goto L5;
            Collection r102 = (Collection) Maps.h(this.f275274c.asMap(), r100);
            int r103 = 0;
            if (r102 != null) goto L9;
            return 0;
        L9:
            int r104 = r102.size();
            if (r101 < r104) goto L12;
            r102.clear();
        L15:
            return r104;
        L12:
            Iterator r105 = r102.iterator();
        L13:
            if (r103 >= r101) goto L15;
            r105.next();
            r105.remove();
            r103 = r103 + 1;
            goto L13
        L5:
            return count(r100);
        }
    }

    public static Collection a(Collection r100) {
        if ((r100 instanceof SortedSet) == false) goto L6;
        return Collections.unmodifiableSortedSet((SortedSet) r100);
    L6:
        if ((r100 instanceof Set) == false) goto L9;
        return Collections.unmodifiableSet((Set) r100);
    L9:
        if ((r100 instanceof List) == false) goto L12;
        return Collections.unmodifiableList((List) r100);
    L12:
        return Collections.unmodifiableCollection(r100);
    }

    public static <K, V> k2<K, V> b(k2<K, V> r100, com.google.common.base.n<? super K> r101) {
        if ((r100 instanceof z) == false) goto L7;
        z r102 = (z) r100;
        return new z((k2) r102.f275539f, Predicates.c(r102.f275540g, r101));
    L7:
        if ((r100 instanceof c0) == false) goto L11;
        c0 r103 = (c0) r100;
        com.google.common.base.n r104 = Maps.f(r101);
        com.google.common.base.n r105 = Predicates.c(r103.c(), r104);
        return new x(r103.a(), r105);
    L11:
        return new z(r100, r101);
    }
}
