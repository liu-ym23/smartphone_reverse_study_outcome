package com.cmic.sso.sdk.c.b;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f273409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f273410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f273411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f273414f;

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String r100) {
        return null;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("ver", this.f273410b);     // Catch: JSONException -> L5
        r100.put(OnekeyLoginConstants.OPERATOR_TYPE, this.f273414f);     // Catch: JSONException -> L5
        r100.put("data", this.f273411c);     // Catch: JSONException -> L5
        r100.put("userCapaid", this.f273413e);     // Catch: JSONException -> L5
        r100.put("funcType", this.f273412d);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f273409a;
    }

    public void b(String r100) {
        this.f273414f = r100;
    }

    public void c(String r100) {
        this.f273412d = r100;
    }

    public void d(String r100) {
        this.f273413e = r100;
    }

    public d(String r100, String r101, String r102) {
        this.f273412d = "authz";
        this.f273409a = r100;
        this.f273410b = r101;
        this.f273411c = r102;
    }
}
