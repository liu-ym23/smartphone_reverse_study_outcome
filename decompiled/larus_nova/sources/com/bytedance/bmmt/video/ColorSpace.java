package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public final enum ColorSpace extends Enum<ColorSpace> {
    private static final /* synthetic */ ColorSpace[] $VALUES = null;
    public static final ColorSpace kUnknown = null;
    public static final ColorSpace kYCbCrBT601FullRange = null;
    public static final ColorSpace kYCbCrBT601LimitedRange = null;
    public static final ColorSpace kYCbCrBT709FullRange = null;
    public static final ColorSpace kYCbCrBT709LimitedRange = null;
    private int colorSpace;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.ColorSpace$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$ColorSpace = null;

        static {
            int[] r100 = new int[ColorSpace.values().length];
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace = r100;
            r100[ColorSpace.kUnknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT601LimitedRange.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT601FullRange.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT709LimitedRange.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$bytedance$bmmt$video$ColorSpace[ColorSpace.kYCbCrBT709FullRange.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static /* synthetic */ ColorSpace[] $values() {
        return new ColorSpace[]{kUnknown, kYCbCrBT601LimitedRange, kYCbCrBT601FullRange, kYCbCrBT709LimitedRange, kYCbCrBT709FullRange};
    }

    static {
        kUnknown = new ColorSpace("kUnknown", 0, 0);
        kYCbCrBT601LimitedRange = new ColorSpace("kYCbCrBT601LimitedRange", 1, 1);
        kYCbCrBT601FullRange = new ColorSpace("kYCbCrBT601FullRange", 2, 2);
        kYCbCrBT709LimitedRange = new ColorSpace("kYCbCrBT709LimitedRange", 3, 3);
        kYCbCrBT709FullRange = new ColorSpace("kYCbCrBT709FullRange", 4, 4);
        $VALUES = $values();
    }

    public static ColorSpace[] values() {
        return (ColorSpace[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$ColorSpace[ordinal()];
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

    public static ColorSpace fromId(int r100) {
        ColorSpace[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ColorSpace r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ColorSpace valueOf(String r100) {
        return (ColorSpace) r27.a.a(ColorSpace.class, r100);
    }

    private ColorSpace(String r100, int r101, int r102) {
        super(r100, r101);
        this.colorSpace = r102;
    }
}
