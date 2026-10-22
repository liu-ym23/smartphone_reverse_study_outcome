package com.bytedance.ee.bear.document.feed;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ReadMessageBean implements NonProguard {
    private List<String> messageIds;

    public ReadMessageBean() {
    }

    public String toString() {
        return "ReadMessageBean{messageIds=" + this.messageIds + '}';
    }

    public List<String> getMessageIds() {
        return this.messageIds;
    }

    public void setMessageIds(List<String> r100) {
        this.messageIds = r100;
    }
}
