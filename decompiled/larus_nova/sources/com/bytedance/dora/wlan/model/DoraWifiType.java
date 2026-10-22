package com.bytedance.dora.wlan.model;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraWifiType extends Enum<DoraWifiType> {
    private static final /* synthetic */ DoraWifiType[] $VALUES = null;
    public static final DoraWifiType P2P = null;
    public static final DoraWifiType SOFT_AP = null;

    static {
        DoraWifiType r100 = new DoraWifiType("P2P", 0);
        P2P = r100;
        DoraWifiType r101 = new DoraWifiType("SOFT_AP", 1);
        SOFT_AP = r101;
        $VALUES = new DoraWifiType[]{r100, r101};
    }

    public static DoraWifiType[] values() {
        return (DoraWifiType[]) $VALUES.clone();
    }

    public static DoraWifiType valueOf(String r100) {
        return (DoraWifiType) a.a(DoraWifiType.class, r100);
    }

    private DoraWifiType(String r100, int r101) {
        super(r100, r101);
    }
}
