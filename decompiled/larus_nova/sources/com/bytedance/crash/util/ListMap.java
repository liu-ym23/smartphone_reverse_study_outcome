package com.bytedance.crash.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ListMap<K, V> extends ConcurrentHashMap<K, List<V>> {
    private static final long serialVersionUID = -8278080958339137414L;

    public List<V> newList() {
        return new ArrayList();
    }

    public ListMap() {
    }

    public List<V> getList(K r100) {
        List<V> r101 = (List) super.get(r100);
        if (r101 != null) goto L6;
        List<V> r102 = newList();
        put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public void removeAll(V r100) {
        Iterator<V> r101 = values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((List) r101.next()).remove(r100);
        goto L4
    }

    public void add(K r100, V r101) {
        getList(r100).add(r101);
    }

    public void addMulti(V r100, K... r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.length <= 0) goto L12;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        getList(r101[r103]).add(r100);
        r103 = r103 + 1;
        goto L8
    L13:
        return;
    }

    public void removeInList(K r100, V r101) {
        getList(r100).remove(r101);
    }
}
