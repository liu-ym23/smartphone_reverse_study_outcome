package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class CommentMentionAuthorize$Request implements NonProguard {
    private String callbackId;
    private boolean notify;
    private List<String> userIds;

    public CommentMentionAuthorize$Request() {
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public List<String> getUserIds() {
        return this.userIds;
    }

    public boolean isNotify() {
        return this.notify;
    }

    public void setCallbackId(String r100) {
        this.callbackId = r100;
    }

    public void setNotify(boolean r100) {
        this.notify = r100;
    }

    public void setUserIds(List<String> r100) {
        this.userIds = r100;
    }
}
