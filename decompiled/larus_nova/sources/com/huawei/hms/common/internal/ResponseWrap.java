package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ResponseWrap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ResponseHeader f277118b;

    public String getBody() {
        if (TextUtils.isEmpty(this.f277117a) == false) goto L6;
        this.f277117a = new JSONObject().toString();
    L6:
        return this.f277117a;
    }

    public String toJson() {
        if (this.f277118b != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        JSONObject r100 = new JSONObject();
        r100.put("status_code", this.f277118b.getStatusCode());     // Catch: JSONException -> L14
        r100.put("error_code", this.f277118b.getErrorCode());     // Catch: JSONException -> L14
        r100.put("error_reason", this.f277118b.getErrorReason());     // Catch: JSONException -> L14
        r100.put("srv_name", this.f277118b.getSrvName());     // Catch: JSONException -> L14
        r100.put("api_name", this.f277118b.getApiName());     // Catch: JSONException -> L14
        r100.put("app_id", this.f277118b.getAppID());     // Catch: JSONException -> L14
        r100.put("pkg_name", this.f277118b.getPkgName());     // Catch: JSONException -> L14
        r100.put(CommonCode.MapKey.TRANSACTION_ID, this.f277118b.getTransactionId());     // Catch: JSONException -> L14
        r100.put("resolution", this.f277118b.getResolution());     // Catch: JSONException -> L14
        String r101 = this.f277118b.getSessionId();     // Catch: JSONException -> L14
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r100.put("session_id", r101);     // Catch: JSONException -> L14
    L11:
        if (TextUtils.isEmpty(this.f277117a) == true) goto L17;
        r100.put(ContainerPosition.BODY, this.f277117a);     // Catch: JSONException -> L14
    L17:
        return r100.toString();
    L14:
        e = move-exception;
        HMSLog.e("ResponseWrap", "toJson failed: " + e.getMessage());
        goto L17
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f277117a + "', responseHeader=" + this.f277118b + '}';
    }

    public ResponseHeader getResponseHeader() {
        return this.f277118b;
    }

    public ResponseWrap(ResponseHeader r100) {
        this.f277118b = r100;
    }

    public boolean fromJson(String r100) {
        if (this.f277118b != null) goto L11;
        return false;
    L11:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L8
        this.f277118b.setStatusCode(JsonUtil.getIntValue(r101, "status_code"));     // Catch: JSONException -> L8
        this.f277118b.setErrorCode(JsonUtil.getIntValue(r101, "error_code"));     // Catch: JSONException -> L8
        this.f277118b.setErrorReason(JsonUtil.getStringValue(r101, "error_reason"));     // Catch: JSONException -> L8
        this.f277118b.setSrvName(JsonUtil.getStringValue(r101, "srv_name"));     // Catch: JSONException -> L8
        this.f277118b.setApiName(JsonUtil.getStringValue(r101, "api_name"));     // Catch: JSONException -> L8
        this.f277118b.setAppID(JsonUtil.getStringValue(r101, "app_id"));     // Catch: JSONException -> L8
        this.f277118b.setPkgName(JsonUtil.getStringValue(r101, "pkg_name"));     // Catch: JSONException -> L8
        this.f277118b.setSessionId(JsonUtil.getStringValue(r101, "session_id"));     // Catch: JSONException -> L8
        this.f277118b.setTransactionId(JsonUtil.getStringValue(r101, CommonCode.MapKey.TRANSACTION_ID));     // Catch: JSONException -> L8
        this.f277118b.setResolution(JsonUtil.getStringValue(r101, "resolution"));     // Catch: JSONException -> L8
        this.f277117a = JsonUtil.getStringValue(r101, ContainerPosition.BODY);     // Catch: JSONException -> L8
        return true;
    L8:
        e = move-exception;
        HMSLog.e("ResponseWrap", "fromJson failed: " + e.getMessage());
        return false;
    }

    public void setBody(String r100) {
        this.f277117a = r100;
    }

    public void setResponseHeader(ResponseHeader r100) {
        this.f277118b = r100;
    }
}
