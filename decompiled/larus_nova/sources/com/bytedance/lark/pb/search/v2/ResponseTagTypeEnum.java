package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ResponseTagTypeEnum extends Enum<ResponseTagTypeEnum> implements WireEnum {
    private static final /* synthetic */ ResponseTagTypeEnum[] $VALUES = null;
    public static final ProtoAdapter<ResponseTagTypeEnum> ADAPTER = null;
    public static final ResponseTagTypeEnum RELATION_TAG_EXTERNAL = null;
    public static final ResponseTagTypeEnum RELATION_TAG_PARTNER = null;
    public static final ResponseTagTypeEnum RELATION_TAG_TENANT_NAME = null;
    public static final ResponseTagTypeEnum RELATION_TAG_UNSET = null;
    private final int value;

    static {
        ResponseTagTypeEnum r100 = new ResponseTagTypeEnum("RELATION_TAG_UNSET", 0, 0);
        RELATION_TAG_UNSET = r100;
        ResponseTagTypeEnum r101 = new ResponseTagTypeEnum("RELATION_TAG_EXTERNAL", 1, 1);
        RELATION_TAG_EXTERNAL = r101;
        ResponseTagTypeEnum r102 = new ResponseTagTypeEnum("RELATION_TAG_PARTNER", 2, 2);
        RELATION_TAG_PARTNER = r102;
        ResponseTagTypeEnum r103 = new ResponseTagTypeEnum("RELATION_TAG_TENANT_NAME", 3, 3);
        RELATION_TAG_TENANT_NAME = r103;
        $VALUES = new ResponseTagTypeEnum[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResponseTagTypeEnum.class);
    }

    public static ResponseTagTypeEnum[] values() {
        return (ResponseTagTypeEnum[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ResponseTagTypeEnum fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return RELATION_TAG_TENANT_NAME;
    L14:
        return RELATION_TAG_PARTNER;
    L16:
        return RELATION_TAG_EXTERNAL;
    L18:
        return RELATION_TAG_UNSET;
    }

    public static ResponseTagTypeEnum valueOf(String r100) {
        return (ResponseTagTypeEnum) a.a(ResponseTagTypeEnum.class, r100);
    }

    private ResponseTagTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
