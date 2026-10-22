package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Synchronized {

    public static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;

        @CheckForNull
        transient Collection<Collection<V>> asMapValues;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapEntrySet != null) goto L7;
            this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, Collection<V>>> r101 = this.asMapEntrySet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapValues != null) goto L7;
            this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<Collection<V>> r101 = this.asMapValues;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(@CheckForNull Object r100) {
            return values().contains(r100);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        @CheckForNull
        public Collection<V> get(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Collection r102 = (Collection) super.get(r100);     // Catch: Throwable -> L10
            if (r102 != null) goto L7;
            Collection<V> r103 = null;
        L8:
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r103;
        L7:
            r103 = Synchronized.b(r102, this.mutex);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r100) {
            return get(r100);
        }

        public SynchronizedAsMap(Map<K, Collection<V>> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }
    }

    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        public class a extends v2<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SynchronizedAsMapEntries f275358b;

            @Override // com.google.common.collect.v2
            public final Object a(Object r100) {
                return new s2(this, (Map.Entry) r100);
            }

            public a(SynchronizedAsMapEntries r100, Iterator r101) {
                this.f275358b = r100;
                super(r101);
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new a(this, super.iterator());
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Set<Map.Entry<K, Collection<V>>> r101 = delegate();     // Catch: Throwable -> L7
            Object[] r102 = new Object[r101.size()];     // Catch: Throwable -> L7
            b2.b(r101, r102);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Set<Map.Entry<K, Collection<V>>> r102 = delegate();     // Catch: Throwable -> L10
            if ((r100 instanceof Map.Entry) == true) goto L7;
            boolean r103 = false;
        L8:
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r103;
        L7:
            Map.Entry r104 = (Map.Entry) r100;     // Catch: Throwable -> L10
            r104.getClass();     // Catch: Throwable -> L10
            r103 = r102.contains(new l1(r104));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = p.a(delegate(), r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = Sets.a(delegate(), r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Set<Map.Entry<K, Collection<V>>> r102 = delegate();     // Catch: Throwable -> L10
            if ((r100 instanceof Map.Entry) == true) goto L7;
            boolean r103 = false;
        L8:
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r103;
        L7:
            Map.Entry r104 = (Map.Entry) r100;     // Catch: Throwable -> L10
            r104.getClass();     // Catch: Throwable -> L10
            r103 = r102.remove(new l1(r104));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = Iterators.g(delegate().iterator(), r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Iterator<Map.Entry<K, Collection<V>>> r102 = delegate().iterator();     // Catch: Throwable -> L12
            r100.getClass();     // Catch: Throwable -> L12
            boolean r103 = false;
        L6:
            if (r102.hasNext() == false) goto L10;
            if (r100.contains(r102.next()) == true) goto L6;
            r102.remove();     // Catch: Throwable -> L12
            r103 = true;
            goto L6
        L10:
            monitor-exit(r101);     // Catch: Throwable -> L12
            return r103;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            T[] r102 = (T[]) b2.c(delegate(), r100);
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }
    }

    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        public class a extends v2<Collection<V>, Collection<V>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SynchronizedAsMapValues f275359b;

            @Override // com.google.common.collect.v2
            public final Object a(Object r100) {
                return Synchronized.b((Collection) r100, this.f275359b.mutex);
            }

            public a(SynchronizedAsMapValues r100, Iterator r101) {
                this.f275359b = r100;
                super(r101);
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new a(this, super.iterator());
        }

        public SynchronizedAsMapValues(Collection<Collection<V>> r100, @CheckForNull Object r101) {
            super(r100, r101, null);
        }
    }

    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements m<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient Set<V> f275360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public transient m<V, K> f275361b;

        @Override // com.google.common.collect.m
        public m<V, K> inverse() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.f275361b != null) goto L7;
            this.f275361b = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);     // Catch: Throwable -> L10
        L7:
            m<V, K> r101 = this.f275361b;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.f275360a != null) goto L7;
            this.f275360a = new SynchronizedSet(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<V> r101 = this.f275360a;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public m<K, V> delegate() {
            return (m) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.m
        @CheckForNull
        public V forcePut(@ParametricNullness K r100, @ParametricNullness V r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            V r103 = delegate().forcePut(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedBiMap(m<K, V> r100, @CheckForNull Object r101, @CheckForNull m<V, K> r102) {
            super(r100, r101);
            this.f275361b = r102;
        }

        public /* synthetic */ SynchronizedBiMap(m r100, Object r101, m r102, a r103) {
            this(r100, r101, r102);
        }
    }

    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedCollection() {
            throw null;
        }

        @Override // java.util.Collection
        public void clear() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            boolean r101 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public int size() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public Object[] toArray() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Object[] r101 = delegate().toArray();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Collection
        public boolean add(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().add(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().addAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean contains(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().contains(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsAll(Collection<?> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean remove(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().remove(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean removeAll(Collection<?> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().removeAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean retainAll(Collection<?> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().retainAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public <T> T[] toArray(T[] r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            T[] r102 = (T[]) delegate().toArray(r100);
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedCollection(Collection r100, Object r101, a r102) {
            super(r100, r101);
        }
    }

    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Iterator<E> r101 = delegate().descendingIterator();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getFirst() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().getFirst();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getLast() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().getLast();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E peekFirst() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().peekFirst();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E peekLast() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().peekLast();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E pollFirst() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E pollLast() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pop() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().pop();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeFirst() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().removeFirst();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeLast() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().removeLast();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Queue delegate() {
            return delegate();
        }

        @Override // java.util.Deque
        public void addFirst(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            delegate().addFirst(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void addLast(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            delegate().addLast(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().offerFirst(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerLast(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().offerLast(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void push(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            delegate().push(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().removeFirstOccurrence(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().removeLastOccurrence(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedDeque(Deque<E> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }
    }

    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Map.Entry
        public K getKey() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            K r101 = delegate().getKey();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            V r101 = delegate().getValue();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Map.Entry
        public boolean equals(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            V r102 = delegate().setValue(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedEntry(Map.Entry<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }
    }

    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            return (List) super.delegate();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E get(int r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            E r102 = delegate().get(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            int r102 = delegate().indexOf(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            int r102 = delegate().lastIndexOf(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int r100) {
            return delegate().listIterator(r100);
        }

        @Override // java.util.List
        public E remove(int r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            E r102 = delegate().remove(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedList(List<E> r100, @CheckForNull Object r101) {
            super(r100, r101, null);
        }

        @Override // java.util.List
        public void add(int r100, E r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            delegate().add(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public boolean addAll(int r100, Collection<? extends E> r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            boolean r103 = delegate().addAll(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E set(int r100, E r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            E r103 = delegate().set(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public List<E> subList(int r100, int r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            List<E> r103 = Synchronized.d(delegate().subList(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements f1<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public f1<K, V> delegate() {
            return (f1) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ q1 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public List<V> get(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            List<V> r102 = Synchronized.d(delegate().get(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public List<V> removeAll(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            List<V> r102 = delegate().removeAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        public SynchronizedListMultimap(f1<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public List<V> replaceValues(K r100, Iterable<? extends V> r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            List<V> r103 = delegate().replaceValues(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<Map.Entry<K, V>> entrySet;

        @CheckForNull
        transient Set<K> keySet;

        @CheckForNull
        transient Collection<V> values;

        @Override // java.util.Map
        public void clear() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = new SynchronizedSet(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, V>> r101 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // java.util.Map
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            boolean r101 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L7;
            this.keySet = new SynchronizedSet(delegate().keySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<K> r101 = this.keySet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // java.util.Map
        public int size() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> values() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.values != null) goto L7;
            this.values = new SynchronizedCollection(delegate().values(), this.mutex, null);     // Catch: Throwable -> L10
        L7:
            Collection<V> r101 = this.values;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Map
        public boolean containsKey(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsKey(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsValue(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsValue(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        @CheckForNull
        public V get(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            V r102 = delegate().get(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            delegate().putAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            V r102 = delegate().remove(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedMap(Map<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // java.util.Map
        @CheckForNull
        public V put(K r100, V r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            V r103 = delegate().put(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements q1<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Map<K, Collection<V>> asMap;

        @CheckForNull
        transient Collection<Map.Entry<K, V>> entries;

        @CheckForNull
        transient Set<K> keySet;

        @CheckForNull
        transient y1<K> keys;

        @CheckForNull
        transient Collection<V> valuesCollection;

        @Override // com.google.common.collect.q1
        public Map<K, Collection<V>> asMap() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMap != null) goto L7;
            this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Map<K, Collection<V>> r101 = this.asMap;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.q1
        public void clear() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public Collection<Map.Entry<K, V>> entries() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entries != null) goto L7;
            this.entries = Synchronized.b(delegate().entries(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<Map.Entry<K, V>> r101 = this.entries;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.q1
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean isEmpty() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            boolean r101 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public Set<K> keySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L7;
            this.keySet = Synchronized.a(delegate().keySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<K> r101 = this.keySet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.q1
        public y1<K> keys() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L16:
            th = move-exception;
            throw th;
        L5:
            if (this.keys != null) goto L13;
            y1<K> r101 = delegate().keys();     // Catch: Throwable -> L16
            Object r102 = this.mutex;     // Catch: Throwable -> L16
            if ((r101 instanceof SynchronizedMultiset) == false) goto L9;
        L12:
            this.keys = r101;     // Catch: Throwable -> L16
            goto L13
        L9:
            if ((r101 instanceof ImmutableMultiset) == true) goto L12;
            r101 = new SynchronizedMultiset(r101, r102);     // Catch: Throwable -> L16
        L13:
            y1<K> r103 = this.keys;     // Catch: Throwable -> L16
            monitor-exit(r100);     // Catch: Throwable -> L16
            return r103;
        }

        @Override // com.google.common.collect.q1
        public int size() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public Collection<V> values() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.valuesCollection != null) goto L7;
            this.valuesCollection = new SynchronizedCollection(delegate().values(), this.mutex, null);     // Catch: Throwable -> L10
        L7:
            Collection<V> r101 = this.valuesCollection;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public q1<K, V> delegate() {
            return (q1) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.q1
        public boolean containsKey(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsKey(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean containsValue(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsValue(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        public Collection<V> get(@ParametricNullness K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Collection<V> r102 = Synchronized.b(delegate().get(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean putAll(q1<? extends K, ? extends V> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().putAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> removeAll(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Collection<V> r102 = delegate().removeAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedMultimap(q1<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // com.google.common.collect.q1
        public boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            boolean r103 = delegate().containsEntry(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            boolean r103 = delegate().put(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean putAll(@ParametricNullness K r100, Iterable<? extends V> r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            boolean r103 = delegate().putAll(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.q1
        public boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            boolean r103 = delegate().remove(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            Collection<V> r103 = delegate().replaceValues(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements y1<E> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<E> elementSet;

        @CheckForNull
        transient Set<y1.a<E>> entrySet;

        @Override // com.google.common.collect.y1
        public Set<E> elementSet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.elementSet != null) goto L7;
            this.elementSet = Synchronized.a(delegate().elementSet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<E> r101 = this.elementSet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.y1
        public Set<y1.a<E>> entrySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.a(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<y1.a<E>> r101 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // java.util.Collection, com.google.common.collect.y1
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public y1<E> delegate() {
            return (y1) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.y1
        public int count(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            int r102 = delegate().count(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, com.google.common.collect.y1
        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        public SynchronizedMultiset(y1<E> r100, @CheckForNull Object r101) {
            super(r100, r101, null);
        }

        @Override // com.google.common.collect.y1
        public int add(@ParametricNullness E r100, int r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            int r103 = delegate().add(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.y1
        public int remove(@CheckForNull Object r100, int r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            int r103 = delegate().remove(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.y1
        public int setCount(@ParametricNullness E r100, int r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            int r103 = delegate().setCount(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.y1
        public boolean setCount(@ParametricNullness E r100, int r101, int r102) {
            Object r103 = this.mutex;
            monitor-enter(r103);
            boolean r104 = delegate().setCount(r100, r101, r102);     // Catch: Throwable -> L7
            monitor-exit(r103);     // Catch: Throwable -> L7
            return r104;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient NavigableSet<K> descendingKeySet;

        @CheckForNull
        transient NavigableMap<K, V> descendingMap;

        @CheckForNull
        transient NavigableSet<K> navigableKeySet;

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            NavigableSet<K> r101 = this.descendingKeySet;     // Catch: Throwable -> L11
            if (r101 != null) goto L9;
            SynchronizedNavigableSet r102 = new SynchronizedNavigableSet(delegate().descendingKeySet(), this.mutex);     // Catch: Throwable -> L11
            this.descendingKeySet = r102;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r102;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            NavigableMap<K, V> r101 = this.descendingMap;     // Catch: Throwable -> L11
            if (r101 != null) goto L9;
            SynchronizedNavigableMap r102 = new SynchronizedNavigableMap(delegate().descendingMap(), this.mutex);     // Catch: Throwable -> L11
            this.descendingMap = r102;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r102;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Map.Entry<K, V> r101 = Synchronized.c(delegate().firstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Map.Entry<K, V> r101 = Synchronized.c(delegate().lastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            NavigableSet<K> r101 = this.navigableKeySet;     // Catch: Throwable -> L11
            if (r101 != null) goto L9;
            SynchronizedNavigableSet r102 = new SynchronizedNavigableSet(delegate().navigableKeySet(), this.mutex);     // Catch: Throwable -> L11
            this.navigableKeySet = r102;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r102;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Map.Entry<K, V> r101 = Synchronized.c(delegate().pollFirstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Map.Entry<K, V> r101 = Synchronized.c(delegate().pollLastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ SortedMap delegate() {
            return delegate();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Map.Entry<K, V> r102 = Synchronized.c(delegate().ceilingEntry(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            K r102 = delegate().ceilingKey(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Map.Entry<K, V> r102 = Synchronized.c(delegate().floorEntry(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            K r102 = delegate().floorKey(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K r100) {
            return headMap(r100, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Map.Entry<K, V> r102 = Synchronized.c(delegate().higherEntry(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            K r102 = delegate().higherKey(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Map.Entry<K, V> r102 = Synchronized.c(delegate().lowerEntry(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            K r102 = delegate().lowerKey(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K r100) {
            return tailMap(r100, true);
        }

        public SynchronizedNavigableMap(NavigableMap<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r100, boolean r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SynchronizedNavigableMap r103 = new SynchronizedNavigableMap(delegate().headMap(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K r100, K r101) {
            return subMap(r100, true, r101, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r100, boolean r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SynchronizedNavigableMap r103 = new SynchronizedNavigableMap(delegate().tailMap(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r100, boolean r101, K r102, boolean r103) {
            Object r104 = this.mutex;
            monitor-enter(r104);
            SynchronizedNavigableMap r105 = new SynchronizedNavigableMap(delegate().subMap(r100, r101, r102, r103), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r104);     // Catch: Throwable -> L7
            return r105;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient NavigableSet<E> descendingSet;

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            NavigableSet<E> r101 = this.descendingSet;     // Catch: Throwable -> L11
            if (r101 != null) goto L9;
            SynchronizedNavigableSet r102 = new SynchronizedNavigableSet(delegate().descendingSet(), this.mutex);     // Catch: Throwable -> L11
            this.descendingSet = r102;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r102;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            E r102 = delegate().ceiling(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            E r102 = delegate().floor(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E r100) {
            return headSet(r100, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            E r102 = delegate().higher(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            E r102 = delegate().lower(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E r100) {
            return tailSet(r100, true);
        }

        public SynchronizedNavigableSet(NavigableSet<E> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r100, boolean r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SynchronizedNavigableSet r103 = new SynchronizedNavigableSet(delegate().headSet(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E r100, E r101) {
            return subSet(r100, true, r101, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r100, boolean r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SynchronizedNavigableSet r103 = new SynchronizedNavigableSet(delegate().tailSet(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r100, boolean r101, E r102, boolean r103) {
            Object r104 = this.mutex;
            monitor-enter(r104);
            SynchronizedNavigableSet r105 = new SynchronizedNavigableSet(delegate().subSet(r100, r101, r102, r103), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r104);     // Catch: Throwable -> L7
            return r105;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        public String toString() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            String r101 = this.delegate.toString();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        Object delegate() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            Object r101 = this.mutex;
            monitor-enter(r101);
            r100.defaultWriteObject();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedObject(Object r100, @CheckForNull Object r101) {
            r100.getClass();
            this.delegate = r100;
            if (r101 != null) goto L5;
            r101 = this;
        L5:
            this.mutex = r101;
        }
    }

    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Queue
        public E element() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().element();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        @CheckForNull
        public E peek() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().peek();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        @CheckForNull
        public E poll() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().poll();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E remove() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().remove();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Queue<E> delegate() {
            return (Queue) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // java.util.Queue
        public boolean offer(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().offer(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedQueue(Queue<E> r100, @CheckForNull Object r101) {
            super(r100, r101, null);
        }
    }

    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        public SynchronizedRandomAccessList(List<E> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }
    }

    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Set<E> delegate() {
            return (Set) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        public SynchronizedSet(Set<E> r100, @CheckForNull Object r101) {
            super(r100, r101, null);
        }
    }

    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements k2<K, V> {
        private static final long serialVersionUID = 0;

        @CheckForNull
        transient Set<Map.Entry<K, V>> entrySet;

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public Set<Map.Entry<K, V>> entries() {
            Object r100 = this.mutex;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = new SynchronizedSet(delegate().entries(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, V>> r101 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public k2<K, V> delegate() {
            return (k2) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ q1 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public Set<V> get(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedSet r102 = new SynchronizedSet(delegate().get(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public Set<V> removeAll(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            Set<V> r102 = delegate().removeAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        public SynchronizedSetMultimap(k2<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public Set<V> replaceValues(K r100, Iterable<? extends V> r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            Set<V> r103 = delegate().replaceValues(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Comparator<? super K> r101 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            K r101 = delegate().firstKey();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            K r101 = delegate().lastKey();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        public SortedMap<K, V> headMap(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedSortedMap r102 = new SynchronizedSortedMap(delegate().headMap(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> tailMap(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedSortedMap r102 = new SynchronizedSortedMap(delegate().tailMap(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedSortedMap(SortedMap<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        public SortedMap<K, V> subMap(K r100, K r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SynchronizedSortedMap r103 = new SynchronizedSortedMap(delegate().subMap(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Comparator<? super E> r101 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedSet
        public E first() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().first();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedSet
        public E last() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            E r101 = delegate().last();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        public SortedSet<E> headSet(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedSortedSet r102 = new SynchronizedSortedSet(delegate().headSet(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> tailSet(E r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedSortedSet r102 = new SynchronizedSortedSet(delegate().tailSet(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedSortedSet(SortedSet<E> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        public SortedSet<E> subSet(E r100, E r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SynchronizedSortedSet r103 = new SynchronizedSortedSet(delegate().subSet(r100, r101), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements p2<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.p2
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            Comparator<? super V> r101 = delegate().valueComparator();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public p2<K, V> delegate() {
            return (p2) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ k2 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ q1 delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public SortedSet<V> get(K r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedSortedSet r102 = new SynchronizedSortedSet(delegate().get(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public SortedSet<V> removeAll(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SortedSet<V> r102 = delegate().removeAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection get(Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Set get(Object r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r100) {
            return removeAll(r100);
        }

        public SynchronizedSortedSetMultimap(p2<K, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public SortedSet<V> replaceValues(K r100, Iterable<? extends V> r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            SortedSet<V> r103 = delegate().replaceValues(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.q1
        public /* bridge */ /* synthetic */ Set replaceValues(Object r100, Iterable r101) {
            return replaceValues(r100, r101);
        }
    }

    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements t2<R, C, V> {

        public class a implements com.google.common.base.g<Map<C, V>, Map<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SynchronizedTable f275362a;

            public a(SynchronizedTable r100) {
                this.f275362a = r100;
            }

            @Override // com.google.common.base.g
            public final Object apply(Object r100) {
                return new SynchronizedMap((Map) r100, this.f275362a.mutex);
            }
        }

        public class b implements com.google.common.base.g<Map<R, V>, Map<R, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SynchronizedTable f275363a;

            public b(SynchronizedTable r100) {
                this.f275363a = r100;
            }

            @Override // com.google.common.base.g
            public final Object apply(Object r100) {
                return new SynchronizedMap((Map) r100, this.f275363a.mutex);
            }
        }

        @Override // com.google.common.collect.t2
        public Set<t2.a<R, C, V>> cellSet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            SynchronizedSet r101 = new SynchronizedSet(delegate().cellSet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public void clear() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public Set<C> columnKeySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            SynchronizedSet r101 = new SynchronizedSet(delegate().columnKeySet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public Map<C, Map<R, V>> columnMap() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            SynchronizedMap r101 = new SynchronizedMap(Maps.j(delegate().columnMap(), new b(this)), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public int hashCode() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public boolean isEmpty() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            boolean r101 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public Set<R> rowKeySet() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            SynchronizedSet r101 = new SynchronizedSet(delegate().rowKeySet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public Map<R, Map<C, V>> rowMap() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            SynchronizedMap r101 = new SynchronizedMap(Maps.j(delegate().rowMap(), new a(this)), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public int size() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            int r101 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public Collection<V> values() {
            Object r100 = this.mutex;
            monitor-enter(r100);
            SynchronizedCollection r101 = new SynchronizedCollection(delegate().values(), this.mutex, null);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public t2<R, C, V> delegate() {
            return (t2) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.t2
        public Map<R, V> column(@ParametricNullness C r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedMap r102 = new SynchronizedMap(delegate().column(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public boolean containsColumn(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsColumn(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public boolean containsRow(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsRow(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public boolean containsValue(@CheckForNull Object r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().containsValue(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public boolean equals(@CheckForNull Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            Object r101 = this.mutex;
            monitor-enter(r101);
            boolean r102 = delegate().equals(r100);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public void putAll(t2<? extends R, ? extends C, ? extends V> r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            delegate().putAll(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        public Map<C, V> row(@ParametricNullness R r100) {
            Object r101 = this.mutex;
            monitor-enter(r101);
            SynchronizedMap r102 = new SynchronizedMap(delegate().row(r100), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedTable(t2<R, C, V> r100, @CheckForNull Object r101) {
            super(r100, r101);
        }

        @Override // com.google.common.collect.t2
        public boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            boolean r103 = delegate().contains(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        @CheckForNull
        public V get(@CheckForNull Object r100, @CheckForNull Object r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            V r103 = delegate().get(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        @CheckForNull
        public V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
            Object r102 = this.mutex;
            monitor-enter(r102);
            V r103 = delegate().remove(r100, r101);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return r103;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.t2
        @CheckForNull
        public V put(@ParametricNullness R r100, @ParametricNullness C r101, @ParametricNullness V r102) {
            Object r103 = this.mutex;
            monitor-enter(r103);
            V r104 = delegate().put(r100, r101, r102);     // Catch: Throwable -> L7
            monitor-exit(r103);     // Catch: Throwable -> L7
            return r104;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ class a {
    }

    public static Set a(Set r100, Object r101) {
        if ((r100 instanceof SortedSet) == false) goto L6;
        return new SynchronizedSortedSet((SortedSet) r100, r101);
    L6:
        return new SynchronizedSet(r100, r101);
    }

    public static Collection b(Collection r100, Object r101) {
        if ((r100 instanceof SortedSet) == false) goto L6;
        return new SynchronizedSortedSet((SortedSet) r100, r101);
    L6:
        if ((r100 instanceof Set) == false) goto L9;
        return new SynchronizedSet((Set) r100, r101);
    L9:
        if ((r100 instanceof List) == false) goto L12;
        return d((List) r100, r101);
    L12:
        return new SynchronizedCollection(r100, r101, null);
    }

    public static Map.Entry c(Map.Entry r100, Object r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new SynchronizedEntry(r100, r101);
    }

    public static <E> List<E> d(List<E> r100, @CheckForNull Object r101) {
        if ((r100 instanceof RandomAccess) == false) goto L6;
        return new SynchronizedRandomAccessList(r100, r101);
    L6:
        return new SynchronizedList(r100, r101);
    }
}
