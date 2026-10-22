package com.bytedance.applet.aibridge.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends c {
    public final f3.h<AbsStartMapNavigationWithRouteIDL.b> f;

    @Override // com.bytedance.applet.aibridge.navigation.c
    public final void l(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        f3.h.a.a(this.f, r4, null, null, 14);
    }

    @Override // com.bytedance.applet.aibridge.navigation.c
    public final void m(String r4) {
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        f3.h<AbsStartMapNavigationWithRouteIDL.b> r0 = this.f;
        Intrinsics.checkNotNullParameter(AbsStartMapNavigationWithRouteIDL.b.class, "<this>");
        AbsStartMapNavigationWithRouteIDL.b r1 = k3.c.a(AbsStartMapNavigationWithRouteIDL.b.class);
        r1.setNavigationId(r4);
        f3.h.a.b(r0, r1);
    }

    public e(f3.h<AbsStartMapNavigationWithRouteIDL.b> r2, com.larus.navigation.api.w r3) {
        Intrinsics.checkNotNullParameter(r2, "jsbCallback");
        super(r3, "jsb_start_nav_route");
        this.f = r2;
    }
}
