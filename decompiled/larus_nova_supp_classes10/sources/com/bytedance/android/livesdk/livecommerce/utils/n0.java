package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return "";
    L5:
        if (r3 != null) goto L26;
        return r1;
    L26:
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        JSONObject r0 = new JSONObject();
    L28:
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        e.toString();
    L24:
        return r0.toString();
    L18:
        if (r0.opt(r2) != null) goto L24;
        r0.put(r2, r3);     // Catch: Exception -> L21
        goto L24
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        r0 = new JSONObject(r1);     // Catch: Exception -> L15
    L25:
        goto L28
    L13:
        r0 = new JSONObject();     // Catch: Exception -> L15
        goto L25
    L10:
        r4 = false;
        goto L11
    }
}
