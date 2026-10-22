package com.bytedance.kmp.ec.yata.common.log;

import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void a(Map<String, ? extends Object> r100);

    boolean b();

    void c(Map<String, ? extends Object> r100);

    void d(String r100, String r101);

    void d(String r100, Throwable r101);

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    void ensureNotReachHere(Throwable r100, String r101);

    void i(String r100, String r101);

    void w(String r100, String r101);
}
