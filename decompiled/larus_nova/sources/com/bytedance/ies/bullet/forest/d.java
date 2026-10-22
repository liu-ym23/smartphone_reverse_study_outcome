package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.ies.bullet.service.base.m0;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f246740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.forest.model.i f246741b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, GeckoConfig> f246742c = null;

    public d() {
    }

    static {
        f246740a = new d();
        f246741b = new com.bytedance.forest.model.i("", null, 6);
        f246742c = new ConcurrentHashMap();
    }

    public static void a() {
        com.bytedance.forest.model.i r100 = f246741b;
        r100.f244343e = true;
        s26.d r101 = s26.d.f540305c;
        m0 r102 = (m0) s26.d.f540305c.c(m0.class);
        if (r102 == null) goto L5;
        com.bytedance.ies.bullet.service.base.d r103 = r102.a0();
    L6:
        int r104 = 5;
        if (r103 == null) goto L9;
        int r105 = r103.f247847u0;
    L10:
        r100.f244341c = (r105 * 1024) * 1024;
        if (r103 == null) goto L13;
        r104 = r103.f247849v0;
    L13:
        r100.f244342d = (r104 * 1024) * 1024;
        r100.f244340b = ForestConfigCenter$initForestConfig$1$1.INSTANCE;
        return;
    L9:
        r105 = 5;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static void b(String r110, com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig r111, v26.j r112, boolean r113) {
        String r100 = r111.getAccessKey();
        com.bytedance.forest.model.i r101 = f246741b;
        GeckoConfig r102 = r101.f244347i.get(r100);
        if (r113 == true) goto L7;
        if (r102 == null) goto L7;
        com.bytedance.forest.utils.i r114 = com.bytedance.forest.utils.i.f244548a;
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Gecko config of " + r100 + " already exists! Config is " + r101.f244347i.get(r100), false, 60);
    L9:
        if (f246742c.putIfAbsent(r110, r102) != null) goto L11;
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Register minor gecko config=" + r101.f244347i.get(r100) + " for " + r110, false, 60);
        return;
    L11:
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Gecko config of " + r110 + " already exists! Config is " + r101.f244347i.get(r100), false, 60);
        return;
    L7:
        r102 = e.a(r111, r112.f552683d, r112.f552684e, r112.f552685f, r112.f552681b);
        r101.f244347i.put(r100, r102);
        com.bytedance.forest.utils.i r115 = com.bytedance.forest.utils.i.f244548a;
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Register minor gecko config=" + r101.f244347i.get(r100) + " for " + r100, false, 60);
        goto L9
    }
}
