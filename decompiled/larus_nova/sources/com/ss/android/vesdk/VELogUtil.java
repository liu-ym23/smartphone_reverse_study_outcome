package com.ss.android.vesdk;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.ttve.nativePort.TELogcat;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes40.dex */
public class VELogUtil {
    private static String APPNAME = "VESDK-";
    private static String AUTO_TEST_MONITOR = "monitorInfo";
    public static final int BEF_LOG_LEVEL_DEBUG = 3;
    public static final int BEF_LOG_LEVEL_DEFAULT = 1;
    public static final int BEF_LOG_LEVEL_ERROR = 6;
    public static final int BEF_LOG_LEVEL_FATAL = 7;
    public static final int BEF_LOG_LEVEL_INFO = 4;
    public static final int BEF_LOG_LEVEL_NONE = 0;
    public static final int BEF_LOG_LEVEL_SILENT = 8;
    public static final int BEF_LOG_LEVEL_VERBOSE = 2;
    public static final int BEF_LOG_LEVEL_WARN = 5;
    private static byte DEBUG_LEVEL = 7;
    private static final byte LOGD = 8;
    private static final byte LOGE = 1;
    private static final byte LOGI = 4;
    private static final byte LOGN = 0;
    private static final byte LOGV = 16;
    private static final byte LOGW = 2;
    public static final byte LOG_LEVEL_D = 15;
    public static final byte LOG_LEVEL_E = 1;
    public static final byte LOG_LEVEL_I = 7;
    public static final byte LOG_LEVEL_N = 0;
    public static final byte LOG_LEVEL_V = 31;
    public static final byte LOG_LEVEL_W = 3;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f455630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f455631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f455632c;

        public a(String r100, Object r101) {
            this.f455630a = r100;
            this.f455631b = String.valueOf(r101);
            this.f455632c = "";
        }
    }

    public VELogUtil() {
    }

    public static byte getLogLevel(byte r100) {
        if (r100 != 1) goto L5;
        return 1;
    L5:
        if (r100 != 3) goto L7;
        return 2;
    L7:
        if (r100 != 7) goto L9;
        return 4;
    L9:
        if (r100 != 15) goto L11;
        return 8;
    L11:
        if (r100 == 31) goto L14;
        return 0;
    L14:
        return 16;
    }

    public static String __FILE__() {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r100 != null) goto L5;
        return "unknown file";
    L5:
        if (r100.length >= 3) goto L7;
        return "unknown file";
    L7:
        return ThreadMethodProxy.currentThread().getStackTrace()[2].getFileName();
    }

    public static String __FUNCTION__() {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r100 != null) goto L5;
        return "unknown function";
    L5:
        if (r100.length >= 3) goto L7;
        return "unknown function";
    L7:
        return ThreadMethodProxy.currentThread().getStackTrace()[2].getMethodName();
    }

    public static int __LINE__() {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r100.length >= 3) goto L7;
        return -1;
    L7:
        return ThreadMethodProxy.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static byte getLogLevel() {
        return DEBUG_LEVEL;
    }

    public static String getSafeString(String r100) {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (PatternProtector.compile("%[^n]+n").matcher(r100).find() == false) goto L12;
        return r100.replace(GXTemplateKey.GAIAX_PE, "*");
    L12:
        return r100;
    L13:
        return r100;
    L11:
        return r100;
    }

    public static void setLogWriteFunction(long r100) {
        TELogcat.setLogWriteFunction(r100);
    }

    public static void d(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 8) == 0) goto L6;
        TELogcat.Log((byte) 8, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void e(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        TELogcat.Log((byte) 1, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void i(String r100, String r101) {
        if ((DEBUG_LEVEL & 4) == 0) goto L6;
        TELogcat.Log((byte) 4, APPNAME + r100, r101);
        return;
    }

    public static void logMonitorInfo(String r100, Object r101) {
        if ((DEBUG_LEVEL & 8) == 0) goto L6;
        r101.toString();
        return;
    }

    public static void setUp(String r100, byte r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        APPNAME += r100 + "-";
    L5:
        DEBUG_LEVEL = r101;
        TELogcat.setLogLevel(getLogLevel(r101));
    }

    public static void v(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 16) == 0) goto L6;
        TELogcat.Log((byte) 16, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void w(Class<?> r100, String r101) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        TELogcat.Log((byte) 2, APPNAME + r100.getSimpleName(), r101);
        return;
    }

    public static void d(String r100, String r101) {
        if ((DEBUG_LEVEL & 8) == 0) goto L6;
        TELogcat.Log((byte) 8, APPNAME + r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        TELogcat.Log((byte) 1, APPNAME + r100, r101);
        return;
    }

    public static void v(String r100, String r101) {
        if ((DEBUG_LEVEL & 16) == 0) goto L6;
        TELogcat.Log((byte) 16, APPNAME + r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        TELogcat.Log((byte) 2, APPNAME + r100, r101);
        return;
    }

    public static void e(Class<?> r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        TELogcat.Log((byte) 1, APPNAME + r100.getSimpleName(), r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }

    public static String formatLog(String r100, String r101, a... r102) {
        StringBuilder r103 = new StringBuilder(String.format("%s; (Msg): {%s}; ", new Object[]{r100, r101}));
        if (r102 == null) goto L10;
        int r104 = r102.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        a r106 = r102[r105];
        if (r106 == null) goto L9;
        r103.append(String.format("(%s): {%s}[%s], ", new Object[]{r106.f455630a, r106.f455631b, r106.f455632c}));
    L9:
        r105 = r105 + 1;
    L10:
        r103.append("_for_auto_analysis_");
        return r103.toString();
    }

    public static void log(byte r100, String r101, String r102) {
        if ((DEBUG_LEVEL & r100) == 0) goto L6;
        TELogcat.Log(r100, APPNAME + r101, r102);
        return;
    }

    public static void w(Class<?> r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        TELogcat.Log((byte) 2, APPNAME + r100.getSimpleName(), r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 1) == 0) goto L6;
        TELogcat.Log((byte) 1, APPNAME + r100, r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if ((DEBUG_LEVEL & 2) == 0) goto L6;
        TELogcat.Log((byte) 2, APPNAME + r100, r101 + "\n***StackTrace***\n" + Log.getStackTraceString(r102));
        return;
    }
}
