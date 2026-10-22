package com.cmic.sso.sdk.c.a;

/* JADX INFO: loaded from: classes22.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f273357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.cmic.sso.sdk.c.d.c f273358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.cmic.sso.sdk.c.b f273359c;

    public c() {
        this.f273359c = new com.cmic.sso.sdk.c.b();
    }

    public static /* synthetic */ com.cmic.sso.sdk.c.b a(c r100) {
        return r100.f273359c;
    }

    public void a(b r100) {
        this.f273357a = r100;
    }

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(com.cmic.sso.sdk.c.c.c r100, com.cmic.sso.sdk.c.d.c r101, com.cmic.sso.sdk.a r102) {
        b(r100, r101, r102);
    }

    public void b(final com.cmic.sso.sdk.c.c.c r100, final com.cmic.sso.sdk.c.d.c r101, final com.cmic.sso.sdk.a r102) {
        if (this.f273357a == null) goto L6;
        com.cmic.sso.sdk.c.d.c r103 = new AnonymousClass1(this, r100, r102, r101);
        this.f273358b = r103;
        this.f273357a.a(r100, r103, r102);
        return;
    }
}
