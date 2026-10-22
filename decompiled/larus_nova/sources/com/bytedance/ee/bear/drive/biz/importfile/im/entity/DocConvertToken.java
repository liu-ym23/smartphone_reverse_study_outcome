package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class DocConvertToken implements Serializable {
    private String chatToken;
    private String token;

    public String getChatToken() {
        return this.chatToken;
    }

    public String getToken() {
        return this.token;
    }

    public DocConvertToken(String r100, String r101) {
        this.token = r100;
        this.chatToken = r101;
    }
}
