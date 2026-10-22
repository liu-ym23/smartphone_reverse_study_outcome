package com.bytedance.ee.bear.document.offline.base.datapage;

import android.text.TextUtils;
import g25.d;
import java.io.Serializable;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfflineResultModelV2 implements Serializable {
    private String batchNumber;
    private int code;
    private String data;
    private String message;
    private int page;
    private int totalPage;
    private String url;

    public String toString() {
        StringBuilder r0 = new StringBuilder("{\"code\": ");
        r0.append(this.code);
        r0.append(",\"message\": \"");
        r0.append(this.message);
        r0.append("\",\"url\": \"");
        r0.append(this.url);
        r0.append("\",\"page\": ");
        r0.append(this.page);
        r0.append(",\"totalPage\": ");
        r0.append(this.totalPage);
        r0.append(",\"batchNumber\": ");
        String r2 = "\"\"";
        if (TextUtils.isEmpty(this.batchNumber) == false) goto L5;
        String r1 = "\"\"";
    L6:
        r0.append(r1);
        r0.append(",\"data\": ");
        if (TextUtils.isEmpty(this.data) == true) goto L10;
        r2 = this.data;
    L10:
        r0.append(r2);
        r0.append("}");
        return r0.toString();
    L5:
        r1 = "\"" + this.batchNumber + "\"";
        goto L6
    }

    public OfflineResultModelV2() {
        this.page = 0;
        this.totalPage = 1;
    }

    public String getBatchNumber() {
        return this.batchNumber;
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

    public int getPage() {
        return this.page;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public String getUrl() {
        return this.url;
    }

    public OfflineResultModelV2(d r2) {
        this.page = 0;
        this.totalPage = 1;
        this.code = r2.a;
        this.message = r2.b;
        this.data = r2.c;
        this.page = r2.d;
        this.totalPage = r2.e;
        this.batchNumber = r2.f;
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

    public void setBatchNumber(String r1) {
        this.batchNumber = r1;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setPage(int r1) {
        this.page = r1;
    }

    public void setTotalPage(int r1) {
        this.totalPage = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public OfflineResultModelV2(int r2, String r3, String r4, int r5) {
        this.totalPage = 1;
        this.code = r2;
        this.message = r3;
        this.data = r4;
        this.page = r5;
    }
}
