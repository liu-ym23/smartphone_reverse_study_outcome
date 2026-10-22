package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerRotation extends Enum<VeLivePlayerDef$VeLivePlayerRotation> {
    public static final VeLivePlayerDef$VeLivePlayerRotation VeLivePlayerRotation0 = null;
    public static final VeLivePlayerDef$VeLivePlayerRotation VeLivePlayerRotation180 = null;
    public static final VeLivePlayerDef$VeLivePlayerRotation VeLivePlayerRotation270 = null;
    public static final VeLivePlayerDef$VeLivePlayerRotation VeLivePlayerRotation90 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerRotation[] f458624a = null;

    static {
        VeLivePlayerDef$VeLivePlayerRotation r100 = new VeLivePlayerDef$VeLivePlayerRotation("VeLivePlayerRotation0", 0);
        VeLivePlayerRotation0 = r100;
        VeLivePlayerDef$VeLivePlayerRotation r101 = new VeLivePlayerDef$VeLivePlayerRotation("VeLivePlayerRotation90", 1);
        VeLivePlayerRotation90 = r101;
        VeLivePlayerDef$VeLivePlayerRotation r102 = new VeLivePlayerDef$VeLivePlayerRotation("VeLivePlayerRotation180", 2);
        VeLivePlayerRotation180 = r102;
        VeLivePlayerDef$VeLivePlayerRotation r103 = new VeLivePlayerDef$VeLivePlayerRotation("VeLivePlayerRotation270", 3);
        VeLivePlayerRotation270 = r103;
        f458624a = new VeLivePlayerDef$VeLivePlayerRotation[]{r100, r101, r102, r103};
    }

    public static VeLivePlayerDef$VeLivePlayerRotation[] values() {
        return (VeLivePlayerDef$VeLivePlayerRotation[]) f458624a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerRotation valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerRotation) r27.a.a(VeLivePlayerDef$VeLivePlayerRotation.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerRotation(String r100, int r101) {
        super(r100, r101);
    }
}
