package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class d<E> extends AbstractCollection<E> implements y1<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Set<E> f275449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Set<y1.a<E>> f275450b;

    public class a extends Multisets.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f275451a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<E> iterator() {
            return this.f275451a.elementIterator();
        }

        @Override // com.google.common.collect.Multisets.b
        public final y1<E> a() {
            return this.f275451a;
        }

        public a(d r100) {
            this.f275451a = r100;
        }
    }

    public class b extends Multisets.c<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f275452a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<y1.a<E>> iterator() {
            return this.f275452a.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f275452a.distinctElements();
        }

        @Override // com.google.common.collect.Multisets.c
        public y1<E> a() {
            return this.f275452a;
        }

        public b(d r100) {
            this.f275452a = r100;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public abstract Iterator<y1.a<E>> entryIterator();

    public Set<E> createElementSet() {
        return new a(this);
    }

    public Set<y1.a<E>> createEntrySet() {
        return new b(this);
    }

    public Set<E> elementSet() {
        Set<E> r100 = this.f275449a;
        if (r100 != null) goto L6;
        Set<E> r101 = createElementSet();
        this.f275449a = r101;
        return r101;
    L6:
        return r100;
    }

    public Set<y1.a<E>> entrySet() {
        Set<y1.a<E>> r100 = this.f275450b;
        if (r100 != null) goto L6;
        Set<y1.a<E>> r101 = createEntrySet();
        this.f275450b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.Collection, com.google.common.collect.y1
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    public d() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(@ParametricNullness E r100) {
        add(r100, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        return Multisets.a(this, r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public boolean contains(@CheckForNull Object r100) {
        if (count(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, com.google.common.collect.y1
    public final boolean equals(@CheckForNull Object r100) {
        return Multisets.b(this, r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public final boolean remove(@CheckForNull Object r100) {
        if (remove(r100, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> r100) {
        if ((r100 instanceof y1) == false) goto L6;
        r100 = ((y1) r100).elementSet();
    L6:
        return elementSet().removeAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> r100) {
        r100.getClass();
        if ((r100 instanceof y1) == false) goto L6;
        r100 = ((y1) r100).elementSet();
    L6:
        return elementSet().retainAll(r100);
    }

    public int add(@ParametricNullness E r100, int r101) {
        throw new UnsupportedOperationException();
    }

    public int remove(@CheckForNull Object r100, int r101) {
        throw new UnsupportedOperationException();
    }

    public int setCount(@ParametricNullness E r100, int r101) {
        o.b(r101, "count");
        int r102 = count(r100);
        int r103 = r101 - r102;
        if (r103 <= 0) goto L5;
        add(r100, r103);
    L7:
        return r102;
    L5:
        if (r103 >= 0) goto L7;
        remove(r100, -r103);
        goto L7
    }

    public boolean setCount(@ParametricNullness E r100, int r101, int r102) {
        o.b(r101, "oldCount");
        o.b(r102, "newCount");
        if (count(r100) != r101) goto L5;
        setCount(r100, r102);
        return true;
    L5:
        return false;
    }
}
