package com.cmic.sso.sdk.c.a;

import com.cmic.sso.sdk.e.r;

/* JADX INFO: loaded from: classes22.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f273364a;

    public d() {
    }

    public void a(b r100) {
        this.f273364a = r100;
    }

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(final com.cmic.sso.sdk.c.c.c r100, final com.cmic.sso.sdk.c.d.c r101, final com.cmic.sso.sdk.a r102) {
        if (r100.b() == true) goto L6;
        b(r100, r101, r102);
        return;
    L6:
        r.a(null).a(new AnonymousClass1(this, r102, r100, r101));
    }

    public void b(com.cmic.sso.sdk.c.c.c r100, final com.cmic.sso.sdk.c.d.c r101, com.cmic.sso.sdk.a r102) {
        b r103 = this.f273364a;
        if (r103 == null) goto L6;
        r103.a(r100, new AnonymousClass2(this, r101), r102);
        return;
    }
}
