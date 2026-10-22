package com.ss.android.lark.pb.improto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum PayloadType extends Enum<PayloadType> implements WireEnum {
    private static final /* synthetic */ PayloadType[] $VALUES = null;
    public static final ProtoAdapter<PayloadType> ADAPTER = null;
    public static final PayloadType JSON = null;
    public static final PayloadType PB2 = null;
    public static final PayloadType TYPE_UNKNOWN = null;
    private final int value;

    static {
        PayloadType r100 = new PayloadType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        PayloadType r101 = new PayloadType("PB2", 1, 1);
        PB2 = r101;
        PayloadType r102 = new PayloadType("JSON", 2, 2);
        JSON = r102;
        $VALUES = new PayloadType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(PayloadType.class);
    }

    public static PayloadType[] values() {
        return (PayloadType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PayloadType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return JSON;
    L12:
        return PB2;
    L14:
        return TYPE_UNKNOWN;
    }

    public static PayloadType valueOf(String r100) {
        return (PayloadType) a.a(PayloadType.class, r100);
    }

    private PayloadType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
