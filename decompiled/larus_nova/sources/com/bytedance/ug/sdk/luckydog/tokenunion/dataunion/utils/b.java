package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils;

import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static void a(String r100, String r101, String r102, DataUnionStrategy r103) {
        JSONObject r104 = new JSONObject();
        r104.put("luckydog_token_key", r100);     // Catch: JSONException -> L5
        r104.put("luckydog_token_value", r101);     // Catch: JSONException -> L5
        r104.put("luckydog_token_from", r102);     // Catch: JSONException -> L5
        r104.put("luckydog_token_type", r103.toString().toLowerCase());     // Catch: JSONException -> L5
        um7.e.b("onDataUnionEvent() EventName = luckydog_get_token; params = " + r104.toString());     // Catch: JSONException -> L5
    L7:
        rm7.c.a.f538587a.e("luckydog_get_token", r104);
        r104.put("time", new SimpleDateFormat(AdBaseConstants.RECORD_DATE_FORMAT).format(new Date()));     // Catch: Throwable -> L13
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L13
        pm7.b r106 = pm7.b.a.f529854a;     // Catch: Throwable -> L13
        String r107 = e.a(r106.getContext()).f272296a.getString("token_detail", null);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r107) == true) goto L11;
        r105.append(r107);     // Catch: Throwable -> L13
        r105.append("\n");     // Catch: Throwable -> L13
    L11:
        r105.append(r104.toString());     // Catch: Throwable -> L13
        e r108 = e.a(r106.getContext());     // Catch: Throwable -> L13
        r108.f272296a.edit().putString("token_detail", r105.toString()).apply();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        um7.e.a(th.getMessage());
        return;
    L5:
        e = move-exception;
        um7.e.a(e.getMessage());
        goto L7
    }
}
