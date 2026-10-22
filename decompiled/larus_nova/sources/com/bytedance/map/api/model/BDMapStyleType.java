package com.bytedance.map.api.model;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum BDMapStyleType extends Enum<BDMapStyleType> {
    private static final /* synthetic */ BDMapStyleType[] $VALUES = null;
    public static final BDMapStyleType NORMAL_DARK = null;
    public static final BDMapStyleType NORMAL_LIGHT = null;
    public static final BDMapStyleType SIMPLE_DARK = null;
    public static final BDMapStyleType SIMPLE_LIGHT = null;

    static {
        BDMapStyleType r100 = new BDMapStyleType("NORMAL_LIGHT", 0);
        NORMAL_LIGHT = r100;
        BDMapStyleType r101 = new BDMapStyleType("NORMAL_DARK", 1);
        NORMAL_DARK = r101;
        BDMapStyleType r102 = new BDMapStyleType("SIMPLE_LIGHT", 2);
        SIMPLE_LIGHT = r102;
        BDMapStyleType r103 = new BDMapStyleType("SIMPLE_DARK", 3);
        SIMPLE_DARK = r103;
        $VALUES = new BDMapStyleType[]{r100, r101, r102, r103};
    }

    public static BDMapStyleType[] values() {
        return (BDMapStyleType[]) $VALUES.clone();
    }

    public static BDMapStyleType valueOf(String r100) {
        return (BDMapStyleType) a.a(BDMapStyleType.class, r100);
    }

    private BDMapStyleType(String r100, int r101) {
        super(r100, r101);
    }
}
