package com.bytedance.caijing.sdk.infra.base.logger;

import android.util.Log;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.localtest.CJLocalTestService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;

/* JADX INFO: loaded from: classes3.dex */
public final class CJLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CJLocalTestService f202757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ALogService f202758b;

    public static final enum LogLevel extends Enum<LogLevel> {
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogLevel[] f202759a = null;

        static {
            LogLevel r100 = new LogLevel("WARN", 0);
            WARN = r100;
            LogLevel r101 = new LogLevel("INFO", 1);
            INFO = r101;
            LogLevel r102 = new LogLevel("DEBUG", 2);
            DEBUG = r102;
            LogLevel r103 = new LogLevel("ERROR", 3);
            ERROR = r103;
            f202759a = new LogLevel[]{r100, r101, r102, r103};
        }

        public static LogLevel[] values() {
            return (LogLevel[]) f202759a.clone();
        }

        public static LogLevel valueOf(String r100) {
            return (LogLevel) r27.a.a(LogLevel.class, r100);
        }

        public LogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f202760a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            f202760a = r100;
            r100[LogLevel.WARN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f202760a[LogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f202760a[LogLevel.DEBUG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f202760a[LogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        ve4.a.f554342a.getClass();
        f202757a = (CJLocalTestService) ve4.a.a(CJLocalTestService.class);
    }

    public static void a(String r100, String r101) {
        f(LogLevel.DEBUG, "cjpay-" + r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.getStackTraceString(th);
    }

    public static void b(String r100, String r101) {
        f(LogLevel.ERROR, "cjpay-" + r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.getStackTraceString(th);
    }

    public static void d(String r100, String r101) {
        f(LogLevel.INFO, "cjpay-" + r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.getStackTraceString(th);
    }

    public static void e(String r100, String r101) {
        f(LogLevel.WARN, "cjpay-" + r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.getStackTraceString(th);
    }

    public static void c(String r100, String r101, Throwable r102) {
        f(LogLevel.ERROR, "cjpay-" + r100, r101 + '\n' + Log.getStackTraceString(r102));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.getStackTraceString(th);
    }

    public static void f(LogLevel r100, String r101, String r102) {
        CJLocalTestService r103 = f202757a;
        if (r103 != null) goto L5;
    L7:
        Boolean r104 = Boolean.valueOf(CJEnv.f().hostIsDebug());
    L9:
        if (r104.booleanValue() == false) goto L13;
        int r105 = a.f202760a[r100.ordinal()];
        return;
    L13:
        if (f202758b != null) goto L15;
        ve4.a.f554342a.getClass();
        f202758b = (ALogService) ve4.a.a(ALogService.class);
    L15:
        ALogService r106 = f202758b;
        if (r106 != null) goto L18;
    L32:
        CJEnv.n();
        return;
    L18:
        if (r106.isReady() == false) goto L32;
        int r107 = a.f202760a[r100.ordinal()];
        if (r107 != 1) goto L22;
        r106.w(r101, r102);
        return;
    L22:
        if (r107 != 2) goto L24;
        r106.i(r101, r102);
        return;
    L24:
        if (r107 != 3) goto L26;
        r106.d(r101, r102);
        return;
    L26:
        if (r107 != 4) goto L38;
        r106.e(r101, r102);
        return;
    L38:
        return;
    L5:
        if (r103.isAlogDebugEnv() == false) goto L7;
        r104 = Boolean.TRUE;
        goto L9
    }
}
