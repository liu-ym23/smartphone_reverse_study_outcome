package com.larus.dora.impl.log;

/* JADX INFO: loaded from: classes27.dex */
public final class n implements ff7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f336139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f336140b;

    @Override // ff7.e
    public final void onSuccess() {
        DoraLogManager.f336045a.u(true, "upload log success");
        String r100 = p.f336143b;
        p.f(0, this.f336139a, System.currentTimeMillis() - this.f336140b);
    }

    @Override // ff7.e
    public final void onFail(String r100) {
        g49.d.b("DoraLogManager", "upload log failed, " + r100);
        DoraLogManager.f336045a.u(false, "upload log failed");
        String r101 = p.f336143b;
        p.f(1, this.f336139a, System.currentTimeMillis() - this.f336140b);
    }

    public n(int r100, long r101) {
        this.f336139a = r100;
        this.f336140b = r101;
    }
}
