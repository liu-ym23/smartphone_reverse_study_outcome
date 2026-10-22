package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyAttribute$Fit extends Enum<KeyAttribute$Fit> {
    public static final KeyAttribute$Fit LINEAR = null;
    public static final KeyAttribute$Fit SPLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttribute$Fit[] f399664a = null;

    static {
        KeyAttribute$Fit r100 = new KeyAttribute$Fit("SPLINE", 0);
        SPLINE = r100;
        KeyAttribute$Fit r101 = new KeyAttribute$Fit("LINEAR", 1);
        LINEAR = r101;
        f399664a = new KeyAttribute$Fit[]{r100, r101};
    }

    public static KeyAttribute$Fit[] values() {
        return (KeyAttribute$Fit[]) f399664a.clone();
    }

    public static KeyAttribute$Fit valueOf(String r100) {
        return (KeyAttribute$Fit) a.a(KeyAttribute$Fit.class, r100);
    }

    public KeyAttribute$Fit(String r100, int r101) {
        super(r100, r101);
    }
}
