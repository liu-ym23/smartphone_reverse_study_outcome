package com.bytedance.ee.bear.middleground.comment.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.card.d;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/ReactionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;Landroidx/recyclerview/widget/RecyclerView;)V", "getRootView", "()Landroid/view/View;", "getConfig", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "getActionControl", "()Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "getCommentListeners", "()Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "getCardDataViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "reactionFlowLayout", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "getReactionFlowLayout", "()Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "commentDetail", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "getCommentDetail", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "setCommentDetail", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;)V", "setData", "", "setReaction", "setAnim", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactionViewHolder extends RecyclerView.ViewHolder {
    public final View a;
    public final p b;
    public final d c;
    public final RecyclerView d;
    public final ReactionFlowLayout e;
    public CommentBean.CommentDetail f;

    public static final class a {
    }

    static {
    }

    public ReactionViewHolder(View r2, p r3, y r4, z r5, d r6, RecyclerView r7) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "actionControl");
        Intrinsics.checkNotNullParameter(r5, "commentListeners");
        Intrinsics.checkNotNullParameter(r6, "cardDataViewModel");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r6;
        this.d = r7;
        this.e = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131383754);
    }
}
