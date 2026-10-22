package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerVideoBufferType extends Enum<VeLivePlayerVideoBufferType> {
    public static final VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeByteArray = null;
    public static final VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeByteBuffer = null;
    public static final VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeTexture = null;
    public static final VeLivePlayerVideoBufferType VeLivePlayerVideoBufferTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerVideoBufferType[] f459710a = null;

    static {
        VeLivePlayerVideoBufferType r100 = new VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeUnknown", 0);
        VeLivePlayerVideoBufferTypeUnknown = r100;
        VeLivePlayerVideoBufferType r101 = new VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeByteBuffer", 1);
        VeLivePlayerVideoBufferTypeByteBuffer = r101;
        VeLivePlayerVideoBufferType r102 = new VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeByteArray", 2);
        VeLivePlayerVideoBufferTypeByteArray = r102;
        VeLivePlayerVideoBufferType r103 = new VeLivePlayerVideoBufferType("VeLivePlayerVideoBufferTypeTexture", 3);
        VeLivePlayerVideoBufferTypeTexture = r103;
        f459710a = new VeLivePlayerVideoBufferType[]{r100, r101, r102, r103};
    }

    public static VeLivePlayerVideoBufferType[] values() {
        return (VeLivePlayerVideoBufferType[]) f459710a.clone();
    }

    public static VeLivePlayerVideoBufferType valueOf(String r100) {
        return (VeLivePlayerVideoBufferType) r27.a.a(VeLivePlayerVideoBufferType.class, r100);
    }

    public VeLivePlayerVideoBufferType(String r100, int r101) {
        super(r100, r101);
    }
}
