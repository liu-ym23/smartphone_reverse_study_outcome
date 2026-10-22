package com.bytedance.ee.bear.bitable.itemview.recordpages;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/OpenCommentData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "activeCommentId", "", "getActiveCommentId", "()Ljava/lang/String;", "setActiveCommentId", "(Ljava/lang/String;)V", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "openDiscussPanelType", "getOpenDiscussPanelType", "setOpenDiscussPanelType", "replyId", "getReplyId", "setReplyId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenCommentData implements NonProguard {
    private String activeCommentId;
    private int commentType;
    private int openDiscussPanelType;
    private String replyId;

    public OpenCommentData() {
    }

    public final String getActiveCommentId() {
        return this.activeCommentId;
    }

    public final int getCommentType() {
        return this.commentType;
    }

    public final int getOpenDiscussPanelType() {
        return this.openDiscussPanelType;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final void setActiveCommentId(String r100) {
        this.activeCommentId = r100;
    }

    public final void setCommentType(int r100) {
        this.commentType = r100;
    }

    public final void setOpenDiscussPanelType(int r100) {
        this.openDiscussPanelType = r100;
    }

    public final void setReplyId(String r100) {
        this.replyId = r100;
    }
}
