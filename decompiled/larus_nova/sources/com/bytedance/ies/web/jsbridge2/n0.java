package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f249395a;

    public static String a(Throwable r100) {
        JSONObject r101 = new JSONObject();
        if ((r100 instanceof JsBridgeException) == false) goto L6;
        int r102 = ((JsBridgeException) r100).code;     // Catch: JSONException -> L14
    L7:
        r101.put("code", r102);     // Catch: JSONException -> L14
        if (r100 == null) goto L13;
        if (TextUtils.isEmpty(r100.getMessage()) == true) goto L13;
        r101.put("msg", r100.getMessage());     // Catch: JSONException -> L14
        goto L13
    L6:
        r102 = 0;
    L13:
        return r101.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> String b(l r100, T r101) {
        if ((r101 instanceof JSONObject) == true) goto L5;
    L12:
        String r102 = r100.b(r101);
        if (TextUtils.isEmpty(r102) == false) goto L17;
        return "{\"code\":1}";
    L17:
        if (f249395a == false) goto L19;
        String r103 = r102.substring(1, r102.length() - 1);
    L20:
        String r104 = "{\"code\":1,\"__data\":".concat(r102);
        if (r103.isEmpty() == true) goto L24;
        return r104 + "," + r103 + com.alipay.sdk.m.u.i.f25855d;
    L24:
        return r104 + com.alipay.sdk.m.u.i.f25855d;
    L19:
        r103 = "";
        goto L20
    L5:
        if (f249395a == false) goto L12;
        if (r100.f249387b == false) goto L12;
        JSONObject r105 = (JSONObject) r101;
        r105.put("code", 1);     // Catch: JSONException -> L11
        return r105.toString();
    }
}
