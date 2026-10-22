package com.ss.alog.middleware;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface IALogProtocol {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    void bundle(int r100, String r101, Bundle r102);

    void changeLevel(int r100);

    void d(String r100, String r101);

    void destroy();

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    void e(String r100, Throwable r101);

    void flush();

    void forceLogSharding();

    void header(int r100, String r101, String r102);

    void i(String r100, String r101);

    void init();

    void init(String r100);

    void intent(int r100, String r101, Intent r102);

    void json(int r100, String r101, String r102);

    void release();

    void statcktrace(int r100, String r101, StackTraceElement[] r102);

    void thread(int r100, String r101, Thread r102);

    void throwable(int r100, String r101, Throwable r102);

    void v(String r100, String r101);

    void w(String r100, String r101);

    void w(String r100, String r101, Throwable r102);

    void w(String r100, Throwable r101);
}
