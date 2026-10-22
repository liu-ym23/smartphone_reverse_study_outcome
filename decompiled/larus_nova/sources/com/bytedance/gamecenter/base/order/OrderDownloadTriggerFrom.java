package com.bytedance.gamecenter.base.order;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/gamecenter/base/order/OrderDownloadTriggerFrom;", "", "", "value", "I", "getValue", "()I", "USER_ACTIVE", "WEB_SOCKET", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum OrderDownloadTriggerFrom extends Enum<OrderDownloadTriggerFrom> {
    public static final OrderDownloadTriggerFrom USER_ACTIVE = null;
    public static final OrderDownloadTriggerFrom WEB_SOCKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderDownloadTriggerFrom[] f245017a = null;
    private final int value;

    static {
        OrderDownloadTriggerFrom r100 = new OrderDownloadTriggerFrom("USER_ACTIVE", 0, 0);
        USER_ACTIVE = r100;
        OrderDownloadTriggerFrom r101 = new OrderDownloadTriggerFrom("WEB_SOCKET", 1, 1);
        WEB_SOCKET = r101;
        f245017a = new OrderDownloadTriggerFrom[]{r100, r101};
    }

    public static OrderDownloadTriggerFrom valueOf(String r100) {
        return (OrderDownloadTriggerFrom) r27.a.a(OrderDownloadTriggerFrom.class, r100);
    }

    public static OrderDownloadTriggerFrom[] values() {
        return (OrderDownloadTriggerFrom[]) f245017a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderDownloadTriggerFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
