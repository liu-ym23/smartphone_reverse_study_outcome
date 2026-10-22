package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SmartReplyDataForInsert implements NonProguard {
    private String aiReplyId;
    private String commentId;
    private String replyId;
    private String text;

    public SmartReplyDataForInsert() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.text, this.commentId, this.replyId, this.aiReplyId});
    }

    public String toString() {
        return "SmartReplyDataForInsert{text='" + this.text + "', commentId='" + this.commentId + "', replyId='" + this.replyId + "', aiReplyId='" + this.aiReplyId + "'}";
    }

    public String getAiReplyId() {
        return this.aiReplyId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public String getText() {
        return this.text;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (getClass() != r4.getClass()) goto L22;
        SmartReplyDataForInsert r5 = (SmartReplyDataForInsert) r4;
        if (Objects.equals(this.text, r5.text) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(this.commentId, r5.commentId) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.replyId, r5.replyId) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.aiReplyId, r5.aiReplyId) == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public void setAiReplyId(String r1) {
        this.aiReplyId = r1;
    }

    public void setCommentId(String r1) {
        this.commentId = r1;
    }

    public void setReplyId(String r1) {
        this.replyId = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }
}
