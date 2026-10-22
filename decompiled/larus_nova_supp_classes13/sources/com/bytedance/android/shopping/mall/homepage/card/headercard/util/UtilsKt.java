package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCardType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class UtilsKt {
    public static final Map<String, String> a(ChannelVO r8, boolean r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "channel");
        String r0 = r8.getComponentId();
        LinkedHashMap r1 = new LinkedHashMap();
        if (Intrinsics.areEqual(r0, ChannelCID.BRAND.getValue()) == false) goto L94;
        String r2 = "product";
        String r3 = "none";
        String r4 = null;
        if (r9 == false) goto L36;
        ChannelVO.Data r11 = r8.getData();
        if (r11 == null) goto L11;
        List<ECCommonCard> r12 = r11.getItems();
        if (r12 == null) goto L11;
        ECCommonCard r13 = (ECCommonCard) CollectionsKt.getOrNull(r12, r10);
    L12:
        if (r13 == null) goto L14;
        Integer r14 = r13.getType();
    L15:
        int r15 = ECCommonCardType.SHOP.getValue();
        if (r14 != null) goto L19;
    L21:
        int r16 = ECCommonCardType.PRODUCT.getValue();
        if (r14 != null) goto L25;
    L27:
        r2 = null;
    L28:
        if (r13 == null) goto L34;
        ECProductStruct r17 = r13.getProduct();
        if (r17 == null) goto L34;
        ECProductStruct.Extra r18 = r17.getExtra();
        if (r18 == null) goto L34;
        r4 = r18.getResourceId();
    L34:
        if (r4 == null) goto L93;
        r3 = r2;
    L93:
        r1.put("custom_daogou_type", r3);
        goto L94
    L25:
        if (r14.intValue() != r16) goto L27;
    L19:
        if (r14.intValue() != r15) goto L21;
        r2 = "shop";
        goto L28
    L14:
        r14 = null;
    L11:
        r13 = null;
        goto L12
    L36:
        ChannelVO.Data r19 = r8.getData();
        if (r19 == null) goto L73;
        List<ECCommonCard> r20 = r19.getItems();
        if (r20 == null) goto L73;
        ArrayList r21 = new ArrayList();
        Iterator<T> r22 = r20.iterator();
    L42:
        if (r22.hasNext() == false) goto L72;
        ECCommonCard r110 = (ECCommonCard) r22.next();
        if (r110 == null) goto L46;
        Integer r5 = r110.getType();
    L47:
        int r6 = ECCommonCardType.SHOP.getValue();
        if (r5 != null) goto L51;
    L53:
        int r7 = ECCommonCardType.PRODUCT.getValue();
        if (r5 != null) goto L57;
    L59:
        Object r23 = null;
    L60:
        if (r110 == null) goto L66;
        ECProductStruct r111 = r110.getProduct();
        if (r111 == null) goto L66;
        ECProductStruct.Extra r112 = r111.getExtra();
        if (r112 == null) goto L66;
        String r113 = r112.getResourceId();
    L67:
        if (r113 != null) goto L70;
        r23 = "none";
    L70:
        if (r23 == null) goto L42;
        r21.add(r23);
    L66:
        r113 = null;
        goto L67
    L57:
        if (r5.intValue() != r7) goto L59;
        r23 = "product";
        goto L60
    L51:
        if (r5.intValue() != r6) goto L53;
        r23 = "shop";
        goto L60
    L46:
        r5 = null;
        goto L47
    L72:
        List r24 = CollectionsKt.distinct(r21);
    L74:
        if (r24 == null) goto L76;
        Integer r25 = Integer.valueOf(r24.size());
    L77:
        if (r25 != null) goto L80;
    L82:
        if (r25 != null) goto L85;
    L87:
        if (r25 != null) goto L90;
    L92:
        r3 = null;
        goto L93
    L90:
        if (r25.intValue() != 0) goto L92;
    L85:
        if (r25.intValue() != 2) goto L87;
        r3 = "both";
        goto L93
    L80:
        if (r25.intValue() != 1) goto L82;
        r3 = (String) CollectionsKt.first(r24);
        goto L93
    L76:
        r25 = null;
    L73:
        r24 = null;
    L94:
        return r1;
    }

    public static final Map<String, String> b(ChannelVO r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "channel");
        if (Intrinsics.areEqual(r11.getComponentId(), ChannelCID.SECKILL.getValue()) == false) goto L12;
        ChannelVO.Data r0 = r11.getData();
        if (r0 == null) goto L12;
        List<ECCommonCard> r1 = r0.getItems();
        if (r1 == null) goto L12;
        List r2 = t93.a.e(r1, r12, r13);
        if (r2 == null) goto L12;
        String r3 = CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, UtilsKt$getSkillOrSubsideProductString$1.INSTANCE, 30, null);
        if (r3 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r11.getComponentId(), ChannelCID.SUBSIDE.getValue()) == false) goto L23;
        ChannelVO.Data r14 = r11.getData();
        if (r14 == null) goto L23;
        List<ECCommonCard> r15 = r14.getItems();
        if (r15 == null) goto L23;
        List r16 = t93.a.e(r15, r12, r13);
        if (r16 == null) goto L23;
        String r17 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, UtilsKt$getSkillOrSubsideProductString$2.INSTANCE, 30, null);
        if (r17 == null) goto L23;
    L25:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("seckill_filters", r3), TuplesKt.to("allowance_filters", r17), TuplesKt.to("filters", "")});
    L23:
        r17 = "";
    L12:
        r3 = "";
        goto L14
    }
}
