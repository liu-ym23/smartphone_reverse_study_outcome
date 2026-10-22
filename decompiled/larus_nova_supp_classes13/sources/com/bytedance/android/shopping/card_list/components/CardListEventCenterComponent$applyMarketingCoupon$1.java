package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.ec.core.utils.a2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListEventCenterComponent$applyMarketingCoupon$1 implements ti.j {
    public final /* synthetic */ CardListEventCenterComponent a;

    public CardListEventCenterComponent$applyMarketingCoupon$1(CardListEventCenterComponent r1) {
        this.a = r1;
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        final String r5 = r4.optString("anchorCartId", "");
        String r0 = a2.d(r5);
        if (r0 == null) goto L5;
        this.a.r.e.e.add(r0);
    L5:
        CardListQueryFetchComponent r1 = (CardListQueryFetchComponent) this.a.h.getValue();
        if (r1 == null) goto L9;
        r1.i(false, "reload", new CardListEventCenterComponent$applyMarketingCoupon$1$onReceiveJsEvent$2(this, r5));
        return;
    }
}
