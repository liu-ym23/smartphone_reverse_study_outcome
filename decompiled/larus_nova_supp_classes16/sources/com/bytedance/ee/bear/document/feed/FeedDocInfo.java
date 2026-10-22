package com.bytedance.ee.bear.document.feed;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FeedDocInfo implements Serializable {
    private boolean isOwner;

    public FeedDocInfo() {
    }

    public boolean isIsOwner() {
        return this.isOwner;
    }

    public void setIsOwner(boolean r1) {
        this.isOwner = r1;
    }
}
