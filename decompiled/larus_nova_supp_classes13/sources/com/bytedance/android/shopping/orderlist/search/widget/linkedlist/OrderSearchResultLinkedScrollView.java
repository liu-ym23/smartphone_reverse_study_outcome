package com.bytedance.android.shopping.orderlist.search.widget.linkedlist;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.gul.EmptyGULView;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.android.shopping.orderlist.search.viewmodel.d;
import com.bytedance.android.shopping.orderlist.search.widget.gul.OrderSearchResultGULView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/widget/linkedlist/OrderSearchResultLinkedScrollView;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/BaseLinkedScrollView;", "Lcom/bytedance/android/shopping/orderlist/search/container/a;", "getRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/search/container/a;", "refreshHelper", "Lcom/bytedance/android/shopping/orderlist/search/viewmodel/OrderSearchResultViewModel;", "getViewModel", "()Lcom/bytedance/android/shopping/orderlist/search/viewmodel/OrderSearchResultViewModel;", "viewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSearchResultLinkedScrollView extends BaseLinkedScrollView {
    public OrderSearchResultLinkedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderSearchResultLinkedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final com.bytedance.android.shopping.orderlist.search.container.a getRefreshHelper() {
        Object r0 = d0.a.getActivity(getContext());
        if ((r0 instanceof OrderSearchResultActivity) == true) goto L5;
        r0 = null;
    L5:
        OrderSearchResultActivity r1 = (OrderSearchResultActivity) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.G1();
    }

    private final OrderSearchResultViewModel getViewModel() {
        Object r0 = d0.a.getActivity(getContext());
        if ((r0 instanceof OrderSearchResultActivity) == true) goto L5;
        r0 = null;
    L5:
        OrderSearchResultActivity r1 = (OrderSearchResultActivity) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.I1();
    }

    public final void q() {
        Intrinsics.checkNotNullParameter("OrderSearchResultRefreshHelper-onUpScreenFinish", "tag");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRefreshHelper-onUpScreenFinish", OrderSearchResultLinkedScrollView$initOrReloadGUL$1.INSTANCE);
        jg3.b r1 = getGulContainer();
        if ((r1 instanceof OrderSearchResultGULView) == true) goto L5;
        r1 = null;
    L5:
        OrderSearchResultGULView r2 = (OrderSearchResultGULView) r1;
        if (r2 == null) goto L9;
        r2.h();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final jg3.b d() {
        OrderSearchResultViewModel r0 = getViewModel();
        if (r0 == null) goto L12;
        d r1 = r0.getStaticState();
        if (r1 == null) goto L12;
        OrderSearchResultParams r2 = r1.g;
        if (r2 == null) goto L12;
        if (r2.isHideGul() != true) goto L12;
        return new EmptyGULView(getContext());
    L12:
        return new OrderSearchResultGULView(getContext(), null, 0);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final boolean l() {
        com.bytedance.android.shopping.orderlist.search.container.a r0 = getRefreshHelper();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() != true) goto L7;
        return true;
    }

    public OrderSearchResultLinkedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a c(jg3.b r8, OrderCommonYataView r9, OrderCommonRefreshSloganView r10) {
        Intrinsics.checkNotNullParameter(r8, "gulContainer");
        Intrinsics.checkNotNullParameter(r9, "yataContainer");
        Intrinsics.checkNotNullParameter(r10, "footContainer");
        return new a(getContext(), this, r8, r9, r10);
    }

    public /* synthetic */ OrderSearchResultLinkedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
