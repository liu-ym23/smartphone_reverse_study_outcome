package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TagColor extends Enum<TagColor> implements WireEnum {
    private static final /* synthetic */ TagColor[] $VALUES = null;
    public static final ProtoAdapter<TagColor> ADAPTER = null;
    public static final TagColor BLUE = null;
    public static final TagColor CARMINE = null;
    public static final TagColor GRAY = null;
    public static final TagColor GREEN = null;
    public static final TagColor INDIGO = null;
    public static final TagColor LIME = null;
    public static final TagColor ORANGE = null;
    public static final TagColor PURPLE = null;
    public static final TagColor RED = null;
    public static final TagColor TURQUOISE = null;
    public static final TagColor VIOLET = null;
    public static final TagColor WATHET = null;
    public static final TagColor YELLOW = null;
    private final int value;

    static {
        TagColor r100 = new TagColor("BLUE", 0, 0);
        BLUE = r100;
        TagColor r101 = new TagColor("GRAY", 1, 1);
        GRAY = r101;
        TagColor r102 = new TagColor("INDIGO", 2, 2);
        INDIGO = r102;
        TagColor r103 = new TagColor("WATHET", 3, 3);
        WATHET = r103;
        TagColor r104 = new TagColor("GREEN", 4, 4);
        GREEN = r104;
        TagColor r105 = new TagColor("TURQUOISE", 5, 5);
        TURQUOISE = r105;
        TagColor r110 = new TagColor("YELLOW", 6, 6);
        YELLOW = r110;
        TagColor r111 = new TagColor("LIME", 7, 7);
        LIME = r111;
        TagColor r112 = new TagColor("RED", 8, 8);
        RED = r112;
        TagColor r113 = new TagColor("ORANGE", 9, 9);
        ORANGE = r113;
        TagColor r114 = new TagColor("PURPLE", 10, 10);
        PURPLE = r114;
        TagColor r115 = new TagColor("VIOLET", 11, 11);
        VIOLET = r115;
        TagColor r106 = new TagColor("CARMINE", 12, 12);
        CARMINE = r106;
        $VALUES = new TagColor[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        ADAPTER = ProtoAdapter.newEnumAdapter(TagColor.class);
    }

    public static TagColor[] values() {
        return (TagColor[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TagColor fromValue(int r100) {
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
            case 12: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CARMINE;
    L8:
        return VIOLET;
    L10:
        return PURPLE;
    L12:
        return ORANGE;
    L14:
        return RED;
    L16:
        return LIME;
    L18:
        return YELLOW;
    L20:
        return TURQUOISE;
    L22:
        return GREEN;
    L24:
        return WATHET;
    L26:
        return INDIGO;
    L28:
        return GRAY;
    L30:
        return BLUE;
    }

    public static TagColor valueOf(String r100) {
        return (TagColor) a.a(TagColor.class, r100);
    }

    private TagColor(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
