package com.cmic.sso.sdk.c.b;

import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f273415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f273416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f273418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f273420f;

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String r100) {
        return null;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f273415a.a();
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        if (this.f273420f == true) goto L9;
    L8:
        return r100;
    L9:
        r100.put("encrypted", this.f273417c);     // Catch: JSONException -> L6
        r100.put("encryptedIV", Base64.encodeToString(this.f273418d, 0));     // Catch: JSONException -> L6
        r100.put("reqdata", com.cmic.sso.sdk.e.a.a(this.f273416b, this.f273415a.b().toString(), this.f273418d));     // Catch: JSONException -> L6
        r100.put("securityreinforce", this.f273419e);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public e() {
        this.f273420f = false;
    }

    public a c() {
        return this.f273415a;
    }

    public void a(a r100) {
        this.f273415a = r100;
    }

    public void b(String r100) {
        this.f273419e = r100;
    }

    public void c(String r100) {
        this.f273417c = r100;
    }

    public void a(boolean r100) {
        this.f273420f = r100;
    }

    public void b(byte[] r100) {
        this.f273418d = r100;
    }

    public void a(byte[] r100) {
        this.f273416b = r100;
    }
}
