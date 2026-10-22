package com.bytedance.common.utility.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes15.dex */
public class WeakContainer<E> implements Iterable<E> {
    private final WeakHashMap<E, Object> mMap;
    private final Object mValue;

    public void clear() {
        this.mMap.clear();
    }

    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        ArrayList r100 = new ArrayList(this.mMap.size());
        Iterator<E> r101 = this.mMap.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        E r102 = r101.next();
        if (r102 == null) goto L4;
        r100.add(r102);
        goto L4
    L9:
        return r100.iterator();
    }

    public E peek() {
        E r100 = null;
        if (this.mMap.size() != 0) goto L5;
        return null;
    L5:
        Iterator<E> r101 = this.mMap.keySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        E r102 = r101.next();
        if (r102 == null) goto L7;
        r100 = r102;
    L11:
        this.mMap.remove(r100);
        return r100;
    }

    public int size() {
        return this.mMap.size();
    }

    public WeakContainer() {
        this.mMap = new WeakHashMap();
        this.mValue = new Object();
    }

    public void add(E r100) {
        if (r100 != null) goto L5;
        this.mMap.size();
        return;
    L5:
        this.mMap.put(r100, this.mValue);
    }

    public boolean contains(E r100) {
        return this.mMap.containsKey(r100);
    }

    public void remove(E r100) {
        if (r100 != null) goto L5;
        this.mMap.size();
        return;
    L5:
        this.mMap.remove(r100);
    }
}
