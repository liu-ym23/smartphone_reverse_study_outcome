package com.bytedance.android.shopping.sku.outer.business.buynow;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuOuterBuyNowOpenHelper {
    public String a;
    public final Context b;
    public final c c;
    public final PageFinder d;
    public final mh3.a e;

    public final void a() {
        String r0 = this.c.b.getEntranceInfo();
        final com.bytedance.android.shopping.buynow.monitor.firstscreen.a r1 = null;
        if (r0 == null) goto L5;
        final JSONObject r2 = z1.g(r0);
    L6:
        int r3 = ECSdk.a;
        IEShoppingService r4 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r4 == null) goto L9;
        sc3.c r5 = r4.getBuyNowService();
    L10:
        if (r5 == null) goto L12;
        r1 = r5.n(new com.bytedance.android.ec.model.d(this.b, "SkuOuterBuyNowOpenHelper", System.currentTimeMillis()));
    L12:
        if (r1 == null) goto L14;
        r1.c(ChainPoint.PAGE_INIT, Long.valueOf(System.currentTimeMillis()));
    L14:
        if (r1 == null) goto L16;
        r1.c(ChainPoint.PAGE_START, Long.valueOf(System.currentTimeMillis()));
    L16:
        com.bytedance.android.shopping.sku.common.utils.d.b(CollectionsKt.listOf(new com.bytedance.android.shopping.sku.common.utils.a[]{com.bytedance.android.shopping.sku.common.utils.d.a("监控", new SkuOuterBuyNowOpenHelper$start$1(this, r2)), com.bytedance.android.shopping.sku.common.utils.d.a("提单以后的周期内把小窗关掉", SkuOuterBuyNowOpenHelper$start$2.INSTANCE), com.bytedance.android.shopping.sku.common.utils.d.a("提单", new SkuOuterBuyNowOpenHelper$start$3(this, r1)), com.bytedance.android.shopping.sku.common.utils.d.a("ecom.sku.buynow", new SkuOuterBuyNowOpenHelper$start$4(this)), com.bytedance.android.shopping.sku.common.utils.d.a("通知营销层用户下单行为", SkuOuterBuyNowOpenHelper$start$5.INSTANCE), com.bytedance.android.shopping.sku.common.utils.d.a("logAdEvent host service", new SkuOuterBuyNowOpenHelper$start$6(this, r2))}));
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public SkuOuterBuyNowOpenHelper(Context r2, c r3, PageFinder r4, mh3.a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "buyNowData");
        Intrinsics.checkNotNullParameter(r4, "btmPageFinder");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = "";
    }
}
