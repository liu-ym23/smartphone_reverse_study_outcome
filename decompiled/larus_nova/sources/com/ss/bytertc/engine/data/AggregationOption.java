package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AggregationOption extends Enum<AggregationOption> {
    private static final /* synthetic */ AggregationOption[] $VALUES = null;
    public static final AggregationOption MAJORITY = null;
    public static final AggregationOption MAX = null;
    public static final AggregationOption MIN = null;
    private int value;

    static {
        AggregationOption r100 = new AggregationOption("MIN", 0, 0);
        MIN = r100;
        AggregationOption r101 = new AggregationOption("MAX", 1, 1);
        MAX = r101;
        AggregationOption r102 = new AggregationOption("MAJORITY", 2, 2);
        MAJORITY = r102;
        $VALUES = new AggregationOption[]{r100, r101, r102};
    }

    public static AggregationOption[] values() {
        return (AggregationOption[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != MIN) goto L6;
        return "AggregationOptionMin";
    L6:
        if (this != MAX) goto L10;
        return "AggregationOptionMax";
    L10:
        if (this != MAJORITY) goto L13;
        return "AggregationOptionMajority";
    L13:
        return "AggregationOptionMin";
    }

    public int value() {
        return this.value;
    }

    public static AggregationOption valueOf(String r100) {
        return (AggregationOption) a.a(AggregationOption.class, r100);
    }

    private AggregationOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
