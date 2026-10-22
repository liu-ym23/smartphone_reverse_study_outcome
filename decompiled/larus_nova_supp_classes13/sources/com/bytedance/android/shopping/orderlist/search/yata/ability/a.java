package com.bytedance.android.shopping.orderlist.search.yata.ability;

import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.orderlist.common.yata.abilities.a {
    public final AtomicBoolean a;
    public final OrderSearchResultViewModel b;

    @Override // com.bytedance.android.shopping.orderlist.common.yata.abilities.a
    public final void a() {
        if (this.a.compareAndSet(false, true) == false) goto L10;
        Map<String, ig3.a> r0 = ig3.a.h;
        ig3.a r1 = ig3.a.C0206a.a(this.b.getStaticState().c);
        if (r1 == null) goto L11;
        OrderCommonFirstScreenMonitor r2 = r1.a;
        if (r2 == null) goto L12;
        r2.a(FirstScreenPoint.RENDER_END);
        return;
    L12:
        return;
    L11:
        return;
    }

    public a(OrderSearchResultViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.b = r2;
        this.a = new AtomicBoolean(false);
    }
}
