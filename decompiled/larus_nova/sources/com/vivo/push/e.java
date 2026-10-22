package com.vivo.push;

import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.vivo.push.restructure.request.a.a.c.a<e> f462298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f462300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f462302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f462303f;

    static {
        f462298a = new f();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a r100 = new com.vivo.push.restructure.request.a.a.a();
        r100.a(this.f462299b);
        r100.a(this.f462300c);
        r100.a(this.f462301d);
        r100.a(this.f462302e);
        r100.a(this.f462303f);
        return r100.e();
    }

    public e(com.vivo.push.restructure.request.a.a.a r100) throws JSONException {
        this.f462299b = r100.a();
        this.f462300c = r100.c();
        this.f462301d = r100.c();
        this.f462302e = r100.c();
        this.f462303f = r100.c();
    }

    public e(int r100, String r101, String r102, String r103, String r104) {
        this.f462299b = r100;
        this.f462300c = r101;
        this.f462301d = r102;
        this.f462302e = r103;
        this.f462303f = r104;
    }
}
