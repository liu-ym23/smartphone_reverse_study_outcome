package com.bytedance.android.shopping.orderlist.common.model;

import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/model/OrderBottomBarActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CLICK", "VIEW", "CLOSE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderBottomBarActionType extends Enum<OrderBottomBarActionType> {
    public static final OrderBottomBarActionType CLICK = null;
    public static final OrderBottomBarActionType CLOSE = null;
    public static final OrderBottomBarActionType VIEW = null;
    public static final /* synthetic */ OrderBottomBarActionType[] a = null;
    private final String type;

    static {
        OrderBottomBarActionType r1 = new OrderBottomBarActionType("CLICK", 0, "click");
        CLICK = r1;
        OrderBottomBarActionType r2 = new OrderBottomBarActionType("VIEW", 1, FreqActions.ACTION_VIEW);
        VIEW = r2;
        OrderBottomBarActionType r3 = new OrderBottomBarActionType("CLOSE", 2, FreqActions.ACTION_CLOSE);
        CLOSE = r3;
        a = new OrderBottomBarActionType[]{r1, r2, r3};
    }

    public static OrderBottomBarActionType valueOf(String r1) {
        return (OrderBottomBarActionType) a.a(OrderBottomBarActionType.class, r1);
    }

    public static OrderBottomBarActionType[] values() {
        return (OrderBottomBarActionType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public OrderBottomBarActionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
