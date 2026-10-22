package com.google.common.collect;

import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Sets {

    public static final class UnmodifiableNavigableSet<E> extends s0<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient UnmodifiableNavigableSet<E> f275324a;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.i(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> r100 = this.f275324a;
            if (r100 != null) goto L6;
            UnmodifiableNavigableSet<E> r101 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.f275324a = r101;
            r101.f275324a = this;
            return r101;
        L6:
            return r100;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s0, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.s0, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.s0, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.s0, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        public UnmodifiableNavigableSet(NavigableSet<E> r100) {
            r100.getClass();
            this.delegate = r100;
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E r100) {
            return this.delegate.ceiling(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E r100) {
            return this.delegate.floor(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E r100) {
            return this.delegate.higher(r100);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E r100) {
            return this.delegate.lower(r100);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E r100, boolean r101) {
            return Sets.f(this.delegate.headSet(r100, r101));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E r100, boolean r101) {
            return Sets.f(this.delegate.tailSet(r100, r101));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E r100, boolean r101, @ParametricNullness E r102, boolean r103) {
            return Sets.f(this.delegate.subSet(r100, r101, r102, r103));
        }
    }

    public static class a<E> extends p.a<E> implements Set<E> {
        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.c(this);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(@CheckForNull Object r100) {
            return Sets.a(this, r100);
        }

        public a(Set<E> r100, com.google.common.base.n<? super E> r101) {
            super(r100, r101);
        }
    }

    public static class b<E> extends a<E> implements SortedSet<E> {
        @Override // java.util.SortedSet
        @CheckForNull
        public final Comparator<? super E> comparator() {
            return ((SortedSet) this.f275489a).comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final E first() {
            Iterator<E> r100 = this.f275489a.iterator();
            com.google.common.base.n<? super E> r101 = this.f275490b;
            r100.getClass();
            r101.getClass();
        L4:
            if (r100.hasNext() == false) goto L9;
            E r102 = r100.next();
            if (r101.apply(r102) == false) goto L4;
            return r102;
        L9:
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public final E last() {
            SortedSet r100 = (SortedSet) this.f275489a;
        L3:
            E r101 = (Object) r100.last();
            if (this.f275490b.apply(r101) == true) goto L5;
            r100 = r100.headSet(r101);
            goto L3
        L5:
            return r101;
        }

        @Override // java.util.SortedSet
        public final SortedSet<E> headSet(@ParametricNullness E r100) {
            return new b(((SortedSet) this.f275489a).headSet(r100), this.f275490b);
        }

        @Override // java.util.SortedSet
        public final SortedSet<E> tailSet(@ParametricNullness E r100) {
            return new b(((SortedSet) this.f275489a).tailSet(r100), this.f275490b);
        }

        public b(SortedSet<E> r100, com.google.common.base.n<? super E> r101) {
            super(r100, r101);
        }

        @Override // java.util.SortedSet
        public final SortedSet<E> subSet(@ParametricNullness E r100, @ParametricNullness E r101) {
            return new b(((SortedSet) this.f275489a).subSet(r100, r101), this.f275490b);
        }
    }

    public static abstract class c<E> extends AbstractSet<E> {
        public c() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r100) {
            return Sets.d(this, r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r100) {
            r100.getClass();
            return super.retainAll(r100);
        }
    }

    public static int c(Set<?> r100) {
        Iterator<?> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L10;
        Object r103 = r101.next();
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L9:
        r102 = ~(~(r102 + r104));
        goto L4
    L8:
        r104 = 0;
        goto L9
    L10:
        return r102;
    }

    public static <E> NavigableSet<E> f(NavigableSet<E> r100) {
        if ((r100 instanceof ImmutableCollection) == false) goto L5;
    L9:
        return r100;
    L5:
        if ((r100 instanceof UnmodifiableNavigableSet) == true) goto L9;
        return new UnmodifiableNavigableSet(r100);
    }

    public static boolean a(Set<?> r100, @CheckForNull Object r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r101 instanceof Set) == false) goto L15;
        Set r102 = (Set) r101;
        if (r100.size() != r102.size()) goto L13;
        if (r100.containsAll(r102) == false) goto L13;
        return true;
    L13:
        return false;
    L15:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a b(Set r100, com.google.common.base.n r101) {
        if ((r100 instanceof SortedSet) == false) goto L10;
        SortedSet r102 = (SortedSet) r100;
        if ((r102 instanceof a) == false) goto L7;
        a r103 = (a) r102;
        com.google.common.base.n r104 = Predicates.c(r103.f275490b, r101);
        return new b((SortedSet) r103.f275489a, r104);
    L7:
        r102.getClass();
        r101.getClass();
        return new b(r102, r101);
    L10:
        if ((r100 instanceof a) == false) goto L13;
        a r105 = (a) r100;
        com.google.common.base.n r106 = Predicates.c(r105.f275490b, r101);
        return new a((Set) r105.f275489a, r106);
    L13:
        r100.getClass();
        r101.getClass();
        return new a(r100, r101);
    }

    public static boolean d(Set<?> r100, Collection<?> r101) {
        r101.getClass();
        if ((r101 instanceof y1) == false) goto L6;
        r101 = ((y1) r101).elementSet();
    L6:
        if ((r101 instanceof Set) == false) goto L12;
        if (r101.size() <= r100.size()) goto L12;
        return Iterators.g(r100.iterator(), r101);
    L12:
        return e(r100, r101.iterator());
    }

    public static boolean e(Set<?> r100, Iterator<?> r101) {
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 | r100.remove(r101.next());
        goto L4
    L6:
        return r102;
    }
}
