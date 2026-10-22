package com.bytedance.ee.bear.document.offline.base;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.u.i;
import java.io.Serializable;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class OfflineResultModel implements Serializable {
    private int code;
    private String data;
    private boolean isDataJsonInvalid;
    private String message;
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

    public String printAndGetFieldsLengthInfo(String r100) {
        StringBuilder r101 = new StringBuilder("code: ");
        r101.append(this.code);
        r101.append("--message length: ");
        String r102 = this.message;
        int r103 = 0;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        int r104 = 0;
    L6:
        r101.append(r104);
        r101.append("--data length: ");
        String r105 = this.data;
        if (TextUtils.isEmpty(r105) == false) goto L9;
        int r106 = 0;
    L10:
        r101.append(r106);
        r101.append("--url length: ");
        String r107 = this.url;
        if (TextUtils.isEmpty(r107) == true) goto L14;
        r103 = r107.length();
    L14:
        r101.append(r103);
        String r108 = r101.toString();
        a.h(r100, r108);
        return r108;
    L9:
        r106 = r105.length();
        goto L10
    L5:
        r104 = r102.length();
        goto L6
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
