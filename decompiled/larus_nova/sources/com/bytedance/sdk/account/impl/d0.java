package com.bytedance.sdk.account.impl;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements ta7.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d0 f268980b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f268981a;

    public static ta7.j c() {
        if (f268980b != null) goto L15;
        monitor-enter(d0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f268980b != null) goto L9;
        f268980b = new d0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d0.class);     // Catch: Throwable -> L11
    L15:
        return f268980b;
    }

    public d0() {
        this.f268981a = com.ss.android.account.k.d().getApplicationContext();
    }

    public final void a(String r100, Map<String, String> r101, Map<String, String> r102, ua7.a<xa7.c> r103) {
        Context r104 = this.f268981a;
        int r105 = rb7.c.f536945n;
        new rb7.c(r104, rb7.c.p(ta7.d.a(r100), r101, r102, true), r103).m();
    }

    public final void b(String r100, Map<String, String> r101, Map<String, String> r102, ua7.a<xa7.c> r103) {
        Context r104 = this.f268981a;
        int r105 = rb7.c.f536945n;
        new rb7.c(r104, rb7.c.p(ta7.d.a(r100), r101, r102, false), r103).m();
    }
}
