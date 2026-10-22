package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes23.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278190a = "aegis";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f278191b;

    public g() {
    }

    public static void a(Context r100) {
        b(r100).edit().clear().apply();
    }

    public static synchronized SharedPreferences b(Context r100) {
        monitor-enter(g.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f278191b == null) goto L7;
    L10:
        SharedPreferences r101 = f278191b;     // Catch: Throwable -> L13
        monitor-exit(g.class);
        return r101;
    L7:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        f278191b = r100.createDeviceProtectedStorageContext().getSharedPreferences(f278190a, 0);     // Catch: Throwable -> L13
        goto L10
    L9:
        f278191b = r100.getApplicationContext().getSharedPreferences(f278190a, 0);     // Catch: Throwable -> L13
        goto L10
    }

    public static void a(String r100, Context r101) {
        b(r101).edit().remove(r100).apply();
    }

    public static int a(String r100, int r101, Context r102) {
        return b(r102).getInt(r100, r101);
    }

    public static void b(String r100, int r101, Context r102) {
        b(r102).edit().putInt(r100, r101).apply();
    }

    public static long a(String r100, long r101, Context r102) {
        return b(r102).getLong(r100, r101);
    }

    public static void b(String r100, long r101, Context r102) {
        b(r102).edit().putLong(r100, r101).apply();
    }

    public static String a(String r100, String r101, Context r102) {
        return b(r102).getString(r100, r101);
    }

    public static void b(String r100, String r101, Context r102) {
        b(r102).edit().putString(r100, r101).apply();
    }
}
