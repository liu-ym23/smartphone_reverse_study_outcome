package com.bytedance.ee.bear.jsbridge;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class Message {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MESSAGE_CHANNEL {
    }

    public final String b() {
        JSONObject r0 = new JSONObject();
        r0.put("callbackId", this.a);     // Catch: JSONException -> L5
        r0.put("data", this.d);     // Catch: JSONException -> L5
        r0.put("handlerName", this.e);     // Catch: JSONException -> L5
        r0.put("responseData", this.c);     // Catch: JSONException -> L5
        r0.put("responseId", this.b);     // Catch: JSONException -> L5
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public Message() {
    }

    public static List<Message> a(String r11) {
        ArrayList r5 = new ArrayList();
        JSONArray r6 = new JSONArray(r11);     // Catch: JSONException -> L27
        int r12 = 0;
    L4:
        if (r12 >= r6.length()) goto L29;
        Message r7 = new Message();     // Catch: JSONException -> L27
        JSONObject r8 = JSONArrayProtectorUtils.getJSONObject(r6, r12);     // Catch: JSONException -> L27
        String r10 = null;
        if (r8.has("handlerName") == false) goto L9;
        String r9 = JSONObjectProtectorUtils.getString(r8, "handlerName");     // Catch: JSONException -> L27
    L10:
        r7.e = r9;     // Catch: JSONException -> L27
        if (r8.has("callbackId") == false) goto L13;
        String r13 = JSONObjectProtectorUtils.getString(r8, "callbackId");     // Catch: JSONException -> L27
    L14:
        r7.a = r13;     // Catch: JSONException -> L27
        if (r8.has("responseData") == false) goto L17;
        String r14 = JSONObjectProtectorUtils.getString(r8, "responseData");     // Catch: JSONException -> L27
    L18:
        r7.c = r14;     // Catch: JSONException -> L27
        if (r8.has("responseId") == false) goto L21;
        String r16 = JSONObjectProtectorUtils.getString(r8, "responseId");     // Catch: JSONException -> L27
    L22:
        r7.b = r16;     // Catch: JSONException -> L27
        if (r8.has("data") == false) goto L25;
        r10 = JSONObjectProtectorUtils.getString(r8, "data");     // Catch: JSONException -> L27
    L25:
        r7.d = r10;     // Catch: JSONException -> L27
        j.a("jsbridge.Message", r7.e);     // Catch: JSONException -> L27
        r5.add(r7);     // Catch: JSONException -> L27
        r12 = r12 + 1;
        goto L4
    L21:
        r16 = null;
        goto L22
    L17:
        r14 = null;
        goto L18
    L13:
        r13 = null;
        goto L14
    L9:
        r9 = null;
    L29:
        return r5;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    public static Message c(String r8) {
        Message r5 = new Message();
        JSONObject r6 = new JSONObject(r8);     // Catch: JSONException -> L24
        String r7 = null;
        if (r6.has("handlerName") == false) goto L6;
        String r9 = JSONObjectProtectorUtils.getString(r6, "handlerName");     // Catch: JSONException -> L24
    L7:
        r5.e = r9;     // Catch: JSONException -> L24
        if (r6.has("callbackId") == false) goto L10;
        String r10 = JSONObjectProtectorUtils.getString(r6, "callbackId");     // Catch: JSONException -> L24
    L11:
        r5.a = r10;     // Catch: JSONException -> L24
        if (r6.has("responseData") == false) goto L14;
        String r11 = JSONObjectProtectorUtils.getString(r6, "responseData");     // Catch: JSONException -> L24
    L15:
        r5.c = r11;     // Catch: JSONException -> L24
        if (r6.has("responseId") == false) goto L18;
        String r12 = JSONObjectProtectorUtils.getString(r6, "responseId");     // Catch: JSONException -> L24
    L19:
        r5.b = r12;     // Catch: JSONException -> L24
        if (r6.has("data") == false) goto L22;
        r7 = JSONObjectProtectorUtils.getString(r6, "data");     // Catch: JSONException -> L24
    L22:
        r5.d = r7;     // Catch: JSONException -> L24
        return r5;
    L18:
        r12 = null;
        goto L19
    L14:
        r11 = null;
        goto L15
    L10:
        r10 = null;
        goto L11
    L6:
        r9 = null;
    L24:
        e = move-exception;
        e.printStackTrace();
        return r5;
    }
}
