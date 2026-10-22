package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.feed.export.bean.DeleteBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class FeedItemDelete extends AbsFeedItemBase<DeleteBean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f232636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f232637c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedItemDelete$FeedMentionViewHolder;", "Lcom/bytedance/ee/bear/middleground/feed/view/adapter/AbsFeedItemBase$FeedBaseViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTvContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "setMTvContent", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;)V", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "setMUserImg", "(Landroid/widget/ImageView;)V", "mUnReadIco", "getMUnReadIco", "()Landroid/view/View;", "setMUnReadIco", "mDivider", "getMDivider", "setMDivider", "mTvTime", "Landroid/widget/TextView;", "getMTvTime", "()Landroid/widget/TextView;", "setMTvTime", "(Landroid/widget/TextView;)V", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedMentionViewHolder extends AbsFeedItemBase.FeedBaseViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CommentTextView f232638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f232639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f232640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f232641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f232642e;

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final View T3() {
            return this.f232641d;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final CommentTextView U3() {
            return this.f232638a;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final TextView V3() {
            return this.f232642e;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final View W3() {
            return this.f232640c;
        }

        @Override // com.bytedance.ee.bear.middleground.feed.view.adapter.AbsFeedItemBase.FeedBaseViewHolder
        public final ImageView X3() {
            return this.f232639b;
        }

        public FeedMentionViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f232638a = (CommentTextView) this.itemView.findViewById(R.id.tv_content);
            this.f232639b = (ImageView) this.itemView.findViewById(R.id.user_msg_image);
            this.f232640c = this.itemView.findViewById(R.id.unread_ico);
            this.f232641d = this.itemView.findViewById(R.id.v_divider);
            this.f232642e = (TextView) this.itemView.findViewById(R.id.tv_create_at);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // ag5.a
    public final int b() {
        return 2;
    }

    public FeedItemDelete(dg5.f r100, dg5.g r101) {
        Intrinsics.checkNotNullParameter(r100, "toMessage");
        Intrinsics.checkNotNullParameter(r101, "gotoProfile");
        super(r101);
        this.f232636b = r100;
        this.f232637c = r101;
    }

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r101.getContext()).inflate(R.layout.middle_feed_item_delete, r101, false);
        Intrinsics.checkNotNull(r102);
        return new FeedMentionViewHolder(r102);
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102, MultiBean r103, boolean r104) {
        AbsFeedItemBase.FeedBaseViewHolder r105 = (AbsFeedItemBase.FeedBaseViewHolder) r101;
        DeleteBean r106 = (DeleteBean) r103;
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r105, "holder");
        Intrinsics.checkNotNullParameter(r106, "data");
        a(r100, r105, r106);
        r105.U3().setRawString(r106.getTitleStr());
        r105.U3().setOnClickListener(new i(r105));
        r105.itemView.setOnClickListener(new j(this, r106));
    }
}
