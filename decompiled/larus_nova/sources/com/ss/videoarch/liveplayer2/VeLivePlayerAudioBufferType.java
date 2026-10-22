package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerAudioBufferType extends Enum<VeLivePlayerAudioBufferType> {
    public static final VeLivePlayerAudioBufferType VeLivePlayerAudioBufferTypeByteArray = null;
    public static final VeLivePlayerAudioBufferType VeLivePlayerAudioBufferTypeByteBuffer = null;
    public static final VeLivePlayerAudioBufferType VeLivePlayerAudioBufferTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerAudioBufferType[] f459676a = null;

    static {
        VeLivePlayerAudioBufferType r100 = new VeLivePlayerAudioBufferType("VeLivePlayerAudioBufferTypeUnknown", 0);
        VeLivePlayerAudioBufferTypeUnknown = r100;
        VeLivePlayerAudioBufferType r101 = new VeLivePlayerAudioBufferType("VeLivePlayerAudioBufferTypeByteArray", 1);
        VeLivePlayerAudioBufferTypeByteArray = r101;
        VeLivePlayerAudioBufferType r102 = new VeLivePlayerAudioBufferType("VeLivePlayerAudioBufferTypeByteBuffer", 2);
        VeLivePlayerAudioBufferTypeByteBuffer = r102;
        f459676a = new VeLivePlayerAudioBufferType[]{r100, r101, r102};
    }

    public static VeLivePlayerAudioBufferType[] values() {
        return (VeLivePlayerAudioBufferType[]) f459676a.clone();
    }

    public static VeLivePlayerAudioBufferType valueOf(String r100) {
        return (VeLivePlayerAudioBufferType) r27.a.a(VeLivePlayerAudioBufferType.class, r100);
    }

    public VeLivePlayerAudioBufferType(String r100, int r101) {
        super(r100, r101);
    }
}
