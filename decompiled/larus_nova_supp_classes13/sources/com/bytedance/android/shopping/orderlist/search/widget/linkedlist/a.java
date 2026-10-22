package com.bytedance.android.shopping.orderlist.search.widget.linkedlist;

import android.content.Context;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchRequestType;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends BaseLinkedFootHelper {
    public final Context h;
    public final jg3.b i;

    public final com.bytedance.android.shopping.orderlist.search.container.a j() {
        Object r0 = d0.a.getActivity(this.h);
        if ((r0 instanceof OrderSearchResultActivity) == true) goto L5;
        r0 = null;
    L5:
        OrderSearchResultActivity r1 = (OrderSearchResultActivity) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.G1();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper
    public final void g(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.bytedance.android.shopping.orderlist.search.container.a r1 = j();
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
    public final void h(e r3) {
        Intrinsics.checkNotNullParameter(r3, "resp");
        com.bytedance.android.shopping.orderlist.search.container.a r0 = j();
        if (r0 == null) goto L6;
        r0.h(OrderSearchRequestType.FOOT_REQUEST, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedFootHelper
    public final boolean i(Function1<? super e, Unit> r3, Function0<Unit> r4) {
        com.bytedance.android.shopping.orderlist.search.container.a r0 = j();
        if (r0 != null) goto L6;
        return false;
    L6:
        r0.j(OrderSearchRequestType.FOOT_REQUEST, r3, r4);
        return true;
    }

    public a(Context r2, BaseLinkedScrollView r3, jg3.b r4, OrderCommonYataView r5, OrderCommonRefreshSloganView r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "gulContainer");
        Intrinsics.checkNotNullParameter(r5, "yataContainer");
        Intrinsics.checkNotNullParameter(r6, "footContainer");
        super(r2, r3, r4, r5, r6);
        this.h = r2;
        this.i = r4;
    }
}
