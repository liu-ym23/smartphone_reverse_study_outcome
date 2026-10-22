package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f277495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f277496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f277497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f277498d;

    public am() {
    }

    public JSONObject e() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.putOpt("appId", this.f277495a);
        r100.putOpt("packageName", this.f277496b);
        r100.put("hmsSdkVersion", this.f277497c);
        r100.putOpt("subAppId", this.f277498d);
        return r100;
    }

    public String toString() {
        return "HuaweiIdCpClientInfo{appId='" + this.f277495a + "', packageName='" + this.f277496b + "', hmsSdkVersion=" + this.f277497c + "', subAppId=" + this.f277498d + '}';
    }

    public String d() throws JSONException {
        return e().toString();
    }

    public String a() {
        return this.f277495a;
    }

    public long b() {
        return this.f277497c;
    }

    public String c() {
        return this.f277498d;
    }

    public void a(long r100) {
        this.f277497c = r100;
    }

    public void b(String r100) {
        this.f277495a = r100;
    }

    public void c(String r100) {
        this.f277496b = r100;
    }

    public void d(String r100) {
        this.f277498d = r100;
    }
}
