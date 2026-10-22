package com.ss.android.lark.biz.im.api;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f410259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f410261c;

    public final String a() {
        String r100 = this.f410259a;
    L4:
        if (r100.startsWith("doubao://") == false) goto L7;
        r100 = r100.substring(9);
        goto L4
    L7:
        return "doubao://".concat(r100);
    }

    public k(String r100, String r101, int r102) {
        this.f410259a = r100;
        this.f410260b = r101;
        this.f410261c = r102;
    }
}
