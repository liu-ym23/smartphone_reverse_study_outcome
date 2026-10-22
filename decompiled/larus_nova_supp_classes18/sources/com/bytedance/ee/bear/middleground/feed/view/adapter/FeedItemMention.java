package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import dg5.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FeedItemMention extends AbsFeedItemBase<AtBean> {
    public final Function1<String, Unit> b;
    public final Function1<String, Unit> c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedItemMention$FeedMentionViewHolder;", "Lcom/bytedance/ee/bear/middleground/feed/view/adapter/AbsFeedItemBase$FeedBaseViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTvContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "setMTvContent", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;)V", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "setMUserImg", "(Landroid/widget/ImageView;)V", "mUnReadIco", "getMUnReadIco", "()Landroid/view/View;", "setMUnReadIco", "mDivider", "getMDivider", "setMDivider", "mTvTime", "Landroid/widget/TextView;", "getMTvTime", "()Landroid/widget/TextView;", "setMTvTime", "(Landroid/widget/TextView;)V", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedMentionViewHolder extends AbsFeedItemBase.FeedBaseViewHolder {
        public final CommentTextView a;
        public final ImageView b;
        public final View c;
        public final View d;
        public final TextView e;

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final View T3() {
            return this.d;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final CommentTextView U3() {
            return this.a;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final TextView V3() {
            return this.e;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final View W3() {
            return this.c;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final ImageView X3() {
            return this.b;
        }

        public FeedMentionViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (CommentTextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390392);
            this.b = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392043);
            this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391881);
            this.d = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392112);
            this.e = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390459);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // ag5.a
    public final int b() {
        return 1;
    }

    public FeedItemMention(dg5.k r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "toMessage");
        Intrinsics.checkNotNullParameter(r3, "gotoProfile");
        super(r3);
        this.b = r2;
        this.c = r3;
    }

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563639, r4, false);
        Intrinsics.checkNotNull(r5);
        return new FeedMentionViewHolder(r5);
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r1, RecyclerView.ViewHolder r2, int r3, MultiBean r4, boolean r5) {
        AbsFeedItemBase.FeedBaseViewHolder r6 = (AbsFeedItemBase.FeedBaseViewHolder) r2;
        AtBean r7 = (AtBean) r4;
        Intrinsics.checkNotNullParameter(r1, "adapter");
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
        a(r1, r6, r7);
        r6.U3().setRawString(r7.getContent());
        r6.U3().setOnClickListener(new k(r6));
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new l(r6, r7, this));
    }
}
