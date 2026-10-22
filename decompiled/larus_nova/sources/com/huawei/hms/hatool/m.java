package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m f277401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277402c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277403a;

    static {
        f277402c = new Object();
    }

    private m() {
    }

    public static m a() {
        if (f277401b != null) goto L6;
        b();
    L6:
        return f277401b;
    }

    private static synchronized void b() {
        monitor-enter(m.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f277401b != null) goto L7;
        f277401b = new m();     // Catch: Throwable -> L9
    L7:
        monitor-exit(m.class);
    }

    public void a(Context r100) {
        Object r101 = f277402c;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f277403a == null) goto L9;
        v.f("hmsSdk", "DataManager already initialized.");     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L9:
        this.f277403a = r100;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        s.c().b().a(this.f277403a);
        s.c().b().j(r100.getPackageName());
        j.a().a(r100);
    }

    public void a(String r100) {
        v.a("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context r101 = this.f277403a;
        if (r101 != null) goto L6;
        v.e("hmsSdk", "sdk is not init");
        return;
    L6:
        String r102 = e1.a(com.heytap.mcssdk.constant.b.f276371u, r100, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", r101.getPackageName());
        s.c().b().i(r102);
    }
}
