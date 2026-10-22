package com.ss.android.lark.pb.section;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ModifierType extends Enum<ModifierType> implements WireEnum {
    private static final /* synthetic */ ModifierType[] $VALUES = null;
    public static final ModifierType ACTION = null;
    public static final ProtoAdapter<ModifierType> ADAPTER = null;
    public static final ModifierType EMPHASIS = null;
    public static final ModifierType HIGHLIGHT = null;
    public static final ModifierType TOOLTIPS = null;
    public static final ModifierType UNKNOWN = null;
    private final int value;

    static {
        ModifierType r100 = new ModifierType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ModifierType r101 = new ModifierType("ACTION", 1, 1);
        ACTION = r101;
        ModifierType r102 = new ModifierType("HIGHLIGHT", 2, 2);
        HIGHLIGHT = r102;
        ModifierType r103 = new ModifierType("EMPHASIS", 3, 3);
        EMPHASIS = r103;
        ModifierType r104 = new ModifierType("TOOLTIPS", 4, 4);
        TOOLTIPS = r104;
        $VALUES = new ModifierType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ModifierType.class);
    }

    public static ModifierType[] values() {
        return (ModifierType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ModifierType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return TOOLTIPS;
    L16:
        return EMPHASIS;
    L18:
        return HIGHLIGHT;
    L20:
        return ACTION;
    L22:
        return UNKNOWN;
    }

    public static ModifierType valueOf(String r100) {
        return (ModifierType) a.a(ModifierType.class, r100);
    }

    private ModifierType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
