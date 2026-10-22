package com.bytedance.salamander.anniex;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class r1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r1 f268341d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1 f268342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f268343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.anniex.bd.foundation.impl.s<String, t1> f268344c;

    public static final class a {
    }

    static {
        f268341d = new r1();
    }

    public r1() {
        Function1<String, t1> r100 = AnnieXAnnieXServiceCenterKt.f267804b;
        int r101 = u1.f268403a;
        this.f268342a = r100.invoke("AnnieXDefaultServiceStore");
        this.f268343b = r100.invoke("AnnieXHostServiceStore");
        this.f268344c = new com.bytedance.anniex.bd.foundation.impl.s();
    }

    public final k3 a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceId");
        k3 r101 = (k3) this.f268343b.a(r100);
        if (r101 != null) goto L5;
        com.bytedance.anniex.bd.foundation.impl.c.f190141a.b("getService from hostServiceStore fail: service not found! serviceId: ".concat(r100));
    L5:
        return r101;
    }
}
