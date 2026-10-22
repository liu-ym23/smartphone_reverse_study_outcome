package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SugTextType extends Enum<SugTextType> implements WireEnum {
    private static final /* synthetic */ SugTextType[] $VALUES = null;
    public static final ProtoAdapter<SugTextType> ADAPTER = null;
    public static final SugTextType SugFaqType = null;
    public static final SugTextType SugTextUnknownType = null;
    private final int value;

    static {
        SugTextType r100 = new SugTextType("SugTextUnknownType", 0, 0);
        SugTextUnknownType = r100;
        SugTextType r101 = new SugTextType("SugFaqType", 1, 1);
        SugFaqType = r101;
        $VALUES = new SugTextType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(SugTextType.class);
    }

    public static SugTextType[] values() {
        return (SugTextType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SugTextType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return SugFaqType;
    L10:
        return SugTextUnknownType;
    }

    public static SugTextType valueOf(String r100) {
        return (SugTextType) a.a(SugTextType.class, r100);
    }

    private SugTextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
