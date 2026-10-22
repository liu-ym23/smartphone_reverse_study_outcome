package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f271514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f271515b;

    public static float a() {
        if (f271515b == false) goto L7;
        float r100 = f271514a;
        if (r100 <= 0.0f) goto L7;
        return r100;
    L7:
        zl7.d r101 = (zl7.d) hn7.d.b(zl7.d.class);
        if (r101 == null) goto L10;
        float r102 = r101.getDeviceScore();
    L15:
        if (r102 <= 0.0f) goto L22;
        f271514a = r102;
        if (f271515b == true) goto L22;
        if (r102 < 0.0f) goto L22;
        u r103 = u.a();
        float r104 = f271514a;
        r103.e("device_score");
        SharedPreferences.Editor r105 = r103.f271527a.edit();
        r105.putFloat("device_score", r104);
        r105.apply();
        f271515b = true;
    L22:
        if (f271514a > 0) goto L25;
        u r106 = u.a();
        r106.e("device_score");
        f271514a = r106.f271527a.getFloat("device_score", 0.0f);
    L25:
        return f271514a;
    L10:
        zl7.g r107 = (zl7.g) hn7.d.b(zl7.g.class);
        if (r107 == null) goto L13;
        r102 = r107.getDeviceScore();
        goto L15
    L13:
        r102 = 0.0f;
        goto L15
    }

    static {
    }
}
