package com.story.ai.biz.comment.model;

import com.larus.platform.model.comment.CommentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0016J\u0006\u0010/\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000e¨\u00060"}, d2 = {"Lcom/story/ai/biz/comment/model/BaseComment;", "Lcom/story/ai/biz/comment/model/CommentSection;", "<init>", "()V", "commentData", "Lcom/larus/platform/model/comment/CommentInfo;", "getCommentData", "()Lcom/larus/platform/model/comment/CommentInfo;", "setCommentData", "(Lcom/larus/platform/model/comment/CommentInfo;)V", "isPin", "", "()Z", "setPin", "(Z)V", "isCreator", "setCreator", "isSelfComment", "setSelfComment", "showBgFlashing", "getShowBgFlashing", "setShowBgFlashing", "sendState", "Lcom/story/ai/biz/comment/model/CommentPublishState;", "getSendState", "()Lcom/story/ai/biz/comment/model/CommentPublishState;", "setSendState", "(Lcom/story/ai/biz/comment/model/CommentPublishState;)V", "initTime", "", "getInitTime", "()J", "setInitTime", "(J)V", "serverTimeDelta", "getServerTimeDelta", "setServerTimeDelta", "textExpandState", "", "getTextExpandState", "()I", "setTextExpandState", "(I)V", "isCacheData", "setCacheData", "getCommentItemType", "Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "isPublished", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseComment implements CommentSection {
    private CommentInfo commentData;
    private long initTime;
    private boolean isCacheData;
    private boolean isCreator;
    private boolean isPin;
    private boolean isSelfComment;
    private CommentPublishState sendState;
    private long serverTimeDelta;
    private boolean showBgFlashing;
    private int textExpandState;

    public final boolean isPublished() {
        if (this.sendState != CommentPublishState.SUCCESS) goto L5;
        return true;
    L5:
        return false;
    }

    public BaseComment() {
        this.sendState = CommentPublishState.SUCCESS;
        this.initTime = System.currentTimeMillis();
    }

    @Override // com.story.ai.biz.comment.model.CommentSection
    public boolean isLoadingOrEmptyOrFail() {
        return CommentSection.a.a(this);
    }

    public final CommentInfo getCommentData() {
        return this.commentData;
    }

    @Override // com.story.ai.biz.comment.model.CommentSection
    public CommentSection.CommentItemType getCommentItemType() {
        return CommentSection.CommentItemType.UNKNOWN;
    }

    public final long getInitTime() {
        return this.initTime;
    }

    public final CommentPublishState getSendState() {
        return this.sendState;
    }

    public final long getServerTimeDelta() {
        return this.serverTimeDelta;
    }

    public final boolean getShowBgFlashing() {
        return this.showBgFlashing;
    }

    public final int getTextExpandState() {
        return this.textExpandState;
    }

    public final boolean isCacheData() {
        return this.isCacheData;
    }

    public final boolean isCreator() {
        return this.isCreator;
    }

    public final boolean isPin() {
        return this.isPin;
    }

    public final boolean isSelfComment() {
        return this.isSelfComment;
    }

    public final void setCacheData(boolean r100) {
        this.isCacheData = r100;
    }

    public final void setCommentData(CommentInfo r100) {
        this.commentData = r100;
    }

    public final void setCreator(boolean r100) {
        this.isCreator = r100;
    }

    public final void setInitTime(long r100) {
        this.initTime = r100;
    }

    public final void setPin(boolean r100) {
        this.isPin = r100;
    }

    public final void setSelfComment(boolean r100) {
        this.isSelfComment = r100;
    }

    public final void setSendState(CommentPublishState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sendState = r100;
    }

    public final void setServerTimeDelta(long r100) {
        this.serverTimeDelta = r100;
    }

    public final void setShowBgFlashing(boolean r100) {
        this.showBgFlashing = r100;
    }

    public final void setTextExpandState(int r100) {
        this.textExpandState = r100;
    }
}
