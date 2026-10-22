package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class o2 {

    public static class a<E> extends Multisets.b<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n2<E> f275488a;

        @Override // java.util.SortedSet
        public final Comparator<? super E> comparator() {
            return this.f275488a.comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final E first() {
            y1.a<E> r100 = this.f275488a.firstEntry();
            if (r100 == null) goto L7;
            return r100.getElement();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<E> iterator() {
            return new z1(this.f275488a.entrySet().iterator());
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final E last() {
            y1.a<E> r100 = this.f275488a.lastEntry();
            if (r100 == null) goto L7;
            return r100.getElement();
        L7:
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.Multisets.b
        public final y1 a() {
            return this.f275488a;
        }

        public a(n2<E> r100) {
            this.f275488a = r100;
        }

        @Override // java.util.SortedSet
        public final SortedSet<E> headSet(@ParametricNullness E r100) {
            return this.f275488a.headMultiset(r100, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public final SortedSet<E> tailSet(@ParametricNullness E r100) {
            return this.f275488a.tailMultiset(r100, BoundType.CLOSED).elementSet();
        }

        @Override // java.util.SortedSet
        public final SortedSet<E> subSet(@ParametricNullness E r100, @ParametricNullness E r101) {
            return this.f275488a.subMultiset(r100, BoundType.CLOSED, r101, BoundType.OPEN).elementSet();
        }
    }

    public static class b<E> extends a<E> implements NavigableSet<E> {
        @Override // java.util.NavigableSet
        public final NavigableSet<E> descendingSet() {
            return new b(this.f275488a.descendingMultiset());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final E pollFirst() {
            return (E) o2.a(this.f275488a.pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final E pollLast() {
            return (E) o2.a(this.f275488a.pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public final Iterator<E> descendingIterator() {
            return ((a) descendingSet()).iterator();
        }

        public b(n2<E> r100) {
            super(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final E ceiling(@ParametricNullness E r100) {
            return (E) o2.a(this.f275488a.tailMultiset(r100, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final E floor(@ParametricNullness E r100) {
            return (E) o2.a(this.f275488a.headMultiset(r100, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final E higher(@ParametricNullness E r100) {
            return (E) o2.a(this.f275488a.tailMultiset(r100, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final E lower(@ParametricNullness E r100) {
            return (E) o2.a(this.f275488a.headMultiset(r100, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<E> headSet(@ParametricNullness E r100, boolean r101) {
            return new b(this.f275488a.headMultiset(r100, BoundType.forBoolean(r101)));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<E> tailSet(@ParametricNullness E r100, boolean r101) {
            return new b(this.f275488a.tailMultiset(r100, BoundType.forBoolean(r101)));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<E> subSet(@ParametricNullness E r100, boolean r101, @ParametricNullness E r102, boolean r103) {
            return new b(this.f275488a.subMultiset(r100, BoundType.forBoolean(r101), r102, BoundType.forBoolean(r103)));
        }
    }

    public static Object a(y1.a r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getElement();
    }
}
