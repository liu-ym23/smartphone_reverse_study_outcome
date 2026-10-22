package com.ss.bytertc.engine.device;

import com.alibaba.gaiax.model.GXAnimation;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum DeviceState extends Enum<DeviceState> {
    private static final /* synthetic */ DeviceState[] $VALUES = null;
    public static final DeviceState INIT = null;
    public static final DeviceState REMOVE = null;
    public static final DeviceState START = null;
    public static final DeviceState STOP = null;
    int type;

    static {
        DeviceState r100 = new DeviceState(ErrorCode.INIT, 0, 0);
        INIT = r100;
        DeviceState r101 = new DeviceState(GXAnimation.STATE_START, 1, 1);
        START = r101;
        DeviceState r102 = new DeviceState("STOP", 2, 2);
        STOP = r102;
        DeviceState r103 = new DeviceState("REMOVE", 3, 3);
        REMOVE = r103;
        $VALUES = new DeviceState[]{r100, r101, r102, r103};
    }

    public static DeviceState[] values() {
        return (DeviceState[]) $VALUES.clone();
    }

    public int getId() {
        return this.type;
    }

    public static DeviceState fromId(int r100) {
        DeviceState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DeviceState r104 = r101[r103];
        if (r104.getId() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DeviceState valueOf(String r100) {
        return (DeviceState) a.a(DeviceState.class, r100);
    }

    private DeviceState(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
