package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ResponseHeader implements IMessageEntity, ResponseErrorCode {
    private static final String TAG = "ResponseHeader";

    @Packed
    private String api_name;

    @Packed
    private String app_id;

    @Packed
    private int error_code;

    @Packed
    private String error_reason;
    private Parcelable parcelable;

    @Packed
    private String pkg_name;

    @Packed
    private String resolution;

    @Packed
    private String session_id;

    @Packed
    private String srv_name;

    @Packed
    private int status_code;

    @Packed
    private String transaction_id;

    public String getActualAppID() {
        if (TextUtils.isEmpty(this.app_id) == false) goto L5;
        return "";
    L5:
        String[] r100 = this.app_id.split("\\|");
        if (r100.length != 0) goto L9;
        return "";
    L9:
        if (r100.length != 1) goto L13;
        return r100[0];
    L13:
        return r100[1];
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public boolean hasResolution() {
        if (this.parcelable == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSuccess() {
        if (this.status_code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("status_code", this.status_code);     // Catch: JSONException -> L8
        r100.put("error_code", this.error_code);     // Catch: JSONException -> L8
        r100.put("error_reason", this.error_reason);     // Catch: JSONException -> L8
        r100.put("srv_name", this.srv_name);     // Catch: JSONException -> L8
        r100.put("api_name", this.api_name);     // Catch: JSONException -> L8
        r100.put("app_id", this.app_id);     // Catch: JSONException -> L8
        r100.put("pkg_name", this.pkg_name);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(this.session_id) == true) goto L6;
        r100.put("session_id", this.session_id);     // Catch: JSONException -> L8
    L6:
        r100.put(CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);     // Catch: JSONException -> L8
        r100.put("resolution", this.resolution);     // Catch: JSONException -> L8
    L11:
        return r100.toString();
    L8:
        e = move-exception;
        HMSLog.e(TAG, "toJson failed: " + e.getMessage());
        goto L11
    }

    public String toString() {
        return "status_code:" + this.status_code + ", error_code:" + this.error_code + ", api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", session_id:*, transaction_id:" + this.transaction_id + ", resolution:" + this.resolution;
    }

    public ResponseHeader() {
        this.app_id = "";
    }

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getErrorCode() {
        return this.error_code;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getErrorReason() {
        return this.error_reason;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getResolution() {
        return this.resolution;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getStatusCode() {
        return this.status_code;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getTransactionId() {
        return this.transaction_id;
    }

    public boolean fromJson(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L5
        this.status_code = JsonUtil.getIntValue(r101, "status_code");     // Catch: JSONException -> L5
        this.error_code = JsonUtil.getIntValue(r101, "error_code");     // Catch: JSONException -> L5
        this.error_reason = JsonUtil.getStringValue(r101, "error_reason");     // Catch: JSONException -> L5
        this.srv_name = JsonUtil.getStringValue(r101, "srv_name");     // Catch: JSONException -> L5
        this.api_name = JsonUtil.getStringValue(r101, "api_name");     // Catch: JSONException -> L5
        this.app_id = JsonUtil.getStringValue(r101, "app_id");     // Catch: JSONException -> L5
        this.pkg_name = JsonUtil.getStringValue(r101, "pkg_name");     // Catch: JSONException -> L5
        this.session_id = JsonUtil.getStringValue(r101, "session_id");     // Catch: JSONException -> L5
        this.transaction_id = JsonUtil.getStringValue(r101, CommonCode.MapKey.TRANSACTION_ID);     // Catch: JSONException -> L5
        this.resolution = JsonUtil.getStringValue(r101, "resolution");     // Catch: JSONException -> L5
        return true;
    L5:
        e = move-exception;
        HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
        return false;
    }

    public void setApiName(String r100) {
        this.api_name = r100;
    }

    public void setAppID(String r100) {
        this.app_id = r100;
    }

    public void setErrorCode(int r100) {
        this.error_code = r100;
    }

    public void setErrorReason(String r100) {
        this.error_reason = r100;
    }

    public void setParcelable(Parcelable r100) {
        this.parcelable = r100;
    }

    public void setPkgName(String r100) {
        this.pkg_name = r100;
    }

    public void setResolution(String r100) {
        this.resolution = r100;
    }

    public void setSessionId(String r100) {
        this.session_id = r100;
    }

    public void setSrvName(String r100) {
        this.srv_name = r100;
    }

    public void setStatusCode(int r100) {
        this.status_code = r100;
    }

    public void setTransactionId(String r100) {
        this.transaction_id = r100;
    }

    public ResponseHeader(int r100, int r101, String r102) {
        this.app_id = "";
        this.status_code = r100;
        this.error_code = r101;
        this.error_reason = r102;
    }
}
