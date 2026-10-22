package com.bytedance.android.shopping.extensions;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.utils.u;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final String a(ECLogExtraData r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getEComEntranceFrom");
        return b(r1);
    }

    public static final String b(ECLogExtraData r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getRealCarrierType");
        String r0 = a2.d(r1.getEComEntranceForm());
        if (r0 != null) goto L6;
        int r2 = u.a;
        return u.a(r1.getEnterMethod());
    L6:
        return r0;
    }

    public static final boolean c(ECLogExtraData r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isFromDetailProductGuessULike");
        if (Intrinsics.areEqual(r2.getModuleLabel(), "guess_you_like_product") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getEnterFrom(), "product_detail") == false) goto L7;
        return true;
    }

    public static final boolean d(ECLogExtraData r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isFromFeedProductGuessULike");
        if (Intrinsics.areEqual(r2.getModuleLabel(), "guess_you_like_product") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getEnterFrom(), "product_flow_page") == false) goto L7;
        return true;
    }
}
