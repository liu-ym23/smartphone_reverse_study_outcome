package com.bytedance.awemeopen.apps.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class q0<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<E, Object> f197738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f197739b;

    @Override // java.lang.Iterable
    public final Iterator<E> iterator() {
        ArrayList r100 = new ArrayList(this.f197738a.size());
        Iterator<E> r101 = this.f197738a.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        E r102 = r101.next();
        if (r102 == null) goto L4;
        r100.add(r102);
        goto L4
    L9:
        return r100.iterator();
    }

    public q0() {
        this.f197738a = new WeakHashMap();
        this.f197739b = new Object();
    }
}
