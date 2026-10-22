package com.bytedance.privacy.pcc;

/* JADX INFO: loaded from: classes3.dex */
public final enum LaneType extends Enum<LaneType> {
    private static final /* synthetic */ LaneType[] $VALUES = null;
    public static final LaneType CPU_NORMAL = null;
    public static final LaneType CPU_TEE = null;
    public static final LaneType GPU_TEE = null;
    public static final LaneType IGNORE = null;
    private final int value;

    private static /* synthetic */ LaneType[] $values() {
        return new LaneType[]{IGNORE, CPU_NORMAL, CPU_TEE, GPU_TEE};
    }

    public static boolean isValid(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r100 > 3) goto L6;
        return true;
    }

    static {
        IGNORE = new LaneType("IGNORE", 0, 0);
        CPU_NORMAL = new LaneType("CPU_NORMAL", 1, 1);
        CPU_TEE = new LaneType("CPU_TEE", 2, 2);
        GPU_TEE = new LaneType("GPU_TEE", 3, 3);
        $VALUES = $values();
    }

    public static LaneType[] values() {
        return (LaneType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static LaneType fromValue(int r100) {
        LaneType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        LaneType r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return CPU_NORMAL;
    }

    public static LaneType valueOf(String r100) {
        return (LaneType) r27.a.a(LaneType.class, r100);
    }

    public static LaneType min(LaneType r100, LaneType r101) {
        if (r100.value > r101.value) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static LaneType negotiate(LaneType r100, LaneType r101) {
        LaneType r102 = IGNORE;
        if (r100 != r102) goto L7;
        if (r101 != r102) goto L7;
        return CPU_NORMAL;
    L7:
        if (r100 != r102) goto L9;
        return r101;
    L9:
        if (r101 != r102) goto L12;
        return r100;
    L12:
        return min(r100, r101);
    }

    private LaneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
