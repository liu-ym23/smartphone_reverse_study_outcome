package com.bytedance.awemeopen.apps.framework.utils;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements i54.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f197680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k34.b f197681b = null;

    public c() {
    }

    static {
        f197680a = new c();
        d14.a r100 = b14.a.f16924a;
        f197681b = (k34.b) b14.a.a(k34.b.class);
    }

    public static k34.a b() {
        k34.b r100 = f197681b;
        if (r100 == null) goto L5;
        r100.M1();
        com.bytedance.awemeopen.appserviceimpl.user.a r101 = com.bytedance.awemeopen.appserviceimpl.user.a.f198152a;
        return com.bytedance.awemeopen.appserviceimpl.user.a.f198153b;
    L5:
        return null;
    }

    @Override // i54.b
    public final Map<String, String> a() {
        k34.b r100 = f197681b;
        if (r100 == null) goto L5;
        r100.M1();
        return com.bytedance.awemeopen.appserviceimpl.user.a.f198152a.b();
    L5:
        return null;
    }

    public static void c(k34.a r100) {
        k34.b r101 = f197681b;
        if (r101 == null) goto L6;
        r101.M1();
        com.bytedance.awemeopen.appserviceimpl.user.a.f198152a.c(r100);
        return;
    }
}
