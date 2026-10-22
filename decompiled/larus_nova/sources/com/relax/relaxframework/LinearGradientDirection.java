package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/relax/relaxframework/LinearGradientDirection;", "", "", "value", "I", "getValue", "()I", "None", "Top", "Bottom", "Left", "Right", "TopRight", "TopLeft", "BottomRight", "BottomLeft", "Angle", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearGradientDirection extends Enum<LinearGradientDirection> {
    public static final LinearGradientDirection Angle = null;
    public static final LinearGradientDirection Bottom = null;
    public static final LinearGradientDirection BottomLeft = null;
    public static final LinearGradientDirection BottomRight = null;
    public static final LinearGradientDirection Left = null;
    public static final LinearGradientDirection None = null;
    public static final LinearGradientDirection Right = null;
    public static final LinearGradientDirection Top = null;
    public static final LinearGradientDirection TopLeft = null;
    public static final LinearGradientDirection TopRight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearGradientDirection[] f404761a = null;
    private final int value;

    public static LinearGradientDirection valueOf(String r100) {
        return (LinearGradientDirection) r27.a.a(LinearGradientDirection.class, r100);
    }

    public static LinearGradientDirection[] values() {
        return (LinearGradientDirection[]) f404761a.clone();
    }

    static {
        LinearGradientDirection r100 = new LinearGradientDirection("None", 0, 0);
        None = r100;
        LinearGradientDirection r101 = new LinearGradientDirection("Top", 1, 1);
        Top = r101;
        LinearGradientDirection r102 = new LinearGradientDirection("Bottom", 2, 2);
        Bottom = r102;
        LinearGradientDirection r103 = new LinearGradientDirection("Left", 3, 3);
        Left = r103;
        LinearGradientDirection r104 = new LinearGradientDirection("Right", 4, 4);
        Right = r104;
        LinearGradientDirection r105 = new LinearGradientDirection("TopRight", 5, 5);
        TopRight = r105;
        LinearGradientDirection r110 = new LinearGradientDirection("TopLeft", 6, 6);
        TopLeft = r110;
        LinearGradientDirection r111 = new LinearGradientDirection("BottomRight", 7, 7);
        BottomRight = r111;
        LinearGradientDirection r112 = new LinearGradientDirection("BottomLeft", 8, 8);
        BottomLeft = r112;
        LinearGradientDirection r113 = new LinearGradientDirection("Angle", 9, 9);
        Angle = r113;
        f404761a = new LinearGradientDirection[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearGradientDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
