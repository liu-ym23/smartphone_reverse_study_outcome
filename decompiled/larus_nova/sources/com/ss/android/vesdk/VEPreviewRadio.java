package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEPreviewRadio extends Enum<VEPreviewRadio> {
    private static final /* synthetic */ VEPreviewRadio[] $VALUES = null;
    public static final VEPreviewRadio RADIO_1_1 = null;
    public static final VEPreviewRadio RADIO_3_4 = null;
    public static final VEPreviewRadio RADIO_9_16 = null;
    public static final VEPreviewRadio RADIO_FULL = null;
    public static final VEPreviewRadio RADIO_ROUND = null;

    private static /* synthetic */ VEPreviewRadio[] $values() {
        return new VEPreviewRadio[]{RADIO_9_16, RADIO_3_4, RADIO_1_1, RADIO_FULL, RADIO_ROUND};
    }

    static {
        RADIO_9_16 = new VEPreviewRadio("RADIO_9_16", 0);
        RADIO_3_4 = new VEPreviewRadio("RADIO_3_4", 1);
        RADIO_1_1 = new VEPreviewRadio("RADIO_1_1", 2);
        RADIO_FULL = new VEPreviewRadio("RADIO_FULL", 3);
        RADIO_ROUND = new VEPreviewRadio("RADIO_ROUND", 4);
        $VALUES = $values();
    }

    public static VEPreviewRadio[] values() {
        return (VEPreviewRadio[]) $VALUES.clone();
    }

    public static VEPreviewRadio valueOf(String r100) {
        return (VEPreviewRadio) r27.a.a(VEPreviewRadio.class, r100);
    }

    private VEPreviewRadio(String r100, int r101) {
        super(r100, r101);
    }
}
