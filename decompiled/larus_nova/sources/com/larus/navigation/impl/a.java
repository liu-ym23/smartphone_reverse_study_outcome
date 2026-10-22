package com.larus.navigation.impl;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements e37.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<String> f359774a;

    /* JADX INFO: renamed from: com.larus.navigation.impl.a$a, reason: collision with other inner class name */
    public static final class C4427a {
    }

    static {
    }

    public final void b() {
        this.f359774a.getAndSet(null);
    }

    public a() {
        this.f359774a = new AtomicReference(null);
    }

    @Override // e37.g
    public final void a(c37.f r100, com.bytedance.navigation.kmp.capability.navigation.f r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "listener");
        String r102 = this.f359774a.getAndSet(null);
        if (r102 == null) goto L5;
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("app_route_provider", "using preloaded route JSON (" + r102.length() + " chars)");
        r101.b(r102);
        return;
    L5:
        com.larus.navigation.api.c.b("app_route_provider", "routePlan called but no preloaded data available");
        r101.a(new IllegalStateException("No preloaded route data"));
    }
}
