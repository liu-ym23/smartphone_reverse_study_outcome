package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerPixelFormat extends Enum<VeLivePlayerPixelFormat> {
    public static final VeLivePlayerPixelFormat VeLivePlayerPixelFormatRGBA32 = null;
    public static final VeLivePlayerPixelFormat VeLivePlayerPixelFormatTexture = null;
    public static final VeLivePlayerPixelFormat VeLivePlayerPixelFormatUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerPixelFormat[] f459697a = null;

    static {
        VeLivePlayerPixelFormat r100 = new VeLivePlayerPixelFormat("VeLivePlayerPixelFormatUnknown", 0);
        VeLivePlayerPixelFormatUnknown = r100;
        VeLivePlayerPixelFormat r101 = new VeLivePlayerPixelFormat("VeLivePlayerPixelFormatRGBA32", 1);
        VeLivePlayerPixelFormatRGBA32 = r101;
        VeLivePlayerPixelFormat r102 = new VeLivePlayerPixelFormat("VeLivePlayerPixelFormatTexture", 2);
        VeLivePlayerPixelFormatTexture = r102;
        f459697a = new VeLivePlayerPixelFormat[]{r100, r101, r102};
    }

    public static VeLivePlayerPixelFormat[] values() {
        return (VeLivePlayerPixelFormat[]) f459697a.clone();
    }

    public static VeLivePlayerPixelFormat valueOf(String r100) {
        return (VeLivePlayerPixelFormat) r27.a.a(VeLivePlayerPixelFormat.class, r100);
    }

    public VeLivePlayerPixelFormat(String r100, int r101) {
        super(r100, r101);
    }
}
