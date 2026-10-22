package io.reactivex.internal.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }

    public VolatileSizeArrayList() {
        this.list = new ArrayList();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (get() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    public VolatileSizeArrayList(int r100) {
        this.list = new ArrayList(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r100) {
        boolean r101 = this.list.add(r100);
        lazySet(this.list.size());
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
        boolean r101 = this.list.addAll(r100);
        lazySet(this.list.size());
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r100) {
        return this.list.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return this.list.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r100) {
        if ((r100 instanceof VolatileSizeArrayList) == false) goto L7;
        return this.list.equals(((VolatileSizeArrayList) r100).list);
    L7:
        return this.list.equals(r100);
    }

    @Override // java.util.List
    public T get(int r100) {
        return (T) ListProtector.get(this.list, r100);
    }

    @Override // java.util.List
    public int indexOf(Object r100) {
        return this.list.indexOf(r100);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r100) {
        return this.list.lastIndexOf(r100);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r100) {
        return this.list.listIterator(r100);
    }

    @Override // java.util.List
    public T remove(int r100) {
        T r101 = (T) ListProtector.remove(this.list, r100);
        lazySet(this.list.size());
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        boolean r101 = this.list.removeAll(r100);
        lazySet(this.list.size());
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        boolean r101 = this.list.retainAll(r100);
        lazySet(this.list.size());
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] r100) {
        return (E[]) this.list.toArray(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r100) {
        boolean r101 = this.list.remove(r100);
        lazySet(this.list.size());
        return r101;
    }

    @Override // java.util.List
    public void add(int r100, T r101) {
        ListProtector.add(this.list, r100, r101);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends T> r101) {
        boolean r102 = this.list.addAll(r100, r101);
        lazySet(this.list.size());
        return r102;
    }

    @Override // java.util.List
    public T set(int r100, T r101) {
        return (T) ListProtector.set(this.list, r100, r101);
    }

    @Override // java.util.List
    public List<T> subList(int r100, int r101) {
        return this.list.subList(r100, r101);
    }
}
