package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/GridAutoFlow;", "", "", "value", "I", "getValue", "()I", "Row", "Column", "Dense", "RowDense", "ColumnDense", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum GridAutoFlow extends Enum<GridAutoFlow> {
    public static final GridAutoFlow Column = null;
    public static final GridAutoFlow ColumnDense = null;
    public static final GridAutoFlow Dense = null;
    public static final GridAutoFlow Row = null;
    public static final GridAutoFlow RowDense = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GridAutoFlow[] f404731a = null;
    private final int value;

    public static GridAutoFlow valueOf(String r100) {
        return (GridAutoFlow) r27.a.a(GridAutoFlow.class, r100);
    }

    public static GridAutoFlow[] values() {
        return (GridAutoFlow[]) f404731a.clone();
    }

    static {
        GridAutoFlow r100 = new GridAutoFlow("Row", 0, 0);
        Row = r100;
        GridAutoFlow r101 = new GridAutoFlow("Column", 1, 1);
        Column = r101;
        GridAutoFlow r102 = new GridAutoFlow("Dense", 2, 2);
        Dense = r102;
        GridAutoFlow r103 = new GridAutoFlow("RowDense", 3, 3);
        RowDense = r103;
        GridAutoFlow r104 = new GridAutoFlow("ColumnDense", 4, 4);
        ColumnDense = r104;
        f404731a = new GridAutoFlow[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public GridAutoFlow(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
