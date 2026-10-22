package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes3.dex */
public final enum Level extends Enum<Level> {
    public static final Level L0 = null;
    public static final Level L1 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f199603a = null;
    private final int mLevel;

    static {
        Level r100 = new Level("L0", 0, 0);
        L0 = r100;
        Level r101 = new Level("L1", 1, 1);
        L1 = r101;
        f199603a = new Level[]{r100, r101};
    }

    public static Level[] values() {
        return (Level[]) f199603a.clone();
    }

    public int value() {
        return this.mLevel;
    }

    public static Level valueOf(String r100) {
        return (Level) r27.a.a(Level.class, r100);
    }

    public Level(String r100, int r101, int r102) {
        super(r100, r101);
        this.mLevel = r102;
    }
}
