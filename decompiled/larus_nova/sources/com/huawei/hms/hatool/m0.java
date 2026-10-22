package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f277404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277405b;

    public m0() {
        this.f277404a = false;
        this.f277405b = 4;
    }

    private static String a() {
        return "FormalHASDK_2.2.0.315" + p.a();
    }

    public void a(int r100) {
        System.lineSeparator();
        System.lineSeparator();
        a();
        System.lineSeparator();
        this.f277405b = r100;
        this.f277404a = true;
    }

    public void a(int r100, String r101, String r102) {
    }

    public void b(int r100, String r101, String r102) {
        a(r100, "FormalHASDK", r101 + "=> " + r102);
    }

    public boolean b(int r100) {
        if (this.f277404a == true) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.f277405b) goto L7;
        return true;
    }
}
