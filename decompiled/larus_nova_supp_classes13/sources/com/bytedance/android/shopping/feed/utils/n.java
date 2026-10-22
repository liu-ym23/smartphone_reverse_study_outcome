package com.bytedance.android.shopping.feed.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.android.shopping.feed.viewmodel.d a(PromotionProductStruct r10, Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        com.bytedance.android.shopping.feed.viewmodel.d r0 = new com.bytedance.android.shopping.feed.viewmodel.d();
        String r3 = null;
        if (r10 == null) goto L17;
        PromotionProductCommentsStruct r4 = r10.getCommentInfo();
        if (r4 == null) goto L17;
        String r5 = r4.getGoodRatio();
        if (r5 == null) goto L17;
        if (CastDoubleProtector.parseDouble(r5) <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
        String r7 = r5.concat("%");
    L18:
        if (r10 == null) goto L22;
        PromotionProductPrivilegesStruct r8 = r10.getPrivilegeInfo();
        if (r8 == null) goto L22;
        List r9 = r8.getServices();
    L23:
        if (r10 == null) goto L27;
        PromotionProductCommentsStruct r12 = r10.getCommentInfo();
        if (r12 == null) goto L27;
        List r13 = r12.getSellingPoints();
    L28:
        if (r7 != null) goto L30;
    L35:
        if (r9 != null) goto L37;
    L42:
        if (r13 != null) goto L44;
        return r0;
    L44:
        if ((!r13.isEmpty()) != true) goto L50;
        com.bytedance.android.shopping.feed.viewmodel.d r1 = new com.bytedance.android.shopping.feed.viewmodel.d();
        r1.a = (String) CollectionsKt.firstOrNull(r13);
        r1.b = 2;
        return r1;
    L50:
        return r0;
    L37:
        if ((!r9.isEmpty()) != true) goto L42;
        com.bytedance.android.shopping.feed.viewmodel.d r2 = new com.bytedance.android.shopping.feed.viewmodel.d();
        PromotionProductServiceStruct r14 = (PromotionProductServiceStruct) CollectionsKt.firstOrNull(r9);
        if (r14 == null) goto L41;
        r3 = r14.getTitle();
    L41:
        r2.a = r3;
        r2.b = 1;
        return r2;
    L30:
        if (r7.length() <= 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 != true) goto L35;
        com.bytedance.android.shopping.feed.viewmodel.d r16 = new com.bytedance.android.shopping.feed.viewmodel.d();
        int r17 = g1.a;
        r16.a = g1.a.c(r11, 2131895847, new Object[]{r7});
        r16.b = 0;
        return r16;
    L32:
        r15 = false;
    L27:
        r13 = null;
    L22:
        r9 = null;
        goto L23
    L11:
        r6 = false;
    L17:
        r7 = null;
        goto L18
    }
}
