package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerEffectType extends Enum<VeLivePlayerDef$VeLivePlayerEffectType> {
    public static final VeLivePlayerDef$VeLivePlayerEffectType VeLivePlayerEffectAudioBalance = null;
    public static final VeLivePlayerDef$VeLivePlayerEffectType VeLivePlayerEffectAudioMetric = null;
    public static final VeLivePlayerDef$VeLivePlayerEffectType VeLivePlayerEffectUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerEffectType[] f458617a = null;

    static {
        VeLivePlayerDef$VeLivePlayerEffectType r100 = new VeLivePlayerDef$VeLivePlayerEffectType("VeLivePlayerEffectUnknown", 0);
        VeLivePlayerEffectUnknown = r100;
        VeLivePlayerDef$VeLivePlayerEffectType r101 = new VeLivePlayerDef$VeLivePlayerEffectType("VeLivePlayerEffectAudioBalance", 1);
        VeLivePlayerEffectAudioBalance = r101;
        VeLivePlayerDef$VeLivePlayerEffectType r102 = new VeLivePlayerDef$VeLivePlayerEffectType("VeLivePlayerEffectAudioMetric", 2);
        VeLivePlayerEffectAudioMetric = r102;
        f458617a = new VeLivePlayerDef$VeLivePlayerEffectType[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerEffectType[] values() {
        return (VeLivePlayerDef$VeLivePlayerEffectType[]) f458617a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerEffectType valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerEffectType) r27.a.a(VeLivePlayerDef$VeLivePlayerEffectType.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerEffectType(String r100, int r101) {
        super(r100, r101);
    }
}
