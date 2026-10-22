package com.bytedance.ee.bear.drive.biz.preview.vc.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/vc/model/CommentImagePreview;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "replyId", "getReplyId", "setReplyId", "imageIndex", "", "getImageIndex", "()I", "setImageIndex", "(I)V", "isGlobal", "", "()Z", "setGlobal", "(Z)V", "toString", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentImagePreview implements NonProguard {

    @SerializedName("commentId")
    @JSONField(name = "commentId")
    private String commentId;

    @SerializedName("imageIndex")
    @JSONField(name = "imageIndex")
    private int imageIndex;

    @SerializedName("isGlobal")
    @JSONField(name = "isGlobal")
    private boolean isGlobal;

    @SerializedName("replyId")
    @JSONField(name = "replyId")
    private String replyId;

    public CommentImagePreview() {
    }

    public String toString() {
        return "CommentImagePreview@" + hashCode() + "{commentId: " + this.commentId + ", replyId: " + this.replyId + ", imageIndex: " + this.imageIndex + ", isGlobal: " + this.isGlobal + '}';
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final int getImageIndex() {
        return this.imageIndex;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final boolean isGlobal() {
        return this.isGlobal;
    }

    public final void setCommentId(String r100) {
        this.commentId = r100;
    }

    public final void setGlobal(boolean r100) {
        this.isGlobal = r100;
    }

    public final void setImageIndex(int r100) {
        this.imageIndex = r100;
    }

    public final void setReplyId(String r100) {
        this.replyId = r100;
    }
}
