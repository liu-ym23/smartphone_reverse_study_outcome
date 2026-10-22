package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/PlatformLengthUnit;", "", "", "value", "I", "getValue", "()I", "NUMBER", "PERCENTAGE", "CALC", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PlatformLengthUnit extends Enum<PlatformLengthUnit> {
    public static final PlatformLengthUnit CALC = null;
    public static final PlatformLengthUnit NUMBER = null;
    public static final PlatformLengthUnit PERCENTAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformLengthUnit[] f404843a = null;
    private final int value;

    public static PlatformLengthUnit valueOf(String r100) {
        return (PlatformLengthUnit) r27.a.a(PlatformLengthUnit.class, r100);
    }

    public static PlatformLengthUnit[] values() {
        return (PlatformLengthUnit[]) f404843a.clone();
    }

    static {
        PlatformLengthUnit r100 = new PlatformLengthUnit("NUMBER", 0, 0);
        NUMBER = r100;
        PlatformLengthUnit r101 = new PlatformLengthUnit("PERCENTAGE", 1, 1);
        PERCENTAGE = r101;
        PlatformLengthUnit r102 = new PlatformLengthUnit("CALC", 2, 2);
        CALC = r102;
        f404843a = new PlatformLengthUnit[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public PlatformLengthUnit(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
