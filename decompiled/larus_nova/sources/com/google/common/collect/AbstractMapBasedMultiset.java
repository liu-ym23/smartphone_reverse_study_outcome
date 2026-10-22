package com.google.common.collect;

import androidx.collection.SieveCacheKt;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = 0;
    transient c2<E> backingMap;
    transient long size;

    public class a extends AbstractMapBasedMultiset<E>.c<E> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultiset f274941e;

        public a(AbstractMapBasedMultiset r100) {
            this.f274941e = r100;
            super(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        @ParametricNullness
        public final E a(int r100) {
            c2<E> r101 = this.f274941e.backingMap;
            com.google.common.base.m.j(r100, r101.f275440c);
            return (E) r101.f275438a[r100];
        }
    }

    public class b extends AbstractMapBasedMultiset<E>.c<y1.a<E>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultiset f274942e;

        public b(AbstractMapBasedMultiset r100) {
            this.f274942e = r100;
            super(r100);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        public final Object a(int r100) {
            c2<E> r101 = this.f274942e.backingMap;
            com.google.common.base.m.j(r100, r101.f275440c);
            return new c2.a(r101, r100);
        }
    }

    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f274945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultiset f274946d;

        @ParametricNullness
        public abstract T a(int r100);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f274946d.backingMap.f275441d != this.f274945c) goto L10;
            if (this.f274943a < 0) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f274946d.backingMap.f275441d != this.f274945c) goto L11;
            if (this.f274944b == (-1)) goto L7;
            boolean r100 = true;
        L8:
            o.e(r100);
            AbstractMapBasedMultiset r101 = this.f274946d;
            r101.size -= (long) r101.backingMap.n(this.f274944b);
            this.f274943a = this.f274946d.backingMap.k(this.f274943a, this.f274944b);
            this.f274944b = -1;
            this.f274945c = this.f274946d.backingMap.f275441d;
            return;
        L7:
            r100 = false;
            goto L8
        L11:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final T next() {
            if (hasNext() == false) goto L7;
            T r100 = a(this.f274943a);
            int r101 = this.f274943a;
            this.f274944b = r101;
            this.f274943a = this.f274946d.backingMap.j(r101);
            return r100;
        L7:
            throw new NoSuchElementException();
        }

        public c(AbstractMapBasedMultiset r100) {
            this.f274946d = r100;
            this.f274943a = r100.backingMap.c();
            this.f274944b = -1;
            this.f274945c = r100.backingMap.f275441d;
        }
    }

    public abstract c2<E> newBackingMap(int r100);

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0;
    }

    @Override // com.google.common.collect.d
    public final int distinctElements() {
        return this.backingMap.f275440c;
    }

    @Override // com.google.common.collect.d
    public final Iterator<E> elementIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.d
    public final Iterator<y1.a<E>> entryIterator() {
        return new b(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public final int size() {
        return Ints.c(this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.y1
    public final Iterator<E> iterator() {
        return Multisets.d(this);
    }

    public AbstractMapBasedMultiset(int r100) {
        this.backingMap = newBackingMap(r100);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        int r101 = r100.readInt();
        this.backingMap = newBackingMap(3);
        j2.d(this, r100, r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        j2.g(this, r100);
    }

    public void addTo(y1<? super E> r100) {
        r100.getClass();
        int r101 = this.backingMap.c();
    L3:
        if (r101 < 0) goto L5;
        c2<E> r102 = this.backingMap;
        com.google.common.base.m.j(r101, r102.f275440c);
        r100.add(r102.f275438a[r101], this.backingMap.e(r101));
        r101 = this.backingMap.j(r101);
        goto L3
    }

    @Override // com.google.common.collect.y1
    public final int count(@CheckForNull Object r100) {
        return this.backingMap.d(r100);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public final int add(@ParametricNullness E r110, int r111) {
        if (r111 == 0) goto L4;
        boolean r100 = true;
        if (r111 <= 0) goto L8;
        boolean r101 = true;
    L9:
        com.google.common.base.m.d(r101, "occurrences cannot be negative: %s", r111);
        int r102 = this.backingMap.f(r110);
        if (r102 != (-1)) goto L13;
        this.backingMap.l(r110, r111);
        this.size += (long) r111;
        return 0;
    L13:
        int r112 = this.backingMap.e(r102);
        long r103 = r111;
        long r104 = ((long) r112) + r103;
        if (r104 <= SieveCacheKt.NodeLinkMask) goto L17;
        r100 = false;
    L17:
        com.google.common.base.m.f(r100, "too many occurrences: %s", r104);
        c2<E> r113 = this.backingMap;
        com.google.common.base.m.j(r102, r113.f275440c);
        r113.f275439b[r102] = (int) r104;
        this.size += r103;
        return r112;
    L8:
        r101 = false;
        goto L9
    L4:
        return count(r110);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public final int remove(@CheckForNull Object r100, int r101) {
        if (r101 != 0) goto L6;
        return count(r100);
    L6:
        if (r101 <= 0) goto L8;
        boolean r102 = true;
    L9:
        com.google.common.base.m.d(r102, "occurrences cannot be negative: %s", r101);
        int r103 = this.backingMap.f(r100);
        if (r103 != (-1)) goto L12;
        return 0;
    L12:
        int r104 = this.backingMap.e(r103);
        if (r104 <= r101) goto L15;
        c2<E> r105 = this.backingMap;
        com.google.common.base.m.j(r103, r105.f275440c);
        r105.f275439b[r103] = r104 - r101;
    L16:
        this.size -= (long) r101;
        return r104;
    L15:
        this.backingMap.n(r103);
        r101 = r104;
        goto L16
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public final int setCount(@ParametricNullness E r100, int r101) {
        o.b(r101, "count");
        c2<E> r102 = this.backingMap;
        if (r101 != 0) goto L5;
        r102.getClass();
        int r103 = r102.m(r100, u0.c(r100));
    L6:
        this.size += (long) (r101 - r103);
        return r103;
    L5:
        r103 = r102.l(r100, r101);
        goto L6
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public final boolean setCount(@ParametricNullness E r100, int r101, int r102) {
        o.b(r101, "oldCount");
        o.b(r102, "newCount");
        int r103 = this.backingMap.f(r100);
        if (r103 != (-1)) goto L10;
        if (r101 == 0) goto L6;
        return false;
    L6:
        if (r102 <= 0) goto L8;
        this.backingMap.l(r100, r102);
        this.size += (long) r102;
    L8:
        return true;
    L10:
        if (this.backingMap.e(r103) == r101) goto L12;
        return false;
    L12:
        if (r102 != 0) goto L14;
        this.backingMap.n(r103);
        this.size -= (long) r101;
    L15:
        return true;
    L14:
        c2<E> r104 = this.backingMap;
        com.google.common.base.m.j(r103, r104.f275440c);
        r104.f275439b[r103] = r102;
        this.size += (long) (r102 - r101);
        goto L15
    }
}
