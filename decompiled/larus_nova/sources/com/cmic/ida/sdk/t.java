package com.cmic.ida.sdk;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class t extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f273215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f273216b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f273217a;

        public a() {
        }

        public JSONObject a() {
            return this.f273217a;
        }

        public void a(JSONObject r100) {
            this.f273217a = r100;
        }
    }

    public static class b extends i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f273218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f273219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f273220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f273221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f273222e;

        @Override // com.cmic.ida.sdk.i0
        public JSONObject b() {
            return null;
        }

        public b() {
        }

        @Override // com.cmic.ida.sdk.i0
        public String a() {
            return this.f273221d;
        }

        public String c() {
            return this.f273219b;
        }

        public String d() {
            return this.f273218a;
        }

        public String e() {
            return this.f273220c;
        }

        public String f() {
            return this.f273222e;
        }

        @Override // com.cmic.ida.sdk.i0
        public String a(String r100) {
            return this.f273222e + this.f273221d + this.f273220c + this.f273219b + "@Fdiwmxy7CBDDQNUI";
        }

        public void c(String r100) {
            this.f273221d = r100;
        }

        public void d(String r100) {
            this.f273219b = r100;
        }

        public void e(String r100) {
            this.f273218a = r100;
        }

        public void f(String r100) {
            this.f273220c = r100;
        }

        public void g(String r100) {
            this.f273222e = r100;
        }

        public static /* synthetic */ String a(b r100) {
            return r100.f273221d;
        }
    }

    @Override // com.cmic.ida.sdk.i0
    public String a(String r100) {
        return null;
    }

    @Override // com.cmic.ida.sdk.i0
    public String a() {
        return b.a(this.f273215a);
    }

    @Override // com.cmic.ida.sdk.i0
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r101.put("sign", this.f273215a.d());     // Catch: JSONException -> L5
        r101.put("msgid", this.f273215a.c());     // Catch: JSONException -> L5
        r101.put("systemtime", this.f273215a.e());     // Catch: JSONException -> L5
        r101.put("appid", this.f273215a.a());     // Catch: JSONException -> L5
        r101.put("version", this.f273215a.f());     // Catch: JSONException -> L5
        r100.put("header", r101);     // Catch: JSONException -> L5
        r102.put("log", this.f273216b.a());     // Catch: JSONException -> L5
        r100.put(ContainerPosition.BODY, r102);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public t() {
    }

    public void a(a r100) {
        this.f273216b = r100;
    }

    public void a(b r100) {
        this.f273215a = r100;
    }
}
