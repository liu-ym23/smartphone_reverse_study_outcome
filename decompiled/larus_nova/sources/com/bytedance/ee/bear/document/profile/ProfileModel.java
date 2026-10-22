package com.bytedance.ee.bear.document.profile;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class ProfileModel implements BaseJSModel {
    private String confirmText;
    private String content;
    private String userId;

    public String toString() {
        return "{userId='" + this.userId + "'}";
    }

    public ProfileModel() {
    }

    public String getConfirmText() {
        return this.confirmText;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setConfirmText(String r100) {
        this.confirmText = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }
}
