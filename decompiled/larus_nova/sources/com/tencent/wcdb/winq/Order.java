package com.tencent.wcdb.winq;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum Order extends Enum<Order> {
    private static final /* synthetic */ Order[] $VALUES = null;
    public static final Order Asc = null;
    public static final Order Desc = null;

    private static /* synthetic */ Order[] $values() {
        return new Order[]{Asc, Desc};
    }

    static {
        Asc = new Order("Asc", 0);
        Desc = new Order("Desc", 1);
        $VALUES = $values();
    }

    public static Order[] values() {
        return (Order[]) $VALUES.clone();
    }

    public static Order valueOf(String r100) {
        return (Order) a.a(Order.class, r100);
    }

    private Order(String r100, int r101) {
        super(r100, r101);
    }
}
