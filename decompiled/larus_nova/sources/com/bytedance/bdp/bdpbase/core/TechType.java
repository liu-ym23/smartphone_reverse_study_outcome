package com.bytedance.bdp.bdpbase.core;

import com.bytedance.bdp.bdpbase.schema.SchemaInfo;

/* JADX INFO: loaded from: classes11.dex */
public final enum TechType extends Enum<TechType> {
    private static final /* synthetic */ TechType[] $VALUES = null;
    public static final TechType H5_GAME = null;
    public static final TechType INTERACTION_GAME = null;
    public static final TechType MINI_APP = null;
    public static final TechType MINI_GAME = null;
    public static final TechType UC_GAME = null;
    public static final TechType UNKNOWN = null;
    private int type;

    static {
        TechType r100 = new TechType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        TechType r101 = new TechType("MINI_APP", 1, 1);
        MINI_APP = r101;
        TechType r102 = new TechType("MINI_GAME", 2, 2);
        MINI_GAME = r102;
        TechType r103 = new TechType("H5_GAME", 3, 4);
        H5_GAME = r103;
        TechType r104 = new TechType("UC_GAME", 4, 7);
        UC_GAME = r104;
        TechType r110 = new TechType("INTERACTION_GAME", 5, 17);
        INTERACTION_GAME = r110;
        $VALUES = new TechType[]{r100, r101, r102, r103, r104, r110};
    }

    public static TechType[] values() {
        return (TechType[]) $VALUES.clone();
    }

    public int toInt() {
        return this.type;
    }

    public static TechType parse(int r100) {
        TechType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        TechType r104 = r101[r103];
        if (r104.type == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static TechType valueOf(String r100) {
        return (TechType) r27.a.a(TechType.class, r100);
    }

    public static TechType parse(SchemaInfo r100) {
        return parse(r100.o());
    }

    public static TechType parse(String r100) {
        return parse(r100, null);
    }

    public static TechType parse(String r100, BdpStartUpParam r101) {
        if (r101 == null) goto L7;
        int r102 = r101.getAssignedTechType();
        if (r102 == 0) goto L7;
        return parse(r102);
    L7:
        SchemaInfo r103 = SchemaInfo.r(r100);
        if (r103 != null) goto L12;
        return UNKNOWN;
    L12:
        return parse(r103);
    }

    private TechType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
