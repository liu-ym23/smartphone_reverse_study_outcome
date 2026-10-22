package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class i extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f462236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462237d;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    public final String e() {
        return this.f462234a;
    }

    public final String f() {
        return this.f462236c;
    }

    public i(int r100) {
        super(r100);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("app_id", this.f462234a);
        r100.a("client_id", this.f462235b);
        r100.a("client_token", this.f462236c);
        r100.a("client_token_validity_period", this.f462237d);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462234a = r100.a("app_id");
        this.f462235b = r100.a("client_id");
        this.f462236c = r100.a("client_token");
        this.f462237d = r100.a("client_token_validity_period");
    }
}
