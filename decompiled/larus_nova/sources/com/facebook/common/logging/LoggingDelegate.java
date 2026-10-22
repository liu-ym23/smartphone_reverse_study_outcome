package com.facebook.common.logging;

/* JADX INFO: loaded from: classes3.dex */
public interface LoggingDelegate {
    void d(String r100, String r101);

    void d(String r100, String r101, Throwable r102);

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    int getMinimumLoggingLevel();

    void i(String r100, String r101);

    void i(String r100, String r101, Throwable r102);

    boolean isLoggable(int r100);

    void log(int r100, String r101, String r102);

    void setMinimumLoggingLevel(int r100);

    void v(String r100, String r101);

    void v(String r100, String r101, Throwable r102);

    void w(String r100, String r101);

    void w(String r100, String r101, Throwable r102);

    void wtf(String r100, String r101);

    void wtf(String r100, String r101, Throwable r102);
}
