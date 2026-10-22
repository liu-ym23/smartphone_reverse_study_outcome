package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultimap<K, V> extends l<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public z2<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        public EntryCollection(ImmutableMultimap<K, V> r100) {
            this.multimap = r100;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L6;
            Map.Entry r101 = (Map.Entry) r100;
            return this.multimap.containsEntry(r101.getKey(), r101.getValue());
        L6:
            return false;
        }
    }

    public class Keys extends ImmutableMultiset<K> {
        final /* synthetic */ ImmutableMultimap this$0;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
        public ImmutableSet<K> elementSet() {
            return this.this$0.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(this.this$0);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
        public /* bridge */ /* synthetic */ Set elementSet() {
            return elementSet();
        }

        public Keys(ImmutableMultimap r100) {
            this.this$0 = r100;
        }

        private void readObject(ObjectInputStream r100) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            return this.this$0.containsKey(r100);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
        public int count(@CheckForNull Object r100) {
            ImmutableCollection<V> r101 = this.this$0.map.get(r100);
            if (r101 != null) goto L6;
            return 0;
        L6:
            return r101.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public y1.a<K> getEntry(int r100) {
            Map.Entry<K, ? extends ImmutableCollection<V>> r101 = this.this$0.map.entrySet().asList().get(r100);
            return new Multisets.ImmutableEntry(r101.getKey(), r101.getValue().size());
        }
    }

    public static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        public Object readResolve() {
            return this.multimap.keys();
        }

        public KeysSerializedForm(ImmutableMultimap<?, ?> r100) {
            this.multimap = r100;
        }
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableMultimap<K, V> f275080b;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public z2<V> iterator() {
            return this.f275080b.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f275080b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        public Values(ImmutableMultimap<K, V> r100) {
            this.f275080b = r100;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            return this.f275080b.containsValue(r100);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r100, int r101) {
            z2<? extends ImmutableCollection<V>> r102 = this.f275080b.map.values().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101 = r102.next().copyIntoArray(r100, r101);
            goto L4
        L6:
            return r101;
        }
    }

    public class a extends z2<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z2 f275081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public K f275082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public z2 f275083c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275083c.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f275081a.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f275083c.hasNext() == true) goto L5;
            Map.Entry r100 = (Map.Entry) this.f275081a.next();
            this.f275082b = (K) r100.getKey();
            this.f275083c = ((ImmutableCollection) r100.getValue()).iterator();
        L5:
            K r101 = this.f275082b;
            Objects.requireNonNull(r101);
            return new ImmutableEntry(r101, this.f275083c.next());
        }

        public a(ImmutableMultimap r100) {
            this.f275081a = r100.map.entrySet().iterator();
            this.f275082b = null;
            this.f275083c = Iterators.b.f275137e;
        }
    }

    public class b extends z2<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z2 f275084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z2 f275085b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275085b.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f275084a.hasNext() == true) goto L8;
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public final V next() {
            if (this.f275085b.hasNext() == true) goto L6;
            this.f275085b = ((ImmutableCollection) this.f275084a.next()).iterator();
        L6:
            return (V) this.f275085b.next();
        }

        public b(ImmutableMultimap r100) {
            this.f275084a = r100.map.values().iterator();
            this.f275085b = Iterators.b.f275137e;
        }
    }

    @DoNotMock
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, Collection<V>> f275086a;

        public Collection<V> a() {
            return new ArrayList();
        }

        public c() {
            this.f275086a = CompactHashMap.create();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void c(Map.Entry r100) {
            b(r100.getKey(), r100.getValue());
        }

        public c<K, V> b(K r100, V r101) {
            o.a(r100, r101);
            Collection<V> r102 = this.f275086a.get(r100);
            if (r102 != null) goto L5;
            Map<K, Collection<V>> r103 = this.f275086a;
            Collection<V> r104 = a();
            r103.put(r100, r104);
            r102 = r104;
        L5:
            r102.add(r101);
            return this;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j2.a<ImmutableMultimap> f275087a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j2.a<ImmutableMultimap> f275088b = null;

        static {
            f275087a = j2.a(ImmutableMultimap.class, "map");
            f275088b = j2.a(ImmutableMultimap.class, "size");
        }
    }

    @Override // com.google.common.collect.q1
    public abstract ImmutableCollection<V> get(K r100);

    public abstract ImmutableMultimap<V, K> inverse();

    public static <K, V> c<K, V> builder() {
        return new c();
    }

    @Override // com.google.common.collect.q1
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.c
    public ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.c
    public z2<Map.Entry<K, V>> entryIterator() {
        return new a(this);
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.c
    public z2<V> valueIterator() {
        return new b(this);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.q1
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ y1 createKeys() {
        return createKeys();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ Iterator entryIterator() {
        return entryIterator();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ y1 keys() {
        return keys();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ Iterator valueIterator() {
        return valueIterator();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(q1<? extends K, ? extends V> r100) {
        if ((r100 instanceof ImmutableMultimap) == false) goto L8;
        ImmutableMultimap<K, V> r101 = (ImmutableMultimap) r100;
        if (r101.isPartialView() == true) goto L8;
        return r101;
    L8:
        return ImmutableListMultimap.copyOf(r100);
    }

    @Override // com.google.common.collect.q1
    public boolean containsKey(@CheckForNull Object r100) {
        return this.map.containsKey(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public boolean containsValue(@CheckForNull Object r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r100) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final boolean putAll(q1<? extends K, ? extends V> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q1
    public ImmutableCollection<V> removeAll(@CheckForNull Object r100) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
        return ImmutableListMultimap.copyOf(r100);
    }

    @Override // com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> r100, int r101) {
        this.map = r100;
        this.size = r101;
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r100, V r101) {
        return ImmutableListMultimap.of(r100, r101);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.containsEntry(r100, r101);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final boolean put(K r100, V r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final boolean putAll(K r100, Iterable<? extends V> r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableCollection<V> replaceValues(K r100, Iterable<? extends V> r101) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r100, V r101, K r102, V r103) {
        return ImmutableListMultimap.of(r100, r101, r102, r103);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105) {
        return ImmutableListMultimap.of(r100, r101, r102, r103, r104, r105);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107) {
        return ImmutableListMultimap.of(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r108, V r109) {
        return ImmutableListMultimap.of(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }
}
