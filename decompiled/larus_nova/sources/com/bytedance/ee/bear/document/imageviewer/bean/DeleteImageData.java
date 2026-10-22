package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setSuccess(boolean r100) {
        this.success = r100;
    }

    public void setUuid(String r100) {
        this.uuid = r100;
    }
}
