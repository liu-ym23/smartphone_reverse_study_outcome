package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes6.dex */
public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {
    private final ArrayList<E> delegate;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.delegate.toArray();
    }

    public NonNullElementWrapperList(ArrayList<E> r100) {
        Objects.requireNonNull(r100);
        this.delegate = r100;
    }

    private E nonNull(E r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r100) {
        return this.delegate.contains(r100);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        return this.delegate.equals(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r100) {
        return this.delegate.get(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r100) {
        return this.delegate.indexOf(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r100) {
        return this.delegate.lastIndexOf(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r100) {
        return this.delegate.remove(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r100) {
        return this.delegate.removeAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r100) {
        return this.delegate.retainAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r100) {
        return (T[]) this.delegate.toArray(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        return this.delegate.remove(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        this.delegate.add(r100, nonNull(r101));
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        return this.delegate.set(r100, nonNull(r101));
    }
}
