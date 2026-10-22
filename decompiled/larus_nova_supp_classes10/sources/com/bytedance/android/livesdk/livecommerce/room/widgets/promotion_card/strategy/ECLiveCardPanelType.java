package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/ECLiveCardPanelType;", "", "GOODS_DETAIL", "SKU", "ORDER", "OTHERS", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLiveCardPanelType extends Enum<ECLiveCardPanelType> {
    public static final ECLiveCardPanelType GOODS_DETAIL = null;
    public static final ECLiveCardPanelType ORDER = null;
    public static final ECLiveCardPanelType OTHERS = null;
    public static final ECLiveCardPanelType SKU = null;
    public static final /* synthetic */ ECLiveCardPanelType[] a = null;

    static {
        ECLiveCardPanelType r1 = new ECLiveCardPanelType("GOODS_DETAIL", 0);
        GOODS_DETAIL = r1;
        ECLiveCardPanelType r2 = new ECLiveCardPanelType("SKU", 1);
        SKU = r2;
        ECLiveCardPanelType r3 = new ECLiveCardPanelType("ORDER", 2);
        ORDER = r3;
        ECLiveCardPanelType r4 = new ECLiveCardPanelType("OTHERS", 3);
        OTHERS = r4;
        a = new ECLiveCardPanelType[]{r1, r2, r3, r4};
    }

    public static ECLiveCardPanelType valueOf(String r1) {
        return (ECLiveCardPanelType) r27.a.a(ECLiveCardPanelType.class, r1);
    }

    public static ECLiveCardPanelType[] values() {
        return (ECLiveCardPanelType[]) a.clone();
    }

    public ECLiveCardPanelType(String r1, int r2) {
        super(r1, r2);
    }
}
