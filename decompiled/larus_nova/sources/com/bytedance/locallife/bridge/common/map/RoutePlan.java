package com.bytedance.locallife.bridge.common.map;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/bridge/common/map/RoutePlan;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "RouteWalk", "RouteDrive", "RouteBus", "RouteRide", "NULL", "locallife-bridge_release"}, k = 1, mv = {1, 4, 3})
public final enum RoutePlan extends Enum<RoutePlan> {
    public static final RoutePlan NULL = null;
    public static final RoutePlan RouteBus = null;
    public static final RoutePlan RouteDrive = null;
    public static final RoutePlan RouteRide = null;
    public static final RoutePlan RouteWalk = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoutePlan[] f257034a = null;
    private final String value;

    public static RoutePlan valueOf(String r100) {
        return (RoutePlan) r27.a.a(RoutePlan.class, r100);
    }

    public static RoutePlan[] values() {
        return (RoutePlan[]) f257034a.clone();
    }

    static {
        RoutePlan r100 = new RoutePlan("RouteWalk", 0, "walk");
        RouteWalk = r100;
        RoutePlan r101 = new RoutePlan("RouteDrive", 1, "drive");
        RouteDrive = r101;
        RoutePlan r102 = new RoutePlan("RouteBus", 2, "bus");
        RouteBus = r102;
        RoutePlan r103 = new RoutePlan("RouteRide", 3, "cycle");
        RouteRide = r103;
        RoutePlan r104 = new RoutePlan("NULL", 4, "null");
        NULL = r104;
        f257034a = new RoutePlan[]{r100, r101, r102, r103, r104};
    }

    public final String getValue() {
        return this.value;
    }

    public RoutePlan(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
