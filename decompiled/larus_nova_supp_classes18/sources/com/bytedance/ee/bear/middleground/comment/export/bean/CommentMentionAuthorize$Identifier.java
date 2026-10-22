package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentMentionAuthorize$Identifier implements NonProguard {
    private String service;
    private String token;
    private int type;

    public CommentMentionAuthorize$Identifier() {
    }

    public String getService() {
        return this.service;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setService(String r1) {
        this.service = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
