package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f277530a;

    private static String a() {
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper("/proc/self/cmdline");     // Catch: Exception -> L35 IOException -> L37
        InputStreamReader r101 = new InputStreamReader(r100, StandardCharsets.UTF_8);     // Catch: Throwable -> L29
        BufferedReader r102 = new BufferedReader(r101);     // Catch: Throwable -> L23
        String r103 = r102.readLine();     // Catch: Throwable -> L17
        if (r103 == null) goto L13;
        String r104 = r103.trim();     // Catch: Throwable -> L17
        r102.close();     // Catch: Throwable -> L23
        r101.close();     // Catch: Throwable -> L29
        r100.close();     // Catch: Exception -> L35 IOException -> L37
        return r104;
    L13:
        r102.close();     // Catch: Throwable -> L23
        r101.close();     // Catch: Throwable -> L29
        r100.close();     // Catch: Exception -> L35 IOException -> L37
        return "";
    L17:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Exception -> L35 IOException -> L37
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L35 IOException -> L37
    L37:
        HMSLog.e("CommFun", "get current app processes IOException!");
        return "";
    L35:
        e = move-exception;
        HMSLog.e("CommFun", "get current app processes exception!" + e.getMessage());
        return "";
    }

    public static boolean b() {
        int r100 = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.d("CommFun", "Emui Api Level:" + r100);
        if (r100 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String a(Context r100) {
        if (TextUtils.isEmpty(f277530a) == false) goto L5;
        String r101 = b(r100);
        f277530a = r101;
        if (TextUtils.isEmpty(r101) == false) goto L9;
        String r102 = a();
        f277530a = r102;
        return r102;
    L9:
        return f277530a;
    L5:
        return f277530a;
    }

    private static String b(Context r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        if (r101 != null) goto L5;
        return "";
    L5:
        List<ActivityManager.RunningAppProcessInfo> r102 = r101.getRunningAppProcesses();
        if (r102 != null) goto L8;
    L20:
        HMSLog.w("CommFun", "get running app processes null!");
        return "";
    L8:
        if (r102.size() == 0) goto L20;
        int r103 = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();
        if (r105.pid != r103) goto L12;
        if (r105.processName == null) goto L12;
        HMSLog.i("CommFun", "info.pid -> " + r105.pid + ", info.processName -> " + r105.processName);
        return r105.processName;
    L19:
        return "";
    }

    public static String c(Context r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        String r101 = r100.createDeviceProtectedStorageContext().getDataDir() + "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        HMSLog.e("CommFun", "get storage root path of the current user failed.");
    L9:
        return r101;
    L5:
        r101 = r100.getFilesDir().getParent();
        goto L7
    }

    public static long d(Context r100) {
        return r100.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
    L4:
        HMSLog.e("CommFun", "get nc versionCode error");
        return -1;
    }

    public static boolean e(Context r100) {
        if (b() == true) goto L5;
        return false;
    L5:
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 21) goto L7;
        return false;
    L7:
        if (d(r100) >= 110001400) goto L13;
        return true;
    L13:
        return false;
    }
}
