package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/BackgroundPositionType;", "", "", "value", "I", "getValue", "()I", "Top", "Right", "Bottom", "Left", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BackgroundPositionType extends Enum<BackgroundPositionType> {
    public static final BackgroundPositionType Bottom = null;
    public static final BackgroundPositionType Center = null;
    public static final BackgroundPositionType Left = null;
    public static final BackgroundPositionType Right = null;
    public static final BackgroundPositionType Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundPositionType[] f404683a = null;
    private final int value;

    public static BackgroundPositionType valueOf(String r100) {
        return (BackgroundPositionType) r27.a.a(BackgroundPositionType.class, r100);
    }

    public static BackgroundPositionType[] values() {
        return (BackgroundPositionType[]) f404683a.clone();
    }

    static {
        BackgroundPositionType r100 = new BackgroundPositionType("Top", 0, 32);
        Top = r100;
        BackgroundPositionType r101 = new BackgroundPositionType("Right", 1, 33);
        Right = r101;
        BackgroundPositionType r102 = new BackgroundPositionType("Bottom", 2, 34);
        Bottom = r102;
        BackgroundPositionType r103 = new BackgroundPositionType("Left", 3, 35);
        Left = r103;
        BackgroundPositionType r104 = new BackgroundPositionType("Center", 4, 36);
        Center = r104;
        f404683a = new BackgroundPositionType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public BackgroundPositionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
