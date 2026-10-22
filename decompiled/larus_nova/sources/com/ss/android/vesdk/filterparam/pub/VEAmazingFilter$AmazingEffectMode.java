package com.ss.android.vesdk.filterparam.pub;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEAmazingFilter$AmazingEffectMode extends Enum<VEAmazingFilter$AmazingEffectMode> {
    public static final VEAmazingFilter$AmazingEffectMode Canvas = null;
    public static final VEAmazingFilter$AmazingEffectMode Default = null;
    public static final VEAmazingFilter$AmazingEffectMode MixedAll = null;
    public static final VEAmazingFilter$AmazingEffectMode VideoFrame = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEAmazingFilter$AmazingEffectMode[] f455825a = null;

    static {
        VEAmazingFilter$AmazingEffectMode r100 = new VEAmazingFilter$AmazingEffectMode("Canvas", 0);
        Canvas = r100;
        VEAmazingFilter$AmazingEffectMode r101 = new VEAmazingFilter$AmazingEffectMode("Default", 1);
        Default = r101;
        VEAmazingFilter$AmazingEffectMode r102 = new VEAmazingFilter$AmazingEffectMode("MixedAll", 2);
        MixedAll = r102;
        VEAmazingFilter$AmazingEffectMode r103 = new VEAmazingFilter$AmazingEffectMode("VideoFrame", 3);
        VideoFrame = r103;
        f455825a = new VEAmazingFilter$AmazingEffectMode[]{r100, r101, r102, r103};
    }

    public static VEAmazingFilter$AmazingEffectMode[] values() {
        return (VEAmazingFilter$AmazingEffectMode[]) f455825a.clone();
    }

    public static VEAmazingFilter$AmazingEffectMode valueOf(String r100) {
        return (VEAmazingFilter$AmazingEffectMode) a.a(VEAmazingFilter$AmazingEffectMode.class, r100);
    }

    public VEAmazingFilter$AmazingEffectMode(String r100, int r101) {
        super(r100, r101);
    }
}
