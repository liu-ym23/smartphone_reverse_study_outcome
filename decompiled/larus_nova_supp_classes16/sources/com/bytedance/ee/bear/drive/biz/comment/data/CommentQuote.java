package com.bytedance.ee.bear.drive.biz.comment.data;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CommentQuote implements NonProguard {
    private String key;
    private String[] params;

    public CommentQuote() {
    }

    public String getKey() {
        return this.key;
    }

    public String[] getParams() {
        return this.params;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setParams(String[] r1) {
        this.params = r1;
    }

    public CommentQuote(String r1, String[] r2) {
        this.key = r1;
        this.params = r2;
    }
}
