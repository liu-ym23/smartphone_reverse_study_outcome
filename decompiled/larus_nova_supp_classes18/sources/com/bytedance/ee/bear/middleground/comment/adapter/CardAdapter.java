package com.bytedance.ee.bear.middleground.comment.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.u;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.comment.control.x;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.export.w;
import com.bytedance.ee.bear.middleground.comment.extension.events.CardAdapterActionType;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTimeText;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002WXBM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020+H\u0016J\b\u00104\u001a\u00020+H\u0016J&\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u00020+2\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0016H\u0016J\u0018\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u00020+H\u0017J\u0018\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020+H\u0016J\u0018\u0010<\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0018\u0010>\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0018\u0010@\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00172\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010C\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0018\u0010D\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0018\u0010E\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0018\u0010F\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0002H\u0002J\u0016\u0010G\u001a\u00020\u00122\u0006\u00106\u001a\u00020H2\u0006\u0010,\u001a\u00020\u0017J\u0018\u0010I\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0003J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0010\u0010L\u001a\u00020\u00072\u0006\u00103\u001a\u00020+H\u0016J\n\u0010M\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010N\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u00010OH\u0016J\u0010\u0010P\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0017H\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020BH\u0002J\u0018\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020BH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 ¨\u0006Y"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/export/ICardAdapter;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "language", "", "userIds", "", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "isEditStatus", "", "clickLink", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;ZLkotlin/jvm/functions/Function0;)V", "commentRecord", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "commentBean", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "quote", "getQuote", "()Ljava/lang/String;", "setQuote", "(Ljava/lang/String;)V", "parentToken", "getParentToken", "setParentToken", "parentType", "getParentType", "setParentType", "setData", WikiFolderPushPlugin.DATA, "getData", "getCommentVisibility", "", "commentDetail", "getCommentDetails", "onAttachedToRecyclerView", "recyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "position", "getItemCount", "onBindViewHolder", "holder", "payloads", "", "onItemVisible", "first", "last", "setLoaddingStatus", "item", "setRetryView", "shouldHideDeleteButton", "retry", "retryView", "Landroid/view/View;", "setContent", "setTranslateIcon", "setTranslateContent", "setTime", "setReaction", "Lcom/bytedance/ee/bear/middleground/comment/adapter/BaseContentViewHolder;", "setMore", "getLast3Item", "replyId", "findReplyIdByPosition", "getPostion", "getBizParam", "", "getCommentId", "adjustTouchArea", "view", "adjustPosition", "textView", "Landroid/widget/TextView;", "tran", "Companion", "ViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardAdapter extends RecyclerView.Adapter<ViewHolder> implements ICardAdapter {
    public static final int CONTAINS_VALUE = 1;
    public static final a Companion = null;
    public static final String REACTION = "REACTION";
    public static final String SENDINGSTATUS = "SENDINGSTATUS";
    private static final String TAG = "Comment#CardAdapter";
    public static final String TEXT = "TEXT";
    private final y actionControl;
    private final Function0<Unit> clickLink;
    private CommentBean commentBean;
    private final z commentListeners;
    private List<CommentBean.CommentDetail> commentRecord;
    private final p config;
    private final boolean isEditStatus;
    private final String language;
    private RecyclerView mRecyclerView;
    private String parentToken;
    private String parentType;
    private String quote;
    private final List<String> userIds;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020,X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010)\"\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001b\"\u0004\b<\u0010\u001dR\u001a\u0010=\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u0010\u0005R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010\u0005¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/BaseContentViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "translateContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getTranslateContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "setTranslateContent", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;)V", "translate", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getTranslate", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "setTranslate", "(Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;)V", "userImg", "Landroid/widget/ImageView;", "getUserImg", "()Landroid/widget/ImageView;", "setUserImg", "(Landroid/widget/ImageView;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "crateTime", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "getCrateTime", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "setCrateTime", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;)V", "content", "getContent", "setContent", "more", "getMore", "()Landroid/view/View;", "setMore", "reactionFlowLayout", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "getReactionFlowLayout", "()Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "setReactionFlowLayout", "(Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;)V", "commentSendingMask", "getCommentSendingMask", "setCommentSendingMask", "contentMask", "getContentMask", "setContentMask", "retry", "getRetry", "setRetry", "sendFailTv", "getSendFailTv", "setSendFailTv", "deleteComment", "getDeleteComment", "setDeleteComment", "commentLoading", "Lcom/airbnb/lottie/LottieAnimationView;", "getCommentLoading", "()Lcom/airbnb/lottie/LottieAnimationView;", "setCommentLoading", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "commentFailImg", "getCommentFailImg", "setCommentFailImg", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends BaseContentViewHolder {
        public final CommentTextView a;
        public final BearLottieView b;
        public final ImageView c;
        public final TextView d;
        public final CommentTimeText e;
        public final CommentTextView f;
        public final View g;
        public final ReactionFlowLayout h;
        public final View i;
        public final View j;
        public final View k;
        public final TextView l;
        public final View m;
        public final LottieAnimationView n;
        public final View o;

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder
        public final CommentTextView T3() {
            return this.f;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder
        public final ReactionFlowLayout U3() {
            return this.h;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder
        public final BearLottieView V3() {
            return this.b;
        }

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (CommentTextView) r2.findViewById(2131390399);
            this.b = r2.findViewById(2131376701);
            this.c = (ImageView) r2.findViewById(2131392043);
            this.d = (TextView) r2.findViewById(2131390975);
            this.e = (CommentTimeText) r2.findViewById(2131390459);
            this.f = (CommentTextView) r2.findViewById(2131390392);
            this.g = r2.findViewById(2131391037);
            this.h = r2.findViewById(2131383754);
            this.i = r2.findViewById(2131367394);
            this.j = r2.findViewById(2131367839);
            this.k = r2.findViewById(2131367426);
            this.l = (TextView) r2.findViewById(2131367428);
            this.m = r2.findViewById(2131368787);
            this.n = r2.findViewById(2131367392);
            this.o = r2.findViewById(2131367341);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CommentBean.CommentDetail a;
        public final /* synthetic */ CardAdapter b;

        public b(CommentBean.CommentDetail r1, CardAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.isAnonymous() == true) goto L9;
            CardAdapter.access$getConfig$p(this.b).h.getClass();
            if (com.bytedance.ee.bear.middleground.comment.p.c() == true) goto L10;
            CardAdapter.access$getCommentListeners$p(this.b).s0().invoke(this.a.getUser_id());
            return;
        L10:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public c(boolean r1, CardAdapter r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            if (this.a == false) goto L5;
            y r2 = CardAdapter.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r3 = this.c;
            CardAdapter r4 = this.b;
            r2.j(r3, r4, r4.getQuote(), 0, this.b.getParentType(), this.b.getParentToken(), null);
            return;
        L5:
            String r5 = this.c.getContent();
            CommentBean.CommentDetail.ExtraEntity r1 = this.c.getExtra();
            if (r1 == null) goto L8;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r6 = r1.getImage_list();
        L9:
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r6;
            String r7 = this.b.getQuote();
            String r9 = this.c.getComment_id();
            String r12 = this.c.getReply_id();
            com.bytedance.ee.bear.rn.e r10 = new com.bytedance.ee.bear.rn.e(r7, r5, r9, false, false, r8, null, this.b.getParentType(), this.b.getParentToken(), r12, false, null, null, null, null, null, this.c.getCommentType(), null, 195672);
            CardAdapter.access$getActionControl$p(this.b).C(r10);
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CardAdapter a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public d(CardAdapter r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            y r5 = CardAdapter.access$getActionControl$p(this.a);
            CommentBean.CommentDetail r0 = this.b;
            r5.w(r0, r0.getReply_id(), null);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public e(boolean r1, CardAdapter r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            if (this.a == false) goto L5;
            y r2 = CardAdapter.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r3 = this.c;
            CardAdapter r4 = this.b;
            r2.j(r3, r4, r4.getQuote(), 2, this.b.getParentType(), this.b.getParentToken(), null);
            return;
        L5:
            String r5 = this.c.getContent();
            CommentBean.CommentDetail.ExtraEntity r1 = this.c.getExtra();
            if (r1 == null) goto L8;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r6 = r1.getImage_list();
        L9:
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r6;
            com.bytedance.ee.bear.rn.e r7 = new com.bytedance.ee.bear.rn.e(null, r5, this.c.getComment_id(), false, false, r8, null, null, null, this.c.getReply_id(), false, null, null, null, null, null, this.c.getCommentType(), null, 196057);
            CardAdapter.access$getActionControl$p(this.b).z(r7);
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public f(boolean r1, CardAdapter r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            if (this.a == false) goto L5;
            y r2 = CardAdapter.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r3 = this.c;
            CardAdapter r4 = this.b;
            r2.j(r3, r4, r4.getQuote(), 1, this.b.getParentType(), this.b.getParentToken(), null);
            return;
        L5:
            String r11 = this.c.getComment_id();
            String r12 = this.c.getReply_id();
            String r13 = this.c.getContent();
            CommentBean.CommentDetail.ExtraEntity r5 = this.c.getExtra();
            if (r5 == null) goto L8;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r6 = r5.getImage_list();
        L9:
            com.bytedance.ee.bear.rn.d r1 = new com.bytedance.ee.bear.rn.d(r11, r12, r13, r6, false, false, null, false, 0, false, 2032);
            CardAdapter.access$getActionControl$p(this.b).p(r1);
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CardAdapter a;
        public final /* synthetic */ ViewHolder b;

        public g(CardAdapter r1, ViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardAdapter.access$adjustTouchArea(this.a, this.b.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements com.bytedance.ee.bear.middleground.comment.cell.i.a {
        public final /* synthetic */ CardAdapter a;

        public h(CardAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final void b(String r2) {
            CardAdapter.access$getClickLink$p(this.a).invoke();
            if (r2 == null) goto L6;
            CardAdapter.access$getCommentListeners$p(this.a).b0().invoke(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uuid");
            CardAdapter.access$getCommentListeners$p(this.a).s0().invoke(r2);
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final boolean isSameSpace(String r2) {
            if (r2 != null) goto L4;
        L6:
            return false;
        L4:
            if (((Boolean) CardAdapter.access$getCommentListeners$p(this.a).v0().invoke(r2)).booleanValue() == false) goto L6;
            return true;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final void a(String r2, String r3, MentionUserState r4) {
            Intrinsics.checkNotNullParameter(r2, "uuid");
            Intrinsics.checkNotNullParameter(r3, "content");
            Intrinsics.checkNotNullParameter(r4, "userState");
            CardAdapter.access$getCommentListeners$p(this.a).e0().invoke(r2, r3);
        }
    }

    public static final class i implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ViewHolder a;
        public final /* synthetic */ ViewGroup.MarginLayoutParams b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a.f.getLayout() != null) goto L6;
            this.a.f.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        L6:
            Layout r0 = this.a.f.getLayout();
            this.b.topMargin = (this.a.f.getTop() + ((r0.getLineTop(r0.getLineCount() - 1) + r0.getLineBottom(r0.getLineCount() - 1)) / 2)) - (this.a.n.getHeight() / 2);
            ViewGroup.MarginLayoutParams r2 = this.b;
            int r3 = this.a.f.getLeft();
            if ((this.a.f.getWidth() - r0.getLineWidth(r0.getLineCount() - 1)) >= this.a.n.getWidth()) goto L9;
            this.a.i.setVisibility(0);
            int r1 = this.a.f.getWidth() - this.a.n.getWidth();
        L10:
            r2.leftMargin = r3 + r1;
            this.a.n.setLayoutParams(this.b);
            this.a.f.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        L9:
            r1 = (int) r0.getLineWidth(r0.getLineCount() - 1);
            goto L10
        }

        public i(ViewHolder r1, ViewGroup.MarginLayoutParams r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ CardAdapter a;
        public final /* synthetic */ ViewHolder b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public j(CardAdapter r1, ViewHolder r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            y r6 = CardAdapter.access$getActionControl$p(this.a);
            ViewHolder r0 = this.b;
            x.b(r6, ((RecyclerView.ViewHolder) r0).itemView, this.c, this.a, r0.getAdapterPosition());
        }
    }

    public static final class k implements View.OnLongClickListener {
        public final /* synthetic */ BaseContentViewHolder a;
        public final /* synthetic */ CardAdapter b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public k(BaseContentViewHolder r1, CardAdapter r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            int r0 = this.a.getAdapterPosition();
            tt5.a.h(CardAdapter.TAG, "onBindViewHolder:content.setOnLongClickListener " + r0);
            if (r0 < 0) goto L7;
            y r1 = CardAdapter.access$getActionControl$p(this.b);
            Intrinsics.checkNotNull(r5);
            x.b(r1, r5, this.c, this.b, r0);
            return true;
        L7:
            return true;
        }
    }

    public static final class l implements View.OnLongClickListener {
        public final /* synthetic */ BaseContentViewHolder a;
        public final /* synthetic */ CardAdapter b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public l(BaseContentViewHolder r1, CardAdapter r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            int r0 = this.a.getAdapterPosition();
            tt5.a.h(CardAdapter.TAG, "onBindViewHolder:itemView.setOnLongClickListener " + r0);
            if (r0 < 0) goto L7;
            y r1 = CardAdapter.access$getActionControl$p(this.b);
            Intrinsics.checkNotNull(r5);
            x.b(r1, r5, this.c, this.b, r0);
            return true;
        L7:
            return true;
        }
    }

    public static final class m implements View.OnClickListener {
        public final /* synthetic */ CardAdapter a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public m(CardAdapter r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            y r5 = CardAdapter.access$getActionControl$p(this.a);
            CommentBean.CommentDetail r0 = this.b;
            r5.w(r0, r0.getReply_id(), null);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public Map<Object, Object> getBizParam() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public String getPostion() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public w getUiState() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public CommentBean getData() {
        CommentBean r0 = this.commentBean;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new CommentBean();
    }

    public int getItemCount() {
        return this.commentRecord.size();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public List<CommentBean.CommentDetail> getCommentDetails() {
        return this.commentRecord;
    }

    public final String getParentToken() {
        return this.parentToken;
    }

    public final String getParentType() {
        return this.parentType;
    }

    public final String getQuote() {
        return this.quote;
    }

    public static final /* synthetic */ y access$getActionControl$p(CardAdapter r0) {
        return r0.actionControl;
    }

    public static final /* synthetic */ Function0 access$getClickLink$p(CardAdapter r0) {
        return r0.clickLink;
    }

    public static final /* synthetic */ z access$getCommentListeners$p(CardAdapter r0) {
        return r0.commentListeners;
    }

    public static final /* synthetic */ p access$getConfig$p(CardAdapter r0) {
        return r0.config;
    }

    private final void adjustTouchArea(View r8) {
        if (r8.getVisibility() == 0) goto L6;
        Object r9 = r8.getParent();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.View");
        ((View) r9).setTouchDelegate(null);
        return;
    L6:
        Rect r0 = new Rect();
        r8.getHitRect(r0);
        Object r2 = r8.getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        ((View) r2).setTouchDelegate(new TouchDelegate(new Rect(r0.left - 200, r0.top - 30, r0.right + 200, r0.bottom + 200), r8));
    }

    private final boolean shouldHideDeleteButton(CommentBean.CommentDetail r3) {
        if (r3.getError().isSuccess() == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r3.getRetryType(), "delete") == true) goto L10;
        if (Intrinsics.areEqual(r3.getRetryType(), "update") == true) goto L10;
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public String findReplyIdByPosition(int r2) {
        if (r2 >= this.commentRecord.size()) goto L5;
        String r3 = ((CommentBean.CommentDetail) ListProtector.get(this.commentRecord, r2)).getReply_id();
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public String getCommentId(CommentBean.CommentDetail r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        String r3 = r2.getComment_id();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public int getCommentVisibility(CommentBean.CommentDetail r1) {
        CommentBean.Extra r2 = getData().getExtra();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getVisibility();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public List<CommentBean.CommentDetail> getLast3Item(String r6) {
        Intrinsics.checkNotNullParameter(r6, "replyId");
        Iterator<T> r0 = this.commentRecord.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        int r2 = r1 + 1;
        CommentBean.CommentDetail r3 = (CommentBean.CommentDetail) r0.next();
        if (Intrinsics.areEqual(r6, r3.getReply_id()) == true) goto L7;
        r1 = r2;
        goto L4
    L7:
        r3.setEditStatus(true);
        return CollectionsKt.toMutableList(this.commentRecord).subList(r1, Math.min(r1 + 3, this.commentRecord.size()));
    L11:
        return new ArrayList();
    }

    public void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.mRecyclerView = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public void setData(CommentBean r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        this.commentBean = r2;
        List<CommentBean.CommentDetail> r3 = r2.getComment_list();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean.CommentDetail>");
        this.commentRecord = TypeIntrinsics.asMutableList(r3);
    }

    public final void setParentToken(String r1) {
        this.parentToken = r1;
    }

    public final void setParentType(String r1) {
        this.parentType = r1;
    }

    public final void setQuote(String r1) {
        this.quote = r1;
    }

    public static final /* synthetic */ void access$adjustTouchArea(CardAdapter r0, View r1) {
        r0.adjustTouchArea(r1);
    }

    private final void adjustPosition(TextView r4, View r5) {
        this.config.N.a(new ef5.c(this.mRecyclerView, r4, r5));
    }

    private final void retry(CommentBean.CommentDetail r5, View r6) {
        if (r5.getError().isSuccess() == false) goto L6;
        r6.setVisibility(8);
        r6.setOnClickListener(null);
        return;
    L6:
        r6.setVisibility(0);
        boolean r0 = ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).b(r5.getError().code);
        String r2 = r5.getRetryType();
        if (r2 != null) goto L9;
    L27:
        r6.setOnClickListener(null);
        return;
    L9:
        switch(r2.hashCode()) {
            case -1335458389: goto L24;
            case -838846263: goto L20;
            case 96417: goto L16;
            case 108401386: goto L12;
            default: goto L27;
        };
    L12:
        if (r2.equals("reply") == false) goto L27;
        r6.setOnClickListener(new e(r0, this, r5));
        return;
    L16:
        if (r2.equals("add") == false) goto L27;
        r6.setOnClickListener(new c(r0, this, r5));
        return;
    L20:
        if (r2.equals("update") == false) goto L27;
        r6.setOnClickListener(new f(r0, this, r5));
        return;
    L24:
        if (r2.equals("delete") == false) goto L27;
        r6.setOnClickListener(new d(this, r5));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void setContent(ViewHolder r6, CommentBean.CommentDetail r7) {
        if (this.isEditStatus == true) goto L5;
        com.bytedance.ee.bear.middleground.comment.cell.i r0 = this.actionControl.H(r7.getComment_id(), 0, new h(this));
    L6:
        RichTextInjector.b(r6.f, this.userIds, r0, this.config.U, 8);
        int r1 = n.v() - n.d(86);
        r6.f.setMaxWidth(r1);
        r6.f.setMovementMethod(u.a());
        Map<String, Boolean> r2 = nf5.a.a;
        TranslateConfig r3 = this.config.x;
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r7, "item");
        if (nf5.a.g(r3, r7.getReply_id(), r7.getTranslate_status()) == false) goto L9;
        r6.f.setRawString(r7.getTranslate_content());
    L10:
        adjustPosition(r6.f, r6.b);
        r6.f.post(new g(this, r6));
        return;
    L9:
        r6.f.setRawString(r7.getContent());
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    private final void setLoaddingStatus(ViewHolder r4, CommentBean.CommentDetail r5) {
        r4.i.setVisibility(8);
        if (r5.isSending() == false) goto L13;
        ViewGroup.LayoutParams r0 = r4.n.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        CommentBean.CommentDetail.ExtraEntity r6 = r5.getExtra();
        if (r6 == null) goto L9;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = r6.getImage_list();
        if (r7 == null) goto L9;
        int r8 = r7.size();
    L10:
        if (r8 != 0) goto L12;
        r4.f.getViewTreeObserver().addOnPreDrawListener(new i(r4, r1));
    L12:
        r4.n.setVisibility(0);
        r4.n.playAnimation();
        return;
    L9:
        r8 = 0;
        goto L10
    L13:
        r4.n.setVisibility(8);
    }

    private final void setMore(ViewHolder r3, CommentBean.CommentDetail r4) {
        View r0 = r3.g;
        if (this.isEditStatus == false) goto L5;
    L10:
        int r1 = 8;
    L11:
        r0.setVisibility(r1);
        r3.g.setOnClickListener(new j(this, r3, r4));
        return;
    L5:
        if (r4.isSending() == true) goto L10;
        if (r4.getError().isSuccess() == false) goto L10;
        r1 = 0;
        goto L11
    }

    private final void setRetryView(ViewHolder r5, CommentBean.CommentDetail r6) {
        retry(r6, r5.l);
        retry(r6, r5.k);
        retry(r6, r5.o);
        if (r6.getError().isNetFail() == false) goto L6;
        int r0 = 2131887323;
    L21:
        r5.l.setText(this.config.getActivity().getText(r0));
        View r1 = r5.m;
        int r2 = 8;
        if (shouldHideDeleteButton(r6) == false) goto L24;
        int r3 = 8;
    L25:
        r1.setVisibility(r3);
        View r4 = r5.j;
        if (shouldHideDeleteButton(r6) == true) goto L29;
        r2 = 0;
    L29:
        r4.setVisibility(r2);
        r5.m.setOnClickListener(new m(this, r6));
        return;
    L24:
        r3 = 0;
        goto L25
    L6:
        if (r6.getError().isNoPermission() == false) goto L9;
        r0 = 2131887324;
        goto L21
    L9:
        if (r6.getError().isReviewFail() == false) goto L12;
        r0 = 2131887329;
        goto L21
    L12:
        if (r6.getError().isBanFail() == false) goto L15;
        r0 = 2131889734;
        goto L21
    L15:
        if (r6.getError().isMultiGeoFail() == false) goto L18;
        r0 = 2131887325;
        goto L21
    L18:
        if (r6.getError().isMultiGeoPrepare() == false) goto L20;
        r0 = 2131887326;
        goto L21
    L20:
        r0 = 2131887328;
        goto L21
    }

    private final void setTime(CommentBean.CommentDetail r5, ViewHolder r6) {
    L8:
        tt5.a.k(TAG, "the time isn't right");
        r6.e.setText(String.valueOf(r5.getCreate_timestamp()));
        return;
    L3:
        if (r5.getModify() != 1) goto L5;
        CharSequence r0 = zu5.a.b(r6.e.getContext(), ((long) r5.getUpdate_timestamp()) * ((long) CCMLynxCardView.ViewType.BANNER)) + r6.e.getResources().getString(2131887616);     // Catch: Exception -> L8
    L6:
        r6.e.setText(r0);     // Catch: Exception -> L8
        return;
    L5:
        r0 = zu5.a.b(r6.c.getContext(), ((long) r5.getCreate_timestamp()) * ((long) CCMLynxCardView.ViewType.BANNER));     // Catch: Exception -> L8
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void setTranslateContent(ViewHolder r7, CommentBean.CommentDetail r8) {
        int r0 = n.v() - n.d(86);
        r7.a.setMaxWidth(r0);
        Map<String, Boolean> r1 = nf5.a.a;
        TranslateConfig r2 = this.config.x;
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r8, "item");
        if (nf5.a.f(r2, r8.getReply_id(), r8.getTranslate_status()) == false) goto L8;
        RichTextInjector.b(r7.a, null, null, this.config.U, 8);
        r7.a.setVisibility(0);
        TranslateConfig r3 = this.config.x;
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r8, "item");
        if (nf5.a.a(r3, r8.getReply_id()) == false) goto L7;
        r7.a.setRawString(r8.getContent());
    L9:
        adjustPosition(r7.a, r7.b);
        return;
    L7:
        r7.a.setRawString(r8.getTranslate_content());
        goto L9
    L8:
        r7.a.setVisibility(8);
        goto L9
    }

    private final void setTranslateIcon(ViewHolder r5, CommentBean.CommentDetail r6) {
        this.config.N.a(new ef5.b(CardAdapterActionType.SetTranslateIcon, this.mRecyclerView, r5, r6));
    }

    public void onBindViewHolder(ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        CommentBean.CommentDetail r7 = (CommentBean.CommentDetail) ListProtector.get(this.commentRecord, r6);
        if (r7.getReply_id() != null) goto L6;
        tt5.a.d(TAG, "reply_id is null! comment_id = " + getCommentId(r7));
        return;
    L6:
        RichTextInjector.b(r5.f, null, null, false, 24);
        RichTextInjector.b(r5.a, null, null, false, 24);
        if (this.isEditStatus == false) goto L13;
        View r0 = ((RecyclerView.ViewHolder) r5).itemView;
        if (r7.isEditStatus() == false) goto L11;
        int r1 = ((RecyclerView.ViewHolder) r5).itemView.getResources().getColor(2131100559);
    L12:
        r0.setBackgroundColor(r1);
        goto L13
    L11:
        r1 = ((RecyclerView.ViewHolder) r5).itemView.getResources().getColor(2131103546);
    L13:
        Glide.with(((RecyclerView.ViewHolder) r5).itemView.getContext()).load(new BearGlideUrl(r7.getAvatar_url())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131235295).into(r5.c);
        if (this.isEditStatus == true) goto L16;
        r5.c.setOnClickListener(new b(r7, this));
    L16:
        setTranslateIcon(r5, r7);
        setContent(r5, r7);
        r5.d.setText(r7.getName());
        setTime(r7, r5);
        setMore(r5, r7);
        setReaction(r5, r7);
        setTranslateContent(r5, r7);
        setLoaddingStatus(r5, r7);
        setRetryView(r5, r7);
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public ViewHolder m76onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(this.config.getActivity()).inflate(2131559866, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ViewHolder(r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public void onItemVisible(int r7, int r8) {
        tt5.a.h(TAG, "onItemVisible, first: " + r7 + ", last: " + r8);
        if (this.commentRecord.isEmpty() == false) goto L6;
        return;
    L6:
        if (r7 < this.commentRecord.size()) goto L8;
        tt5.a.k(TAG, "onItemVisible first out of index, first: " + r7 + ", size: " + this.commentRecord.size());
        int r0 = this.commentRecord.size() - 1;
    L10:
        if (r8 < this.commentRecord.size()) goto L12;
        tt5.a.k(TAG, "onItemVisible last out of index, last: " + r7 + ", size: " + this.commentRecord.size());
        r8 = this.commentRecord.size() + (-1);
    L12:
        ArrayList r9 = new ArrayList();
        if (r0 > r8) goto L29;
    L14:
        CommentBean.CommentDetail r2 = (CommentBean.CommentDetail) ListProtector.get(this.commentRecord, r0);
        String[] r4 = r2.getMessageIds();
        if (r4 == null) goto L21;
        boolean r5 = false;
        if (r4.length != 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L21;
    L22:
        if (r5 == false) goto L24;
    L26:
        if (r0 == r8) goto L29;
        r0 = r0 + 1;
        goto L14
    L24:
        if (r2.getReadStatus() != 1) goto L26;
        CollectionsKt.addAll(r9, r2.getMessageIds());
        r2.setReadStatus(2);
        goto L26
    L19:
        r6 = false;
    L21:
        r5 = true;
    L29:
        if ((!r9.isEmpty()) == false) goto L33;
        tt5.a.h(TAG, "readMessage: " + r9);
        this.actionControl.g(r9);
        return;
    L33:
        return;
    L8:
        r0 = r7;
        goto L10
    }

    public final void setReaction(BaseContentViewHolder r5, CommentBean.CommentDetail r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "commentDetail");
        this.config.N.a(new ef5.b(CardAdapterActionType.SetReaction, this.mRecyclerView, r5, r6));
        if (this.isEditStatus == false) goto L5;
        return;
    L5:
        if (r6.isSending() == true) goto L9;
        r5.T3().setOnLongClickListener(new k(r5, this, r6));
        ((RecyclerView.ViewHolder) r5).itemView.setOnLongClickListener(new l(r5, this, r6));
        return;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m76onCreateViewHolder(r1, r2);
    }

    public void onBindViewHolder(ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.isEmpty() == true) goto L19;
        Object r1 = ListProtector.get(r6, 0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.Bundle");
        if (((Bundle) r1).isEmpty() == true) goto L19;
        CommentBean.CommentDetail r7 = (CommentBean.CommentDetail) ListProtector.get(this.commentRecord, r5);
        Object r8 = ListProtector.get(r6, 0);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r9 = (Bundle) r8;
        if (r9.getInt(TEXT, 0) != 1) goto L10;
        setContent(r4, r7);
        setTranslateContent(r4, r7);
        setTime(r7, r4);
    L10:
        int r2 = CommentDiffUtils.a;
        if (r9.getInt("TRANSLATE", 0) != 1) goto L14;
        setContent(r4, r7);
        setTranslateIcon(r4, r7);
        setTranslateContent(r4, r7);
        setMore(r4, r7);
    L14:
        if (r9.getInt(REACTION, 0) != 1) goto L17;
        setReaction(r4, r7);
        setMore(r4, r7);
    L17:
        if (r9.getInt(SENDINGSTATUS, 0) != 1) goto L21;
        setLoaddingStatus(r4, r7);
        setMore(r4, r7);
        setRetryView(r4, r7);
        return;
    L21:
        return;
    L19:
        onBindViewHolder(r4, r5);
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        onBindViewHolder((ViewHolder) r1, r2, r3);
    }

    public CardAdapter(p r2, String r3, List<String> r4, z r5, y r6, boolean r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "language");
        Intrinsics.checkNotNullParameter(r4, "userIds");
        Intrinsics.checkNotNullParameter(r5, "commentListeners");
        Intrinsics.checkNotNullParameter(r6, "actionControl");
        Intrinsics.checkNotNullParameter(r8, "clickLink");
        this.config = r2;
        this.language = r3;
        this.userIds = r4;
        this.commentListeners = r5;
        this.actionControl = r6;
        this.isEditStatus = r7;
        this.clickLink = r8;
        this.commentRecord = new ArrayList();
    }

    public /* synthetic */ CardAdapter(p r10, String r11, List r12, z r13, y r14, boolean r15, Function0 r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 32) == 0) goto L5;
        boolean r7 = false;
    L6:
        this(r10, r11, r12, r13, r14, r7, r16);
        return;
    L5:
        r7 = r15;
        goto L6
    }
}
