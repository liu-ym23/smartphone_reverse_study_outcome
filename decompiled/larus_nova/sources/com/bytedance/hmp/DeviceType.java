package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum DeviceType extends Enum<DeviceType> {
    private static final /* synthetic */ DeviceType[] $VALUES = null;
    public static final DeviceType kCPU = null;
    public static final DeviceType kCUDA = null;
    private final int value;

    static {
        DeviceType r100 = new DeviceType("kCPU", 0, 0);
        kCPU = r100;
        DeviceType r101 = new DeviceType("kCUDA", 1, 1);
        kCUDA = r101;
        $VALUES = new DeviceType[]{r100, r101};
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static DeviceType valueOf(String r100) {
        return (DeviceType) a.a(DeviceType.class, r100);
    }

    private DeviceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
