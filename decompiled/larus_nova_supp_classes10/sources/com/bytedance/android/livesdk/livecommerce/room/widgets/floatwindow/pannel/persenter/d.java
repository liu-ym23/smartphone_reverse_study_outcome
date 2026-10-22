package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ECFloatWindowCarouselPresenter a;
    public final /* synthetic */ ScrollingLinearLayoutManager b;
    public final /* synthetic */ ECCarouselIndicatorView c;
    public final /* synthetic */ RecyclerView d;

    public d(ECFloatWindowCarouselPresenter r1, ScrollingLinearLayoutManager r2, ECCarouselIndicatorView r3, RecyclerView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        ScrollingLinearLayoutManager r0 = this.b;
        r0.a = r5.booleanValue();
        if (r5.booleanValue() == false) goto L5;
        this.a.E().safeNotifyDataSetChanged();
    L5:
        ECCarouselIndicatorView r1 = this.c;
        if (r5.booleanValue() == true) goto L8;
    L10:
        int r2 = 8;
    L11:
        r1.setVisibility(r2);
        this.a.F(r5.booleanValue());
        this.d.post(new c(this));
        return;
    L8:
        if (this.a.E().getItemCount() <= 1) goto L10;
        r2 = 0;
        goto L11
    }
}
