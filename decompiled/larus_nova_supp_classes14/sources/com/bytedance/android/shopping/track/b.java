package com.bytedance.android.shopping.track;

import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final String a(PromotionProductStruct r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getCashRebate");
        PromotionProductPrivilegesStruct r3 = r2.getPrivilegeInfo();
        if (r3 == null) goto L21;
        PromotionProductCouponsStruct r4 = r3.getCoupons();
        if (r4 == null) goto L22;
        List r5 = r4.discounts();
        if (r5 != null) goto L9;
        return "0";
    L9:
        if ((!r5.isEmpty()) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L24;
        int r6 = ((PromotionDiscountLabel) ListProtector.get(r5, 0)).getType();
        if (r6 != 2) goto L16;
        return CommentScene.COMMENTSCENE_NO_AWEME;
    L16:
        if (r6 != 3) goto L26;
        return "2";
    L26:
        return "0";
    L24:
        return "0";
    L22:
        return "0";
    L21:
        return "0";
    }
}
