package com.bytedance.android.livesdk.log;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface g {
    void a(int r1);

    boolean addSendLogFilter(Object r1, com.bytedance.android.livesdk.log.filter.v r2);

    void b(String r1);

    com.bytedance.android.livesdk.log.filter.o c(Class r1);

    void d(String r1, Object... r2);

    void e(String r1, Map r2, Object... r3);

    void f(String r1, Map<String, String> r2, Object... r3);

    void g(String r1, boolean r2, boolean r3, Map<String, String> r4, Object... r5);

    Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter();

    void h(String r1, Map<String, String> r2, Object... r3);

    <T> void register(Class<? extends T> r1, com.bytedance.android.livesdk.log.filter.o<? extends T> r2);

    com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r1);

    void sendLog(String r1, Map<String, String> r2, Object... r3);
}
