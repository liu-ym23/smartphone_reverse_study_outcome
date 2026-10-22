package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f277323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<b1> f277328f;

    public f(byte[] r100, String r101, String r102, String r103, String r104, List<b1> r105) {
        this.f277323a = (byte[]) r100.clone();
        this.f277324b = r101;
        this.f277325c = r102;
        this.f277327e = r103;
        this.f277326d = r104;
        this.f277328f = r105;
    }

    private n0 a(Map<String, String> r100) {
        return w.a(this.f277324b, this.f277323a, r100);
    }

    private Map<String, String> a() {
        return k.b(this.f277325c, this.f277327e, this.f277326d);
    }

    private void b() {
        d1 r100 = new d1(this.f277328f, this.f277325c, this.f277326d, this.f277327e);
        b0.c().a(r100);
    }

    @Override // java.lang.Runnable
    public void run() {
        v.a("hmsSdk", "send data running");
        int r100 = a(a()).b();
        if (r100 == 200) goto L5;
        b();
        return;
    L5:
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f277326d, new Object[]{this.f277327e, this.f277325c, Integer.valueOf(r100)});
    }
}
