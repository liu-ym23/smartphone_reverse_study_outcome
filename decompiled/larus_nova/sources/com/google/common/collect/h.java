package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class h<E> extends d<E> implements n2<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    public transient n2<E> f275467c;

    @GwtTransient
    final Comparator<? super E> comparator;

    public class a extends t<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f275468d;

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<E> iterator() {
            return this.f275468d.descendingIterator();
        }

        public a(h r100) {
            this.f275468d = r100;
        }
    }

    public abstract Iterator<y1.a<E>> descendingEntryIterator();

    public n2<E> createDescendingMultiset() {
        return new a(this);
    }

    @Override // com.google.common.collect.d
    public NavigableSet<E> createElementSet() {
        return new o2.b(this);
    }

    public n2<E> descendingMultiset() {
        n2<E> r100 = this.f275467c;
        if (r100 != null) goto L6;
        n2<E> r101 = createDescendingMultiset();
        this.f275467c = r101;
        return r101;
    L6:
        return r100;
    }

    public h() {
        this(Ordering.natural());
    }

    Iterator<E> descendingIterator() {
        return Multisets.d(descendingMultiset());
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @CheckForNull
    public y1.a<E> firstEntry() {
        Iterator<y1.a<E>> r100 = entryIterator();
        if (r100.hasNext() == true) goto L7;
        return null;
    L7:
        return r100.next();
    }

    @CheckForNull
    public y1.a<E> lastEntry() {
        Iterator<y1.a<E>> r100 = descendingEntryIterator();
        if (r100.hasNext() == true) goto L7;
        return null;
    L7:
        return r100.next();
    }

    @CheckForNull
    public y1.a<E> pollFirstEntry() {
        Iterator<y1.a<E>> r100 = entryIterator();
        if (r100.hasNext() == false) goto L6;
        y1.a<E> r101 = r100.next();
        Multisets.ImmutableEntry r102 = new Multisets.ImmutableEntry(r101.getElement(), r101.getCount());
        r100.remove();
        return r102;
    L6:
        return null;
    }

    @CheckForNull
    public y1.a<E> pollLastEntry() {
        Iterator<y1.a<E>> r100 = descendingEntryIterator();
        if (r100.hasNext() == false) goto L6;
        y1.a<E> r101 = r100.next();
        Multisets.ImmutableEntry r102 = new Multisets.ImmutableEntry(r101.getElement(), r101.getCount());
        r100.remove();
        return r102;
    L6:
        return null;
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    public h(Comparator<? super E> r100) {
        r100.getClass();
        this.comparator = r100;
    }

    public n2<E> subMultiset(@ParametricNullness E r100, BoundType r101, @ParametricNullness E r102, BoundType r103) {
        r101.getClass();
        r103.getClass();
        return tailMultiset(r100, r101).headMultiset(r102, r103);
    }
}
