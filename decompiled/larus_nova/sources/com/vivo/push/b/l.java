package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class l extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462241b;

    public l() {
        super(2016);
        this.f462240a = -1;
        this.f462241b = -1;
    }

    public final int e() {
        return this.f462240a;
    }

    public final int f() {
        return this.f462241b;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("key_dispatch_environment", this.f462240a);
        r100.a("key_dispatch_area", this.f462241b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462240a = r100.b("key_dispatch_environment", 1);
        this.f462241b = r100.b("key_dispatch_area", 1);
    }
}
