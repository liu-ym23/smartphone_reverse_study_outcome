package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxLoadOption extends Enum<LynxLoadOption> {
    public static final LynxLoadOption DUMP_ELEMENT = null;
    public static final LynxLoadOption PROCESS_LAYOUT_WITHOUT_UI_FLUSH = null;
    public static final LynxLoadOption RECYCLE_TEMPLATE_BUNDLE = null;
    public static final LynxLoadOption RENDER_FOR_RECREATE_ENGINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxLoadOption[] f381668a = null;
    private int mId;

    static {
        LynxLoadOption r100 = new LynxLoadOption("DUMP_ELEMENT", 0, 2);
        DUMP_ELEMENT = r100;
        LynxLoadOption r101 = new LynxLoadOption("RECYCLE_TEMPLATE_BUNDLE", 1, 4);
        RECYCLE_TEMPLATE_BUNDLE = r101;
        LynxLoadOption r102 = new LynxLoadOption("PROCESS_LAYOUT_WITHOUT_UI_FLUSH", 2, 8);
        PROCESS_LAYOUT_WITHOUT_UI_FLUSH = r102;
        LynxLoadOption r103 = new LynxLoadOption("RENDER_FOR_RECREATE_ENGINE", 3, 16);
        RENDER_FOR_RECREATE_ENGINE = r103;
        f381668a = new LynxLoadOption[]{r100, r101, r102, r103};
    }

    public static LynxLoadOption[] values() {
        return (LynxLoadOption[]) f381668a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static LynxLoadOption valueOf(String r100) {
        return (LynxLoadOption) r27.a.a(LynxLoadOption.class, r100);
    }

    public LynxLoadOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.mId = r102;
    }
}
