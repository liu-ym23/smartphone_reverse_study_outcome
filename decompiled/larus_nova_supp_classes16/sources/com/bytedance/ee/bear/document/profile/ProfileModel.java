package com.bytedance.ee.bear.document.profile;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setConfirmText(String r1) {
        this.confirmText = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }
}
