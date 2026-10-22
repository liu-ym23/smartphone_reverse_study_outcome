package com.bytedance.ee.bear.document.sendtoim;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SendToImBean implements NonProguard {
    private String url;

    public SendToImBean() {
    }

    public String toString() {
        return "SendToImBean{url=" + b.f(this.url) + '}';
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
