package com.hihonor.android.softsim;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum SimCommandType extends Enum<SimCommandType> {
    public static final SimCommandType APDU_DATA = null;
    public static final SimCommandType APDU_REQUEST = null;
    public static final SimCommandType ATR_DATA = null;
    public static final SimCommandType INVALID_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SimCommandType[] f276472a = null;

    static {
        SimCommandType r100 = new SimCommandType("ATR_DATA", 0);
        ATR_DATA = r100;
        SimCommandType r101 = new SimCommandType("APDU_REQUEST", 1);
        APDU_REQUEST = r101;
        SimCommandType r102 = new SimCommandType("APDU_DATA", 2);
        APDU_DATA = r102;
        SimCommandType r103 = new SimCommandType("INVALID_TYPE", 3);
        INVALID_TYPE = r103;
        f276472a = new SimCommandType[]{r100, r101, r102, r103};
    }

    public static SimCommandType[] values() {
        return (SimCommandType[]) f276472a.clone();
    }

    public int getValue() {
        throw new RuntimeException("Stub!");
    }

    public static SimCommandType getSimCommandType(int r100) {
        throw new RuntimeException("Stub!");
    }

    public static SimCommandType valueOf(String r100) {
        return (SimCommandType) a.a(SimCommandType.class, r100);
    }

    public SimCommandType(String r100, int r101) {
        super(r100, r101);
    }
}
