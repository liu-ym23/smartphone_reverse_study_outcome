package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerStreamType extends Enum<VeLivePlayerDef$VeLivePlayerStreamType> {
    public static final VeLivePlayerDef$VeLivePlayerStreamType VeLivePlayerStreamTypeBackup = null;
    public static final VeLivePlayerDef$VeLivePlayerStreamType VeLivePlayerStreamTypeMain = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerStreamType[] f458626a = null;

    static {
        VeLivePlayerDef$VeLivePlayerStreamType r100 = new VeLivePlayerDef$VeLivePlayerStreamType("VeLivePlayerStreamTypeMain", 0);
        VeLivePlayerStreamTypeMain = r100;
        VeLivePlayerDef$VeLivePlayerStreamType r101 = new VeLivePlayerDef$VeLivePlayerStreamType("VeLivePlayerStreamTypeBackup", 1);
        VeLivePlayerStreamTypeBackup = r101;
        f458626a = new VeLivePlayerDef$VeLivePlayerStreamType[]{r100, r101};
    }

    public static VeLivePlayerDef$VeLivePlayerStreamType[] values() {
        return (VeLivePlayerDef$VeLivePlayerStreamType[]) f458626a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerStreamType valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerStreamType) r27.a.a(VeLivePlayerDef$VeLivePlayerStreamType.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerStreamType(String r100, int r101) {
        super(r100, r101);
    }
}
