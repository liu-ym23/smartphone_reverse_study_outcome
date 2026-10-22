package com.larus.dora.impl.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class y {
    public static String a(Context r100) {
        if (r100 != null) goto L34;
        return "";
    L34:
        String r101 = ita.k.c(r100);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r101) == true) goto L36;
        return r101;
    L36:
    L14:
        g49.d.e("DoraProcessUtils", "Application.getProcessName failed, fallback to ActivityManager");
    L32:
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L30
        if (r102 == null) goto L31;
        List<ActivityManager.RunningAppProcessInfo> r103 = r102.getRunningAppProcesses();     // Catch: Throwable -> L30
        if (r103 == null) goto L31;
        int r104 = Process.myPid();     // Catch: Throwable -> L30
        Iterator<ActivityManager.RunningAppProcessInfo> r105 = r103.iterator();     // Catch: Throwable -> L30
    L21:
        if (r105.hasNext() == false) goto L31;
        ActivityManager.RunningAppProcessInfo r106 = r105.next();     // Catch: Throwable -> L30
        if (r106 == null) goto L21;
        if (r106.pid != r104) goto L21;
        if (TextUtils.isEmpty(r106.processName) == true) goto L21;
        return r106.processName;
    L31:
        return "";
    L30:
        g49.d.e("DoraProcessUtils", "ActivityManager fallback getCurProcessName failed");
        goto L31
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L32;
        String r107 = Application.getProcessName();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r107) == true) goto L32;
        return r107;
    L8:
        g49.d.e("DoraProcessUtils", "ToolUtils.getCurProcessName failed, fallback to framework API");
        goto L36
    }

    public static boolean b(Context r100) {
        if (r100 != null) goto L18;
        return false;
    L18:
    L13:
        g49.d.e("DoraProcessUtils", "ToolUtils.isMainProcess failed, fallback by process name");
        String r101 = a(r100);
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return false;
    L17:
        return TextUtils.equals(r100.getPackageName(), r101);
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        String r102 = Application.getProcessName();     // Catch: Throwable -> L13
        if (r102 == null) goto L12;
        return r102.equals(r100.getPackageName());
    L12:
        return ita.k.i(r100);
    }
}
