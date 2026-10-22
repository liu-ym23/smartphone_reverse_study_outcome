package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxColorScheme extends Enum<LynxColorScheme> {
    public static final LynxColorScheme DARK = null;
    public static final LynxColorScheme LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxColorScheme[] f381647a = null;
    private final int mId;

    static {
        LynxColorScheme r100 = new LynxColorScheme("LIGHT", 0, 0);
        LIGHT = r100;
        LynxColorScheme r101 = new LynxColorScheme("DARK", 1, 1);
        DARK = r101;
        f381647a = new LynxColorScheme[]{r100, r101};
    }

    public static LynxColorScheme[] values() {
        return (LynxColorScheme[]) f381647a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static LynxColorScheme valueOf(String r100) {
        return (LynxColorScheme) r27.a.a(LynxColorScheme.class, r100);
    }

    public LynxColorScheme(String r100, int r101, int r102) {
        super(r100, r101);
        this.mId = r102;
    }
}
