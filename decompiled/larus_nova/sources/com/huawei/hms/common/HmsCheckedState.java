package com.huawei.hms.common;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum HmsCheckedState extends Enum<HmsCheckedState> {
    public static final HmsCheckedState NEED_UPDATE = null;
    public static final HmsCheckedState NOT_NEED_UPDATE = null;
    public static final HmsCheckedState UNCHECKED = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ HmsCheckedState[] f277017b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f277018a;

    static {
        HmsCheckedState r100 = new HmsCheckedState("UNCHECKED", 0, 0);
        UNCHECKED = r100;
        HmsCheckedState r101 = new HmsCheckedState("NOT_NEED_UPDATE", 1, 1);
        NOT_NEED_UPDATE = r101;
        HmsCheckedState r102 = new HmsCheckedState("NEED_UPDATE", 2, 2);
        NEED_UPDATE = r102;
        f277017b = new HmsCheckedState[]{r100, r101, r102};
    }

    public static HmsCheckedState[] values() {
        return (HmsCheckedState[]) f277017b.clone();
    }

    public int getState() {
        return this.f277018a;
    }

    public static HmsCheckedState valueOf(String r100) {
        return (HmsCheckedState) a.a(HmsCheckedState.class, r100);
    }

    private HmsCheckedState(String r100, int r101, int r102) {
        super(r100, r101);
        this.f277018a = r102;
    }
}
