package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/FlexDirection;", "", "", "value", "I", "getValue", "()I", "Column", "Row", "RowReverse", "ColumnReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FlexDirection extends Enum<FlexDirection> {
    public static final FlexDirection Column = null;
    public static final FlexDirection ColumnReverse = null;
    public static final FlexDirection Row = null;
    public static final FlexDirection RowReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexDirection[] f404721a = null;
    private final int value;

    public static FlexDirection valueOf(String r100) {
        return (FlexDirection) r27.a.a(FlexDirection.class, r100);
    }

    public static FlexDirection[] values() {
        return (FlexDirection[]) f404721a.clone();
    }

    static {
        FlexDirection r100 = new FlexDirection("Column", 0, 0);
        Column = r100;
        FlexDirection r101 = new FlexDirection("Row", 1, 1);
        Row = r101;
        FlexDirection r102 = new FlexDirection("RowReverse", 2, 2);
        RowReverse = r102;
        FlexDirection r103 = new FlexDirection("ColumnReverse", 3, 3);
        ColumnReverse = r103;
        f404721a = new FlexDirection[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public FlexDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
