package com.bytedance.android.shopping.buynow.container;

import android.net.Uri;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(UltimateBuyParams r5, Uri r6, boolean r7, nl.c r8) {
        String r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.getQueryParam("is_single_sku");
    L6:
        boolean r2 = false;
        boolean r3 = com.bytedance.android.shopping.extensions.k.n(r1, false);
        if (r8 == null) goto L9;
        String r4 = r8.getQueryParam("ultimate_buy_ab");
    L11:
        if (com.bytedance.android.shopping.extensions.k.r(r4, 0) <= 0) goto L13;
        boolean r9 = true;
    L14:
        if (r8 == null) goto L17;
        r0 = r8.getQueryParam("ultimate_buy_version");
    L17:
        if (com.bytedance.android.shopping.extensions.k.r(r0, 0) > 0) goto L19;
    L21:
        if (r2 == false) goto L25;
        if (r3 == false) goto L25;
        if (r9 == false) goto L25;
        String r10 = "单sku\n极致提单\nschema升级";
    L43:
        if (r7 == true) goto L45;
        return r10;
    L45:
        return r10 + "\n命中过缓存";
    L25:
        if (r2 == false) goto L29;
        if (r3 == true) goto L29;
        if (r9 == false) goto L29;
        r10 = "多sku\n极致提单\nschema升级";
    L29:
        if (r5 != null) goto L32;
        r10 = "组件化NA\n提单";
        goto L43
    L32:
        if (r5.isSingleSku() != 1) goto L36;
        if (r6 == null) goto L36;
        r10 = "单sku\n极致提单\nschema重构\ntype:" + r5.getUltimateBuyType();
    L36:
        if (r5.isSingleSku() == 1) goto L40;
        if (r6 == null) goto L40;
        r10 = "多sku\n极致提单\nschema重构\ntype:" + r5.getUltimateBuyType();
    L40:
        if (r5.isSingleSku() != 1) goto L42;
        r10 = "单sku\n极致提单\n非schema重构\ntype:" + r5.getUltimateBuyType();
        goto L43
    L42:
        r10 = "多sku\n极致提单\n非schema重构\ntype:" + r5.getUltimateBuyType();
        goto L43
    L19:
        if ((r8 instanceof IOrderSchema) == false) goto L21;
        r2 = true;
        goto L21
    L13:
        r9 = false;
        goto L14
    L9:
        r4 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
