package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements k2<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient ImmutableSet<V> f275115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSetMultimap<V, K> f275116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSet<Map.Entry<K, V>> f275117h;

    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient ImmutableSetMultimap<K, V> f275118c;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public z2<Map.Entry<K, V>> iterator() {
            return this.f275118c.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f275118c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        public EntrySet(ImmutableSetMultimap<K, V> r100) {
            this.f275118c = r100;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L6;
            Map.Entry r101 = (Map.Entry) r100;
            return this.f275118c.containsEntry(r101.getKey(), r101.getValue());
        L6:
            return false;
        }
    }

    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public final ImmutableSetMultimap<K, V> d() {
            return ImmutableSetMultimap.fromMapEntries(this.f275086a.entrySet(), null);
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        public final Collection<V> a() {
            return CompactHashSet.create();
        }

        public a() {
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        public final void c(Map.Entry r100) {
            super.c(r100);
        }

        public final void f(Map.Entry r100) {
            super.c(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.c
        public final ImmutableMultimap.c b(Object r100, Object r101) {
            super.b(r100, r101);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void e(Object r100, Object r101) {
            super.b(r100, r101);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j2.a<ImmutableSetMultimap> f275119a = null;

        static {
            f275119a = j2.a(ImmutableSetMultimap.class, "emptySet");
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> r100 = this.f275117h;
        if (r100 != null) goto L6;
        EntrySet r101 = new EntrySet(this);
        this.f275117h = r101;
        return r101;
    L6:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> r100 = this.f275116g;
        if (r100 != null) goto L11;
        a r101 = builder();
        z2 r102 = entries().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.e(r103.getValue(), r103.getKey());
        goto L6
    L8:
        ImmutableSetMultimap<V, K> r104 = r101.d();
        r104.f275116g = this;
        this.f275116g = r104;
        return r104;
    L11:
        return r100;
    }

    @CheckForNull
    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> r100 = this.f275115f;
        if ((r100 instanceof ImmutableSortedSet) == true) goto L7;
        return null;
    L7:
        return ((ImmutableSortedSet) r100).comparator();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set entries() {
        return entries();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(q1<? extends K, ? extends V> r100) {
        r100.getClass();
        if (r100.isEmpty() == false) goto L6;
        return of();
    L6:
        if ((r100 instanceof ImmutableSetMultimap) == false) goto L11;
        ImmutableSetMultimap<K, V> r101 = (ImmutableSetMultimap) r100;
        if (r101.isPartialView() == true) goto L11;
        return r101;
    L11:
        return fromMapEntries(r100.asMap().entrySet(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r110) throws IOException, ClassNotFoundException {
        r110.defaultReadObject();
        Comparator r100 = (Comparator) r110.readObject();
        int r101 = r110.readInt();
        if (r101 < 0) goto L37;
        ImmutableMap.b r102 = ImmutableMap.builder();
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r101) goto L38;
        Object r105 = r110.readObject();
        int r106 = r110.readInt();
        if (r106 <= 0) goto L20;
        if (r100 != null) goto L10;
        ImmutableSet.a r107 = new ImmutableSet.a();
    L11:
        int r108 = 0;
    L12:
        if (r108 >= r106) goto L14;
        r107.d(r110.readObject());
        r108 = r108 + 1;
        goto L12
    L14:
        ImmutableSet r109 = r107.f();
        if (r109.size() != r106) goto L18;
        r102.e(r105, r109);
        r104 = r104 + r106;
        r103 = r103 + 1;
        goto L5
    L18:
        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + r105);
    L10:
        r107 = new ImmutableSortedSet.a(r100);
        goto L11
    L20:
        throw new InvalidObjectException("Invalid value count " + r106);
    L38:
        ImmutableMultimap.d.f275087a.a(this, r102.d());
        j2.a<ImmutableMultimap> r111 = ImmutableMultimap.d.f275088b;
        r111.getClass();
        r111.f275479a.set(this, Integer.valueOf(r104));     // Catch: IllegalAccessException -> L30
        j2.a<ImmutableSetMultimap> r112 = b.f275119a;
        if (r100 != null) goto L27;
        Object r113 = ImmutableSet.of();
    L28:
        r112.a(this, r113);
        return;
    L27:
        r113 = ImmutableSortedSet.emptySet(r100);
    L30:
        e = move-exception;
        throw new AssertionError(e);
    L33:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L37:
        throw new InvalidObjectException("Invalid key count " + r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(valueComparator());
        j2.f(this, r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public ImmutableSet<V> get(K r100) {
        return (ImmutableSet) com.google.common.base.j.a((ImmutableSet) this.map.get(r100), this.f275115f);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public final ImmutableSet<V> removeAll(@CheckForNull Object r100) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
        a r101 = new a();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.c(r102.next());
        goto L4
    L7:
        return r101.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r100, @CheckForNull Comparator<? super V> r101) {
        if (r100.isEmpty() == true) goto L5;
        ImmutableMap.b r102 = new ImmutableMap.b(r100.size());
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r103 = r100.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<? extends K, ? extends Collection<? extends V>> r105 = r103.next();
        K r106 = r105.getKey();
        Collection<? extends V> r107 = r105.getValue();
        if (r101 != null) goto L12;
        AbstractCollection r108 = ImmutableSet.copyOf(r107);
    L14:
        if (r108.isEmpty() == true) goto L8;
        r102.e(r106, r108);
        r104 = r104 + r108.size();
        goto L8
    L12:
        r108 = ImmutableSortedSet.copyOf(r101, r107);
        goto L14
    L17:
        return new ImmutableSetMultimap(r102.b(true), r104, r101);
    L5:
        return of();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r100, V r101) {
        a r102 = builder();
        r102.e(r100, r101);
        return r102.d();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public final ImmutableSet<V> replaceValues(K r100, Iterable<? extends V> r101) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> r100, int r101, @CheckForNull Comparator<? super V> r102) {
        super(r100, r101);
        if (r102 != null) goto L5;
        ImmutableSet<V> r103 = ImmutableSet.of();
    L6:
        this.f275115f = r103;
        return;
    L5:
        r103 = ImmutableSortedSet.emptySet(r102);
        goto L6
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r100, V r101, K r102, V r103) {
        a r104 = builder();
        r104.e(r100, r101);
        r104.e(r102, r103);
        return r104.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105) {
        a r106 = builder();
        r106.e(r100, r101);
        r106.e(r102, r103);
        r106.e(r104, r105);
        return r106.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107) {
        a r108 = builder();
        r108.e(r100, r101);
        r108.e(r102, r103);
        r108.e(r104, r105);
        r108.e(r106, r107);
        return r108.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r108, V r110) {
        a r109 = builder();
        r109.e(r100, r101);
        r109.e(r102, r103);
        r109.e(r104, r105);
        r109.e(r106, r107);
        r109.e(r108, r110);
        return r109.d();
    }
}
