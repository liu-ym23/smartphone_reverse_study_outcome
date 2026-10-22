package com.ss.android.lark.discretescrollview;

/* JADX INFO: loaded from: classes35.dex */
public abstract enum DSVScrollConfig extends Enum<DSVScrollConfig> {
    public static final DSVScrollConfig BACKWARD_ONLY = null;
    public static final DSVScrollConfig DISABLED = null;
    public static final DSVScrollConfig ENABLED = null;
    public static final DSVScrollConfig FORWARD_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DSVScrollConfig[] f420411a = null;

    public DSVScrollConfig() {
        throw null;
    }

    public abstract boolean isScrollBlocked(Direction r100);

    static {
        final String r100 = "ENABLED";
        final int r101 = 0;
        DSVScrollConfig r102 = new AnonymousClass1(r100, r101);
        ENABLED = r102;
        final String r103 = "FORWARD_ONLY";
        final int r104 = 1;
        DSVScrollConfig r105 = new AnonymousClass2(r103, r104);
        FORWARD_ONLY = r105;
        final String r106 = "BACKWARD_ONLY";
        final int r107 = 2;
        DSVScrollConfig r108 = new AnonymousClass3(r106, r107);
        BACKWARD_ONLY = r108;
        final String r109 = "DISABLED";
        final int r110 = 3;
        DSVScrollConfig r111 = new AnonymousClass4(r109, r110);
        DISABLED = r111;
        f420411a = new DSVScrollConfig[]{r102, r105, r108, r111};
    }

    public static DSVScrollConfig[] values() {
        return (DSVScrollConfig[]) f420411a.clone();
    }

    public static DSVScrollConfig valueOf(String r100) {
        return (DSVScrollConfig) r27.a.a(DSVScrollConfig.class, r100);
    }

    public DSVScrollConfig(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }
}
