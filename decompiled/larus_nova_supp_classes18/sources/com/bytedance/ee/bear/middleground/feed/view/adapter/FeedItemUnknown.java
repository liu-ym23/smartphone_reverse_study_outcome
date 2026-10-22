package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UnknownBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FeedItemUnknown implements ag5.a<FeedUnknownViewHolder, UnknownBean> {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedItemUnknown$FeedUnknownViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "mTvTime", "Landroid/widget/TextView;", "getMTvTime", "()Landroid/widget/TextView;", "mUnReadIco", "getMUnReadIco", "()Landroid/view/View;", "mDivider", "getMDivider", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedUnknownViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final View c;
        public final View d;

        public FeedUnknownViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392043);
            this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390459);
            this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391881);
            this.d = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392112);
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
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new FeedUnknownViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131563643, r5, false));
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r6, RecyclerView.ViewHolder r7, int r8, MultiBean r9, boolean r10) {
        FeedUnknownViewHolder r11 = (FeedUnknownViewHolder) r7;
        UnknownBean r12 = (UnknownBean) r9;
        Intrinsics.checkNotNullParameter(r6, "adapter");
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r12, WikiFolderPushPlugin.DATA);
        r11.a.setImageResource(kac.a.b(2131254630));
        TextView r13 = r11.b;
        long r0 = r12.getCreateTime();
        String r1 = zu5.a.b(((RecyclerView.ViewHolder) r11).itemView.getContext(), ((long) CCMLynxCardView.ViewType.BANNER) * r0);     // Catch: Exception -> L5
    L6:
        r13.setText(r1);
        tt5.a.h("FeedItemUnknown", "read message +" + r8);
        View r14 = r11.c;
        if (r12.getReadStatus() != 1) goto L9;
        int r15 = 0;
    L10:
        r14.setVisibility(r15);
        return;
    L9:
        r15 = 8;
    L5:
        tt5.a.k("FeedItemUnknown", "the time isn't right");
        r1 = String.valueOf(r0);
        goto L6
    }
}
