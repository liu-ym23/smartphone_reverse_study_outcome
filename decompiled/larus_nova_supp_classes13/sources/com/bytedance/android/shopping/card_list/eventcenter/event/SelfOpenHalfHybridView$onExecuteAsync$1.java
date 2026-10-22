package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.components.CardListPopupLayerComponent;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lhl3/a;", "", "invoke", "(Lhl3/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SelfOpenHalfHybridView$onExecuteAsync$1 extends Lambda implements Function1<hl3.a, Unit> {
    final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e $input;
    final /* synthetic */ SelfOpenHalfHybridView this$0;

    public static final class a implements hl3.b {
        public final /* synthetic */ SelfOpenHalfHybridView$onExecuteAsync$1 a;

        public a(SelfOpenHalfHybridView$onExecuteAsync$1 r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.shopping.yata.biz.popup.a r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            Intrinsics.checkNotNullParameter(r2, "card");
        }

        public final void b(com.bytedance.android.shopping.yata.biz.popup.a r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            Intrinsics.checkNotNullParameter(r2, "card");
        }

        public final void c(hl3.a r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            Intrinsics.checkNotNullParameter(r2, "card");
        }

        public final void d(com.bytedance.android.shopping.yata.biz.popup.a r3) {
            Intrinsics.checkNotNullParameter(r3, "card");
            SelfOpenHalfHybridView r4 = this.a.this$0;
            int r0 = SelfOpenHalfHybridView.i;
            CardListPopupLayerComponent r5 = (CardListPopupLayerComponent) r4.b.getValue();
            if (r5 == null) goto L5;
            r5.h();
        L5:
            this.a.this$0.a.set(false);
            final AndroidYaTaInstance r6 = (AndroidYaTaInstance) this.a.this$0.h.e.c.invoke();
            CardListRunCatchExtKt.a(this.a.this$0.c, "OpenHybridPopupView-dismissHybridPopupView", new SelfOpenHalfHybridView$onExecuteAsync$1$1$onCardDetach$$inlined$let$lambda$1(r6, this));
        }

        public final void e(il3.a r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            Intrinsics.checkNotNullParameter(r2, "config");
        }

        public final void f(com.bytedance.android.shopping.yata.biz.popup.a r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            Intrinsics.checkNotNullParameter(r2, "card");
        }
    }

    public SelfOpenHalfHybridView$onExecuteAsync$1(SelfOpenHalfHybridView r1, com.bytedance.kmp.ec.yata.event.common.e r2) {
        this.this$0 = r1;
        this.$input = r2;
        super(1);
    }

    public final void invoke(hl3.a r5) {
        Intrinsics.checkNotNullParameter(r5, "$receiver");
        com.bytedance.android.shopping.yata.biz.popup.a r6 = (com.bytedance.android.shopping.yata.biz.popup.a) r5;
        if (r6.a() != null) goto L7;
        com.bytedance.android.shopping.card_list.monitor.error.a r0 = (com.bytedance.android.shopping.card_list.monitor.error.a) this.this$0.d.getValue();
        if (r0 == null) goto L7;
        CardListErrorMonitorType r1 = CardListErrorMonitorType.HYBRID_PANEL_OPEN_ERROR;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r2 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r0.b(r1, "OpenHybridPopupView->hybridComponent is null", null);
    L7:
        a r3 = new a(this);
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        r6.c.add(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((hl3.a) r1);
        return Unit.INSTANCE;
    }
}
