package com.bytedance.android.shopping.store.shopfeed;

import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowLynxCardView;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(ShopMomentFlowLynxCardView r3, boolean r4) {
        if (r3 == null) goto L10;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("is_current_show", r4);     // Catch: Exception -> L5
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L5
        r3.c("ecom.shop_feed.card_show", r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        dm.a.a("ShopFeedJsEvent").b("sendShowEvent", e);
        return;
    }
}
