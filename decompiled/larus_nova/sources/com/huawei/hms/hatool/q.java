package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static q f277427b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    z0 f277428a;

    static {
        f277427b = new q();
    }

    public q() {
        this.f277428a = null;
    }

    public static q c() {
        return f277427b;
    }

    public void a(z0 r100) {
        this.f277428a = r100;
    }

    public boolean a() {
        if (this.f277428a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public z0 b() {
        return this.f277428a;
    }
}
