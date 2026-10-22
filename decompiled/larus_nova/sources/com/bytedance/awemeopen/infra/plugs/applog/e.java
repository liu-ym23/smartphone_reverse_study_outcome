package com.bytedance.awemeopen.infra.plugs.applog;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class e {
    public static void a(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L38;
        if (r101 == null) goto L39;
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L25
    L7:
        if (r102.hasNext() == false) goto L40;
        String r103 = r102.next();     // Catch: Throwable -> L25
        if (r100.has(r103) == false) goto L11;
        String r104 = "";
        if (r101.has(r103) == true) goto L23;
        int r105 = 0;
    L17:
        if (r105 >= 10) goto L22;
        String r106 = r103 + "_" + r105;     // Catch: Throwable -> L25
        if (r101.has(r106) == false) goto L20;
        r105 = r105 + 1;     // Catch: Throwable -> L25
        goto L17
    L20:
        r104 = r106;
        goto L23
    L22:
        f.a("EventUtils", "not detect valid key");     // Catch: Throwable -> L25
    L23:
        r100.put(r104, r101.get(r103));     // Catch: Throwable -> L25
        goto L7
    L11:
        r100.put(r103, r101.get(r103));     // Catch: Throwable -> L25
        goto L7
    L40:
        return;
    L25:
        th = move-exception;
        f.a("EventUtils", th);
        return;
    L39:
        return;
    }
}
