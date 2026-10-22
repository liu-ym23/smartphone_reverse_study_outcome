package com.cmic.sso.sdk.c.b;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f273421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f273422b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f273423a;

        public a() {
        }

        public JSONObject a() {
            return this.f273423a;
        }

        public void a(JSONObject r100) {
            this.f273423a = r100;
        }
    }

    public static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f273424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f273425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f273426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f273427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f273428e;

        @Override // com.cmic.sso.sdk.c.b.g
        public JSONObject b() {
            return null;
        }

        public b() {
        }

        @Override // com.cmic.sso.sdk.c.b.g
        public String a() {
            return this.f273427d;
        }

        public String c() {
            return this.f273428e;
        }

        public String d() {
            return this.f273424a;
        }

        public String e() {
            return this.f273425b;
        }

        public String f() {
            return this.f273426c;
        }

        public static /* synthetic */ String a(b r100) {
            return r100.f273427d;
        }

        @Override // com.cmic.sso.sdk.c.b.g
        public String a_(String r100) {
            return this.f273428e + this.f273427d + this.f273426c + this.f273425b + "@Fdiwmxy7CBDDQNUI";
        }

        public void b(String r100) {
            this.f273428e = r100;
        }

        public void c(String r100) {
            this.f273427d = r100;
        }

        public void d(String r100) {
            this.f273424a = r100;
        }

        public void e(String r100) {
            this.f273425b = r100;
        }

        public void f(String r100) {
            this.f273426c = r100;
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String r100) {
        return null;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return b.a(this.f273421a);
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r101.put("sign", this.f273421a.d());     // Catch: JSONException -> L5
        r101.put("msgid", this.f273421a.e());     // Catch: JSONException -> L5
        r101.put("systemtime", this.f273421a.f());     // Catch: JSONException -> L5
        r101.put("appid", this.f273421a.a());     // Catch: JSONException -> L5
        r101.put("version", this.f273421a.c());     // Catch: JSONException -> L5
        r100.put("header", r101);     // Catch: JSONException -> L5
        r102.put("log", this.f273422b.a());     // Catch: JSONException -> L5
        r100.put(ContainerPosition.BODY, r102);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public f() {
    }

    public void a(a r100) {
        this.f273422b = r100;
    }

    public void a(b r100) {
        this.f273421a = r100;
    }
}
