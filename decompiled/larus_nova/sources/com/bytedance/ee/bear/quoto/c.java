package com.bytedance.ee.bear.quoto;

import android.text.TextUtils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static void b(boolean r100, com.bytedance.ee.bear.contract.d r101, boolean r102, boolean r103, boolean r104, String r105) {
        if (r101 != null) goto L4;
        return;
    L4:
        JSONObject r106 = new JSONObject();
        r106.put("is_owner", String.valueOf(r102));     // Catch: JSONException -> L12
        r106.put("is_default", String.valueOf(r103));     // Catch: JSONException -> L12
        r106.put("is_folder", String.valueOf(r104));     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r106.put("reason", r105);     // Catch: JSONException -> L12
    L8:
        if (r100 == false) goto L10;
        r101.i("ccm_space_department_storage_excess_view", r106);     // Catch: JSONException -> L12
        return;
    L10:
        r101.i("ccm_space_storage_excess_view", r106);     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.d("ExceedQuotaAnalytic", "reportExceedQuotaView()...error = " + e);
    }

    public static void a(boolean r100, com.bytedance.ee.bear.contract.d r101, boolean r102, boolean r103, boolean r104, String r105, String r106) {
        if (r101 != null) goto L4;
        return;
    L4:
        JSONObject r107 = new JSONObject();
        r107.put("is_owner", String.valueOf(r102));     // Catch: JSONException -> L10
        r107.put("is_default", String.valueOf(r103));     // Catch: JSONException -> L10
        r107.put("is_folder", String.valueOf(r104));     // Catch: JSONException -> L10
        r107.put("click", r105);     // Catch: JSONException -> L10
        r107.put(PickerReporterConstants.KEY.TARGET, r106);     // Catch: JSONException -> L10
        if (r100 == false) goto L8;
        r101.i("ccm_space_department_storage_excess_click", r107);     // Catch: JSONException -> L10
    L13:
        return;
    L8:
        r101.i("ccm_space_storage_excess_click", r107);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        tt5.a.d("ExceedQuotaAnalytic", "reportExceedQuotaClick()...error = " + e);
    }
}
