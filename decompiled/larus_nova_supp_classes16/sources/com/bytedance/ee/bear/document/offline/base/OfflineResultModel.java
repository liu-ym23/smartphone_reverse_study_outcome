package com.bytedance.ee.bear.document.offline.base;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfflineResultModel implements Serializable {
    private int code;
    private String data;
    private boolean isDataJsonInvalid;
    private String message;
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
        return JSON.toJSONString(this);
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

    public String printAndGetFieldsLengthInfo(String r5) {
        StringBuilder r0 = new StringBuilder("code: ");
        r0.append(this.code);
        r0.append("--message length: ");
        String r1 = this.message;
        int r3 = 0;
        if (TextUtils.isEmpty(r1) == false) goto L5;
        int r2 = 0;
    L6:
        r0.append(r2);
        r0.append("--data length: ");
        String r4 = this.data;
        if (TextUtils.isEmpty(r4) == false) goto L9;
        int r6 = 0;
    L10:
        r0.append(r6);
        r0.append("--url length: ");
        String r7 = this.url;
        if (TextUtils.isEmpty(r7) == true) goto L14;
        r3 = r7.length();
    L14:
        r0.append(r3);
        String r8 = r0.toString();
        a.h(r5, r8);
        return r8;
    L9:
        r6 = r4.length();
        goto L10
    L5:
        r2 = r1.length();
        goto L6
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
