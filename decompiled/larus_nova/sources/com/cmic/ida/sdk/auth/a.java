package com.cmic.ida.sdk.auth;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.cmic.ida.sdk.g;
import com.cmic.ida.sdk.u;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class a {
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

    public static JSONObject a(String r100, g r101, JSONObject r102) {
        String[] r103 = {PlayerResolution.NAME.UNKNOWN, "移动", "联通", "电信", "香港移动"};
        String r104 = r101.a(OnekeyLoginConstants.OPERATOR_TYPE, "0");     // Catch: Exception -> L15
        if ("0".equals(r104) == true) goto L11;
        if (TextUtils.isEmpty(r104) == true) goto L11;
        r102.put("operatorType", r103[CastIntegerProtector.parseInt(r104)]);     // Catch: Exception -> L15
    L18:
    L17:
        return r102;
    L11:
        if ("103000".equals(r100) == false) goto L13;
        r102.put("operatorType", r103[1]);     // Catch: Exception -> L15
        goto L18
    L13:
        r102.put("operatorType", r103[0]);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static JSONObject a(String r110, String r111, g r112, JSONObject r113) {
        String r100 = "0";
        JSONObject r101 = new JSONObject();
        int r102 = CastIntegerProtector.parseInt(r112.a("authType", "0"));     // Catch: Exception -> L18
        int r103 = r112.a("networktype");     // Catch: Exception -> L18
        if (r102 != 3) goto L9;
        if (r103 != 3) goto L8;
        String r104 = "WIFI下网关鉴权";
        String r105 = "1";
    L7:
        String r106 = r105;
        String r107 = r104;
        r100 = r106;
    L10:
        r101.put("resultCode", r110);     // Catch: Exception -> L18
        r101.put("authType", r100);     // Catch: Exception -> L18
        r101.put("authTypeDes", r107);     // Catch: Exception -> L18
        if ("103000".equals(r110) == true) goto L13;
        r101.put(SocialConstants.PARAM_APP_DESC, r111);     // Catch: Exception -> L18
    L20:
        u.a("AuthnResult", "返回参数:" + r101.toString());
        return r101;
    L13:
        if (1 != r112.a("logintype")) goto L15;
        r101.put("openId", r112.b("openId"));     // Catch: Exception -> L18
    L15:
        r101.put("token", r113.optString("token"));     // Catch: Exception -> L18
        r101.put(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN, r113.optString(OnekeyLoginConstants.CM_KEY_TOKEN_EXPIRES_IN));     // Catch: Exception -> L18
        goto L20
    L8:
        r104 = "网关鉴权";
        r105 = "2";
        goto L7
    L9:
        r107 = "其他";
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }
}
