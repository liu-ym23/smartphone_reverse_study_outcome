package com.bytedance.awemeopen.apps.framework.utils;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements i54.b {
    public static final c a = null;
    public static final k34.b b = null;

    public c() {
    }

    static {
        a = new c();
        d14.a r0 = b14.a.a;
        b = b14.a.a(k34.b.class);
    }

    public static k34.a b() {
        k34.b r0 = b;
        if (r0 == null) goto L5;
        r0.M1();
        com.bytedance.awemeopen.appserviceimpl.user.a r1 = com.bytedance.awemeopen.appserviceimpl.user.a.a;
        return com.bytedance.awemeopen.appserviceimpl.user.a.b;
    L5:
        return null;
    }

    public final Map<String, String> a() {
        k34.b r0 = b;
        if (r0 == null) goto L5;
        r0.M1();
        return com.bytedance.awemeopen.appserviceimpl.user.a.a.b();
    L5:
        return null;
    }

    public static void c(k34.a r1) {
        k34.b r0 = b;
        if (r0 == null) goto L6;
        r0.M1();
        com.bytedance.awemeopen.appserviceimpl.user.a.a.c(r1);
        return;
    }
}
