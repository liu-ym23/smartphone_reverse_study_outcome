package com.larus.home.impl.sdk;

import com.larus.amap.IAMapService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements com.larus.platform.api.l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f346134a = null;

    static {
        f346134a = new a();
    }

    public a() {
    }

    public static IAMapService e() {
        return (IAMapService) ServiceManager.get().getService(IAMapService.class);
    }

    @Override // com.larus.platform.api.l1
    public final boolean a() {
        IAMapService r100 = e();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.l1
    public final void b() {
        IAMapService r100 = e();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.platform.api.l1
    public final void c() {
        IAMapService r100 = e();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.larus.platform.api.l1
    public final void d(String r100, Pair<Double, Double> r101, String r102, Pair<Double, Double> r103, String r104, int r105, com.larus.platform.api.j0 r106) {
        Intrinsics.checkNotNullParameter(r103, "toCoordinate");
        Intrinsics.checkNotNullParameter(r104, "routeType");
        IAMapService r107 = e();
        if (r107 == null) goto L6;
        r107.d();
        return;
    }
}
