package com.bytedance.ee.lark.infra.network.larkbrand.net;

import com.bytedance.ee.bear.operation.api.event.OperationName;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum RustNetworkLevel extends Enum<RustNetworkLevel> {
    public static final RustNetworkLevel EVALUATING = null;
    public static final RustNetworkLevel EXCELLENT = null;
    public static final RustNetworkLevel NET_UNAVAILABLE = null;
    public static final RustNetworkLevel OFFLINE = null;
    public static final RustNetworkLevel SERVICE_UNAVAILABLE = null;
    public static final RustNetworkLevel UNKNOWN = null;
    public static final RustNetworkLevel WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RustNetworkLevel[] f242804a = null;
    private String status;

    static {
        RustNetworkLevel r100 = new RustNetworkLevel("EXCELLENT", 0, "excellent");
        EXCELLENT = r100;
        RustNetworkLevel r101 = new RustNetworkLevel("EVALUATING", 1, "evaluating");
        EVALUATING = r101;
        RustNetworkLevel r102 = new RustNetworkLevel("WEAK", 2, "weak");
        WEAK = r102;
        RustNetworkLevel r103 = new RustNetworkLevel("NET_UNAVAILABLE", 3, "netUnavailable");
        NET_UNAVAILABLE = r103;
        RustNetworkLevel r104 = new RustNetworkLevel("SERVICE_UNAVAILABLE", 4, "serviceUnavailable");
        SERVICE_UNAVAILABLE = r104;
        RustNetworkLevel r105 = new RustNetworkLevel("OFFLINE", 5, OperationName.OPERATION_OFFLINE_AVAILABLE);
        OFFLINE = r105;
        RustNetworkLevel r110 = new RustNetworkLevel("UNKNOWN", 6, "unknown");
        UNKNOWN = r110;
        f242804a = new RustNetworkLevel[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static RustNetworkLevel[] values() {
        return (RustNetworkLevel[]) f242804a.clone();
    }

    public String getValue() {
        return this.status;
    }

    public static RustNetworkLevel forNumber(int r100) {
        switch(r100) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return UNKNOWN;
    L6:
        return OFFLINE;
    L8:
        return SERVICE_UNAVAILABLE;
    L10:
        return NET_UNAVAILABLE;
    L12:
        return WEAK;
    L14:
        return EVALUATING;
    L16:
        return EXCELLENT;
    }

    public static RustNetworkLevel valueOf(String r100) {
        return (RustNetworkLevel) a.a(RustNetworkLevel.class, r100);
    }

    public RustNetworkLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
