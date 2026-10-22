package com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CartObjectContainer a;
    public final CartViewModel b;

    public b(CartObjectContainer r3) {
        CartViewModel r0 = r3.d;
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r0, "cartVM");
        this.a = r3;
        this.b = r0;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r0.element = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        Lazy r2 = CartSettingUtils.a;
        Function0<Unit> r3 = new FindMore$onExecuteSync$1(this, r5, r0);
        Intrinsics.checkNotNullParameter(r3, "action");
        r3.invoke();
        return (com.bytedance.kmp.ec.yata.chain.event.b) r0.element;
    }
}
