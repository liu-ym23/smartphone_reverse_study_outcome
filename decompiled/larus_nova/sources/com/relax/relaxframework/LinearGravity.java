package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/LinearGravity;", "", "", "value", "I", "getValue", "()I", "None", "Top", "Bottom", "Left", "Right", "CenterVertical", "CenterHorizontal", "SpaceBetween", "Start", "End", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LinearGravity extends Enum<LinearGravity> {
    public static final LinearGravity Bottom = null;
    public static final LinearGravity Center = null;
    public static final LinearGravity CenterHorizontal = null;
    public static final LinearGravity CenterVertical = null;
    public static final LinearGravity End = null;
    public static final LinearGravity Left = null;
    public static final LinearGravity None = null;
    public static final LinearGravity Right = null;
    public static final LinearGravity SpaceBetween = null;
    public static final LinearGravity Start = null;
    public static final LinearGravity Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearGravity[] f404762a = null;
    private final int value;

    public static LinearGravity valueOf(String r100) {
        return (LinearGravity) r27.a.a(LinearGravity.class, r100);
    }

    public static LinearGravity[] values() {
        return (LinearGravity[]) f404762a.clone();
    }

    static {
        LinearGravity r100 = new LinearGravity("None", 0, 0);
        None = r100;
        LinearGravity r101 = new LinearGravity("Top", 1, 1);
        Top = r101;
        LinearGravity r102 = new LinearGravity("Bottom", 2, 2);
        Bottom = r102;
        LinearGravity r103 = new LinearGravity("Left", 3, 3);
        Left = r103;
        LinearGravity r104 = new LinearGravity("Right", 4, 4);
        Right = r104;
        LinearGravity r105 = new LinearGravity("CenterVertical", 5, 5);
        CenterVertical = r105;
        LinearGravity r110 = new LinearGravity("CenterHorizontal", 6, 6);
        CenterHorizontal = r110;
        LinearGravity r111 = new LinearGravity("SpaceBetween", 7, 7);
        SpaceBetween = r111;
        LinearGravity r112 = new LinearGravity("Start", 8, 8);
        Start = r112;
        LinearGravity r113 = new LinearGravity("End", 9, 9);
        End = r113;
        LinearGravity r114 = new LinearGravity("Center", 10, 10);
        Center = r114;
        f404762a = new LinearGravity[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public LinearGravity(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
