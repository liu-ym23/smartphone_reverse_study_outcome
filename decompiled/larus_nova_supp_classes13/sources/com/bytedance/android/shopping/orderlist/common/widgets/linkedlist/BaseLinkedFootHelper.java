package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class BaseLinkedFootHelper implements com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a {
    public boolean a;
    public int b;
    public final int c;
    public final BaseLinkedScrollView d;
    public final jg3.b e;
    public final com.bytedance.android.shopping.orderlist.common.widgets.yata.a f;
    public final OrderCommonRefreshSloganView g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BaseLinkedFootHelper a;

        public b(BaseLinkedFootHelper r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a.d.b() == false) goto L5;
            this.a.e();
            return;
        L5:
            this.a.b();
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void b() {
        final String r2 = "BaseLinkedFootHelper-startGULFootRefresh";
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("展示Foot", new BaseLinkedFootHelper$startGULFootRefresh$1(this, r2)), com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("等待GUL加载完成展示GUL", new BaseLinkedFootHelper$startGULFootRefresh$2(this, r2))}));
    }

    public abstract void g(Function0<Unit> r1);

    public abstract void h(e r1);

    public abstract boolean i(Function1<? super e, Unit> r1, Function0<Unit> r2);

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void a() {
        if (this.a == false) goto L9;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedFootHelper", BaseLinkedFootHelper$hideFoot$1.INSTANCE);
        this.a = false;
        ViewGroup.LayoutParams r1 = this.g.getLayoutParams();
        if (r1 == null) goto L7;
        r1.height = 0;
    L7:
        this.g.requestLayout();
        this.g.invalidate();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void d() {
        if (this.a == true) goto L9;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedFootHelper", BaseLinkedFootHelper$showFoot$1.INSTANCE);
        this.a = true;
        ViewGroup.LayoutParams r1 = this.g.getLayoutParams();
        if (r1 == null) goto L7;
        r1.height = this.c;
    L7:
        this.g.requestLayout();
        this.g.invalidate();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void e() {
        Lazy r0 = OrderCommonLog.a;
        final String r1 = "BaseLinkedFootHelper-startYataFootRefresh";
        OrderCommonLog.a("BaseLinkedFootHelper-startYataFootRefresh", BaseLinkedFootHelper$startYataFootRefresh$1.INSTANCE);
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("展示Foot", new BaseLinkedFootHelper$startYataFootRefresh$2(this, r1)), com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("Yata接口请求", new BaseLinkedFootHelper$startYataFootRefresh$3(this, "BaseLinkedFootHelper-startYataFootRefresh"))}));
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void f() {
        if (this.b != 2) goto L6;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenFail", BaseLinkedFootHelper$cancelYataFootRefreshWhenFail$1.INSTANCE);
        return;
    L6:
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenFail", BaseLinkedFootHelper$cancelYataFootRefreshWhenFail$2.INSTANCE);
        this.g.b("刷新失败，请重试");
        this.g.setOnClickListener(new b(this));
        this.b = 2;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void c(e r4) {
        Intrinsics.checkNotNullParameter(r4, "downLinkDataResponse");
        if (this.b == 1) goto L6;
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenSuccess", BaseLinkedFootHelper$cancelYataFootRefreshWhenSuccess$1.INSTANCE);
        return;
    L6:
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenSuccess", BaseLinkedFootHelper$cancelYataFootRefreshWhenSuccess$2.INSTANCE);
        g(new BaseLinkedFootHelper$cancelYataFootRefreshWhenSuccess$3(this));
        h(r4);
    }

    public BaseLinkedFootHelper(Context r2, BaseLinkedScrollView r3, jg3.b r4, OrderCommonYataView r5, OrderCommonRefreshSloganView r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "gulContainer");
        Intrinsics.checkNotNullParameter(r5, "yataContainer");
        Intrinsics.checkNotNullParameter(r6, "footContainer");
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.c = com.bytedance.android.shopping.extensions.b.b(60);
    }
}
