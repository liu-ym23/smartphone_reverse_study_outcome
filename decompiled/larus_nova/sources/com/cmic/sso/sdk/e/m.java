package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.huawei.hms.android.SystemUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f273510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f273511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f273512c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f273513d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f273514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f273515f;

    static {
        f273510a = Build.BRAND;
        f273511b = Build.MODEL;
        f273512c = "android" + Build.VERSION.RELEASE;
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r100 = true;
    L6:
        f273513d = r100;
        f273514e = true;
        f273515f = 0;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static boolean e() {
        String r100 = f273510a;
        c.a("brand", r100);
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(r100);
    }

    public static boolean f() {
        String r100 = f273510a;
        c.a("brand", r100);
        return SystemUtils.PRODUCT_HONOR.equalsIgnoreCase(r100);
    }

    public static String a() {
        return f273510a;
    }

    public static String b() {
        return f273511b;
    }

    public static String c() {
        return f273512c;
    }

    public static boolean d() {
        return f273513d;
    }

    public static boolean a(Context r100) {
        if ((SystemClock.elapsedRealtime() - f273515f) <= 3000) goto L13;
        f273515f = SystemClock.elapsedRealtime();
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        if (r101 == null) goto L13;
        boolean r102 = true;
        if (1 != r101.getSimState()) goto L10;
        r102 = false;
    L10:
        f273514e = r102;
        return r102;
    L13:
        return f273514e;
    }

    private static boolean a(ConnectivityManager r100, Context r101, com.cmic.sso.sdk.a r102) {
        boolean r103 = false;
    L19:
        c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
    L20:
        c.b("TelephonyUtils", "data is on ---------" + r103);
        return r103;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        TelephonyManager r104 = (TelephonyManager) r101.getSystemService("phone");     // Catch: Exception -> L19
        if (r104 != null) goto L9;
    L22:
        goto L20
    L9:
        if (g.a(r101, "android.permission.ACCESS_NETWORK_STATE") == false) goto L22;
        if (r104.isDataEnabled() == false) goto L13;
    L16:
        r102.a("networkTypeByAPI", "1");     // Catch: Exception -> L19
        r103 = true;
        goto L22
    L13:
        if (r104.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).isDataEnabled() == true) goto L16;
        r102.a("networkTypeByAPI", "0");     // Catch: Exception -> L19
        goto L22
    L17:
        Method r105 = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L19
        r105.setAccessible(true);     // Catch: Exception -> L19
        r103 = ((Boolean) r105.invoke(r100, new Object[0])).booleanValue();     // Catch: Exception -> L19
        c.b("TelephonyUtils", "data is on ---------getMobileDataEnabled");     // Catch: Exception -> L19
        r102.a("networkTypeByAPI", "-1");     // Catch: Exception -> L19
        goto L22
    }

    public static int a(Context r100, boolean r101, com.cmic.sso.sdk.a r102) {
        ConnectivityManager r103 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L27
        if (r103 == null) goto L6;
        NetworkInfo r104 = r103.getActiveNetworkInfo();     // Catch: Exception -> L27
    L7:
        if (r104 != null) goto L9;
    L26:
        return 0;
    L9:
        if (r104.isAvailable() == false) goto L26;
        int r105 = r104.getType();     // Catch: Exception -> L27
        if (r105 != 1) goto L23;
        c.b("TelephonyUtils", "WIFI");     // Catch: Exception -> L27
        boolean r106 = g.a(r100, "android.permission.CHANGE_NETWORK_STATE");     // Catch: Exception -> L27
        c.a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + r106);     // Catch: Exception -> L27
        if (r106 == false) goto L21;
        if (r101 == true) goto L18;
        return 2;
    L18:
        if (a(r103, r100, r102) == false) goto L32;
        c.b("TelephonyUtils", "流量数据 WIFI 同开");     // Catch: Exception -> L27
        return 3;
    L32:
        return 2;
    L21:
        return 2;
    L23:
        if (r105 != 0) goto L29;
        c.b("TelephonyUtils", "流量");     // Catch: Exception -> L27
        return 1;
    L29:
        return 0;
    L6:
        r104 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }
}
