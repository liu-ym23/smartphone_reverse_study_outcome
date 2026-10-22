package com.bytedance.assem.arch.core;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final Map<g, com.bytedance.assem.arch.extensions.a> a;
    public final b b;

    public b() {
        this(null);
    }

    public b(b r1) {
        this.b = r1;
        this.a = new LinkedHashMap();
    }

    public final <T> T a(Class<T> r2, String r3) throws IllegalArgumentException {
        g r0 = new g(r2, r3);
        b r4 = this;
    L3:
        if (r4 == null) goto L10;
        if (r4.a.containsKey(r0) == true) goto L7;
        r4 = r4.b;
        goto L3
    L7:
        return (T) ((LinkedHashMap) r4.a).get(r0);
    L10:
        throw new IllegalArgumentException("No such data hierarchy by parent.");
    }

    public final <T> T b(Class<T> r2, String r3) {
        g r0 = new g(r2, r3);
        b r4 = this;
    L3:
        if (r4 == null) goto L9;
        if (r4.a.containsKey(r0) == true) goto L7;
        r4 = r4.b;
        goto L3
    L7:
        return (T) ((LinkedHashMap) r4.a).get(r0);
    L9:
        return null;
    }

    public final void c(com.bytedance.assem.arch.extensions.a r4, String r5) throws IllegalArgumentException {
        if (r4 == null) goto L5;
        this.a.put(new g(r4.getClass(), r5), r4);
        return;
    }
}
