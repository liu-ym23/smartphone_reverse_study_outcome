package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements PagerSnapScrollListener.a {
    public final /* synthetic */ ECFloatWindowCarouselPresenter a;
    public final /* synthetic */ ScrollingLinearLayoutManager b;
    public final /* synthetic */ RecyclerView c;

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void a(int r1, float r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageScrollStateChanged(int r2) {
        if (r2 != 1) goto L6;
        this.a.F(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageSelected(int r4) {
        ECFloatWindowCarouselPresenter r5 = this.a;
        ECFloatWindowCarouselPresenter.D(r5, this.b, this.c, r5.E());
    }

    public b(ECFloatWindowCarouselPresenter r1, ScrollingLinearLayoutManager r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
