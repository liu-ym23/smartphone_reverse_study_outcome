package com.bytedance.common.wschannel.heartbeat.smart.state;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum StateType extends Enum<StateType> {
    private static final /* synthetic */ StateType[] $VALUES = null;
    public static final StateType ACTIVE = null;
    public static final StateType IDLE = null;
    public static final StateType PLUMB = null;
    public static final StateType SECONDARY_ACTIVE = null;
    public static final StateType STABLE = null;

    static {
        StateType r100 = new StateType("ACTIVE", 0);
        ACTIVE = r100;
        StateType r101 = new StateType("SECONDARY_ACTIVE", 1);
        SECONDARY_ACTIVE = r101;
        StateType r102 = new StateType("PLUMB", 2);
        PLUMB = r102;
        StateType r103 = new StateType("STABLE", 3);
        STABLE = r103;
        StateType r104 = new StateType("IDLE", 4);
        IDLE = r104;
        $VALUES = new StateType[]{r100, r101, r102, r103, r104};
    }

    public static StateType[] values() {
        return (StateType[]) $VALUES.clone();
    }

    public static StateType valueOf(String r100) {
        return (StateType) a.a(StateType.class, r100);
    }

    private StateType(String r100, int r101) {
        super(r100, r101);
    }
}
