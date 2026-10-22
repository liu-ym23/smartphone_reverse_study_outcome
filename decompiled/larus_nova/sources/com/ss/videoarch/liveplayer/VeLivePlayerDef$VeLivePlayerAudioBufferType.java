package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerAudioBufferType extends Enum<VeLivePlayerDef$VeLivePlayerAudioBufferType> {
    public static final VeLivePlayerDef$VeLivePlayerAudioBufferType VeLivePlayerAudioBufferTypeByteArray = null;
    public static final VeLivePlayerDef$VeLivePlayerAudioBufferType VeLivePlayerAudioBufferTypeByteBuffer = null;
    public static final VeLivePlayerDef$VeLivePlayerAudioBufferType VeLivePlayerAudioBufferTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerAudioBufferType[] f458616a = null;

    static {
        VeLivePlayerDef$VeLivePlayerAudioBufferType r100 = new VeLivePlayerDef$VeLivePlayerAudioBufferType("VeLivePlayerAudioBufferTypeUnknown", 0);
        VeLivePlayerAudioBufferTypeUnknown = r100;
        VeLivePlayerDef$VeLivePlayerAudioBufferType r101 = new VeLivePlayerDef$VeLivePlayerAudioBufferType("VeLivePlayerAudioBufferTypeByteArray", 1);
        VeLivePlayerAudioBufferTypeByteArray = r101;
        VeLivePlayerDef$VeLivePlayerAudioBufferType r102 = new VeLivePlayerDef$VeLivePlayerAudioBufferType("VeLivePlayerAudioBufferTypeByteBuffer", 2);
        VeLivePlayerAudioBufferTypeByteBuffer = r102;
        f458616a = new VeLivePlayerDef$VeLivePlayerAudioBufferType[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerAudioBufferType[] values() {
        return (VeLivePlayerDef$VeLivePlayerAudioBufferType[]) f458616a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerAudioBufferType valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerAudioBufferType) r27.a.a(VeLivePlayerDef$VeLivePlayerAudioBufferType.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerAudioBufferType(String r100, int r101) {
        super(r100, r101);
    }
}
