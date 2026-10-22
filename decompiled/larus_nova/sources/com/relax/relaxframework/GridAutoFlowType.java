package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/GridAutoFlowType;", "", "", "value", "I", "getValue", "()I", "Row", "Column", "Dense", "RowDense", "ColumnDense", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum GridAutoFlowType extends Enum<GridAutoFlowType> {
    public static final GridAutoFlowType Column = null;
    public static final GridAutoFlowType ColumnDense = null;
    public static final GridAutoFlowType Dense = null;
    public static final GridAutoFlowType Row = null;
    public static final GridAutoFlowType RowDense = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GridAutoFlowType[] f404732a = null;
    private final int value;

    public static GridAutoFlowType valueOf(String r100) {
        return (GridAutoFlowType) r27.a.a(GridAutoFlowType.class, r100);
    }

    public static GridAutoFlowType[] values() {
        return (GridAutoFlowType[]) f404732a.clone();
    }

    static {
        GridAutoFlowType r100 = new GridAutoFlowType("Row", 0, 0);
        Row = r100;
        GridAutoFlowType r101 = new GridAutoFlowType("Column", 1, 1);
        Column = r101;
        GridAutoFlowType r102 = new GridAutoFlowType("Dense", 2, 2);
        Dense = r102;
        GridAutoFlowType r103 = new GridAutoFlowType("RowDense", 3, 3);
        RowDense = r103;
        GridAutoFlowType r104 = new GridAutoFlowType("ColumnDense", 4, 4);
        ColumnDense = r104;
        f404732a = new GridAutoFlowType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public GridAutoFlowType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
