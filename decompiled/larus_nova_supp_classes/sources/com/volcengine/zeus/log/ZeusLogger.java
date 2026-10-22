package com.volcengine.zeus.log;

import android.text.TextUtils;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.apm.ApmUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ZeusLogger {
    public static final String TAG = "Zeus_zeus";
    public static final String TAG_ACTIVITY = "Zeus/activity_zeus";
    public static final String TAG_DEX2OAT = "Zeus/dex2oat_zeus";
    public static final String TAG_DOWNLOAD = "Zeus/download_zeus";
    public static final String TAG_INIT = "Zeus/init_zeus";
    public static final String TAG_INSTALL = "Zeus/install_zeus";
    public static final String TAG_LOAD = "Zeus/load_zeus";
    public static final String TAG_PAM = "Zeus/pam_zeus";
    public static final String TAG_PPM = "Zeus/ppm_zeus";
    public static final String TAG_PROVIDER = "Zeus/provider_zeus";
    public static final String TAG_RECEIVER = "Zeus/receiver_zeus";
    public static final String TAG_REPORTER = "Zeus/reporter_zeus";
    public static final String TAG_RESOURCES = "Zeus/resources_zeus";
    public static final String TAG_SERVER = "Zeus/server_zeus";
    public static final String TAG_SERVICE = "Zeus/service_zeus";
    public static final String TAG_SO = "Zeus/so_zeus";
    private static boolean sDebug = true;
    private static boolean sEnableTrace;

    public ZeusLogger() {
    }

    private static String getTraceInfo() {
        StackTraceElement[] r1 = new Throwable().getStackTrace();     // Catch: Exception -> L14
        int r2 = 1;
    L5:
        if (r2 >= r1.length) goto L10;
        if (TextUtils.equals(r1[r2].getClassName(), ZeusLogger.class.getName()) == false) goto L8;
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

    public static void v(String r1) {
        v(null, r1);
    }

    public static void w(String r1) {
        w(null, r1);
    }

    public static void d(String r1, String r2) {
        String r3 = prefixTraceInfo(r2);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().d(r1, r3);
        return;
    }

    public static void errReport(String r4, String r5) {
        RuntimeException r0 = new RuntimeException();
        StackTraceElement[] r1 = r0.getStackTrace();
        r0.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r1, 1, r1.length - 1));
        errReport(r4, r5, r0, false);
    }

    public static void i(String r1, String r2) {
        String r3 = prefixTraceInfo(r2);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().i(r1, r3);
        return;
    }

    public static void v(String r1, String r2) {
        String r3 = prefixTraceInfo(r2);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().v(r1, r3);
        return;
    }

    public static void w(String r1, String r2) {
        String r3 = prefixTraceInfo(r2);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().w(r1, r3);
        return;
    }

    public static void errReport(String r1, String r2, Throwable r3) {
        errReport(r1, r2, r3, true);
    }

    public static void w(String r1, String r2, Throwable r3) {
        String r4 = prefixTraceInfo(r2);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().w(r1, r4, r3);
        return;
    }

    private static void errReport(String r1, String r2, Throwable r3, boolean r4) {
        if (sDebug == false) goto L6;
    L12:
        ApmUtils.getApmInstance().reportError(r2, r3);
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L12;
        IZeusLogger r0 = GlobalParam.getInstance().getLogger();
        if (r4 == false) goto L10;
        Throwable r5 = r3;
    L11:
        r0.e(r1, r2, r5);
        goto L12
    L10:
        r5 = null;
        goto L11
    }
}
