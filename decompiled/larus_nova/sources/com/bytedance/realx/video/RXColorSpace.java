package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public final enum RXColorSpace extends Enum<RXColorSpace> {
    private static final /* synthetic */ RXColorSpace[] $VALUES = null;
    public static final RXColorSpace kUnknown = null;
    public static final RXColorSpace kYCbCrBT601FullRange = null;
    public static final RXColorSpace kYCbCrBT601LimitedRange = null;
    public static final RXColorSpace kYCbCrBT709FullRange = null;
    public static final RXColorSpace kYCbCrBT709LimitedRange = null;
    private int colorSpace;

    /* JADX INFO: renamed from: com.bytedance.realx.video.RXColorSpace$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXColorSpace = null;

        static {
            int[] r100 = new int[RXColorSpace.values().length];
            $SwitchMap$com$bytedance$realx$video$RXColorSpace = r100;
            r100[RXColorSpace.kUnknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT601LimitedRange.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT601FullRange.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT709LimitedRange.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT709FullRange.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        RXColorSpace r100 = new RXColorSpace("kUnknown", 0, 0);
        kUnknown = r100;
        RXColorSpace r101 = new RXColorSpace("kYCbCrBT601LimitedRange", 1, 1);
        kYCbCrBT601LimitedRange = r101;
        RXColorSpace r102 = new RXColorSpace("kYCbCrBT601FullRange", 2, 2);
        kYCbCrBT601FullRange = r102;
        RXColorSpace r103 = new RXColorSpace("kYCbCrBT709LimitedRange", 3, 3);
        kYCbCrBT709LimitedRange = r103;
        RXColorSpace r104 = new RXColorSpace("kYCbCrBT709FullRange", 4, 4);
        kYCbCrBT709FullRange = r104;
        $VALUES = new RXColorSpace[]{r100, r101, r102, r103, r104};
    }

    public static RXColorSpace[] values() {
        return (RXColorSpace[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$bytedance$realx$video$RXColorSpace[ordinal()];
        if (r100 != 2) goto L5;
        return "kYCbCrBT601LimitedRange";
    L5:
        if (r100 != 3) goto L7;
        return "kYCbCrBT601FullRange";
    L7:
        if (r100 != 4) goto L9;
        return "kYCbCrBT709LimitedRange";
    L9:
        if (r100 == 5) goto L12;
        return "kUnknown";
    L12:
        return "kYCbCrBT709FullRange";
    }

    private int value() {
        return this.colorSpace;
    }

    public int getColorSpace() {
        return this.colorSpace;
    }

    public static RXColorSpace fromId(int r100) {
        RXColorSpace[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RXColorSpace r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RXColorSpace valueOf(String r100) {
        return (RXColorSpace) r27.a.a(RXColorSpace.class, r100);
    }

    private RXColorSpace(String r100, int r101, int r102) {
        super(r100, r101);
        this.colorSpace = r102;
    }
}
