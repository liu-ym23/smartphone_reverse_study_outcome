package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s0 f277397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s0 f277398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s0 f277399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private s0 f277400d;

    public l1(String r100) {
    }

    public s0 a() {
        return this.f277399c;
    }

    public s0 a(String r100) {
        if (r100.equals("oper") == false) goto L7;
        return c();
    L7:
        if (r100.equals("maint") == false) goto L11;
        return b();
    L11:
        if (r100.equals("diffprivacy") == false) goto L15;
        return a();
    L15:
        if (r100.equals("preins") == true) goto L17;
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: ".concat(r100));
        return null;
    L17:
        return d();
    }

    public void a(s0 r100) {
        this.f277397a = r100;
    }

    public s0 b() {
        return this.f277397a;
    }

    public void b(s0 r100) {
        this.f277398b = r100;
    }

    public s0 c() {
        return this.f277398b;
    }

    public s0 d() {
        return this.f277400d;
    }
}
