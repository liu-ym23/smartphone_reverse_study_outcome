package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyPosition$Type extends Enum<KeyPosition$Type> {
    public static final KeyPosition$Type CARTESIAN = null;
    public static final KeyPosition$Type PATH = null;
    public static final KeyPosition$Type SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyPosition$Type[] f399670a = null;

    static {
        KeyPosition$Type r100 = new KeyPosition$Type("CARTESIAN", 0);
        CARTESIAN = r100;
        KeyPosition$Type r101 = new KeyPosition$Type("SCREEN", 1);
        SCREEN = r101;
        KeyPosition$Type r102 = new KeyPosition$Type("PATH", 2);
        PATH = r102;
        f399670a = new KeyPosition$Type[]{r100, r101, r102};
    }

    public static KeyPosition$Type[] values() {
        return (KeyPosition$Type[]) f399670a.clone();
    }

    public static KeyPosition$Type valueOf(String r100) {
        return (KeyPosition$Type) a.a(KeyPosition$Type.class, r100);
    }

    public KeyPosition$Type(String r100, int r101) {
        super(r100, r101);
    }
}
