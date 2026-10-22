package com.bytedance.ee.bear.quoto;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static void b(boolean r2, com.bytedance.ee.bear.contract.d r3, boolean r4, boolean r5, boolean r6, String r7) {
        if (r3 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        r0.put("is_owner", String.valueOf(r4));     // Catch: JSONException -> L12
        r0.put("is_default", String.valueOf(r5));     // Catch: JSONException -> L12
        r0.put("is_folder", String.valueOf(r6));     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r7) == true) goto L8;
        r0.put("reason", r7);     // Catch: JSONException -> L12
    L8:
        if (r2 == false) goto L10;
        r3.i("ccm_space_department_storage_excess_view", r0);     // Catch: JSONException -> L12
        return;
    L10:
        r3.i("ccm_space_storage_excess_view", r0);     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.d("ExceedQuotaAnalytic", "reportExceedQuotaView()...error = " + e);
    }

    public static void a(boolean r2, com.bytedance.ee.bear.contract.d r3, boolean r4, boolean r5, boolean r6, String r7, String r8) {
        if (r3 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        r0.put("is_owner", String.valueOf(r4));     // Catch: JSONException -> L10
        r0.put("is_default", String.valueOf(r5));     // Catch: JSONException -> L10
        r0.put("is_folder", String.valueOf(r6));     // Catch: JSONException -> L10
        r0.put("click", r7);     // Catch: JSONException -> L10
        r0.put("target", r8);     // Catch: JSONException -> L10
        if (r2 == false) goto L8;
        r3.i("ccm_space_department_storage_excess_click", r0);     // Catch: JSONException -> L10
    L13:
        return;
    L8:
        r3.i("ccm_space_storage_excess_click", r0);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        tt5.a.d("ExceedQuotaAnalytic", "reportExceedQuotaClick()...error = " + e);
    }
}
