package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerFormat extends Enum<VeLivePlayerDef$VeLivePlayerFormat> {
    public static final VeLivePlayerDef$VeLivePlayerFormat VeLivePlayerFormatFLV = null;
    public static final VeLivePlayerDef$VeLivePlayerFormat VeLivePlayerFormatHLS = null;
    public static final VeLivePlayerDef$VeLivePlayerFormat VeLivePlayerFormatRTM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerFormat[] f458619a = null;

    static {
        VeLivePlayerDef$VeLivePlayerFormat r100 = new VeLivePlayerDef$VeLivePlayerFormat("VeLivePlayerFormatFLV", 0);
        VeLivePlayerFormatFLV = r100;
        VeLivePlayerDef$VeLivePlayerFormat r101 = new VeLivePlayerDef$VeLivePlayerFormat("VeLivePlayerFormatHLS", 1);
        VeLivePlayerFormatHLS = r101;
        VeLivePlayerDef$VeLivePlayerFormat r102 = new VeLivePlayerDef$VeLivePlayerFormat("VeLivePlayerFormatRTM", 2);
        VeLivePlayerFormatRTM = r102;
        f458619a = new VeLivePlayerDef$VeLivePlayerFormat[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerFormat[] values() {
        return (VeLivePlayerDef$VeLivePlayerFormat[]) f458619a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerFormat valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerFormat) r27.a.a(VeLivePlayerDef$VeLivePlayerFormat.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerFormat(String r100, int r101) {
        super(r100, r101);
    }
}
