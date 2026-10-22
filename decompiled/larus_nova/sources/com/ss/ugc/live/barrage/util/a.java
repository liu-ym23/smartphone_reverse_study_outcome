package com.ss.ugc.live.barrage.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements List<AbsBarrage>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f458143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AbsBarrage> f458144b;

    /* JADX INFO: renamed from: com.ss.ugc.live.barrage.util.a$a, reason: collision with other inner class name */
    public static final class C5473a implements ListIterator<AbsBarrage>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbsBarrage f458145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ListIterator<AbsBarrage> f458146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f458147c;

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f458146b.hasNext();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f458146b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f458146b.nextIndex();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f458146b.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            AbsBarrage r100 = this.f458146b.next();
            this.f458145a = r100;
            return r100;
        }

        @Override // java.util.ListIterator
        public final AbsBarrage previous() {
            AbsBarrage r100 = this.f458146b.previous();
            this.f458145a = r100;
            return r100;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            this.f458146b.remove();
            AbsBarrage r100 = this.f458145a;
            if (r100 == null) goto L6;
            r100.p(AbsBarrage.State.HIDDEN);
            this.f458147c.a(r100);
            return;
        }

        @Override // java.util.ListIterator
        public final void add(AbsBarrage r100) {
            AbsBarrage r101 = r100;
            ListIterator<AbsBarrage> r102 = this.f458146b;
            r101.p(AbsBarrage.State.VISIBLE);
            this.f458147c.b();
            r102.add(r101);
        }

        @Override // java.util.ListIterator
        public final void set(AbsBarrage r100) {
            AbsBarrage r101 = r100;
            ListIterator<AbsBarrage> r102 = this.f458146b;
            r101.p(AbsBarrage.State.VISIBLE);
            this.f458147c.b();
            r102.set(r101);
            AbsBarrage r103 = this.f458145a;
            if (r103 == null) goto L6;
            r103.p(AbsBarrage.State.HIDDEN);
            this.f458147c.a(r103);
            return;
        }

        public C5473a(ListIterator<AbsBarrage> r100, b r101) {
            this.f458146b = r100;
            this.f458147c = r101;
        }
    }

    public interface b {
        void a(AbsBarrage r100);

        void b();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        return this.f458144b.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f458144b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        List<AbsBarrage> r100 = this.f458144b;
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        AbsBarrage r102 = (AbsBarrage) r101.next();
        r102.p(AbsBarrage.State.HIDDEN);
        this.f458143a.a(r102);
        goto L4
    L6:
        r100.clear();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<AbsBarrage> iterator() {
        return new C5473a(this.f458144b.listIterator(), this.f458143a);
    }

    @Override // java.util.List
    public final ListIterator<AbsBarrage> listIterator() {
        return new C5473a(this.f458144b.listIterator(), this.f458143a);
    }

    @Override // java.util.Collection
    public final Stream<AbsBarrage> parallelStream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f458144b.size();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Spliterator<AbsBarrage> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final Stream<AbsBarrage> stream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r100) {
        AbsBarrage r101 = (AbsBarrage) r100;
        UtilsKt.a();
        boolean r102 = this.f458144b.add(r101);
        r101.p(AbsBarrage.State.VISIBLE);
        this.f458143a.b();
        return r102;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends AbsBarrage> r100) {
        UtilsKt.a();
        boolean r101 = this.f458144b.addAll(r100);
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((AbsBarrage) r102.next()).p(AbsBarrage.State.VISIBLE);
        this.f458143a.b();
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        if ((r100 instanceof AbsBarrage) == false) goto L6;
        List<AbsBarrage> r101 = this.f458144b;
        return r101.contains((AbsBarrage) r100);
    L6:
        return false;
    }

    @Override // java.util.List
    public final AbsBarrage get(int r100) {
        return (AbsBarrage) ListProtector.get(this.f458144b, r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        if ((r100 instanceof AbsBarrage) == false) goto L6;
        List<AbsBarrage> r101 = this.f458144b;
        return r101.indexOf((AbsBarrage) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        if ((r100 instanceof AbsBarrage) == false) goto L6;
        List<AbsBarrage> r101 = this.f458144b;
        return r101.lastIndexOf((AbsBarrage) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<AbsBarrage> listIterator(int r100) {
        return new C5473a(this.f458144b.listIterator(r100), this.f458143a);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        if ((r100 instanceof AbsBarrage) == false) goto L6;
        AbsBarrage r101 = (AbsBarrage) r100;
        UtilsKt.a();
        boolean r102 = this.f458144b.remove(r101);
        r101.p(AbsBarrage.State.HIDDEN);
        this.f458143a.a(r101);
        return r102;
    L6:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        UtilsKt.a();
        boolean r101 = this.f458144b.removeAll(r100);
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        AbsBarrage r103 = (AbsBarrage) r102.next();
        r103.p(AbsBarrage.State.HIDDEN);
        this.f458143a.a(r103);
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate<? super AbsBarrage> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<AbsBarrage> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final AbsBarrage remove(int r100) {
        UtilsKt.a();
        AbsBarrage r101 = (AbsBarrage) ListProtector.remove(this.f458144b, r100);
        r101.p(AbsBarrage.State.HIDDEN);
        this.f458143a.a(r101);
        return r101;
    }

    public a(AbsBarrageController.c r100, List r101) {
        this.f458143a = r100;
        this.f458144b = r101;
    }

    @Override // java.util.List
    public final void add(int r100, AbsBarrage r101) {
        AbsBarrage r102 = r101;
        UtilsKt.a();
        ListProtector.add(this.f458144b, r100, r102);
        r102.p(AbsBarrage.State.VISIBLE);
        this.f458143a.b();
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends AbsBarrage> r101) {
        UtilsKt.a();
        boolean r102 = this.f458144b.addAll(r100, r101);
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((AbsBarrage) r103.next()).p(AbsBarrage.State.VISIBLE);
        this.f458143a.b();
        goto L4
    L6:
        return r102;
    }

    @Override // java.util.List
    public final AbsBarrage set(int r100, AbsBarrage r101) {
        AbsBarrage r102 = r101;
        List<AbsBarrage> r103 = this.f458144b;
        r102.p(AbsBarrage.State.VISIBLE);
        this.f458143a.a(r102);
        AbsBarrage r104 = (AbsBarrage) ListProtector.set(r103, r100, r102);
        r104.p(AbsBarrage.State.HIDDEN);
        this.f458143a.a(r104);
        return r104;
    }

    @Override // java.util.List
    public final List<AbsBarrage> subList(int r100, int r101) {
        throw new UnsupportedOperationException();
    }
}
