package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/relax/relaxframework/VerticalAlignType;", "", "", "value", "I", "getValue", "()I", "Default", "Baseline", "Sub", "Super", "Top", "TextTop", "Middle", "Bottom", "TextBottom", "Length", "Percent", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum VerticalAlignType extends Enum<VerticalAlignType> {
    public static final VerticalAlignType Baseline = null;
    public static final VerticalAlignType Bottom = null;
    public static final VerticalAlignType Center = null;
    public static final VerticalAlignType Default = null;
    public static final VerticalAlignType Length = null;
    public static final VerticalAlignType Middle = null;
    public static final VerticalAlignType Percent = null;
    public static final VerticalAlignType Sub = null;
    public static final VerticalAlignType Super = null;
    public static final VerticalAlignType TextBottom = null;
    public static final VerticalAlignType TextTop = null;
    public static final VerticalAlignType Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VerticalAlignType[] f404982a = null;
    private final int value;

    public static VerticalAlignType valueOf(String r100) {
        return (VerticalAlignType) r27.a.a(VerticalAlignType.class, r100);
    }

    public static VerticalAlignType[] values() {
        return (VerticalAlignType[]) f404982a.clone();
    }

    static {
        VerticalAlignType r100 = new VerticalAlignType("Default", 0, 0);
        Default = r100;
        VerticalAlignType r101 = new VerticalAlignType("Baseline", 1, 1);
        Baseline = r101;
        VerticalAlignType r102 = new VerticalAlignType("Sub", 2, 2);
        Sub = r102;
        VerticalAlignType r103 = new VerticalAlignType("Super", 3, 3);
        Super = r103;
        VerticalAlignType r104 = new VerticalAlignType("Top", 4, 4);
        Top = r104;
        VerticalAlignType r105 = new VerticalAlignType("TextTop", 5, 5);
        TextTop = r105;
        VerticalAlignType r110 = new VerticalAlignType("Middle", 6, 6);
        Middle = r110;
        VerticalAlignType r111 = new VerticalAlignType("Bottom", 7, 7);
        Bottom = r111;
        VerticalAlignType r112 = new VerticalAlignType("TextBottom", 8, 8);
        TextBottom = r112;
        VerticalAlignType r113 = new VerticalAlignType("Length", 9, 9);
        Length = r113;
        VerticalAlignType r114 = new VerticalAlignType("Percent", 10, 10);
        Percent = r114;
        VerticalAlignType r115 = new VerticalAlignType("Center", 11, 11);
        Center = r115;
        f404982a = new VerticalAlignType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public final int getValue() {
        return this.value;
    }

    public VerticalAlignType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
