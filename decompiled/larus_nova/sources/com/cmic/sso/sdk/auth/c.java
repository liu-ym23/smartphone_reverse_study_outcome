package com.cmic.sso.sdk.auth;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class c {
    public static JSONObject a(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("resultCode", "103000");     // Catch: JSONException -> L5
        r101.put(SocialConstants.PARAM_APP_DESC, "true");     // Catch: JSONException -> L5
        r101.put(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, r100);     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static JSONObject a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("resultCode", r100);     // Catch: Exception -> L5
        r102.put(SocialConstants.PARAM_APP_DESC, r101);     // Catch: Exception -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static JSONObject b(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("resultCode", r100);     // Catch: JSONException -> L5
        r102.put(SocialConstants.PARAM_APP_DESC, r101);     // Catch: JSONException -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static JSONObject a(String r100, com.cmic.sso.sdk.a r101, JSONObject r102) {
        String[] r103 = {PlayerResolution.NAME.UNKNOWN, "移动", "联通", "电信"};
        String r104 = r101.b("operatorTypeName");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r104) == true) goto L7;
        r102.put("operatorType", r104);     // Catch: Exception -> L11
    L14:
    L13:
        return r102;
    L7:
        String r105 = r101.b(OnekeyLoginConstants.OPERATOR_TYPE, "0");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r102.put("operatorType", r103[CastIntegerProtector.parseInt(r105)]);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static JSONObject a(String r110, String r111, com.cmic.sso.sdk.a r112, JSONObject r113) {
        String r100 = "0";
        JSONObject r101 = new JSONObject();
        int r102 = CastIntegerProtector.parseInt(r112.b("authType", "0"));     // Catch: Exception -> L18
        int r103 = r112.c("networktype");     // Catch: Exception -> L18
        if (r102 != 3) goto L9;
        if (r103 != 3) goto L7;
        String r104 = "WIFI下网关鉴权";
        String r105 = "1";
    L8:
        String r114 = r105;
        String r106 = r104;
        r100 = r114;
    L10:
        r101.put("resultCode", r110);     // Catch: Exception -> L18
        r101.put("authType", r100);     // Catch: Exception -> L18
        r101.put("authTypeDes", r106);     // Catch: Exception -> L18
        if ("103000".equals(r110) == true) goto L13;
        r101.put(SocialConstants.PARAM_APP_DESC, r111);     // Catch: Exception -> L18
    L20:
        com.cmic.sso.sdk.e.c.b("AuthnResult", "返回参数:" + r101.toString());
        return r101;
    L13:
        if (1 != r112.c("logintype")) goto L15;
        r101.put("openId", r112.b("openId"));     // Catch: Exception -> L18
        r101.put(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, r112.b(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP));     // Catch: Exception -> L18
    L15:
        r101.put("token", r113.optString("token"));     // Catch: Exception -> L18
        r101.put(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN, r113.optString(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN));     // Catch: Exception -> L18
        goto L20
    L7:
        r104 = "网关鉴权";
        r105 = "2";
        goto L8
    L9:
        r106 = "其他";
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }
}
