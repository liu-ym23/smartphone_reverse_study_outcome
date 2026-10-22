package com.bytedance.android.shopping.buynow.viewmodel;

import com.bytedance.android.shopping.buynow.data.model.PageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final String a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getCreatePath");
        String r3 = r2.g;
        int r0 = r3.hashCode();
        if (r0 == (-1132693887)) goto L11;
        if (r0 == 21618209) goto L8;
    L13:
        return "/order/yata/createOrder";
    L8:
        if (r3.equals(PageType.ULTIMATEBUYNOW) == false) goto L13;
        return "/order/component/createOrder/";
    L11:
        if (r3.equals(PageType.CONTINUEPAY) == false) goto L13;
        return "/order/yata/createPay";
    }

    public static final String b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getEditPath");
        String r3 = r2.g;
        int r0 = r3.hashCode();
        if (r0 == (-1132693887)) goto L11;
        if (r0 == 21618209) goto L8;
    L13:
        return "/order/yata/confirmOrderEdit";
    L8:
        if (r3.equals(PageType.ULTIMATEBUYNOW) == false) goto L13;
        return "/order/component/confirmOrderEdit/";
    L11:
        if (r3.equals(PageType.CONTINUEPAY) == false) goto L13;
        return "/order/yata/getPayMethodEdit";
    }

    public static final String c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getQueryPath");
        String r3 = r2.g;
        int r0 = r3.hashCode();
        if (r0 == (-1132693887)) goto L11;
        if (r0 == 21618209) goto L8;
    L13:
        return "/order/yata/confirmOrderRender";
    L8:
        if (r3.equals(PageType.ULTIMATEBUYNOW) == false) goto L13;
        return "/order/component/confirmOrder/";
    L11:
        if (r3.equals(PageType.CONTINUEPAY) == false) goto L13;
        return "/order/yata/getPayMethod";
    }
}
