package com.cmic.ida.sdk;

import android.text.TextUtils;
import com.cmic.ida.sdk.auth.IdaAuthnHelper;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class s extends i0 {
    public CopyOnWriteArrayList<Throwable> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f273192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f273193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f273194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f273195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f273196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f273197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f273198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f273199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private JSONArray f273200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f273201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f273202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f273203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f273204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f273205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f273206t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f273207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f273208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f273209w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f273210x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f273211y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f273212z;

    @Override // com.cmic.ida.sdk.i0
    public String a() {
        return null;
    }

    @Override // com.cmic.ida.sdk.i0
    public String a(String r100) {
        return null;
    }

    @Override // com.cmic.ida.sdk.i0
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("appid", this.f273187a);     // Catch: JSONException -> L7
        r100.put("traceId", this.f273188b);     // Catch: JSONException -> L7
        r100.put("appName", this.f273189c);     // Catch: JSONException -> L7
        r100.put("appVersion", this.f273190d);     // Catch: JSONException -> L7
        r100.put(com.heytap.mcssdk.constant.b.C, IdaAuthnHelper.SDK_VERSION);     // Catch: JSONException -> L7
        r100.put("clientType", "android");     // Catch: JSONException -> L7
        r100.put("timeOut", this.f273191e);     // Catch: JSONException -> L7
        r100.put("requestTime", this.f273192f);     // Catch: JSONException -> L7
        r100.put("responseTime", this.f273193g);     // Catch: JSONException -> L7
        r100.put("elapsedTime", this.f273194h);     // Catch: JSONException -> L7
        r100.put("requestType", this.f273195i);     // Catch: JSONException -> L7
        r100.put("interfaceType", this.f273196j);     // Catch: JSONException -> L7
        r100.put("interfaceCode", this.f273197k);     // Catch: JSONException -> L7
        r100.put("interfaceElasped", this.f273198l);     // Catch: JSONException -> L7
        r100.put("loginType", this.f273199m);     // Catch: JSONException -> L7
        r100.put("exceptionStackTrace", this.f273200n);     // Catch: JSONException -> L7
        r100.put("operatorType", this.f273201o);     // Catch: JSONException -> L7
        r100.put("networkType", this.f273202p);     // Catch: JSONException -> L7
        r100.put("brand", this.f273203q);     // Catch: JSONException -> L7
        r100.put("reqDevice", this.f273204r);     // Catch: JSONException -> L7
        r100.put("reqSystem", this.f273205s);     // Catch: JSONException -> L7
        r100.put("simCardNum", this.f273206t);     // Catch: JSONException -> L7
        r100.put("imsiState", this.f273207u);     // Catch: JSONException -> L7
        r100.put("resultCode", this.f273208v);     // Catch: JSONException -> L7
        r100.put("AID", this.f273209w);     // Catch: JSONException -> L7
        r100.put("sysOperType", this.f273210x);     // Catch: JSONException -> L7
        r100.put("scripType", this.f273211y);     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(this.f273212z) == true) goto L9;
        r100.put("networkTypeByAPI", this.f273212z);     // Catch: JSONException -> L7
    L9:
        return r100;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public s() {
        this.f273187a = null;
        this.f273188b = null;
        this.f273189c = null;
        this.f273190d = null;
        this.f273191e = null;
        this.f273192f = null;
        this.f273193g = null;
        this.f273194h = null;
        this.f273195i = null;
        this.f273196j = "";
        this.f273197k = null;
        this.f273198l = null;
        this.f273199m = null;
        this.f273201o = null;
        this.f273202p = null;
        this.f273203q = null;
        this.f273204r = null;
        this.f273205s = null;
        this.f273206t = null;
        this.f273207u = null;
        this.f273208v = null;
        this.A = new CopyOnWriteArrayList();
    }

    public void A(String r100) {
        this.f273188b = r100;
    }

    public void a(JSONArray r100) {
        this.f273200n = r100;
    }

    public void c(String r100) {
        this.f273209w = r100;
    }

    public void d(String r100) {
        this.f273189c = r100;
    }

    public void e(String r100) {
        this.f273190d = r100;
    }

    public void f(String r100) {
        this.f273187a = r100;
    }

    public void g(String r100) {
        this.f273203q = r100;
    }

    public void h(String r100) {
        this.f273194h = r100;
    }

    public void i(String r100) {
        this.f273207u = r100;
    }

    public void j(String r100) {
        this.f273197k = r100;
    }

    public void k(String r100) {
        this.f273198l = r100;
    }

    public void l(String r100) {
        this.f273196j = r100;
    }

    public void m(String r100) {
        this.f273199m = r100;
    }

    public void n(String r100) {
        this.f273202p = r100;
    }

    public void o(String r100) {
        this.f273212z = r100;
    }

    public void p(String r100) {
        this.f273201o = r100;
    }

    public void q(String r100) {
        this.f273204r = r100;
    }

    public void r(String r100) {
        this.f273205s = r100;
    }

    public void s(String r100) {
        this.f273192f = r100;
    }

    public void t(String r100) {
        this.f273195i = r100;
    }

    public void u(String r100) {
        this.f273193g = r100;
    }

    public void v(String r100) {
        this.f273208v = r100;
    }

    public void w(String r100) {
        this.f273211y = r100;
    }

    public void x(String r100) {
        this.f273206t = r100;
    }

    public void y(String r100) {
        this.f273210x = r100;
    }

    public void z(String r100) {
        this.f273191e = r100;
    }
}
