package com.bytedance.android.shopping.orderlist.list.yata.ability;

import com.bytedance.android.ec.core.opt.ab.q;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.g;
import com.bytedance.android.shopping.orderlist.common.utils.h;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.orderlist.common.yata.abilities.a {
    public final AtomicBoolean a;
    public final OrderListViewModel b;
    public final WeakReference<OrderListFragment> c;

    @Override // com.bytedance.android.shopping.orderlist.common.yata.abilities.a
    public final void a() {
        if (this.a.compareAndSet(false, true) == false) goto L10;
        Map<String, ig3.a> r0 = ig3.a.h;
        ig3.a r1 = ig3.a.C0206a.a(this.b.getStaticState().b);
        if (r1 == null) goto L9;
        OrderCommonFirstScreenMonitor r2 = r1.a;
        if (r2 == null) goto L9;
        r2.a(FirstScreenPoint.RENDER_END);
    L9:
        h.a(new g(3, new b(this)), this.c);
    L10:
        int r3 = q.a;
    }

    public c(OrderListViewModel r2, WeakReference<OrderListFragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.b = r2;
        this.c = r3;
        this.a = new AtomicBoolean(false);
    }
}
