package com.bytedance.android.shopping.feed.viewholder;

import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowSchema;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.ShortVideoSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ PromotionProductStruct a;

    public c(PromotionProductStruct r1) {
        this.a = r1;
    }

    public final void a() {
        PromotionProductStruct r0 = this.a;
        if (r0 == null) goto L10;
        InnerFlowSchema r1 = r0.getInnerflowSchema();
        if (r1 == null) goto L10;
        ShortVideoSchema r2 = r1.getOrderSchema();
        if (r2 == null) goto L10;
        String r3 = r2.getUrl();
        if (r3 == null) goto L10;
    L11:
        int r4 = ECSdk.a;
        IECCommonService r5 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r5 == null) goto L14;
        IOrderSchema r6 = r5.convertToOrderSchema(r3, new EntranceInfoScene("product_flow", "preload"));
    L15:
        if (r6 == null) goto L22;
        IEShoppingService r7 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r7 == null) goto L23;
        sc3.c r8 = r7.getBuyNowService();
        if (r8 == null) goto L24;
        r8.i(r6);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r6 = null;
    L10:
        r3 = "";
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
