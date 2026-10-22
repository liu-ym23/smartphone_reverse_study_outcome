package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel extends Enum<VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel> {
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelGAME1 = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelGAME2 = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelMedium = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelStrong = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelUnknown = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelVeryWeak = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel VeLivePlayerSharpenLevelWeak = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel[] f458628a = null;

    static {
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r100 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelUnknown", 0);
        VeLivePlayerSharpenLevelUnknown = r100;
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r101 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelVeryWeak", 1);
        VeLivePlayerSharpenLevelVeryWeak = r101;
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r102 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelWeak", 2);
        VeLivePlayerSharpenLevelWeak = r102;
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r103 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelMedium", 3);
        VeLivePlayerSharpenLevelMedium = r103;
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r104 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelStrong", 4);
        VeLivePlayerSharpenLevelStrong = r104;
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r105 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelGAME1", 5);
        VeLivePlayerSharpenLevelGAME1 = r105;
        VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel r110 = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel("VeLivePlayerSharpenLevelGAME2", 6);
        VeLivePlayerSharpenLevelGAME2 = r110;
        f458628a = new VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel[] values() {
        return (VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel[]) f458628a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel) r27.a.a(VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel(String r100, int r101) {
        super(r100, r101);
    }
}
