package com.bytedance.applet.aibridge.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends c {
    public final f3.h<AbsStartMapNavigationIDL.b> f;

    @Override // com.bytedance.applet.aibridge.navigation.c
    public final void l(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        f3.h.a.a(this.f, r4, null, null, 14);
    }

    @Override // com.bytedance.applet.aibridge.navigation.c
    public final void m(String r4) {
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        f3.h<AbsStartMapNavigationIDL.b> r0 = this.f;
        Intrinsics.checkNotNullParameter(AbsStartMapNavigationIDL.b.class, "<this>");
        AbsStartMapNavigationIDL.b r1 = k3.c.a(AbsStartMapNavigationIDL.b.class);
        r1.setNavigationId(r4);
        f3.h.a.b(r0, r1);
    }

    public f(f3.h<AbsStartMapNavigationIDL.b> r2, com.larus.navigation.api.w r3) {
        Intrinsics.checkNotNullParameter(r2, "jsbCallback");
        super(r3, "jsb_start_map_nav");
        this.f = r2;
    }
}
