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
import gg5.o;
import gg5.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseFeedItemAdapter<T extends BaseContent> implements ag5.a<NormalFeedItemViewHolder, Notice<T>> {
    public final Function5<String, String, String, Boolean, Notice<?>, Unit> a;
    public final Function1<String, Unit> b;
    public final boolean c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/apapterv2/BaseFeedItemAdapter$NormalFeedItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mQuoteLayout", "getMQuoteLayout", "()Landroid/view/View;", "mTvQuote", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvQuote", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "mTvName", "Landroid/widget/TextView;", "getMTvName", "()Landroid/widget/TextView;", "mTvTime", "getMTvTime", "mUnReadIco", "getMUnReadIco", "subContent", "Landroid/widget/FrameLayout;", "getSubContent", "()Landroid/widget/FrameLayout;", "mDivider", "getMDivider", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NormalFeedItemViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final CommentTextView b;
        public final ImageView c;
        public final TextView d;
        public final TextView e;
        public final View f;
        public final FrameLayout g;
        public final View h;

        public NormalFeedItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131383579);
            this.b = (CommentTextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367324);
            this.c = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392043);
            this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
            this.e = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390459);
            this.f = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391881);
            this.g = (FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387527);
            this.h = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392112);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/apapterv2/BaseFeedItemAdapter$TitleSpan;", "Landroid/text/style/StyleSpan;", "style", "", "color", "<init>", "(ILjava/lang/Integer;)V", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleSpan extends StyleSpan {
        public final Integer a;

        public TitleSpan() {
            this(0);
        }

        public /* synthetic */ TitleSpan(int r2) {
            this(1, null);
        }

        @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            super.updateDrawState(r2);
            Integer r0 = this.a;
            if (r0 == null) goto L7;
            if (r2 == null) goto L8;
            r2.setColor(r0.intValue());
            return;
        L8:
            return;
        }

        public TitleSpan(int r1, Integer r2) {
            super(r1);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public boolean a(View r1, int r2, Notice<?> r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r3, "notice");
        return false;
    }

    public abstract void e(View r1, FrameLayout r2, Notice<T> r3, int r4);

    public abstract View f(LayoutInflater r1, ViewGroup r2);

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r5 = LayoutInflater.from(r4.getContext());
        View r6 = r5.inflate(2131558768, r4, false);
        Intrinsics.checkNotNull(r6);
        NormalFeedItemViewHolder r0 = new NormalFeedItemViewHolder(r6);
        FrameLayout r7 = r0.g;
        Intrinsics.checkNotNull(r5);
        r7.addView(f(r5, r0.g));
        return r0;
    }

    public BaseFeedItemAdapter(o r2, p r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "toMessage");
        Intrinsics.checkNotNullParameter(r3, "gotoProfile");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r18, RecyclerView.ViewHolder r19, int r20, MultiBean r21, boolean r22) {
        NormalFeedItemViewHolder r2 = (NormalFeedItemViewHolder) r19;
        Notice<T> r3 = (Notice) r21;
        Intrinsics.checkNotNullParameter(r18, "adapter");
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        ContentWraper<Content> r5 = r3.getContent();
        if (r5 == 0) goto L59;
        BaseContent r6 = (BaseContent) r5.getData();
        if (r6 == null) goto L60;
        String r7 = r6.getAvatarUrl();
        int r8 = 0;
        if (r7 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        r2.c.setImageResource(kac.a.b(2131254630));
    L18:
        if (r6.getTitle() != null) goto L20;
        r2.d.setVisibility(8);
    L25:
        if (this.c == false) goto L42;
        ArrayList<TextContext> r10 = r6.getQuote();
        if (r10 != null) goto L29;
    L32:
        boolean r11 = true;
    L33:
        if (r11 == true) goto L42;
        r2.a.setVisibility(0);
        StringBuilder r12 = new StringBuilder();
        ArrayList<TextContext> r13 = r6.getQuote();
        if (r13 == null) goto L41;
        Iterator<T> r14 = r13.iterator();
    L39:
        if (r14.hasNext() == false) goto L41;
        r12.append(cg5.a.a((TextContext) r14.next()));
    L41:
        int r15 = RichTextInjector.a;
        RichTextInjector.c(r2.b, null, null, null, 2131106607, false, 32);
        r2.b.setRawString(r12.toString());
    L43:
        TextView r16 = r2.e;
        String r17 = zu5.a.b(r2.e.getContext(), r3.getNoticeTime());     // Catch: Exception -> L46
    L47:
        r16.setText(r17);
        r2.c.setOnClickListener(new com.bytedance.ee.bear.middleground.feed.view.apapterv2.a(r6, this));
        tt5.a.h("FeedItemComment", "read message +" + r20);
        View r4 = r2.f;
        if (r3.getReadStatus() != 0) goto L50;
        int r23 = 0;
    L51:
        r4.setVisibility(r23);
        ((RecyclerView.ViewHolder) r2).itemView.setOnLongClickListener(new b(this, r20, r3));
        e(((RecyclerView.ViewHolder) r2).itemView, r2.g, r3, r20);
        View r1 = r2.h;
        if (r22 == false) goto L54;
        r8 = 8;
    L54:
        r1.setVisibility(r8);
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new c(this, r3));
        return;
    L50:
        r23 = 8;
    L46:
        tt5.a.k("FeedItemComment", "the time isn't right");
        r17 = "";
        goto L47
    L29:
        if (r10.isEmpty() == true) goto L32;
        r11 = false;
    L42:
        r2.a.setVisibility(8);
        goto L43
    L20:
        r2.d.setVisibility(0);
        TextView r24 = r2.d;
        Context r110 = r24.getContext();
        TextContext r111 = r6.getTitle();
        TextContext r112 = r6.getSubTitle();
        String r113 = cg5.a.a(r111);
        SpannableStringBuilder r114 = new SpannableStringBuilder(r113 + cg5.a.a(r112));
        r114.setSpan(new TitleSpan(r8), 0, r113.length(), 33);
        int r115 = r113.length();
        int r116 = r114.length();
        if (r115 >= r116) goto L23;
        r114.setSpan(new TitleSpan(0, Integer.valueOf(ContextCompat.getColor(r110, 2131106620))), r115, r116, 33);
    L23:
        r24.setText(r114);
        goto L25
    L16:
        Intrinsics.checkNotNull(Glide.with(((RecyclerView.ViewHolder) r2).itemView.getContext()).load(new BearGlideUrl(r6.getAvatarUrl())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131235295).into(r2.c));
        goto L18
    L10:
        if (r7.length() == 0) goto L13;
        r9 = false;
        goto L14
    L60:
        return;
    }
}
