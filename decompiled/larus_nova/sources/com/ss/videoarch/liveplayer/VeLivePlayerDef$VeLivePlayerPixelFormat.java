package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerPixelFormat extends Enum<VeLivePlayerDef$VeLivePlayerPixelFormat> {
    public static final VeLivePlayerDef$VeLivePlayerPixelFormat VeLivePlayerPixelFormatRGBA32 = null;
    public static final VeLivePlayerDef$VeLivePlayerPixelFormat VeLivePlayerPixelFormatTexture = null;
    public static final VeLivePlayerDef$VeLivePlayerPixelFormat VeLivePlayerPixelFormatUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerPixelFormat[] f458621a = null;

    static {
        VeLivePlayerDef$VeLivePlayerPixelFormat r100 = new VeLivePlayerDef$VeLivePlayerPixelFormat("VeLivePlayerPixelFormatUnknown", 0);
        VeLivePlayerPixelFormatUnknown = r100;
        VeLivePlayerDef$VeLivePlayerPixelFormat r101 = new VeLivePlayerDef$VeLivePlayerPixelFormat("VeLivePlayerPixelFormatRGBA32", 1);
        VeLivePlayerPixelFormatRGBA32 = r101;
        VeLivePlayerDef$VeLivePlayerPixelFormat r102 = new VeLivePlayerDef$VeLivePlayerPixelFormat("VeLivePlayerPixelFormatTexture", 2);
        VeLivePlayerPixelFormatTexture = r102;
        f458621a = new VeLivePlayerDef$VeLivePlayerPixelFormat[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerPixelFormat[] values() {
        return (VeLivePlayerDef$VeLivePlayerPixelFormat[]) f458621a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerPixelFormat valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerPixelFormat) r27.a.a(VeLivePlayerDef$VeLivePlayerPixelFormat.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerPixelFormat(String r100, int r101) {
        super(r100, r101);
    }
}
