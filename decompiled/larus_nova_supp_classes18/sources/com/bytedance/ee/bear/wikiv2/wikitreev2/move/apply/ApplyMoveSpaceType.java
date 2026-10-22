package com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum ApplyMoveSpaceType extends Enum<ApplyMoveSpaceType> {
    public static final ApplyMoveSpaceType APPLY_MOVE = null;
    public static final ApplyMoveSpaceType APPLY_REMOVE = null;
    public static final /* synthetic */ ApplyMoveSpaceType[] a = null;
    private final int type;

    static {
        ApplyMoveSpaceType r0 = new ApplyMoveSpaceType("APPLY_REMOVE", 0, 0);
        APPLY_REMOVE = r0;
        ApplyMoveSpaceType r1 = new ApplyMoveSpaceType("APPLY_MOVE", 1, 1);
        APPLY_MOVE = r1;
        a = new ApplyMoveSpaceType[]{r0, r1};
    }

    public static ApplyMoveSpaceType[] values() {
        return (ApplyMoveSpaceType[]) a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ApplyMoveSpaceType valueOf(String r1) {
        return (ApplyMoveSpaceType) a.a(ApplyMoveSpaceType.class, r1);
    }

    public ApplyMoveSpaceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
