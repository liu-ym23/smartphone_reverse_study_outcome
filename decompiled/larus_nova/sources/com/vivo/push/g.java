package com.vivo.push;

import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.vivo.push.restructure.request.a.a.c.a<g> f462326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f462328c;

    static {
        f462326a = new h();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a r100 = new com.vivo.push.restructure.request.a.a.a();
        r100.a(this.f462327b);
        r100.a(this.f462328c);
        return r100.e();
    }

    public final String b() {
        return this.f462328c;
    }

    public g(com.vivo.push.restructure.request.a.a.a r100) throws JSONException {
        this.f462327b = r100.a();
        this.f462328c = r100.c();
    }
}
