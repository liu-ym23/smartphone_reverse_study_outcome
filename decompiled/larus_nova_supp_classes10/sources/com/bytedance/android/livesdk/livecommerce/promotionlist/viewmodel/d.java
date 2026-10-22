package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Decision.values().length];
        a = r0;
        r0[Decision.DEGRADE_HOT_ATMOSPHERE.ordinal()] = 1;
        r0[Decision.HIDE_EXPLAINING_ANIM.ordinal()] = 2;
        r0[Decision.DEGRADE_SALE_POINT_LOOP.ordinal()] = 3;
        r0[Decision.PROMOTION_CARD_CLOSE_STYLE.ordinal()] = 4;
        r0[Decision.DISPLAY_TWO_LINE_TITLE.ordinal()] = 5;
        r0[Decision.ADJUST_INSTANT_FUSION.ordinal()] = 6;
        r0[Decision.SHORTEN_BTN_INSTANT_FUSION.ordinal()] = 7;
        r0[Decision.IS_IN_SPLIT_SCREEN.ordinal()] = 8;
        int[] r1 = new int[ILivePromotionCardContainerHandler.ContainerPriority.values().length];
        b = r1;
        r1[ILivePromotionCardContainerHandler.ContainerPriority.LigoInitDataMap.ordinal()] = 1;
        r1[ILivePromotionCardContainerHandler.ContainerPriority.AddressInfo.ordinal()] = 2;
    }
}
