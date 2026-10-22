package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, com.tencent.a.a.a> f461860a;

    public k() {
    }

    public static String a(int r100) {
        if (r100 != 10103) goto L7;
        return "shareToQQ";
    L7:
        if (r100 != 10104) goto L11;
        return "shareToQzone";
    L11:
        if (r100 != 10105) goto L15;
        return "addToQQFavorites";
    L15:
        if (r100 != 10106) goto L19;
        return "sendToMyComputer";
    L19:
        if (r100 != 10107) goto L23;
        return "shareToTroopBar";
    L23:
        if (r100 != 11101) goto L27;
        return "action_login";
    L27:
        if (r100 != 10100) goto L31;
        return "action_request";
    L31:
        if (r100 == 10114) goto L34;
        return null;
    L34:
        return "action_common_channel";
    }

    private static boolean b() {
        return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
    L8:
        return false;
    }

    static {
        f461860a = new ConcurrentHashMap();
    }

    public static void a() {
        f461860a.clear();
    }

    private static String c() {
        String r100 = com.tencent.open.b.b.b();
        if (r100 != null) goto L5;
    L6:
        SLog.e("openSDK_LOG.SystemUtils", "getAppId error: " + r100);
    L7:
        return r100;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L6
    }

    public static String a(Activity r100) {
        ApplicationInfo r101 = r100.getPackageManager().getApplicationInfo(r100.getApplicationContext().getPackageName(), 128);     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L8
        SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + r101.sourceDir);     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L8
        return r101.sourceDir;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
        return null;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "Exception", e);
        return null;
    }

    public static int b(String r100) {
        if ("shareToQQ".equals(r100) == false) goto L7;
        return 10103;
    L7:
        if ("shareToQzone".equals(r100) == false) goto L11;
        return 10104;
    L11:
        if ("addToQQFavorites".equals(r100) == false) goto L15;
        return 10105;
    L15:
        if ("sendToMyComputer".equals(r100) == false) goto L19;
        return 10106;
    L19:
        if ("shareToTroopBar".equals(r100) == false) goto L23;
        return 10107;
    L23:
        if ("action_login".equals(r100) == false) goto L27;
        return Constants.REQUEST_LOGIN;
    L27:
        if ("action_request".equals(r100) == false) goto L30;
        return 10100;
    L30:
        return -1;
    }

    public static boolean c(Context r100) {
        if (g(r100, "com.tencent.mobileqq") == false) goto L7;
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
        return true;
    L7:
        if (g(r100, Constants.PACKAGE_TIM) == false) goto L11;
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
        return true;
    L11:
        if (g(r100, Constants.PACKAGE_QQ_PAD) == false) goto L14;
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
        return true;
    L14:
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
        return false;
    }

    public static boolean d(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getApplicationInfo().targetSdkVersion >= 29) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT >= 29) goto L10;
        return false;
    L10:
        if (b() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public static String a(Context r100) {
        return r100.getApplicationInfo().loadLabel(r100.getPackageManager()).toString();
    }

    public static boolean b(Context r100) {
        boolean r101 = g(r100, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + r101);
        return r101;
    }

    public static void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f461860a.remove(r100);
    }

    public static boolean a(Context r100, Intent r101) {
        boolean r102 = true;
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        List<ResolveInfo> r103 = r100.getPackageManager().queryIntentActivities(r101, 0);
        if (r103 != null) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == true) goto L18;
        StringBuilder r104 = new StringBuilder("isActivityExist false. result=");
        if (r103 != null) goto L16;
        Object r105 = "null";
    L17:
        r104.append(r105);
        r104.append(" Intent= ");
        r104.append(r101);
        SLog.e("openSDK_LOG.SystemUtils", r104.toString());
        goto L18
    L16:
        r105 = Integer.valueOf(r103.size());
    L18:
        return r102;
    L9:
        if (r103.size() <= 0) goto L11;
    L19:
        StringBuilder r106 = new StringBuilder("isActivityExist params error! [");
        if (r100 != null) goto L22;
        boolean r107 = true;
    L23:
        r106.append(r107);
        r106.append(",");
        if (r101 == null) goto L27;
        r102 = false;
    L27:
        r106.append(r102);
        r106.append("]");
        SLog.e("openSDK_LOG.SystemUtils", r106.toString());
        return false;
    L22:
        r107 = false;
        goto L23
    }

    public static String b(Context r100, String r101) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String r102 = "";
        String r103 = r100.getPackageName();     // Catch: Exception -> L5
        Signature[] r104 = r100.getPackageManager().getPackageInfo(r103, 64).signatures;     // Catch: Exception -> L5
        MessageDigest r105 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L5
        r105.update(r104[0].toByteArray());     // Catch: Exception -> L5
        String r106 = m.a(r105.digest());     // Catch: Exception -> L5
        r105.reset();     // Catch: Exception -> L5
        SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + r106);     // Catch: Exception -> L5
        r105.update(m.j(r103 + "_" + r106 + "_" + r101 + ""));     // Catch: Exception -> L5
        r102 = m.a(r105.digest());     // Catch: Exception -> L5
        r105.reset();     // Catch: Exception -> L5
        StringBuilder r107 = new StringBuilder("-->signEncryped: ");     // Catch: Exception -> L5
        r107.append(r102);     // Catch: Exception -> L5
        SLog.v("openSDK_LOG.SystemUtils", r107.toString());     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
        return r102;
    }

    public static boolean c(Context r100, Intent r101) {
        boolean r102 = false;
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        ComponentName r103 = r101.getComponent();
        if (r103 != null) goto L10;
        SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
        return false;
    L10:
        String r104 = r103.getPackageName();
        String r105 = a(r100, r104);
        if (r105 != null) goto L13;
    L15:
        SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + r104 + ", appVersionName= " + r105);
        goto L16
    L13:
        if (r105.isEmpty() == true) goto L15;
        r102 = true;
    L16:
        return r102;
    }

    public static int d(Context r100, String r101) {
        return a(a(r100, Constants.PACKAGE_TIM), r101);
    }

    private static PackageInfo e(Context r100, String r101) {
        if (r100 == null) goto L26;
        if (r101 == null) goto L26;
        monitor-enter(k.class);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (f461860a.containsKey(r101) == false) goto L20;
        com.tencent.a.a.a r102 = f461860a.get(r101);     // Catch: Throwable -> L23
        if (r102 != null) goto L15;
        SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");     // Catch: Throwable -> L23
        monitor-exit(k.class);     // Catch: Throwable -> L23
        return null;
    L15:
        PackageInfo r103 = r102.f461398b;     // Catch: Throwable -> L23
        if (r103 != null) goto L18;
        SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");     // Catch: Throwable -> L23
    L18:
        monitor-exit(k.class);     // Catch: Throwable -> L23
        return r103;
    L20:
        PackageInfo r104 = f(r100, r101);     // Catch: Throwable -> L23
        f461860a.put(r101, new com.tencent.a.a.a(r101, r104));     // Catch: Throwable -> L23
        monitor-exit(k.class);     // Catch: Throwable -> L23
        return r104;
    L26:
        return null;
    }

    private static PackageInfo f(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: Exception -> L7
        if (r102 != null) goto L6;
        SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + r101);     // Catch: Exception -> L7
    L6:
        return r102;
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e);
        return null;
    }

    private static boolean g(Context r100, String r101) {
        if (h.a(r100, c(), r101) == null) goto L6;
        return true;
    L6:
        if (e(r100, r101) != null) goto L10;
        return false;
    L10:
        return true;
    }

    public static int a(String r100, String r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return 0;
    L7:
        if (r100 == null) goto L11;
        if (r101 != null) goto L11;
        return 1;
    L11:
        if (r100 != null) goto L14;
        if (r101 == null) goto L14;
        return -1;
    L14:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r104 = 0;
    L34:
        if (r104 >= r102.length) goto L26;
        if (r104 >= r103.length) goto L26;
        int r105 = CastIntegerProtector.parseInt(r102[r104]);     // Catch: NumberFormatException -> L32
        int r106 = CastIntegerProtector.parseInt(r103[r104]);     // Catch: NumberFormatException -> L32
        if (r105 < r106) goto L21;
        if (r105 > r106) goto L23;
        r104 = r104 + 1;     // Catch: NumberFormatException -> L32
        goto L34
    L23:
        return 1;
    L21:
        return -1;
    L26:
        if (r102.length <= r104) goto L28;
        return 1;
    L28:
        if (r103.length <= r104) goto L31;
        return -1;
    L31:
        return 0;
    L33:
        return r100.compareTo(r101);
    }

    public static boolean b(Context r100, Intent r101) {
        ArrayList r102 = new ArrayList(3);
        r102.add("com.tencent.mobileqq");
        r102.add(Constants.PACKAGE_TIM);
        if (r100 == null) goto L8;
        if (m.c(r100) == false) goto L8;
        r102.add(Constants.PACKAGE_QQ_PAD);
    L8:
        return a(r100, r101, r102);
    }

    public static int c(Context r100, String r101) {
        return a(a(r100, "com.tencent.mobileqq"), r101);
    }

    public static String a(Activity r100, String r101) {
        if (r100 != null) goto L15;
        SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
        return "";
    L15:
        byte[] r102 = e.a(r101);     // Catch: Exception -> L12
        if (r102 != null) goto L10;
        SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");     // Catch: Exception -> L12
        return "";
    L10:
        byte[] r103 = new byte[8];     // Catch: Exception -> L12
        System.arraycopy(r102, 5, r103, 0, 8);     // Catch: Exception -> L12
        byte[] r104 = new byte[16];     // Catch: Exception -> L12
        System.arraycopy(r102, 8, r104, 0, 16);     // Catch: Exception -> L12
        return e.a(r100.getPackageName(), e.a(r104), r103);
    L12:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
        return "";
    }

    public static String a(Context r100, String r101) {
        String r102 = h.a(r100, c(), r101);
        if (r102 != null) goto L5;
    L8:
        PackageInfo r103 = e(r100, r101);
        if (r103 != null) goto L13;
        SLog.e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + r101);
        return null;
    L13:
        return r103.versionName;
    L5:
        if ("UNKNOWN".equals(r102) == true) goto L8;
        return r102;
    }

    private static long a(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[8192];
        long r103 = 0;
    L3:
        int r104 = r100.read(r102, 0, 8192);
        if (r104 == (-1)) goto L6;
        r101.write(r102, 0, r104);
        r103 = r103 + ((long) r104);
        goto L3
    L6:
        SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + r103);
        return r103;
    }

    public static boolean a(String r110, String r111, int r112) {
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + r110);
        Context r100 = g.a();
        if (r100 != null) goto L6;
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
        return false;
    L6:
        SharedPreferences r101 = r100.getSharedPreferences("secure_lib", 0);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir(), r111);
        if (r102.exists() == true) goto L16;
        File r103 = r102.getParentFile();
        if (r103 != null) goto L11;
    L19:
        InputStream r104 = null;
        FileOutputStream r105 = null;
        r105 = null;
        r104 = null;
        InputStream r113 = r100.getAssets().open(r110);     // Catch: Throwable -> L33 Exception -> L35
        r105 = r100.openFileOutput(r111, 0);     // Catch: Throwable -> L29 Exception -> L31
        a(r113, r105);     // Catch: Throwable -> L29 Exception -> L31
        SharedPreferences.Editor r114 = r101.edit();     // Catch: Throwable -> L29 Exception -> L31
        r114.putInt("version", r112);     // Catch: Throwable -> L29 Exception -> L31
        r114.commit();     // Catch: Throwable -> L29 Exception -> L31
        if (r113 != null) goto L66;
    L26:
        if (r105 != null) goto L60;
    L28:
        return true;
    L60:
        r105.close();     // Catch: IOException -> L53
        goto L28
    L66:
        r113.close();     // Catch: IOException -> L25
        goto L26
    L31:
        e = e;
        FileOutputStream r106 = r105;
        r104 = r113;
        FileOutputStream r115 = r106;
    L58:
        SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);     // Catch: Throwable -> L45
        if (r104 != null) goto L68;
    L42:
        if (r115 != null) goto L62;
    L44:
        return false;
    L62:
        r115.close();     // Catch: IOException -> L55
        goto L44
    L68:
        r104.close();     // Catch: IOException -> L41
    L45:
        th = th;
    L46:
        if (r104 != null) goto L70;
    L50:
        if (r115 == null) goto L76;
        r115.close();     // Catch: IOException -> L54
        throw th;
    L77:
        throw th;
    L76:
        throw th;
    L70:
        r104.close();     // Catch: IOException -> L49
    L29:
        th = th;
        FileOutputStream r107 = r105;
        r104 = r113;
        r115 = r107;
        goto L46
    L35:
        e = e;
        r115 = null;
    L33:
        th = th;
        r115 = null;
        goto L46
    L11:
        if (r103.mkdirs() == false) goto L19;
        r102.createNewFile();     // Catch: IOException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L16:
        int r108 = r101.getInt("version", 0);
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + r112 + " | oldVersion: " + r108);
        if (r112 != r108) goto L19;
        return true;
    }

    public static boolean a(Context r100, Intent r101, List<String> r102) {
        boolean r103 = true;
        if (r100 == null) goto L37;
        if (r101 == null) goto L37;
        PackageManager r104 = r100.getPackageManager();
        if (TextUtils.isEmpty(r101.getPackage()) == true) goto L21;
        List<ResolveInfo> r105 = r104.queryIntentActivities(r101, 0);
        if (r105 != null) goto L11;
    L13:
        r103 = false;
    L14:
        if (r103 == true) goto L20;
        StringBuilder r106 = new StringBuilder("isTargetActivityExist false. result=");
        if (r105 != null) goto L18;
        Object r107 = "null";
    L19:
        r106.append(r107);
        SLog.e("openSDK_LOG.SystemUtils", r106.toString());
        goto L20
    L18:
        r107 = Integer.valueOf(r105.size());
    L20:
        return r103;
    L11:
        if (r105.size() <= 0) goto L13;
    L21:
        if (r102 != null) goto L24;
        SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist params error! targetPackageList is null");
        return false;
    L24:
        Iterator<String> r108 = r102.iterator();
    L26:
        if (r108.hasNext() == false) goto L35;
        String r109 = r108.next();
        if (r109 == null) goto L26;
        r101.setPackage(r109);
        List<ResolveInfo> r110 = r104.queryIntentActivities(r101, 0);
        r101.setPackage(null);
        if (r110 == null) goto L26;
        if (r110.size() <= 0) goto L26;
        return true;
    L35:
        SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist false");
        return false;
    L37:
        StringBuilder r111 = new StringBuilder("isTargetActivityExist params error! [");
        if (r100 != null) goto L40;
        boolean r112 = true;
    L41:
        r111.append(r112);
        r111.append(",");
        if (r101 == null) goto L45;
        r103 = false;
    L45:
        r111.append(r103);
        r111.append("]");
        SLog.e("openSDK_LOG.SystemUtils", r111.toString());
        return false;
    L40:
        r112 = false;
        goto L41
    }

    public static boolean a(Context r100, String r101, String r102) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        Signature[] r103 = r100.getPackageManager().getPackageInfo(r101, 64).signatures;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L11;
        if (m.g(r103[r105].toCharsString()).equals(r102) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }
}
