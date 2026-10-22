package com.ss.android.ttve.model;

/* JADX INFO: loaded from: classes38.dex */
public final enum VEAudioDeviceType extends Enum<VEAudioDeviceType> {
    public static final VEAudioDeviceType BLUETOOTH = null;
    public static final VEAudioDeviceType DEFAULT = null;
    public static final VEAudioDeviceType WIRED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEAudioDeviceType[] f449894a = null;

    static {
        VEAudioDeviceType r100 = new VEAudioDeviceType("DEFAULT", 0);
        DEFAULT = r100;
        VEAudioDeviceType r101 = new VEAudioDeviceType("WIRED", 1);
        WIRED = r101;
        VEAudioDeviceType r102 = new VEAudioDeviceType("BLUETOOTH", 2);
        BLUETOOTH = r102;
        f449894a = new VEAudioDeviceType[]{r100, r101, r102};
    }

    public static VEAudioDeviceType[] values() {
        return (VEAudioDeviceType[]) f449894a.clone();
    }

    public static VEAudioDeviceType valueOf(String r100) {
        return (VEAudioDeviceType) r27.a.a(VEAudioDeviceType.class, r100);
    }

    public VEAudioDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
