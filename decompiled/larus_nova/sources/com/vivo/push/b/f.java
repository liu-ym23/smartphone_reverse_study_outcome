package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462231a;

    public f() {
        super(0);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    public final void a(int r100) {
        this.f462231a = r100;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        if (r100 == null) goto L5;
        r100.a("APP_CLIENT_SWITCH_FLAG", this.f462231a);
        return;
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        if (r100 == null) goto L5;
        this.f462231a = r100.b("APP_CLIENT_SWITCH_FLAG", 0);
        return;
    }
}
