package com.cmic.ida.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f273268b;

    private z b() {
        if (this.f273267a != null) goto L6;
        return null;
    L6:
        if (a0.a() == false) goto L10;
        return new c(this.f273267a);
    L10:
        if (a0.f() == true) goto L71;
        if (a0.d() == true) goto L71;
        if (a0.e() == false) goto L19;
        return new k(this.f273267a);
    L19:
        if (a0.g() == true) goto L69;
        if (a0.j() == true) goto L69;
        if (a0.h() == false) goto L28;
        return new w(this.f273267a);
    L28:
        if (a0.k() == false) goto L32;
        return new x(this.f273267a);
    L32:
        if (a0.m() == true) goto L67;
        if (a0.l() == true) goto L67;
        if (a0.n() == false) goto L41;
        return new l0(this.f273267a);
    L41:
        if (a0.o() == false) goto L45;
        return new z0(this.f273267a);
    L45:
        if (a0.p() == true) goto L65;
        if (a0.i() == true) goto L65;
        if (a0.b() == true) goto L65;
        if (a0.q() == false) goto L56;
        return new b1(this.f273267a);
    L56:
        if (a0.a(this.f273267a) == false) goto L60;
        return new i(this.f273267a);
    L60:
        if (a0.c() == true) goto L62;
        return null;
    L62:
        return new j(this.f273267a);
    L65:
        return new a1(this.f273267a);
    L67:
        return new b0(this.f273267a);
    L69:
        return new r(this.f273267a);
    L71:
        return new o(this.f273267a);
    }

    public String a() {
        z r100 = this.f273268b;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.b();
    }

    public y(Context r100) {
        this.f273267a = r100;
        this.f273268b = b();
    }
}
