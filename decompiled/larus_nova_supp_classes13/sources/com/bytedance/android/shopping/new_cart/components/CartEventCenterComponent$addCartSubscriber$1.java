package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartEventCenterComponent$addCartSubscriber$1 implements ti.j {
    public final /* synthetic */ CartEventCenterComponent a;

    public CartEventCenterComponent$addCartSubscriber$1(CartEventCenterComponent r1) {
        this.a = r1;
    }

    public final void a(final JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Lazy r0 = CartSettingUtils.a;
        Function0<Unit> r1 = new CartEventCenterComponent$addCartSubscriber$1$onReceiveJsEvent$1(this, r2);
        Intrinsics.checkNotNullParameter(r1, "action");
        r1.invoke();
    }
}
