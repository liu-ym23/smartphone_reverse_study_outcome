package com.bytedance.gamecenter.base.order;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/gamecenter/base/order/OrderConstant$TAG", "", "Lcom/bytedance/gamecenter/base/order/OrderConstant$TAG;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "TAG_ORDER_UPDATE", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum OrderConstant$TAG extends Enum<OrderConstant$TAG> {
    public static final OrderConstant$TAG TAG_ORDER_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderConstant$TAG[] f245013a = null;
    private final String tag;

    static {
        OrderConstant$TAG r100 = new OrderConstant$TAG();
        TAG_ORDER_UPDATE = r100;
        f245013a = new OrderConstant$TAG[]{r100};
    }

    public static OrderConstant$TAG valueOf(String r100) {
        return (OrderConstant$TAG) r27.a.a(OrderConstant$TAG.class, r100);
    }

    public static OrderConstant$TAG[] values() {
        return (OrderConstant$TAG[]) f245013a.clone();
    }

    public OrderConstant$TAG() {
        super("TAG_ORDER_UPDATE", 0);
        this.tag = "order_update";
    }

    public final String getTag() {
        return this.tag;
    }
}
