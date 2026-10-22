package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.ss.android.lark.log.Log;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class w {
    public static final void b(k r100, com.bytedance.lark.rustclient.api.s<InvokeResponse, ?> r101, com.bytedance.lark.rustclient.api.b<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r102, "input");
        JSONObject r103 = new JSONObject();
        r103.put("scenario", "invoke_meta_parse_c");     // Catch: JSONException -> L7
        r103.put("command", r102.f253903a.a().getValue());     // Catch: JSONException -> L7
        r103.put("context_id", r102.f253903a.f253893b);     // Catch: JSONException -> L7
        r103.put("utc_time_stamp", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());     // Catch: JSONException -> L7
        InvokeResponse r104 = r101.f253925a;     // Catch: JSONException -> L7
        if (r104 == null) goto L9;
        r103.put("is_error", r104.f254047a);     // Catch: JSONException -> L7
    L9:
        r100.c(r103);
        return;
    L7:
        e = move-exception;
        Log.e("sdk", "logInvokeMetaParseFailed: error occurs: " + e.getMessage(), e);
        goto L9
    }

    public static final void a(k r100, String r101, com.bytedance.lark.rustclient.api.b<?> r102, com.bytedance.lark.sdk.refactor.b r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clientUserId");
        Intrinsics.checkNotNullParameter(r102, "input");
        Intrinsics.checkNotNullParameter(r103, "rawResponse");
        JSONObject r104 = new JSONObject();
        r104.put("scenario", "invoke_async_c");     // Catch: JSONException -> L12
        r104.put("command", r102.f253903a.a().getValue());     // Catch: JSONException -> L12
        r104.put("client_user_id", r100.a(r101));     // Catch: JSONException -> L12
        r104.put("sdk_user_id", r100.a(r103.f254247d));     // Catch: JSONException -> L12
        r104.put("context_id", r102.f253903a.f253893b);     // Catch: JSONException -> L12
        r104.put("utc_time_stamp", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());     // Catch: JSONException -> L12
        if (r103.f254245b == false) goto L6;
        int r105 = 1;
    L7:
        r104.put("is_error", r105);     // Catch: JSONException -> L12
        r104.put("server_command", r102.f253903a.f253896e);     // Catch: JSONException -> L12
        StringBuilder r106 = new StringBuilder();     // Catch: JSONException -> L12
        if (r103.f254248e == false) goto L10;
        r106.append("verify,");     // Catch: JSONException -> L12
    L10:
        r104.put("extra", r106.toString());     // Catch: JSONException -> L12
    L14:
        r100.c(r104);
        return;
    L6:
        r105 = 0;
    L12:
        e = move-exception;
        Log.e("sdk", "logAsyncCallbackVerifyFailed: error occurs: " + e.getMessage(), e);
        goto L14
    }

    public static final void d(k r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "userId");
        JSONObject r104 = new JSONObject();
        r104.put("scenario", "push_cache_flush");     // Catch: JSONException -> L9
        r104.put("command", r102);     // Catch: JSONException -> L9
        r104.put("sdk_user_id", r100.a(r101));     // Catch: JSONException -> L9
        r104.put("utc_time_stamp", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());     // Catch: JSONException -> L9
        r104.put("is_error", 0);     // Catch: JSONException -> L9
        if (r103 == false) goto L6;
        String r105 = "global";
    L7:
        r104.put("extra", r105);     // Catch: JSONException -> L9
    L11:
        r100.c(r104);
        return;
    L6:
        r105 = "user";
    L9:
        e = move-exception;
        Log.e("sdk", "logPushCacheFlush: error occurs: " + e.getMessage(), e);
        goto L11
    }

    public static final void c(k r100, String r101, String r102, boolean r103, com.bytedance.lark.rustclient.api.s<InvokeResponse, ?> r104, com.bytedance.lark.rustclient.api.b<?> r105) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clientUserId");
        Intrinsics.checkNotNullParameter(r102, "sdkUserId");
        Intrinsics.checkNotNullParameter(r104, "response");
        Intrinsics.checkNotNullParameter(r105, "input");
        JSONObject r106 = new JSONObject();
        r106.put("scenario", "invoke_c");     // Catch: JSONException -> L11
        r106.put("command", r105.f253903a.a().getValue());     // Catch: JSONException -> L11
        r106.put("client_user_id", r100.a(r101));     // Catch: JSONException -> L11
        r106.put("sdk_user_id", r100.a(r102));     // Catch: JSONException -> L11
        r106.put("context_id", r105.f253903a.f253893b);     // Catch: JSONException -> L11
        r106.put("utc_time_stamp", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());     // Catch: JSONException -> L11
        InvokeResponse r107 = r104.f253925a;     // Catch: JSONException -> L11
        if (r107 == null) goto L6;
        r106.put("is_error", r107.f254047a);     // Catch: JSONException -> L11
    L6:
        StringBuilder r108 = new StringBuilder();     // Catch: JSONException -> L11
        if (r103 == false) goto L9;
        r108.append("verify,");     // Catch: JSONException -> L11
    L9:
        r106.put("extra", r108.toString());     // Catch: JSONException -> L11
    L13:
        r100.c(r106);
        return;
    L11:
        e = move-exception;
        Log.e("sdk", "logInvokeVerifyFailed: error occurs: " + e.getMessage(), e);
        goto L13
    }
}
