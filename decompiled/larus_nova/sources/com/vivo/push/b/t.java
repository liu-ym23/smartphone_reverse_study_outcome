package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public class t extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462262b;

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }

    public final String i() {
        return this.f462261a;
    }

    public final int j() {
        return this.f462262b;
    }

    public t(int r100) {
        super(r100);
        this.f462261a = null;
        this.f462262b = 0;
    }

    @Override // com.vivo.push.v
    public void c(com.vivo.push.d r100) {
        r100.a("req_id", this.f462261a);
        r100.a("status_msg_code", this.f462262b);
    }

    @Override // com.vivo.push.v
    public void d(com.vivo.push.d r100) {
        this.f462261a = r100.a("req_id");
        this.f462262b = r100.b("status_msg_code", this.f462262b);
    }
}
