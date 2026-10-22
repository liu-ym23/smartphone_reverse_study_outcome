package com.bytedance.security.android.aopcheck.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.util.i;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessUtil {
    private static String sCurProcessName;
    private static boolean sIsMainProcess;

    public ProcessUtil() {
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r102 = r100.read();     // Catch: Throwable -> L14
        if (r102 <= 0) goto L8;
        r101.append((char) r102);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r103 = r101.toString();     // Catch: Throwable -> L14
        i.a(r100);
        return r103;
    L12:
        i.a(r100);
        return null;
    L11:
        r100 = null;
        goto L12
    }

    public static String getCurProcessName(Context r100) {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        String r101 = getCurProcessNameFromProc();
        sCurProcessName = r101;
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101;
    L5:
        return sCurProcessName;
    }

    public static boolean isMainProcess(Context r100) {
        boolean r101 = true;
        if (sIsMainProcess == false) goto L5;
        return true;
    L5:
        String r102 = getCurProcessName(r100);
        if (r102 != null) goto L8;
    L10:
        if (r102 != null) goto L12;
    L14:
        r101 = false;
    L15:
        sIsMainProcess = r101;
    L17:
        return sIsMainProcess;
    L12:
        if (r102.equals(r100.getPackageName()) == false) goto L14;
    L8:
        if (r102.contains(":") == false) goto L10;
        sIsMainProcess = false;
        goto L17
    }

    public static void setCurProcessName(String r100) {
        sCurProcessName = r100;
    }

    public static boolean isMainProcess(Context r100, String r101) {
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.equals(r100.getApplicationInfo().processName) == false) goto L11;
        return true;
    L5:
        if (r101.equals(r100.getPackageName()) == false) goto L7;
        return true;
    }
}
