package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocConvertToken implements Serializable {
    private String chatToken;
    private String token;

    public String getChatToken() {
        return this.chatToken;
    }

    public String getToken() {
        return this.token;
    }

    public DocConvertToken(String r1, String r2) {
        this.token = r1;
        this.chatToken = r2;
    }
}
