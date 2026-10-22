package com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementAdapter;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.accessibility.b;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.exposure.RecyclerViewItemExposureHelper;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.orderlist.list.viewmodel.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListOftenBuyListViewManager extends BaseSlcViewManager<OrderListSlcOftenBuyElementView> {
    public RecyclerViewItemExposureHelper H3;
    public final OftenBuyListBindDataFixHelper I3;
    public final List<String> J3;
    public final Function0<OrderListFragment> K3;

    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy.OrderListSlcOftenBuyElementView] */
    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new OrderListSlcOftenBuyElementView(r5, null, 6, 0);
        OrderListOftenBuyRecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L5;
        r1.setLayoutManager(new LinearLayoutManager(r5, 0, false));
    L5:
        if (r1 == null) goto L7;
        this.H3 = new RecyclerViewItemExposureHelper(r1);
    L7:
        return r0;
    }

    public final b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((OrderListSlcOftenBuyElementView) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new b(this, true);
    }

    public final void w0(final Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCtx");
        OrderListOftenBuyRecyclerView r0 = ((OrderListSlcOftenBuyElementView) getView()).getRecyclerView();
        if (r0 != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r1 = r0.getAdapter();
        if ((r1 instanceof SlcListElementAdapter) == true) goto L8;
        r1 = null;
    L8:
        final SlcListElementAdapter r2 = (SlcListElementAdapter) r1;
        if (r2 != null) goto L11;
        return;
    L11:
        OftenBuyListBindDataFixHelper r3 = this.I3;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "recyclerView");
        r3.b = r0;
        if (r0.isComputingLayout() == false) goto L14;
        this.I3.a(new OrderListOftenBuyListViewManager$onAfterBindSelf$1(this, r2, r5));
        return;
    L14:
        r2.y2(r5);
        RecyclerViewItemExposureHelper r6 = this.H3;
        if (r6 == null) goto L19;
        r6.k(new OrderListOftenBuyListViewManager$onAfterBindSelf$2(this));
        return;
    }

    public final void y0(SlcElement r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        List r5 = r4.getElements();
        OrderListOftenBuyRecyclerView r0 = ((OrderListSlcOftenBuyElementView) getView()).getRecyclerView();
        if (r0 == null) goto L8;
        r0.setAdapter(new SlcListElementAdapter(((BaseSlcViewManager) this).a, r5));
        return;
    }

    public OrderListOftenBuyListViewManager(SlcTemplateContext r2, Function0<OrderListFragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragmentProvider");
        super(r2);
        this.K3 = r3;
        this.I3 = new OftenBuyListBindDataFixHelper(r3);
        this.J3 = new ArrayList();
    }

    public static final void k1(OrderListOftenBuyListViewManager r7, int r8) {
        OrderListFragment r0 = (OrderListFragment) r7.K3.invoke();
        if (r0 == null) goto L17;
        OrderListViewModel r1 = r0.Y90();
        if (r1 == null) goto L18;
        a r2 = r1.getStaticState();
        if (r2 == null) goto L19;
        Integer r3 = r2.l;
        if (r3 == null) goto L20;
        int r4 = r3.intValue();
        StringBuilder r5 = new StringBuilder();
        r5.append(r4);
        r5.append('_');
        r5.append(r8);
        final String r6 = r5.toString();
        if (((ArrayList) r7.J3).contains(r6) == true) goto L22;
        Lazy r9 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListOftenBuyListViewManager", new OrderListOftenBuyListViewManager$reportTracker$1(r6));
        ((ArrayList) r7.J3).add(r6);
        BaseSlcViewManager r10 = SlcViewExtensionsKt.g(r7.getView());
        if (r10 == null) goto L21;
        r10.a.d(new SlcCommonAction("re_shop_show_track_" + r8, MapsKt.emptyMap()), r7.getView(), r10.l(), null, null);
        return;
    L21:
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }
}
