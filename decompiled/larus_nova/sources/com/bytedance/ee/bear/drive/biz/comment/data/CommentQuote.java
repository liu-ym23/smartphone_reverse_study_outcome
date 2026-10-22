package com.bytedance.ee.bear.drive.biz.comment.data;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setParams(String[] r100) {
        this.params = r100;
    }

    public CommentQuote(String r100, String[] r101) {
        this.key = r100;
        this.params = r101;
    }
}
