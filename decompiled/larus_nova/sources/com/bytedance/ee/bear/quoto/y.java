package com.bytedance.ee.bear.quoto;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class y {
    public static String a(String r100) {
        if (r100 != null) goto L5;
        return "暂无";
    L5:
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49: goto L29;
            case 50: goto L25;
            case 51: goto L21;
            case 52: goto L17;
            case 53: goto L13;
            case 54: goto L9;
            default: goto L32;
        };
    L32:
        switch(r101) {
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
        if (r100.equals("6") == false) goto L32;
        r101 = 5;
        goto L32
    L13:
        if (r100.equals("5") == false) goto L32;
        r101 = 4;
        goto L32
    L17:
        if (r100.equals("4") == false) goto L32;
        r101 = 3;
        goto L32
    L21:
        if (r100.equals("3") == false) goto L32;
        r101 = 2;
        goto L32
    L25:
        if (r100.equals("2") == false) goto L32;
        r101 = 1;
        goto L32
    L29:
        if (r100.equals("1") == false) goto L32;
        r101 = 0;
        goto L32
    }

    public static void c(com.bytedance.ee.bear.contract.d r100, String r101, Boolean r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r104 = new JSONObject();
        r104.put("lark_version", a(r101));     // Catch: JSONException -> L17
        if (r102 != null) goto L9;
        String r105 = "暂无";
    L12:
        r104.put("member_type", r105);     // Catch: JSONException -> L17
        if (r103 != null) goto L15;
        r103 = "0";
    L15:
        r104.put("limit_type", r103);     // Catch: JSONException -> L17
        r100.i("ccm_drive_upload_limit_view", r104);     // Catch: JSONException -> L17
        return;
    L9:
        if (r102.booleanValue() == false) goto L11;
        r105 = "administrator";
        goto L12
    L11:
        r105 = "user";
    L17:
        e = move-exception;
        tt5.a.d("SingleFileExceedQuotaAn", "reportExceedQuotaView()...error = " + e);
    }

    public static void b(com.bytedance.ee.bear.contract.d r100, String r101, Boolean r102, String r103, String r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r105 = new JSONObject();
        r105.put("lark_version", a(r101));     // Catch: JSONException -> L17
        if (r102 != null) goto L9;
        String r106 = "暂无";
    L12:
        r105.put("member_type", r106);     // Catch: JSONException -> L17
        if (r103 != null) goto L15;
        r103 = "0";
    L15:
        r105.put("limit_type", r103);     // Catch: JSONException -> L17
        r105.put("click", r104);     // Catch: JSONException -> L17
        r100.i("ccm_drive_upload_limit_click", r105);     // Catch: JSONException -> L17
        return;
    L9:
        if (r102.booleanValue() == false) goto L11;
        r106 = "administrator";
        goto L12
    L11:
        r106 = "user";
    L17:
        e = move-exception;
        tt5.a.d("SingleFileExceedQuotaAn", "reportExceedQuotaClick()...error = " + e);
    }
}
