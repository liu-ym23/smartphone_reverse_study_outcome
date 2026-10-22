package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ColorSpace extends Enum<ColorSpace> {
    private static final /* synthetic */ ColorSpace[] $VALUES = null;
    public static final ColorSpace BT601_FULL_RANGE = null;
    public static final ColorSpace BT601_LIMITED_RANGE = null;
    public static final ColorSpace BT709_FULL_RANGE = null;
    public static final ColorSpace BT709_LIMITED_RANGE = null;
    public static final ColorSpace UNKNOWN = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.ColorSpace$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$ColorSpace = null;

        static {
            int[] r100 = new int[ColorSpace.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$ColorSpace = r100;
            r100[ColorSpace.BT601_LIMITED_RANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ColorSpace.BT601_FULL_RANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ColorSpace.BT709_LIMITED_RANGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ColorSpace.BT709_FULL_RANGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        ColorSpace r100 = new ColorSpace("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ColorSpace r101 = new ColorSpace("BT601_LIMITED_RANGE", 1, 1);
        BT601_LIMITED_RANGE = r101;
        ColorSpace r102 = new ColorSpace("BT601_FULL_RANGE", 2, 2);
        BT601_FULL_RANGE = r102;
        ColorSpace r103 = new ColorSpace("BT709_LIMITED_RANGE", 3, 3);
        BT709_LIMITED_RANGE = r103;
        ColorSpace r104 = new ColorSpace("BT709_FULL_RANGE", 4, 4);
        BT709_FULL_RANGE = r104;
        $VALUES = new ColorSpace[]{r100, r101, r102, r103, r104};
    }

    public static ColorSpace[] values() {
        return (ColorSpace[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$ColorSpace[ordinal()];
        if (r100 != 1) goto L5;
        return "kColorSpaceYCbCrBT601LimitedRange";
    L5:
        if (r100 != 2) goto L7;
        return "kColorSpaceYCbCrBT601FullRange";
    L7:
        if (r100 != 3) goto L9;
        return "kColorSpaceYCbCrBT709LimitedRange";
    L9:
        if (r100 == 4) goto L12;
        return "kColorSpaceUnknown";
    L12:
        return "kColorSpaceYCbCrBT709FullRange";
    }

    public int value() {
        return this.value;
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
        return (ColorSpace) a.a(ColorSpace.class, r100);
    }

    private ColorSpace(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
