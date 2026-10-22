package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerVideoBufferType extends Enum<VeLivePlayerDef$VeLivePlayerVideoBufferType> {
    public static final VeLivePlayerDef$VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeByteArray = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeByteBuffer = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeTexture = null;
    public static final VeLivePlayerDef$VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerVideoBufferType[] f458627a = null;

    static {
        VeLivePlayerDef$VeLivePlayerVideoBufferType r100 = new VeLivePlayerDef$VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeUnknown", 0);
        VeLivePlayerVideoBufferTypeUnknown = r100;
        VeLivePlayerDef$VeLivePlayerVideoBufferType r101 = new VeLivePlayerDef$VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeByteBuffer", 1);
        VeLivePlayerVideoBufferTypeByteBuffer = r101;
        VeLivePlayerDef$VeLivePlayerVideoBufferType r102 = new VeLivePlayerDef$VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeByteArray", 2);
        VeLivePlayerVideoBufferTypeByteArray = r102;
        VeLivePlayerDef$VeLivePlayerVideoBufferType r103 = new VeLivePlayerDef$VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeTexture", 3);
        VeLivePlayerVideoBufferTypeTexture = r103;
        f458627a = new VeLivePlayerDef$VeLivePlayerVideoBufferType[]{r100, r101, r102, r103};
    }

    public static VeLivePlayerDef$VeLivePlayerVideoBufferType[] values() {
        return (VeLivePlayerDef$VeLivePlayerVideoBufferType[]) f458627a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerVideoBufferType valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerVideoBufferType) r27.a.a(VeLivePlayerDef$VeLivePlayerVideoBufferType.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerVideoBufferType(String r100, int r101) {
        super(r100, r101);
    }
}
