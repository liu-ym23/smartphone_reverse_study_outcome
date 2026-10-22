package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum RequestTagTypeEnum extends Enum<RequestTagTypeEnum> implements WireEnum {
    private static final /* synthetic */ RequestTagTypeEnum[] $VALUES = null;
    public static final ProtoAdapter<RequestTagTypeEnum> ADAPTER = null;
    public static final RequestTagTypeEnum RELATION_TAG = null;
    public static final RequestTagTypeEnum TENANT_TAG = null;
    public static final RequestTagTypeEnum UNKNOWN_TAG_TYPE = null;
    private final int value;

    static {
        RequestTagTypeEnum r100 = new RequestTagTypeEnum("UNKNOWN_TAG_TYPE", 0, 0);
        UNKNOWN_TAG_TYPE = r100;
        RequestTagTypeEnum r101 = new RequestTagTypeEnum("RELATION_TAG", 1, 1);
        RELATION_TAG = r101;
        RequestTagTypeEnum r102 = new RequestTagTypeEnum("TENANT_TAG", 2, 2);
        TENANT_TAG = r102;
        $VALUES = new RequestTagTypeEnum[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(RequestTagTypeEnum.class);
    }

    public static RequestTagTypeEnum[] values() {
        return (RequestTagTypeEnum[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RequestTagTypeEnum fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return TENANT_TAG;
    L12:
        return RELATION_TAG;
    L14:
        return UNKNOWN_TAG_TYPE;
    }

    public static RequestTagTypeEnum valueOf(String r100) {
        return (RequestTagTypeEnum) a.a(RequestTagTypeEnum.class, r100);
    }

    private RequestTagTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
