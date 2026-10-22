package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SyncReactionResultJsData implements NonProguard {
    private String actionId;
    private int code;
    private String commentId;
    private String reactionKey;
    private String replyId;

    public SyncReactionResultJsData() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.commentId, this.replyId, this.reactionKey, this.actionId, Integer.valueOf(this.code)});
    }

    public String toString() {
        return "SyncReactionResultJsData{commentId='" + this.commentId + "', replyId='" + this.replyId + "', reactionKey='" + this.reactionKey + "', actionId='" + this.actionId + "', code=" + this.code + '}';
    }

    public String getActionId() {
        return this.actionId;
    }

    public int getCode() {
        return this.code;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (getClass() != r4.getClass()) goto L25;
        SyncReactionResultJsData r5 = (SyncReactionResultJsData) r4;
        if (this.code == r5.code) goto L10;
        return false;
    L10:
        if (Objects.equals(this.commentId, r5.commentId) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.replyId, r5.replyId) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.reactionKey, r5.reactionKey) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(this.actionId, r5.actionId) == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public void setActionId(String r1) {
        this.actionId = r1;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setCommentId(String r1) {
        this.commentId = r1;
    }

    public void setReactionKey(String r1) {
        this.reactionKey = r1;
    }

    public void setReplyId(String r1) {
        this.replyId = r1;
    }
}
