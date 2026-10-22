package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements n2<E> {

    @CheckForNull
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public Object readResolve() {
            int r100 = this.elements.length;
            a r101 = new a(this.comparator);
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L6;
            r101.h(this.elements[r102], this.counts[r102]);
            r102 = r102 + 1;
            goto L3
        L6:
            return r101.i();
        }

        public SerializedForm(n2<E> r100) {
            this.comparator = r100.comparator();
            int r101 = r100.entrySet().size();
            this.elements = (E[]) new Object[r101];
            this.counts = new int[r101];
            Iterator<y1.a<E>> r102 = r100.entrySet().iterator();
            int r103 = 0;
        L4:
            if (r102.hasNext() == false) goto L6;
            y1.a<E> r104 = r102.next();
            this.elements[r103] = r104.getElement();
            this.counts[r103] = r104.getCount();
            r103 = r103 + 1;
            goto L4
        }
    }

    public static class a<E> extends ImmutableMultiset.b<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Comparator<? super E> f275128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public E[] f275129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f275130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f275131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f275132g;

        public final ImmutableSortedMultiset<E> i() {
            j(false);
            int r100 = 0;
            int r101 = 0;
        L3:
            int r102 = this.f275131f;
            if (r100 >= r102) goto L9;
            int[] r103 = this.f275130e;
            int r104 = r103[r100];
            if (r104 <= 0) goto L8;
            E[] r105 = this.f275129d;
            r105[r101] = r105[r100];
            r103[r101] = r104;
            r101 = r101 + 1;
        L8:
            r100 = r100 + 1;
            goto L3
        L9:
            Arrays.fill(this.f275129d, r101, r102, null);
            Arrays.fill(this.f275130e, r101, this.f275131f, 0);
            this.f275131f = r101;
            if (r101 == 0) goto L12;
            RegularImmutableSortedSet r106 = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f275128c, r101, this.f275129d);
            long[] r107 = new long[this.f275131f + 1];
            int r108 = 0;
        L15:
            if (r108 >= this.f275131f) goto L17;
            int r109 = r108 + 1;
            r107[r109] = r107[r108] + ((long) this.f275130e[r108]);
            r108 = r109;
            goto L15
        L17:
            this.f275132g = true;
            return new RegularImmutableSortedMultiset(r106, r107, 0, this.f275131f);
        L12:
            return ImmutableSortedMultiset.emptyMultiset(this.f275128c);
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public final /* bridge */ /* synthetic */ ImmutableMultiset f() {
            return i();
        }

        public a(Comparator<? super E> r100) {
            super(null);
            r100.getClass();
            this.f275128c = r100;
            this.f275129d = (E[]) new Object[4];
            this.f275130e = new int[4];
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public final ImmutableCollection.b b(Object r100) {
            h(r100, 1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public final ImmutableMultiset.b c(Object r100) {
            h(r100, 1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public final ImmutableMultiset.b d(Object[] r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            h(r100[r102], 1);
            r102 = r102 + 1;
            goto L3
        L5:
            return this;
        }

        public final void g(Iterable r100) {
            if ((r100 instanceof y1) == false) goto L8;
            Iterator<y1.a<E>> r101 = ((y1) r100).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L12;
            y1.a<E> r102 = r101.next();
            h(r102.getElement(), r102.getCount());
            goto L6
        L12:
            return;
        L8:
            Iterator r103 = r100.iterator();
        L10:
            if (r103.hasNext() == false) goto L15;
            h(r103.next(), 1);
            goto L10
        }

        public final void j(boolean r100) {
            int r101 = this.f275131f;
            if (r101 != 0) goto L5;
            return;
        L5:
            Object[] r102 = (E[]) Arrays.copyOf(this.f275129d, r101);
            Arrays.sort(r102, this.f275128c);
            int r103 = 1;
            int r104 = 1;
        L7:
            if (r103 >= r102.length) goto L12;
            if (this.f275128c.compare((Object) r102[r104 - 1], (Object) r102[r103]) >= 0) goto L11;
            r102[r104] = r102[r103];
            r104 = r104 + 1;
        L11:
            r103 = r103 + 1;
            goto L7
        L12:
            Arrays.fill(r102, r104, this.f275131f, null);
            if (r100 == false) goto L17;
            int r105 = r104 * 4;
            int r106 = this.f275131f;
            if (r105 <= (r106 * 3)) goto L17;
            r102 = (E[]) Arrays.copyOf(r102, Ints.c(((long) r106) + ((long) ((r106 / 2) + 1))));
        L17:
            int[] r107 = new int[r102.length];
            int r108 = 0;
        L19:
            if (r108 >= this.f275131f) goto L25;
            int r109 = Arrays.binarySearch(r102, 0, r104, this.f275129d[r108], this.f275128c);
            int r110 = this.f275130e[r108];
            if (r110 < 0) goto L23;
            r107[r109] = r107[r109] + r110;
        L24:
            r108 = r108 + 1;
            goto L19
        L23:
            r107[r109] = ~r110;
            goto L24
        L25:
            this.f275129d = (E[]) r102;
            this.f275130e = r107;
            this.f275131f = r104;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public final /* bridge */ /* synthetic */ ImmutableMultiset.b e(Object r100, int r101) {
            h(r100, r101);
            return this;
        }

        public final void h(Object r100, int r101) {
            r100.getClass();
            o.b(r101, "occurrences");
            if (r101 != 0) goto L5;
            return;
        L5:
            int r102 = this.f275131f;
            E[] r103 = this.f275129d;
            if (r102 != r103.length) goto L9;
            j(true);
        L11:
            this.f275132g = false;
            Object[] r104 = (E[]) this.f275129d;
            int r105 = this.f275131f;
            r104[r105] = r100;
            this.f275130e[r105] = r101;
            this.f275131f = r105 + 1;
            return;
        L9:
            if (this.f275132g == false) goto L11;
            this.f275129d = (E[]) Arrays.copyOf(r103, r103.length);
            goto L11
        }
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public abstract /* synthetic */ int count(@CheckForNull Object r100);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public abstract ImmutableSortedSet<E> elementSet();

    @CheckForNull
    public abstract /* synthetic */ y1.a<E> firstEntry();

    public abstract ImmutableSortedMultiset<E> headMultiset(E r100, BoundType r101);

    @CheckForNull
    public abstract /* synthetic */ y1.a<E> lastEntry();

    public abstract ImmutableSortedMultiset<E> tailMultiset(E r100, BoundType r101);

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a(Ordering.natural().reverse());
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> r100 = this.descendingMultiset;
        if (r100 == null) goto L5;
    L9:
        return r100;
    L5:
        if (isEmpty() == false) goto L7;
        r100 = emptyMultiset(Ordering.from(comparator()).reverse());
    L8:
        this.descendingMultiset = r100;
        goto L9
    L7:
        r100 = new DescendingImmutableSortedMultiset(this);
        goto L8
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public final y1.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public final y1.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.n2, com.google.common.collect.l2
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    public ImmutableSortedMultiset() {
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public /* bridge */ /* synthetic */ n2 descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] r100) {
        return copyOf(Ordering.natural(), Arrays.asList(r100));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(n2<E> r100) {
        return c(r100.comparator(), Lists.b(r100.entrySet()));
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> r100) {
        if (Ordering.natural().equals(r100) == false) goto L7;
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    L7:
        return new RegularImmutableSortedMultiset(r100);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r100) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(r100), new long[]{0, 1}, 0, 1);
    }

    public static <E> a<E> orderedBy(Comparator<E> r100) {
        return new a(r100);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> r100) {
        return copyOf(Ordering.natural(), r100);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> r100) {
        return copyOf(Ordering.natural(), r100);
    }

    public static <E> ImmutableSortedMultiset<E> c(Comparator<? super E> r110, Collection<y1.a<E>> r111) {
        if (r111.isEmpty() == true) goto L5;
        int r100 = r111.size();
        o.b(r100, "initialCapacity");
        Object[] r101 = new Object[r100];
        long[] r102 = new long[r111.size() + 1];
        Iterator<y1.a<E>> r103 = r111.iterator();
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r103.hasNext() == false) goto L14;
        y1.a<E> r106 = r103.next();
        E r107 = r106.getElement();
        r107.getClass();
        int r108 = r104 + 1;
        if (r101.length >= r108) goto L12;
        r101 = Arrays.copyOf(r101, ImmutableCollection.b.a(r101.length, r108));
    L12:
        r101[r104] = r107;
        int r109 = r105 + 1;
        r102[r109] = r102[r105] + ((long) r106.getCount());
        r105 = r109;
        r104 = r108;
        goto L8
    L14:
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(ImmutableList.asImmutableList(r101, r104), r110), r102, 0, r111.size());
    L5:
        return emptyMultiset(r110);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r100, Iterable<? extends E> r101) {
        if ((r101 instanceof ImmutableSortedMultiset) == false) goto L11;
        ImmutableSortedMultiset<E> r102 = (ImmutableSortedMultiset) r101;
        if (r100.equals(r102.comparator()) == false) goto L11;
        if (r102.isPartialView() == true) goto L9;
        return r102;
    L9:
        return c(r100, r102.entrySet().asList());
    L11:
        a r103 = new a(r100);
        r103.g(r101);
        return r103.i();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r100, Comparable r101) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r100, r101}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ n2 headMultiset(Object r100, BoundType r101) {
        return headMultiset(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ n2 tailMultiset(Object r100, BoundType r101) {
        return tailMultiset(r100, r101);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r100, Iterator<? extends E> r101) {
        r100.getClass();
        a r102 = new a(r100);
    L4:
        if (r101.hasNext() == false) goto L7;
        r102.h(r101.next(), 1);
        goto L4
    L7:
        return r102.i();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r100, Comparable r101, Comparable r102) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r100, r101, r102}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r100, Comparable r101, Comparable r102, Comparable r103) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r100, r101, r102, r103}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.n2
    public ImmutableSortedMultiset<E> subMultiset(E r100, BoundType r101, E r102, BoundType r103) {
        if (comparator().compare(r100, r102) > 0) goto L5;
        boolean r104 = true;
    L6:
        com.google.common.base.m.i(r104, "Expected lowerBound <= upperBound but %s > %s", r100, r102);
        return tailMultiset(r100, r101).headMultiset(r102, r103);
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ n2 subMultiset(Object r100, BoundType r101, Object r102, BoundType r103) {
        return subMultiset(r100, r101, r102, r103);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r100, Comparable r101, Comparable r102, Comparable r103, Comparable r104) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r100, r101, r102, r103, r104}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r100, Comparable r101, Comparable r102, Comparable r103, Comparable r104, Comparable r105, Comparable... r106) {
        ArrayList r107 = Lists.d(r106.length + 6);
        Collections.addAll(r107, new Comparable[]{r100, r101, r102, r103, r104, r105});
        Collections.addAll(r107, r106);
        return copyOf(Ordering.natural(), r107);
    }
}
