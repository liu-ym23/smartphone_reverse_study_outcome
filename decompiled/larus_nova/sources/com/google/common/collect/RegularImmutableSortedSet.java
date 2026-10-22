package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = null;
    final transient ImmutableList<E> elements;

    static {
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), Ordering.natural());
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> createDescendingSet() {
        Comparator r100 = Collections.reverseOrder(this.comparator);
        if (isEmpty() == false) goto L6;
        return ImmutableSortedSet.emptySet(r100);
    L6:
        return new RegularImmutableSortedSet(this.elements.reverse(), r100);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public z2<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @CheckForNull
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public z2<E> iterator() {
        return this.elements.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (isEmpty() == true) goto L7;
        return this.elements.get(0);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (isEmpty() == true) goto L7;
        return this.elements.get(size() - 1);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return this.elements;
    }

    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E ceiling(E r100) {
        int r101 = tailIndex(r100, true);
        if (r101 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r101);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        if (r100 == null) goto L11;
        if (Collections.binarySearch(this.elements, r100, unsafeComparator()) < 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r100) {
        if ((r100 instanceof y1) == false) goto L6;
        r100 = ((y1) r100).elementSet();
    L6:
        if (m2.a(comparator(), r100) == false) goto L29;
        if (r100.size() <= 1) goto L29;
        z2<E> r101 = iterator();
        Iterator<?> r102 = r100.iterator();
        if (r101.hasNext() == true) goto L13;
        return false;
    L13:
        Object r103 = r102.next();
        E r104 = r101.next();
    L31:
        int r105 = unsafeCompare(r104, r103);     // Catch: Throwable -> L30
        if (r105 < 0) goto L17;
        if (r105 == 0) goto L22;
        if (r105 <= 0) goto L31;
    L22:
        if (r102.hasNext() == false) goto L23;
        r103 = r102.next();     // Catch: Throwable -> L30
        goto L31
    L23:
        return true;
    L17:
        if (r101.hasNext() == false) goto L18;
        r104 = r101.next();     // Catch: Throwable -> L30
        goto L31
    L18:
        return false;
    L27:
        return false;
    L29:
        return super.containsAll(r100);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Set) == true) goto L8;
        return false;
    L8:
        Set r101 = (Set) r100;
        if (size() == r101.size()) goto L12;
        return false;
    L12:
        if (isEmpty() == false) goto L15;
        return true;
    L15:
        if (m2.a(this.comparator, r101) == false) goto L28;
        Iterator<E> r102 = r101.iterator();
        z2<E> r103 = iterator();     // Catch: Throwable -> L26
    L19:
        if (r103.hasNext() == false) goto L25;
        E r104 = r103.next();     // Catch: Throwable -> L26
        E r105 = r102.next();     // Catch: Throwable -> L26
        if (r105 == null) goto L24;
        if (unsafeCompare(r104, r105) == 0) goto L19;
    L24:
        return false;
    L25:
        return true;
    L26:
        return false;
    L28:
        return containsAll(r101);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E floor(E r100) {
        int r101 = headIndex(r100, true) - 1;
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r101);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E higher(E r100) {
        int r101 = tailIndex(r100, false);
        if (r101 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r101);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(@CheckForNull Object r100) {
        if (r100 != null) goto L10;
        return -1;
    L10:
        int r101 = Collections.binarySearch(this.elements, r100, unsafeComparator());     // Catch: ClassCastException -> L9
        if (r101 >= 0) goto L8;
        return -1;
    L8:
        return r101;
    L13:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E lower(E r100) {
        int r101 = headIndex(r100, false) - 1;
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r101);
    }

    public RegularImmutableSortedSet(ImmutableList<E> r100, Comparator<? super E> r101) {
        super(r101);
        this.elements = r100;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r100, int r101) {
        return this.elements.copyIntoArray(r100, r101);
    }

    public RegularImmutableSortedSet<E> getSubSet(int r100, int r101) {
        if (r100 == 0) goto L4;
    L6:
        if (r100 >= r101) goto L10;
        return new RegularImmutableSortedSet(this.elements.subList(r100, r101), this.comparator);
    L10:
        return ImmutableSortedSet.emptySet(this.comparator);
    L4:
        if (r101 != size()) goto L6;
        return this;
    }

    public int headIndex(E r100, boolean r101) {
        ImmutableList<E> r102 = this.elements;
        r100.getClass();
        int r103 = Collections.binarySearch(r102, r100, comparator());
        if (r103 < 0) goto L8;
        if (r101 == true) goto L6;
        return r103;
    L6:
        return r103 + 1;
    L8:
        return ~r103;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E r100, boolean r101) {
        return getSubSet(0, headIndex(r100, r101));
    }

    public int tailIndex(E r100, boolean r101) {
        ImmutableList<E> r102 = this.elements;
        r100.getClass();
        int r103 = Collections.binarySearch(r102, r100, comparator());
        if (r103 < 0) goto L9;
        if (r101 == false) goto L7;
        return r103;
    L7:
        return r103 + 1;
    L9:
        return ~r103;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> tailSetImpl(E r100, boolean r101) {
        return getSubSet(tailIndex(r100, r101), size());
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> subSetImpl(E r100, boolean r101, E r102, boolean r103) {
        return tailSetImpl(r100, r101).headSetImpl(r102, r103);
    }
}
