package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/LinearGravityType;", "", "", "value", "I", "getValue", "()I", "None", "Top", "Bottom", "Left", "Right", "CenterVertical", "CenterHorizontal", "SpaceBetween", "Start", "End", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearGravityType extends Enum<LinearGravityType> {
    public static final LinearGravityType Bottom = null;
    public static final LinearGravityType Center = null;
    public static final LinearGravityType CenterHorizontal = null;
    public static final LinearGravityType CenterVertical = null;
    public static final LinearGravityType End = null;
    public static final LinearGravityType Left = null;
    public static final LinearGravityType None = null;
    public static final LinearGravityType Right = null;
    public static final LinearGravityType SpaceBetween = null;
    public static final LinearGravityType Start = null;
    public static final LinearGravityType Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearGravityType[] f404763a = null;
    private final int value;

    public static LinearGravityType valueOf(String r100) {
        return (LinearGravityType) r27.a.a(LinearGravityType.class, r100);
    }

    public static LinearGravityType[] values() {
        return (LinearGravityType[]) f404763a.clone();
    }

    static {
        LinearGravityType r100 = new LinearGravityType("None", 0, 0);
        None = r100;
        LinearGravityType r101 = new LinearGravityType("Top", 1, 1);
        Top = r101;
        LinearGravityType r102 = new LinearGravityType("Bottom", 2, 2);
        Bottom = r102;
        LinearGravityType r103 = new LinearGravityType("Left", 3, 3);
        Left = r103;
        LinearGravityType r104 = new LinearGravityType("Right", 4, 4);
        Right = r104;
        LinearGravityType r105 = new LinearGravityType("CenterVertical", 5, 5);
        CenterVertical = r105;
        LinearGravityType r110 = new LinearGravityType("CenterHorizontal", 6, 6);
        CenterHorizontal = r110;
        LinearGravityType r111 = new LinearGravityType("SpaceBetween", 7, 7);
        SpaceBetween = r111;
        LinearGravityType r112 = new LinearGravityType("Start", 8, 8);
        Start = r112;
        LinearGravityType r113 = new LinearGravityType("End", 9, 9);
        End = r113;
        LinearGravityType r114 = new LinearGravityType("Center", 10, 10);
        Center = r114;
        f404763a = new LinearGravityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearGravityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
