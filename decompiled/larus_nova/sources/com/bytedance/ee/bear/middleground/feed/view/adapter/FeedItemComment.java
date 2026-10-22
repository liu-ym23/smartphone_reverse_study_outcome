package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.u;
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
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class FeedItemComment implements ag5.a<FeedCommentViewHolder, FeedCommentDetailBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranslateConfig f232620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final un5.a.InterfaceC7903a f232621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function5<View, Integer, String, String, String, Unit> f232622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<String, Boolean, Unit> f232623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<String, Unit> f232624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f232625g;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedItemComment$FeedCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTvContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "mTvTranslate", "getMTvTranslate", "mTvTranslateA", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getMTvTranslateA", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "mQuoteLayout", "getMQuoteLayout", "()Landroid/view/View;", "mTvQuote", "Landroid/widget/TextView;", "getMTvQuote", "()Landroid/widget/TextView;", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "mTvName", "getMTvName", "mTvTime", "getMTvTime", "mUnReadIco", "getMUnReadIco", "mDivider", "getMDivider", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedCommentViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CommentTextView f232626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CommentTextView f232627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BearLottieView f232628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f232629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f232630e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f232631f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f232632g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f232633h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final View f232634i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final View f232635j;

        public FeedCommentViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f232626a = (CommentTextView) this.itemView.findViewById(R.id.tv_content);
            this.f232627b = (CommentTextView) this.itemView.findViewById(R.id.tv_content_translate);
            this.f232628c = (BearLottieView) this.itemView.findViewById(R.id.iv_translate);
            this.f232629d = this.itemView.findViewById(R.id.quote_layout);
            this.f232630e = (TextView) this.itemView.findViewById(R.id.comment_card_quote);
            this.f232631f = (ImageView) this.itemView.findViewById(R.id.user_msg_image);
            this.f232632g = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.f232633h = (TextView) this.itemView.findViewById(R.id.tv_create_at);
            this.f232634i = this.itemView.findViewById(R.id.unread_ico);
            this.f232635j = this.itemView.findViewById(R.id.v_divider);
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
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r101.getContext()).inflate(R.layout.middle_feed_item_comment, r101, false);
        Intrinsics.checkNotNull(r102);
        return new FeedCommentViewHolder(r102);
    }

    public static String a(FeedCommentViewHolder r100, String r101, FeedCommentDetailBean r102) {
        boolean r103 = true;
        int r104 = 0;
        StringBuilder r105 = new StringBuilder(StringsKt.trim(StringsKt.trim(r101).toString(), new char[]{'\n'}));
        BaseFeedMessageDetailBean.ExtraEntity r106 = r102.getExtra();
        if (r106 == null) goto L7;
        List<String> r107 = r106.getImage_list();
        if (r107 == null) goto L7;
        int r108 = r107.size();
    L8:
        if (r108 <= 0) goto L18;
        if (r105.length() > 0) goto L13;
        r103 = false;
    L13:
        if (r103 == false) goto L15;
        r105.append("\n");
    L15:
        if (r104 >= r108) goto L18;
        r105.append("[");
        r105.append(r100.itemView.getContext().getString(R.string.Doc_Document_ExportImage));
        r105.append("]");
        r104 = r104 + 1;
    L18:
        return r105.toString();
    L7:
        r108 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ag5.a
    public final void d(RecyclerView.Adapter r110, RecyclerView.ViewHolder r111, int r112, MultiBean r210, boolean r211) {
        FeedCommentViewHolder r100 = (FeedCommentViewHolder) r111;
        FeedCommentDetailBean r101 = (FeedCommentDetailBean) r210;
        Intrinsics.checkNotNullParameter(r110, "adapter");
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.comment_markdown_enable");
        int r113 = 8;
        RichTextInjector.b(r100.f232626a, CollectionsKt.listOf(this.f232619a), this.f232621c, r102, 8);
        RichTextInjector.b(r100.f232627b, null, null, r102, 8);
        r100.f232626a.setMovementMethod(u.a());
        r100.f232626a.setOnClickListener(new b(r100));
        CommentBean.CommentDetail r103 = new CommentBean.CommentDetail();
        if (r101 == 0) goto L9;
        r103.setAnonymous(r101.isAnonymous());
        r103.setAvatar_url(r101.getAvatar_url());
        r103.setComment_id(r101.getComment_id());
        r103.setContent(r101.getContent());
        r103.setCreate_timestamp(r101.getCreate_timestamp());
        r103.setEditStatus(r101.isEditStatus());
        r103.setError(r101.getError());
        r103.setExtra(null);
        r103.setFull(r101.isFull());
        r103.setIs_whole(r101.getIs_whole());
        r103.setModify(r101.getModify());
        r103.setName(r101.getName());
        r103.setReaction(r101.getReaction());
        r103.setReaction_type(r101.getReaction_type());
        r103.setReactionDetailData(r101.getReactionDetailData());
        r103.setReactionFlowData(r101.getReactionFlowData());
        r103.setReferKey(r101.getReferKey());
        r103.setUser_id(r101.getUser_id());
        r103.setUpdate_timestamp(r101.getUpdate_timestamp());
        r103.setTranslate_status(r101.getTranslate_status());
        r103.setTranslate_content(r101.getTranslate_content());
        r103.setSending(r101.isSending());
        r103.setRetryType(r101.getRetryType());
        r103.setReply_id(r101.getReply_id());
        if ((r101 instanceof MessageBean) == false) goto L8;
        MessageBean r114 = (MessageBean) r101;
        r103.setMessageIds(new String[]{r114.getMessageId()});
        r103.setReadStatus(r114.getReadStatus());
    L8:
        r103.setMessageIds(new String[]{r101.getMessageId()});
        r103.setReadStatus(r101.getReadStatus());
    L9:
        String r115 = "";
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).e(this.f232620b, r103.getReply_id(), r103.getTranslate_status()) == false) goto L15;
        CommentTextView r116 = r100.f232626a;
        String r117 = r101.getTranslate_content();
        if (r117 != null) goto L14;
        r117 = "";
    L14:
        r116.setRawString(a(r100, r117, r101));
    L19:
        r100.f232626a.post(new c(this, r100));
        int r118 = n.v() - n.d(86);
        r100.f232626a.setMaxWidth(r118);
        r100.f232627b.setMaxWidth(r118);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).f(this.f232620b, r103.getReply_id(), r103.getTranslate_status()) == false) goto L33;
        r100.f232627b.setVisibility(0);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).d(this.f232620b, r103.getReply_id()) == false) goto L28;
        CommentTextView r104 = r100.f232627b;
        String r119 = r101.getContent();
        if (r119 == null) goto L27;
        r115 = r119;
    L27:
        r104.setRawString(a(r100, r115, r101));
    L35:
        if (Intrinsics.areEqual(r101.getTranslate_status(), "loading") == false) goto L43;
        ViewGroup.LayoutParams r105 = r100.f232628c.getLayoutParams();
        if ((r105 instanceof RelativeLayout.LayoutParams) == false) goto L39;
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r105;
    L40:
        if (r106 == null) goto L42;
        r106.addRule(8, R.id.tv_content);
    L42:
        r100.f232628c.playAnimation();
    L57:
        BearLottieView r107 = r100.f232628c;
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).a(this.f232620b, r103.getReply_id(), r103.getTranslate_status()) == false) goto L60;
        int r108 = 0;
    L61:
        r107.setVisibility(r108);
        r100.f232628c.setOnClickListener(new d(r101, r110, r112));
        r100.f232626a.setOnLongClickListener(new e(this, r112, r101));
        r100.itemView.setOnLongClickListener(new f(this, r112, r101));
        Glide.with(r100.itemView.getContext()).load(new BearGlideUrl(r101.getAvatar_url())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(R.drawable.facade_common_avatar_place_holder).into(r100.f232631f);
        r100.f232632g.setText(r101.getTitleStr());
        if (this.f232625g == false) goto L77;
        String r109 = r101.getQuote();
        if (r109 != null) goto L66;
    L69:
        boolean r120 = true;
    L70:
        if (r120 == true) goto L77;
        r100.f232629d.setVisibility(0);
        TextView r121 = r100.f232630e;
        if (r101.getCommentType() != 2) goto L75;
        CharSequence r122 = r100.f232630e.getContext().getText(R.string.LarkCCM_Docs_Suggestion_Title);
    L76:
        r121.setText(r122);
    L78:
        TextView r123 = r100.f232633h;
        String r124 = zu5.a.b(r100.f232626a.getContext(), r101.getCreateTime() * ((long) 1000));     // Catch: Exception -> L81
    L82:
        r123.setText(r124);
        r100.f232631f.setOnClickListener(new g(r101, this));
        tt5.a.h("FeedItemComment", "read message +" + r112);
        View r125 = r100.f232634i;
        if (r101.getReadStatus() != 1) goto L85;
        int r126 = 0;
    L86:
        r125.setVisibility(r126);
        View r127 = r100.f232635j;
        if (r101.isLastItem() == true) goto L90;
        r113 = 0;
    L90:
        r127.setVisibility(r113);
        r100.f232627b.setBackgroundResource(R.drawable.comment_translate_bg);
        r100.itemView.setOnClickListener(new h(this, r101));
        CommentTextView r128 = r100.f232626a;
        CommentTextView r129 = r100.f232627b;
        BearLottieView r130 = r100.f232628c;
        if (r130.getVisibility() == 0) goto L94;
        return;
    L94:
        if (r129.getVisibility() != 0) goto L96;
        r128 = r129;
    L96:
        r128.getViewTreeObserver().addOnPreDrawListener(new eg5.a(r128, r130));
        return;
    L85:
        r126 = 8;
    L81:
        tt5.a.k("FeedItemComment", "the time isn't right");
        r124 = String.valueOf(r101.getCreate_timestamp());
        goto L82
    L75:
        r122 = r101.getQuote();
        goto L76
    L66:
        if (r109.length() == 0) goto L69;
        r120 = false;
    L77:
        r100.f232629d.setVisibility(8);
        goto L78
    L60:
        r108 = 8;
        goto L61
    L39:
        r106 = null;
        goto L40
    L43:
        r100.f232628c.cancelAnimation();
        r100.f232628c.setFrame(0);
        if (r100.f232627b.getVisibility() != 0) goto L51;
        ViewGroup.LayoutParams r131 = r100.f232628c.getLayoutParams();
        if ((r131 instanceof RelativeLayout.LayoutParams) == false) goto L48;
        RelativeLayout.LayoutParams r132 = (RelativeLayout.LayoutParams) r131;
    L49:
        if (r132 == null) goto L57;
        r132.addRule(8, R.id.tv_content_translate);
        goto L57
    L48:
        r132 = null;
        goto L49
    L51:
        ViewGroup.LayoutParams r133 = r100.f232628c.getLayoutParams();
        if ((r133 instanceof RelativeLayout.LayoutParams) == false) goto L54;
        RelativeLayout.LayoutParams r134 = (RelativeLayout.LayoutParams) r133;
    L55:
        if (r134 == null) goto L57;
        r134.addRule(8, R.id.tv_content);
        goto L57
    L54:
        r134 = null;
        goto L55
    L28:
        CommentTextView r135 = r100.f232627b;
        String r136 = r101.getTranslate_content();
        if (r136 == null) goto L32;
        r115 = r136;
    L32:
        r135.setRawString(a(r100, r115, r101));
        goto L35
    L33:
        r100.f232627b.setVisibility(8);
        goto L35
    L15:
        CommentTextView r137 = r100.f232626a;
        String r138 = r101.getContent();
        if (r138 != null) goto L18;
        r138 = "";
    L18:
        r137.setRawString(a(r100, r138, r101));
        goto L19
    }

    public FeedItemComment(String r100, TranslateConfig r101, un5.a.InterfaceC7903a r102, dg5.h r103, dg5.i r104, dg5.j r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "userToken");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "fileSpanClickListener");
        Intrinsics.checkNotNullParameter(r103, "longListener");
        Intrinsics.checkNotNullParameter(r104, "toMessage");
        Intrinsics.checkNotNullParameter(r105, "gotoProfile");
        this.f232619a = r100;
        this.f232620b = r101;
        this.f232621c = r102;
        this.f232622d = r103;
        this.f232623e = r104;
        this.f232624f = r105;
        this.f232625g = r106;
    }
}
