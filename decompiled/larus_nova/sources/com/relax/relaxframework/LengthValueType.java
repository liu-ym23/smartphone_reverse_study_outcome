package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/LengthValueType;", "", "", "value", "I", "getValue", "()I", "Auto", "Percentage", "Calc", "Rpx", "Px", "Rem", "Em", "Vw", "Vh", "Number", "PPx", "MaxContent", "FitContent", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LengthValueType extends Enum<LengthValueType> {
    public static final LengthValueType Auto = null;
    public static final LengthValueType Calc = null;
    public static final LengthValueType Em = null;
    public static final LengthValueType FitContent = null;
    public static final LengthValueType MaxContent = null;
    public static final LengthValueType Number = null;
    public static final LengthValueType PPx = null;
    public static final LengthValueType Percentage = null;
    public static final LengthValueType Px = null;
    public static final LengthValueType Rem = null;
    public static final LengthValueType Rpx = null;
    public static final LengthValueType Vh = null;
    public static final LengthValueType Vw = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LengthValueType[] f404757a = null;
    private final int value;

    public static LengthValueType valueOf(String r100) {
        return (LengthValueType) r27.a.a(LengthValueType.class, r100);
    }

    public static LengthValueType[] values() {
        return (LengthValueType[]) f404757a.clone();
    }

    static {
        LengthValueType r100 = new LengthValueType("Auto", 0, 0);
        Auto = r100;
        LengthValueType r101 = new LengthValueType("Percentage", 1, 1);
        Percentage = r101;
        LengthValueType r102 = new LengthValueType("Calc", 2, 2);
        Calc = r102;
        LengthValueType r103 = new LengthValueType("Rpx", 3, 3);
        Rpx = r103;
        LengthValueType r104 = new LengthValueType("Px", 4, 4);
        Px = r104;
        LengthValueType r105 = new LengthValueType("Rem", 5, 5);
        Rem = r105;
        LengthValueType r110 = new LengthValueType("Em", 6, 6);
        Em = r110;
        LengthValueType r111 = new LengthValueType("Vw", 7, 7);
        Vw = r111;
        LengthValueType r112 = new LengthValueType("Vh", 8, 8);
        Vh = r112;
        LengthValueType r113 = new LengthValueType("Number", 9, 9);
        Number = r113;
        LengthValueType r114 = new LengthValueType("PPx", 10, 10);
        PPx = r114;
        LengthValueType r115 = new LengthValueType("MaxContent", 11, 11);
        MaxContent = r115;
        LengthValueType r106 = new LengthValueType("FitContent", 12, 12);
        FitContent = r106;
        f404757a = new LengthValueType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public final int getValue() {
        return this.value;
    }

    public LengthValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
