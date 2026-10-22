package com.bytedance.ee.bear.document.offline.base.datapage;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import g25.d;
import java.io.Serializable;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class OfflineResultModelV2 implements Serializable {
    private String batchNumber;
    private int code;
    private String data;
    private String message;
    private int page;
    private int totalPage;
    private String url;

    public String toString() {
        StringBuilder r100 = new StringBuilder("{\"code\": ");
        r100.append(this.code);
        r100.append(",\"message\": \"");
        r100.append(this.message);
        r100.append("\",\"url\": \"");
        r100.append(this.url);
        r100.append("\",\"page\": ");
        r100.append(this.page);
        r100.append(",\"totalPage\": ");
        r100.append(this.totalPage);
        r100.append(",\"batchNumber\": ");
        String r101 = "\"\"";
        if (TextUtils.isEmpty(this.batchNumber) == false) goto L5;
        String r102 = "\"\"";
    L6:
        r100.append(r102);
        r100.append(",\"data\": ");
        if (TextUtils.isEmpty(this.data) == true) goto L10;
        r101 = this.data;
    L10:
        r100.append(r101);
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        r102 = "\"" + this.batchNumber + "\"";
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

    public OfflineResultModelV2(d r100) {
        this.page = 0;
        this.totalPage = 1;
        this.code = r100.f479705a;
        this.message = r100.f479706b;
        this.data = r100.f479707c;
        this.page = r100.f479708d;
        this.totalPage = r100.f479709e;
        this.batchNumber = r100.f479710f;
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

    public void setBatchNumber(String r100) {
        this.batchNumber = r100;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setPage(int r100) {
        this.page = r100;
    }

    public void setTotalPage(int r100) {
        this.totalPage = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public OfflineResultModelV2(int r100, String r101, String r102, int r103) {
        this.totalPage = 1;
        this.code = r100;
        this.message = r101;
        this.data = r102;
        this.page = r103;
    }
}
