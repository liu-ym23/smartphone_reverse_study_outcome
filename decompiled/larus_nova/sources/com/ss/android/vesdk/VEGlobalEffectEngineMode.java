package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEGlobalEffectEngineMode extends Enum<VEGlobalEffectEngineMode> {
    public static final VEGlobalEffectEngineMode GLOBAL_NEW_ENGINE = null;
    public static final VEGlobalEffectEngineMode GLOBAL_NEW_OLD_ENGINE_COEXIST = null;
    public static final VEGlobalEffectEngineMode GLOBAL_OLD_ENGINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEGlobalEffectEngineMode[] f455627a = null;
    public int mode;

    static {
        VEGlobalEffectEngineMode r100 = new VEGlobalEffectEngineMode("GLOBAL_OLD_ENGINE", 0, 1);
        GLOBAL_OLD_ENGINE = r100;
        VEGlobalEffectEngineMode r101 = new VEGlobalEffectEngineMode("GLOBAL_NEW_OLD_ENGINE_COEXIST", 1, 2);
        GLOBAL_NEW_OLD_ENGINE_COEXIST = r101;
        VEGlobalEffectEngineMode r102 = new VEGlobalEffectEngineMode("GLOBAL_NEW_ENGINE", 2, 3);
        GLOBAL_NEW_ENGINE = r102;
        f455627a = new VEGlobalEffectEngineMode[]{r100, r101, r102};
    }

    public static VEGlobalEffectEngineMode[] values() {
        return (VEGlobalEffectEngineMode[]) f455627a.clone();
    }

    public static VEGlobalEffectEngineMode valueOf(String r100) {
        return (VEGlobalEffectEngineMode) r27.a.a(VEGlobalEffectEngineMode.class, r100);
    }

    public VEGlobalEffectEngineMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
