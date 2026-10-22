package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0 {
    static {
    }

    public static String a(PromotionProductStruct r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getDiscountActivityId");
        PromotionProductExtraStruct r2 = r1.getExtraInfo();
        if (r2 == null) goto L9;
        String r3 = r2.getLogExtra();
        if (r3 == null) goto L9;
        JSONObject r4 = z1.g(r3);
        if (r4 == null) goto L9;
        return r4.optString("discount_activity_id");
    L9:
        return null;
    }

    public static String b(PromotionProductStruct r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getDiscountActivityType");
        PromotionProductExtraStruct r2 = r1.getExtraInfo();
        if (r2 == null) goto L9;
        String r3 = r2.getLogExtra();
        if (r3 == null) goto L9;
        JSONObject r4 = z1.g(r3);
        if (r4 == null) goto L9;
        return r4.optString("discount_activity_type");
    L9:
        return null;
    }
}
