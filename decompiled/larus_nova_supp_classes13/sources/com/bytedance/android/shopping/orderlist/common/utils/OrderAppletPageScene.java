package com.bytedance.android.shopping.orderlist.common.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/utils/OrderAppletPageScene;", "", "PAGE_INTERNAL", "GO_TO_LANDING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderAppletPageScene extends Enum<OrderAppletPageScene> {
    public static final OrderAppletPageScene GO_TO_LANDING = null;
    public static final OrderAppletPageScene PAGE_INTERNAL = null;
    public static final /* synthetic */ OrderAppletPageScene[] a = null;

    static {
        OrderAppletPageScene r1 = new OrderAppletPageScene("PAGE_INTERNAL", 0);
        PAGE_INTERNAL = r1;
        OrderAppletPageScene r2 = new OrderAppletPageScene("GO_TO_LANDING", 1);
        GO_TO_LANDING = r2;
        a = new OrderAppletPageScene[]{r1, r2};
    }

    public static OrderAppletPageScene valueOf(String r1) {
        return (OrderAppletPageScene) r27.a.a(OrderAppletPageScene.class, r1);
    }

    public static OrderAppletPageScene[] values() {
        return (OrderAppletPageScene[]) a.clone();
    }

    public OrderAppletPageScene(String r1, int r2) {
        super(r1, r2);
    }
}
