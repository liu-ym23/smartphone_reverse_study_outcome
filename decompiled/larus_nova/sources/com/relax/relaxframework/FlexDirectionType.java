package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/FlexDirectionType;", "", "", "value", "I", "getValue", "()I", "Column", "Row", "RowReverse", "ColumnReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FlexDirectionType extends Enum<FlexDirectionType> {
    public static final FlexDirectionType Column = null;
    public static final FlexDirectionType ColumnReverse = null;
    public static final FlexDirectionType Row = null;
    public static final FlexDirectionType RowReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexDirectionType[] f404722a = null;
    private final int value;

    public static FlexDirectionType valueOf(String r100) {
        return (FlexDirectionType) r27.a.a(FlexDirectionType.class, r100);
    }

    public static FlexDirectionType[] values() {
        return (FlexDirectionType[]) f404722a.clone();
    }

    static {
        FlexDirectionType r100 = new FlexDirectionType("Column", 0, 0);
        Column = r100;
        FlexDirectionType r101 = new FlexDirectionType("Row", 1, 1);
        Row = r101;
        FlexDirectionType r102 = new FlexDirectionType("RowReverse", 2, 2);
        RowReverse = r102;
        FlexDirectionType r103 = new FlexDirectionType("ColumnReverse", 3, 3);
        ColumnReverse = r103;
        f404722a = new FlexDirectionType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public FlexDirectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
