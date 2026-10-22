package com.bytedance.ee.bear.middleground.drive.export;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum NetworkLevel extends Enum<NetworkLevel> {
    public static final NetworkLevel EVALUATING = null;
    public static final NetworkLevel EXCELLENT = null;
    public static final NetworkLevel NET_UNAVAILABLE = null;
    public static final NetworkLevel OFFLINE = null;
    public static final NetworkLevel SERVICE_UNAVAILABLE = null;
    public static final NetworkLevel UNKNOWN = null;
    public static final NetworkLevel WEAK = null;
    public static final /* synthetic */ NetworkLevel[] a = null;
    private int status;

    static {
        NetworkLevel r0 = new NetworkLevel("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        NetworkLevel r1 = new NetworkLevel("EXCELLENT", 1, 1);
        EXCELLENT = r1;
        NetworkLevel r2 = new NetworkLevel("EVALUATING", 2, 2);
        EVALUATING = r2;
        NetworkLevel r5 = new NetworkLevel("WEAK", 3, 3);
        WEAK = r5;
        NetworkLevel r7 = new NetworkLevel("NET_UNAVAILABLE", 4, 4);
        NET_UNAVAILABLE = r7;
        NetworkLevel r9 = new NetworkLevel("SERVICE_UNAVAILABLE", 5, 5);
        SERVICE_UNAVAILABLE = r9;
        NetworkLevel r11 = new NetworkLevel("OFFLINE", 6, 6);
        OFFLINE = r11;
        a = new NetworkLevel[]{r0, r1, r2, r5, r7, r9, r11};
    }

    public static NetworkLevel[] values() {
        return (NetworkLevel[]) a.clone();
    }

    public int getValue() {
        return this.status;
    }

    public static NetworkLevel forNumber(int r0) {
        switch(r0) {
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

    public static NetworkLevel valueOf(String r1) {
        return (NetworkLevel) a.a(NetworkLevel.class, r1);
    }

    public NetworkLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
