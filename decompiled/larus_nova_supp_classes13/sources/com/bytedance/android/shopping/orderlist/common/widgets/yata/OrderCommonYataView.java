package com.bytedance.android.shopping.orderlist.common.widgets.yata;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonYataErrorView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/OrderCommonYataView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/a;", "Landroidx/recyclerview/widget/RecyclerView;", "getYataRecyclerView", "Lkotlin/Function0;", "", "action", "setErrorRetryListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonYataView extends FrameLayout implements a {
    public final OrderCommonYataRecyclerView a;
    public final OrderCommonYataErrorView b;
    public boolean c;

    public final boolean a() {
        if (this.c == false) goto L5;
    L7:
        return false;
    L5:
        if (this.a.canScrollVertically(-1) == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.c == false) goto L5;
    L7:
        return false;
    L5:
        if (this.a.canScrollVertically(1) == false) goto L7;
        return true;
    }

    public final void c() {
        final boolean r1 = false;
        OrderCommonErrorMonitorKt.c(null, "OrderCommonYataView-scrollToBottom", new OrderCommonYataView$scrollToBottom$1(this, r1));
    }

    public final void d() {
        final boolean r1 = false;
        OrderCommonErrorMonitorKt.c(null, "OrderCommonYataView-scrollToTop", new OrderCommonYataView$scrollToTop$1(this, r1));
    }

    public RecyclerView getYataRecyclerView() {
        return this.a;
    }

    public void setErrorRetryListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.b.setErrorRetryListener(r2);
    }

    @Override // android.view.View, com.bytedance.android.shopping.orderlist.common.widgets.yata.a
    public final void scrollBy(int r2, int r3) {
        this.a.scrollBy(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonYataErrorView] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataRecyclerView] */
    public OrderCommonYataView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        ?? r7 = new OrderCommonYataRecyclerView(r4, null, 6, 0);
        this.a = r7;
        ?? r2 = new OrderCommonYataErrorView(r4, null, 6, 0);
        this.b = r2;
        removeAllViews();
        addView(r7, new FrameLayout.LayoutParams(-1, -2));
        addView(r2, new FrameLayout.LayoutParams(-1, -2));
        r2.setVisibility(8);
    }
}
