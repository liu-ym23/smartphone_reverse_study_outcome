package uw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.squarefeed.viewholder.SimpleLiveViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f551924a;

    public d(e r100) {
        this.f551924a = r100;
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r110) {
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_feed_live_simple, r100, false);
        e r111 = this.f551924a;
        return new SimpleLiveViewHolder(r101, r111.f551927c, r111.f551928d, r111.f551926b, r111.f551929e);
    }
}
