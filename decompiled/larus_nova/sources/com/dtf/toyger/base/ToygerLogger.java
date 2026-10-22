package com.dtf.toyger.base;

/* JADX INFO: loaded from: classes22.dex */
public abstract class ToygerLogger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private int LOG_LEVEL;

    public abstract int debug(String r100, String r101);

    public abstract int error(String r100, String r101);

    public abstract String getStackTraceString(Throwable r100);

    public abstract int info(String r100, String r101);

    public abstract int verbose(String r100, String r101);

    public abstract int warn(String r100, String r101);

    public ToygerLogger() {
        this.LOG_LEVEL = 2;
    }

    public void setLogLevel(int r100) {
        if (r100 < 2) goto L9;
        if (r100 > 7) goto L9;
        this.LOG_LEVEL = r100;
        return;
    L9:
        throw new RuntimeException("The level value should between [2 , 7]");
    }

    public int d(String r100, Throwable r101) {
        if (this.LOG_LEVEL <= 3) goto L5;
        return -1;
    L5:
        return debug(r100, getStackTraceString(r101));
    }

    public int e(String r100, Throwable r101) {
        if (this.LOG_LEVEL <= 6) goto L5;
        return -1;
    L5:
        return error(r100, getStackTraceString(r101));
    }

    public int i(String r100, Throwable r101) {
        if (this.LOG_LEVEL <= 4) goto L5;
        return -1;
    L5:
        return info(r100, getStackTraceString(r101));
    }

    public int v(String r100, Throwable r101) {
        if (this.LOG_LEVEL <= 2) goto L5;
        return -1;
    L5:
        return verbose(r100, getStackTraceString(r101));
    }

    public int w(String r100, Throwable r101) {
        if (this.LOG_LEVEL <= 5) goto L5;
        return -1;
    L5:
        return warn(r100, getStackTraceString(r101));
    }

    public int d(String r100, String r101) {
        if (this.LOG_LEVEL <= 3) goto L5;
        return -1;
    L5:
        return debug(r100, r101);
    }

    public int e(String r100, String r101) {
        if (this.LOG_LEVEL <= 6) goto L5;
        return -1;
    L5:
        return error(r100, r101);
    }

    public int i(String r100, String r101) {
        if (this.LOG_LEVEL <= 4) goto L5;
        return -1;
    L5:
        return info(r100, r101);
    }

    public int v(String r100, String r101) {
        if (this.LOG_LEVEL <= 2) goto L5;
        return -1;
    L5:
        return verbose(r100, r101);
    }

    public int w(String r100, String r101) {
        if (this.LOG_LEVEL <= 5) goto L5;
        return -1;
    L5:
        return warn(r100, r101);
    }

    public int d(String r100, String r101, Throwable r102) {
        if (this.LOG_LEVEL <= 3) goto L5;
        return -1;
    L5:
        return debug(r100, r101 + '\n' + getStackTraceString(r102));
    }

    public int e(String r100, String r101, Throwable r102) {
        if (this.LOG_LEVEL <= 6) goto L5;
        return -1;
    L5:
        return error(r100, r101 + '\n' + getStackTraceString(r102));
    }

    public int i(String r100, String r101, Throwable r102) {
        if (this.LOG_LEVEL <= 4) goto L5;
        return -1;
    L5:
        return info(r100, r101 + '\n' + getStackTraceString(r102));
    }

    public int v(String r100, String r101, Throwable r102) {
        if (this.LOG_LEVEL <= 2) goto L5;
        return -1;
    L5:
        return verbose(r100, r101 + '\n' + getStackTraceString(r102));
    }

    public int w(String r100, String r101, Throwable r102) {
        if (this.LOG_LEVEL <= 5) goto L5;
        return -1;
    L5:
        return warn(r100, r101 + '\n' + getStackTraceString(r102));
    }
}
