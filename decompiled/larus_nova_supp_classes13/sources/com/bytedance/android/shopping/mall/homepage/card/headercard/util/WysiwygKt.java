package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.CampaignInfo;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class WysiwygKt {
    public static final String b(List<ECProductStruct> r12, Integer r13) {
        ECProductStruct.SecKillProductCampaignType r0 = ECProductStruct.SecKillProductCampaignType.SECKILL;
        int r1 = r0.getValue();
        if (r13 != null) goto L6;
    L11:
        List<ECProductStruct> r2 = r12;
    L12:
        String r3 = null;
        if (r2 == null) goto L15;
        String r4 = CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, WysiwygKt$getWysiwygString$wysiwygStr$1.INSTANCE, 30, null);
    L16:
        if (r12 == null) goto L18;
        ECProductStruct r14 = (ECProductStruct) CollectionsKt.firstOrNull(r12);
    L19:
        if (r14 == null) goto L23;
        ECProductStruct.Extra r5 = r14.getExtra();
        if (r5 == null) goto L23;
        r3 = r5.getNYuanMPiece();
    L23:
        if (r3 == null) goto L31;
        int r6 = r0.getValue();
        if (r13 != null) goto L28;
        return r4;
    L28:
        if (r13.intValue() == r6) goto L30;
        return r4;
    L30:
        return r14.getWysiwygParam();
    L31:
        return r4;
    L18:
        r14 = null;
        goto L19
    L15:
        r4 = null;
        goto L16
    L6:
        if (r13.intValue() != r1) goto L11;
        if (r12 == null) goto L11;
        if (r12.isEmpty() == true) goto L11;
        r2 = r12.subList(0, 1);
        goto L12
    }

    public static final String a(List<ECProductStruct> r6, Integer r7, Integer r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L3:
        boolean r2 = true;
        if (r9.hasNext() == false) goto L22;
        Object r1 = r9.next();
        ECProductStruct r3 = (ECProductStruct) r1;
        int r4 = ECProductStruct.SecKillProductCampaignType.SECKILL.getValue();
        if (r8 != null) goto L9;
    L10:
        if (r3 == null) goto L14;
        CampaignInfo r5 = r3.getCampaignInfo();
        if (r5 == null) goto L14;
        Integer r10 = r5.getCampaignType();
    L16:
        if (Intrinsics.areEqual(r10, r8) == true) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L3;
        r0.add(r1);
    L14:
        r10 = null;
        goto L16
    L9:
        if (r8.intValue() == r4) goto L19;
    L22:
        if (r0.isEmpty() != true) goto L25;
        return "";
    L25:
        if (r7 == null) goto L31;
        if (r7.intValue() < 0) goto L31;
        return b(CollectionsKt.listOf((ECProductStruct) CollectionsKt.getOrNull(r0, r7.intValue())), r8);
    L31:
        return b(r0, r8);
    }
}
