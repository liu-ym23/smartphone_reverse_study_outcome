package com.ss.android.ttve.common;

/* JADX INFO: loaded from: classes38.dex */
public final class TESpdLogManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile TESpdLogManager f449829b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TESpdLogInvoker f449830a;

    public static final enum InfoLevel extends Enum<InfoLevel> {
        public static final InfoLevel LEVEL0 = null;
        public static final InfoLevel LEVEL1 = null;
        public static final InfoLevel LEVEL2 = null;
        public static final InfoLevel LEVEL3 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InfoLevel[] f449831a = null;

        static {
            InfoLevel r100 = new InfoLevel("LEVEL0", 0);
            LEVEL0 = r100;
            InfoLevel r101 = new InfoLevel("LEVEL1", 1);
            LEVEL1 = r101;
            InfoLevel r102 = new InfoLevel("LEVEL2", 2);
            LEVEL2 = r102;
            InfoLevel r103 = new InfoLevel("LEVEL3", 3);
            LEVEL3 = r103;
            f449831a = new InfoLevel[]{r100, r101, r102, r103};
        }

        public static InfoLevel[] values() {
            return (InfoLevel[]) f449831a.clone();
        }

        public static InfoLevel valueOf(String r100) {
            return (InfoLevel) r27.a.a(InfoLevel.class, r100);
        }

        public InfoLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static TESpdLogManager a() {
        if (f449829b != null) goto L15;
        monitor-enter(TESpdLogManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f449829b != null) goto L9;
        f449829b = new TESpdLogManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TESpdLogManager.class);     // Catch: Throwable -> L11
    L15:
        return f449829b;
    }

    public TESpdLogManager() {
        this.f449830a = new TESpdLogInvoker();
    }
}
