package com.bytedance.mira.log;

import android.text.TextUtils;
import com.bytedance.mira.IALogSupport;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParamPre;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class MiraLogger {
    public static final int DEBUG = 4;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final String TAG = "mira";
    public static final String TAG_ACTIVITY = "mira/activity";
    public static final String TAG_DOWNLOAD = "mira/morpheus";
    public static final String TAG_INIT = "mira/init";
    public static final String TAG_INSTALL = "mira/install";
    public static final String TAG_LOAD = "mira/load";
    public static final String TAG_PAM = "mira/pam";
    public static final String TAG_PPM = "mira/ppm";
    public static final String TAG_PROVIDER = "mira/provider";
    public static final String TAG_RECEIVER = "mira/receiver";
    public static final String TAG_RES = "mira/res";
    public static final String TAG_RESOLVE = "mira/resolve";
    public static final String TAG_SERVICE = "mira/service";
    public static final String TAG_SO = "mira/so";
    public static final int VERBOS = 5;
    public static final int WARN = 2;
    private static boolean sDebug = true;
    private static boolean sEnableTrace = false;
    private static int sLogLevel = 4;

    public MiraLogger() {
    }

    private static String getTraceInfo() {
        StackTraceElement[] r1 = new Throwable().getStackTrace();     // Catch: Exception -> L14
        int r2 = 1;
    L5:
        if (r2 >= r1.length) goto L10;
        if (TextUtils.equals(r1[r2].getClassName(), MiraLogger.class.getName()) == false) goto L8;
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L5
    L8:
        StackTraceElement r3 = r1[r2];     // Catch: Exception -> L14
    L11:
        if (r3 == null) goto L21;
        return "\t\t[" + r3.toString() + "]";
    L21:
        return "\t\t[No Trace Info]";
    L10:
        r3 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return "\t\t[No Trace Info]";
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    public static void d(String r1) {
        d(null, r1);
    }

    public static void e(String r1) {
        e(null, r1, null);
    }

    public static void i(String r1) {
        i(null, r1);
    }

    private static String prefixTraceInfo(String r1) {
        if (sEnableTrace == true) goto L5;
        return r1;
    L5:
        return r1 + getTraceInfo();
    }

    public static void setDebug(boolean r0) {
        sDebug = r0;
    }

    public static void setEnableTrace(boolean r0) {
        sEnableTrace = r0;
    }

    public static void setLogLevel(int r0) {
        sLogLevel = r0;
    }

    public static void v(String r1) {
        v(null, r1);
    }

    public static void w(String r1) {
        w(null, r1);
    }

    public static void d(String r2, String r3) {
        if (sLogLevel >= 4) goto L5;
        return;
    L5:
        i(r2, r3);
    }

    public static void e(String r1, String r2) {
        e(r1, r2, null);
    }

    public static void i(String r2, String r3) {
        if (sLogLevel >= 3) goto L5;
        return;
    L5:
        String r4 = prefixTraceInfo(r3);
        if (sDebug == false) goto L9;
        ALogService.iSafely(r2, r4);
        return;
    L9:
        if (iSafelyProxy(r2, r4) == true) goto L13;
        ALogService.iSafely(r2, r4);
        return;
    }

    private static boolean iSafelyProxy(String r1, String r2) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 != null) goto L5;
        IALogSupport r3 = null;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        r3.i(r1, r2);
        return true;
    L5:
        r3 = r0.getALogSupport();
        goto L6
    }

    public static void v(String r2, String r3) {
        if (sLogLevel >= 5) goto L5;
        return;
    L5:
        String r4 = prefixTraceInfo(r3);
        if (sDebug == false) goto L9;
        ALogService.vSafely(r2, r4);
        return;
    L9:
        if (vSafelyProxy(r2, r4) == true) goto L13;
        ALogService.vSafely(r2, r4);
        return;
    }

    private static boolean vSafelyProxy(String r1, String r2) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 != null) goto L5;
        IALogSupport r3 = null;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        r3.v(r1, r2);
        return true;
    L5:
        r3 = r0.getALogSupport();
        goto L6
    }

    public static void w(String r2, String r3) {
        if (sLogLevel >= 2) goto L5;
        return;
    L5:
        String r4 = prefixTraceInfo(r3);
        if (sDebug == false) goto L9;
        ALogService.wSafely(r2, r4);
        return;
    L9:
        if (wSafelyProxy(r2, r4) == true) goto L13;
        ALogService.wSafely(r2, r4);
        return;
    }

    private static boolean wSafelyProxy(String r1, String r2) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 != null) goto L5;
        IALogSupport r3 = null;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        r3.w(r1, r2);
        return true;
    L5:
        r3 = r0.getALogSupport();
        goto L6
    }

    public static void e(String r1, Throwable r2) {
        e(null, r1, r2);
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (sLogLevel >= 1) goto L5;
        return;
    L5:
        String r5 = prefixTraceInfo(r3);
        if (sDebug == false) goto L9;
        ALogService.eSafely(r2, r5, r4);
    L12:
        if (MiraManager.getInstance().getMiraErrorReporter() == null) goto L17;
        if (r4 != null) goto L15;
        r4 = new Throwable(r5);
    L15:
        MiraManager.getInstance().getMiraErrorReporter().onError(r5, r4);
        return;
    L17:
        return;
    L9:
        if (eSafelyProxy(r2, r5, r4) == true) goto L12;
        ALogService.eSafely(r2, r5, r4);
        goto L12
    }

    private static boolean eSafelyProxy(String r1, String r2, Throwable r3) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 != null) goto L5;
        IALogSupport r4 = null;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        r4.e(r1, r2, r3);
        return true;
    L5:
        r4 = r0.getALogSupport();
        goto L6
    }

    public static void w(String r1, String r2, Throwable r3) {
        String r4 = prefixTraceInfo(r2);
        if (sDebug == false) goto L6;
        ALogService.wSafely(r1, r4, r3);
        return;
    L6:
        if (wSafelyProxy(r1, r4, r3) == true) goto L10;
        ALogService.wSafely(r1, r4, r3);
        return;
    }

    private static boolean wSafelyProxy(String r1, String r2, Throwable r3) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 != null) goto L5;
        IALogSupport r4 = null;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        r4.w(r1, r2, r3);
        return true;
    L5:
        r4 = r0.getALogSupport();
        goto L6
    }
}
