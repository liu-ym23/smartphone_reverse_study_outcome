package com.mammon.audiosdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreNativeTraceSpanCallback {
    private static SAMICoreTraceSpanCallback userCallback;

    public SAMICoreNativeTraceSpanCallback() {
    }

    public static void setTraceSpanCallback(SAMICoreTraceSpanCallback r100) {
        userCallback = r100;
    }

    public static void onSpan(int r100, String r101, String r110, String r111, String r112, String r113) {
        if (userCallback == null) goto L14;
        if (r113 != null) goto L12;
        JSONObject r102 = null;
    L10:
        SAMICoreTraceSpanCallback r103 = userCallback;
        r103.onSpan(r100, r101, r110, r111, r112, r102);
        return;
    L12:
        r102 = new JSONObject(r113);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        r102 = new JSONObject();
        goto L10
    }
}
