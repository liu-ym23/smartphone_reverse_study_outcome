package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Constraint$VSide extends Enum<Constraint$VSide> {
    public static final Constraint$VSide BASELINE = null;
    public static final Constraint$VSide BOTTOM = null;
    public static final Constraint$VSide TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$VSide[] f399662a = null;

    static {
        Constraint$VSide r100 = new Constraint$VSide("TOP", 0);
        TOP = r100;
        Constraint$VSide r101 = new Constraint$VSide("BOTTOM", 1);
        BOTTOM = r101;
        Constraint$VSide r102 = new Constraint$VSide("BASELINE", 2);
        BASELINE = r102;
        f399662a = new Constraint$VSide[]{r100, r101, r102};
    }

    public static Constraint$VSide[] values() {
        return (Constraint$VSide[]) f399662a.clone();
    }

    public static Constraint$VSide valueOf(String r100) {
        return (Constraint$VSide) a.a(Constraint$VSide.class, r100);
    }

    public Constraint$VSide(String r100, int r101) {
        super(r100, r101);
    }
}
