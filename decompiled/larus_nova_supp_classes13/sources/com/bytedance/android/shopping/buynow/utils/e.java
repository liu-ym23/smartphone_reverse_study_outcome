package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowAppInfos;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowSubBTypes;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final int a = 0;

    static {
        a = com.bytedance.android.shopping.extensions.k.r(ECAppInfoService.e.getAppId(), 1128);
    }

    public static int a() {
        BuyNowAppInfos.a r0 = BuyNowAppInfos.Companion;
        int r1 = a;
        r0.getClass();
        BuyNowAppInfos[] r2 = BuyNowAppInfos.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L11;
        BuyNowAppInfos r5 = r2[r4];
        if (r5.getAid() != r1) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L12;
        r4 = r4 + 1;
    L12:
        if (r5 != null) goto L18;
        return 2;
    L18:
        return r5.getBType();
    L7:
        r6 = false;
        goto L8
    L11:
        r5 = null;
        goto L12
    }

    public static int b(boolean r1) {
        BuyNowSubBTypes.Companion.getClass();
        if (r1 == false) goto L6;
        return com.bytedance.android.shopping.extensions.k.r(ECAppInfoService.e.getAppId(), 1128);
    L6:
        return BuyNowSubBTypes.H5.getType();
    }
}
