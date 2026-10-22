package com.bytedance.platform.godzilla.plugin;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum StartType extends Enum<StartType> {
    public static final StartType IMMEDIATE = null;
    public static final StartType REGISTER_EXCEPTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StartType[] f266620a = null;

    static {
        StartType r100 = new StartType("IMMEDIATE", 0);
        IMMEDIATE = r100;
        StartType r101 = new StartType("REGISTER_EXCEPTION", 1);
        REGISTER_EXCEPTION = r101;
        f266620a = new StartType[]{r100, r101};
    }

    public static StartType[] values() {
        return (StartType[]) f266620a.clone();
    }

    public static StartType valueOf(String r100) {
        return (StartType) a.a(StartType.class, r100);
    }

    public StartType(String r100, int r101) {
        super(r100, r101);
    }
}
