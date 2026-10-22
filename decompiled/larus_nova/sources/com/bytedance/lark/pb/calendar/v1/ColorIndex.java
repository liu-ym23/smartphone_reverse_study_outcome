package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ColorIndex extends Enum<ColorIndex> implements WireEnum {
    private static final /* synthetic */ ColorIndex[] $VALUES = null;
    public static final ProtoAdapter<ColorIndex> ADAPTER = null;
    public static final ColorIndex BLUE = null;
    public static final ColorIndex CARMINE = null;
    public static final ColorIndex GREEN = null;
    public static final ColorIndex INDIGO = null;
    public static final ColorIndex NEUTRAL = null;
    public static final ColorIndex NONE_COLOR = null;
    public static final ColorIndex ORANGE = null;
    public static final ColorIndex PURPLE = null;
    public static final ColorIndex RED = null;
    public static final ColorIndex TURQUOISE = null;
    public static final ColorIndex VIOLET = null;
    public static final ColorIndex WATHET = null;
    public static final ColorIndex YELLOW = null;
    private final int value;

    static {
        ColorIndex r100 = new ColorIndex("CARMINE", 0, 0);
        CARMINE = r100;
        ColorIndex r101 = new ColorIndex("RED", 1, 1);
        RED = r101;
        ColorIndex r102 = new ColorIndex("ORANGE", 2, 2);
        ORANGE = r102;
        ColorIndex r103 = new ColorIndex("YELLOW", 3, 3);
        YELLOW = r103;
        ColorIndex r104 = new ColorIndex("GREEN", 4, 4);
        GREEN = r104;
        ColorIndex r105 = new ColorIndex("TURQUOISE", 5, 5);
        TURQUOISE = r105;
        ColorIndex r110 = new ColorIndex("BLUE", 6, 6);
        BLUE = r110;
        ColorIndex r111 = new ColorIndex("WATHET", 7, 7);
        WATHET = r111;
        ColorIndex r112 = new ColorIndex("INDIGO", 8, 8);
        INDIGO = r112;
        ColorIndex r113 = new ColorIndex("PURPLE", 9, 9);
        PURPLE = r113;
        ColorIndex r114 = new ColorIndex("VIOLET", 10, 10);
        VIOLET = r114;
        ColorIndex r115 = new ColorIndex("NEUTRAL", 11, 11);
        NEUTRAL = r115;
        ColorIndex r106 = new ColorIndex("NONE_COLOR", 12, 99);
        NONE_COLOR = r106;
        $VALUES = new ColorIndex[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        ADAPTER = ProtoAdapter.newEnumAdapter(ColorIndex.class);
    }

    public static ColorIndex[] values() {
        return (ColorIndex[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ColorIndex fromValue(int r100) {
        if (r100 == 99) goto L32;
        switch(r100) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return NEUTRAL;
    L10:
        return VIOLET;
    L12:
        return PURPLE;
    L14:
        return INDIGO;
    L16:
        return WATHET;
    L18:
        return BLUE;
    L20:
        return TURQUOISE;
    L22:
        return GREEN;
    L24:
        return YELLOW;
    L26:
        return ORANGE;
    L28:
        return RED;
    L30:
        return CARMINE;
    L32:
        return NONE_COLOR;
    }

    public static ColorIndex valueOf(String r100) {
        return (ColorIndex) a.a(ColorIndex.class, r100);
    }

    private ColorIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
