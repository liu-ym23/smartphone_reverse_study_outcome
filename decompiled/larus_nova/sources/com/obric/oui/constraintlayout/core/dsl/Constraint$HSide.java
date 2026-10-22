package com.obric.oui.constraintlayout.core.dsl;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Constraint$HSide extends Enum<Constraint$HSide> {
    public static final Constraint$HSide END = null;
    public static final Constraint$HSide LEFT = null;
    public static final Constraint$HSide RIGHT = null;
    public static final Constraint$HSide START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$HSide[] f399660a = null;

    static {
        Constraint$HSide r100 = new Constraint$HSide("LEFT", 0);
        LEFT = r100;
        Constraint$HSide r101 = new Constraint$HSide("RIGHT", 1);
        RIGHT = r101;
        Constraint$HSide r102 = new Constraint$HSide(GXAnimation.STATE_START, 2);
        START = r102;
        Constraint$HSide r103 = new Constraint$HSide(GXAnimation.STATE_END, 3);
        END = r103;
        f399660a = new Constraint$HSide[]{r100, r101, r102, r103};
    }

    public static Constraint$HSide[] values() {
        return (Constraint$HSide[]) f399660a.clone();
    }

    public static Constraint$HSide valueOf(String r100) {
        return (Constraint$HSide) a.a(Constraint$HSide.class, r100);
    }

    public Constraint$HSide(String r100, int r101) {
        super(r100, r101);
    }
}
