package com.bytedance.ug.sdk.share.impl.manager;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements io7.d.InterfaceC6341d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f272323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f272324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f272325c;

    public final void a(int r100, String r101) {
        oo7.k.e("ShareSdkManager", "share init interface failed, status: " + r100 + ", errorMsg: " + r101);
        go7.b.g(false, r101, System.currentTimeMillis() - this.f272323a);
        go7.a.f(1, System.currentTimeMillis() - this.f272324b);
        co7.c r102 = this.f272325c.f272332g;
        if (r102 == null) goto L6;
        r102.getClass();
        this.f272325c.f272332g = null;
        return;
    }

    public c(h r100, long r101, long r102) {
        this.f272325c = r100;
        this.f272323a = r101;
        this.f272324b = r102;
    }
}
