package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerFormat extends Enum<VeLivePlayerFormat> {
    public static final VeLivePlayerFormat VeLivePlayerFormatCMAF = null;
    public static final VeLivePlayerFormat VeLivePlayerFormatFLV = null;
    public static final VeLivePlayerFormat VeLivePlayerFormatHLS = null;
    public static final VeLivePlayerFormat VeLivePlayerFormatRTM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerFormat[] f459684a = null;

    static {
        VeLivePlayerFormat r100 = new VeLivePlayerFormat("VeLivePlayerFormatFLV", 0);
        VeLivePlayerFormatFLV = r100;
        VeLivePlayerFormat r101 = new VeLivePlayerFormat("VeLivePlayerFormatHLS", 1);
        VeLivePlayerFormatHLS = r101;
        VeLivePlayerFormat r102 = new VeLivePlayerFormat("VeLivePlayerFormatRTM", 2);
        VeLivePlayerFormatRTM = r102;
        VeLivePlayerFormat r103 = new VeLivePlayerFormat("VeLivePlayerFormatCMAF", 3);
        VeLivePlayerFormatCMAF = r103;
        f459684a = new VeLivePlayerFormat[]{r100, r101, r102, r103};
    }

    public static VeLivePlayerFormat[] values() {
        return (VeLivePlayerFormat[]) f459684a.clone();
    }

    public static VeLivePlayerFormat valueOf(String r100) {
        return (VeLivePlayerFormat) r27.a.a(VeLivePlayerFormat.class, r100);
    }

    public VeLivePlayerFormat(String r100, int r101) {
        super(r100, r101);
    }
}
