package com.bytedance.sdk.account.platform.onekey;

import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OnekeySettingManager {
    public static final boolean DEFAULT_ENABLE_EXPIRE_TIME_OPT = false;
    public static final boolean DEFAULT_ENABLE_GET_CARRIER_TYPE_OPT = false;
    public static final long DEFAULT_OVER_TIME_SEC = 4;
    public static final long DEFAULT_UNION_TOKEN_EXPIRE_IN = 3600000;
    public static final String KEY_CM_CONFIG = "cm_config";
    public static final String KEY_CT_CONFIG = "ct_config";
    public static final String KEY_CU_CONFIG = "cu_config";
    private static final String KEY_DATA_MOBILE_ENABLE = "need_data_mobile";
    private static final String KEY_DISABLE_SCENE_TIMEOUT_CARRIER = "disable_scene_timeout_carrier";
    private static final String KEY_ENABLE = "is_enable";
    private static final String KEY_ENABLE_EXPIRE_TIME_OPT = "enable_expire_time_opt";
    private static final String KEY_ENABLE_GET_CARRIER_TYPE_OPT = "enable_get_carrier_type_opt";
    private static final String KEY_GLOBAL_CONFIG = "global_config";
    private static final String KEY_PHONE_PERMISSION_ENABLE = "need_read_phone_permission";
    private static final String KEY_REQUEST_ABOVE_4G = "request_above_4g";
    private static final String KEY_SCENE_TIMEOUT = "scene_timeout";
    private static final String KEY_TIMEOUT = "timeout_sec";
    private static final String KEY_TOKEN_EXPIRE_IN = "token_expire_in";
    private static volatile OnekeySettingManager sInstance;

    public static OnekeySettingManager instance() {
        if (sInstance != null) goto L15;
        monitor-enter(OnekeySettingManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OnekeySettingManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OnekeySettingManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean isEnableExpireTimeOpt() {
        JSONObject r100 = getMobileConfig(KEY_GLOBAL_CONFIG);
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.optBoolean(KEY_ENABLE_EXPIRE_TIME_OPT, false);
    }

    public boolean isEnableGetCarrierTypeOpt() {
        JSONObject r100 = getMobileConfig(KEY_GLOBAL_CONFIG);
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.optBoolean(KEY_ENABLE_GET_CARRIER_TYPE_OPT, false);
    }

    public boolean requestAbove4GEnable() {
        JSONObject r100 = getMobileConfig(KEY_GLOBAL_CONFIG);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.optBoolean(KEY_REQUEST_ABOVE_4G);
    }

    private OnekeySettingManager() {
    }

    private JSONObject getMobileConfig(String r100) {
        IAccountSettingsService r101 = (IAccountSettingsService) AuthorizeFramework.getService(IAccountSettingsService.class);
        if (r101 == null) goto L8;
        JSONObject r102 = r101.getOnekeyLoginConfig();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.optJSONObject(r100);
    L8:
        return null;
    }

    public long getTimeout(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 4000;
    L5:
        JSONObject r101 = getMobileConfig(r100);
        if (r101 != null) goto L8;
        return 4000;
    L8:
        return r101.optLong(KEY_TIMEOUT, 4) * 1000;
    }

    public long getTokenExpireIn(String r100) {
        JSONObject r101 = getMobileConfig(r100);
        if (r101 == null) goto L7;
        long r102 = r101.optLong(KEY_TOKEN_EXPIRE_IN, -1);
        if (r102 <= 0) goto L9;
        return r102;
    L9:
        return 3600000;
    L7:
        return 3600000;
    }

    public boolean isEnable(String r100) {
        JSONObject r101 = getMobileConfig(r100);
        if (r101 != null) goto L5;
        return true;
    L5:
        if (r101.optInt("is_enable", 1) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean needReadPhonePermission(String r100) {
        if (TextUtils.equals("1", r100) == false) goto L10;
        JSONObject r101 = getMobileConfig(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.optInt(KEY_PHONE_PERMISSION_ENABLE, 0) != 1) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean needDataMobile(String r100, boolean r101) {
        JSONObject r102 = getMobileConfig(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if (r102.optInt(KEY_DATA_MOBILE_ENABLE, 1) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public long getSceneTimeOut(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        JSONObject r103 = getMobileConfig(KEY_GLOBAL_CONFIG);
        if (r103 == null) goto L9;
        JSONArray r104 = r103.optJSONArray(KEY_DISABLE_SCENE_TIMEOUT_CARRIER);
        if (r104 != null) goto L13;
    L22:
        JSONObject r105 = r103.optJSONObject(KEY_SCENE_TIMEOUT);
        if (r105 != null) goto L27;
        return getTimeout(r101);
    L27:
        if (r105.has(r100) == false) goto L31;
        return r105.optLong(r100);
    L31:
        return getTimeout(r101);
    L13:
        if (r104.length() <= 0) goto L22;
        int r106 = 0;
    L16:
        if (r106 >= r104.length()) goto L22;
        if (r102.equals(r104.optString(r106)) == true) goto L20;
        r106 = r106 + 1;
        goto L16
    L20:
        return getTimeout(r101);
    L9:
        return getTimeout(r101);
    L5:
        return getTimeout(r101);
    }
}
