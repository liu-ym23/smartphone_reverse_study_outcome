package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerStreamType extends Enum<VeLivePlayerStreamType> {
    public static final VeLivePlayerStreamType VeLivePlayerStreamTypeBackup = null;
    public static final VeLivePlayerStreamType VeLivePlayerStreamTypeMain = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerStreamType[] f459706a = null;

    static {
        VeLivePlayerStreamType r100 = new VeLivePlayerStreamType("VeLivePlayerStreamTypeMain", 0);
        VeLivePlayerStreamTypeMain = r100;
        VeLivePlayerStreamType r101 = new VeLivePlayerStreamType("VeLivePlayerStreamTypeBackup", 1);
        VeLivePlayerStreamTypeBackup = r101;
        f459706a = new VeLivePlayerStreamType[]{r100, r101};
    }

    public static VeLivePlayerStreamType[] values() {
        return (VeLivePlayerStreamType[]) f459706a.clone();
    }

    public static VeLivePlayerStreamType valueOf(String r100) {
        return (VeLivePlayerStreamType) r27.a.a(VeLivePlayerStreamType.class, r100);
    }

    public VeLivePlayerStreamType(String r100, int r101) {
        super(r100, r101);
    }
}
