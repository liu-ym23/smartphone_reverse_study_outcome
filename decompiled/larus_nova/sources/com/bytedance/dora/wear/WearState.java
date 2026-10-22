package com.bytedance.dora.wear;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum WearState extends Enum<WearState> {
    public static final WearState INVALID = null;
    public static final WearState OFF = null;
    public static final WearState ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WearState[] f204668a = null;

    static {
        WearState r100 = new WearState("OFF", 0);
        OFF = r100;
        WearState r101 = new WearState("ON", 1);
        ON = r101;
        WearState r102 = new WearState("INVALID", 2);
        INVALID = r102;
        f204668a = new WearState[]{r100, r101, r102};
    }

    public static WearState[] values() {
        return (WearState[]) f204668a.clone();
    }

    public static WearState valueOf(String r100) {
        return (WearState) a.a(WearState.class, r100);
    }

    public WearState(String r100, int r101) {
        super(r100, r101);
    }
}
