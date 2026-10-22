package com.larksuite.framework.utils;

import android.util.LruCache;

/* JADX INFO: loaded from: classes24.dex */
public final class i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, T> f285999a;

    public i0() {
        this.f285999a = new LruCache(200);
    }

    public final T a(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return null;
    L5:
        return this.f285999a.get(r100 + "-" + r101);
    L6:
        return null;
    }

    public final void b(String r100, String r101, T r102) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        if (r102 == null) goto L9;
        this.f285999a.put(r100 + "-" + r101, r102);
        return;
    L9:
        return;
    L8:
        return;
    }
}
