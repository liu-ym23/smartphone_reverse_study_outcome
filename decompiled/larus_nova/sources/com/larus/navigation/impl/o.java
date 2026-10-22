package com.larus.navigation.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class o implements tl9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.navigation.api.p f359906a;

    @Override // tl9.c
    public final void b(String r100, String r101, Integer r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
    }

    @Override // tl9.c
    public final void c(int r100, JSONObject r101) {
    }

    @Override // tl9.c
    public final void a() {
        com.larus.navigation.api.c.d("kmp_adapter", "bridge.onRemoved: forwarding to NavigationNotificationCallback");
        this.f359906a.a();
    }

    @Override // tl9.c
    public final void onClick() {
        com.larus.navigation.api.c.d("kmp_adapter", "bridge.onClick: forwarding to NavigationNotificationCallback");
        this.f359906a.c();
    }

    public o(com.bytedance.applet.aibridge.navigation.m r100) {
        this.f359906a = r100;
    }
}
