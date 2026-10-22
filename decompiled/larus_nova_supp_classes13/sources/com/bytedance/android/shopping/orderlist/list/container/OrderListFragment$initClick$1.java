package com.bytedance.android.shopping.orderlist.list.container;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonHeadBarView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonMaskView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class OrderListFragment$initClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OrderListFragment this$0;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            cl.d r2 = k.a();
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public static final class b implements View.OnLongClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            r2.setVisibility(8);
            return true;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OrderListFragment$initClick$1 a;

        public c(OrderListFragment$initClick$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ig3.a r3 = this.a.this$0.K;
            if (r3 == null) goto L8;
            OrderCommonBusinessMonitor r4 = r3.c;
            if (r4 == null) goto L9;
            r4.b("clickBody");
            return;
        L9:
            return;
        }
    }

    public OrderListFragment$initClick$1(OrderListFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2102invoke() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListFragment", AnonymousClass1.INSTANCE);
        wg.a.h(this.this$0.S90(2131368571), ECAppInfoService.e.i());
        ((TextView) this.this$0.S90(2131368571)).setOnClickListener(a.a);
        ((TextView) this.this$0.S90(2131368571)).setOnLongClickListener(b.a);
        View r1 = this.this$0.w;
        if (r1 == null) goto L5;
        r1.setOnClickListener(new AnonymousClass4(this));
    L5:
        ((OrderCommonHeadBarView) this.this$0.S90(2131381635)).setStyle(OrderCommonHeadBarView.HeadBarStyle.ORDER_LIST);
        ((OrderCommonHeadBarView) this.this$0.S90(2131381635)).setClickIconBackListener(new AnonymousClass5(this));
        ((OrderCommonMaskView) this.this$0.S90(2131381637)).setOnClickListener(new c(this));
        OrderListFragment.T90(this.this$0).setErrorRetryListener(new AnonymousClass7(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2102invoke();
        return Unit.INSTANCE;
    }
}
