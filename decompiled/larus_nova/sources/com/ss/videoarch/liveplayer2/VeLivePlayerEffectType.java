package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerEffectType extends Enum<VeLivePlayerEffectType> {
    public static final VeLivePlayerEffectType VeLivePlayerEffectAudioBalance = null;
    public static final VeLivePlayerEffectType VeLivePlayerEffectAudioMetric = null;
    public static final VeLivePlayerEffectType VeLivePlayerEffectUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerEffectType[] f459682a = null;

    static {
        VeLivePlayerEffectType r100 = new VeLivePlayerEffectType("VeLivePlayerEffectUnknown", 0);
        VeLivePlayerEffectUnknown = r100;
        VeLivePlayerEffectType r101 = new VeLivePlayerEffectType("VeLivePlayerEffectAudioBalance", 1);
        VeLivePlayerEffectAudioBalance = r101;
        VeLivePlayerEffectType r102 = new VeLivePlayerEffectType("VeLivePlayerEffectAudioMetric", 2);
        VeLivePlayerEffectAudioMetric = r102;
        f459682a = new VeLivePlayerEffectType[]{r100, r101, r102};
    }

    public static VeLivePlayerEffectType[] values() {
        return (VeLivePlayerEffectType[]) f459682a.clone();
    }

    public static VeLivePlayerEffectType valueOf(String r100) {
        return (VeLivePlayerEffectType) r27.a.a(VeLivePlayerEffectType.class, r100);
    }

    public VeLivePlayerEffectType(String r100, int r101) {
        super(r100, r101);
    }
}
