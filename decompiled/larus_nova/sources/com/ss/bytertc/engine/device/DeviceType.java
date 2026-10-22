package com.ss.bytertc.engine.device;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum DeviceType extends Enum<DeviceType> {
    private static final /* synthetic */ DeviceType[] $VALUES = null;
    public static final DeviceType CAMERA = null;
    public static final DeviceType MICROPHONE = null;
    public static final DeviceType SPEAKER = null;
    int type;

    static {
        DeviceType r100 = new DeviceType("MICROPHONE", 0, 0);
        MICROPHONE = r100;
        DeviceType r101 = new DeviceType("SPEAKER", 1, 1);
        SPEAKER = r101;
        DeviceType r102 = new DeviceType("CAMERA", 2, 2);
        CAMERA = r102;
        $VALUES = new DeviceType[]{r100, r101, r102};
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }

    public int getId() {
        return this.type;
    }

    public static DeviceType fromId(int r100) {
        DeviceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DeviceType r104 = r101[r103];
        if (r104.getId() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DeviceType valueOf(String r100) {
        return (DeviceType) a.a(DeviceType.class, r100);
    }

    private DeviceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
