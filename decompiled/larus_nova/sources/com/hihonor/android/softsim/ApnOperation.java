package com.hihonor.android.softsim;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum ApnOperation extends Enum<ApnOperation> {
    public static final ApnOperation CLEAR_APN = null;
    public static final ApnOperation INSERT_APN = null;
    public static final ApnOperation INVALID_OPERATION = null;
    public static final ApnOperation LOOK_UP_APN = null;
    public static final ApnOperation SET_PREFERRED_APN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApnOperation[] f276469a = null;

    static {
        ApnOperation r100 = new ApnOperation("LOOK_UP_APN", 0);
        LOOK_UP_APN = r100;
        ApnOperation r101 = new ApnOperation("INSERT_APN", 1);
        INSERT_APN = r101;
        ApnOperation r102 = new ApnOperation("SET_PREFERRED_APN", 2);
        SET_PREFERRED_APN = r102;
        ApnOperation r103 = new ApnOperation("CLEAR_APN", 3);
        CLEAR_APN = r103;
        ApnOperation r104 = new ApnOperation("INVALID_OPERATION", 4);
        INVALID_OPERATION = r104;
        f276469a = new ApnOperation[]{r100, r101, r102, r103, r104};
    }

    public static ApnOperation[] values() {
        return (ApnOperation[]) f276469a.clone();
    }

    public int getValue() {
        throw new RuntimeException("Stub!");
    }

    public static ApnOperation getApnOperation(int r100) {
        throw new RuntimeException("Stub!");
    }

    public static ApnOperation valueOf(String r100) {
        return (ApnOperation) a.a(ApnOperation.class, r100);
    }

    public ApnOperation(String r100, int r101) {
        super(r100, r101);
    }
}
