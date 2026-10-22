package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListHeaderLoadMoreItem {
    public final View a;
    public boolean b;
    public final LoadMoreStatusView c;
    public final View d;

    public LivePromotionListHeaderLoadMoreItem(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = th.a.c(r4.getContext(), 2131564762, r4, false);
        this.a = r5;
        this.c = r5.findViewById(2131387787);
        this.d = r5.findViewById(2131390735);
    }

    public final void b(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m r3) {
        PageListLoadStatus r4 = r3.a;
        int r5 = e.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        this.a.setVisibility(0);
        this.c.a();
        this.d.setVisibility(8);
        return;
    L5:
        if (r5 != 2) goto L11;
        this.a.setVisibility(0);
        this.c.b();
        this.d.setVisibility(0);
        return;
    }

    public final void a(LifecycleOwner r3, PageListLoadStatus r4, LivePromotionListViewModel r5) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "vm");
        if (this.b == true) goto L5;
        this.b = true;
        com.bytedance.android.ec.core.arch.event.c.c(r5, r3, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m.class), new LivePromotionListHeaderLoadMoreItem$bindData$1(this));
    L5:
        if (r4 == null) goto L8;
        b(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m(r4));
        return;
    }
}
