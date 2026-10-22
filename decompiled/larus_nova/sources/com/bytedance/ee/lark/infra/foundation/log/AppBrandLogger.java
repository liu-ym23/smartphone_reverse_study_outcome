package com.bytedance.ee.lark.infra.foundation.log;

import android.text.TextUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public class AppBrandLogger {
    public static final int ERROR = 6;
    private static final boolean IS_DEVELOP_PACKAGE = false;
    private static final int MAX_TAG_LENGTH = 128;
    private static final String TAG = "AppBrandLogger";
    public static final String TAG_PREFIX = "tma_";
    public static final int WARN = 5;
    private static ILogger sFeedbackLogger = null;
    private static ILogger sLogger = null;
    private static boolean sLoggerDisable = true;
    private static boolean sShowMoreLogInfo;

    public interface ILogger {
        void flush();

        void logD(String r100, String r101);

        void logE(String r100, String r101);

        void logE(String r100, String r101, Throwable r102);

        void logI(String r100, String r101);

        void logW(String r100, String r101);
    }

    public AppBrandLogger() {
    }

    public static void flush() {
        ILogger r100 = sLogger;
        if (r100 == null) goto L6;
        r100.flush();
        return;
    }

    private static void updateLoggerEnableState() {
        if (sLogger == null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        sLoggerDisable = r100;
        return;
    L5:
        if (sFeedbackLogger != null) goto L7;
        r100 = true;
        goto L8
    }

    static {
        IS_DEVELOP_PACKAGE = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
    }

    public static boolean debug() {
        return sShowMoreLogInfo;
    }

    public static boolean isShowMoreLogInfo() {
        return sShowMoreLogInfo;
    }

    private static String createLog(Object[] r100) {
        if (r100 != null) goto L5;
        return "emptyLog";
    L5:
        StringBuilder r101 = new StringBuilder();
        if (sShowMoreLogInfo == false) goto L12;
        StackTraceElement[] r102 = new Throwable().getStackTrace();
        if (r102.length <= 2) goto L10;
        String r103 = r102[2].getFileName();
        String r104 = r102[2].getMethodName();
        int r105 = r102[2].getLineNumber();
    L11:
        r101.append(r104);
        r101.append("(");
        r101.append(r103);
        r101.append(":");
        r101.append(r105);
        r101.append(") ");
        goto L12
    L10:
        r105 = -1;
        r103 = "unknown file";
        r104 = "unknown";
    L12:
        int r106 = r100.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L20;
        Object r108 = r100[r107];
        r101.append(" ");
        if (r108 == null) goto L17;
        r101.append(r108);
    L18:
        r107 = r107 + 1;
        goto L13
    L17:
        r101.append("null");
        goto L18
    L20:
        return r101.toString();
    }

    private static String formatTag(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "tma";
    L7:
        if (sShowMoreLogInfo == false) goto L9;
        Thread r101 = ThreadMethodProxy.currentThread();
        String r102 = r101.toString() + "[" + r101.getId() + "]tma_";
    L11:
        if (r100.startsWith(r102) == false) goto L13;
        return r100;
    L13:
        return r102 + r100;
    L9:
        r102 = TAG_PREFIX;
        goto L11
    }

    public static void registerFeedbackLogger(ILogger r100) {
        sFeedbackLogger = r100;
        updateLoggerEnableState();
    }

    public static void registerLogger(ILogger r100) {
        sLogger = r100;
        updateLoggerEnableState();
    }

    public static void setShowMoreLogInfo(boolean r100) {
        sShowMoreLogInfo = r100;
        i(TAG, new Object[]{"setShowMoreLogInfo:", Boolean.valueOf(r100)});
    }

    public static void d(String r100, Object... r101) {
        if (sLoggerDisable == false) goto L9;
        if (sShowMoreLogInfo == false) goto L22;
        formatTag(r100);
        createLog(r101);
        return;
    L22:
        return;
    L9:
        if (IS_DEVELOP_PACKAGE == true) goto L13;
        if (sFeedbackLogger != null) goto L13;
        return;
    L13:
        if (needRefactorLongTag(r100, r101) == false) goto L15;
        r101 = new Object[]{r100};
        r100 = "tma";
    L15:
        String r102 = formatTag(r100);
        String r103 = createLog(r101);
        ILogger r104 = sLogger;
        if (r104 == null) goto L19;
        r104.logD(r102, r103);
    L19:
        if (sFeedbackLogger == null) goto L24;
        sFeedbackLogger.logD(formatTag(r102), createLog(r101));
        return;
    }

    public static void e(String r100, Object... r101) {
        if (r101 != null) goto L5;
    L9:
        boolean r102 = false;
    L11:
        if (sLoggerDisable == false) goto L20;
        if (sShowMoreLogInfo == false) goto L33;
        createLog(r101);
        if (r102 == false) goto L17;
        formatTag(r100);
        Throwable r103 = (Throwable) r101[r101.length - 1];
        return;
    L17:
        formatTag(r100);
        return;
    L33:
        return;
    L20:
        if (needRefactorLongTag(r100, r101) == false) goto L22;
        r101 = new Object[]{r100};
        r100 = "tma";
    L22:
        String r104 = formatTag(r100);
        String r105 = createLog(r101);
        if (r102 == false) goto L26;
        eWithThrowable(r104, r105, (Throwable) r101[r101.length - 1]);
        return;
    L26:
        ILogger r106 = sLogger;
        if (r106 == null) goto L29;
        r106.logE(r104, r105);
    L29:
        ILogger r107 = sFeedbackLogger;
        if (r107 == null) goto L35;
        r107.logE(r104, r105);
        return;
    L35:
        return;
    L5:
        if (r101.length <= 0) goto L9;
        if ((r101[r101.length - 1] instanceof Throwable) == false) goto L9;
        r102 = true;
        goto L11
    }

    public static void i(String r100, Object... r101) {
        if (sLoggerDisable == false) goto L9;
        if (sShowMoreLogInfo == false) goto L18;
        formatTag(r100);
        createLog(r101);
        return;
    L18:
        return;
    L9:
        if (needRefactorLongTag(r100, r101) == false) goto L11;
        r101 = new Object[]{r100};
        r100 = "tma";
    L11:
        String r102 = formatTag(r100);
        String r103 = createLog(r101);
        ILogger r104 = sLogger;
        if (r104 == null) goto L14;
        r104.logI(r102, r103);
    L14:
        ILogger r105 = sFeedbackLogger;
        if (r105 == null) goto L19;
        r105.logI(r102, r103);
        return;
    }

    private static boolean needRefactorLongTag(String r100, Object... r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L10:
        return false;
    L5:
        if (r100.length() < 128) goto L10;
        if (r101 != null) goto L8;
    L9:
        return true;
    L8:
        if (r101.length != 0) goto L10;
        goto L9
    }

    public static void w(String r100, Object... r101) {
        if (sLoggerDisable == false) goto L9;
        if (sShowMoreLogInfo == false) goto L18;
        formatTag(r100);
        createLog(r101);
        return;
    L18:
        return;
    L9:
        if (needRefactorLongTag(r100, r101) == false) goto L11;
        r101 = new Object[]{r100};
        r100 = "tma";
    L11:
        String r102 = formatTag(r100);
        String r103 = createLog(r101);
        ILogger r104 = sLogger;
        if (r104 == null) goto L14;
        r104.logW(r102, r103);
    L14:
        ILogger r105 = sFeedbackLogger;
        if (r105 == null) goto L19;
        r105.logW(r102, r103);
        return;
    }

    public static void eWithThrowable(String r100, String r101, Throwable r102) {
        if (sLoggerDisable == true) goto L5;
        String r103 = formatTag(r100);
        ILogger r104 = sLogger;
        if (r104 == null) goto L11;
        r104.logE(r103, r101, r102);
    L11:
        ILogger r105 = sFeedbackLogger;
        if (r105 == null) goto L16;
        r105.logE(r103, r101, r102);
        return;
    L16:
        return;
    L5:
        if (sShowMoreLogInfo == false) goto L15;
        formatTag(r100);
        return;
    }

    public static void log(String r100, int r101, String r102) {
        if (r101 != 3) goto L5;
        d(r100, new Object[]{r102});
        return;
    L5:
        if (r101 != 4) goto L7;
        i(r100, new Object[]{r102});
        return;
    L7:
        if (r101 != 5) goto L9;
        w(r100, new Object[]{r102});
        return;
    L9:
        if (r101 == 6) goto L11;
        i(r100, new Object[]{r102});
        return;
    L11:
        e(r100, new Object[]{r102});
    }

    public static void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        int r103 = 0;
        if (sLoggerDisable == true) goto L5;
        StringBuilder r104 = new StringBuilder();
        if (r102 == null) goto L18;
        int r105 = r102.length;
    L16:
        if (r103 >= r105) goto L18;
        r104.append(r102[r103]);
        r104.append("\n");
        r103 = r103 + 1;
    L18:
        String r106 = r104.toString();
        ILogger r107 = sLogger;
        if (r107 == null) goto L21;
        r107.logE(formatTag(r101), r106);
    L21:
        ILogger r108 = sFeedbackLogger;
        if (r108 == null) goto L28;
        r108.logE(formatTag(r101), r106);
        return;
    L28:
        return;
    L5:
        if (sShowMoreLogInfo == true) goto L7;
        return;
    L7:
        if (r102 == null) goto L11;
        int r109 = r102.length;
    L9:
        if (r103 >= r109) goto L11;
        Objects.toString(r102[r103]);
        r103 = r103 + 1;
    L11:
        formatTag(r101);
    }
}
