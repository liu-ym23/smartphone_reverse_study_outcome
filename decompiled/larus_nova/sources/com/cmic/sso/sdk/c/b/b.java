package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f273406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f273407g;

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("version", this.f273401a);     // Catch: JSONException -> L5
        r100.put("apptype", this.f273402b);     // Catch: JSONException -> L5
        r100.put("phone_ID", this.f273403c);     // Catch: JSONException -> L5
        r100.put("certflag", this.f273404d);     // Catch: JSONException -> L5
        r100.put("sdkversion", this.f273405e);     // Catch: JSONException -> L5
        r100.put("appid", this.f273406f);     // Catch: JSONException -> L5
        r100.put("expandparams", "");     // Catch: JSONException -> L5
        r100.put("sign", this.f273407g);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public b() {
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f273406f;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String r100) {
        return this.f273401a + this.f273405e + this.f273406f + "iYm0HAnkxQtpvN44";
    }

    public void b(String r100) {
        this.f273401a = r100;
    }

    public void c(String r100) {
        this.f273402b = r100;
    }

    public void d(String r100) {
        this.f273403c = r100;
    }

    public void e(String r100) {
        this.f273404d = r100;
    }

    public void f(String r100) {
        this.f273405e = r100;
    }

    public void g(String r100) {
        this.f273406f = r100;
    }

    public void h(String r100) {
        this.f273407g = r100;
    }
}
