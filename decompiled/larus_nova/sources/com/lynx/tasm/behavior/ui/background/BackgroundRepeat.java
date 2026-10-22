package com.lynx.tasm.behavior.ui.background;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum BackgroundRepeat extends Enum<BackgroundRepeat> {
    public static final BackgroundRepeat NO_REPEAT = null;
    public static final BackgroundRepeat REPEAT = null;
    public static final BackgroundRepeat REPEAT_X = null;
    public static final BackgroundRepeat REPEAT_Y = null;
    public static final BackgroundRepeat ROUND = null;
    public static final BackgroundRepeat SPACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundRepeat[] f382471a = null;

    static {
        BackgroundRepeat r100 = new BackgroundRepeat("REPEAT", 0);
        REPEAT = r100;
        BackgroundRepeat r101 = new BackgroundRepeat("NO_REPEAT", 1);
        NO_REPEAT = r101;
        BackgroundRepeat r102 = new BackgroundRepeat("REPEAT_X", 2);
        REPEAT_X = r102;
        BackgroundRepeat r103 = new BackgroundRepeat("REPEAT_Y", 3);
        REPEAT_Y = r103;
        BackgroundRepeat r104 = new BackgroundRepeat("ROUND", 4);
        ROUND = r104;
        BackgroundRepeat r105 = new BackgroundRepeat("SPACE", 5);
        SPACE = r105;
        f382471a = new BackgroundRepeat[]{r100, r101, r102, r103, r104, r105};
    }

    public static BackgroundRepeat[] values() {
        return (BackgroundRepeat[]) f382471a.clone();
    }

    public static BackgroundRepeat valueOf(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return REPEAT;
    L16:
        return SPACE;
    L18:
        return ROUND;
    L20:
        return REPEAT_Y;
    L22:
        return REPEAT_X;
    L24:
        return NO_REPEAT;
    L26:
        return REPEAT;
    }

    public static BackgroundRepeat valueOf(String r100) {
        return (BackgroundRepeat) a.a(BackgroundRepeat.class, r100);
    }

    public BackgroundRepeat(String r100, int r101) {
        super(r100, r101);
    }
}
