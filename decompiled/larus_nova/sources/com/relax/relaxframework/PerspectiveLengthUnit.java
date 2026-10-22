package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/PerspectiveLengthUnit;", "", "", "value", "I", "getValue", "()I", "NUMBER", "VW", "VH", "DEFAULT", "PX", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PerspectiveLengthUnit extends Enum<PerspectiveLengthUnit> {
    public static final PerspectiveLengthUnit DEFAULT = null;
    public static final PerspectiveLengthUnit NUMBER = null;
    public static final PerspectiveLengthUnit PX = null;
    public static final PerspectiveLengthUnit VH = null;
    public static final PerspectiveLengthUnit VW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerspectiveLengthUnit[] f404841a = null;
    private final int value;

    public static PerspectiveLengthUnit valueOf(String r100) {
        return (PerspectiveLengthUnit) r27.a.a(PerspectiveLengthUnit.class, r100);
    }

    public static PerspectiveLengthUnit[] values() {
        return (PerspectiveLengthUnit[]) f404841a.clone();
    }

    static {
        PerspectiveLengthUnit r100 = new PerspectiveLengthUnit("NUMBER", 0, 0);
        NUMBER = r100;
        PerspectiveLengthUnit r101 = new PerspectiveLengthUnit("VW", 1, 1);
        VW = r101;
        PerspectiveLengthUnit r102 = new PerspectiveLengthUnit("VH", 2, 2);
        VH = r102;
        PerspectiveLengthUnit r103 = new PerspectiveLengthUnit("DEFAULT", 3, 3);
        DEFAULT = r103;
        PerspectiveLengthUnit r104 = new PerspectiveLengthUnit("PX", 4, 4);
        PX = r104;
        f404841a = new PerspectiveLengthUnit[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public PerspectiveLengthUnit(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
