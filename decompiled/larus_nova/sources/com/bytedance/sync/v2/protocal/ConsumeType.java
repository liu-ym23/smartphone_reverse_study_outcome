package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConsumeType extends Enum<ConsumeType> implements WireEnum {
    private static final /* synthetic */ ConsumeType[] $VALUES = null;
    public static final ProtoAdapter<ConsumeType> ADAPTER = null;
    public static final ConsumeType Increment = null;
    public static final ConsumeType OneByOne = null;
    private final int value;

    static {
        ConsumeType r100 = new ConsumeType("OneByOne", 0, 0);
        OneByOne = r100;
        ConsumeType r101 = new ConsumeType("Increment", 1, 1);
        Increment = r101;
        $VALUES = new ConsumeType[]{r100, r101};
        ADAPTER = new ProtoAdapter_ConsumeType();
    }

    public static ConsumeType[] values() {
        return (ConsumeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static ConsumeType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return Increment;
    L10:
        return OneByOne;
    }

    public static ConsumeType valueOf(String r100) {
        return (ConsumeType) r27.a.a(ConsumeType.class, r100);
    }

    private ConsumeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
