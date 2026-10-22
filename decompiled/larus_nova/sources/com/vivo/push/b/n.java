package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class n extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f462245c;

    public n() {
        super(7);
        this.f462244b = 0;
        this.f462245c = false;
    }

    public final void h() {
        this.f462245c = false;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    public final String e() {
        return this.f462243a;
    }

    public final int f() {
        return this.f462244b;
    }

    public final boolean g() {
        return this.f462245c;
    }

    public final void a(int r100) {
        this.f462244b = r100;
    }

    public final void b(String r100) {
        this.f462243a = r100;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("content", this.f462243a);
        r100.a("log_level", this.f462244b);
        r100.a("is_server_log", this.f462245c);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462243a = r100.a("content");
        this.f462244b = r100.b("log_level", 0);
        this.f462245c = r100.e("is_server_log");
    }
}
