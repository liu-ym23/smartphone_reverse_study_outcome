package com.bytedance.lark.pb.search.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SortType extends Enum<SortType> implements WireEnum {
    private static final /* synthetic */ SortType[] $VALUES = null;
    public static final ProtoAdapter<SortType> ADAPTER = null;
    public static final SortType ASC_BY_ENTITY_CREATE_TIME = null;
    public static final SortType ASC_BY_ENTITY_UPDATE_TIME = null;
    public static final SortType ASC_BY_TAG_CREATE_TIME = null;
    public static final SortType ASC_BY_TAG_UPDATE_TIME = null;
    public static final SortType DEFAULT = null;
    public static final SortType DESC_BY_ENTITY_CREATE_TIME = null;
    public static final SortType DESC_BY_ENTITY_UPDATE_TIME = null;
    public static final SortType DESC_BY_TAG_CREATE_TIME = null;
    public static final SortType DESC_BY_TAG_UPDATE_TIME = null;
    private final int value;

    static {
        SortType r100 = new SortType("DEFAULT", 0, 0);
        DEFAULT = r100;
        SortType r101 = new SortType("DESC_BY_TAG_CREATE_TIME", 1, 1);
        DESC_BY_TAG_CREATE_TIME = r101;
        SortType r102 = new SortType("ASC_BY_TAG_CREATE_TIME", 2, 2);
        ASC_BY_TAG_CREATE_TIME = r102;
        SortType r103 = new SortType("DESC_BY_TAG_UPDATE_TIME", 3, 3);
        DESC_BY_TAG_UPDATE_TIME = r103;
        SortType r104 = new SortType("ASC_BY_TAG_UPDATE_TIME", 4, 4);
        ASC_BY_TAG_UPDATE_TIME = r104;
        SortType r105 = new SortType("DESC_BY_ENTITY_CREATE_TIME", 5, 5);
        DESC_BY_ENTITY_CREATE_TIME = r105;
        SortType r110 = new SortType("ASC_BY_ENTITY_CREATE_TIME", 6, 6);
        ASC_BY_ENTITY_CREATE_TIME = r110;
        SortType r111 = new SortType("DESC_BY_ENTITY_UPDATE_TIME", 7, 7);
        DESC_BY_ENTITY_UPDATE_TIME = r111;
        SortType r112 = new SortType("ASC_BY_ENTITY_UPDATE_TIME", 8, 8);
        ASC_BY_ENTITY_UPDATE_TIME = r112;
        $VALUES = new SortType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        ADAPTER = ProtoAdapter.newEnumAdapter(SortType.class);
    }

    public static SortType[] values() {
        return (SortType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SortType fromValue(int r100) {
        switch(r100) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return ASC_BY_ENTITY_UPDATE_TIME;
    L8:
        return DESC_BY_ENTITY_UPDATE_TIME;
    L10:
        return ASC_BY_ENTITY_CREATE_TIME;
    L12:
        return DESC_BY_ENTITY_CREATE_TIME;
    L14:
        return ASC_BY_TAG_UPDATE_TIME;
    L16:
        return DESC_BY_TAG_UPDATE_TIME;
    L18:
        return ASC_BY_TAG_CREATE_TIME;
    L20:
        return DESC_BY_TAG_CREATE_TIME;
    L22:
        return DEFAULT;
    }

    public static SortType valueOf(String r100) {
        return (SortType) a.a(SortType.class, r100);
    }

    private SortType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
