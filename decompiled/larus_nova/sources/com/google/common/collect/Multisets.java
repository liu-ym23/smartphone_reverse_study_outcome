package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Multisets {

    public static class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @ParametricNullness
        private final E element;

        @CheckForNull
        public ImmutableEntry<E> nextInBucket() {
            return null;
        }

        @Override // com.google.common.collect.y1.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.y1.a
        @ParametricNullness
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry(@ParametricNullness E r100, int r101) {
            this.element = r100;
            this.count = r101;
            o.b(r101, "count");
        }
    }

    public static class UnmodifiableMultiset<E> extends n0<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final y1<? extends E> delegate;

        @CheckForNull
        transient Set<E> elementSet;

        @CheckForNull
        transient Set<y1.a<E>> entrySet;

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.y1
        public Set<E> elementSet() {
            Set<E> r100 = this.elementSet;
            if (r100 != null) goto L6;
            Set<E> r101 = createElementSet();
            this.elementSet = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.y1
        public Set<y1.a<E>> entrySet() {
            Set<y1.a<E>> r100 = this.entrySet;
            if (r100 != null) goto L6;
            Set<y1.a<E>> r101 = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.i(this.delegate.iterator());
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
        public y1<E> delegate() {
            return this.delegate;
        }

        public UnmodifiableMultiset(y1<? extends E> r100) {
            this.delegate = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness E r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.f0, java.util.Collection
        public boolean addAll(Collection<? extends E> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.y1
        public int add(@ParametricNullness E r100, int r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.y1
        public int remove(@CheckForNull Object r100, int r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.y1
        public int setCount(@ParametricNullness E r100, int r101) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.n0, com.google.common.collect.y1
        public boolean setCount(@ParametricNullness E r100, int r101, int r102) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class a<E> implements y1.a<E> {
        public a() {
        }

        public int hashCode() {
            E r100 = getElement();
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return r101 ^ getCount();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        @Override // com.google.common.collect.y1.a
        public String toString() {
            String r100 = String.valueOf(getElement());
            int r101 = getCount();
            if (r101 != 1) goto L6;
            return r100;
        L6:
            return r100 + " x " + r101;
        }

        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof y1.a) == false) goto L10;
            y1.a r101 = (y1.a) r100;
            if (getCount() == r101.getCount()) goto L7;
            return false;
        L7:
            if (com.google.common.base.k.a(getElement(), r101.getElement()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    public static abstract class b<E> extends Sets.c<E> {
        public abstract y1<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return a().entrySet().size();
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            return a().contains(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> r100) {
            return a().containsAll(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if (a().remove(r100, Integer.MAX_VALUE) <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static abstract class c<E> extends Sets.c<y1.a<E>> {
        public abstract y1<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            a().clear();
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof y1.a) == false) goto L11;
            y1.a r101 = (y1.a) r100;
            if (r101.getCount() > 0) goto L8;
            return false;
        L8:
            if (a().count(r101.getElement()) != r101.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if ((r100 instanceof y1.a) == false) goto L8;
            y1.a r101 = (y1.a) r100;
            Object r102 = r101.getElement();
            int r103 = r101.getCount();
            if (r103 == 0) goto L8;
            return a().setCount(r102, r103, 0);
        L8:
            return false;
        }
    }

    public static final class d<E> extends f<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y1<E> f275275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.google.common.base.n<? super E> f275276d;

        public class a implements com.google.common.base.n<y1.a<E>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f275277a;

            public a(d r100) {
                this.f275277a = r100;
            }

            @Override // com.google.common.base.n
            public final boolean apply(Object r100) {
                return this.f275277a.f275276d.apply((Object) ((y1.a) r100).getElement());
            }
        }

        public final z2<E> a() {
            Iterator<E> r100 = this.f275275c.iterator();
            com.google.common.base.n<? super E> r101 = this.f275276d;
            r100.getClass();
            r101.getClass();
            return new b1(r100, r101);
        }

        @Override // com.google.common.collect.d
        public final Set<E> createElementSet() {
            return Sets.b(this.f275275c.elementSet(), this.f275276d);
        }

        @Override // com.google.common.collect.d
        public final Set<y1.a<E>> createEntrySet() {
            return Sets.b(this.f275275c.entrySet(), new a(this));
        }

        @Override // com.google.common.collect.d
        public final Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.d
        public final Iterator<y1.a<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.y1
        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return a();
        }

        @Override // com.google.common.collect.y1
        public final int count(@CheckForNull Object r100) {
            int r101 = this.f275275c.count(r100);
            if (r101 > 0) goto L5;
            return 0;
        L5:
            if (this.f275276d.apply(r100) == true) goto L10;
            return 0;
        L10:
            return r101;
        }

        public d(y1<E> r100, com.google.common.base.n<? super E> r101) {
            super(0);
            r100.getClass();
            this.f275275c = r100;
            r101.getClass();
            this.f275276d = r101;
        }

        @Override // com.google.common.collect.d, com.google.common.collect.y1
        public final int add(@ParametricNullness E r100, int r101) {
            com.google.common.base.m.i(this.f275276d.apply(r100), "Element %s does not match predicate %s", r100, this.f275276d);
            return this.f275275c.add(r100, r101);
        }

        @Override // com.google.common.collect.d, com.google.common.collect.y1
        public final int remove(@CheckForNull Object r100, int r101) {
            o.b(r101, "occurrences");
            if (r101 != 0) goto L7;
            return count(r100);
        L7:
            if (contains(r100) == true) goto L11;
            return 0;
        L11:
            return this.f275275c.remove(r100, r101);
        }
    }

    public static final class e<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y1<E> f275278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<y1.a<E>> f275279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public y1.a<E> f275280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f275281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275282e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f275283f;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275281d <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.f275279b.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            o.e(this.f275283f);
            if (this.f275282e != 1) goto L5;
            this.f275279b.remove();
        L6:
            this.f275282e--;
            this.f275283f = false;
            return;
        L5:
            y1<E> r100 = this.f275278a;
            y1.a<E> r101 = this.f275280c;
            Objects.requireNonNull(r101);
            r100.remove(r101.getElement());
            goto L6
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final E next() {
            if (hasNext() == false) goto L10;
            if (this.f275281d != 0) goto L7;
            y1.a<E> r100 = this.f275279b.next();
            this.f275280c = r100;
            int r101 = r100.getCount();
            this.f275281d = r101;
            this.f275282e = r101;
        L7:
            this.f275281d--;
            this.f275283f = true;
            y1.a<E> r102 = this.f275280c;
            Objects.requireNonNull(r102);
            return r102.getElement();
        L10:
            throw new NoSuchElementException();
        }

        public e(y1<E> r100, Iterator<y1.a<E>> r101) {
            this.f275278a = r100;
            this.f275279b = r101;
        }
    }

    public static abstract class f<E> extends com.google.common.collect.d<E> {
        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            elementSet().clear();
        }

        @Override // com.google.common.collect.d
        public final int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
        public final int size() {
            return Multisets.e(this);
        }

        public f(int r100) {
        }
    }

    public static int c(Iterable<?> r100) {
        if ((r100 instanceof y1) == true) goto L5;
        return 11;
    L5:
        return ((y1) r100).elementSet().size();
    }

    public static e d(y1 r100) {
        return new e(r100, r100.entrySet().iterator());
    }

    public static int e(y1<?> r100) {
        Iterator<y1.a<?>> r101 = r100.entrySet().iterator();
        long r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L7;
        r102 = r102 + ((long) r101.next().getCount());
        goto L4
    L7:
        return Ints.c(r102);
    }

    public static <E> boolean a(y1<E> r100, Collection<? extends E> r101) {
        r100.getClass();
        r101.getClass();
        if ((r101 instanceof y1) == false) goto L20;
        y1 r102 = (y1) r101;
        if ((r102 instanceof AbstractMapBasedMultiset) == false) goto L12;
        AbstractMapBasedMultiset r103 = (AbstractMapBasedMultiset) r102;
        if (r103.isEmpty() == true) goto L25;
        r103.addTo(r100);
    L10:
        return true;
    L25:
        return false;
    L12:
        if (r102.isEmpty() == true) goto L26;
        Iterator<y1.a<E>> r104 = r102.entrySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L10;
        y1.a<E> r105 = r104.next();
        r100.add(r105.getElement(), r105.getCount());
        goto L16
    L26:
        return false;
    L20:
        if (r101.isEmpty() == false) goto L23;
        return false;
    L23:
        return Iterators.a(r100, r101.iterator());
    }

    public static boolean b(y1<?> r100, @CheckForNull Object r101) {
        if (r101 != r100) goto L6;
        return true;
    L6:
        if ((r101 instanceof y1) == false) goto L19;
        y1 r102 = (y1) r101;
        if (r100.size() != r102.size()) goto L19;
        if (r100.entrySet().size() != r102.entrySet().size()) goto L19;
        Iterator r103 = r102.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        y1.a r104 = (y1.a) r103.next();
        if (r100.count(r104.getElement()) == r104.getCount()) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }
}
