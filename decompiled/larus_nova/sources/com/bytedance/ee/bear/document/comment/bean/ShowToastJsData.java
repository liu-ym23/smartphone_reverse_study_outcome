package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setAction(String r100) {
        this.action = r100;
    }

    public void setButtonMessage(String r100) {
        this.buttonMessage = r100;
    }

    public void setCommentId(String r100) {
        this.commentId = r100;
    }

    public void setCommentType(int r100) {
        this.commentType = r100;
    }

    public void setCommentUUID(String r100) {
        this.commentUUID = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setReplyId(String r100) {
        this.replyId = r100;
    }

    public void setReplyUUID(String r100) {
        this.replyUUID = r100;
    }
}
