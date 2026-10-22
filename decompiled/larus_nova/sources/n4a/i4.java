package n4a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes32.dex */
public final class i4 {
    public static int a(Context r100, String r101, int r102) {
        return r100.getSharedPreferences("pref", 0).getInt(r101, r102);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsInt");
        return r102;
    }

    public static long b(Context r100, String r101, String r102, long r103) {
        return r100.getSharedPreferences(r101, 0).getLong(r102, r103);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsLong");
        return r103;
    }

    public static SharedPreferences.Editor c(Context r100, String r101) {
        return r100.getSharedPreferences(r101, 0).edit();
    }

    public static String d(Context r100, String r101, String r102, String r103) {
        return r100.getSharedPreferences(r101, 0).getString(r102, r103);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsInt");
        return r103;
    }

    public static void e(SharedPreferences.Editor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.apply();
    }

    public static void f(SharedPreferences.Editor r100, String r101, int r102) {
        r100.putInt(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsInt");
    }

    public static void g(SharedPreferences.Editor r100, String r101, long r102) {
        r100.putLong(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsLong");
    }

    public static void h(SharedPreferences.Editor r100, String r101, String r102) {
        r100.putString(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsStr");
    }

    public static void i(SharedPreferences.Editor r100, String r101, boolean r102) {
        r100.putBoolean(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SpUtil", "updatePrefsBoolean");
    }

    public static boolean j(Context r100, String r101, boolean r102) {
        return r100.getSharedPreferences("pref", 0).getBoolean(r101, r102);
    L5:
        th = move-exception;
        c4.g(th, "SpUtil", "getPrefsBoolean");
        return r102;
    }
}
