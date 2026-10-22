package com.larus.trace.tracespan.span;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public interface b {
    String a();

    void b(JSONObject r100);

    void c(JSONObject r100);

    void cancel(boolean r100);

    b d(String r100, Object r101);

    void e(b r100);

    String f();

    void g(Integer r100, String r101);

    b getParent();

    String getTag();

    String getTraceId();

    boolean hasEnd();

    void setTag(String r100);
}
