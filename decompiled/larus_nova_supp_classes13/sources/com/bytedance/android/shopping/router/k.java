package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.sku.SkuPanelHelperForSchema;
import com.bytedance.android.shopping.api.IEShoppingService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements bf.c {
    public k() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_goods_sku";
    }

    public final boolean c(Context r4, Uri r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "uri");
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == false) goto L6;
        SkuPanelHelperForSchema.b(r4, r5, r6);
        return true;
    L6:
        int r1 = ECSdk.a;
        IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r2 == null) goto L11;
        sc3.i r3 = r2.getSkuYataService();
        if (r3 == null) goto L11;
        r3.a(r4, r5, r6, null);
    L11:
        return true;
    }
}
