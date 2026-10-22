package com.bytedance.bdinstall;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f199779c;

    public final String toString() {
        return "{r='" + this.f199777a + "', a='" + this.f199778b + "', v='" + this.f199779c + "'}";
    }

    public static r0 a(String r100) {
        return new r0(r100.concat("/service/2/device_register/"), r100.concat("/service/2/app_alert_check/"), r100.concat("/service/1/client_context/"));
    }

    public static void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (r100.startsWith("https") == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("url protocol should be https");
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == false) goto L16;
        r0 r101 = (r0) r100;
        if (TextUtils.equals(this.f199778b, r101.f199778b) == true) goto L10;
    L14:
        return false;
    L10:
        if (TextUtils.equals(this.f199777a, r101.f199777a) == false) goto L14;
        if (TextUtils.equals(this.f199779c, r101.f199779c) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public r0(String r100, String r101) {
        this.f199779c = "";
        b(r100);
        this.f199777a = r100;
        b(r101);
        this.f199778b = r101;
    }

    public r0(String r100, String r101, String r102) {
        this.f199779c = "";
        b(r100);
        this.f199777a = r100;
        b(r101);
        this.f199778b = r101;
        b(r102);
        this.f199779c = r102;
    }
}
