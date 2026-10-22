package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.c.b.g;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class a extends g {
    private String A;
    private String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<Throwable> f273461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f273466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f273467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f273468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f273469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f273470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f273471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f273472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f273473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f273474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private JSONArray f273475o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f273476p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f273477q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f273478r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f273479s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f273480t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f273481u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f273482v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f273483w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f273484x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f273485y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f273486z;

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return null;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String r100) {
        return null;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("appid", this.f273462b);     // Catch: JSONException -> L7
        r100.put("traceId", this.f273463c);     // Catch: JSONException -> L7
        r100.put("appName", this.f273464d);     // Catch: JSONException -> L7
        r100.put("appVersion", this.f273465e);     // Catch: JSONException -> L7
        r100.put(com.heytap.mcssdk.constant.b.C, AuthnHelper.SDK_VERSION);     // Catch: JSONException -> L7
        r100.put("clientType", "android");     // Catch: JSONException -> L7
        r100.put("timeOut", this.f273466f);     // Catch: JSONException -> L7
        r100.put("requestTime", this.f273467g);     // Catch: JSONException -> L7
        r100.put("responseTime", this.f273468h);     // Catch: JSONException -> L7
        r100.put("elapsedTime", this.f273469i);     // Catch: JSONException -> L7
        r100.put("requestType", this.f273470j);     // Catch: JSONException -> L7
        r100.put("interfaceType", this.f273471k);     // Catch: JSONException -> L7
        r100.put("interfaceCode", this.f273472l);     // Catch: JSONException -> L7
        r100.put("interfaceElasped", this.f273473m);     // Catch: JSONException -> L7
        r100.put("loginType", this.f273474n);     // Catch: JSONException -> L7
        r100.put("exceptionStackTrace", this.f273475o);     // Catch: JSONException -> L7
        r100.put("operatorType", this.f273476p);     // Catch: JSONException -> L7
        r100.put("networkOperator", this.f273477q);     // Catch: JSONException -> L7
        r100.put("networkType", this.f273478r);     // Catch: JSONException -> L7
        r100.put("brand", this.f273479s);     // Catch: JSONException -> L7
        r100.put("reqDevice", this.f273480t);     // Catch: JSONException -> L7
        r100.put("reqSystem", this.f273481u);     // Catch: JSONException -> L7
        r100.put("simCardNum", this.f273482v);     // Catch: JSONException -> L7
        r100.put("imsiState", this.f273483w);     // Catch: JSONException -> L7
        r100.put("resultCode", this.f273484x);     // Catch: JSONException -> L7
        r100.put("AID", this.f273485y);     // Catch: JSONException -> L7
        r100.put("sysOperType", this.f273486z);     // Catch: JSONException -> L7
        r100.put("scripType", this.A);     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(this.B) == true) goto L9;
        r100.put("networkTypeByAPI", this.B);     // Catch: JSONException -> L7
    L9:
        return r100;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public a() {
        this.f273462b = null;
        this.f273463c = null;
        this.f273464d = null;
        this.f273465e = null;
        this.f273466f = null;
        this.f273467g = null;
        this.f273468h = null;
        this.f273469i = null;
        this.f273470j = null;
        this.f273471k = "";
        this.f273472l = null;
        this.f273473m = null;
        this.f273474n = null;
        this.f273476p = null;
        this.f273477q = null;
        this.f273478r = null;
        this.f273479s = null;
        this.f273480t = null;
        this.f273481u = null;
        this.f273482v = null;
        this.f273483w = null;
        this.f273484x = null;
        this.f273461a = new CopyOnWriteArrayList();
    }

    public void A(String r100) {
        this.B = r100;
    }

    public void a(JSONArray r100) {
        this.f273475o = r100;
    }

    public void b(String r100) {
        this.f273462b = r100;
    }

    public void c(String r100) {
        this.f273483w = r100;
    }

    public void d(String r100) {
        this.f273484x = r100;
    }

    public void e(String r100) {
        this.f273479s = r100;
    }

    public void f(String r100) {
        this.f273473m = r100;
    }

    public void g(String r100) {
        this.f273472l = r100;
    }

    public void h(String r100) {
        this.f273471k = r100;
    }

    public void i(String r100) {
        this.f273464d = r100;
    }

    public void j(String r100) {
        this.f273465e = r100;
    }

    public void k(String r100) {
        this.f273466f = r100;
    }

    public void l(String r100) {
        this.f273469i = r100;
    }

    public void m(String r100) {
        this.f273482v = r100;
    }

    public void n(String r100) {
        this.f273476p = r100;
    }

    public void o(String r100) {
        this.f273480t = r100;
    }

    public void p(String r100) {
        this.f273481u = r100;
    }

    public void q(String r100) {
        this.f273474n = r100;
    }

    public void r(String r100) {
        this.f273463c = r100;
    }

    public void s(String r100) {
        this.f273467g = r100;
    }

    public void t(String r100) {
        this.f273468h = r100;
    }

    public void u(String r100) {
        this.f273470j = r100;
    }

    public void v(String r100) {
        this.f273478r = r100;
    }

    public void x(String r100) {
        this.f273485y = r100;
    }

    public void y(String r100) {
        this.f273486z = r100;
    }

    public void z(String r100) {
        this.A = r100;
    }
}
