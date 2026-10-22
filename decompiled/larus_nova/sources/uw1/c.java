package uw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.squarefeed.viewholder.SimpleRankViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f551923a;

    public c(e r100) {
        this.f551923a = r100;
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_feed_item_rank, r100, false);
        e r103 = this.f551923a;
        FeedDataKey r104 = r103.f551927c;
        return new SimpleRankViewHolder(r102, r103.f551928d, r103.f551926b, r103.f551929e);
    }
}
