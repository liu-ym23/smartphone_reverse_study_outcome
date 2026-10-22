package zk1;

import android.widget.LinearLayout;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayFadingEdgeRecyclerView;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayListCacheWidget;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayListCacheWidget f572604a;

    @Override // zk1.h.b
    public final void a() {
        ReplayListCacheWidget r100 = this.f572604a;
        ((LinearLayout) r100.contentView.findViewById(R.id.vs_cache_empty_container)).setVisibility(0);
        ((LinearLayout) r100.contentView.findViewById(R.id.vs_cache_error_container)).setVisibility(8);
        LiveDoubleColorBallAnimationView r101 = (LiveDoubleColorBallAnimationView) r100.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r101 == null) goto L5;
        r101.c();
    L5:
        LiveDoubleColorBallAnimationView r102 = (LiveDoubleColorBallAnimationView) r100.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ((ReplayFadingEdgeRecyclerView) r100.contentView.findViewById(R.id.vs_cache_rv)).setVisibility(8);
        ReplayListCacheWidget.wq(this.f572604a, "no_episodes");
    }

    @Override // zk1.h.b
    public final void onError() {
        ReplayListCacheWidget r100 = this.f572604a;
        ((LinearLayout) r100.contentView.findViewById(R.id.vs_cache_error_container)).setVisibility(0);
        ((LinearLayout) r100.contentView.findViewById(R.id.vs_cache_empty_container)).setVisibility(8);
        LiveDoubleColorBallAnimationView r101 = (LiveDoubleColorBallAnimationView) r100.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r101 == null) goto L5;
        r101.c();
    L5:
        LiveDoubleColorBallAnimationView r102 = (LiveDoubleColorBallAnimationView) r100.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ((ReplayFadingEdgeRecyclerView) r100.contentView.findViewById(R.id.vs_cache_rv)).setVisibility(8);
        ReplayListCacheWidget.wq(this.f572604a, BuyNowCloseMethod.NETWORK_ERROR);
    }

    @Override // zk1.h.b
    public final void onSuccess() {
        ReplayListCacheWidget r100 = this.f572604a;
        ((LinearLayout) r100.contentView.findViewById(R.id.vs_cache_error_container)).setVisibility(8);
        ((LinearLayout) r100.contentView.findViewById(R.id.vs_cache_empty_container)).setVisibility(8);
        LiveDoubleColorBallAnimationView r101 = (LiveDoubleColorBallAnimationView) r100.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r101 == null) goto L5;
        r101.c();
    L5:
        LiveDoubleColorBallAnimationView r102 = (LiveDoubleColorBallAnimationView) r100.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ((ReplayFadingEdgeRecyclerView) r100.contentView.findViewById(R.id.vs_cache_rv)).setVisibility(0);
        ReplayListCacheWidget.wq(this.f572604a, "normal");
    }

    public m(ReplayListCacheWidget r100) {
        this.f572604a = r100;
    }
}
