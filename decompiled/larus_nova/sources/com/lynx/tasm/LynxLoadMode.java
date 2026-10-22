package com.lynx.tasm;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxLoadMode extends Enum<LynxLoadMode> {
    public static final LynxLoadMode HYDRATE_SSR = null;
    public static final LynxLoadMode NORMAL = null;
    public static final LynxLoadMode PRE_PAINTING = null;
    public static final LynxLoadMode PRE_PAINTING_DRAW = null;
    public static final LynxLoadMode RENDER_SSR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxLoadMode[] f381667a = null;
    private int mId;

    static {
        LynxLoadMode r100 = new LynxLoadMode(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        LynxLoadMode r101 = new LynxLoadMode("PRE_PAINTING", 1, 1);
        PRE_PAINTING = r101;
        LynxLoadMode r102 = new LynxLoadMode("PRE_PAINTING_DRAW", 2, 2);
        PRE_PAINTING_DRAW = r102;
        LynxLoadMode r103 = new LynxLoadMode("RENDER_SSR", 3, 3);
        RENDER_SSR = r103;
        LynxLoadMode r104 = new LynxLoadMode("HYDRATE_SSR", 4, 4);
        HYDRATE_SSR = r104;
        f381667a = new LynxLoadMode[]{r100, r101, r102, r103, r104};
    }

    public static LynxLoadMode[] values() {
        return (LynxLoadMode[]) f381667a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static LynxLoadMode valueOf(String r100) {
        return (LynxLoadMode) r27.a.a(LynxLoadMode.class, r100);
    }

    public LynxLoadMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mId = r102;
    }
}
