package com.vivo.push.restructure.request.a;

import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<c> f462494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f462496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f462497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f462498e;

    static {
        f462494a = new d();
    }

    public c(com.vivo.push.restructure.request.a.a.a r100) {
        this.f462495b = r100.c();     // Catch: JSONException -> L5
        this.f462496c = r100.a();     // Catch: JSONException -> L5
        this.f462497d = r100.b();     // Catch: JSONException -> L5
        this.f462498e = r100.a();     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a r100) {
        r100.a(this.f462495b);
        r100.a(this.f462496c);
        r100.a(this.f462497d);
        r100.a(this.f462498e);
    }

    public c(int r100, int r101) {
        this.f462495b = com.vivo.push.restructure.a.a().b().getPackageName();
        this.f462496c = r100;
        this.f462497d = 356;
        this.f462498e = r101;
    }
}
