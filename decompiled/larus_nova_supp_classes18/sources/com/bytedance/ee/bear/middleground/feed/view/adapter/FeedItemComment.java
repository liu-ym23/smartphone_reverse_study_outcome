package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.u;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.middleground.feed.export.bean.BaseFeedMessageDetailBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FeedItemComment implements ag5.a<FeedCommentViewHolder, FeedCommentDetailBean> {
    public final String a;
    public TranslateConfig b;
    public final un5.a.InterfaceC0318a c;
    public final Function5<View, Integer, String, String, String, Unit> d;
    public final Function2<String, Boolean, Unit> e;
    public final Function1<String, Unit> f;
    public final boolean g;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedItemComment$FeedCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTvContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "mTvTranslate", "getMTvTranslate", "mTvTranslateA", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getMTvTranslateA", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "mQuoteLayout", "getMQuoteLayout", "()Landroid/view/View;", "mTvQuote", "Landroid/widget/TextView;", "getMTvQuote", "()Landroid/widget/TextView;", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "mTvName", "getMTvName", "mTvTime", "getMTvTime", "mUnReadIco", "getMUnReadIco", "mDivider", "getMDivider", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedCommentViewHolder extends RecyclerView.ViewHolder {
        public final CommentTextView a;
        public final CommentTextView b;
        public final BearLottieView c;
        public final View d;
        public final TextView e;
        public final ImageView f;
        public final TextView g;
        public final TextView h;
        public final View i;
        public final View j;

        public FeedCommentViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (CommentTextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390392);
            this.b = (CommentTextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390399);
            this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376701);
            this.d = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131383579);
            this.e = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367324);
            this.f = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392043);
            this.g = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
            this.h = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390459);
            this.i = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391881);
            this.j = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392112);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // ag5.a
    public final int b() {
        return 0;
    }

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563636, r4, false);
        Intrinsics.checkNotNull(r5);
        return new FeedCommentViewHolder(r5);
    }

    public static String a(FeedCommentViewHolder r5, String r6, FeedCommentDetailBean r7) {
        boolean r1 = true;
        int r3 = 0;
        StringBuilder r0 = new StringBuilder(StringsKt.trim(StringsKt.trim(r6).toString(), new char[]{'\n'}));
        BaseFeedMessageDetailBean.ExtraEntity r8 = r7.getExtra();
        if (r8 == null) goto L7;
        List<String> r9 = r8.getImage_list();
        if (r9 == null) goto L7;
        int r10 = r9.size();
    L8:
        if (r10 <= 0) goto L18;
        if (r0.length() > 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        r0.append("\n");
    L15:
        if (r3 >= r10) goto L18;
        r0.append("[");
        r0.append(((RecyclerView.ViewHolder) r5).itemView.getContext().getString(2131887704));
        r0.append("]");
        r3 = r3 + 1;
    L18:
        return r0.toString();
    L7:
        r10 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // ag5.a
    public final void d(RecyclerView.Adapter r17, RecyclerView.ViewHolder r18, int r19, MultiBean r20, boolean r21) {
        FeedCommentViewHolder r3 = (FeedCommentViewHolder) r18;
        FeedCommentDetailBean r4 = (FeedCommentDetailBean) r20;
        Intrinsics.checkNotNullParameter(r17, "adapter");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "item");
        boolean r6 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_markdown_enable");
        int r10 = 8;
        RichTextInjector.b(r3.a, CollectionsKt.listOf(this.a), this.c, r6, 8);
        RichTextInjector.b(r3.b, null, null, r6, 8);
        r3.a.setMovementMethod(u.a());
        r3.a.setOnClickListener(new b(r3));
        CommentBean.CommentDetail r7 = new CommentBean.CommentDetail();
        if (r4 == 0) goto L9;
        r7.setAnonymous(r4.isAnonymous());
        r7.setAvatar_url(r4.getAvatar_url());
        r7.setComment_id(r4.getComment_id());
        r7.setContent(r4.getContent());
        r7.setCreate_timestamp(r4.getCreate_timestamp());
        r7.setEditStatus(r4.isEditStatus());
        r7.setError(r4.getError());
        r7.setExtra(null);
        r7.setFull(r4.isFull());
        r7.setIs_whole(r4.getIs_whole());
        r7.setModify(r4.getModify());
        r7.setName(r4.getName());
        r7.setReaction(r4.getReaction());
        r7.setReaction_type(r4.getReaction_type());
        r7.setReactionDetailData(r4.getReactionDetailData());
        r7.setReactionFlowData(r4.getReactionFlowData());
        r7.setReferKey(r4.getReferKey());
        r7.setUser_id(r4.getUser_id());
        r7.setUpdate_timestamp(r4.getUpdate_timestamp());
        r7.setTranslate_status(r4.getTranslate_status());
        r7.setTranslate_content(r4.getTranslate_content());
        r7.setSending(r4.isSending());
        r7.setRetryType(r4.getRetryType());
        r7.setReply_id(r4.getReply_id());
        if ((r4 instanceof MessageBean) == false) goto L8;
        MessageBean r12 = (MessageBean) r4;
        r7.setMessageIds(new String[]{r12.getMessageId()});
        r7.setReadStatus(r12.getReadStatus());
    L8:
        r7.setMessageIds(new String[]{r4.getMessageId()});
        r7.setReadStatus(r4.getReadStatus());
    L9:
        String r13 = "";
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).e(this.b, r7.getReply_id(), r7.getTranslate_status()) == false) goto L15;
        CommentTextView r11 = r3.a;
        String r14 = r4.getTranslate_content();
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        r11.setRawString(a(r3, r14, r4));
    L19:
        r3.a.post(new c(this, r3));
        int r15 = n.v() - n.d(86);
        r3.a.setMaxWidth(r15);
        r3.b.setMaxWidth(r15);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).f(this.b, r7.getReply_id(), r7.getTranslate_status()) == false) goto L33;
        r3.b.setVisibility(0);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).d(this.b, r7.getReply_id()) == false) goto L28;
        CommentTextView r8 = r3.b;
        String r16 = r4.getContent();
        if (r16 == null) goto L27;
        r13 = r16;
    L27:
        r8.setRawString(a(r3, r13, r4));
    L35:
        if (Intrinsics.areEqual(r4.getTranslate_status(), "loading") == false) goto L43;
        ViewGroup.LayoutParams r9 = r3.c.getLayoutParams();
        if ((r9 instanceof RelativeLayout.LayoutParams) == false) goto L39;
        RelativeLayout.LayoutParams r22 = (RelativeLayout.LayoutParams) r9;
    L40:
        if (r22 == null) goto L42;
        r22.addRule(8, 2131390392);
    L42:
        r3.c.playAnimation();
    L57:
        BearLottieView r23 = r3.c;
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).a(this.b, r7.getReply_id(), r7.getTranslate_status()) == false) goto L60;
        int r24 = 0;
    L61:
        r23.setVisibility(r24);
        r3.c.setOnClickListener(new d(r4, r17, r19));
        r3.a.setOnLongClickListener(new e(this, r19, r4));
        ((RecyclerView.ViewHolder) r3).itemView.setOnLongClickListener(new f(this, r19, r4));
        Glide.with(((RecyclerView.ViewHolder) r3).itemView.getContext()).load(new BearGlideUrl(r4.getAvatar_url())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131235295).into(r3.f);
        r3.g.setText(r4.getTitleStr());
        if (this.g == false) goto L77;
        String r1 = r4.getQuote();
        if (r1 != null) goto L66;
    L69:
        boolean r2 = true;
    L70:
        if (r2 == true) goto L77;
        r3.d.setVisibility(0);
        TextView r5 = r3.e;
        if (r4.getCommentType() != 2) goto L75;
        CharSequence r25 = r3.e.getContext().getText(2131889294);
    L76:
        r5.setText(r25);
    L78:
        TextView r26 = r3.h;
        String r27 = zu5.a.b(r3.a.getContext(), r4.getCreateTime() * ((long) CCMLynxCardView.ViewType.BANNER));     // Catch: Exception -> L81
    L82:
        r26.setText(r27);
        r3.f.setOnClickListener(new g(r4, this));
        tt5.a.h("FeedItemComment", "read message +" + r19);
        View r28 = r3.i;
        if (r4.getReadStatus() != 1) goto L85;
        int r29 = 0;
    L86:
        r28.setVisibility(r29);
        View r30 = r3.j;
        if (r4.isLastItem() == true) goto L90;
        r10 = 0;
    L90:
        r30.setVisibility(r10);
        r3.b.setBackgroundResource(2131233333);
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new h(this, r4));
        AppCompatTextView r31 = r3.a;
        AppCompatTextView r32 = r3.b;
        BearLottieView r33 = r3.c;
        if (r33.getVisibility() == 0) goto L94;
        return;
    L94:
        if (r32.getVisibility() != 0) goto L96;
        r31 = r32;
    L96:
        r31.getViewTreeObserver().addOnPreDrawListener(new eg5.a(r31, r33));
        return;
    L85:
        r29 = 8;
    L81:
        tt5.a.k("FeedItemComment", "the time isn't right");
        r27 = String.valueOf(r4.getCreate_timestamp());
        goto L82
    L75:
        r25 = r4.getQuote();
        goto L76
    L66:
        if (r1.length() == 0) goto L69;
        r2 = false;
    L77:
        r3.d.setVisibility(8);
        goto L78
    L60:
        r24 = 8;
        goto L61
    L39:
        r22 = null;
        goto L40
    L43:
        r3.c.cancelAnimation();
        r3.c.setFrame(0);
        if (r3.b.getVisibility() != 0) goto L51;
        ViewGroup.LayoutParams r34 = r3.c.getLayoutParams();
        if ((r34 instanceof RelativeLayout.LayoutParams) == false) goto L48;
        RelativeLayout.LayoutParams r35 = (RelativeLayout.LayoutParams) r34;
    L49:
        if (r35 == null) goto L57;
        r35.addRule(8, 2131390399);
        goto L57
    L48:
        r35 = null;
        goto L49
    L51:
        ViewGroup.LayoutParams r36 = r3.c.getLayoutParams();
        if ((r36 instanceof RelativeLayout.LayoutParams) == false) goto L54;
        RelativeLayout.LayoutParams r37 = (RelativeLayout.LayoutParams) r36;
    L55:
        if (r37 == null) goto L57;
        r37.addRule(8, 2131390392);
        goto L57
    L54:
        r37 = null;
        goto L55
    L28:
        CommentTextView r38 = r3.b;
        String r110 = r4.getTranslate_content();
        if (r110 == null) goto L32;
        r13 = r110;
    L32:
        r38.setRawString(a(r3, r13, r4));
        goto L35
    L33:
        r3.b.setVisibility(8);
        goto L35
    L15:
        CommentTextView r111 = r3.a;
        String r112 = r4.getContent();
        if (r112 != null) goto L18;
        r112 = "";
    L18:
        r111.setRawString(a(r3, r112, r4));
        goto L19
    }

    public FeedItemComment(String r2, TranslateConfig r3, un5.a.InterfaceC0318a r4, dg5.h r5, dg5.i r6, dg5.j r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "userToken");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "fileSpanClickListener");
        Intrinsics.checkNotNullParameter(r5, "longListener");
        Intrinsics.checkNotNullParameter(r6, "toMessage");
        Intrinsics.checkNotNullParameter(r7, "gotoProfile");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
