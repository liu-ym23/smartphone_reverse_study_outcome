package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class b1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277310f;

    public b1() {
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("type", this.f277305a);
        r100.put("eventtime", this.f277308d);
        r100.put("event", this.f277306b);
        r100.put("event_session_name", this.f277309e);
        r100.put("first_session_event", this.f277310f);
        if (TextUtils.isEmpty(this.f277307c) == false) goto L6;
        return null;
    L6:
        r100.put("properties", new JSONObject(this.f277307c));
        return r100;
    }

    public void a(String r100) {
        this.f277307c = r100;
    }

    public void a(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f277306b = r100.optString("event");
        this.f277307c = n.a(r100.optString("properties"), o0.d().a());
        this.f277305a = r100.optString("type");
        this.f277308d = r100.optString("eventtime");
        this.f277309e = r100.optString("event_session_name");
        this.f277310f = r100.optString("first_session_event");
    }

    public String b() {
        return this.f277308d;
    }

    public void b(String r100) {
        this.f277306b = r100;
    }

    public String c() {
        return this.f277305a;
    }

    public void c(String r100) {
        this.f277308d = r100;
    }

    public JSONObject d() {
        JSONObject r100 = a();
        String r101 = o0.d().a();
        r100.put("properties", n.b(this.f277307c, r101));
        return r100;
    }

    public void d(String r100) {
        this.f277305a = r100;
    }

    public void e(String r100) {
        this.f277310f = r100;
    }

    public void f(String r100) {
        this.f277309e = r100;
    }
}
