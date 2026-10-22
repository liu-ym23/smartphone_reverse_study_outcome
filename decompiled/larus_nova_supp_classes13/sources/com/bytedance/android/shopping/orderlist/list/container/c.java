package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.list.slice.elements.tab.OrderListTabLayout;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.utils.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface c {
    void a();

    OrderCommonYataPageCallbackImpl b();

    boolean c();

    void d();

    void e();

    void f();

    void g();

    void h(OrderListRequestType r1);

    void i(OrderListTabLayout r1);

    boolean isRequesting();

    void j(com.bytedance.android.shopping.orderlist.list.widget.gul.e r1);

    void k(OrderListRequestType r1, com.bytedance.kmp.ec.yata.common.protocol.data.e r2, Function0<Unit> r3);

    boolean l(OrderListRequestType r1);

    void m(OrderListTracker.ChangeTabType r1, String r2);

    void n(boolean r1);

    void o(t r1);

    void u0(int r1);
}
