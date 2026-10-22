package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OnekeyDataHelper {
    public static final String CARRIER_APP_ID = "carrier_app_id";
    public static final String CM_EVENT_CARRIER = "china_mobile";
    public static final String CT_EVENT_CARRIER = "china_telecom";
    public static final String CU_EVENT_CARRIER = "china_unicom";
    public static final String ENSURE_NOT_REACH_HERE_EVENT = "one_click_ensure_not_reach_here";
    public static final String GET_CARRIER_EVENT = "one_click_carrier_response";
    public static final String GET_NETWORK_STATUS_EVENT = "one_click_network_response";
    public static final String GET_PHONE_EVENT = "one_click_number_request_response";
    public static final String GET_PHONE_SEND_EVENT = "one_click_number_request_send";
    public static final String GET_SUBSCRIPTION_ID_FAIL_EVENT = "one_click_get_subscription_id_fail";
    public static final String GET_TOKEN_EVENT = "one_click_login_token_response";
    public static final String GET_TOKEN_SEND_EVENT = "one_click_login_token_send";
    public static final String GET_VALIDATE_TOKEN_EVENT = "one_click_validate_token_response";
    public static final String GET_VALIDATE_TOKEN_SEND_EVENT = "one_click_validate_token_send";
    public static final String SIM_STATE_RESULT_EVENT = "one_click_sim_state_result";
    public static final int VERSION_CODE = 60592;

    public OnekeyDataHelper() {
    }

    private static JSONObject generateCommonJson(Context r100) {
        JSONObject r101 = new JSONObject();
        if (CommonUtils.hasPermission(r100, "android.permission.READ_PHONE_STATE") == false) goto L6;
        int r102 = 1;
    L7:
        r101.put("permission", r102);     // Catch: JSONException -> L9
        r101.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592);     // Catch: JSONException -> L9
        r101.put("params_for_special", "uc_login");     // Catch: JSONException -> L9
        goto L8
    L6:
        r102 = 0;
    L8:
        return r101;
    }

    public static String getCarrierEvent(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1856351708: goto L22;
            case -1429363305: goto L18;
            case -1068855134: goto L14;
            case -944421142: goto L10;
            case -840542575: goto L6;
            default: goto L25;
        };
    L25:
        switch(r101) {
            case 0: goto L29;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        String r102 = "";
    L31:
        if (TextUtils.isEmpty(r102) == true) goto L33;
        return r102;
    L33:
        return r100;
    L27:
        r102 = CU_EVENT_CARRIER;
        goto L31
    L28:
        r102 = CM_EVENT_CARRIER;
        goto L31
    L29:
        r102 = CT_EVENT_CARRIER;
        goto L31
    L6:
        if (r100.equals(OnekeyLoginConstants.UNICOM) == false) goto L25;
        r101 = 4;
        goto L25
    L10:
        if (r100.equals(OnekeyLoginConstants.UNICOM_V2) == false) goto L25;
        r101 = 3;
        goto L25
    L14:
        if (r100.equals("mobile") == false) goto L25;
        r101 = 2;
        goto L25
    L18:
        if (r100.equals(OnekeyLoginConstants.TELECOM) == false) goto L25;
        r101 = 1;
        goto L25
    L22:
        if (r100.equals(OnekeyLoginConstants.TELECOM_V2) == false) goto L25;
        r101 = 0;
        goto L25
    }

    public static JSONObject generateGetCarrierEvent(Context r100, String r101) {
        JSONObject r102 = generateCommonJson(r100);
        r102.put(Constants.OperatorKey.KEY_CARRIER, r101);     // Catch: JSONException -> L5
        r102.put("carrier_log", NetworkTypeHelper.getCarrierLog(r100));     // Catch: JSONException -> L5
    L4:
        return r102;
    }

    public static JSONObject generateGetNetStatusEvent(Context r100, int r101) {
        JSONObject r102 = generateCommonJson(r100);
        r102.put("network", CommonUtils.getNetStatusName(r101));     // Catch: JSONException -> L5
        r102.put("network_log", NetworkTypeHelper.getNetTypeLog(r100));     // Catch: JSONException -> L5
    L4:
        return r102;
    }

    private static void setExtraJsonData(OneLoginCallback r100, JSONObject r101) {
        if (r101 == null) goto L16;
        if (r100 == null) goto L27;
        JSONObject r102 = r100.onSendEvent();     // Catch: Exception -> L17
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.length() <= 0) goto L26;
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L17
    L11:
        if (r103.hasNext() == false) goto L29;
        String r104 = r103.next();     // Catch: Exception -> L17
        if (r101.has(r104) == true) goto L11;
        r101.put(r104, JSONObjectProtectorUtils.getString(r102, r104));     // Catch: Exception -> L17
    L29:
        return;
    L26:
        return;
    L28:
        return;
    L27:
        return;
    }

    public static OnekeyLoginErrorResponse getErrorResponse(String r100, String r101, String r102, int r103, int r104, JSONObject r105) {
        OnekeyLoginErrorResponse r106 = new OnekeyLoginErrorResponse();
        r106.netType = r102;
        r106.netStatus = r103;
        r106.platformErrorCode = r100;
        r106.platformErrorMsg = r101;
        r106.errorType = r104;
        r106.rawResult = r105;
        return r106;
    }

    public static JSONObject getMonitorJson(Context r100, String r101, String r102, String r103, int r104, AuthorizeCallback r105) {
        JSONObject r106 = generateCommonJson(r100);
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r106.put("network_type_detail", r103);     // Catch: JSONException -> L11
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r106.put("request_scene", r102);     // Catch: JSONException -> L11
    L9:
        r106.put(Constants.OperatorKey.KEY_CARRIER, r101);     // Catch: JSONException -> L11
        r106.put("network_type", CommonUtils.getNetStatusName(r104));     // Catch: JSONException -> L11
    L13:
        if ((r105 instanceof OneLoginCallback) == false) goto L15;
        setExtraJsonData((OneLoginCallback) r105, r106);
    L15:
        return r106;
    }

    public static JSONObject generateMonitorJson(Context r100, boolean r101, String r102, String r103, long r104, String r105, String r106, String r107, String r110, int r111, AuthorizeCallback r112) {
        JSONObject r108 = generateCommonJson(r100);
        if (r101 == true) goto L6;
        r108.put("error_code", r102);     // Catch: JSONException -> L20
        r108.put("error_msg", r103);     // Catch: JSONException -> L20
    L22:
        if ((r112 instanceof OneLoginCallback) == false) goto L24;
        setExtraJsonData((OneLoginCallback) r112, r108);
    L24:
        return r108;
    L6:
        if (TextUtils.isEmpty(r105) == true) goto L9;
        r108.put("carrier_sdk_logId", r105);     // Catch: JSONException -> L20
    L9:
        if (TextUtils.isEmpty(r107) == true) goto L12;
        r108.put("request_scene", r107);     // Catch: JSONException -> L20
    L12:
        if (TextUtils.isEmpty(r110) == true) goto L15;
        r108.put("network_type_detail", r110);     // Catch: JSONException -> L20
    L15:
        if (r101 == false) goto L17;
        int r109 = 1;
    L18:
        r108.put("result_value", r109);     // Catch: JSONException -> L20
        r108.put(Constants.OperatorKey.KEY_CARRIER, r106);     // Catch: JSONException -> L20
        r108.put("duration", r104);     // Catch: JSONException -> L20
        r108.put("network_type", CommonUtils.getNetStatusName(r111));     // Catch: JSONException -> L20
        goto L22
    L17:
        r109 = 0;
        goto L18
    }
}
