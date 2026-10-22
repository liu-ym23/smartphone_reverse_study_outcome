package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DeleteImageData implements BaseJSModel {
    private boolean success;
    private String uuid;

    public DeleteImageData() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean r1) {
        this.success = r1;
    }

    public void setUuid(String r1) {
        this.uuid = r1;
    }
}
