package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/BorderStyleType;", "", "", "value", "I", "getValue", "()I", "Solid", "Dashed", "Dotted", "Double", "Groove", "Ridge", "Inset", "Outset", "Hide", "None", "Undefined", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BorderStyleType extends Enum<BorderStyleType> {
    public static final BorderStyleType Dashed = null;
    public static final BorderStyleType Dotted = null;
    public static final BorderStyleType Double = null;
    public static final BorderStyleType Groove = null;
    public static final BorderStyleType Hide = null;
    public static final BorderStyleType Inset = null;
    public static final BorderStyleType None = null;
    public static final BorderStyleType Outset = null;
    public static final BorderStyleType Ridge = null;
    public static final BorderStyleType Solid = null;
    public static final BorderStyleType Undefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BorderStyleType[] f404687a = null;
    private final int value;

    public static BorderStyleType valueOf(String r100) {
        return (BorderStyleType) r27.a.a(BorderStyleType.class, r100);
    }

    public static BorderStyleType[] values() {
        return (BorderStyleType[]) f404687a.clone();
    }

    static {
        BorderStyleType r100 = new BorderStyleType("Solid", 0, 0);
        Solid = r100;
        BorderStyleType r101 = new BorderStyleType("Dashed", 1, 1);
        Dashed = r101;
        BorderStyleType r102 = new BorderStyleType("Dotted", 2, 2);
        Dotted = r102;
        BorderStyleType r103 = new BorderStyleType("Double", 3, 3);
        Double = r103;
        BorderStyleType r104 = new BorderStyleType("Groove", 4, 4);
        Groove = r104;
        BorderStyleType r105 = new BorderStyleType("Ridge", 5, 5);
        Ridge = r105;
        BorderStyleType r110 = new BorderStyleType("Inset", 6, 6);
        Inset = r110;
        BorderStyleType r111 = new BorderStyleType("Outset", 7, 7);
        Outset = r111;
        BorderStyleType r112 = new BorderStyleType("Hide", 8, 8);
        Hide = r112;
        BorderStyleType r113 = new BorderStyleType("None", 9, 9);
        None = r113;
        BorderStyleType r114 = new BorderStyleType("Undefined", 10, Integer.MAX_VALUE);
        Undefined = r114;
        f404687a = new BorderStyleType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public BorderStyleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
