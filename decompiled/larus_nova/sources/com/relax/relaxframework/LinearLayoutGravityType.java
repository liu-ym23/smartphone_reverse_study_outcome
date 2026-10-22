package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/LinearLayoutGravityType;", "", "", "value", "I", "getValue", "()I", "None", "Top", "Bottom", "Left", "Right", "CenterVertical", "CenterHorizontal", "FillVertical", "FillHorizontal", "Center", "Stretch", "Start", "End", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearLayoutGravityType extends Enum<LinearLayoutGravityType> {
    public static final LinearLayoutGravityType Bottom = null;
    public static final LinearLayoutGravityType Center = null;
    public static final LinearLayoutGravityType CenterHorizontal = null;
    public static final LinearLayoutGravityType CenterVertical = null;
    public static final LinearLayoutGravityType End = null;
    public static final LinearLayoutGravityType FillHorizontal = null;
    public static final LinearLayoutGravityType FillVertical = null;
    public static final LinearLayoutGravityType Left = null;
    public static final LinearLayoutGravityType None = null;
    public static final LinearLayoutGravityType Right = null;
    public static final LinearLayoutGravityType Start = null;
    public static final LinearLayoutGravityType Stretch = null;
    public static final LinearLayoutGravityType Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearLayoutGravityType[] f404764a = null;
    private final int value;

    public static LinearLayoutGravityType valueOf(String r100) {
        return (LinearLayoutGravityType) r27.a.a(LinearLayoutGravityType.class, r100);
    }

    public static LinearLayoutGravityType[] values() {
        return (LinearLayoutGravityType[]) f404764a.clone();
    }

    static {
        LinearLayoutGravityType r100 = new LinearLayoutGravityType("None", 0, 0);
        None = r100;
        LinearLayoutGravityType r101 = new LinearLayoutGravityType("Top", 1, 1);
        Top = r101;
        LinearLayoutGravityType r102 = new LinearLayoutGravityType("Bottom", 2, 2);
        Bottom = r102;
        LinearLayoutGravityType r103 = new LinearLayoutGravityType("Left", 3, 3);
        Left = r103;
        LinearLayoutGravityType r104 = new LinearLayoutGravityType("Right", 4, 4);
        Right = r104;
        LinearLayoutGravityType r105 = new LinearLayoutGravityType("CenterVertical", 5, 5);
        CenterVertical = r105;
        LinearLayoutGravityType r110 = new LinearLayoutGravityType("CenterHorizontal", 6, 6);
        CenterHorizontal = r110;
        LinearLayoutGravityType r111 = new LinearLayoutGravityType("FillVertical", 7, 7);
        FillVertical = r111;
        LinearLayoutGravityType r112 = new LinearLayoutGravityType("FillHorizontal", 8, 8);
        FillHorizontal = r112;
        LinearLayoutGravityType r113 = new LinearLayoutGravityType("Center", 9, 9);
        Center = r113;
        LinearLayoutGravityType r114 = new LinearLayoutGravityType("Stretch", 10, 10);
        Stretch = r114;
        LinearLayoutGravityType r115 = new LinearLayoutGravityType("Start", 11, 11);
        Start = r115;
        LinearLayoutGravityType r106 = new LinearLayoutGravityType("End", 12, 12);
        End = r106;
        f404764a = new LinearLayoutGravityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearLayoutGravityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
