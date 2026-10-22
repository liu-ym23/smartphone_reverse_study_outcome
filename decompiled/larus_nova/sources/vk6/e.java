package vk6;

import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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

/* JADX INFO: loaded from: classes19.dex */
public final class e<T extends Danmaku> implements List<T>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f555519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f555520b;

    public static final class a<T extends Danmaku> implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f555521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ListIterator<T> f555522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b<T> f555523c;

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f555522b.hasNext();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f555522b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f555522b.nextIndex();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f555522b.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            T r100 = this.f555522b.next();
            this.f555521a = r100;
            return r100;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            T r100 = this.f555522b.previous();
            this.f555521a = r100;
            return r100;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            this.f555522b.remove();
            T r100 = this.f555521a;
            if (r100 == null) goto L6;
            r100.f(Danmaku.State.HIDDEN);
            this.f555523c.a(r100);
            return;
        }

        @Override // java.util.ListIterator
        public final void add(Object r100) {
            Danmaku r101 = (Danmaku) r100;
            ListIterator<T> r102 = this.f555522b;
            r101.f(Danmaku.State.VISIBLE);
            this.f555523c.b(r101);
            r102.add((T) r101);
        }

        @Override // java.util.ListIterator
        public final void set(Object r100) {
            Danmaku r101 = (Danmaku) r100;
            ListIterator<T> r102 = this.f555522b;
            r101.f(Danmaku.State.VISIBLE);
            this.f555523c.b(r101);
            r102.set((T) r101);
            T r103 = this.f555521a;
            if (r103 == null) goto L6;
            r103.f(Danmaku.State.HIDDEN);
            this.f555523c.a(r103);
            return;
        }

        public a(ListIterator<T> r100, b<T> r101) {
            this.f555522b = r100;
            this.f555523c = r101;
        }
    }

    public interface b<T extends Danmaku> {
        void a(T r100);

        void b(T r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        return this.f555520b.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f555520b.isEmpty();
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
        List<T> r100 = this.f555520b;
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Danmaku r102 = (Danmaku) r101.next();
        r102.f(Danmaku.State.HIDDEN);
        this.f555519a.a(r102);
        goto L4
    L6:
        r100.clear();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new a(this.f555520b.listIterator(), this.f555519a);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return new a(this.f555520b.listIterator(), this.f555519a);
    }

    @Override // java.util.Collection
    public final Stream<T> parallelStream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f555520b.size();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final Stream<T> stream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r100) {
        Danmaku r101 = (Danmaku) r100;
        boolean r102 = this.f555520b.add((T) r101);
        r101.f(Danmaku.State.VISIBLE);
        this.f555519a.b(r101);
        return r102;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> r100) {
        boolean r101 = this.f555520b.addAll(r100);
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Danmaku r103 = (Danmaku) r102.next();
        r103.f(Danmaku.State.VISIBLE);
        this.f555519a.b(r103);
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        if ((r100 instanceof Danmaku) == false) goto L6;
        List<T> r101 = this.f555520b;
        return r101.contains((Danmaku) r100);
    L6:
        return false;
    }

    @Override // java.util.List
    public final Object get(int r100) {
        return (Danmaku) ListProtector.get(this.f555520b, r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        if ((r100 instanceof Danmaku) == false) goto L6;
        List<T> r101 = this.f555520b;
        return r101.indexOf((Danmaku) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        if ((r100 instanceof Danmaku) == false) goto L6;
        List<T> r101 = this.f555520b;
        return r101.lastIndexOf((Danmaku) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int r100) {
        return new a(this.f555520b.listIterator(r100), this.f555519a);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        if ((r100 instanceof Danmaku) == false) goto L6;
        Danmaku r101 = (Danmaku) r100;
        boolean r102 = this.f555520b.remove(r101);
        r101.f(Danmaku.State.HIDDEN);
        this.f555519a.a(r101);
        return r102;
    L6:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        boolean r101 = this.f555520b.removeAll(r100);
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Danmaku r103 = (Danmaku) r102.next();
        r103.f(Danmaku.State.HIDDEN);
        this.f555519a.a(r103);
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate<? super T> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<T> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object remove(int r100) {
        Danmaku r101 = (Danmaku) ListProtector.remove(this.f555520b, r100);
        r101.f(Danmaku.State.HIDDEN);
        this.f555519a.a(r101);
        return r101;
    }

    public e(DanmakuController.c r100, List r101) {
        this.f555519a = r100;
        this.f555520b = r101;
    }

    @Override // java.util.List
    public final void add(int r100, Object r101) {
        Danmaku r102 = (Danmaku) r101;
        ListProtector.add(this.f555520b, r100, r102);
        r102.f(Danmaku.State.VISIBLE);
        this.f555519a.b(r102);
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends T> r101) {
        boolean r102 = this.f555520b.addAll(r100, r101);
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Danmaku r104 = (Danmaku) r103.next();
        r104.f(Danmaku.State.VISIBLE);
        this.f555519a.b(r104);
        goto L4
    L6:
        return r102;
    }

    @Override // java.util.List
    public final Object set(int r100, Object r101) {
        Danmaku r102 = (Danmaku) r101;
        List<T> r103 = this.f555520b;
        r102.f(Danmaku.State.VISIBLE);
        this.f555519a.a(r102);
        Danmaku r104 = (Danmaku) ListProtector.set(r103, r100, r102);
        r104.f(Danmaku.State.HIDDEN);
        this.f555519a.a(r104);
        return r104;
    }

    @Override // java.util.List
    public final List<T> subList(int r100, int r101) {
        throw new UnsupportedOperationException();
    }
}
