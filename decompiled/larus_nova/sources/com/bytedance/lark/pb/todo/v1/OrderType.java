package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum OrderType extends Enum<OrderType> implements WireEnum {
    private static final /* synthetic */ OrderType[] $VALUES = null;
    public static final ProtoAdapter<OrderType> ADAPTER = null;
    public static final OrderType ASC = null;
    public static final OrderType DESC = null;
    private final int value;

    static {
        OrderType r100 = new OrderType("ASC", 0, 0);
        ASC = r100;
        OrderType r101 = new OrderType("DESC", 1, 1);
        DESC = r101;
        $VALUES = new OrderType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(OrderType.class);
    }

    public static OrderType[] values() {
        return (OrderType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static OrderType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return DESC;
    L10:
        return ASC;
    }

    public static OrderType valueOf(String r100) {
        return (OrderType) a.a(OrderType.class, r100);
    }

    private OrderType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
