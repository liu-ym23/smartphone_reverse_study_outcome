package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.p;

/* JADX INFO: loaded from: classes22.dex */
public class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f273437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f273438c;

    public void a(com.cmic.sso.sdk.a r100) {
        com.cmic.sso.sdk.c.b.a r101 = this.f273437b.c();
        r101.u(r100.b("socketip"));
        com.cmic.sso.sdk.e.c.b("HttpGetPrephoneRequest", "socket socketip = " + r100.b("socketip"));
        if (this.f273438c == false) goto L5;
    L14:
        r101.n(r101.w(r100.b("appkey")));
        this.f273437b.a(r101);
        this.f273437b.a(true);
        this.f273439a = this.f273437b.b().toString();
        return;
    L5:
        if (r100.b("isCloseIpv4", false) == true) goto L7;
        String[] r102 = p.a(true);
        r101.q(r102[0]);
    L9:
        if (r100.b("isCloseIpv6", false) == true) goto L13;
        if (r102 != null) goto L12;
        r102 = p.a(true);
    L12:
        r101.r(r102[1]);
    L13:
        this.f273438c = true;
        goto L14
    L7:
        r102 = null;
        goto L9
    }

    public b(String r100, e r101, String r102, String r103) {
        super(r100, r101, r102, r103);
        this.f273438c = false;
        this.f273437b = r101;
    }
}
