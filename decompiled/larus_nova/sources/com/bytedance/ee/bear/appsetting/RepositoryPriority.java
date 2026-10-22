package com.bytedance.ee.bear.appsetting;

/* JADX INFO: loaded from: classes15.dex */
public final enum RepositoryPriority extends Enum<RepositoryPriority> {
    public static final RepositoryPriority DOU_BAO = null;
    public static final RepositoryPriority FG = null;
    public static final RepositoryPriority MINA = null;
    public static final RepositoryPriority MOCK_FG = null;
    public static final RepositoryPriority SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RepositoryPriority[] f206233a = null;

    static {
        RepositoryPriority r100 = new RepositoryPriority("MINA", 0);
        MINA = r100;
        RepositoryPriority r101 = new RepositoryPriority("SETTING", 1);
        SETTING = r101;
        RepositoryPriority r102 = new RepositoryPriority("FG", 2);
        FG = r102;
        RepositoryPriority r103 = new RepositoryPriority("DOU_BAO", 3);
        DOU_BAO = r103;
        RepositoryPriority r104 = new RepositoryPriority("MOCK_FG", 4);
        MOCK_FG = r104;
        f206233a = new RepositoryPriority[]{r100, r101, r102, r103, r104};
    }

    public static RepositoryPriority[] values() {
        return (RepositoryPriority[]) f206233a.clone();
    }

    public static RepositoryPriority valueOf(String r100) {
        return (RepositoryPriority) r27.a.a(RepositoryPriority.class, r100);
    }

    public RepositoryPriority(String r100, int r101) {
        super(r100, r101);
    }
}
