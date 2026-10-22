package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerMirror extends Enum<VeLivePlayerMirror> {
    public static final VeLivePlayerMirror VeLivePlayerMirrorHorizontal = null;
    public static final VeLivePlayerMirror VeLivePlayerMirrorNone = null;
    public static final VeLivePlayerMirror VeLivePlayerMirrorVertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerMirror[] f459696a = null;

    static {
        VeLivePlayerMirror r100 = new VeLivePlayerMirror("VeLivePlayerMirrorNone", 0);
        VeLivePlayerMirrorNone = r100;
        VeLivePlayerMirror r101 = new VeLivePlayerMirror("VeLivePlayerMirrorHorizontal", 1);
        VeLivePlayerMirrorHorizontal = r101;
        VeLivePlayerMirror r102 = new VeLivePlayerMirror("VeLivePlayerMirrorVertical", 2);
        VeLivePlayerMirrorVertical = r102;
        f459696a = new VeLivePlayerMirror[]{r100, r101, r102};
    }

    public static VeLivePlayerMirror[] values() {
        return (VeLivePlayerMirror[]) f459696a.clone();
    }

    public static VeLivePlayerMirror valueOf(String r100) {
        return (VeLivePlayerMirror) r27.a.a(VeLivePlayerMirror.class, r100);
    }

    public VeLivePlayerMirror(String r100, int r101) {
        super(r100, r101);
    }
}
