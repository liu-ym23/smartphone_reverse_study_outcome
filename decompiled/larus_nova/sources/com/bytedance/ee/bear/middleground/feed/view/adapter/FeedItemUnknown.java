package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UnknownBean;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class FeedItemUnknown implements ag5.a<FeedUnknownViewHolder, UnknownBean> {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedItemUnknown$FeedUnknownViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "mTvTime", "Landroid/widget/TextView;", "getMTvTime", "()Landroid/widget/TextView;", "mUnReadIco", "getMUnReadIco", "()Landroid/view/View;", "mDivider", "getMDivider", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedUnknownViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f232656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f232657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f232658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f232659d;

        public FeedUnknownViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f232656a = (ImageView) this.itemView.findViewById(R.id.user_msg_image);
            this.f232657b = (TextView) this.itemView.findViewById(R.id.tv_create_at);
            this.f232658c = this.itemView.findViewById(R.id.unread_ico);
            this.f232659d = this.itemView.findViewById(R.id.v_divider);
        }
    }

    public static final class a {
    }

    static {
    }

    public FeedItemUnknown() {
    }

    @Override // ag5.a
    public final int b() {
        return 100;
    }

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new FeedUnknownViewHolder(LayoutInflater.from(r101.getContext()).inflate(R.layout.middle_feed_item_unknown, r101, false));
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102, MultiBean r103, boolean r110) {
        FeedUnknownViewHolder r104 = (FeedUnknownViewHolder) r101;
        UnknownBean r105 = (UnknownBean) r103;
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r104, "holder");
        Intrinsics.checkNotNullParameter(r105, "data");
        r104.f232656a.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_doc_colorful));
        TextView r106 = r104.f232657b;
        long r107 = r105.getCreateTime();
        String r108 = zu5.a.b(r104.itemView.getContext(), ((long) 1000) * r107);     // Catch: Exception -> L5
    L6:
        r106.setText(r108);
        tt5.a.h("FeedItemUnknown", "read message +" + r102);
        View r109 = r104.f232658c;
        if (r105.getReadStatus() != 1) goto L9;
        int r111 = 0;
    L10:
        r109.setVisibility(r111);
        return;
    L9:
        r111 = 8;
    L5:
        tt5.a.k("FeedItemUnknown", "the time isn't right");
        r108 = String.valueOf(r107);
        goto L6
    }
}
