package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Constraint$Behaviour extends Enum<Constraint$Behaviour> {
    public static final Constraint$Behaviour PERCENT = null;
    public static final Constraint$Behaviour RATIO = null;
    public static final Constraint$Behaviour RESOLVED = null;
    public static final Constraint$Behaviour SPREAD = null;
    public static final Constraint$Behaviour WRAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$Behaviour[] f399658a = null;

    static {
        Constraint$Behaviour r100 = new Constraint$Behaviour("SPREAD", 0);
        SPREAD = r100;
        Constraint$Behaviour r101 = new Constraint$Behaviour("WRAP", 1);
        WRAP = r101;
        Constraint$Behaviour r102 = new Constraint$Behaviour("PERCENT", 2);
        PERCENT = r102;
        Constraint$Behaviour r103 = new Constraint$Behaviour("RATIO", 3);
        RATIO = r103;
        Constraint$Behaviour r104 = new Constraint$Behaviour("RESOLVED", 4);
        RESOLVED = r104;
        f399658a = new Constraint$Behaviour[]{r100, r101, r102, r103, r104};
    }

    public static Constraint$Behaviour[] values() {
        return (Constraint$Behaviour[]) f399658a.clone();
    }

    public static Constraint$Behaviour valueOf(String r100) {
        return (Constraint$Behaviour) a.a(Constraint$Behaviour.class, r100);
    }

    public Constraint$Behaviour(String r100, int r101) {
        super(r100, r101);
    }
}
