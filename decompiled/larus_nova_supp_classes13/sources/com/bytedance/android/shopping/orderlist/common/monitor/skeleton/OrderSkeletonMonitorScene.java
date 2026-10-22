package com.bytedance.android.shopping.orderlist.common.monitor.skeleton;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/monitor/skeleton/OrderSkeletonMonitorScene;", "", "", "value", "I", "getValue", "()I", "SCENE_SKELETON_SHOW", "SCENE_LAST_PAGE_LEAVE", "SCENE_LAST_APP_BACKGROUND", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderSkeletonMonitorScene extends Enum<OrderSkeletonMonitorScene> {
    public static final OrderSkeletonMonitorScene SCENE_LAST_APP_BACKGROUND = null;
    public static final OrderSkeletonMonitorScene SCENE_LAST_PAGE_LEAVE = null;
    public static final OrderSkeletonMonitorScene SCENE_SKELETON_SHOW = null;
    public static final /* synthetic */ OrderSkeletonMonitorScene[] a = null;
    private final int value;

    static {
        OrderSkeletonMonitorScene r1 = new OrderSkeletonMonitorScene("SCENE_SKELETON_SHOW", 0, 0);
        SCENE_SKELETON_SHOW = r1;
        OrderSkeletonMonitorScene r2 = new OrderSkeletonMonitorScene("SCENE_LAST_PAGE_LEAVE", 1, 1);
        SCENE_LAST_PAGE_LEAVE = r2;
        OrderSkeletonMonitorScene r3 = new OrderSkeletonMonitorScene("SCENE_LAST_APP_BACKGROUND", 2, 2);
        SCENE_LAST_APP_BACKGROUND = r3;
        a = new OrderSkeletonMonitorScene[]{r1, r2, r3};
    }

    public static OrderSkeletonMonitorScene valueOf(String r1) {
        return (OrderSkeletonMonitorScene) r27.a.a(OrderSkeletonMonitorScene.class, r1);
    }

    public static OrderSkeletonMonitorScene[] values() {
        return (OrderSkeletonMonitorScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderSkeletonMonitorScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
