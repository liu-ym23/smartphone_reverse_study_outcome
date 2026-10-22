package com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend;

import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CartViewModel a;

    public e(CartViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "cartVM");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Lazy r0 = CartSettingUtils.a;
        Function0<Unit> r1 = new RecommendShowTrackerFunction$onExecuteSync$1(this, r3);
        Intrinsics.checkNotNullParameter(r1, "action");
        r1.invoke();
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
