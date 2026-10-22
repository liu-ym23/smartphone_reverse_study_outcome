package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/RadialGradientSizeType;", "", "", "value", "I", "getValue", "()I", "FarthestCorner", "FarthestSide", "ClosestCorner", "ClosestSide", "Length", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RadialGradientSizeType extends Enum<RadialGradientSizeType> {
    public static final RadialGradientSizeType ClosestCorner = null;
    public static final RadialGradientSizeType ClosestSide = null;
    public static final RadialGradientSizeType FarthestCorner = null;
    public static final RadialGradientSizeType FarthestSide = null;
    public static final RadialGradientSizeType Length = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RadialGradientSizeType[] f404852a = null;
    private final int value;

    public static RadialGradientSizeType valueOf(String r100) {
        return (RadialGradientSizeType) r27.a.a(RadialGradientSizeType.class, r100);
    }

    public static RadialGradientSizeType[] values() {
        return (RadialGradientSizeType[]) f404852a.clone();
    }

    static {
        RadialGradientSizeType r100 = new RadialGradientSizeType("FarthestCorner", 0, 0);
        FarthestCorner = r100;
        RadialGradientSizeType r101 = new RadialGradientSizeType("FarthestSide", 1, 1);
        FarthestSide = r101;
        RadialGradientSizeType r102 = new RadialGradientSizeType("ClosestCorner", 2, 2);
        ClosestCorner = r102;
        RadialGradientSizeType r103 = new RadialGradientSizeType("ClosestSide", 3, 3);
        ClosestSide = r103;
        RadialGradientSizeType r104 = new RadialGradientSizeType("Length", 4, 4);
        Length = r104;
        f404852a = new RadialGradientSizeType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public RadialGradientSizeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
