package com.bytedance.gamecenter.base.order;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/gamecenter/base/order/OrderConstant$RESERVE_TYPE", "", "Lcom/bytedance/gamecenter/base/order/OrderConstant$RESERVE_TYPE;", "", "type", "I", "getType", "()I", "ORDER_DOWNLOAD", "ORDER_UPDATE", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum OrderConstant$RESERVE_TYPE extends Enum<OrderConstant$RESERVE_TYPE> {
    public static final OrderConstant$RESERVE_TYPE ORDER_DOWNLOAD = null;
    public static final OrderConstant$RESERVE_TYPE ORDER_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderConstant$RESERVE_TYPE[] f245012a = null;
    private final int type;

    static {
        OrderConstant$RESERVE_TYPE r100 = new OrderConstant$RESERVE_TYPE("ORDER_DOWNLOAD", 0, 1);
        ORDER_DOWNLOAD = r100;
        OrderConstant$RESERVE_TYPE r101 = new OrderConstant$RESERVE_TYPE("ORDER_UPDATE", 1, 2);
        ORDER_UPDATE = r101;
        f245012a = new OrderConstant$RESERVE_TYPE[]{r100, r101};
    }

    public static OrderConstant$RESERVE_TYPE valueOf(String r100) {
        return (OrderConstant$RESERVE_TYPE) r27.a.a(OrderConstant$RESERVE_TYPE.class, r100);
    }

    public static OrderConstant$RESERVE_TYPE[] values() {
        return (OrderConstant$RESERVE_TYPE[]) f245012a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public OrderConstant$RESERVE_TYPE(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
