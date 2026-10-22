package com.bytedance.android.shopping.orderlist.list.widget.linkedlist;

import android.content.Context;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.android.shopping.orderlist.list.container.c;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends BaseLinkedFootHelper {
    public final jg3.b h;
    public final c i;
    public final OrderListViewModel j;

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper
    public final void g(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        c r1 = this.i;
        if (r1 == null) goto L7;
        OrderCommonYataPageCallbackImpl r2 = r1.b();
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "callback");
        r2.a.add(r3);
        return;
    L7:
        r3.invoke();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper
    public final void h(e r4) {
        Intrinsics.checkNotNullParameter(r4, "resp");
        c r0 = this.i;
        if (r0 == null) goto L6;
        r0.k(OrderListRequestType.FOOT_REQUEST, r4, null);
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper
    public final boolean i(Function1<? super e, Unit> r2, Function0<Unit> r3) {
        OrderListViewModel r4 = this.j;
        if (r4 == null) goto L9;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r5 = r4.getStaticState();
        if (r5 == null) goto L9;
        if (r5.t != true) goto L9;
        return false;
    L9:
        c r6 = this.i;
        if (r6 != null) goto L12;
        return false;
    L12:
        return r6.l(OrderListRequestType.FOOT_REQUEST);
    }

    public a(Context r2, BaseLinkedScrollView r3, jg3.b r4, OrderCommonYataView r5, OrderCommonRefreshSloganView r6, c r7, OrderListViewModel r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "gulContainer");
        Intrinsics.checkNotNullParameter(r5, "yataContainer");
        Intrinsics.checkNotNullParameter(r6, "footContainer");
        super(r2, r3, r4, r5, r6);
        this.h = r4;
        this.i = r7;
        this.j = r8;
    }
}
