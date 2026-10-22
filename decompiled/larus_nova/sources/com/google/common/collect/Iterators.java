package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Iterators {

    public static final enum EmptyModifiableIterator extends Enum<EmptyModifiableIterator> implements Iterator<Object> {
        public static final EmptyModifiableIterator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EmptyModifiableIterator[] f275135a = null;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            o.e(false);
        }

        static {
            EmptyModifiableIterator r100 = new EmptyModifiableIterator();
            INSTANCE = r100;
            f275135a = new EmptyModifiableIterator[]{r100};
        }

        public EmptyModifiableIterator() {
            super("INSTANCE", 0);
        }

        public static EmptyModifiableIterator[] values() {
            return (EmptyModifiableIterator[]) f275135a.clone();
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        public static EmptyModifiableIterator valueOf(String r100) {
            return (EmptyModifiableIterator) r27.a.a(EmptyModifiableIterator.class, r100);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends z2<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f275136a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f275136a.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final T next() {
            return (T) this.f275136a.next();
        }

        public a(Iterator r100) {
            this.f275136a = r100;
        }
    }

    public static final class b<T> extends com.google.common.collect.a<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f275137e = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T[] f275138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f275139d;

        static {
            f275137e = new b(new Object[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object[] r100) {
            super(0, 0);
            this.f275138c = r100;
            this.f275139d = 0;
        }

        @Override // com.google.common.collect.a
        @ParametricNullness
        public final T a(int r100) {
            return this.f275138c[this.f275139d + r100];
        }
    }

    public static class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Iterator<? extends T> f275140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<? extends T> f275141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public Iterator<? extends Iterator<? extends T>> f275142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @CheckForNull
        public Deque<Iterator<? extends Iterator<? extends T>>> f275143d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
        L2:
            Iterator<? extends T> r100 = this.f275141b;
            r100.getClass();
            if (r100.hasNext() == true) goto L31;
        L4:
            Iterator<? extends Iterator<? extends T>> r101 = this.f275142c;
            if (r101 != null) goto L7;
        L10:
            Deque<Iterator<? extends Iterator<? extends T>>> r102 = this.f275143d;
            if (r102 == null) goto L15;
            if (r102.isEmpty() == true) goto L15;
            this.f275142c = this.f275143d.removeFirst();
        L15:
            Iterator<? extends Iterator<? extends T>> r103 = null;
        L16:
            this.f275142c = r103;
            if (r103 == null) goto L18;
            Iterator<? extends T> r104 = r103.next();
            this.f275141b = r104;
            if ((r104 instanceof c) == false) goto L2;
            c r105 = (c) r104;
            this.f275141b = r105.f275141b;
            if (this.f275143d != null) goto L25;
            this.f275143d = new ArrayDeque();
        L25:
            this.f275143d.addFirst(this.f275142c);
            if (r105.f275143d != null) goto L28;
        L30:
            this.f275142c = r105.f275142c;
        L28:
            if (r105.f275143d.isEmpty() == true) goto L30;
            this.f275143d.addFirst(r105.f275143d.removeLast());
            goto L28
        L18:
            return false;
        L7:
            if (r101.hasNext() == false) goto L10;
            r103 = this.f275142c;
            goto L16
        L31:
            return true;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Iterator<? extends T> r100 = this.f275140a;
            if (r100 == null) goto L7;
            r100.remove();
            this.f275140a = null;
            return;
        L7:
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final T next() {
            if (hasNext() == false) goto L7;
            Iterator<? extends T> r100 = this.f275141b;
            this.f275140a = r100;
            return r100.next();
        L7:
            throw new NoSuchElementException();
        }

        public c(e0.a r100) {
            this.f275141b = b.f275137e;
            this.f275142c = r100;
        }
    }

    public static class d<T> extends z2<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<e2<T>> f275144a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f275144a.isEmpty();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final T next() {
            e2<T> r100 = this.f275144a.remove();
            T r101 = r100.next();
            if (r100.hasNext() == false) goto L5;
            ((PriorityQueue) this.f275144a).add(r100);
        L5:
            return r101;
        }

        public d(y0 r100, final Comparator r101) {
            this.f275144a = new PriorityQueue(2, new e1(r101));
            Iterator<Object> r102 = r100.iterator();
        L3:
            v2 r103 = (v2) r102;
            if (r103.hasNext() == false) goto L8;
            Iterator r104 = (Iterator) r103.next();
            if (r104.hasNext() == false) goto L3;
            Queue<e2<T>> r105 = this.f275144a;
            PriorityQueue r106 = (PriorityQueue) r105;
            r106.add(Iterators.e(r104));
            goto L3
        }
    }

    public static class e<E> implements e2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends E> f275145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f275146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public E f275147c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275146b == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f275145a.hasNext() == true) goto L8;
            return false;
        }

        @Override // com.google.common.collect.e2, java.util.Iterator
        @ParametricNullness
        public final E next() {
            if (this.f275146b == false) goto L5;
            E r100 = this.f275147c;
            this.f275146b = false;
            this.f275147c = null;
            return r100;
        L5:
            return this.f275145a.next();
        }

        @Override // com.google.common.collect.e2
        @ParametricNullness
        public final E peek() {
            if (this.f275146b == true) goto L6;
            this.f275147c = this.f275145a.next();
            this.f275146b = true;
        L6:
            return this.f275147c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.google.common.base.m.p(!this.f275146b, "Can't remove after you've peeked at next");
            this.f275145a.remove();
        }

        public e(Iterator<? extends E> r100) {
            r100.getClass();
            this.f275145a = r100;
        }
    }

    public static void b(Iterator<?> r100) {
        r100.getClass();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next();
        r100.remove();
        goto L4
    }

    @ParametricNullness
    public static Object d(Iterator r100) {
        if (r100.hasNext() == true) goto L7;
        return null;
    L7:
        return r100.next();
    }

    public static e e(Iterator r100) {
        if ((r100 instanceof e) == false) goto L7;
        return (e) r100;
    L7:
        return new e(r100);
    }

    @CheckForNull
    public static <T> T f(Iterator<T> r100) {
        if (r100.hasNext() == false) goto L6;
        T r101 = r100.next();
        r100.remove();
        return r101;
    L6:
        return null;
    }

    public static int h(Iterator<?> r100) {
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L7;
        r100.next();
        r101 = r101 + 1;
        goto L4
    L7:
        return Ints.c(r101);
    }

    public static <T> z2<T> i(Iterator<? extends T> r100) {
        r100.getClass();
        if ((r100 instanceof z2) == false) goto L7;
        return (z2) r100;
    L7:
        return new a(r100);
    }

    public static <T> boolean a(Collection<T> r100, Iterator<? extends T> r101) {
        r100.getClass();
        r101.getClass();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 | r100.add(r101.next());
        goto L4
    L6:
        return r102;
    }

    public static boolean c(Iterator<?> r100, @CheckForNull Object r101) {
        if (r101 != null) goto L10;
    L5:
        if (r100.hasNext() == false) goto L14;
        if (r100.next() != null) goto L5;
        return true;
    L14:
        return false;
    L10:
        if (r100.hasNext() == false) goto L22;
        if (r101.equals(r100.next()) == false) goto L10;
        return true;
    L22:
        return false;
    }

    public static boolean g(Iterator<?> r100, Collection<?> r101) {
        r101.getClass();
        boolean r102 = false;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r101.contains(r100.next()) == false) goto L4;
        r100.remove();
        r102 = true;
        goto L4
    L8:
        return r102;
    }
}
