package com.bytedance.salamander.anniex;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXAnnieXServiceCenterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function1<String, String> f267803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function1<String, t1> f267804b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f267805c = null;

    static {
        f267803a = AnnieXAnnieXServiceCenterKt$createAnnieXBizServiceStoreId$1.INSTANCE;
        f267804b = AnnieXAnnieXServiceCenterKt$createAnnieXServiceStore$1.INSTANCE;
        f267805c = "AnnieX";
    }

    public static k3 a(String r100) {
        Intrinsics.checkNotNullParameter("AnnieXContainerUIService", "serviceId");
        Intrinsics.checkNotNullParameter(r100, "bid");
        r1 r101 = r1.f268341d;
        r101.getClass();
        Intrinsics.checkNotNullParameter("AnnieXContainerUIService", "serviceId");
        Intrinsics.checkNotNullParameter(r100, "bid");
        com.bytedance.anniex.bd.foundation.impl.s<String, t1> r102 = r101.f268344c;
        t1 r103 = r102.f190154a.get(f267803a.invoke(r100));
        if (r103 != null) goto L5;
        com.bytedance.anniex.bd.foundation.impl.c.f190141a.b("getService from bizServiceStore fail: bizServiceStore not found! serviceId: AnnieXContainerUIService, bid: " + r100);
    L8:
        k3 r104 = null;
    L9:
        if (r104 != null) goto L23;
        k3 r105 = r101.a("AnnieXContainerUIService");
        if (r105 != null) goto L24;
        Intrinsics.checkNotNullParameter("AnnieXContainerUIService", "serviceId");
        String r106 = f267805c;
        k3 r107 = (k3) r101.f268342a.a(r106 + "_Default_AnnieXContainerUIService");
        if (r107 != null) goto L21;
        k3 r108 = (k3) r101.f268342a.a(r106 + "_Default_AnnieXContainerUIService");
        if (r108 != null) goto L22;
        com.bytedance.anniex.bd.foundation.impl.c.f190141a.b("getService from defaultServiceStore fail: service not found! serviceId: ".concat("AnnieXContainerUIService"));
        return r108;
    L22:
        return r108;
    L21:
        return r107;
    L24:
        return r105;
    L23:
        return r104;
    L5:
        r104 = (k3) r103.a("AnnieXContainerUIService");
        if (r104 != null) goto L9;
        com.bytedance.anniex.bd.foundation.impl.c.f190141a.b("getService from bizServiceStore fail: service not found! serviceId: AnnieXContainerUIService, bid: " + r100);
        goto L8
    }
}
