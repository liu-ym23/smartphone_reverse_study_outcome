package com.bytedance.ee.bear.middleground.drive.export;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum NetworkLevel extends Enum<NetworkLevel> {
    public static final NetworkLevel EVALUATING = null;
    public static final NetworkLevel EXCELLENT = null;
    public static final NetworkLevel NET_UNAVAILABLE = null;
    public static final NetworkLevel OFFLINE = null;
    public static final NetworkLevel SERVICE_UNAVAILABLE = null;
    public static final NetworkLevel UNKNOWN = null;
    public static final NetworkLevel WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkLevel[] f232467a = null;
    private int status;

    static {
        NetworkLevel r100 = new NetworkLevel("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        NetworkLevel r101 = new NetworkLevel("EXCELLENT", 1, 1);
        EXCELLENT = r101;
        NetworkLevel r102 = new NetworkLevel("EVALUATING", 2, 2);
        EVALUATING = r102;
        NetworkLevel r103 = new NetworkLevel("WEAK", 3, 3);
        WEAK = r103;
        NetworkLevel r104 = new NetworkLevel("NET_UNAVAILABLE", 4, 4);
        NET_UNAVAILABLE = r104;
        NetworkLevel r105 = new NetworkLevel("SERVICE_UNAVAILABLE", 5, 5);
        SERVICE_UNAVAILABLE = r105;
        NetworkLevel r110 = new NetworkLevel("OFFLINE", 6, 6);
        OFFLINE = r110;
        f232467a = new NetworkLevel[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static NetworkLevel[] values() {
        return (NetworkLevel[]) f232467a.clone();
    }

    public int getValue() {
        return this.status;
    }

    public static NetworkLevel forNumber(int r100) {
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

    public static NetworkLevel valueOf(String r100) {
        return (NetworkLevel) a.a(NetworkLevel.class, r100);
    }

    public NetworkLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
