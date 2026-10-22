package com.story.ai.biz.comment.model;

import com.larus.platform.model.comment.CommentInfo;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010 \u001a\u0004\u0018\u00010\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0006\u0010\u001c\u001a\u00020$J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/story/ai/biz/comment/model/CommentListItem;", "Lcom/story/ai/biz/comment/model/BaseComment;", "", "<init>", "()V", "childCommentCount", "", "getChildCommentCount", "()J", "setChildCommentCount", "(J)V", "defaultShowCount", "getDefaultShowCount", "setDefaultShowCount", "hasMoreChildren", "", "getHasMoreChildren", "()Z", "setHasMoreChildren", "(Z)V", "offset", "", "getOffset", "()Ljava/lang/String;", "setOffset", "(Ljava/lang/String;)V", "lastDefaultShowChildComment", "Lcom/story/ai/biz/comment/model/ChildCommentItem;", "getLastDefaultShowChildComment", "()Lcom/story/ai/biz/comment/model/ChildCommentItem;", "setLastDefaultShowChildComment", "(Lcom/story/ai/biz/comment/model/ChildCommentItem;)V", "getLastShowComment", "commentList", "", "Lcom/story/ai/biz/comment/model/CommentSection;", "", "getCommentItemType", "Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "clone", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentListItem extends BaseComment implements Cloneable {
    private long childCommentCount;
    private long defaultShowCount;
    private boolean hasMoreChildren;
    private ChildCommentItem lastDefaultShowChildComment;
    private String offset;

    /* JADX INFO: renamed from: getLastDefaultShowChildComment, reason: collision with other method in class */
    public final Object m8713getLastDefaultShowChildComment() {
        ChildCommentItem r100 = this.lastDefaultShowChildComment;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this;
    }

    public CommentListItem clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.story.ai.biz.comment.model.CommentListItem");
        return (CommentListItem) r100;
    }

    public CommentListItem() {
    }

    public final long getChildCommentCount() {
        return this.childCommentCount;
    }

    @Override // com.story.ai.biz.comment.model.BaseComment, com.story.ai.biz.comment.model.CommentSection
    public CommentSection.CommentItemType getCommentItemType() {
        return CommentSection.CommentItemType.PARENT_COMMENT;
    }

    public final long getDefaultShowCount() {
        return this.defaultShowCount;
    }

    public final boolean getHasMoreChildren() {
        return this.hasMoreChildren;
    }

    public final String getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8712clone() {
        return clone();
    }

    public final ChildCommentItem getLastDefaultShowChildComment() {
        return this.lastDefaultShowChildComment;
    }

    public final BaseComment getLastShowComment(List<? extends CommentSection> r100) {
        Intrinsics.checkNotNullParameter(r100, "commentList");
        ListIterator<? extends CommentSection> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L30;
        CommentSection r102 = r101.previous();
        CommentSection r103 = r102;
        boolean r104 = true;
        if ((r103 instanceof ChildCommentItem) == false) goto L19;
        CommentListItem r105 = ((ChildCommentItem) r103).getParentCommentItem();
        if (r105 == null) goto L16;
        CommentInfo r106 = getCommentData();
        if (r106 == null) goto L12;
        String r107 = r106.c();
    L14:
        if (b.a(r105, r107) != true) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
    L28:
        if (r104 == false) goto L4;
    L32:
        if ((r102 instanceof BaseComment) == true) goto L34;
        return null;
    L34:
        return (BaseComment) r102;
    L12:
        r107 = null;
    L16:
        r108 = false;
    L19:
        if ((r103 instanceof CommentListItem) == false) goto L27;
        CommentInfo r109 = getCommentData();
        if (r109 == null) goto L23;
        String r110 = r109.c();
    L25:
        if (b.a(r103, r110) == false) goto L27;
    L23:
        r110 = null;
    L27:
        r104 = false;
        goto L28
    L30:
        r102 = null;
        goto L32
    }

    public final void setChildCommentCount(long r100) {
        this.childCommentCount = r100;
    }

    public final void setDefaultShowCount(long r100) {
        this.defaultShowCount = r100;
    }

    public final void setHasMoreChildren(boolean r100) {
        this.hasMoreChildren = r100;
    }

    public final void setLastDefaultShowChildComment(ChildCommentItem r100) {
        this.lastDefaultShowChildComment = r100;
    }

    public final void setOffset(String r100) {
        this.offset = r100;
    }
}
