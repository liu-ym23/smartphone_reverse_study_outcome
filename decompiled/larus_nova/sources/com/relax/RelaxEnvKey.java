package com.relax;

/* JADX INFO: loaded from: classes34.dex */
public final enum RelaxEnvKey extends Enum<RelaxEnvKey> {
    public static final RelaxEnvKey ENABLE_DEVTOOL = null;
    public static final RelaxEnvKey ENABLE_DEV_MENU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RelaxEnvKey[] f404557a = null;
    private final String desc;

    static {
        RelaxEnvKey r100 = new RelaxEnvKey("ENABLE_DEVTOOL", 0, "enable_devtool");
        ENABLE_DEVTOOL = r100;
        RelaxEnvKey r101 = new RelaxEnvKey("ENABLE_DEV_MENU", 1, "enable_dev_menu");
        ENABLE_DEV_MENU = r101;
        f404557a = new RelaxEnvKey[]{r100, r101};
    }

    public static RelaxEnvKey[] values() {
        return (RelaxEnvKey[]) f404557a.clone();
    }

    public String getDesc() {
        return this.desc;
    }

    public static RelaxEnvKey valueOf(String r100) {
        return (RelaxEnvKey) r27.a.a(RelaxEnvKey.class, r100);
    }

    public RelaxEnvKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
