package com.bytedance.crypto.pake;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum PakeRole extends Enum<PakeRole> {
    private static final /* synthetic */ PakeRole[] $VALUES = null;
    public static final PakeRole ALICE = null;
    public static final PakeRole BOB = null;

    static {
        PakeRole r100 = new PakeRole("ALICE", 0);
        ALICE = r100;
        PakeRole r101 = new PakeRole("BOB", 1);
        BOB = r101;
        $VALUES = new PakeRole[]{r100, r101};
    }

    private PakeRole(String r100, int r101) {
        super(r100, r101);
    }

    public static PakeRole valueOf(String r100) {
        return (PakeRole) a.a(PakeRole.class, r100);
    }

    public static PakeRole[] values() {
        return (PakeRole[]) $VALUES.clone();
    }
}
