package com.vivo.push.d;

import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class g implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<g> f462291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f462292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f462293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f462294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f462295e;

    static {
        f462291a = new h();
    }

    public g(com.vivo.push.restructure.request.a.a.a r100) {
        this.f462292b = r100.b();     // Catch: JSONException -> L5
        this.f462293c = r100.a();     // Catch: JSONException -> L5
        this.f462294d = r100.a();     // Catch: JSONException -> L5
        this.f462295e = r100.d();     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a r100) {
        r100.a(this.f462292b);
        r100.a(this.f462293c);
        r100.a(this.f462294d);
        r100.a(this.f462295e);
    }

    public g(int r100, boolean r101) {
        this.f462293c = r100;
        this.f462294d = 1;
        this.f462295e = r101;
    }

    public g(long r100, int r101, boolean r102) {
        this.f462292b = r100;
        this.f462293c = r101;
        this.f462294d = 2;
        this.f462295e = r102;
    }
}
