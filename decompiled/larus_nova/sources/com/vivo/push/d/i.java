package com.vivo.push.d;

import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<i> f462296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462297b;

    static {
        f462296a = new j();
    }

    public final int a() {
        return this.f462297b;
    }

    public i(com.vivo.push.restructure.request.a.a.a r100) throws JSONException {
        this.f462297b = r100.a();
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a r100) {
        r100.a(this.f462297b);
    }
}
