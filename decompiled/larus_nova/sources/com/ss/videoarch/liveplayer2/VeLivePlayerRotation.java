package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerRotation extends Enum<VeLivePlayerRotation> {
    public static final VeLivePlayerRotation VeLivePlayerRotation0 = null;
    public static final VeLivePlayerRotation VeLivePlayerRotation180 = null;
    public static final VeLivePlayerRotation VeLivePlayerRotation270 = null;
    public static final VeLivePlayerRotation VeLivePlayerRotation90 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerRotation[] f459701a = null;

    static {
        VeLivePlayerRotation r100 = new VeLivePlayerRotation("VeLivePlayerRotation0", 0);
        VeLivePlayerRotation0 = r100;
        VeLivePlayerRotation r101 = new VeLivePlayerRotation("VeLivePlayerRotation90", 1);
        VeLivePlayerRotation90 = r101;
        VeLivePlayerRotation r102 = new VeLivePlayerRotation("VeLivePlayerRotation180", 2);
        VeLivePlayerRotation180 = r102;
        VeLivePlayerRotation r103 = new VeLivePlayerRotation("VeLivePlayerRotation270", 3);
        VeLivePlayerRotation270 = r103;
        f459701a = new VeLivePlayerRotation[]{r100, r101, r102, r103};
    }

    public static VeLivePlayerRotation[] values() {
        return (VeLivePlayerRotation[]) f459701a.clone();
    }

    public static VeLivePlayerRotation valueOf(String r100) {
        return (VeLivePlayerRotation) r27.a.a(VeLivePlayerRotation.class, r100);
    }

    public VeLivePlayerRotation(String r100, int r101) {
        super(r100, r101);
    }
}
