package com.bytedance.crash.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ListMap<K, V> extends ConcurrentHashMap<K, List<V>> {
    private static final long serialVersionUID = -8278080958339137414L;

    public List<V> newList() {
        return new ArrayList();
    }

    public ListMap() {
    }

    public List<V> getList(K r2) {
        List<V> r0 = (List) super.get(r2);
        if (r0 != null) goto L6;
        List<V> r1 = newList();
        put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public void removeAll(V r3) {
        Iterator<V> r0 = values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((List) r0.next()).remove(r3);
        goto L4
    }

    public void add(K r1, V r2) {
        getList(r1).add(r2);
    }

    public void addMulti(V r4, K... r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.length <= 0) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        getList(r5[r1]).add(r4);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    public void removeInList(K r1, V r2) {
        getList(r1).remove(r2);
    }
}
