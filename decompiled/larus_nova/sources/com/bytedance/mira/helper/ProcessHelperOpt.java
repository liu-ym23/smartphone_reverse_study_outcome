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

/* JADX INFO: loaded from: classes.dex */
public class ProcessHelperOpt {
    private static final int FALSE = 0;
    private static final int NONE = -1;
    private static final int TRUE = 1;
    private static String sCurrentProcessName = null;
    private static int sIsMainProcess = -1;

    public ProcessHelperOpt() {
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r102 = r100.read();     // Catch: Throwable -> L14
        if (r102 <= 0) goto L9;
        r101.append((char) r102);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (MiraLogger.isDebug() == false) goto L11;
        MiraLogger.d("Process", "get processName = " + r101.toString());     // Catch: Throwable -> L14
    L11:
        String r103 = r101.toString();     // Catch: Throwable -> L14
        r100.close();     // Catch: Exception -> L19
    L13:
        return r103;
    L16:
        if (r100 != null) goto L27;
    L18:
        return null;
    L27:
        r100.close();     // Catch: Exception -> L20
    L15:
        r100 = null;
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
        String r100 = getCurProcessNameFromProc();
        sCurrentProcessName = r100;
        return r100;
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
        Object r100 = ActivityThreadHelper.currentActivityThread();     // Catch: Throwable -> L4
        Object r101 = HackHelperImpl.getField(r100.getClass(), "mBoundApplication").get(r100);     // Catch: Throwable -> L4
        return (String) HackHelperImpl.getField(r101.getClass(), "processName").get(r101);
    L4:
        return null;
    }

    public static boolean isMainProcess(Context r100) {
        if (sIsMainProcess != (-1)) goto L6;
        sIsMainProcess = TextUtils.equals(getCurrentProcessName(), r100.getPackageName()) ? 1 : 0;
    L6:
        if (sIsMainProcess == 1) goto L10;
        return false;
    L10:
        return true;
    }
}
