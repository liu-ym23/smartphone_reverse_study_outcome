package com.bytedance.ee.bear.jsbridge;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.lark.officesdk.utils.di.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class Message {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f227150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f227151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f227152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f227153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f227154e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MESSAGE_CHANNEL {
    }

    public final String b() {
        JSONObject r100 = new JSONObject();
        r100.put("callbackId", this.f227150a);     // Catch: JSONException -> L5
        r100.put("data", this.f227153d);     // Catch: JSONException -> L5
        r100.put("handlerName", this.f227154e);     // Catch: JSONException -> L5
        r100.put(OnekeyLoginConstants.CT_KEY_RSP_DATA, this.f227152c);     // Catch: JSONException -> L5
        r100.put("responseId", this.f227151b);     // Catch: JSONException -> L5
        return r100.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public Message() {
    }

    public static List<Message> a(String r110) {
        ArrayList r100 = new ArrayList();
        JSONArray r101 = new JSONArray(r110);     // Catch: JSONException -> L27
        int r111 = 0;
    L4:
        if (r111 >= r101.length()) goto L29;
        Message r102 = new Message();     // Catch: JSONException -> L27
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r111);     // Catch: JSONException -> L27
        String r112 = null;
        if (r103.has("handlerName") == false) goto L9;
        String r104 = JSONObjectProtectorUtils.getString(r103, "handlerName");     // Catch: JSONException -> L27
    L10:
        r102.f227154e = r104;     // Catch: JSONException -> L27
        if (r103.has("callbackId") == false) goto L13;
        String r105 = JSONObjectProtectorUtils.getString(r103, "callbackId");     // Catch: JSONException -> L27
    L14:
        r102.f227150a = r105;     // Catch: JSONException -> L27
        if (r103.has(OnekeyLoginConstants.CT_KEY_RSP_DATA) == false) goto L17;
        String r106 = JSONObjectProtectorUtils.getString(r103, OnekeyLoginConstants.CT_KEY_RSP_DATA);     // Catch: JSONException -> L27
    L18:
        r102.f227152c = r106;     // Catch: JSONException -> L27
        if (r103.has("responseId") == false) goto L21;
        String r107 = JSONObjectProtectorUtils.getString(r103, "responseId");     // Catch: JSONException -> L27
    L22:
        r102.f227151b = r107;     // Catch: JSONException -> L27
        if (r103.has("data") == false) goto L25;
        r112 = JSONObjectProtectorUtils.getString(r103, "data");     // Catch: JSONException -> L27
    L25:
        r102.f227153d = r112;     // Catch: JSONException -> L27
        j.a("jsbridge.Message", r102.f227154e);     // Catch: JSONException -> L27
        r100.add(r102);     // Catch: JSONException -> L27
        r111 = r111 + 1;
        goto L4
    L21:
        r107 = null;
        goto L22
    L17:
        r106 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
    L29:
        return r100;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    public static Message c(String r100) {
        Message r101 = new Message();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L24
        String r103 = null;
        if (r102.has("handlerName") == false) goto L6;
        String r104 = JSONObjectProtectorUtils.getString(r102, "handlerName");     // Catch: JSONException -> L24
    L7:
        r101.f227154e = r104;     // Catch: JSONException -> L24
        if (r102.has("callbackId") == false) goto L10;
        String r105 = JSONObjectProtectorUtils.getString(r102, "callbackId");     // Catch: JSONException -> L24
    L11:
        r101.f227150a = r105;     // Catch: JSONException -> L24
        if (r102.has(OnekeyLoginConstants.CT_KEY_RSP_DATA) == false) goto L14;
        String r106 = JSONObjectProtectorUtils.getString(r102, OnekeyLoginConstants.CT_KEY_RSP_DATA);     // Catch: JSONException -> L24
    L15:
        r101.f227152c = r106;     // Catch: JSONException -> L24
        if (r102.has("responseId") == false) goto L18;
        String r107 = JSONObjectProtectorUtils.getString(r102, "responseId");     // Catch: JSONException -> L24
    L19:
        r101.f227151b = r107;     // Catch: JSONException -> L24
        if (r102.has("data") == false) goto L22;
        r103 = JSONObjectProtectorUtils.getString(r102, "data");     // Catch: JSONException -> L24
    L22:
        r101.f227153d = r103;     // Catch: JSONException -> L24
        return r101;
    L18:
        r107 = null;
        goto L19
    L14:
        r106 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    L6:
        r104 = null;
    L24:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }
}
