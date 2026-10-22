package com.dtf.toyger.base;

import android.util.Log;
import com.dtf.face.log.RecordService;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerLog {
    public static final String DIAGNOSE = "diagnose";
    private static boolean ENABLE = true;
    private static final String TAG = "Toyger";
    private static final String TAG_PREFIX = "Toyger_";
    private static ToygerLogger sTargetLogger;

    public static final class a extends ToygerLogger {
        public a() {
        }

        @Override // com.dtf.toyger.base.ToygerLogger
        public String getStackTraceString(Throwable r100) {
            return RecordService.getStackTraceString(r100);
        }

        @Override // com.dtf.toyger.base.ToygerLogger
        public int debug(String r100, String r101) {
            return Log.d(r100, r101);
        }

        @Override // com.dtf.toyger.base.ToygerLogger
        public int error(String r100, String r101) {
            return Log.e(r100, r101);
        }

        @Override // com.dtf.toyger.base.ToygerLogger
        public int info(String r100, String r101) {
            return Log.i(r100, r101);
        }

        @Override // com.dtf.toyger.base.ToygerLogger
        public int verbose(String r100, String r101) {
            return Log.v(r100, r101);
        }

        @Override // com.dtf.toyger.base.ToygerLogger
        public int warn(String r100, String r101) {
            return Log.w(r100, r101);
        }
    }

    static {
        sTargetLogger = new a();
    }

    private ToygerLog() {
    }

    public static void d(String r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.d(TAG, r100);
        return;
    }

    public static void e(String r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.e(TAG, r100);
        return;
    }

    public static void i(String r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.i(TAG, r100);
        return;
    }

    public static void setEnable(boolean r100) {
        ENABLE = r100;
    }

    public static void setLogger(ToygerLogger r100) {
        sTargetLogger = r100;
    }

    public static void v(String r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.v(TAG, r100);
        return;
    }

    public static void w(String r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.w(TAG, r100);
        return;
    }

    public static void e(Throwable r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.e(TAG, r100);
        return;
    }

    public static void w(Throwable r100) {
        if (ENABLE == false) goto L6;
        sTargetLogger.w(TAG, r100);
        return;
    }

    public static void d(String r100, String r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.d(TAG_PREFIX + r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.e(TAG_PREFIX + r100, r101);
        return;
    }

    public static void i(String r100, String r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.i(TAG_PREFIX + r100, r101);
        return;
    }

    public static void v(String r100, String r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.v(TAG_PREFIX + r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.w(TAG_PREFIX + r100, r101);
        return;
    }

    public static void e(String r100, Throwable r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.e(TAG_PREFIX + r100, r101);
        return;
    }

    public static void w(String r100, Throwable r101) {
        if (ENABLE == false) goto L6;
        sTargetLogger.w(TAG_PREFIX + r100, r101);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (ENABLE == false) goto L6;
        sTargetLogger.e(TAG_PREFIX + r100, r101, r102);
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (ENABLE == false) goto L6;
        sTargetLogger.w(TAG_PREFIX + r100, r101, r102);
        return;
    }
}
