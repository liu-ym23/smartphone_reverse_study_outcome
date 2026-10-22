package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class OrderListStickyController$initOrReset$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OrderListStickyController this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.orderlist.list.container.OrderListStickyController$initOrReset$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c {
        public final /* synthetic */ OrderListStickyController$initOrReset$1 a;

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void onScrollStateChanged(int r1) {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void a() {
            this.a.this$0.g.setVisibility(8);
        }

        public AnonymousClass2(OrderListStickyController$initOrReset$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void c(float r3) {
            OrderListLinkedScrollView r4 = this.a.this$0.h;
            Function0<Unit> r0 = new OrderListStickyController$initOrReset$1$2$onScrollGULPageDown$1(this);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, "disposableCallback");
            r4.getGulContainer().f(r0);
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void b(int r1, com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.b r2) {
            Intrinsics.checkNotNullParameter(r2, "verticalOffsetInfo");
            OrderListStickyController.a(this.a.this$0, r2);
        }
    }

    public OrderListStickyController$initOrReset$1(OrderListStickyController r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2192invoke() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStickyController", AnonymousClass1.INSTANCE);
        this.this$0.g.setVisibility(8);
        OrderListStickyController r1 = this.this$0;
        r1.b = false;
        r1.c = false;
        r1.h.a("OrderListStickyController", new AnonymousClass2(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2192invoke();
        return Unit.INSTANCE;
    }
}
