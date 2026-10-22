package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.extensions.k;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends CardListKitStarter {
    @Override // com.bytedance.android.shopping.card_list.router.CardListKitStarter
    public final CardPassThroughData b(HashMap<String, String> r14) {
        Intrinsics.checkNotNullParameter(r14, "schemaMap");
        CardPassThroughData r0 = super.b(r14);
        String r3 = r14.get("new_source_type");
        String r4 = r14.get("history_path");
        String r5 = r14.get("enter_from_live_saas");
        String r6 = r14.get("cart_ids");
        String r7 = r14.get("shop_ids");
        String r8 = r14.get("show_shop_ids");
        String r9 = r14.get("anchor_cart_id");
        int r11 = k.r(r14.get("cart_height_percent"), 0);
        String r2 = r14.get("transparent_params");
        if (r2 != null) goto L5;
        String r12 = "";
    L6:
        String r15 = r14.get("delivery_session_id");
        if (r15 != null) goto L9;
        r15 = "";
    L9:
        r0.setCartSchemaData(new CartPassThroughData(r3, r4, r5, r6, r7, r8, r9, r12, r11, r15));
        return r0;
    L5:
        r12 = r2;
        goto L6
    }

    public e(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "pageConfig");
        super(r2, r3);
    }
}
