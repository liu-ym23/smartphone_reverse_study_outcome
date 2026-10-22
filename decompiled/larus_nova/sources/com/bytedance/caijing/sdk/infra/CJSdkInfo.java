package com.bytedance.caijing.sdk.infra;

import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class CJSdkInfo {
    public CJSdkInfo() {
    }

    public static JSONObject getInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("cjpay_build_ts", "0");     // Catch: JSONException -> L5
        r100.put("cjpay_sdk_ver", CJEnv.k());     // Catch: JSONException -> L5
    L4:
        return r100;
    }
}
