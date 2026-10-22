package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.ec.core.utils.a2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartEventCenterComponent$applyMarketingCoupon$1 implements ti.j {
    public final /* synthetic */ CartEventCenterComponent a;

    public CartEventCenterComponent$applyMarketingCoupon$1(CartEventCenterComponent r1) {
        this.a = r1;
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        final String r5 = r4.optString("anchorCartId", "");
        String r0 = a2.d(r5);
        if (r0 == null) goto L5;
        this.a.o.e.f.add(r0);
    L5:
        this.a.b.doQuery(false, "reload", new CartEventCenterComponent$applyMarketingCoupon$1$onReceiveJsEvent$2(this, r5));
    }
}
