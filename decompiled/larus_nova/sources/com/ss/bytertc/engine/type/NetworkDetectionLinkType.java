package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum NetworkDetectionLinkType extends Enum<NetworkDetectionLinkType> {
    private static final /* synthetic */ NetworkDetectionLinkType[] $VALUES = null;
    public static final NetworkDetectionLinkType DOWN = null;
    public static final NetworkDetectionLinkType UP = null;
    int value;

    static {
        NetworkDetectionLinkType r100 = new NetworkDetectionLinkType("UP", 0, 0);
        UP = r100;
        NetworkDetectionLinkType r101 = new NetworkDetectionLinkType("DOWN", 1, 1);
        DOWN = r101;
        $VALUES = new NetworkDetectionLinkType[]{r100, r101};
    }

    public static NetworkDetectionLinkType[] values() {
        return (NetworkDetectionLinkType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static NetworkDetectionLinkType fromId(int r100) {
        NetworkDetectionLinkType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        NetworkDetectionLinkType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UP;
    }

    public static NetworkDetectionLinkType valueOf(String r100) {
        return (NetworkDetectionLinkType) a.a(NetworkDetectionLinkType.class, r100);
    }

    private NetworkDetectionLinkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
