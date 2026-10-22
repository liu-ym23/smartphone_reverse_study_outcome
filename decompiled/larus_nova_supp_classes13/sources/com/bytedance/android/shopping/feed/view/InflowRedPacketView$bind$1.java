package com.bytedance.android.shopping.feed.view;

import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/a;", "it", "", "invoke", "(Lcom/bytedance/android/ec/core/widget/price/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class InflowRedPacketView$bind$1 extends Lambda implements Function1<com.bytedance.android.ec.core.widget.price.a, Unit> {
    final /* synthetic */ String $availableAmount;

    public InflowRedPacketView$bind$1(String r1) {
        this.$availableAmount = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.ec.core.widget.price.a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.d = Long.valueOf((long) (CastFloatProtector.parseFloat(this.$availableAmount) * 100));
        r3.i = true;
        r3.v = "元";
        r3.g = 1.0f;
        r3.h = true;
        int r1 = this.$availableAmount.length();
        if (r1 != 1) goto L5;
        int r0 = UnitExtensionKt.dp2px(18);
    L15:
        float r2 = r0;
    L16:
        r3.c = r2;
        return;
    L5:
        if (r1 != 2) goto L7;
        r0 = UnitExtensionKt.dp2px(16);
        goto L15
    L7:
        if (r1 != 3) goto L9;
        r0 = UnitExtensionKt.dp2px(14);
        goto L15
    L9:
        if (r1 == 4) goto L11;
        r2 = 12.0f;
        goto L16
    L11:
        r0 = UnitExtensionKt.dp2px(12);
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.ec.core.widget.price.a) r1);
        return Unit.INSTANCE;
    }
}
