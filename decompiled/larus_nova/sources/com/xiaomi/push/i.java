package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.message.util.ToolUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f464100a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Set<String> f954a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f955a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f464101b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f464102c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f464103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f464104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f464105f = null;

    static {
        f464105f = String.valueOf(2);
        f956a = new String[]{HttpClient.ENDFLAG, "a-", "u-", "v-", "o-", "g-", "d-"};
        HashSet r100 = new HashSet();
        f954a = r100;
        r100.add("com.xiaomi.xmsf");
        r100.add("com.xiaomi.finddevice");
        r100.add("com.miui.securitycenter");
        f955a = true;
    }

    private static double a(double r100) {
        int r101 = 1;
    L3:
        double r102 = r101;
        if (r102 >= r100) goto L6;
        r101 = r101 << 1;
        goto L3
    L6:
        return r102;
    }

    public static int a() {
        Object r100 = av.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (r100 != null) goto L7;
        return -1;
    L7:
        return ((Integer) Integer.class.cast(r100)).intValue();
    }

    public static String a(Context r100) {
        return null;
    }

    public static String b(Context r100) {
        String r101 = ToolUtils.getAndroidId(r100);
        f464101b = r101;
        return r101;
    }

    public static String c(Context r100) {
        return null;
    }

    public static String d(Context r100) {
        return null;
    }

    public static String e(Context r100) {
        return null;
    }

    public static String f(Context r100) {
        return "";
    }

    private static String j(Context r100) {
        return "";
    }

    public static int b() {
        int r100 = 0;
        if (new PolarisFileWrapper("/proc/meminfo").exists() == false) goto L29;
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper("/proc/meminfo"), 8192);     // Catch: Throwable -> L21 Exception -> L26
        String r103 = r102.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (TextUtils.isEmpty(r103) == true) goto L16;
        String[] r104 = r103.split("\\s+");     // Catch: Throwable -> L18 Exception -> L20
        if (r104 == null) goto L16;
        if (r104.length < 2) goto L16;
        if (TextUtils.isDigitsOnly(r104[1]) == false) goto L16;
        r100 = Integer.parseInt(r104[1]);     // Catch: Throwable -> L18 Exception -> L20
        goto L16
    L16:
        r102.close();     // Catch: IOException -> L31
    L32:
    L20:
        r101 = r102;
    L18:
        Throwable th10 = th;
    L23:
        if (r102 != null) goto L35;
    L25:
        throw th10;
    L35:
        r102.close();     // Catch: IOException -> L30
        goto L25
    L21:
        th = move-exception;
        r102 = null;
        th10 = th;
    L27:
        if (r101 == null) goto L29;
        r101.close();     // Catch: IOException -> L31
    L29:
        return r100;
    }

    public static String c() {
        return b() + "KB";
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9282a() {
        return a(b()) + "GB";
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m9287b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9284a() {
        if (a() > 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static float a(int r100) {
        float r101 = ((((((r100 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double r102 = r101;
        if (r102 > 0.5d) goto L5;
        return r101;
    L5:
        return (float) Math.ceil(r102);
    }

    private static boolean b(String r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        String r101 = r100.trim();
        if (r101.length() != 0) goto L8;
        return true;
    L8:
        if (r101.equalsIgnoreCase("null") == false) goto L10;
        return true;
    L10:
        if (r101.equalsIgnoreCase("unknown") == true) goto L16;
        return false;
    L16:
        return true;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private static boolean m9289c(Context r100) {
        if ("com.xiaomi.xmsf".equals(r100.getPackageName()) == false) goto L33;
        return true;
    L33:
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 128);     // Catch: Exception -> L16
        if (r101 == null) goto L31;
        ApplicationInfo r102 = r101.applicationInfo;     // Catch: Exception -> L16
        if (r102 == null) goto L31;
        Bundle r103 = r102.metaData;     // Catch: Exception -> L16
        if (r103 == null) goto L31;
        if (r103.containsKey("supportGetAndroidID") == false) goto L31;
        boolean r104 = r101.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);     // Catch: Exception -> L16
        com.xiaomi.channel.commonutils.logger.b.m8723b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + r104);     // Catch: Exception -> L16
        return r104;
    L31:
        Intent r105 = new Intent();     // Catch: Exception -> L27
        ComponentName r106 = new ComponentName(r100.getPackageName(), "com.xiaomi.push.service.XMPushService");     // Catch: Exception -> L27
        r105.setComponent(r106);     // Catch: Exception -> L27
        ServiceInfo r107 = r100.getPackageManager().getServiceInfo(r106, 128);     // Catch: Exception -> L27
        if (r107 == null) goto L29;
        Bundle r108 = r107.metaData;     // Catch: Exception -> L27
        if (r108 == null) goto L29;
        if (r108.containsKey("supportGetAndroidID") == false) goto L29;
        com.xiaomi.channel.commonutils.logger.b.m8723b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");     // Catch: Exception -> L27
        return false;
    L29:
        com.xiaomi.channel.commonutils.logger.b.m8723b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    L27:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e.getMessage());
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e.getMessage());
        goto L31
    }

    public static synchronized String g(Context r100) {
        monitor-enter(i.class);
        String r101 = f464104e;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        monitor-exit(i.class);
        return r101;
    L8:
        String r102 = ba.b(b(r100) + a(r100));     // Catch: Throwable -> L11
        f464104e = r102;     // Catch: Throwable -> L11
        monitor-exit(i.class);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized String h(Context r100) {
        monitor-enter(i.class);
        String r101 = ba.b(b(r100) + null);     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static String i(Context r100) {
        return ((TelephonyManager) r100.getSystemService("phone")).getSimOperatorName();
    }

    private static String k(Context r100) {
        String r101 = r100.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        String r102 = l(r100);
        a(r100, r102);
        return r102;
    L6:
        return r101;
    }

    private static String l(Context r110) {
        return ax.a(Build.BRAND + "_" + Build.MODEL + "_" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + "_" + Build.VERSION.INCREMENTAL + "_" + a() + "_" + r110.getPackageName() + "_" + System.currentTimeMillis() + "_" + ba.a(16));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9285a(Context r100) {
        Intent r101 = l.a(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null);
        if (r101 == null) goto L10;
        int r102 = r101.getIntExtra("status", -1);
        if (r102 == 2) goto L9;
        if (r102 == 5) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m9288b(Context r100) {
        PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.isScreenOn() == true) goto L8;
        return false;
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        int r101 = 0;
    L6:
        String[] r102 = f956a;
        if (r101 >= r102.length) goto L13;
        if (r100.startsWith(r102[r101]) == true) goto L10;
        r101 = r101 + 1;
        goto L6
    L10:
        return true;
    L13:
        return false;
    }

    private static long a(File r100) {
        StatFs r101 = new StatFs(r100.getPath());
        long r102 = r101.getBlockCountLong();
        return r101.getBlockSizeLong() * r102;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m9283a(int r100) {
        if (r100 <= 0) goto L9;
        String[] r101 = f956a;
        if (r100 >= r101.length) goto L9;
        return r101[r100];
    L9:
        return f956a[0];
    }

    public static synchronized String a(Context r100, boolean r101) {
        monitor-enter(i.class);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (f464103d != null) goto L39;
        String r102 = b(r100);     // Catch: Throwable -> L42
        String r103 = "";
        if (j.m9300d() == true) goto L12;
        if (r101 == false) goto L10;
        String r104 = c(r100);     // Catch: Throwable -> L42
    L11:
        r103 = r104;
        goto L12
    L10:
        r104 = j(r100);     // Catch: Throwable -> L42
    L12:
        String r105 = a(r100);     // Catch: Throwable -> L42
        int r106 = 1;
        if (Build.VERSION.SDK_INT >= 26) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
    L34:
        r102 = r103 + r102 + r105;     // Catch: Throwable -> L42
    L35:
        com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + r106);     // Catch: Throwable -> L42
        if (r106 != 3) goto L38;
        f464103d = r102;     // Catch: Throwable -> L42
        goto L39
    L38:
        f464103d = m9283a(r106) + ba.b(r102);     // Catch: Throwable -> L42
        goto L39
    L18:
        if (b(r103) == false) goto L34;
        if (b(r105) == false) goto L34;
        String r108 = am.a(r100).b();     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r108) == true) goto L25;
        r102 = r108 + r102;     // Catch: Throwable -> L42
        r106 = 2;
        goto L35
    L25:
        String r109 = am.a(r100).mo8804a();     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r109) == true) goto L31;
        if (r109.startsWith("00000000-0000-0000-0000-000000000000") == true) goto L31;
        r106 = 4;
        r102 = r109;
    L31:
        if (TextUtils.isEmpty(r102) == true) goto L33;
        r106 = 5;
        goto L35
    L33:
        r102 = k(r100);     // Catch: Throwable -> L42
        r106 = 6;
        goto L35
    L15:
        r107 = false;
    L39:
        String r110 = f464103d;     // Catch: Throwable -> L42
        monitor-exit(i.class);
        return r110;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9286a(Context r100, String r101) {
        PackageInfo r102 = (PackageInfo) av.a(r100.getPackageManager(), "getPackageInfoAsUser", new Object[]{r101, 0, 999});
        if (r102 == null) goto L8;
        ApplicationInfo r103 = r102.applicationInfo;
        if (r103 == null) goto L8;
        if ((r103.flags & 8388608) != 8388608) goto L8;
        return false;
    L8:
        return true;
    }

    private static void a(Context r100, String r101) {
        SharedPreferences r102 = r100.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(r102.getString("default_id", null)) == false) goto L5;
        r102.edit().putString("default_id", r101).apply();
        return;
    L5:
        com.xiaomi.channel.commonutils.logger.b.m8718a("default_id exist,do not change it.");
    }
}
