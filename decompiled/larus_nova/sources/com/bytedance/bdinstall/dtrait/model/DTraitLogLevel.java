package com.bytedance.bdinstall.dtrait.model;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum DTraitLogLevel extends Enum<DTraitLogLevel> {
    public static final DTraitLogLevel DEBUG = null;
    public static final DTraitLogLevel ERROR = null;
    public static final DTraitLogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DTraitLogLevel[] f199634a = null;
    private final String level;

    static {
        DTraitLogLevel r100 = new DTraitLogLevel("DEBUG", 0, "DEBUG");
        DEBUG = r100;
        DTraitLogLevel r101 = new DTraitLogLevel("WARN", 1, "warn");
        WARN = r101;
        DTraitLogLevel r102 = new DTraitLogLevel("ERROR", 2, "ERROR");
        ERROR = r102;
        f199634a = new DTraitLogLevel[]{r100, r101, r102};
    }

    public static DTraitLogLevel[] values() {
        return (DTraitLogLevel[]) f199634a.clone();
    }

    public String getLevel() {
        return this.level;
    }

    public static DTraitLogLevel valueOf(String r100) {
        return (DTraitLogLevel) a.a(DTraitLogLevel.class, r100);
    }

    public DTraitLogLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.level = r102;
    }
}
