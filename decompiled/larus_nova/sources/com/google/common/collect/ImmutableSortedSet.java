package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, l2<E> {
    final transient Comparator<? super E> comparator;

    @CheckForNull
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public Object readResolve() {
            a r100 = new a(this.comparator);
            Object[] r101 = this.elements;
            int r102 = 0;
            if (r100.f275113d == null) goto L7;
            int r103 = r101.length;
        L5:
            if (r102 >= r103) goto L9;
            r100.d(r101[r102]);
            r102 = r102 + 1;
        L9:
            return r100.h();
        L7:
            int r104 = r101.length;
            b2.a(r101, r104);
            r100.c(r100.f275056b + r104);
            System.arraycopy(r101, 0, r100.f275055a, r100.f275056b, r104);
            r100.f275056b += r104;
            goto L9
        }

        public SerializedForm(Comparator<? super E> r100, Object[] r101) {
            this.comparator = r100;
            this.elements = r101;
        }
    }

    public static final class a<E> extends ImmutableSet.a<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Comparator<? super E> f275133f;

        @Override // com.google.common.collect.ImmutableSet.a
        public final ImmutableSet.a e(Iterator r100) {
            throw null;
        }

        public final ImmutableSortedSet<E> h() {
            Object[] r100 = this.f275055a;
            ImmutableSortedSet<E> r101 = ImmutableSortedSet.construct(this.f275133f, this.f275056b, r100);
            this.f275056b = r101.size();
            this.f275057c = true;
            return r101;
        }

        @Override // com.google.common.collect.ImmutableSet.a
        public final /* bridge */ /* synthetic */ ImmutableSet f() {
            return h();
        }

        public a(Comparator<? super E> r100) {
            r100.getClass();
            this.f275133f = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a
        public final ImmutableSet.a d(Object r100) {
            super.d(r100);
            return this;
        }

        public final void g(Iterator r100) {
            super.e(r100);
        }
    }

    public abstract ImmutableSortedSet<E> createDescendingSet();

    public abstract z2<E> descendingIterator();

    public abstract ImmutableSortedSet<E> headSetImpl(E r100, boolean r101);

    public abstract int indexOf(@CheckForNull Object r100);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract z2<E> iterator();

    public abstract ImmutableSortedSet<E> subSetImpl(E r100, boolean r101, E r102, boolean r103);

    public abstract ImmutableSortedSet<E> tailSetImpl(E r100, boolean r101);

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a(Collections.reverseOrder());
    }

    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> r100 = this.descendingSet;
        if (r100 != null) goto L6;
        ImmutableSortedSet<E> r101 = createDescendingSet();
        this.descendingSet = r101;
        r101.descendingSet = this;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    public E first() {
        return iterator().next();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public E last() {
        return descendingIterator().next();
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    @Override // java.util.SortedSet, com.google.common.collect.l2
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        return descendingSet();
    }

    public ImmutableSortedSet(Comparator<? super E> r100) {
        this.comparator = r100;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] r100) {
        return construct(Ordering.natural(), r100.length, (Comparable[]) r100.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> r100) {
        Comparator<? super E> r101 = r100.comparator();
        if (r101 != null) goto L5;
        r101 = Ordering.natural();
    L5:
        ImmutableList r102 = ImmutableList.copyOf(r100);
        if (r102.isEmpty() == false) goto L10;
        return emptySet(r101);
    L10:
        return new RegularImmutableSortedSet(r102, r101);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> r100) {
        if (Ordering.natural().equals(r100) == false) goto L7;
        return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    L7:
        return new RegularImmutableSortedSet(ImmutableList.of(), r100);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r100) {
        return new RegularImmutableSortedSet(ImmutableList.of(r100), Ordering.natural());
    }

    public static <E> a<E> orderedBy(Comparator<E> r100) {
        return new a(r100);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @CheckForNull
    public E ceiling(E r100) {
        return (E) Iterators.d(tailSet(r100, true).iterator());
    }

    @CheckForNull
    public E floor(E r100) {
        return (E) Iterators.d(headSet(r100, true).descendingIterator());
    }

    public ImmutableSortedSet<E> headSet(E r100) {
        return headSet(r100, false);
    }

    @CheckForNull
    public E higher(E r100) {
        return (E) Iterators.d(tailSet(r100, false).iterator());
    }

    @CheckForNull
    public E lower(E r100) {
        return (E) Iterators.d(headSet(r100, false).descendingIterator());
    }

    public ImmutableSortedSet<E> tailSet(E r100) {
        return tailSet(r100, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> r100) {
        return copyOf(Ordering.natural(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r100) {
        return headSet(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r100) {
        return tailSet(r100);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> r100) {
        return copyOf(Ordering.natural(), r100);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> r100) {
        return copyOf(Ordering.natural(), r100);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r100, Iterable<? extends E> r101) {
        r100.getClass();
        if (m2.a(r100, r101) == false) goto L10;
        if ((r101 instanceof ImmutableSortedSet) == false) goto L10;
        ImmutableSortedSet<E> r102 = (ImmutableSortedSet) r101;
        if (r102.isPartialView() == true) goto L10;
        return r102;
    L10:
        if ((r101 instanceof Collection) == false) goto L12;
        Collection r103 = (Collection) r101;
    L13:
        Object[] r104 = r103.toArray();
        return construct(r100, r104.length, r104);
    L12:
        r103 = Lists.c(r101.iterator());
        goto L13
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r100, Comparable r101) {
        return construct(Ordering.natural(), 2, new Comparable[]{r100, r101});
    }

    public ImmutableSortedSet<E> headSet(E r100, boolean r101) {
        r100.getClass();
        return headSetImpl(r100, r101);
    }

    public ImmutableSortedSet<E> subSet(E r100, E r101) {
        return subSet(r100, true, r101, false);
    }

    public ImmutableSortedSet<E> tailSet(E r100, boolean r101) {
        r100.getClass();
        return tailSetImpl(r100, r101);
    }

    public int unsafeCompare(Object r100, @CheckForNull Object r101) {
        return unsafeCompare(this.comparator, r100, r101);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r100, Iterator<? extends E> r101) {
        a r102 = new a(r100);
        r102.g(r101);
        return r102.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r100, boolean r101) {
        return headSet(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r100, Object r101) {
        return subSet(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r100, boolean r101) {
        return tailSet(r100, r101);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r100, Collection<? extends E> r101) {
        return copyOf(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> r100, int r101, E... r102) {
        if (r101 == 0) goto L4;
        b2.a(r102, r101);
        Arrays.sort(r102, 0, r101, r100);
        int r103 = 1;
        int r104 = 1;
    L6:
        if (r103 >= r101) goto L11;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) r102[r103];
        if (r100.compare(r105, (Object) r102[r104 - 1]) == 0) goto L10;
        r102[r104] = r105;
        r104 = r104 + 1;
    L10:
        r103 = r103 + 1;
        goto L6
    L11:
        Arrays.fill(r102, r104, r101, null);
        if (r104 >= (r102.length / 2)) goto L15;
        r102 = (E[]) Arrays.copyOf(r102, r104);
    L15:
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(r102, r104), r100);
    L4:
        return emptySet(r100);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r100, Comparable r101, Comparable r102) {
        return construct(Ordering.natural(), 3, new Comparable[]{r100, r101, r102});
    }

    public static int unsafeCompare(Comparator<?> r100, Object r101, @CheckForNull Object r102) {
        return r100.compare(r101, r102);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r100, Comparable r101, Comparable r102, Comparable r103) {
        return construct(Ordering.natural(), 4, new Comparable[]{r100, r101, r102, r103});
    }

    public ImmutableSortedSet<E> subSet(E r100, boolean r101, E r102, boolean r103) {
        r100.getClass();
        r102.getClass();
        if (this.comparator.compare(r100, r102) > 0) goto L5;
        boolean r104 = true;
    L6:
        com.google.common.base.m.b(r104);
        return subSetImpl(r100, r101, r102, r103);
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r100, boolean r101, Object r102, boolean r103) {
        return subSet(r100, r101, r102, r103);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r100, Comparable r101, Comparable r102, Comparable r103, Comparable r104) {
        return construct(Ordering.natural(), 5, new Comparable[]{r100, r101, r102, r103, r104});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r100, Comparable r101, Comparable r102, Comparable r103, Comparable r104, Comparable r105, Comparable... r110) {
        int r106 = r110.length + 6;
        Comparable[] r107 = new Comparable[r106];
        r107[0] = r100;
        r107[1] = r101;
        r107[2] = r102;
        r107[3] = r103;
        r107[4] = r104;
        r107[5] = r105;
        System.arraycopy(r110, 0, r107, 6, r110.length);
        return construct(Ordering.natural(), r106, r107);
    }
}
