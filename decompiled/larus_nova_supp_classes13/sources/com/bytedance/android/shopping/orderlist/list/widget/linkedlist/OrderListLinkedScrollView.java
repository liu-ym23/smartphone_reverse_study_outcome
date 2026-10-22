package com.bytedance.android.shopping.orderlist.list.widget.linkedlist;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.gul.EmptyGULView;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.container.c;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.orderlist.list.widget.gul.OrderListGULView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/linkedlist/OrderListLinkedScrollView;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/BaseLinkedScrollView;", "Lcom/bytedance/android/shopping/orderlist/list/widget/gul/OrderListGULView;", "getGulView", "Lcom/bytedance/android/shopping/orderlist/list/container/c;", "m", "Lcom/bytedance/android/shopping/orderlist/list/container/c;", "getRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/list/container/c;", "setRefreshHelper", "(Lcom/bytedance/android/shopping/orderlist/list/container/c;)V", "refreshHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListLinkedScrollView extends BaseLinkedScrollView {
    public c m;
    public OrderListViewModel n;
    public OrderListGULView o;

    public OrderListLinkedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderListLinkedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final jg3.b d() {
        OrderListViewModel r0 = this.n;
        if (r0 == null) goto L11;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r1 = r0.getStaticState();
        if (r1 == null) goto L11;
        OrderListParams r2 = r1.g;
        if (r2 == null) goto L11;
        if (r2.isHideGul() != true) goto L11;
        return new EmptyGULView(getContext());
    L11:
        OrderListGULView r3 = new OrderListGULView(getContext(), null, 0);
        this.o = r3;
        return r3;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final boolean l() {
        c r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() != true) goto L7;
        return true;
    }

    public final OrderListGULView getGulView() {
        return this.o;
    }

    public final c getRefreshHelper() {
        return this.m;
    }

    public final void setRefreshHelper(c r1) {
        this.m = r1;
    }

    public final void q(OrderListFragment r3, Integer r4) {
        Intrinsics.checkNotNullParameter("OrderListRefreshHelper-onUpScreenFinish", "tag");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper-onUpScreenFinish", OrderListLinkedScrollView$initOrReloadGUL$1.INSTANCE);
        jg3.b r1 = getGulContainer();
        if ((r1 instanceof OrderListGULView) == true) goto L5;
        r1 = null;
    L5:
        OrderListGULView r2 = (OrderListGULView) r1;
        if (r2 == null) goto L9;
        r2.q(r3, r4);
        return;
    }

    public OrderListLinkedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a c(jg3.b r10, OrderCommonYataView r11, OrderCommonRefreshSloganView r12) {
        Intrinsics.checkNotNullParameter(r10, "gulContainer");
        Intrinsics.checkNotNullParameter(r11, "yataContainer");
        Intrinsics.checkNotNullParameter(r12, "footContainer");
        return new a(getContext(), this, r10, r11, r12, this.m, this.n);
    }

    public /* synthetic */ OrderListLinkedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
