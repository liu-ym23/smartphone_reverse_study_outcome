package com.bytedance.android.window.shop.repository.tab.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/CardPosition;", "", "NORMAL", "GLOBAL", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardPosition extends Enum<CardPosition> {
    public static final CardPosition GLOBAL = null;
    public static final CardPosition NORMAL = null;
    public static final /* synthetic */ CardPosition[] a = null;

    static {
        CardPosition r1 = new CardPosition("NORMAL", 0);
        NORMAL = r1;
        CardPosition r2 = new CardPosition("GLOBAL", 1);
        GLOBAL = r2;
        a = new CardPosition[]{r1, r2};
    }

    public static CardPosition valueOf(String r1) {
        return (CardPosition) r27.a.a(CardPosition.class, r1);
    }

    public static CardPosition[] values() {
        return (CardPosition[]) a.clone();
    }

    public CardPosition(String r1, int r2) {
        super(r1, r2);
    }
}
