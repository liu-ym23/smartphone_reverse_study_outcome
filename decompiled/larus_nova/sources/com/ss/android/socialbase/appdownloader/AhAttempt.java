package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class AhAttempt {
    public static final int ERROR_CODE_DEFAULT = -1;
    public static final int ERROR_CODE_DEVICE_NOT_FIT = 2;
    public static final int ERROR_CODE_FIND_URI_FAILED = 10;
    public static final int ERROR_CODE_HAS_TASK_NOT_REDIRECTED = 8;
    public static final int ERROR_CODE_MODIFY_NAME = 11;
    public static final int ERROR_CODE_NOT_APK = 9;
    public static final int ERROR_CODE_RESOLVE_ACTIVITY_FAILED = 3;
    public static final int ERROR_CODE_SAVE_PATH_ERROR = 7;
    public static final int ERROR_CODE_START_ACTIVITY_FAILED = 1;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CREATE_DESC_FAIL = 6;
    public static final int ERROR_NO_CUSTOM_DIR = 5;
    public static final int ERROR_OTHER = 4;
    public static final String JSON_TITLE = "ah_attempt";
    public static final String KEY_ANTI_PLAN_TYPE = "ah_plan_type";
    public static final String KEY_DEVICE_PLANS = "device_plans";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_ERROR_MSG = "error_msg";
    public static final String KEY_REAL_DEVICE_PLAN = "real_device_plan";
    public String anti_plan_type;
    public String device_plans;
    public int error_code;
    public String error_msg;
    public String real_device_plan;

    public JSONObject getJSONObject() {
        JSONObject r100 = new JSONObject();
        appendJSONObject(r100);
        return r100;
    }

    public AhAttempt() {
        this.error_code = -1;
    }

    public String getJsonString() {
        return getJSONObject().toString();
    }

    public static AhAttempt fromJson(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        AhAttempt r101 = new AhAttempt();
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L11
        r101.device_plans = r102.optString("device_plans", null);     // Catch: Throwable -> L11
        r101.real_device_plan = r102.optString(KEY_REAL_DEVICE_PLAN, null);     // Catch: Throwable -> L11
        r101.error_msg = r102.optString("error_msg", null);     // Catch: Throwable -> L11
        r101.anti_plan_type = r102.optString(KEY_ANTI_PLAN_TYPE, null);     // Catch: Throwable -> L11
        String r103 = r102.optString("error_code");     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r103) == false) goto L9;
        r101.error_code = -1;     // Catch: Throwable -> L11
    L14:
    L13:
        return r101;
    L9:
        r101.error_code = CastIntegerProtector.parseInt(r103);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    public void appendJSONObject(JSONObject r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.put(KEY_ANTI_PLAN_TYPE, this.anti_plan_type);     // Catch: Throwable -> L6
        r100.put("error_code", String.valueOf(this.error_code));     // Catch: Throwable -> L6
        r100.put("error_msg", this.error_msg);     // Catch: Throwable -> L6
        r100.put(KEY_REAL_DEVICE_PLAN, this.real_device_plan);     // Catch: Throwable -> L6
        r100.put("device_plans", this.device_plans);     // Catch: Throwable -> L6
        return;
    }
}
