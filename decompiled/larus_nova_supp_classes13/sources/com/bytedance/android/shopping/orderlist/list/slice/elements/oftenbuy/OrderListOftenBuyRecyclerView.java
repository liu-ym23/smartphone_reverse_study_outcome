package com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/oftenbuy/OrderListOftenBuyRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListOftenBuyRecyclerView extends RecyclerView {
    public OrderListOftenBuyRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderListOftenBuyRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(final MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListOftenBuyRecyclerView", new AnonymousClass1(r3));
        final boolean r4 = super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
        OrderCommonLog.a("OrderListOftenBuyRecyclerView", new AnonymousClass2(r4));
        return r4;
    }

    public final boolean onInterceptTouchEvent(final MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListOftenBuyRecyclerView", new C02961(r4));
        final boolean r1 = super.onInterceptTouchEvent(r4);
        OrderCommonLog.a("OrderListOftenBuyRecyclerView", new C02972(r4, r1));
        return r1;
    }

    public final boolean onTouchEvent(final MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListOftenBuyRecyclerView", new C02981(r3));
        return super.onTouchEvent(r3);
    }

    public OrderListOftenBuyRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ OrderListOftenBuyRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
