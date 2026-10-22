package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/FocusInputBean;", "Ljava/io/Serializable;", "<init>", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "replyId", "getReplyId", "setReplyId", ResourceData.KEY_TYPE, "", "getType", "()I", "setType", "(I)V", "from", "getFrom", "setFrom", "toString", "equals", "", "other", "", "hashCode", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusInputBean implements Serializable {
    private String commentId;
    private String from;
    private String replyId;
    private int type;

    public int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.commentId;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.replyId;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.from;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "FocusInputBean(commentId=" + du5.b.h(this.commentId) + ", replyId=" + du5.b.h(this.replyId) + ", type=" + this.type + ", from=" + this.from + ')';
    }

    public FocusInputBean() {
        this.type = 2;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final int getType() {
        return this.type;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(FocusInputBean.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean");
        FocusInputBean r6 = (FocusInputBean) r5;
        if (this.type == r6.type) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.commentId, r6.commentId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.replyId, r6.replyId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.from, r6.from) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setCommentId(String r1) {
        this.commentId = r1;
    }

    public final void setFrom(String r1) {
        this.from = r1;
    }

    public final void setReplyId(String r1) {
        this.replyId = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
