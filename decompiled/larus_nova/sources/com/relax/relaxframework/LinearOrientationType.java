package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/LinearOrientationType;", "", "", "value", "I", "getValue", "()I", "Horizontal", "Vertical", "HorizontalReverse", "VerticalReverse", "Row", "Column", "RowReverse", "ColumnReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearOrientationType extends Enum<LinearOrientationType> {
    public static final LinearOrientationType Column = null;
    public static final LinearOrientationType ColumnReverse = null;
    public static final LinearOrientationType Horizontal = null;
    public static final LinearOrientationType HorizontalReverse = null;
    public static final LinearOrientationType Row = null;
    public static final LinearOrientationType RowReverse = null;
    public static final LinearOrientationType Vertical = null;
    public static final LinearOrientationType VerticalReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearOrientationType[] f404767a = null;
    private final int value;

    public static LinearOrientationType valueOf(String r100) {
        return (LinearOrientationType) r27.a.a(LinearOrientationType.class, r100);
    }

    public static LinearOrientationType[] values() {
        return (LinearOrientationType[]) f404767a.clone();
    }

    static {
        LinearOrientationType r100 = new LinearOrientationType("Horizontal", 0, 0);
        Horizontal = r100;
        LinearOrientationType r101 = new LinearOrientationType("Vertical", 1, 1);
        Vertical = r101;
        LinearOrientationType r102 = new LinearOrientationType("HorizontalReverse", 2, 2);
        HorizontalReverse = r102;
        LinearOrientationType r103 = new LinearOrientationType("VerticalReverse", 3, 3);
        VerticalReverse = r103;
        LinearOrientationType r104 = new LinearOrientationType("Row", 4, 4);
        Row = r104;
        LinearOrientationType r105 = new LinearOrientationType("Column", 5, 5);
        Column = r105;
        LinearOrientationType r110 = new LinearOrientationType("RowReverse", 6, 6);
        RowReverse = r110;
        LinearOrientationType r111 = new LinearOrientationType("ColumnReverse", 7, 7);
        ColumnReverse = r111;
        f404767a = new LinearOrientationType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearOrientationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
