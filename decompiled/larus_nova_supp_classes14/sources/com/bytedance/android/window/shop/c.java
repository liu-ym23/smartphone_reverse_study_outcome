package com.bytedance.android.window.shop;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final ConcurrentHashMap<Integer, c> b = null;
    public static final c c = null;
    public static final c d = null;
    public static final c e = null;
    public static final c f = null;
    public static final c g = null;
    public final int a;

    public static final class a {
        public static c a(int r2) {
            ConcurrentHashMap<Integer, c> r0 = c.b;
            c r1 = r0.get(Integer.valueOf(r2));
            if (r1 != null) goto L6;
            c r3 = new c(r2);
            r0.put(Integer.valueOf(r2), r3);
            return r3;
        L6:
            return r1;
        }
    }

    static {
        b = new ConcurrentHashMap();
        c = a.a(100);
        d = a.a(200);
        e = a.a(300);
        f = a.a(400);
        g = a.a(500);
    }

    public final int getType() {
        return this.a;
    }

    public c(int r1) {
        this.a = r1;
    }
}
