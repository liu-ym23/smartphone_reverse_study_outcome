package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShowToastJsData extends ErrorBean implements NonProguard {
    private static final String TAG = "ShowToastJsData";
    private String action;
    private String buttonMessage;
    private String commentId;
    private int commentType;
    private String commentUUID;
    private String message;
    private String replyId;
    private String replyUUID;

    public ShowToastJsData() {
        this.commentType = 0;
    }

    public String getAction() {
        return this.action;
    }

    public String getButtonMessage() {
        return this.buttonMessage;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getCommentUUID() {
        return this.commentUUID;
    }

    public String getMessage() {
        return this.message;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public String getReplyUUID() {
        return this.replyUUID;
    }

    public void setAction(String r1) {
        this.action = r1;
    }

    public void setButtonMessage(String r1) {
        this.buttonMessage = r1;
    }

    public void setCommentId(String r1) {
        this.commentId = r1;
    }

    public void setCommentType(int r1) {
        this.commentType = r1;
    }

    public void setCommentUUID(String r1) {
        this.commentUUID = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setReplyId(String r1) {
        this.replyId = r1;
    }

    public void setReplyUUID(String r1) {
        this.replyUUID = r1;
    }
}
