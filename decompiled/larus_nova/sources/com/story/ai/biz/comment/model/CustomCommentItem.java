package com.story.ai.biz.comment.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0000H\u0016¨\u0006\b"}, d2 = {"Lcom/story/ai/biz/comment/model/CustomCommentItem;", "Lcom/story/ai/biz/comment/model/CommentSection;", "", "<init>", "()V", "getCommentItemType", "Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "clone", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomCommentItem implements CommentSection, Cloneable {
    public CustomCommentItem() {
    }

    public CustomCommentItem clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.story.ai.biz.comment.model.CustomCommentItem");
        return (CustomCommentItem) r100;
    }

    @Override // com.story.ai.biz.comment.model.CommentSection
    public boolean isLoadingOrEmptyOrFail() {
        return CommentSection.a.a(this);
    }

    @Override // com.story.ai.biz.comment.model.CommentSection
    public CommentSection.CommentItemType getCommentItemType() {
        return CommentSection.CommentItemType.CUSTOM;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8714clone() {
        return clone();
    }
}
