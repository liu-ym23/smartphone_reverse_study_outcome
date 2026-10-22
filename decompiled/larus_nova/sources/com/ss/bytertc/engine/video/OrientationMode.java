package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum OrientationMode extends Enum<OrientationMode> {
    private static final /* synthetic */ OrientationMode[] $VALUES = null;

    static {
        $VALUES = new OrientationMode[0];
    }

    public static OrientationMode[] values() {
        return (OrientationMode[]) $VALUES.clone();
    }

    public static OrientationMode valueOf(String r100) {
        return (OrientationMode) a.a(OrientationMode.class, r100);
    }

    private OrientationMode(String r100, int r101) {
        super(r100, r101);
    }
}
