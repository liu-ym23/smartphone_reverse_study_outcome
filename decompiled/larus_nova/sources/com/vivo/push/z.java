package com.vivo.push;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class z implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y f462620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f462621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.vivo.push.c.a f462622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile String f462623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f462624e;

    private int c() {
        if (this.f462622c.d() == true) goto L7;
        return 8013;
    L7:
        if (this.f462621b.a() == false) goto L10;
        com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
        return 1002;
    L10:
        int r100 = 1;
        String r101 = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();     // Catch: Exception -> L15
        com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(r101)));     // Catch: Exception -> L15
        String r102 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), r101);     // Catch: Exception -> L15
        com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(r102)));     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r102) == true) goto L17;
        r100 = 1 ^ (Boolean.parseBoolean(((g) g.f462326a.a(r102)).b()) ? 1 : 0);
    L17:
        com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(r100)));
        return r100;
    L15:
        e = move-exception;
        com.vivo.push.util.t.a("SubscribeImpl", "isAppSubscribe", e);
        goto L17
    }

    private String d() {
        String r100 = "";
        if (this.f462622c.d() == true) goto L7;
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
        return "";
    L7:
        if (this.f462620a.a() == false) goto L18;
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
        return "";
    L18:
        String r101 = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();     // Catch: Exception -> L14
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(r101)));     // Catch: Exception -> L14
        String r102 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), r101);     // Catch: Exception -> L14
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(r102)));     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r102) == true) goto L16;
        r100 = ((g) g.f462326a.a(r102)).b();     // Catch: Exception -> L14
    L16:
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(r100)));
        return r100;
    L14:
        e = move-exception;
        com.vivo.push.util.t.a("SubscribeImpl", "getRegidByCoreSdk", e);
        goto L16
    }

    @Override // com.vivo.push.k
    public final String b() {
        if (TextUtils.isEmpty(this.f462623d) == false) goto L5;
        String r100 = d();
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = this.f462624e.f();
        t.b(new aa(this, r100));
    L9:
        this.f462623d = r100;
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(r100)));
        return r100;
    L5:
        return this.f462623d;
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    private void d(String r100) {
        this.f462623d = r100;
        this.f462624e.c(this.f462623d);
    }

    @Override // com.vivo.push.k
    public final void a(String r100) {
        d(r100);
        this.f462624e.d();
        this.f462624e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String r100) {
        d(r100);
        m.a().e();
        this.f462624e.h();
        this.f462624e.d();
        this.f462624e.b();
    }

    @Override // com.vivo.push.k
    public final void c(String r100) {
        d(r100);
    }

    public z(com.vivo.push.c.a r100, com.vivo.push.restructure.b.a r101) {
        this.f462620a = new y();
        this.f462621b = new y();
        this.f462622c = r100;
        this.f462624e = r101;
    }

    public static /* synthetic */ String a(z r100, String r101) {
        r100.f462623d = r101;
        return r101;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener r100, String r101, String r102) {
        if (this.f462622c.c() == true) goto L7;
        if (r100 == null) goto L7;
        r100.onStateChanged(8012);
        return;
    L7:
        m.a().b(r100, r101, r102);
    }

    @Override // com.vivo.push.k
    public final void a(String r100, String r101, String r102) {
        d(r100);
        this.f462624e.a(r101);
        this.f462624e.b(r102);
    }
}
