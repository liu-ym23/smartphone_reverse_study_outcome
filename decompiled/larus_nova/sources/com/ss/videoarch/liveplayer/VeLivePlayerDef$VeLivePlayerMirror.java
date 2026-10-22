package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerMirror extends Enum<VeLivePlayerDef$VeLivePlayerMirror> {
    public static final VeLivePlayerDef$VeLivePlayerMirror VeLivePlayerMirrorHorizontal = null;
    public static final VeLivePlayerDef$VeLivePlayerMirror VeLivePlayerMirrorNone = null;
    public static final VeLivePlayerDef$VeLivePlayerMirror VeLivePlayerMirrorVertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerMirror[] f458620a = null;

    static {
        VeLivePlayerDef$VeLivePlayerMirror r100 = new VeLivePlayerDef$VeLivePlayerMirror("VeLivePlayerMirrorNone", 0);
        VeLivePlayerMirrorNone = r100;
        VeLivePlayerDef$VeLivePlayerMirror r101 = new VeLivePlayerDef$VeLivePlayerMirror("VeLivePlayerMirrorHorizontal", 1);
        VeLivePlayerMirrorHorizontal = r101;
        VeLivePlayerDef$VeLivePlayerMirror r102 = new VeLivePlayerDef$VeLivePlayerMirror("VeLivePlayerMirrorVertical", 2);
        VeLivePlayerMirrorVertical = r102;
        f458620a = new VeLivePlayerDef$VeLivePlayerMirror[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerMirror[] values() {
        return (VeLivePlayerDef$VeLivePlayerMirror[]) f458620a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerMirror valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerMirror) r27.a.a(VeLivePlayerDef$VeLivePlayerMirror.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerMirror(String r100, int r101) {
        super(r100, r101);
    }
}
