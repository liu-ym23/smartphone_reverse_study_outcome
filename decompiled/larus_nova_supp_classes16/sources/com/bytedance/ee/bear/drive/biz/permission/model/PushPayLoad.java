package com.bytedance.ee.bear.drive.biz.permission.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PushPayLoad<DATA> implements Serializable {
    private String business;
    private DATA data;

    public PushPayLoad() {
    }

    public String getBusiness() {
        return this.business;
    }

    public DATA getData() {
        return this.data;
    }

    public void setBusiness(String r1) {
        this.business = r1;
    }

    public void setData(DATA r1) {
        this.data = r1;
    }
}
