package androidx.camera.core;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    public static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    private Logger() {
    }

    public static int getMinLogLevel() {
        return sMinLogLevel;
    }

    public static boolean isDebugEnabled(String r1) {
        return isLogLevelEnabled(truncateTag(r1), 3);
    }

    public static boolean isErrorEnabled(String r1) {
        return isLogLevelEnabled(truncateTag(r1), 6);
    }

    public static boolean isInfoEnabled(String r1) {
        return isLogLevelEnabled(truncateTag(r1), 4);
    }

    public static boolean isVerboseEnabled(String r1) {
        return isLogLevelEnabled(truncateTag(r1), 2);
    }

    public static boolean isWarnEnabled(String r1) {
        return isLogLevelEnabled(truncateTag(r1), 5);
    }

    public static void setMinLogLevel(int r0) {
        sMinLogLevel = r0;
    }

    private static String truncateTag(String r2) {
        if (Build.VERSION.SDK_INT <= 25) goto L5;
        return r2;
    L5:
        if (MAX_TAG_LENGTH < r2.length()) goto L7;
        return r2;
    L7:
        return r2.substring(0, MAX_TAG_LENGTH);
    }

    public static void d(String r0, String r1) {
        isLogLevelEnabled(truncateTag(r0), 3);
    }

    public static void e(String r0, String r1) {
        isLogLevelEnabled(truncateTag(r0), 6);
    }

    public static void i(String r0, String r1) {
        isLogLevelEnabled(truncateTag(r0), 4);
    }

    private static boolean isLogLevelEnabled(String r1, int r2) {
        if (sMinLogLevel > r2) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(r1, r2) == true) goto L8;
        return false;
    }

    public static void w(String r0, String r1) {
        isLogLevelEnabled(truncateTag(r0), 5);
    }

    public static void d(String r0, String r1, Throwable r2) {
        isLogLevelEnabled(truncateTag(r0), 3);
    }

    public static void e(String r0, String r1, Throwable r2) {
        isLogLevelEnabled(truncateTag(r0), 6);
    }

    public static void i(String r0, String r1, Throwable r2) {
        isLogLevelEnabled(truncateTag(r0), 4);
    }

    public static void w(String r0, String r1, Throwable r2) {
        isLogLevelEnabled(truncateTag(r0), 5);
    }
}
