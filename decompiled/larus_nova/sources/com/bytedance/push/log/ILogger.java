package com.bytedance.push.log;

/* JADX INFO: loaded from: classes3.dex */
public interface ILogger {
    void d(String r100);

    void d(String r100, String r101);

    boolean debug();

    void e(String r100);

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    void i(String r100);

    void i(String r100, String r101);

    void i(String r100, String r101, Throwable r102);

    void v(String r100, String r101);

    void w(String r100, String r101);
}
