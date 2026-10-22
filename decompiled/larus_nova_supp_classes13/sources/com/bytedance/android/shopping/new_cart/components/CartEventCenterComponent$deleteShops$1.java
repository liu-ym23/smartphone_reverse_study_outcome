package com.bytedance.android.shopping.new_cart.components;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartEventCenterComponent$deleteShops$1 implements ti.j {
    public final /* synthetic */ CartEventCenterComponent a;

    public CartEventCenterComponent$deleteShops$1(CartEventCenterComponent r1) {
        this.a = r1;
    }

    public final void a(final JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        CartEventCenterComponent.n(this.a, r3, new CartEventCenterComponent$deleteShops$1$onReceiveJsEvent$1(this, r3));
    }
}
