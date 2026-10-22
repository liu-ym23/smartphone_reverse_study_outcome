package com.bytedance.ee.bear.bitable.homepage.activity;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/Content;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "commentContentFeedDefault", "", "getCommentContentFeedDefault", "()Ljava/lang/String;", "setCommentContentFeedDefault", "(Ljava/lang/String;)V", "commentContentFeed", "getCommentContentFeed", "setCommentContentFeed", "commentOwnerNameDefault", "getCommentOwnerNameDefault", "setCommentOwnerNameDefault", "commentOwnerName", "getCommentOwnerName", "setCommentOwnerName", "commentOwnerId", "getCommentOwnerId", "setCommentOwnerId", "commentId", "getCommentId", "setCommentId", "picturesDefault", "getPicturesDefault", "setPicturesDefault", NoticeInfo.KEY_PICTURES, "getPictures", "setPictures", "replyId", "getReplyId", "setReplyId", "reactionKey", "getReactionKey", "setReactionKey", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Content implements NonProguard {
    private String commentContentFeed;
    private String commentContentFeedDefault;
    private String commentId;
    private String commentOwnerId;
    private String commentOwnerName;
    private String commentOwnerNameDefault;
    private String pictures;
    private String picturesDefault;
    private String reactionKey;
    private String replyId;

    public Content() {
        this.commentContentFeedDefault = "";
        this.commentContentFeed = "";
        this.commentOwnerNameDefault = "";
        this.commentOwnerName = "";
        this.commentOwnerId = "";
        this.commentId = "";
        this.picturesDefault = "";
        this.pictures = "";
        this.replyId = "";
        this.reactionKey = "";
    }

    public final String getCommentContentFeed() {
        return this.commentContentFeed;
    }

    public final String getCommentContentFeedDefault() {
        return this.commentContentFeedDefault;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getCommentOwnerId() {
        return this.commentOwnerId;
    }

    public final String getCommentOwnerName() {
        return this.commentOwnerName;
    }

    public final String getCommentOwnerNameDefault() {
        return this.commentOwnerNameDefault;
    }

    public final String getPictures() {
        return this.pictures;
    }

    public final String getPicturesDefault() {
        return this.picturesDefault;
    }

    public final String getReactionKey() {
        return this.reactionKey;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final void setCommentContentFeed(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentContentFeed = r100;
    }

    public final void setCommentContentFeedDefault(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentContentFeedDefault = r100;
    }

    public final void setCommentId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentId = r100;
    }

    public final void setCommentOwnerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentOwnerId = r100;
    }

    public final void setCommentOwnerName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentOwnerName = r100;
    }

    public final void setCommentOwnerNameDefault(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentOwnerNameDefault = r100;
    }

    public final void setPictures(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pictures = r100;
    }

    public final void setPicturesDefault(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picturesDefault = r100;
    }

    public final void setReactionKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reactionKey = r100;
    }

    public final void setReplyId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.replyId = r100;
    }
}
