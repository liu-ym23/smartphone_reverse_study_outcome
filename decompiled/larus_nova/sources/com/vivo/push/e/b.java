package com.vivo.push.e;

import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.vivo.push.restructure.request.a.a.c.a<b> f462308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462309b;

    static {
        f462308a = new c();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a r100 = new com.vivo.push.restructure.request.a.a.a();
        r100.a(this.f462309b);
        return r100.e();
    }

    public final String b() {
        return this.f462309b;
    }

    public b(com.vivo.push.restructure.request.a.a.a r100) throws JSONException {
        this.f462309b = r100.c();
    }

    public b(String r100) {
        this.f462309b = r100;
    }
}
