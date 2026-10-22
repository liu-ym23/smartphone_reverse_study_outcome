package com.bytedance.mira.log;

import android.text.TextUtils;
import com.bytedance.mira.IALogSupport;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParamPre;
import com.ss.alog.middleware.ALogService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes21.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
    }

    public MiraLogger() {
    }

    private static String getTraceInfo() {
        StackTraceElement[] r100 = new Throwable().getStackTrace();     // Catch: Exception -> L14
        int r101 = 1;
    L5:
        if (r101 >= r100.length) goto L10;
        if (TextUtils.equals(r100[r101].getClassName(), MiraLogger.class.getName()) == false) goto L8;
        r101 = r101 + 1;     // Catch: Exception -> L14
        goto L5
    L8:
        StackTraceElement r102 = r100[r101];     // Catch: Exception -> L14
    L11:
        if (r102 == null) goto L21;
        return "\t\t[" + r102.toString() + "]";
    L21:
        return "\t\t[No Trace Info]";
    L10:
        r102 = null;
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

    public static void d(String r100) {
        d(null, r100);
    }

    public static void e(String r100) {
        e(null, r100, null);
    }

    public static void i(String r100) {
        i(null, r100);
    }

    private static String prefixTraceInfo(String r100) {
        if (sEnableTrace == true) goto L5;
        return r100;
    L5:
        return r100 + getTraceInfo();
    }

    public static void setDebug(boolean r100) {
        sDebug = r100;
    }

    public static void setEnableTrace(boolean r100) {
        sEnableTrace = r100;
    }

    public static void setLogLevel(int r100) {
        sLogLevel = r100;
    }

    public static void v(String r100) {
        v(null, r100);
    }

    public static void w(String r100) {
        w(null, r100);
    }

    public static void d(String r100, String r101) {
        if (sLogLevel >= 4) goto L5;
        return;
    L5:
        i(r100, r101);
    }

    public static void e(String r100, String r101) {
        e(r100, r101, null);
    }

    public static void i(String r100, String r101) {
        if (sLogLevel >= 3) goto L5;
        return;
    L5:
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L9;
        ALogService.iSafely(r100, r102);
        return;
    L9:
        if (iSafelyProxy(r100, r102) == true) goto L13;
        ALogService.iSafely(r100, r102);
        return;
    }

    private static boolean iSafelyProxy(String r100, String r101) {
        MiraParamPre r102 = MiraManager.getInstance().getParamPre();
        if (r102 != null) goto L5;
        IALogSupport r103 = null;
    L6:
        if (r103 != null) goto L9;
        return false;
    L9:
        r103.i(r100, r101);
        return true;
    L5:
        r103 = r102.getALogSupport();
        goto L6
    }

    public static void v(String r100, String r101) {
        if (sLogLevel >= 5) goto L5;
        return;
    L5:
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L9;
        ALogService.vSafely(r100, r102);
        return;
    L9:
        if (vSafelyProxy(r100, r102) == true) goto L13;
        ALogService.vSafely(r100, r102);
        return;
    }

    private static boolean vSafelyProxy(String r100, String r101) {
        MiraParamPre r102 = MiraManager.getInstance().getParamPre();
        if (r102 != null) goto L5;
        IALogSupport r103 = null;
    L6:
        if (r103 != null) goto L9;
        return false;
    L9:
        r103.v(r100, r101);
        return true;
    L5:
        r103 = r102.getALogSupport();
        goto L6
    }

    public static void w(String r100, String r101) {
        if (sLogLevel >= 2) goto L5;
        return;
    L5:
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L9;
        ALogService.wSafely(r100, r102);
        return;
    L9:
        if (wSafelyProxy(r100, r102) == true) goto L13;
        ALogService.wSafely(r100, r102);
        return;
    }

    private static boolean wSafelyProxy(String r100, String r101) {
        MiraParamPre r102 = MiraManager.getInstance().getParamPre();
        if (r102 != null) goto L5;
        IALogSupport r103 = null;
    L6:
        if (r103 != null) goto L9;
        return false;
    L9:
        r103.w(r100, r101);
        return true;
    L5:
        r103 = r102.getALogSupport();
        goto L6
    }

    public static void e(String r100, Throwable r101) {
        e(null, r100, r101);
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (sLogLevel >= 1) goto L5;
        return;
    L5:
        String r103 = prefixTraceInfo(r101);
        if (sDebug == false) goto L9;
        ALogService.eSafely(r100, r103, r102);
    L12:
        if (MiraManager.getInstance().getMiraErrorReporter() == null) goto L17;
        if (r102 != null) goto L15;
        r102 = new Throwable(r103);
    L15:
        MiraManager.getInstance().getMiraErrorReporter().onError(r103, r102);
        return;
    L17:
        return;
    L9:
        if (eSafelyProxy(r100, r103, r102) == true) goto L12;
        ALogService.eSafely(r100, r103, r102);
        goto L12
    }

    private static boolean eSafelyProxy(String r100, String r101, Throwable r102) {
        MiraParamPre r103 = MiraManager.getInstance().getParamPre();
        if (r103 != null) goto L5;
        IALogSupport r104 = null;
    L6:
        if (r104 != null) goto L9;
        return false;
    L9:
        r104.e(r100, r101, r102);
        return true;
    L5:
        r104 = r103.getALogSupport();
        goto L6
    }

    public static void w(String r100, String r101, Throwable r102) {
        String r103 = prefixTraceInfo(r101);
        if (sDebug == false) goto L6;
        ALogService.wSafely(r100, r103, r102);
        return;
    L6:
        if (wSafelyProxy(r100, r103, r102) == true) goto L10;
        ALogService.wSafely(r100, r103, r102);
        return;
    }

    private static boolean wSafelyProxy(String r100, String r101, Throwable r102) {
        MiraParamPre r103 = MiraManager.getInstance().getParamPre();
        if (r103 != null) goto L5;
        IALogSupport r104 = null;
    L6:
        if (r104 != null) goto L9;
        return false;
    L9:
        r104.w(r100, r101, r102);
        return true;
    L5:
        r104 = r103.getALogSupport();
        goto L6
    }
}
