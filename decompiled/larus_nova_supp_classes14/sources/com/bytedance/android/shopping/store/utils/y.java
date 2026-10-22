package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y {
    public static final Map<String, String> a(StoreV2ProductItemVO r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Pair[] r0 = new Pair[6];
        im.v r1 = r5.u;
        if (r1 == null) goto L5;
        String r2 = r1.i();
    L6:
        r0[0] = TuplesKt.to("room_id", String.valueOf(r2));
        List r3 = r5.c("ecom_shop_product_below");
        String r4 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r3 == null) goto L9;
        Object r6 = CommentScene.COMMENTSCENE_NO_AWEME;
    L10:
        r0[1] = TuplesKt.to("is_product_info", r6);
        if (com.bytedance.android.shopping.extensions.k.c(r5.h) == false) goto L13;
        Object r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L14:
        r0[2] = TuplesKt.to("is_price_info", r7);
        if (r5.c("ecom_shop_product_recommend") != null) goto L18;
        r4 = "0";
    L18:
        r0[3] = TuplesKt.to("is_recommend_info", r4);
        com.bytedance.android.ec.store.repository.dto.l.b r8 = r5.s;
        if (r8 == null) goto L21;
        String r9 = r8.d();
    L22:
        r0[4] = TuplesKt.to("content_form", r9);
        r0[5] = TuplesKt.to("content_source", "shop");
        return MapsKt.mapOf(r0);
    L21:
        r9 = "";
        goto L22
    L13:
        r7 = "0";
        goto L14
    L9:
        r6 = "0";
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
