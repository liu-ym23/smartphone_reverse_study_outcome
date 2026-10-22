package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/PositionModifierProperty;", "", "", "value", "I", "getValue", "()I", "Position", "Top", "Left", "Right", "Bottom", "ZIndex", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PositionModifierProperty extends Enum<PositionModifierProperty> {
    public static final PositionModifierProperty Bottom = null;
    public static final PositionModifierProperty Left = null;
    public static final PositionModifierProperty Position = null;
    public static final PositionModifierProperty Right = null;
    public static final PositionModifierProperty Top = null;
    public static final PositionModifierProperty ZIndex = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PositionModifierProperty[] f404844a = null;
    private final int value;

    public static PositionModifierProperty valueOf(String r100) {
        return (PositionModifierProperty) r27.a.a(PositionModifierProperty.class, r100);
    }

    public static PositionModifierProperty[] values() {
        return (PositionModifierProperty[]) f404844a.clone();
    }

    static {
        PositionModifierProperty r100 = new PositionModifierProperty("Position", 0, 198);
        Position = r100;
        PositionModifierProperty r101 = new PositionModifierProperty("Top", 1, 187);
        Top = r101;
        PositionModifierProperty r102 = new PositionModifierProperty("Left", 2, 188);
        Left = r102;
        PositionModifierProperty r103 = new PositionModifierProperty("Right", 3, 189);
        Right = r103;
        PositionModifierProperty r104 = new PositionModifierProperty("Bottom", 4, 190);
        Bottom = r104;
        PositionModifierProperty r105 = new PositionModifierProperty("ZIndex", 5, 191);
        ZIndex = r105;
        f404844a = new PositionModifierProperty[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public PositionModifierProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
