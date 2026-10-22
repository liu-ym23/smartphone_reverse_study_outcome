package com.bytedance.mira.helper;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.compat.p.HackHelperImpl;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ProcessHelperOpt {
    private static final int FALSE = 0;
    private static final int NONE = -1;
    private static final int TRUE = 1;
    private static String sCurrentProcessName = null;
    private static int sIsMainProcess = -1;

    public ProcessHelperOpt() {
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L9;
        r0.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (MiraLogger.isDebug() == false) goto L11;
        MiraLogger.d("Process", "get processName = " + r0.toString());     // Catch: Throwable -> L14
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L14
        r2.close();     // Catch: Exception -> L19
    L13:
        return r1;
    L16:
        if (r2 != null) goto L27;
    L18:
        return null;
    L27:
        r2.close();     // Catch: Exception -> L20
    L15:
        r2 = null;
        goto L16
    }

    public static String getCurrentProcessName() {
        if (TextUtils.isEmpty(sCurrentProcessName) == true) goto L7;
        return sCurrentProcessName;
    L7:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        sCurrentProcessName = getCurrentProcessNameByReflect();
    L11:
        if (TextUtils.isEmpty(sCurrentProcessName) == false) goto L13;
        String r0 = getCurProcessNameFromProc();
        sCurrentProcessName = r0;
        return r0;
    L13:
        return sCurrentProcessName;
    L9:
        sCurrentProcessName = getCurrentProcessNameByMethod();
        goto L11
    }

    private static String getCurrentProcessNameByMethod() {
        return Application.getProcessName();
    }

    private static String getCurrentProcessNameByReflect() {
        Object r0 = ActivityThreadHelper.currentActivityThread();     // Catch: Throwable -> L4
        Object r1 = HackHelperImpl.getField(r0.getClass(), "mBoundApplication").get(r0);     // Catch: Throwable -> L4
        return (String) HackHelperImpl.getField(r1.getClass(), "processName").get(r1);
    L4:
        return null;
    }

    public static boolean isMainProcess(Context r2) {
        if (sIsMainProcess != (-1)) goto L6;
        sIsMainProcess = TextUtils.equals(getCurrentProcessName(), r2.getPackageName()) ? 1 : 0;
    L6:
        if (sIsMainProcess == 1) goto L10;
        return false;
    L10:
        return true;
    }
}
