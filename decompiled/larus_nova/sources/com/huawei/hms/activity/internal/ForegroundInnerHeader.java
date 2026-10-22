package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ForegroundInnerHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f276864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f276865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f276866c;

    public ForegroundInnerHeader() {
    }

    public String toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("apkVersion", this.f276864a);     // Catch: JSONException -> L5
        r100.put("action", this.f276865b);     // Catch: JSONException -> L5
        r100.put("responseCallbackKey", this.f276866c);     // Catch: JSONException -> L5
    L8:
        return r100.toString();
    L5:
        e = move-exception;
        HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e.getMessage());
        goto L8
    }

    public String toString() {
        return "apkVersion:" + this.f276864a + ", action:" + this.f276865b + ", responseCallbackKey:" + this.f276866c;
    }

    public String getAction() {
        return this.f276865b;
    }

    public int getApkVersion() {
        return this.f276864a;
    }

    public String getResponseCallbackKey() {
        return this.f276866c;
    }

    public void fromJson(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L4
        this.f276864a = JsonUtil.getIntValue(r101, "apkVersion");     // Catch: JSONException -> L4
        this.f276865b = JsonUtil.getStringValue(r101, "action");     // Catch: JSONException -> L4
        this.f276866c = JsonUtil.getStringValue(r101, "responseCallbackKey");     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e.getMessage());
    }

    public void setAction(String r100) {
        this.f276865b = r100;
    }

    public void setApkVersion(int r100) {
        this.f276864a = r100;
    }

    public void setResponseCallbackKey(String r100) {
        this.f276866c = r100;
    }
}
