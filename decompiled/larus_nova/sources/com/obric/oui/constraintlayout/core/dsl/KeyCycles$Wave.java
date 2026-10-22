package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyCycles$Wave extends Enum<KeyCycles$Wave> {
    public static final KeyCycles$Wave COS = null;
    public static final KeyCycles$Wave REVERSE_SAW = null;
    public static final KeyCycles$Wave SAW = null;
    public static final KeyCycles$Wave SIN = null;
    public static final KeyCycles$Wave SQUARE = null;
    public static final KeyCycles$Wave TRIANGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyCycles$Wave[] f399669a = null;

    static {
        KeyCycles$Wave r100 = new KeyCycles$Wave("SIN", 0);
        SIN = r100;
        KeyCycles$Wave r101 = new KeyCycles$Wave("SQUARE", 1);
        SQUARE = r101;
        KeyCycles$Wave r102 = new KeyCycles$Wave("TRIANGLE", 2);
        TRIANGLE = r102;
        KeyCycles$Wave r103 = new KeyCycles$Wave("SAW", 3);
        SAW = r103;
        KeyCycles$Wave r104 = new KeyCycles$Wave("REVERSE_SAW", 4);
        REVERSE_SAW = r104;
        KeyCycles$Wave r105 = new KeyCycles$Wave("COS", 5);
        COS = r105;
        f399669a = new KeyCycles$Wave[]{r100, r101, r102, r103, r104, r105};
    }

    public static KeyCycles$Wave[] values() {
        return (KeyCycles$Wave[]) f399669a.clone();
    }

    public static KeyCycles$Wave valueOf(String r100) {
        return (KeyCycles$Wave) a.a(KeyCycles$Wave.class, r100);
    }

    public KeyCycles$Wave(String r100, int r101) {
        super(r100, r101);
    }
}
