package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FilterPaymentType extends Enum<FilterPaymentType> implements WireEnum {
    private static final /* synthetic */ FilterPaymentType[] $VALUES = null;
    public static final ProtoAdapter<FilterPaymentType> ADAPTER = null;
    public static final FilterPaymentType FREE = null;
    public static final FilterPaymentType PAID = null;
    private final int value;

    static {
        FilterPaymentType r100 = new FilterPaymentType("FREE", 0, 1);
        FREE = r100;
        FilterPaymentType r101 = new FilterPaymentType("PAID", 1, 2);
        PAID = r101;
        $VALUES = new FilterPaymentType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterPaymentType.class);
    }

    public static FilterPaymentType[] values() {
        return (FilterPaymentType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FilterPaymentType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return PAID;
    L11:
        return FREE;
    }

    public static FilterPaymentType valueOf(String r100) {
        return (FilterPaymentType) a.a(FilterPaymentType.class, r100);
    }

    private FilterPaymentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
