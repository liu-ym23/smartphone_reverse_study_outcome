package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyPositions$Type extends Enum<KeyPositions$Type> {
    public static final KeyPositions$Type CARTESIAN = null;
    public static final KeyPositions$Type PATH = null;
    public static final KeyPositions$Type SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyPositions$Type[] f399671a = null;

    static {
        KeyPositions$Type r100 = new KeyPositions$Type("CARTESIAN", 0);
        CARTESIAN = r100;
        KeyPositions$Type r101 = new KeyPositions$Type("SCREEN", 1);
        SCREEN = r101;
        KeyPositions$Type r102 = new KeyPositions$Type("PATH", 2);
        PATH = r102;
        f399671a = new KeyPositions$Type[]{r100, r101, r102};
    }

    public static KeyPositions$Type[] values() {
        return (KeyPositions$Type[]) f399671a.clone();
    }

    public static KeyPositions$Type valueOf(String r100) {
        return (KeyPositions$Type) a.a(KeyPositions$Type.class, r100);
    }

    public KeyPositions$Type(String r100, int r101) {
        super(r100, r101);
    }
}
