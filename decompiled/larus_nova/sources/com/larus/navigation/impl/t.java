package com.larus.navigation.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class t implements tl9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.navigation.api.p f359965a;

    @Override // tl9.c
    public final void a() {
        com.larus.navigation.api.p r100 = this.f359965a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // tl9.c
    public final void onClick() {
        com.larus.navigation.api.p r100 = this.f359965a;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public t(com.larus.navigation.api.p r100) {
        this.f359965a = r100;
    }

    @Override // tl9.c
    public final void c(int r100, JSONObject r101) {
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("legacy_notification", "onError: code=" + r100 + ", extra=" + r101);
    }

    @Override // tl9.c
    public final void b(String r110, String r111, Integer r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "title");
        com.larus.navigation.api.p r100 = this.f359965a;
        if (r100 == null) goto L6;
        com.larus.navigation.api.p.a.a(r100, r110, r111, r112, r113, null, null, 48);
        return;
    }
}
