package com.lynx.debugrouter.log;

/* JADX INFO: loaded from: classes32.dex */
public interface ILogDelegate {
    void d(String r100, String r101);

    void e(String r100, String r101);

    int getMinimumLoggingLevel();

    void i(String r100, String r101);

    boolean isLoggable(int r100);

    void k(String r100, String r101);

    void log(int r100, String r101, String r102);

    void setMinimumLoggingLevel(int r100);

    int type();

    void v(String r100, String r101);

    void w(String r100, String r101);
}
