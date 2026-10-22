package com.bytedance.ee.bear.quoto;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y {
    public static String a(String r3) {
        if (r3 != null) goto L5;
        return "暂无";
    L5:
        byte r2 = -1;
        switch(r3.hashCode()) {
            case 49: goto L29;
            case 50: goto L25;
            case 51: goto L21;
            case 52: goto L17;
            case 53: goto L13;
            case 54: goto L9;
            default: goto L32;
        };
    L32:
        switch(r2) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L34;
            default: goto L33;
        };
    L33:
        return "暂无";
    L34:
        return "enterprise_efive";
    L36:
        return "enterprise_efour";
    L38:
        return "standard_ethree_certified";
    L40:
        return "standard_ethree";
    L42:
        return "flagship_etwo";
    L44:
        return "standard_eone";
    L9:
        if (r3.equals("6") == false) goto L32;
        r2 = 5;
        goto L32
    L13:
        if (r3.equals("5") == false) goto L32;
        r2 = 4;
        goto L32
    L17:
        if (r3.equals("4") == false) goto L32;
        r2 = 3;
        goto L32
    L21:
        if (r3.equals("3") == false) goto L32;
        r2 = 2;
        goto L32
    L25:
        if (r3.equals("2") == false) goto L32;
        r2 = 1;
        goto L32
    L29:
        if (r3.equals("1") == false) goto L32;
        r2 = 0;
        goto L32
    }

    public static void c(com.bytedance.ee.bear.contract.d r2, String r3, Boolean r4, String r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        r0.put("lark_version", a(r3));     // Catch: JSONException -> L17
        if (r4 != null) goto L9;
        String r6 = "暂无";
    L12:
        r0.put("member_type", r6);     // Catch: JSONException -> L17
        if (r5 != null) goto L15;
        r5 = "0";
    L15:
        r0.put("limit_type", r5);     // Catch: JSONException -> L17
        r2.i("ccm_drive_upload_limit_view", r0);     // Catch: JSONException -> L17
        return;
    L9:
        if (r4.booleanValue() == false) goto L11;
        r6 = "administrator";
        goto L12
    L11:
        r6 = "user";
    L17:
        e = move-exception;
        tt5.a.d("SingleFileExceedQuotaAn", "reportExceedQuotaView()...error = " + e);
    }

    public static void b(com.bytedance.ee.bear.contract.d r2, String r3, Boolean r4, String r5, String r6) {
        if (r2 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        r0.put("lark_version", a(r3));     // Catch: JSONException -> L17
        if (r4 != null) goto L9;
        String r7 = "暂无";
    L12:
        r0.put("member_type", r7);     // Catch: JSONException -> L17
        if (r5 != null) goto L15;
        r5 = "0";
    L15:
        r0.put("limit_type", r5);     // Catch: JSONException -> L17
        r0.put("click", r6);     // Catch: JSONException -> L17
        r2.i("ccm_drive_upload_limit_click", r0);     // Catch: JSONException -> L17
        return;
    L9:
        if (r4.booleanValue() == false) goto L11;
        r7 = "administrator";
        goto L12
    L11:
        r7 = "user";
    L17:
        e = move-exception;
        tt5.a.d("SingleFileExceedQuotaAn", "reportExceedQuotaClick()...error = " + e);
    }
}
