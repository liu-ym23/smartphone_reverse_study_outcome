package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class x extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462269a;

    @Override // com.vivo.push.v
    public final boolean d() {
        return true;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    public x() {
        super(2011);
        this.f462269a = 0;
    }

    public final int e() {
        return this.f462269a;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        r100.a("com.bbk.push.ikey.MODE_TYPE", this.f462269a);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        this.f462269a = r100.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
