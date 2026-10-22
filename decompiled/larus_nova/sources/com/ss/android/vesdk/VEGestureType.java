package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEGestureType extends Enum<VEGestureType> {
    private static final /* synthetic */ VEGestureType[] $VALUES = null;
    public static final VEGestureType LongPress = null;
    public static final VEGestureType Pan = null;
    public static final VEGestureType Rotate = null;
    public static final VEGestureType Scale = null;
    public static final VEGestureType Tap = null;
    public static final VEGestureType Unknown = null;

    private static /* synthetic */ VEGestureType[] $values() {
        return new VEGestureType[]{Unknown, Tap, Pan, Rotate, Scale, LongPress};
    }

    static {
        Unknown = new VEGestureType("Unknown", 0);
        Tap = new VEGestureType("Tap", 1);
        Pan = new VEGestureType("Pan", 2);
        Rotate = new VEGestureType("Rotate", 3);
        Scale = new VEGestureType("Scale", 4);
        LongPress = new VEGestureType("LongPress", 5);
        $VALUES = $values();
    }

    public static VEGestureType[] values() {
        return (VEGestureType[]) $VALUES.clone();
    }

    public static VEGestureType valueOf(String r100) {
        return (VEGestureType) r27.a.a(VEGestureType.class, r100);
    }

    private VEGestureType(String r100, int r101) {
        super(r100, r101);
    }
}
