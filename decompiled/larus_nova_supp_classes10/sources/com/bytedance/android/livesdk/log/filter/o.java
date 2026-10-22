package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface o<T> {
    void a(Map<String, String> r1);

    void c(String r1, String r2);

    Map<String, String> getMap();

    void putAll(Map<String, String> r1);

    void remove(String r1);

    void setData(T r1);

    void u(Map<String, String> r1, T r2);
}
