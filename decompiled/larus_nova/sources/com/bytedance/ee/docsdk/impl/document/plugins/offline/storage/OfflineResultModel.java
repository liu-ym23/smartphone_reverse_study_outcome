package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class OfflineResultModel implements Serializable {
    private static final int OFFLINE_SET_FAIL = 1;
    private static final int OFFLINE_SET_SUCCEESS = 0;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private String data;

    @SerializedName("isDataJsonInvalid")
    private boolean isDataJsonInvalid;

    @SerializedName("message")
    private String message;

    @SerializedName("url")
    private String url;

    public String toString() {
        if (this.isDataJsonInvalid == true) goto L5;
        StringBuilder r100 = new StringBuilder("{\"code\": ");
        r100.append(this.code);
        r100.append(",\"message\": \"");
        r100.append(this.message);
        r100.append("\",\"url\": \"");
        r100.append(this.url);
        r100.append("\",\"data\": ");
        if (TextUtils.isEmpty(this.data) == false) goto L9;
        String r101 = "\"\"";
    L10:
        r100.append(r101);
        r100.append(i.f25855d);
        return r100.toString();
    L9:
        r101 = this.data;
        goto L10
    L5:
        return JsonUtils.INSTANCE.toJsonString(this);
    }

    public OfflineResultModel() {
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDataJsonInvalid() {
        return this.isDataJsonInvalid;
    }

    private int getFieldLength(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0;
    L6:
        return r100.length();
    }

    public String printAndGetFieldsLengthInfo(String r100) {
        String r101 = "code: " + this.code + "--message length: " + getFieldLength(this.message) + "--data length: " + getFieldLength(this.data) + "--url length: " + getFieldLength(this.url);
        Log.i(r100, r101);
        return r101;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setDataJsonInvalid(boolean r100) {
        this.isDataJsonInvalid = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public OfflineResultModel(boolean r100, String r101, String r102) {
        this.code = !r100 ? 1 : 0;
        this.message = r101;
        this.data = r102;
    }

    public OfflineResultModel(int r100, String r101, String r102) {
        this.code = r100;
        this.message = r101;
        this.data = r102;
    }
}
