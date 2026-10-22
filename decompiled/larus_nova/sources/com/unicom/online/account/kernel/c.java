package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f462027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f462028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f462029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f462030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f462031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f462032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f462033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f462034h;

    public c() {
    }

    public final void a(g r100) {
        int r101 = this.f462030d + 1;
        this.f462030d = r101;
        if (r101 != 1) goto L5;
        this.f462031e = r100;
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f462032f = r100;
        return;
    L7:
        if (r101 != 3) goto L9;
        this.f462033g = r100;
        return;
    L9:
        if (r101 != 4) goto L19;
        this.f462034h = r100;
        return;
    }

    public final String toString() {
        return "{ifProtal:" + this.f462027a + ", step1:" + this.f462031e + ", step2:" + this.f462032f + ", step3:" + this.f462033g + ", step4:" + this.f462034h + '}';
    }
}
