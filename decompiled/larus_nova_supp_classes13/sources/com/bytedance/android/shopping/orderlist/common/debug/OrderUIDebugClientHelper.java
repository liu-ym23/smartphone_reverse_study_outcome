package com.bytedance.android.shopping.orderlist.common.debug;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import kotlin.Lazy;
import kotlin.LazyKt;
import sc3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderUIDebugClientHelper {
    public static final h a = null;
    public static final Lazy b = null;

    static {
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L5;
        h r2 = r1.getOrderListService();
    L6:
        a = r2;
        b = LazyKt.lazy(OrderUIDebugClientHelper$mainHandler$2.INSTANCE);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
