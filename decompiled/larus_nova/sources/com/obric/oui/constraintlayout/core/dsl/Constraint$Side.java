package com.obric.oui.constraintlayout.core.dsl;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Constraint$Side extends Enum<Constraint$Side> {
    public static final Constraint$Side BASELINE = null;
    public static final Constraint$Side BOTTOM = null;
    public static final Constraint$Side END = null;
    public static final Constraint$Side LEFT = null;
    public static final Constraint$Side RIGHT = null;
    public static final Constraint$Side START = null;
    public static final Constraint$Side TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$Side[] f399661a = null;

    static {
        Constraint$Side r100 = new Constraint$Side("LEFT", 0);
        LEFT = r100;
        Constraint$Side r101 = new Constraint$Side("RIGHT", 1);
        RIGHT = r101;
        Constraint$Side r102 = new Constraint$Side("TOP", 2);
        TOP = r102;
        Constraint$Side r103 = new Constraint$Side("BOTTOM", 3);
        BOTTOM = r103;
        Constraint$Side r104 = new Constraint$Side(GXAnimation.STATE_START, 4);
        START = r104;
        Constraint$Side r105 = new Constraint$Side(GXAnimation.STATE_END, 5);
        END = r105;
        Constraint$Side r110 = new Constraint$Side("BASELINE", 6);
        BASELINE = r110;
        f399661a = new Constraint$Side[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static Constraint$Side[] values() {
        return (Constraint$Side[]) f399661a.clone();
    }

    public static Constraint$Side valueOf(String r100) {
        return (Constraint$Side) a.a(Constraint$Side.class, r100);
    }

    public Constraint$Side(String r100, int r101) {
        super(r100, r101);
    }
}
