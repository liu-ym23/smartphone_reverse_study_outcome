package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEEffectEngineMode extends Enum<VEEffectEngineMode> {
    public static final VEEffectEngineMode EFFECT_NEW_ENGINE = null;
    public static final VEEffectEngineMode EFFECT_NEW_OLD_ENGINE_COEXIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEEffectEngineMode[] f455602a = null;
    public int mode;

    static {
        VEEffectEngineMode r100 = new VEEffectEngineMode("EFFECT_NEW_ENGINE", 0, 1);
        EFFECT_NEW_ENGINE = r100;
        VEEffectEngineMode r101 = new VEEffectEngineMode("EFFECT_NEW_OLD_ENGINE_COEXIST", 1, 2);
        EFFECT_NEW_OLD_ENGINE_COEXIST = r101;
        f455602a = new VEEffectEngineMode[]{r100, r101};
    }

    public static VEEffectEngineMode[] values() {
        return (VEEffectEngineMode[]) f455602a.clone();
    }

    public static VEEffectEngineMode valueOf(String r100) {
        return (VEEffectEngineMode) r27.a.a(VEEffectEngineMode.class, r100);
    }

    public VEEffectEngineMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
