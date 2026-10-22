package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public abstract class e0 {
    public e0() {
    }

    private i a(int r100) {
        if (r100 == 0) goto L7;
        String r101 = f();
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return new i(d0.f277312b, r101);
    L9:
        return new i(d0.f277314d, r101);
    L7:
        r101 = "";
        goto L9
    }

    private i b(int r100) {
        if ((r100 & 4) == 0) goto L8;
        String r101 = f();
        if (TextUtils.isEmpty(r101) == true) goto L10;
        return new i(d0.f277312b, r101);
    L10:
        return new i(d0.f277314d, r101);
    L8:
        r101 = "";
        goto L10
    }

    private boolean e() {
        g1 r100 = s.c().b();
        if (TextUtils.isEmpty(r100.l()) == false) goto L6;
        r100.h(o.a());
    L6:
        return !TextUtils.isEmpty(r100.l());
    }

    private String f() {
        g1 r100 = s.c().b();
        if (TextUtils.isEmpty(r100.i()) == false) goto L6;
        r100.e(x0.c());
    L6:
        return r100.i();
    }

    public i a(Context r100) {
        String r101 = c();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        String r102 = a();
        if (TextUtils.isEmpty(r102) == false) goto L9;
        boolean r103 = e();
        String r104 = b();
        if (TextUtils.isEmpty(r104) == true) goto L17;
        if (r103 == false) goto L16;
        return new i(d0.f277313c, r104);
    L16:
        return new i(d0.f277312b, a(r104));
    L17:
        if (r103 == false) goto L21;
        return a(d());
    L21:
        return b(d());
    L9:
        return new i(d0.f277311a, r102);
    L5:
        return new i(d0.f277312b, r101);
    }

    public abstract String a();

    public abstract String a(String r100);

    public abstract String b();

    public abstract String c();

    public abstract int d();
}
