package com.ss.android.lark.biz.im.api;

/* JADX INFO: loaded from: classes34.dex */
public final enum ChatterNameDisplayRule extends Enum<ChatterNameDisplayRule> {
    public static final ChatterNameDisplayRule ALIAS_NAME = null;
    public static final ChatterNameDisplayRule ALIAS_NICKNAME_NAME = null;
    public static final ChatterNameDisplayRule NAME = null;
    public static final ChatterNameDisplayRule NICKNAME_ALIAS_NAME = null;
    public static final ChatterNameDisplayRule NICKNAME_NAME = null;
    public static final ChatterNameDisplayRule NICKNAME_WITH_ALIAS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatterNameDisplayRule[] f409803a = null;
    private int value;

    static {
        ChatterNameDisplayRule r100 = new ChatterNameDisplayRule("NAME", 0, 1);
        NAME = r100;
        ChatterNameDisplayRule r101 = new ChatterNameDisplayRule("ALIAS_NAME", 1, 2);
        ALIAS_NAME = r101;
        ChatterNameDisplayRule r102 = new ChatterNameDisplayRule("NICKNAME_ALIAS_NAME", 2, 3);
        NICKNAME_ALIAS_NAME = r102;
        ChatterNameDisplayRule r103 = new ChatterNameDisplayRule("ALIAS_NICKNAME_NAME", 3, 4);
        ALIAS_NICKNAME_NAME = r103;
        ChatterNameDisplayRule r104 = new ChatterNameDisplayRule("NICKNAME_NAME", 4, 5);
        NICKNAME_NAME = r104;
        ChatterNameDisplayRule r110 = new ChatterNameDisplayRule("NICKNAME_WITH_ALIAS", 5, 6);
        NICKNAME_WITH_ALIAS = r110;
        f409803a = new ChatterNameDisplayRule[]{r100, r101, r102, r103, r104, r110};
    }

    public static ChatterNameDisplayRule[] values() {
        return (ChatterNameDisplayRule[]) f409803a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ChatterNameDisplayRule forNumber(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return null;
    L15:
        return NICKNAME_NAME;
    L17:
        return ALIAS_NICKNAME_NAME;
    L19:
        return NICKNAME_ALIAS_NAME;
    L21:
        return ALIAS_NAME;
    L23:
        return NAME;
    }

    public static ChatterNameDisplayRule valueOf(String r100) {
        return (ChatterNameDisplayRule) r27.a.a(ChatterNameDisplayRule.class, r100);
    }

    public static ChatterNameDisplayRule valueOf(int r100) {
        return forNumber(r100);
    }

    public ChatterNameDisplayRule(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
