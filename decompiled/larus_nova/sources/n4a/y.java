package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;

/* JADX INFO: loaded from: classes32.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f517955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f517956b;

    public static int a(Context r100, String r101, int r102) {
        return r100.getSharedPreferences("open_common", 0).getInt(r101, r102);
    L5:
        th = move-exception;
        r.f(th, "csp", "giv");
        return r102;
    }

    public static SharedPreferences.Editor b(Context r100, String r101) {
        if (r100 == null) goto L14;
    L8:
        th = move-exception;
        n.a(th, CloudControlInf.SP, "ge");
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        return r100.getSharedPreferences(r101, 0).edit();
    L15:
        return null;
    L14:
        return null;
    }

    public static void e(SharedPreferences.Editor r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.apply();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        n.a(th, CloudControlInf.SP, "cm");
    }

    public static void f(SharedPreferences.Editor r100, String r101, int r102) {
        r100.putInt(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.f(th, "csp", "putPrefsInt");
    }

    public static void g(SharedPreferences.Editor r100, String r101, String r102) {
        if (r100 == null) goto L15;
    L10:
        th = move-exception;
        n.a(th, CloudControlInf.SP, "ps");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        r100.putString(r101, r102);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    public static void h(SharedPreferences.Editor r100, String r101, boolean r102) {
        r100.putBoolean(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.f(th, "csp", "setPrefsStr");
    }

    public static boolean i(Context r100, String r101, boolean r102) {
        return r100.getSharedPreferences("open_common", 0).getBoolean(r101, r102);
    L5:
        th = move-exception;
        r.f(th, "csp", "gbv");
        return r102;
    }

    public static byte[] j(Context r100) {
        if (r100 == null) goto L4;
        byte[] r101 = f517955a;
        if (r101 != null) goto L8;
    L10:
        byte[] r102 = v4.g(r100).getBytes();
        f517955a = r102;
        return r102;
    L8:
        if (r101.length <= 0) goto L10;
        return r101;
    L4:
        return new byte[0];
    }

    public static String k(Context r100, String r101, String r102) {
        if (r100 != null) goto L12;
        return null;
    L12:
        return r100.getSharedPreferences(r101, 0).getString(r102, "");
    L9:
        th = move-exception;
        r.f(th, "csp", "gsv");
        return "";
    }

    public static String c(Context r100, String r101, String r102) {
        if (r100 != null) goto L27;
        return "";
    L27:
        String r103 = r100.getSharedPreferences(r101, 0).getString(r102, "");     // Catch: Throwable -> L24
        String[] r104 = f5.f517286a;     // Catch: Throwable -> L24
        if ((r103.length() % 2) == 0) goto L9;
        r103 = "0".concat(r103);     // Catch: Throwable -> L24
    L9:
        int r105 = r103.length() / 2;     // Catch: Throwable -> L24
        byte[] r106 = new byte[r105];     // Catch: Throwable -> L24
        int r107 = 0;
    L10:
        if (r107 >= r105) goto L25;
        int r108 = r107 * 2;     // Catch: Throwable -> L24
        r106[r107] = (byte) CastIntegerProtector.parseInt(r103.substring(r108, r108 + 2), 16);     // Catch: Throwable -> L24
        r107 = r107 + 1;
        goto L10
    L25:
        byte[] r109 = j(r100);     // Catch: Exception -> L21 Throwable -> L24
        byte[] r110 = f517956b;     // Catch: Exception -> L21 Throwable -> L24
        if (r110 != null) goto L16;
    L18:
        r110 = Arrays.copyOfRange(j(r100), 0, j(r100).length / 2);     // Catch: Exception -> L21 Throwable -> L24
        f517956b = r110;     // Catch: Exception -> L21 Throwable -> L24
    L19:
        byte[] r111 = y4.c(r109, r106, r110);     // Catch: Exception -> L21 Throwable -> L24
    L22:
        return f5.d(r111);
        goto L29
    L16:
        if (r110.length <= 0) goto L18;
    L21:
        r111 = new byte[0];     // Catch: Throwable -> L24
    L29:
        return "";
    }

    public static void d(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L22;
        return;
    L22:
        SharedPreferences.Editor r104 = r100.getSharedPreferences(r101, 0).edit();     // Catch: Throwable -> L21
        byte[] r105 = f5.j(r103);     // Catch: Throwable -> L21
        byte[] r106 = j(r100);     // Catch: Throwable -> L18
        byte[] r107 = f517956b;     // Catch: Throwable -> L18
        if (r107 != null) goto L13;
    L15:
        r107 = Arrays.copyOfRange(j(r100), 0, j(r100).length / 2);     // Catch: Throwable -> L18
        f517956b = r107;     // Catch: Throwable -> L18
    L16:
        byte[] r108 = y4.f(r106, r105, r107);     // Catch: Throwable -> L18
    L19:
        r104.putString(r102, f5.s(r108));     // Catch: Throwable -> L21
        e(r104);     // Catch: Throwable -> L21
        return;
        goto L29
    L13:
        if (r107.length <= 0) goto L15;
    L18:
        r108 = new byte[0];     // Catch: Throwable -> L21
    }
}
