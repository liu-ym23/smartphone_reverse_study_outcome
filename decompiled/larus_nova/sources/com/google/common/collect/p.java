package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class p {

    public static class a<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<E> f275489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.common.base.n<? super E> f275490b;

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            a1.c(this.f275489a, this.f275490b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            Collection<E> r100 = this.f275489a;
            com.google.common.base.n<? super E> r101 = this.f275490b;
            Iterator<T> r102 = r100.iterator();
            com.google.common.base.m.l(r101, "predicate");
            boolean r103 = false;
            int r104 = 0;
        L4:
            if (r102.hasNext() == false) goto L9;
            if (r101.apply((Object) r102.next()) == true) goto L11;
            r104 = r104 + 1;
        L11:
            if (r104 == (-1)) goto L14;
            r103 = true;
        L14:
            return true ^ r103;
        L9:
            r104 = -1;
            goto L11
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<E> iterator() {
            Iterator<E> r100 = this.f275489a.iterator();
            com.google.common.base.n<? super E> r101 = this.f275490b;
            r100.getClass();
            r101.getClass();
            return new b1(r100, r101);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            Iterator<E> r100 = this.f275489a.iterator();
            int r101 = 0;
        L4:
            if (r100.hasNext() == false) goto L8;
            E r102 = r100.next();
            if (this.f275490b.apply(r102) == false) goto L4;
            r101 = r101 + 1;
            goto L4
        L8:
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return Lists.c(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean add(@ParametricNullness E r100) {
            com.google.common.base.m.b(this.f275490b.apply(r100));
            return this.f275489a.add(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean addAll(Collection<? extends E> r100) {
            Iterator<? extends E> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            E r102 = r101.next();
            com.google.common.base.m.b(this.f275490b.apply(r102));
            goto L4
        L7:
            return this.f275489a.addAll(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object r100) {
            Collection<E> r101 = this.f275489a;
            r101.getClass();
            boolean r102 = r101.contains(r100);     // Catch: Throwable -> L5
        L6:
            if (r102 == true) goto L8;
            return false;
        L8:
            return this.f275490b.apply(r100);
        L5:
            r102 = false;
            goto L6
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean containsAll(Collection<?> r100) {
            return p.a(this, r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(@CheckForNull Object r100) {
            if (contains(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f275489a.remove(r100) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection<?> r100) {
            Iterator<E> r101 = this.f275489a.iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L10;
            E r103 = r101.next();
            if (this.f275490b.apply(r103) == false) goto L4;
            if (r100.contains(r103) == false) goto L4;
            r101.remove();
            r102 = true;
            goto L4
        L10:
            return r102;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection<?> r100) {
            Iterator<E> r101 = this.f275489a.iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L10;
            E r103 = r101.next();
            if (this.f275490b.apply(r103) == false) goto L4;
            if (r100.contains(r103) == true) goto L4;
            r101.remove();
            r102 = true;
            goto L4
        L10:
            return r102;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final <T> T[] toArray(T[] r100) {
            return (T[]) Lists.c(iterator()).toArray(r100);
        }

        public a(Collection<E> r100, com.google.common.base.n<? super E> r101) {
            this.f275489a = r100;
            this.f275490b = r101;
        }
    }

    public static boolean a(Collection<?> r100, Collection<?> r101) {
        Iterator<?> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r100.contains(r102.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static a b(Collection r100, com.google.common.base.n r101) {
        if ((r100 instanceof a) == false) goto L6;
        a r102 = (a) r100;
        r102.getClass();
        return new a(r102.f275489a, Predicates.c(r102.f275490b, r101));
    L6:
        r100.getClass();
        return new a(r100, r101);
    }
}
