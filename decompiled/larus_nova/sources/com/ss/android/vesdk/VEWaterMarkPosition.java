package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEWaterMarkPosition extends Enum<VEWaterMarkPosition> {
    private static final /* synthetic */ VEWaterMarkPosition[] $VALUES = null;
    public static final VEWaterMarkPosition BL = null;
    public static final VEWaterMarkPosition BR = null;
    public static final VEWaterMarkPosition TL = null;
    public static final VEWaterMarkPosition TL_BR = null;
    public static final VEWaterMarkPosition TR = null;

    private static /* synthetic */ VEWaterMarkPosition[] $values() {
        return new VEWaterMarkPosition[]{TL_BR, BR, BL, TR, TL};
    }

    static {
        TL_BR = new VEWaterMarkPosition("TL_BR", 0);
        BR = new VEWaterMarkPosition("BR", 1);
        BL = new VEWaterMarkPosition("BL", 2);
        TR = new VEWaterMarkPosition("TR", 3);
        TL = new VEWaterMarkPosition("TL", 4);
        $VALUES = $values();
    }

    public static VEWaterMarkPosition[] values() {
        return (VEWaterMarkPosition[]) $VALUES.clone();
    }

    public static VEWaterMarkPosition valueOf(String r100) {
        return (VEWaterMarkPosition) r27.a.a(VEWaterMarkPosition.class, r100);
    }

    private VEWaterMarkPosition(String r100, int r101) {
        super(r100, r101);
    }
}
