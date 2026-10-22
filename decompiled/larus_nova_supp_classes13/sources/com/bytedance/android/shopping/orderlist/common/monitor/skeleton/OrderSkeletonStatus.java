package com.bytedance.android.shopping.orderlist.common.monitor.skeleton;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/monitor/skeleton/OrderSkeletonStatus;", "", "", "value", "I", "getValue", "()I", "Pending", "Rendering", "Completed", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderSkeletonStatus extends Enum<OrderSkeletonStatus> {
    public static final OrderSkeletonStatus Completed = null;
    public static final OrderSkeletonStatus Pending = null;
    public static final OrderSkeletonStatus Rendering = null;
    public static final /* synthetic */ OrderSkeletonStatus[] a = null;
    private final int value;

    static {
        OrderSkeletonStatus r1 = new OrderSkeletonStatus("Pending", 0, 0);
        Pending = r1;
        OrderSkeletonStatus r2 = new OrderSkeletonStatus("Rendering", 1, 1);
        Rendering = r2;
        OrderSkeletonStatus r3 = new OrderSkeletonStatus("Completed", 2, 2);
        Completed = r3;
        a = new OrderSkeletonStatus[]{r1, r2, r3};
    }

    public static OrderSkeletonStatus valueOf(String r1) {
        return (OrderSkeletonStatus) r27.a.a(OrderSkeletonStatus.class, r1);
    }

    public static OrderSkeletonStatus[] values() {
        return (OrderSkeletonStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderSkeletonStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
