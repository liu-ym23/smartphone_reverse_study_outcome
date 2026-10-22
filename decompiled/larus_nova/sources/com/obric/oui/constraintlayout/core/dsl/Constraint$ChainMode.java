package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Constraint$ChainMode extends Enum<Constraint$ChainMode> {
    public static final Constraint$ChainMode PACKED = null;
    public static final Constraint$ChainMode SPREAD = null;
    public static final Constraint$ChainMode SPREAD_INSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$ChainMode[] f399659a = null;

    static {
        Constraint$ChainMode r100 = new Constraint$ChainMode("SPREAD", 0);
        SPREAD = r100;
        Constraint$ChainMode r101 = new Constraint$ChainMode("SPREAD_INSIDE", 1);
        SPREAD_INSIDE = r101;
        Constraint$ChainMode r102 = new Constraint$ChainMode("PACKED", 2);
        PACKED = r102;
        f399659a = new Constraint$ChainMode[]{r100, r101, r102};
    }

    public static Constraint$ChainMode[] values() {
        return (Constraint$ChainMode[]) f399659a.clone();
    }

    public static Constraint$ChainMode valueOf(String r100) {
        return (Constraint$ChainMode) a.a(Constraint$ChainMode.class, r100);
    }

    public Constraint$ChainMode(String r100, int r101) {
        super(r100, r101);
    }
}
