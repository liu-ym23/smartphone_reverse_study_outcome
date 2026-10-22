package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxBooleanOption extends Enum<LynxBooleanOption> {
    public static final LynxBooleanOption FALSE = null;
    public static final LynxBooleanOption TRUE = null;
    public static final LynxBooleanOption UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxBooleanOption[] f381646a = null;

    static {
        LynxBooleanOption r100 = new LynxBooleanOption("UNSET", 0);
        UNSET = r100;
        LynxBooleanOption r101 = new LynxBooleanOption("TRUE", 1);
        TRUE = r101;
        LynxBooleanOption r102 = new LynxBooleanOption("FALSE", 2);
        FALSE = r102;
        f381646a = new LynxBooleanOption[]{r100, r101, r102};
    }

    public static LynxBooleanOption[] values() {
        return (LynxBooleanOption[]) f381646a.clone();
    }

    public static LynxBooleanOption valueOf(String r100) {
        return (LynxBooleanOption) r27.a.a(LynxBooleanOption.class, r100);
    }

    public LynxBooleanOption(String r100, int r101) {
        super(r100, r101);
    }
}
