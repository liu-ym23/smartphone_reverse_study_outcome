package com.bytedance.ug.sdk.luckydog.api.ab;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ABServiceType extends Enum<ABServiceType> {
    private static final /* synthetic */ ABServiceType[] $VALUES = null;
    public static final ABServiceType BULLET_CONTAINER_SWITCH = null;
    public static final ABServiceType DIALOG = null;
    public static final ABServiceType SETTINGS = null;
    public static final ABServiceType TIME_CALIBRATOR = null;
    private final String mServiceId;

    static {
        ABServiceType r100 = new ABServiceType("TIME_CALIBRATOR", 0, "calibrator");
        TIME_CALIBRATOR = r100;
        ABServiceType r101 = new ABServiceType("SETTINGS", 1, "settings");
        SETTINGS = r101;
        ABServiceType r102 = new ABServiceType("DIALOG", 2, "dialog");
        DIALOG = r102;
        ABServiceType r103 = new ABServiceType("BULLET_CONTAINER_SWITCH", 3, "bullet_container_switch");
        BULLET_CONTAINER_SWITCH = r103;
        $VALUES = new ABServiceType[]{r100, r101, r102, r103};
    }

    public static ABServiceType[] values() {
        return (ABServiceType[]) $VALUES.clone();
    }

    public static String getServiceId(ABServiceType r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.mServiceId;
    }

    public static ABServiceType getServiceType(String r100) {
        ABServiceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ABServiceType r104 = r101[r103];
        if (r104.mServiceId.equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ABServiceType valueOf(String r100) {
        return (ABServiceType) a.a(ABServiceType.class, r100);
    }

    private ABServiceType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mServiceId = r102;
    }
}
