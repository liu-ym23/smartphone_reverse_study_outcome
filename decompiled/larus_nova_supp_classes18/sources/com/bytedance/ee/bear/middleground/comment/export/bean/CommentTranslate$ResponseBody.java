package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseBody;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "commentId", "getCommentId", "setCommentId", "replyId", "getReplyId", "setReplyId", "isWhole", "setWhole", "srcLanguage", "getSrcLanguage", "setSrcLanguage", "targetLanguage", "getTargetLanguage", "setTargetLanguage", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentTranslate$ResponseBody implements NonProguard {
    private int code;
    private String commentId;
    private int isWhole;
    private String msg;
    private String replyId;
    private String srcLanguage;
    private String targetLanguage;

    public CommentTranslate$ResponseBody() {
    }

    public final int getCode() {
        return this.code;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getSrcLanguage() {
        return this.srcLanguage;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final int isWhole() {
        return this.isWhole;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setCommentId(String r1) {
        this.commentId = r1;
    }

    public final void setMsg(String r1) {
        this.msg = r1;
    }

    public final void setReplyId(String r1) {
        this.replyId = r1;
    }

    public final void setSrcLanguage(String r1) {
        this.srcLanguage = r1;
    }

    public final void setTargetLanguage(String r1) {
        this.targetLanguage = r1;
    }

    public final void setWhole(int r1) {
        this.isWhole = r1;
    }
}
