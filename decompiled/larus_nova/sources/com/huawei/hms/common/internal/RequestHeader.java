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
public class RequestHeader implements IMessageEntity {
    private static final String TAG = "RequestHeader";

    @Packed
    private int apiLevel;

    @Packed
    private String api_name;

    @Packed
    private String app_id;

    @Packed
    private int kitSdkVersion;
    private Parcelable parcelable;

    @Packed
    private String pkg_name;

    @Packed
    private int sdk_version;

    @Packed
    private String session_id;

    @Packed
    private String srv_name;

    @Packed
    private String transaction_id;

    @Packed
    private String version;

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

    public String toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("version", this.version);     // Catch: JSONException -> L8
        r100.put("srv_name", this.srv_name);     // Catch: JSONException -> L8
        r100.put("api_name", this.api_name);     // Catch: JSONException -> L8
        r100.put("app_id", this.app_id);     // Catch: JSONException -> L8
        r100.put("pkg_name", this.pkg_name);     // Catch: JSONException -> L8
        r100.put("sdk_version", this.sdk_version);     // Catch: JSONException -> L8
        r100.put("kitSdkVersion", this.kitSdkVersion);     // Catch: JSONException -> L8
        r100.put("apiLevel", this.apiLevel);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(this.session_id) == true) goto L6;
        r100.put("session_id", this.session_id);     // Catch: JSONException -> L8
    L6:
        r100.put(CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);     // Catch: JSONException -> L8
    L11:
        return r100.toString();
    L8:
        e = move-exception;
        HMSLog.e(TAG, "toJson failed: " + e.getMessage());
        goto L11
    }

    public String toString() {
        return "api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", sdk_version:" + this.sdk_version + ", session_id:*, transaction_id:" + this.transaction_id + ", kitSdkVersion:" + this.kitSdkVersion + ", apiLevel:" + this.apiLevel;
    }

    public RequestHeader() {
        this.app_id = "";
        this.version = "4.0";
        this.sdk_version = 61300301;
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    public int getKitSdkVersion() {
        return this.kitSdkVersion;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    public int getSdkVersion() {
        return this.sdk_version;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    public String getTransactionId() {
        return this.transaction_id;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean fromJson(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L5
        this.version = JsonUtil.getStringValue(r101, "version");     // Catch: JSONException -> L5
        this.srv_name = JsonUtil.getStringValue(r101, "srv_name");     // Catch: JSONException -> L5
        this.api_name = JsonUtil.getStringValue(r101, "api_name");     // Catch: JSONException -> L5
        this.app_id = JsonUtil.getStringValue(r101, "app_id");     // Catch: JSONException -> L5
        this.pkg_name = JsonUtil.getStringValue(r101, "pkg_name");     // Catch: JSONException -> L5
        this.sdk_version = JsonUtil.getIntValue(r101, "sdk_version");     // Catch: JSONException -> L5
        this.kitSdkVersion = JsonUtil.getIntValue(r101, "kitSdkVersion");     // Catch: JSONException -> L5
        this.apiLevel = JsonUtil.getIntValue(r101, "apiLevel");     // Catch: JSONException -> L5
        this.session_id = JsonUtil.getStringValue(r101, "session_id");     // Catch: JSONException -> L5
        this.transaction_id = JsonUtil.getStringValue(r101, CommonCode.MapKey.TRANSACTION_ID);     // Catch: JSONException -> L5
        return true;
    L5:
        e = move-exception;
        HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
        return false;
    }

    public void setApiLevel(int r100) {
        this.apiLevel = r100;
    }

    public void setApiName(String r100) {
        this.api_name = r100;
    }

    public void setAppID(String r100) {
        this.app_id = r100;
    }

    public void setKitSdkVersion(int r100) {
        this.kitSdkVersion = r100;
    }

    public void setParcelable(Parcelable r100) {
        this.parcelable = r100;
    }

    public void setPkgName(String r100) {
        this.pkg_name = r100;
    }

    public void setSdkVersion(int r100) {
        this.sdk_version = r100;
    }

    public void setSessionId(String r100) {
        this.session_id = r100;
    }

    public void setSrvName(String r100) {
        this.srv_name = r100;
    }

    public void setTransactionId(String r100) {
        this.transaction_id = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
