package com.unionpay.utils;

import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static h f462196e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f462197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f462198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f462199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f462200d;

    public h() {
        this.f462197a = "";
        this.f462198b = "";
        this.f462199c = "";
        this.f462200d = "";
    }

    public static h a() {
        if (f462196e != null) goto L10;
        if (Locale.getDefault().toString().startsWith("zh") == false) goto L7;
        h r100 = new i();
    L8:
        f462196e = r100;
        goto L10
    L7:
        r100 = new j();
    L10:
        return f462196e;
    }
}
