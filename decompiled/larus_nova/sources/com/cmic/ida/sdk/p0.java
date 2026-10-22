package com.cmic.ida.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.huawei.hms.android.SystemUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f273174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f273175b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f273176c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f273177d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f273178e = null;

    static {
        f273174a = Build.BRAND;
        f273175b = Build.MODEL;
        f273176c = "android" + Build.VERSION.RELEASE;
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r100 = true;
    L6:
        f273177d = r100;
        f273178e = Build.MANUFACTURER;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static boolean d() {
        String r100 = f273178e;
        u.b("brand", r100);
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(r100);
    }

    public static String a() {
        return f273176c;
    }

    public static String b() {
        return f273174a;
    }

    public static String c() {
        return f273175b;
    }

    public static boolean e() {
        return f273177d;
    }

    public static boolean a(Context r100) {
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        if (r101 != null) goto L5;
        return true;
    L5:
        if (1 != r101.getSimState()) goto L10;
        return false;
    L10:
        return true;
    }

    public static int a(Context r100, boolean r101, g r102) {
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
        u.a("TelephonyUtils", "WIFI");     // Catch: Exception -> L27
        boolean r106 = e0.a(r100, "android.permission.CHANGE_NETWORK_STATE");     // Catch: Exception -> L27
        u.b("TelephonyUtils", "CHANGE_NETWORK_STATE=" + r106);     // Catch: Exception -> L27
        if (r106 == false) goto L21;
        if (r101 == true) goto L18;
        return 2;
    L18:
        if (a(r103, r100, r102) == false) goto L32;
        u.a("TelephonyUtils", "流量数据 WIFI 同开");     // Catch: Exception -> L27
        return 3;
    L32:
        return 2;
    L21:
        return 2;
    L23:
        if (r105 != 0) goto L29;
        u.a("TelephonyUtils", "流量");     // Catch: Exception -> L27
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

    private static boolean a(ConnectivityManager r100, Context r101, g r102) {
        Method r103 = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L14
        r103.setAccessible(true);     // Catch: Exception -> L14
        boolean r104 = ((Boolean) r103.invoke(r100, new Object[0])).booleanValue();     // Catch: Exception -> L14
        u.a("TelephonyUtils", "data is on ---------" + r104);     // Catch: Exception -> L14
        if (Build.VERSION.SDK_INT < 26) goto L12;
        TelephonyManager r105 = (TelephonyManager) r101.getSystemService("phone");     // Catch: Exception -> L14
        if (r105 != null) goto L9;
    L13:
        return r104;
    L9:
        if (r105.createForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId()).isDataEnabled() == false) goto L11;
        r102.b("networkTypeByAPI", "1");     // Catch: Exception -> L14
        goto L13
    L11:
        r102.b("networkTypeByAPI", "0");     // Catch: Exception -> L14
        goto L13
    L12:
        r102.b("networkTypeByAPI", "-1");     // Catch: Exception -> L14
    L14:
        u.b("TelephonyUtils", "isMobileEnabled ----反射出错-----");
        return false;
    }
}
