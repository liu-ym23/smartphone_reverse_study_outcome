package org.jsoup.helper;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ChangeNotifyingArrayList<E> extends ArrayList<E> {
    public abstract void onContentsChanged();

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        onContentsChanged();
        super.clear();
    }

    public ChangeNotifyingArrayList(int r100) {
        super(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        onContentsChanged();
        return super.add(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r100) {
        onContentsChanged();
        return super.addAll(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E remove(int r100) {
        onContentsChanged();
        return (E) super.remove(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r100) {
        onContentsChanged();
        return super.removeAll(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r100) {
        onContentsChanged();
        return super.retainAll(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        onContentsChanged();
        return super.remove(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        onContentsChanged();
        super.add(r100, r101);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends E> r101) {
        onContentsChanged();
        return super.addAll(r100, r101);
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r100, int r101) {
        onContentsChanged();
        super.removeRange(r100, r101);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        onContentsChanged();
        return (E) super.set(r100, r101);
    }
}
