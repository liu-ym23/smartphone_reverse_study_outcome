package com.story.ai.biz.comment.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0000H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/story/ai/biz/comment/model/ExpandAndCollapseCommentItem;", "Lcom/story/ai/biz/comment/model/CommentSection;", "", "<init>", "()V", "parentCommentItem", "Lcom/story/ai/biz/comment/model/CommentListItem;", "getParentCommentItem", "()Lcom/story/ai/biz/comment/model/CommentListItem;", "setParentCommentItem", "(Lcom/story/ai/biz/comment/model/CommentListItem;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "state", "Lcom/story/ai/biz/comment/model/ExpandAndCollapseCommentItem$State;", "getState", "()Lcom/story/ai/biz/comment/model/ExpandAndCollapseCommentItem$State;", "setState", "(Lcom/story/ai/biz/comment/model/ExpandAndCollapseCommentItem$State;)V", "getCommentItemType", "Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "clone", "State", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpandAndCollapseCommentItem implements CommentSection, Cloneable {
    private String content;
    private CommentListItem parentCommentItem;
    private State state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/story/ai/biz/comment/model/ExpandAndCollapseCommentItem$State;", "", "<init>", "(Ljava/lang/String;I)V", "EXPAND_WITH_COUNT", "EXPAND_AND_COLLAPSE", "COLLAPSE", "LOADING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COLLAPSE = null;
        public static final State EXPAND_AND_COLLAPSE = null;
        public static final State EXPAND_WITH_COUNT = null;
        public static final State LOADING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f459899a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f459900b = null;

        public static EnumEntries<State> getEntries() {
            return f459900b;
        }

        static {
            State r100 = new State("EXPAND_WITH_COUNT", 0);
            EXPAND_WITH_COUNT = r100;
            State r101 = new State("EXPAND_AND_COLLAPSE", 1);
            EXPAND_AND_COLLAPSE = r101;
            State r102 = new State("COLLAPSE", 2);
            COLLAPSE = r102;
            State r103 = new State("LOADING", 3);
            LOADING = r103;
            State[] r104 = {r100, r101, r102, r103};
            f459899a = r104;
            f459900b = EnumEntriesKt.enumEntries(r104);
        }

        public static State[] values() {
            return (State[]) f459899a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ExpandAndCollapseCommentItem() {
        this.content = "";
        this.state = State.EXPAND_WITH_COUNT;
    }

    public ExpandAndCollapseCommentItem clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.story.ai.biz.comment.model.ExpandAndCollapseCommentItem");
        return (ExpandAndCollapseCommentItem) r100;
    }

    @Override // com.story.ai.biz.comment.model.CommentSection
    public boolean isLoadingOrEmptyOrFail() {
        return CommentSection.a.a(this);
    }

    @Override // com.story.ai.biz.comment.model.CommentSection
    public CommentSection.CommentItemType getCommentItemType() {
        return CommentSection.CommentItemType.EXPAND_COLLAPSE_COMMENT;
    }

    public final String getContent() {
        return this.content;
    }

    public final CommentListItem getParentCommentItem() {
        return this.parentCommentItem;
    }

    public final State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8715clone() {
        return clone();
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setParentCommentItem(CommentListItem r100) {
        this.parentCommentItem = r100;
    }

    public final void setState(State r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }
}
