package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/PositionOffset_Type___;", "", "", "value", "I", "getValue", "()I", "TopLeft", "TopRight", "BottomLeft", "BottomRight", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PositionOffset_Type___ extends Enum<PositionOffset_Type___> {
    public static final PositionOffset_Type___ BottomLeft = null;
    public static final PositionOffset_Type___ BottomRight = null;
    public static final PositionOffset_Type___ TopLeft = null;
    public static final PositionOffset_Type___ TopRight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PositionOffset_Type___[] f404847a = null;
    private final int value;

    public static PositionOffset_Type___ valueOf(String r100) {
        return (PositionOffset_Type___) r27.a.a(PositionOffset_Type___.class, r100);
    }

    public static PositionOffset_Type___[] values() {
        return (PositionOffset_Type___[]) f404847a.clone();
    }

    static {
        PositionOffset_Type___ r100 = new PositionOffset_Type___("TopLeft", 0, 0);
        TopLeft = r100;
        PositionOffset_Type___ r101 = new PositionOffset_Type___("TopRight", 1, 1);
        TopRight = r101;
        PositionOffset_Type___ r102 = new PositionOffset_Type___("BottomLeft", 2, 2);
        BottomLeft = r102;
        PositionOffset_Type___ r103 = new PositionOffset_Type___("BottomRight", 3, 3);
        BottomRight = r103;
        f404847a = new PositionOffset_Type___[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public PositionOffset_Type___(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
