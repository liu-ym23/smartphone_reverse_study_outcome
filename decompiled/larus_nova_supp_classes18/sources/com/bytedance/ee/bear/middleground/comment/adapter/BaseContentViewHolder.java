package com.bytedance.ee.bear.middleground.comment.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020,X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010)\"\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\u0019X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001b\"\u0004\b<\u0010\u001dR\u001a\u0010=\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u0010\u0005¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/BaseContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "translateContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getTranslateContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "setTranslateContent", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;)V", "translate", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getTranslate", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "setTranslate", "(Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;)V", "userImg", "Landroid/widget/ImageView;", "getUserImg", "()Landroid/widget/ImageView;", "setUserImg", "(Landroid/widget/ImageView;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "crateTime", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "getCrateTime", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "setCrateTime", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;)V", "content", "getContent", "setContent", "more", "getMore", "()Landroid/view/View;", "setMore", "reactionFlowLayout", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "getReactionFlowLayout", "()Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "setReactionFlowLayout", "(Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;)V", "commentSendingMask", "getCommentSendingMask", "setCommentSendingMask", "contentMask", "getContentMask", "setContentMask", "retry", "getRetry", "setRetry", "sendFailTv", "getSendFailTv", "setSendFailTv", "deleteComment", "getDeleteComment", "setDeleteComment", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseContentViewHolder extends RecyclerView.ViewHolder {
    public CommentTextView T3() {
        Intrinsics.throwUninitializedPropertyAccessException("content");
        return null;
    }

    public ReactionFlowLayout U3() {
        Intrinsics.throwUninitializedPropertyAccessException("reactionFlowLayout");
        return null;
    }

    public BearLottieView V3() {
        Intrinsics.throwUninitializedPropertyAccessException("translate");
        return null;
    }

    public BaseContentViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}
