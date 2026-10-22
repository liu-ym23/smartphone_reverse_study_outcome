package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(String r2, String r3) {
        PromotionListController.T.getClass();
        LivePromotionListFragment r0 = PromotionListController.a.c(r2, r3).c;
        if (r0 != null) goto L5;
    L19:
        boolean r1 = EntryController.M1;     // Catch: Exception -> L15
        if (EntryController.a.b(r2, r3).U != 1) goto L13;
        int r4 = EComABUtils.liveListPanelHeightInstant();     // Catch: Exception -> L15
    L18:
    L17:
        return RangesKt.coerceIn(r4, 0, 100);
    L13:
        r4 = EComABUtils.liveListPanelHeight();     // Catch: Exception -> L15
    L15:
        r4 = EComABUtils.liveListPanelHeight();
        goto L17
    L5:
        if (r0.p() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L19;
        r4 = r0.ba0();
        goto L17
    }
}
