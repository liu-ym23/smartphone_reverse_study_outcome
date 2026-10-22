package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larus.nova.R;
import gg5.o;
import gg5.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseFeedItemAdapter<T extends BaseContent> implements ag5.a<NormalFeedItemViewHolder, Notice<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function5<String, String, String, Boolean, Notice<?>, Unit> f232687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f232688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f232689c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/apapterv2/BaseFeedItemAdapter$NormalFeedItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mQuoteLayout", "getMQuoteLayout", "()Landroid/view/View;", "mTvQuote", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvQuote", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "mTvName", "Landroid/widget/TextView;", "getMTvName", "()Landroid/widget/TextView;", "mTvTime", "getMTvTime", "mUnReadIco", "getMUnReadIco", "subContent", "Landroid/widget/FrameLayout;", "getSubContent", "()Landroid/widget/FrameLayout;", "mDivider", "getMDivider", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NormalFeedItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f232690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CommentTextView f232691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f232692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f232693d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f232694e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f232695f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final FrameLayout f232696g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View f232697h;

        public NormalFeedItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f232690a = this.itemView.findViewById(R.id.quote_layout);
            this.f232691b = (CommentTextView) this.itemView.findViewById(R.id.comment_card_quote);
            this.f232692c = (ImageView) this.itemView.findViewById(R.id.user_msg_image);
            this.f232693d = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.f232694e = (TextView) this.itemView.findViewById(R.id.tv_create_at);
            this.f232695f = this.itemView.findViewById(R.id.unread_ico);
            this.f232696g = (FrameLayout) this.itemView.findViewById(R.id.sub_content);
            this.f232697h = this.itemView.findViewById(R.id.v_divider);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/apapterv2/BaseFeedItemAdapter$TitleSpan;", "Landroid/text/style/StyleSpan;", "style", "", "color", "<init>", "(ILjava/lang/Integer;)V", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleSpan extends StyleSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f232698a;

        public TitleSpan() {
            this(0);
        }

        public /* synthetic */ TitleSpan(int r100) {
            this(1, null);
        }

        @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            Integer r101 = this.f232698a;
            if (r101 == null) goto L7;
            if (r100 == null) goto L8;
            r100.setColor(r101.intValue());
            return;
        L8:
            return;
        }

        public TitleSpan(int r100, Integer r101) {
            super(r100);
            this.f232698a = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public boolean a(View r100, int r101, Notice<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "notice");
        return false;
    }

    public abstract void e(View r100, FrameLayout r101, Notice<T> r102, int r103);

    public abstract View f(LayoutInflater r100, ViewGroup r101);

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "parent");
        LayoutInflater r102 = LayoutInflater.from(r101.getContext());
        View r103 = r102.inflate(R.layout.base_feed_item_v2, r101, false);
        Intrinsics.checkNotNull(r103);
        NormalFeedItemViewHolder r104 = new NormalFeedItemViewHolder(r103);
        FrameLayout r105 = r104.f232696g;
        Intrinsics.checkNotNull(r102);
        r105.addView(f(r102, r104.f232696g));
        return r104;
    }

    public BaseFeedItemAdapter(o r100, p r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "toMessage");
        Intrinsics.checkNotNullParameter(r101, "gotoProfile");
        this.f232687a = r100;
        this.f232688b = r101;
        this.f232689c = r102;
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r110, RecyclerView.ViewHolder r111, int r210, MultiBean r211, boolean r212) {
        NormalFeedItemViewHolder r100 = (NormalFeedItemViewHolder) r111;
        Notice<T> r101 = (Notice) r211;
        Intrinsics.checkNotNullParameter(r110, "adapter");
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ContentWraper<Content> r102 = r101.getContent();
        if (r102 == 0) goto L59;
        BaseContent r103 = (BaseContent) r102.getData();
        if (r103 == null) goto L60;
        String r104 = r103.getAvatarUrl();
        int r105 = 0;
        if (r104 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        r100.f232692c.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_doc_colorful));
    L18:
        if (r103.getTitle() != null) goto L20;
        r100.f232693d.setVisibility(8);
    L25:
        if (this.f232689c == false) goto L42;
        ArrayList<TextContext> r107 = r103.getQuote();
        if (r107 != null) goto L29;
    L32:
        boolean r108 = true;
    L33:
        if (r108 == true) goto L42;
        r100.f232690a.setVisibility(0);
        StringBuilder r109 = new StringBuilder();
        ArrayList<TextContext> r112 = r103.getQuote();
        if (r112 == null) goto L41;
        Iterator<T> r113 = r112.iterator();
    L39:
        if (r113.hasNext() == false) goto L41;
        r109.append(cg5.a.a((TextContext) r113.next()));
    L41:
        int r114 = RichTextInjector.f232307a;
        RichTextInjector.c(r100.f232691b, null, null, null, Integer.valueOf(R.color.text_caption), false, 32);
        r100.f232691b.setRawString(r109.toString());
    L43:
        TextView r115 = r100.f232694e;
        String r116 = zu5.a.b(r100.f232694e.getContext(), r101.getNoticeTime());     // Catch: Exception -> L46
    L47:
        r115.setText(r116);
        r100.f232692c.setOnClickListener(new com.bytedance.ee.bear.middleground.feed.view.apapterv2.a(r103, this));
        tt5.a.h("FeedItemComment", "read message +" + r210);
        View r117 = r100.f232695f;
        if (r101.getReadStatus() != 0) goto L50;
        int r118 = 0;
    L51:
        r117.setVisibility(r118);
        r100.itemView.setOnLongClickListener(new b(this, r210, r101));
        e(r100.itemView, r100.f232696g, r101, r210);
        View r119 = r100.f232697h;
        if (r212 == false) goto L54;
        r105 = 8;
    L54:
        r119.setVisibility(r105);
        r100.itemView.setOnClickListener(new c(this, r101));
        return;
    L50:
        r118 = 8;
    L46:
        tt5.a.k("FeedItemComment", "the time isn't right");
        r116 = "";
        goto L47
    L29:
        if (r107.isEmpty() == true) goto L32;
        r108 = false;
    L42:
        r100.f232690a.setVisibility(8);
        goto L43
    L20:
        r100.f232693d.setVisibility(0);
        TextView r120 = r100.f232693d;
        Context r121 = r120.getContext();
        TextContext r122 = r103.getTitle();
        TextContext r123 = r103.getSubTitle();
        String r124 = cg5.a.a(r122);
        SpannableStringBuilder r125 = new SpannableStringBuilder(r124 + cg5.a.a(r123));
        r125.setSpan(new TitleSpan(r105), 0, r124.length(), 33);
        int r126 = r124.length();
        int r127 = r125.length();
        if (r126 >= r127) goto L23;
        r125.setSpan(new TitleSpan(0, Integer.valueOf(ContextCompat.getColor(r121, R.color.text_placeholder))), r126, r127, 33);
    L23:
        r120.setText(r125);
        goto L25
    L16:
        Intrinsics.checkNotNull(Glide.with(r100.itemView.getContext()).load(new BearGlideUrl(r103.getAvatarUrl())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(R.drawable.facade_common_avatar_place_holder).into(r100.f232692c));
        goto L18
    L10:
        if (r104.length() == 0) goto L13;
        r106 = false;
        goto L14
    L60:
        return;
    }
}
