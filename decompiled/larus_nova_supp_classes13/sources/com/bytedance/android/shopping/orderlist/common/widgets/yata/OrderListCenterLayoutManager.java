package com.bytedance.android.shopping.orderlist.common.widgets.yata;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/OrderListCenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListCenterLayoutManager extends LinearLayoutManager {
    public final Context a;

    public static final class a extends LinearSmoothScroller {
        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
            return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
        }
    }

    public OrderListCenterLayoutManager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 1, false);
        this.a = r3;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        a r4 = new a(this.a);
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
