package com.bytedance.android.shopping.orderlist.common.eventcenter.model;

import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/eventcenter/model/OrderCommonJsFuncType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TYPE_REFRESH", "TYPE_YATA_EVENT", "TYPE_SEARCH_FEEDS_REQUEST_FINISH", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderCommonJsFuncType extends Enum<OrderCommonJsFuncType> {
    public static final OrderCommonJsFuncType TYPE_REFRESH = null;
    public static final OrderCommonJsFuncType TYPE_SEARCH_FEEDS_REQUEST_FINISH = null;
    public static final OrderCommonJsFuncType TYPE_YATA_EVENT = null;
    public static final /* synthetic */ OrderCommonJsFuncType[] a = null;
    private final String type;

    static {
        OrderCommonJsFuncType r1 = new OrderCommonJsFuncType("TYPE_REFRESH", 0, ErrorPageButtonAction.REFRESH);
        TYPE_REFRESH = r1;
        OrderCommonJsFuncType r2 = new OrderCommonJsFuncType("TYPE_YATA_EVENT", 1, "yata_event");
        TYPE_YATA_EVENT = r2;
        OrderCommonJsFuncType r3 = new OrderCommonJsFuncType("TYPE_SEARCH_FEEDS_REQUEST_FINISH", 2, "search_feeds_request_finish");
        TYPE_SEARCH_FEEDS_REQUEST_FINISH = r3;
        a = new OrderCommonJsFuncType[]{r1, r2, r3};
    }

    public static OrderCommonJsFuncType valueOf(String r1) {
        return (OrderCommonJsFuncType) a.a(OrderCommonJsFuncType.class, r1);
    }

    public static OrderCommonJsFuncType[] values() {
        return (OrderCommonJsFuncType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public OrderCommonJsFuncType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
