package com.ss.videoarch.liveplayer.utils;

import com.ss.videoarch.liveplayer.VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum BmfSharpenV2Level extends Enum<BmfSharpenV2Level> {
    public static final BmfSharpenV2Level GAME1 = null;
    public static final BmfSharpenV2Level GAME2 = null;
    public static final BmfSharpenV2Level Medium = null;
    public static final BmfSharpenV2Level Strong = null;
    public static final BmfSharpenV2Level VeryWeak = null;
    public static final BmfSharpenV2Level Weak = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BmfSharpenV2Level[] f459655a = null;
    public float bmfGlobalThres;
    public float bmfInitialWeight;
    public float bmfOverflowRatio;
    public float bmfWeightThres;
    public int enableBMFAdaptive;
    public float lowWeightThres;

    static {
        BmfSharpenV2Level r100 = new BmfSharpenV2Level("VeryWeak", 0, 2.0f, 3.0f, 0.1f, 1, 1200.0f, 1.0f);
        VeryWeak = r100;
        BmfSharpenV2Level r101 = new BmfSharpenV2Level("Weak", 1, 3.0f, 3.0f, 0.1f, 1, 1200.0f, 1.0f);
        Weak = r101;
        BmfSharpenV2Level r102 = new BmfSharpenV2Level("Medium", 2, 4.0f, 3.0f, 0.2f, 1, 1200.0f, 1.0f);
        Medium = r102;
        BmfSharpenV2Level r103 = new BmfSharpenV2Level("Strong", 3, 5.0f, 3.0f, 0.3f, 1, 1200.0f, 1.0f);
        Strong = r103;
        BmfSharpenV2Level r104 = new BmfSharpenV2Level("GAME1", 4, 4.5f, 5.0f, 0.1f, 1, 1200.0f, 1.0f);
        GAME1 = r104;
        BmfSharpenV2Level r105 = new BmfSharpenV2Level("GAME2", 5, 5.0f, 5.0f, 0.15f, 1, 1200.0f, 1.0f);
        GAME2 = r105;
        f459655a = new BmfSharpenV2Level[]{r100, r101, r102, r103, r104, r105};
    }

    public static BmfSharpenV2Level[] values() {
        return (BmfSharpenV2Level[]) f459655a.clone();
    }

    public static BmfSharpenV2Level valueOf(String r100) {
        return (BmfSharpenV2Level) a.a(BmfSharpenV2Level.class, r100);
    }

    public static VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel toVeLivePlayerVideoEffectSharpenLevel(float r100, float r101, float r102, int r103, float r104, float r105) {
        BmfSharpenV2Level r106 = VeryWeak;
        if (r106.bmfWeightThres == r100) goto L5;
    L16:
        BmfSharpenV2Level r107 = Weak;
        if (r107.bmfWeightThres == r100) goto L19;
    L30:
        BmfSharpenV2Level r108 = Medium;
        if (r108.bmfWeightThres == r100) goto L33;
    L44:
        BmfSharpenV2Level r109 = Strong;
        if (r109.bmfWeightThres == r100) goto L47;
    L58:
        BmfSharpenV2Level r110 = GAME1;
        if (r110.bmfWeightThres == r100) goto L61;
    L72:
        BmfSharpenV2Level r111 = GAME2;
        if (r111.bmfWeightThres != r100) goto L87;
        if (r111.bmfGlobalThres != r101) goto L87;
        if (r111.bmfOverflowRatio != r102) goto L87;
        if (r111.enableBMFAdaptive != r103) goto L87;
        if (r111.bmfInitialWeight != r104) goto L87;
        if (r111.lowWeightThres != r105) goto L87;
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelGAME2;
    L87:
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelUnknown;
    L61:
        if (r110.bmfGlobalThres != r101) goto L72;
        if (r110.bmfOverflowRatio != r102) goto L72;
        if (r110.enableBMFAdaptive != r103) goto L72;
        if (r110.bmfInitialWeight != r104) goto L72;
        if (r110.lowWeightThres != r105) goto L72;
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelGAME1;
    L47:
        if (r109.bmfGlobalThres != r101) goto L58;
        if (r109.bmfOverflowRatio != r102) goto L58;
        if (r109.enableBMFAdaptive != r103) goto L58;
        if (r109.bmfInitialWeight != r104) goto L58;
        if (r109.lowWeightThres != r105) goto L58;
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelStrong;
    L33:
        if (r108.bmfGlobalThres != r101) goto L44;
        if (r108.bmfOverflowRatio != r102) goto L44;
        if (r108.enableBMFAdaptive != r103) goto L44;
        if (r108.bmfInitialWeight != r104) goto L44;
        if (r108.lowWeightThres != r105) goto L44;
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelMedium;
    L19:
        if (r107.bmfGlobalThres != r101) goto L30;
        if (r107.bmfOverflowRatio != r102) goto L30;
        if (r107.enableBMFAdaptive != r103) goto L30;
        if (r107.bmfInitialWeight != r104) goto L30;
        if (r107.lowWeightThres != r105) goto L30;
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelWeak;
    L5:
        if (r106.bmfGlobalThres != r101) goto L16;
        if (r106.bmfOverflowRatio != r102) goto L16;
        if (r106.enableBMFAdaptive != r103) goto L16;
        if (r106.bmfInitialWeight != r104) goto L16;
        if (r106.lowWeightThres != r105) goto L16;
        return VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelVeryWeak;
    }

    private BmfSharpenV2Level(String r100, int r101, float r102, float r103, float r104, int r105, float r106, float r107) {
        super(r100, r101);
        this.bmfWeightThres = r102;
        this.bmfGlobalThres = r103;
        this.bmfOverflowRatio = r104;
        this.enableBMFAdaptive = r105;
        this.bmfInitialWeight = r106;
        this.lowWeightThres = r107;
    }
}
