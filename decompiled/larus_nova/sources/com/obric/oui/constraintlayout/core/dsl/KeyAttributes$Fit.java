package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyAttributes$Fit extends Enum<KeyAttributes$Fit> {
    public static final KeyAttributes$Fit LINEAR = null;
    public static final KeyAttributes$Fit SPLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttributes$Fit[] f399666a = null;

    static {
        KeyAttributes$Fit r100 = new KeyAttributes$Fit("SPLINE", 0);
        SPLINE = r100;
        KeyAttributes$Fit r101 = new KeyAttributes$Fit("LINEAR", 1);
        LINEAR = r101;
        f399666a = new KeyAttributes$Fit[]{r100, r101};
    }

    public static KeyAttributes$Fit[] values() {
        return (KeyAttributes$Fit[]) f399666a.clone();
    }

    public static KeyAttributes$Fit valueOf(String r100) {
        return (KeyAttributes$Fit) a.a(KeyAttributes$Fit.class, r100);
    }

    public KeyAttributes$Fit(String r100, int r101) {
        super(r100, r101);
    }
}
