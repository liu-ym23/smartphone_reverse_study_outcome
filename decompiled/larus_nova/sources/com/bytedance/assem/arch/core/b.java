package com.bytedance.assem.arch.core;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<g, com.bytedance.assem.arch.extensions.a> f192886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f192887b;

    public b() {
        this(null);
    }

    public b(b r100) {
        this.f192887b = r100;
        this.f192886a = new LinkedHashMap();
    }

    public final <T> T a(Class<T> r100, String r101) throws IllegalArgumentException {
        g r102 = new g(r100, r101);
        b r103 = this;
    L3:
        if (r103 == null) goto L10;
        if (r103.f192886a.containsKey(r102) == true) goto L7;
        r103 = r103.f192887b;
        goto L3
    L7:
        return (T) ((LinkedHashMap) r103.f192886a).get(r102);
    L10:
        throw new IllegalArgumentException("No such data hierarchy by parent.");
    }

    public final <T> T b(Class<T> r100, String r101) {
        g r102 = new g(r100, r101);
        b r103 = this;
    L3:
        if (r103 == null) goto L9;
        if (r103.f192886a.containsKey(r102) == true) goto L7;
        r103 = r103.f192887b;
        goto L3
    L7:
        return (T) ((LinkedHashMap) r103.f192886a).get(r102);
    L9:
        return null;
    }

    public final void c(com.bytedance.assem.arch.extensions.a r100, String r101) throws IllegalArgumentException {
        if (r100 == null) goto L5;
        this.f192886a.put(new g(r100.getClass(), r101), r100);
        return;
    }
}
