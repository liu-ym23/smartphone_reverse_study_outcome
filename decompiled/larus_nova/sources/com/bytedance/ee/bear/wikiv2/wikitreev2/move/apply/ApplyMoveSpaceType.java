package com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum ApplyMoveSpaceType extends Enum<ApplyMoveSpaceType> {
    public static final ApplyMoveSpaceType APPLY_MOVE = null;
    public static final ApplyMoveSpaceType APPLY_REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplyMoveSpaceType[] f241599a = null;
    private final int type;

    static {
        ApplyMoveSpaceType r100 = new ApplyMoveSpaceType("APPLY_REMOVE", 0, 0);
        APPLY_REMOVE = r100;
        ApplyMoveSpaceType r101 = new ApplyMoveSpaceType("APPLY_MOVE", 1, 1);
        APPLY_MOVE = r101;
        f241599a = new ApplyMoveSpaceType[]{r100, r101};
    }

    public static ApplyMoveSpaceType[] values() {
        return (ApplyMoveSpaceType[]) f241599a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ApplyMoveSpaceType valueOf(String r100) {
        return (ApplyMoveSpaceType) a.a(ApplyMoveSpaceType.class, r100);
    }

    public ApplyMoveSpaceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
