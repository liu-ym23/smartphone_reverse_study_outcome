package com.bytedance.awemeopen.apps.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q0<E> implements Iterable<E> {
    public final WeakHashMap<E, Object> a;
    public final Object b;

    @Override // java.lang.Iterable
    public final Iterator<E> iterator() {
        ArrayList r0 = new ArrayList(this.a.size());
        Iterator<E> r1 = this.a.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        E r2 = r1.next();
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return r0.iterator();
    }

    public q0() {
        this.a = new WeakHashMap();
        this.b = new Object();
    }
}
