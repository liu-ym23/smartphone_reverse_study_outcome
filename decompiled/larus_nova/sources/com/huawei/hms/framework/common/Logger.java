package com.huawei.hms.framework.common;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class Logger {
    private static final String CLASSNAME_COMMON_PRE_FK = "com.huawei.hms.framework.";
    private static final String CLASSNAME_COMMON_PRE_NK = "com.huawei.hms.network.";
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NK_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NK_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean kitPrint = true;
    private static int minLogEnableLevel = 2;

    /* JADX INFO: renamed from: com.huawei.hms.framework.common.Logger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            monitor-enter(this);
            Throwable r100 = this.thisCause;     // Catch: Throwable -> L8
            if (r100 != this) goto L6;
            r100 = null;
        L6:
            monitor-exit(this);
            return r100;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable r100 = this.ownerThrowable;
            if (r100 != null) goto L6;
            return "";
        L6:
            String r101 = r100.getClass().getName();
            if (this.message == null) goto L14;
            String r102 = r101.concat(": ");
            if (this.message.startsWith(r102) == false) goto L13;
            return this.message;
        L13:
            return r102 + this.message;
        L14:
            return r101;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        private ThrowableWrapper(Throwable r100) {
            this.ownerThrowable = r100;
            StackTraceElement[] r101 = r100.getStackTrace();
            if ((r100 instanceof IOException) == false) goto L5;
        L8:
            int r102 = 8;
        L10:
            if (r101.length <= r102) goto L12;
            setStackTrace((StackTraceElement[]) Arrays.copyOf(r101, r102));
        L13:
            setMessage(StringUtils.anonymizeMessage(r100.getMessage()));
            return;
        L12:
            setStackTrace(r101);
            goto L13
        L5:
            if ((r100 instanceof JSONException) == true) goto L8;
            r102 = 20;
            goto L10
        }

        private synchronized void setCause(Throwable r100) {
            monitor-enter(this);
            this.thisCause = r100;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void setMessage(String r100) {
            this.message = r100;
        }

        public /* synthetic */ ThrowableWrapper(Throwable r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ void access$100(ThrowableWrapper r100, Throwable r101) {
            r100.setCause(r101);
        }
    }

    public Logger() {
    }

    private static String complexAppTag(String r100) {
        return TAG_NETWORK_SDK_PRE + r100;
    }

    private static String complexTag(String r100) {
        return TAG_NETWORKKIT_PRE + r100;
    }

    private static String getBriefCallMethodInfo(int r100) {
        StackTraceElement[] r101 = Thread.currentThread().getStackTrace();
        if (r101.length <= r100) goto L6;
        StackTraceElement r102 = r101[r100];
        return Thread.currentThread().getName() + "|" + r102.getClassName().replace(CLASSNAME_COMMON_PRE_NK, "").replace(CLASSNAME_COMMON_PRE_FK, "") + "|" + r102.getLineNumber();
    L6:
        return "";
    }

    private static String getCallMethodInfo(int r100) {
        if (Log.isLoggable(TAG_NETWORKKIT_PRE, 3) == true) goto L7;
        return getBriefCallMethodInfo(r100 + 1);
    L7:
        return getVerboseCallMethodInfo(r100 + 1);
    }

    private static Throwable getNewThrowable(Throwable r100) {
        if (isLoggable(3) == false) goto L5;
        return r100;
    L5:
        AnonymousClass1 r101 = null;
        if (r100 != null) goto L8;
        return null;
    L8:
        ThrowableWrapper r102 = new ThrowableWrapper(r100, r101);
        Throwable r103 = r100.getCause();
        ThrowableWrapper r104 = r102;
    L9:
        if (r103 == null) goto L11;
        ThrowableWrapper r105 = new ThrowableWrapper(r103, r101);
        ThrowableWrapper.access$100(r104, r105);
        r103 = r103.getCause();
        r104 = r105;
        goto L9
    L11:
        return r102;
    }

    private static String getVerboseCallMethodInfo(int r100) {
        StackTraceElement[] r101 = Thread.currentThread().getStackTrace();
        if (r101.length <= r100) goto L6;
        StackTraceElement r102 = r101[r100];
        return Thread.currentThread().getName() + "|" + r102.getFileName() + "|" + r102.getClassName() + "|" + r102.getMethodName() + "|" + r102.getLineNumber();
    L6:
        return "";
    }

    private static boolean isAPPLoggable(int r100) {
        if (extLogger != null) goto L5;
        return false;
    L5:
        if (r100 < 3) goto L10;
        return true;
    L10:
        return false;
    }

    private static boolean isKitLoggable(int r100) {
        if (kitPrint == true) goto L5;
    L7:
        return false;
    L5:
        if (isLoggable(r100) == false) goto L7;
        return true;
    }

    public static boolean isLoggable(int r100) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, r100);
    }

    public static void setLogEnableLevel(int r100) {
        minLogEnableLevel = r100;
    }

    private static String complexMsg(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        String r102 = getCallMethodInfo(r101);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return r100;
    L8:
        return r102 + "|" + r100;
    L10:
        return getCallMethodInfo(r101);
    }

    public static void d(String r100, Object r101) {
        println(3, r100, r101);
    }

    public static void e(String r100, Object r101) {
        println(6, r100, r101);
    }

    public static void i(String r100, Object r101) {
        println(4, r100, r101);
    }

    public static void setExtLogger(ExtLogger r100, boolean r101) {
        extLogger = r100;
        kitPrint = r101;
        i(TAG, "logger = " + r100 + r101);
    }

    public static void v(String r100, Object r101) {
        println(2, r100, r101);
    }

    public static void w(String r100, Object r101) {
        println(5, r100, r101);
    }

    public static void d(String r100, String r101, Object... r102) {
        println(3, r100, r101, r102);
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (6 >= minLogEnableLevel) goto L6;
        return;
    L6:
        if (isAPPLoggable(6) == false) goto L9;
        extLogger.e(complexAppTag(r100), complexMsg(r101, 5), getNewThrowable(r102));
    L9:
        if (kitPrint == false) goto L12;
        complexTag(r100);
        complexMsg(r101, 5);
        getNewThrowable(r102);
        return;
    }

    private static void extLogPrintln(int r100, String r101, String r102) {
        if (r100 != 2) goto L5;
        extLogger.v(r101, r102);
        return;
    L5:
        if (r100 != 3) goto L7;
        extLogger.d(r101, r102);
        return;
    L7:
        if (r100 != 4) goto L9;
        extLogger.i(r101, r102);
        return;
    L9:
        if (r100 != 5) goto L11;
        extLogger.w(r101, r102);
        return;
    L11:
        if (r100 != 6) goto L23;
        extLogger.e(r101, r102);
        return;
    }

    public static void i(String r100, String r101, Object... r102) {
        println(4, r100, r101, r102);
    }

    private static int logPrintln(int r100, String r101, String r102) {
        if (r100 >= minLogEnableLevel) goto L6;
        return 1;
    L6:
        if (isAPPLoggable(r100) == false) goto L9;
        extLogPrintln(r100, complexAppTag(r101), complexMsg(r102, 7));
    L9:
        if (isKitLoggable(r100) == true) goto L11;
        return 1;
    L11:
        return Log.println(r100, complexTag(r101), complexMsg(r102, 7));
    }

    public static void println(int r100, String r101, Object r102) {
        if (r100 >= 3) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
        String r103 = "null";
    L8:
        logPrintln(r100, r101, r103);
        return;
    L7:
        r103 = r102.toString();
        goto L8
    }

    public static void v(String r100, String r101, Object... r102) {
        println(2, r100, r101, r102);
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (5 >= minLogEnableLevel) goto L6;
        return;
    L6:
        if (isAPPLoggable(5) == false) goto L9;
        extLogger.w(complexAppTag(r100), complexMsg(r101, 5), getNewThrowable(r102));
    L9:
        if (kitPrint == false) goto L12;
        complexTag(r100);
        complexMsg(r101, 5);
        getNewThrowable(r102);
        return;
    }

    public static void e(String r100, String r101, Object... r102) {
        println(6, r100, r101, r102);
    }

    public static void w(String r100, String r101, Object... r102) {
        println(5, r100, r101, r102);
    }

    public static void println(int r100, String r101, String r102, Object... r103) {
        if (r100 >= 3) goto L5;
        return;
    L5:
        if (r102 != null) goto L12;
        return;
    L12:
        logPrintln(r100, r101, StringUtils.format(r102, r103));     // Catch: IllegalFormatException -> L9
        return;
    L9:
        e = move-exception;
        w(TAG, "log format error".concat(r102), e);
    }
}
