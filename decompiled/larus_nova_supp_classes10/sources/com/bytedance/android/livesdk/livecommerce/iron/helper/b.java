package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(IOrderSchema r16, String r17, String r18, String r19, List r20, String r21) {
        Intrinsics.checkNotNullParameter(r16, "orderSchema");
        Intrinsics.checkNotNullParameter(r17, "productId");
        Intrinsics.checkNotNullParameter(r18, "promotionId");
        Intrinsics.checkNotNullParameter(r19, "promotionSource");
        Intrinsics.checkNotNullParameter(r21, "detailUrl");
        JSONObject r4 = new JSONObject();
        r4.put("promotion_source", r19);
        r4.put("product_id", r17);
        r4.put("promotion_id", r18);
        String r2 = r4.toString();
        int r1 = ECSdk.a;
        IEShoppingService r3 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r3 == null) goto L14;
        sc3.i r14 = r3.getSkuYataService();
        if (r14 == null) goto L15;
        String r5 = r16.getQueryParam("mask_alpha");
        if (r5 == null) goto L11;
        Float r6 = StringsKt.toFloatOrNull(r5);
        if (r6 == null) goto L11;
        float r7 = r6.floatValue();
    L12:
        r14.e(r16, new nl.f(r2, r18, 201, null, null, r20, r21, null, null, null, Float.valueOf(r7), 920), null);
        return;
    L11:
        r7 = 0.0f;
        goto L12
    L15:
        return;
    }
}
