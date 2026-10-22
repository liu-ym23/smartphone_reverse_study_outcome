package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DocSortRuleType extends Enum<DocSortRuleType> implements WireEnum {
    private static final /* synthetic */ DocSortRuleType[] $VALUES = null;
    public static final ProtoAdapter<DocSortRuleType> ADAPTER = null;
    public static final DocSortRuleType CREATE_TIME = null;
    public static final DocSortRuleType DEFAULT_TYPE = null;
    public static final DocSortRuleType EDIT_TIME = null;
    public static final DocSortRuleType EDIT_TIME_ASC = null;
    public static final DocSortRuleType ENTITY_CREATE_TIME_ASC = null;
    public static final DocSortRuleType ENTITY_CREATE_TIME_DESC = null;
    public static final DocSortRuleType FILTER_EDIT = null;
    public static final DocSortRuleType FILTER_OPEN = null;
    public static final DocSortRuleType MSG_CREATE_TIME = null;
    public static final DocSortRuleType OPEN_TIME = null;
    public static final DocSortRuleType TAG_TIME_ASC = null;
    public static final DocSortRuleType TAG_TIME_DESC = null;
    private final int value;

    static {
        DocSortRuleType r100 = new DocSortRuleType("DEFAULT_TYPE", 0, 1);
        DEFAULT_TYPE = r100;
        DocSortRuleType r101 = new DocSortRuleType("OPEN_TIME", 1, 2);
        OPEN_TIME = r101;
        DocSortRuleType r102 = new DocSortRuleType("EDIT_TIME", 2, 4);
        EDIT_TIME = r102;
        DocSortRuleType r103 = new DocSortRuleType("EDIT_TIME_ASC", 3, 5);
        EDIT_TIME_ASC = r103;
        DocSortRuleType r104 = new DocSortRuleType("FILTER_OPEN", 4, 8);
        FILTER_OPEN = r104;
        DocSortRuleType r110 = new DocSortRuleType("FILTER_EDIT", 5, 16);
        FILTER_EDIT = r110;
        DocSortRuleType r111 = new DocSortRuleType("MSG_CREATE_TIME", 6, 32);
        MSG_CREATE_TIME = r111;
        DocSortRuleType r112 = new DocSortRuleType("ENTITY_CREATE_TIME_ASC", 7, 64);
        ENTITY_CREATE_TIME_ASC = r112;
        DocSortRuleType r113 = new DocSortRuleType("ENTITY_CREATE_TIME_DESC", 8, 65);
        ENTITY_CREATE_TIME_DESC = r113;
        DocSortRuleType r105 = new DocSortRuleType("TAG_TIME_ASC", 9, 128);
        TAG_TIME_ASC = r105;
        DocSortRuleType r114 = new DocSortRuleType("TAG_TIME_DESC", 10, 129);
        TAG_TIME_DESC = r114;
        DocSortRuleType r106 = new DocSortRuleType("CREATE_TIME", 11, 256);
        CREATE_TIME = r106;
        $VALUES = new DocSortRuleType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r114, r106};
        ADAPTER = ProtoAdapter.newEnumAdapter(DocSortRuleType.class);
    }

    public static DocSortRuleType[] values() {
        return (DocSortRuleType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DocSortRuleType fromValue(int r100) {
        if (r100 == 1) goto L51;
        if (r100 == 2) goto L49;
        if (r100 == 4) goto L47;
        if (r100 == 5) goto L45;
        if (r100 == 8) goto L43;
        if (r100 == 16) goto L41;
        if (r100 == 32) goto L39;
        if (r100 == 256) goto L37;
        if (r100 == 64) goto L35;
        if (r100 == 65) goto L33;
        if (r100 == 128) goto L31;
        if (r100 == 129) goto L29;
        return null;
    L29:
        return TAG_TIME_DESC;
    L31:
        return TAG_TIME_ASC;
    L33:
        return ENTITY_CREATE_TIME_DESC;
    L35:
        return ENTITY_CREATE_TIME_ASC;
    L37:
        return CREATE_TIME;
    L39:
        return MSG_CREATE_TIME;
    L41:
        return FILTER_EDIT;
    L43:
        return FILTER_OPEN;
    L45:
        return EDIT_TIME_ASC;
    L47:
        return EDIT_TIME;
    L49:
        return OPEN_TIME;
    L51:
        return DEFAULT_TYPE;
    }

    public static DocSortRuleType valueOf(String r100) {
        return (DocSortRuleType) a.a(DocSortRuleType.class, r100);
    }

    private DocSortRuleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
