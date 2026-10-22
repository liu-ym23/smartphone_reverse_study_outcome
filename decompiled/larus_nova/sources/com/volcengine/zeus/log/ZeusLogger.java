package com.volcengine.zeus.log;

import android.text.TextUtils;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.apm.ApmUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
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
        StackTraceElement[] r100 = new Throwable().getStackTrace();     // Catch: Exception -> L14
        int r101 = 1;
    L5:
        if (r101 >= r100.length) goto L10;
        if (TextUtils.equals(r100[r101].getClassName(), ZeusLogger.class.getName()) == false) goto L8;
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

    public static void v(String r100) {
        v(null, r100);
    }

    public static void w(String r100) {
        w(null, r100);
    }

    public static void d(String r100, String r101) {
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().d(r100, r102);
        return;
    }

    public static void errReport(String r100, String r101) {
        RuntimeException r102 = new RuntimeException();
        StackTraceElement[] r103 = r102.getStackTrace();
        r102.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r103, 1, r103.length - 1));
        errReport(r100, r101, r102, false);
    }

    public static void i(String r100, String r101) {
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().i(r100, r102);
        return;
    }

    public static void v(String r100, String r101) {
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().v(r100, r102);
        return;
    }

    public static void w(String r100, String r101) {
        String r102 = prefixTraceInfo(r101);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().w(r100, r102);
        return;
    }

    public static void errReport(String r100, String r101, Throwable r102) {
        errReport(r100, r101, r102, true);
    }

    public static void w(String r100, String r101, Throwable r102) {
        String r103 = prefixTraceInfo(r101);
        if (sDebug == false) goto L6;
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L9;
        GlobalParam.getInstance().getLogger().w(r100, r103, r102);
        return;
    }

    private static void errReport(String r100, String r101, Throwable r102, boolean r103) {
        if (sDebug == false) goto L6;
    L12:
        ApmUtils.getApmInstance().reportError(r101, r102);
        return;
    L6:
        if (GlobalParam.getInstance().getLogger() == null) goto L12;
        IZeusLogger r104 = GlobalParam.getInstance().getLogger();
        if (r103 == false) goto L10;
        Throwable r105 = r102;
    L11:
        r104.e(r100, r101, r105);
        goto L12
    L10:
        r105 = null;
        goto L11
    }
}
