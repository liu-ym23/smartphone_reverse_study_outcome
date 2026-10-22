package com.ss.android.lark.todo.impl.features.badge;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<a, Integer> f441372a = null;

    public b() {
    }

    static {
        f441372a = new ConcurrentHashMap();
    }

    public static final void a(int r100) {
        Iterator<a> r101 = f441372a.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a();
        goto L4
    }
}
