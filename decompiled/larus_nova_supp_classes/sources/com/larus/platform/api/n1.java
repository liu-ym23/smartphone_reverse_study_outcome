package com.larus.platform.api;

import com.larus.bmhome.chat.screenshot.j;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface n1 {
    String a();

    String b();

    void c();

    void d();

    void e(String r1);

    void ensureNotReachHere(String r1);

    void ensureNotReachHere(Throwable r1);

    void ensureNotReachHere(Throwable r1, String r2);

    void ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3);

    void f(byte[] r1, Map<String, String> r2);

    void g(String r1);

    e1 h(String r1);

    void i(j r1);

    void monitorEventForSlardar(String r1, JSONObject r2, JSONObject r3, JSONObject r4);
}
