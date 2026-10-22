package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, u> f271526c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f271527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f271528b;

    static {
        f271526c = new HashMap();
    }

    public static u a() {
        return b(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f(), "luckycat_product_configs.prefs");
    }

    public final void e(String r100) {
        if (TextUtils.isEmpty(this.f271528b) == false) goto L5;
        return;
    L5:
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 == null) goto L9;
        r101.M(this.f271528b, r100);
        return;
    }

    public u(Context r100, String r101) {
        this.f271527a = null;
        this.f271528b = null;
        this.f271527a = r100.getSharedPreferences(r101, 0);
        this.f271528b = r101;
    }

    public static u b(Context r100, String r101) {
        Map<String, u> r102 = f271526c;
        u r103 = (u) ((HashMap) r102).get(r101);
        if (r103 == null) goto L5;
    L14:
        return r103;
    L5:
        monitor-enter(u.class);
        r103 = (u) ((HashMap) r102).get(r101);     // Catch: Throwable -> L11
        if (r103 != null) goto L9;
        r103 = new u(r100, r101);     // Catch: Throwable -> L11
        ((HashMap) r102).put(r101, r103);     // Catch: Throwable -> L11
    L9:
        monitor-exit(u.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final String c(String r100, String r101) {
        e(r100);
        return this.f271527a.getString(r100, r101);
    }

    public final boolean d(String r100, Boolean r101) {
        e(r100);
        return this.f271527a.getBoolean(r100, r101.booleanValue());
    }

    public final void f(String r100, int r101) {
        e(r100);
        SharedPreferences.Editor r102 = this.f271527a.edit();
        r102.putInt(r100, r101);
        r102.apply();
    }

    public final void g(String r100, String r101) {
        e(r100);
        SharedPreferences.Editor r102 = this.f271527a.edit();
        r102.putString(r100, r101);
        r102.apply();
    }

    public final void h(String r100, boolean r101) {
        e(r100);
        SharedPreferences.Editor r102 = this.f271527a.edit();
        r102.putBoolean(r100, r101);
        r102.apply();
    }
}
