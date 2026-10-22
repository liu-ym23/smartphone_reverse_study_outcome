package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public abstract class w extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f462268b;

    public final long h() {
        return this.f462268b;
    }

    public final String k() {
        return this.f462267a;
    }

    public w(int r100) {
        super(r100);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f462267a);
        r100.a("notify_id", this.f462268b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462267a = r100.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f462268b = r100.b("notify_id", -1);
    }
}
