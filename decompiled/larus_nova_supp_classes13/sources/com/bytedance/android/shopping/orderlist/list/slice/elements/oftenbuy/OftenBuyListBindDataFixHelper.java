package com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import java.util.ArrayDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OftenBuyListBindDataFixHelper {
    public final Lazy a;
    public RecyclerView b;
    public final ArrayDeque<Function0<Unit>> c;
    public boolean d;
    public final Function0<OrderListFragment> e;

    public final void b() {
        OrderListFragment r0 = (OrderListFragment) this.e.invoke();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isDetached() == false) goto L8;
        return;
    L8:
        if (r0.isRemoving() == true) goto L13;
        this.d = true;
        ((Handler) this.a.getValue()).post(new OftenBuyListBindDataFixHelper$knockTask$1(this));
        return;
    }

    public OftenBuyListBindDataFixHelper(Function0<OrderListFragment> r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentProvider");
        this.e = r2;
        this.a = LazyKt.lazy(OftenBuyListBindDataFixHelper$mainDispatcher$2.INSTANCE);
        this.c = new ArrayDeque();
    }

    public final void a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.c.offer(r2);
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.a("OftenBuyListBindDataFixHelper", new OftenBuyListBindDataFixHelper$addTask$1(this));
        if (this.d == true) goto L5;
        OrderCommonLog.a("OftenBuyListBindDataFixHelper", OftenBuyListBindDataFixHelper$addTask$2.INSTANCE);
        b();
        return;
    L5:
        OrderCommonLog.a("OftenBuyListBindDataFixHelper", OftenBuyListBindDataFixHelper$addTask$3.INSTANCE);
    }
}
