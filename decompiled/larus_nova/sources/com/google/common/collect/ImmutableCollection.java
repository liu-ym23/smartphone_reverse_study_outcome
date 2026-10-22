package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableList.of or another implementation")
@ElementTypesAreNonnullByDefault
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f275054a = null;

    public static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f275055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f275057c;

        public a(int r100) {
            o.b(r100, "initialCapacity");
            this.f275055a = new Object[r100];
            this.f275056b = 0;
        }

        public final void b(Object r100) {
            r100.getClass();
            c(this.f275056b + 1);
            Object[] r101 = this.f275055a;
            int r102 = this.f275056b;
            this.f275056b = r102 + 1;
            r101[r102] = r100;
        }

        public final void c(int r100) {
            Object[] r101 = this.f275055a;
            if (r101.length >= r100) goto L6;
            this.f275055a = Arrays.copyOf(r101, b.a(r101.length, r100));
            this.f275057c = false;
            return;
        L6:
            if (this.f275057c == false) goto L10;
            this.f275055a = (Object[]) r101.clone();
            this.f275057c = false;
            return;
        }
    }

    @DoNotMock
    public static abstract class b<E> {
        public b() {
        }

        public static int a(int r100, int r101) {
            if (r101 < 0) goto L10;
            int r102 = (r100 + (r100 >> 1)) + 1;
            if (r102 >= r101) goto L6;
            r102 = Integer.highestOneBit(r101 - 1) << 1;
        L6:
            if (r102 >= 0) goto L11;
            return Integer.MAX_VALUE;
        L11:
            return r102;
        L10:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    static {
        f275054a = new Object[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@CheckForNull Object r100);

    @CheckForNull
    public Object[] internalArray() {
        return null;
    }

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract z2<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f275054a);
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    public ImmutableList<E> asList() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public ImmutableCollection() {
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(E r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        r100.getClass();
        int r101 = size();
        if (r100.length >= r101) goto L14;
        Object[] r102 = internalArray();
        if (r102 == null) goto L9;
        return (T[]) Arrays.copyOfRange(r102, internalArrayStart(), internalArrayEnd(), r100.getClass());
    L9:
        if (r100.length == 0) goto L12;
        r100 = (T[]) Arrays.copyOf(r100, 0);
    L12:
        r100 = (T[]) Arrays.copyOf(r100, r101);
    L16:
        copyIntoArray(r100, 0);
        return r100;
    L14:
        if (r100.length <= r101) goto L16;
        r100[r101] = null;
        goto L16
    }

    public int copyIntoArray(Object[] r100, int r101) {
        z2<E> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r100[r101] = r102.next();
        r101 = r101 + 1;
        goto L4
    L6:
        return r101;
    }
}
