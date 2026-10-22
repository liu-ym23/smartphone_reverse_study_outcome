package com.bytedance.ugc.ugcwidget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes22.dex */
public class UGCSafeList<T> implements Collection<T> {
    private ArrayList<T> copy;
    private final ArrayList<T> list;

    @Override // java.util.Collection
    public void clear() {
        this.list.clear();
        this.copy = null;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        ArrayList<T> r100 = this.copy;
        if (r100 != null) goto L6;
        r100 = new ArrayList(this.list);
        this.copy = r100;
    L6:
        return r100.iterator();
    }

    @Override // java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    public UGCSafeList() {
        this.list = new ArrayList();
    }

    @Override // java.util.Collection
    public boolean add(T r100) {
        boolean r101 = this.list.add(r100);
        this.copy = null;
        return r101;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.copy = null;
        return r101;
    L4:
        if (this.list.addAll(r100) == false) goto L6;
        r101 = true;
        goto L7
    }

    @Override // java.util.Collection
    public boolean contains(Object r100) {
        return this.list.contains(r100);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.list.containsAll(r100) == false) goto L6;
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object r100) {
        boolean r101 = this.list.remove(r100);
        this.copy = null;
        return r101;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.copy = null;
        return r101;
    L4:
        if (this.list.removeAll(r100) == false) goto L6;
        r101 = true;
        goto L7
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.copy = null;
        return r101;
    L4:
        if (this.list.retainAll(r100) == false) goto L6;
        r101 = true;
        goto L7
    }

    @Override // java.util.Collection
    public <T1> T1[] toArray(T1[] r100) {
        return (T1[]) this.list.toArray(r100);
    }
}
