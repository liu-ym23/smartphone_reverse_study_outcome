package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SendCommentResult implements NonProguard {
    private String comment_uuid;
    private String fail_reason;
    private String reply_uuid;
    private String res;

    public SendCommentResult() {
    }

    public String toString() {
        return "SendCommentResult{res='" + this.res + "', fail_reason='" + this.fail_reason + "', reply_uuid='" + this.reply_uuid + "', comment_uuid='" + this.comment_uuid + "'}";
    }

    public String getCommentUuid() {
        return this.comment_uuid;
    }

    public String getFailReason() {
        return this.fail_reason;
    }

    public String getReplyUuid() {
        return this.reply_uuid;
    }

    public String getRes() {
        return this.res;
    }

    public void setCommentUuid(String r1) {
        this.comment_uuid = r1;
    }

    public void setFailReason(String r1) {
        this.fail_reason = r1;
    }

    public void setReplyUuid(String r1) {
        this.reply_uuid = r1;
    }

    public void setRes(String r1) {
        this.res = r1;
    }
}
