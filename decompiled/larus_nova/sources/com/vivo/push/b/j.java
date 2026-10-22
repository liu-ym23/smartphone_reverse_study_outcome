package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462239b;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    public j() {
        super(12);
        this.f462238a = -1;
        this.f462239b = -1;
    }

    public final int e() {
        return this.f462238a;
    }

    public final int f() {
        return this.f462239b;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f462238a);
        r100.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f462239b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462238a = r100.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f462238a);
        this.f462239b = r100.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f462239b);
    }
}
