package com.xiaomi.push;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f463638a;

    public interface a {
        Map<String, String> a(Context r100, String r101);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m9126a(Context r100, String r101);

        boolean b(Context r100, String r101);
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f463639a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private static final /* synthetic */ b[] f607a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f463640b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f463641c = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final int f608a;

        static {
            b r100 = new b("UNKNOWN", 0, 0);
            f463639a = r100;
            b r101 = new b("ALLOWED", 1, 1);
            f463640b = r101;
            b r102 = new b("NOT_ALLOWED", 2, 2);
            f463641c = r102;
            f607a = new b[]{r100, r101, r102};
        }

        public static b[] values() {
            return (b[]) f607a.clone();
        }

        public int a() {
            return this.f608a;
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        private b(String r100, int r101, int r102) {
            super(r100, r101);
            this.f608a = r102;
        }
    }

    public static String a() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        String r100 = Application.getProcessName();
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return r100;
    L9:
        return "";
    L5:
        r100 = (String) av.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        goto L7
    }

    public static int a(Context r100) {
        if (r100 != null) goto L13;
        return 0;
    L13:
        ApplicationInfo r101 = r100.getPackageManager().getApplicationInfo("com.android.systemui", 128);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r101 == null) goto L15;
        Bundle r102 = r101.metaData;     // Catch: PackageManager.NameNotFoundException -> L12
        if (r102 == null) goto L16;
        return r102.getInt("SupportForPushVersionCode");
    L16:
        return 0;
    L15:
        return 0;
    L17:
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9122a(Context r100) {
        String r101 = a();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r101.equals(r100.getPackageName());
    L7:
        return false;
    }

    private static b a(Context r100, ApplicationInfo r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r101 == null) goto L29;
        if (r102 < 24) goto L29;
    L24:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("are notifications enabled error " + e);
    L27:
        return b.f463639a;
    L9:
        if (r101.packageName.equals(r100.getPackageName()) == false) goto L12;
        Boolean r103 = Boolean.valueOf(((NotificationManager) r100.getSystemService("notification")).areNotificationsEnabled());     // Catch: Exception -> L24
    L18:
        if (r103 == null) goto L27;
        if (r103.booleanValue() == false) goto L23;
        return b.f463640b;
    L23:
        return b.f463641c;
    L12:
        if (r102 < 29) goto L14;
        Object r104 = av.a(r100.getSystemService("notification"), "getService", new Object[0]);     // Catch: Exception -> L24
    L15:
        if (r104 == null) goto L17;
        r103 = (Boolean) av.b(r104, "areNotificationsEnabledForPackage", new Object[]{r101.packageName, Integer.valueOf(r101.uid)});     // Catch: Exception -> L24
        goto L18
    L17:
        r103 = null;
        goto L18
    L14:
        r104 = r100.getSystemService(AppConstants.API_HOST_SI_PREFIX);     // Catch: Exception -> L24
    L29:
        return b.f463639a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m9124b(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L9
        PackageInfo r103 = r102.getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r103 == null) goto L12;
        ApplicationInfo r104 = r103.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L9
        if (r104 == null) goto L13;
        return r102.getApplicationLabel(r104).toString();
    L13:
        return r101;
    L12:
        return r101;
    L14:
        return r101;
    }

    public static boolean c(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (r102 != null) goto L8;
        return false;
    L8:
        return true;
    L5:
        r102 = null;
        goto L6
    }

    private static String com_xiaomi_push_g_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    public static boolean d(Context r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (Settings.Secure.getInt(r100.getContentResolver(), "freeform_window_state", -1) < 0) goto L15;
        return r101.equals(com_xiaomi_push_g_android_provider_Settings$Secure_getString(r100.getContentResolver(), "freeform_package_name"));
    L15:
        return false;
    L16:
        return false;
    L14:
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Drawable m9119a(Context r100, String r101) {
        ApplicationInfo r102 = m9118a(r100, r101);
        Drawable r103 = null;
        if (r102 != null) goto L14;
    L10:
        if (r103 == null) goto L13;
        return r103;
    L13:
        return new ColorDrawable(0);
    L14:
        r103 = r102.loadIcon(r100.getPackageManager());     // Catch: Exception -> L8
        if (r103 != null) goto L10;
        r103 = r102.loadLogo(r100.getPackageManager());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("get app icon drawable failed, " + e);
        goto L10
    }

    public static int b(Context r100, String r101) {
        ApplicationInfo r102 = m9118a(r100, r101);
        if (r102 == null) goto L7;
        int r103 = r102.icon;
        if (r103 == 0) goto L10;
        return r103;
    L10:
        return r102.logo;
    L7:
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static ApplicationInfo m9118a(Context r100, String r101) {
        if (r101.equals(r100.getPackageName()) == true) goto L11;
        return r100.getPackageManager().getApplicationInfo(r101, 0);
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("not found app info ".concat(r101));
        return null;
    L11:
        return r100.getApplicationInfo();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m9125b(Context r100, String r101) {
        a r102 = f463638a;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.b(r100, r101) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9123a(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (j.m9294a() == false) goto L10;
        a r102 = f463638a;
        if (r102 != null) goto L14;
        return false;
    L14:
        if (r102.m9126a(r100, r101) == false) goto L19;
        return true;
    L19:
        return false;
    L10:
        return r100.getPackageName().equals(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9120a(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 16384);     // Catch: Exception -> L4
    L5:
        if (r102 != null) goto L11;
        return "1.0";
    L11:
        return r102.versionName;
    L4:
        r102 = null;
        goto L5
    }

    public static int a(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 16384);     // Catch: Exception -> L4
    L5:
        if (r102 != null) goto L11;
        return 0;
    L11:
        return r102.versionCode;
    L4:
        r102 = null;
        goto L5
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Map<String, String> m9121a(Context r100, String r101) {
        a r102 = f463638a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a(r100, r101);
    }

    public static b a(Context r100, String r101, boolean r102) {
        if (r100 == null) goto L38;
        if (TextUtils.isEmpty(r101) == true) goto L38;
    L33:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("get app op error " + th);
    L36:
        return b.f463639a;
    L7:
        if (r101.equals(r100.getPackageName()) == false) goto L9;
        ApplicationInfo r103 = r100.getApplicationInfo();     // Catch: Throwable -> L33
    L10:
        b r104 = a(r100, r103);     // Catch: Throwable -> L33
        b r105 = b.f463639a;     // Catch: Throwable -> L33
        if (r104 == r105) goto L13;
        return r104;
    L13:
        Integer r106 = (Integer) av.a(AppOpsManager.class, "OP_POST_NOTIFICATION");     // Catch: Throwable -> L33
        if (r106 != null) goto L16;
        return r105;
    L16:
        Integer r107 = (Integer) av.a((AppOpsManager) r100.getSystemService("appops"), "checkOpNoThrow", new Object[]{r106, Integer.valueOf(r103.uid), r101});     // Catch: Throwable -> L33
        int r108 = (Integer) av.a(AppOpsManager.class, "MODE_ALLOWED");     // Catch: Throwable -> L33
        int r109 = (Integer) av.a(AppOpsManager.class, "MODE_IGNORED");     // Catch: Throwable -> L33
        com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", new Object[]{r107, r108, r109}));     // Catch: Throwable -> L33
        if (r108 != null) goto L19;
        r108 = 0;     // Catch: Throwable -> L33
    L19:
        if (r109 != null) goto L21;
        r109 = 1;     // Catch: Throwable -> L33
    L21:
        if (r107 == null) goto L36;
        if (r102 == false) goto L29;
        if (r107.equals(r109) == true) goto L27;
        return b.f463640b;
    L27:
        return b.f463641c;
    L29:
        if (r107.equals(r108) == false) goto L32;
        return b.f463640b;
    L32:
        return b.f463641c;
    L9:
        r103 = r100.getPackageManager().getApplicationInfo(r101, 0);     // Catch: Throwable -> L33
    L38:
        return b.f463639a;
    }

    public static void a(Context r100, ApplicationInfo r101, boolean r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (b.f463640b != a(r100, r101)) goto L14;
        return;
    L14:
        if (r103 < 29) goto L7;
        Object r104 = av.a(r100.getSystemService("notification"), "getService", new Object[0]);     // Catch: Exception -> L11
    L8:
        if (r104 == null) goto L17;
        av.b(r104, "setNotificationsEnabledForPackage", new Object[]{r101.packageName, Integer.valueOf(r101.uid), Boolean.valueOf(r102)});     // Catch: Exception -> L11
        return;
    L17:
        return;
    L7:
        r104 = r100.getSystemService(AppConstants.API_HOST_SI_PREFIX);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("set notifications enabled error " + e);
    }
}
