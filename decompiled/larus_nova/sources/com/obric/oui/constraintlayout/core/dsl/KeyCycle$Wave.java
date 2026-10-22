package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyCycle$Wave extends Enum<KeyCycle$Wave> {
    public static final KeyCycle$Wave COS = null;
    public static final KeyCycle$Wave REVERSE_SAW = null;
    public static final KeyCycle$Wave SAW = null;
    public static final KeyCycle$Wave SIN = null;
    public static final KeyCycle$Wave SQUARE = null;
    public static final KeyCycle$Wave TRIANGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyCycle$Wave[] f399668a = null;

    static {
        KeyCycle$Wave r100 = new KeyCycle$Wave("SIN", 0);
        SIN = r100;
        KeyCycle$Wave r101 = new KeyCycle$Wave("SQUARE", 1);
        SQUARE = r101;
        KeyCycle$Wave r102 = new KeyCycle$Wave("TRIANGLE", 2);
        TRIANGLE = r102;
        KeyCycle$Wave r103 = new KeyCycle$Wave("SAW", 3);
        SAW = r103;
        KeyCycle$Wave r104 = new KeyCycle$Wave("REVERSE_SAW", 4);
        REVERSE_SAW = r104;
        KeyCycle$Wave r105 = new KeyCycle$Wave("COS", 5);
        COS = r105;
        f399668a = new KeyCycle$Wave[]{r100, r101, r102, r103, r104, r105};
    }

    public static KeyCycle$Wave[] values() {
        return (KeyCycle$Wave[]) f399668a.clone();
    }

    public static KeyCycle$Wave valueOf(String r100) {
        return (KeyCycle$Wave) a.a(KeyCycle$Wave.class, r100);
    }

    public KeyCycle$Wave(String r100, int r101) {
        super(r100, r101);
    }
}
