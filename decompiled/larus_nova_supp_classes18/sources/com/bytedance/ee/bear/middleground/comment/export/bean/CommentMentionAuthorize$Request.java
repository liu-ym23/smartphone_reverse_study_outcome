package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setCallbackId(String r1) {
        this.callbackId = r1;
    }

    public void setNotify(boolean r1) {
        this.notify = r1;
    }

    public void setUserIds(List<String> r1) {
        this.userIds = r1;
    }
}
