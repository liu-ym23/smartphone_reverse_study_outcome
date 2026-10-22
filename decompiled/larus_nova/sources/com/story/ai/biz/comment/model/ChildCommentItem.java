package com.story.ai.biz.comment.model;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.platform.model.comment.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/story/ai/biz/comment/model/ChildCommentItem;", "Lcom/story/ai/biz/comment/model/BaseComment;", "", "<init>", "()V", "parentCommentItem", "Lcom/story/ai/biz/comment/model/CommentListItem;", "getParentCommentItem", "()Lcom/story/ai/biz/comment/model/CommentListItem;", "setParentCommentItem", "(Lcom/story/ai/biz/comment/model/CommentListItem;)V", IPerformanceManager.SCENE_RESIDENT, "", "getResident", "()Z", "setResident", "(Z)V", "replyCommentUserInfo", "Lcom/larus/platform/model/comment/UserInfo;", "getReplyCommentUserInfo", "()Lcom/larus/platform/model/comment/UserInfo;", "setReplyCommentUserInfo", "(Lcom/larus/platform/model/comment/UserInfo;)V", "isReplyParentComment", "setReplyParentComment", "realCreatorId", "", "getRealCreatorId", "()Ljava/lang/String;", "setRealCreatorId", "(Ljava/lang/String;)V", "getCommentItemType", "Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "clone", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChildCommentItem extends BaseComment implements Cloneable {
    private boolean isReplyParentComment;
    private CommentListItem parentCommentItem;
    private String realCreatorId;
    private UserInfo replyCommentUserInfo;
    private boolean resident;

    public ChildCommentItem clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.story.ai.biz.comment.model.ChildCommentItem");
        return (ChildCommentItem) r100;
    }

    public ChildCommentItem() {
    }

    @Override // com.story.ai.biz.comment.model.BaseComment, com.story.ai.biz.comment.model.CommentSection
    public CommentSection.CommentItemType getCommentItemType() {
        return CommentSection.CommentItemType.CHILD_COMMENT;
    }

    public final CommentListItem getParentCommentItem() {
        return this.parentCommentItem;
    }

    public final String getRealCreatorId() {
        return this.realCreatorId;
    }

    public final UserInfo getReplyCommentUserInfo() {
        return this.replyCommentUserInfo;
    }

    public final boolean getResident() {
        return this.resident;
    }

    public final boolean isReplyParentComment() {
        return this.isReplyParentComment;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8710clone() {
        return clone();
    }

    public final void setParentCommentItem(CommentListItem r100) {
        this.parentCommentItem = r100;
    }

    public final void setRealCreatorId(String r100) {
        this.realCreatorId = r100;
    }

    public final void setReplyCommentUserInfo(UserInfo r100) {
        this.replyCommentUserInfo = r100;
    }

    public final void setReplyParentComment(boolean r100) {
        this.isReplyParentComment = r100;
    }

    public final void setResident(boolean r100) {
        this.resident = r100;
    }
}
