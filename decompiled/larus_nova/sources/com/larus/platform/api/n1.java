package com.larus.platform.api;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface n1 {
    String a();

    String b();

    void c();

    void d();

    void e(String r100);

    void ensureNotReachHere(String r100);

    void ensureNotReachHere(Throwable r100);

    void ensureNotReachHere(Throwable r100, String r101);

    void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102);

    void f(byte[] r100, Map<String, String> r101);

    void g(String r100);

    e1 h(String r100);

    void i(com.larus.bmhome.chat.screenshot.j r100);

    void monitorEventForSlardar(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
