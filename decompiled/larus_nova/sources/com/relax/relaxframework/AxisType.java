package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/AxisType;", "", "", "value", "I", "getValue", "()I", "TopLeft", "TopRight", "BottomLeft", "BottomRight", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AxisType extends Enum<AxisType> {
    public static final AxisType BottomLeft = null;
    public static final AxisType BottomRight = null;
    public static final AxisType TopLeft = null;
    public static final AxisType TopRight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AxisType[] f404678a = null;
    private final int value;

    public static AxisType valueOf(String r100) {
        return (AxisType) r27.a.a(AxisType.class, r100);
    }

    public static AxisType[] values() {
        return (AxisType[]) f404678a.clone();
    }

    static {
        AxisType r100 = new AxisType("TopLeft", 0, 40027);
        TopLeft = r100;
        AxisType r101 = new AxisType("TopRight", 1, 40029);
        TopRight = r101;
        AxisType r102 = new AxisType("BottomLeft", 2, 40033);
        BottomLeft = r102;
        AxisType r103 = new AxisType("BottomRight", 3, 40035);
        BottomRight = r103;
        f404678a = new AxisType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public AxisType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
