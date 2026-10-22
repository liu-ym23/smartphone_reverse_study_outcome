package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum RequestTagTypeEnum extends Enum<RequestTagTypeEnum> implements WireEnum {
    private static final /* synthetic */ RequestTagTypeEnum[] $VALUES = null;
    public static final ProtoAdapter<RequestTagTypeEnum> ADAPTER = null;
    public static final RequestTagTypeEnum RELATION_TAG = null;
    public static final RequestTagTypeEnum UNKNOWN_TAG_TYPE = null;
    private final int value;

    static {
        RequestTagTypeEnum r100 = new RequestTagTypeEnum("UNKNOWN_TAG_TYPE", 0, 0);
        UNKNOWN_TAG_TYPE = r100;
        RequestTagTypeEnum r101 = new RequestTagTypeEnum("RELATION_TAG", 1, 1);
        RELATION_TAG = r101;
        $VALUES = new RequestTagTypeEnum[]{r100, r101};
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
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return RELATION_TAG;
    L10:
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
