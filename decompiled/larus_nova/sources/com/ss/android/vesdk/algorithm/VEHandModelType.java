package com.ss.android.vesdk.algorithm;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEHandModelType extends Enum<VEHandModelType> {
    private static final /* synthetic */ VEHandModelType[] $VALUES = null;
    public static final VEHandModelType HAND_MODEL_BOX_REG = null;
    public static final VEHandModelType HAND_MODEL_DETECT = null;
    public static final VEHandModelType HAND_MODEL_GESTURE_CLS = null;
    public static final VEHandModelType HAND_MODEL_KEY_POINT = null;
    private int value;

    private static /* synthetic */ VEHandModelType[] $values() {
        return new VEHandModelType[]{HAND_MODEL_DETECT, HAND_MODEL_BOX_REG, HAND_MODEL_GESTURE_CLS, HAND_MODEL_KEY_POINT};
    }

    static {
        HAND_MODEL_DETECT = new VEHandModelType("HAND_MODEL_DETECT", 0, 1);
        HAND_MODEL_BOX_REG = new VEHandModelType("HAND_MODEL_BOX_REG", 1, 2);
        HAND_MODEL_GESTURE_CLS = new VEHandModelType("HAND_MODEL_GESTURE_CLS", 2, 4);
        HAND_MODEL_KEY_POINT = new VEHandModelType("HAND_MODEL_KEY_POINT", 3, 8);
        $VALUES = $values();
    }

    public static VEHandModelType[] values() {
        return (VEHandModelType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static VEHandModelType valueOf(String r100) {
        return (VEHandModelType) a.a(VEHandModelType.class, r100);
    }

    private VEHandModelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
