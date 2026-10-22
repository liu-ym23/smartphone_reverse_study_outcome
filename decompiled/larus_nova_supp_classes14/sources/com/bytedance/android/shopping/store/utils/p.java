package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(PageFinder r4, String r5, Map r6) {
        Intrinsics.checkNotNullParameter(r4, "pageFinder");
        Intrinsics.checkNotNullParameter(r5, "btm");
        BtmSDK r0 = BtmSDK.INSTANCE;
        BcmParams r1 = new BcmParams();
        r1.put("bst_group_type", "product");
        Unit r2 = Unit.INSTANCE;
        return r0.createJumpSourceBtmToken(r5, r4, r1.merge(r6));
    }
}
