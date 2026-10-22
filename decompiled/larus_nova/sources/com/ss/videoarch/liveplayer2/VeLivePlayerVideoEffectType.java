package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerVideoEffectType extends Enum<VeLivePlayerVideoEffectType> {
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectAesBoost = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectGaussianBlur = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectLut = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectPanorama = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectRoiSR = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectSDR2HDR = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectSR = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectSharpen = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectTypeNone = null;
    public static final VeLivePlayerVideoEffectType VeLivePlayerVideoEffectVQScore = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerVideoEffectType[] f459711a = null;

    static {
        VeLivePlayerVideoEffectType r100 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectTypeNone", 0);
        VeLivePlayerVideoEffectTypeNone = r100;
        VeLivePlayerVideoEffectType r101 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectGaussianBlur", 1);
        VeLivePlayerVideoEffectGaussianBlur = r101;
        VeLivePlayerVideoEffectType r102 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectLut", 2);
        VeLivePlayerVideoEffectLut = r102;
        VeLivePlayerVideoEffectType r103 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectRoiSR", 3);
        VeLivePlayerVideoEffectRoiSR = r103;
        VeLivePlayerVideoEffectType r104 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectSDR2HDR", 4);
        VeLivePlayerVideoEffectSDR2HDR = r104;
        VeLivePlayerVideoEffectType r105 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectSR", 5);
        VeLivePlayerVideoEffectSR = r105;
        VeLivePlayerVideoEffectType r110 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectSharpen", 6);
        VeLivePlayerVideoEffectSharpen = r110;
        VeLivePlayerVideoEffectType r111 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectAesBoost", 7);
        VeLivePlayerVideoEffectAesBoost = r111;
        VeLivePlayerVideoEffectType r112 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectVQScore", 8);
        VeLivePlayerVideoEffectVQScore = r112;
        VeLivePlayerVideoEffectType r113 = new VeLivePlayerVideoEffectType("VeLivePlayerVideoEffectPanorama", 9);
        VeLivePlayerVideoEffectPanorama = r113;
        f459711a = new VeLivePlayerVideoEffectType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static VeLivePlayerVideoEffectType[] values() {
        return (VeLivePlayerVideoEffectType[]) f459711a.clone();
    }

    public static VeLivePlayerVideoEffectType valueOf(String r100) {
        return (VeLivePlayerVideoEffectType) r27.a.a(VeLivePlayerVideoEffectType.class, r100);
    }

    public VeLivePlayerVideoEffectType(String r100, int r101) {
        super(r100, r101);
    }
}
