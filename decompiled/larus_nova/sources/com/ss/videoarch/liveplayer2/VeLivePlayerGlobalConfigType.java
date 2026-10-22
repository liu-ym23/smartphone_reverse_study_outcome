package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerGlobalConfigType extends Enum<VeLivePlayerGlobalConfigType> {
    public static final VeLivePlayerGlobalConfigType VeLivePlayerGlobalConfigTypeApp = null;
    public static final VeLivePlayerGlobalConfigType VeLivePlayerGlobalConfigTypeDolphin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerGlobalConfigType[] f459685a = null;

    static {
        VeLivePlayerGlobalConfigType r100 = new VeLivePlayerGlobalConfigType("VeLivePlayerGlobalConfigTypeApp", 0);
        VeLivePlayerGlobalConfigTypeApp = r100;
        VeLivePlayerGlobalConfigType r101 = new VeLivePlayerGlobalConfigType("VeLivePlayerGlobalConfigTypeDolphin", 1);
        VeLivePlayerGlobalConfigTypeDolphin = r101;
        f459685a = new VeLivePlayerGlobalConfigType[]{r100, r101};
    }

    public static VeLivePlayerGlobalConfigType[] values() {
        return (VeLivePlayerGlobalConfigType[]) f459685a.clone();
    }

    public static VeLivePlayerGlobalConfigType valueOf(String r100) {
        return (VeLivePlayerGlobalConfigType) r27.a.a(VeLivePlayerGlobalConfigType.class, r100);
    }

    public VeLivePlayerGlobalConfigType(String r100, int r101) {
        super(r100, r101);
    }
}
