package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum PaymentType extends Enum<PaymentType> implements WireEnum {
    private static final /* synthetic */ PaymentType[] $VALUES = null;
    public static final ProtoAdapter<PaymentType> ADAPTER = null;
    public static final PaymentType Free = null;
    public static final PaymentType Paid = null;
    public static final PaymentType Redemption = null;
    private final int value;

    static {
        PaymentType r100 = new PaymentType("Free", 0, 0);
        Free = r100;
        PaymentType r101 = new PaymentType("Redemption", 1, 1);
        Redemption = r101;
        PaymentType r102 = new PaymentType("Paid", 2, 2);
        Paid = r102;
        $VALUES = new PaymentType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(PaymentType.class);
    }

    public static PaymentType[] values() {
        return (PaymentType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PaymentType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return Paid;
    L12:
        return Redemption;
    L14:
        return Free;
    }

    public static PaymentType valueOf(String r100) {
        return (PaymentType) a.a(PaymentType.class, r100);
    }

    private PaymentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
