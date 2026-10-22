package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfflineResultModel implements Serializable {
    private static final int OFFLINE_SET_FAIL = 1;
    private static final int OFFLINE_SET_SUCCEESS = 0;

    @SerializedName("code")
    private int code;

    @SerializedName(WikiFolderPushPlugin.DATA)
    private String data;

    @SerializedName("isDataJsonInvalid")
    private boolean isDataJsonInvalid;

    @SerializedName("message")
    private String message;

    @SerializedName(ResourceData.KEY_URL)
    private String url;

    public String toString() {
        if (this.isDataJsonInvalid == true) goto L5;
        StringBuilder r0 = new StringBuilder("{\"code\": ");
        r0.append(this.code);
        r0.append(",\"message\": \"");
        r0.append(this.message);
        r0.append("\",\"url\": \"");
        r0.append(this.url);
        r0.append("\",\"data\": ");
        if (TextUtils.isEmpty(this.data) == false) goto L9;
        String r1 = "\"\"";
    L10:
        r0.append(r1);
        r0.append("}");
        return r0.toString();
    L9:
        r1 = this.data;
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

    private int getFieldLength(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return 0;
    L6:
        return r2.length();
    }

    public String printAndGetFieldsLengthInfo(String r3) {
        String r0 = "code: " + this.code + "--message length: " + getFieldLength(this.message) + "--data length: " + getFieldLength(this.data) + "--url length: " + getFieldLength(this.url);
        Log.i(r3, r0);
        return r0;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setDataJsonInvalid(boolean r1) {
        this.isDataJsonInvalid = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public OfflineResultModel(boolean r1, String r2, String r3) {
        this.code = !r1 ? 1 : 0;
        this.message = r2;
        this.data = r3;
    }

    public OfflineResultModel(int r1, String r2, String r3) {
        this.code = r1;
        this.message = r2;
        this.data = r3;
    }
}
