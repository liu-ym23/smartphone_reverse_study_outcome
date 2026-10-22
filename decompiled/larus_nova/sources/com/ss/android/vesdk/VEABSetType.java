package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEABSetType extends Enum<VEABSetType> {
    public static final VEABSetType VEABSetType_Default = null;
    public static final VEABSetType VEABSetType_MobileEditor = null;
    public static final VEABSetType VEABSetType_MobileEditorv2 = null;
    public static final VEABSetType VEABSetType_MobileQingYan = null;
    public static final VEABSetType VEABSetType_MobileUGC = null;
    public static final VEABSetType VEABSetType_MobileUGCv2 = null;
    public static final VEABSetType VEABSetType_PCEditor = null;
    public static final VEABSetType VEABSetType_PCEditorv2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEABSetType[] f455508a = null;

    static {
        VEABSetType r100 = new VEABSetType("VEABSetType_Default", 0);
        VEABSetType_Default = r100;
        VEABSetType r101 = new VEABSetType("VEABSetType_MobileUGC", 1);
        VEABSetType_MobileUGC = r101;
        VEABSetType r102 = new VEABSetType("VEABSetType_MobileUGCv2", 2);
        VEABSetType_MobileUGCv2 = r102;
        VEABSetType r103 = new VEABSetType("VEABSetType_MobileEditor", 3);
        VEABSetType_MobileEditor = r103;
        VEABSetType r104 = new VEABSetType("VEABSetType_MobileEditorv2", 4);
        VEABSetType_MobileEditorv2 = r104;
        VEABSetType r105 = new VEABSetType("VEABSetType_MobileQingYan", 5);
        VEABSetType_MobileQingYan = r105;
        VEABSetType r110 = new VEABSetType("VEABSetType_PCEditor", 6);
        VEABSetType_PCEditor = r110;
        VEABSetType r111 = new VEABSetType("VEABSetType_PCEditorv2", 7);
        VEABSetType_PCEditorv2 = r111;
        f455508a = new VEABSetType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static VEABSetType[] values() {
        return (VEABSetType[]) f455508a.clone();
    }

    public static VEABSetType valueOf(String r100) {
        return (VEABSetType) r27.a.a(VEABSetType.class, r100);
    }

    public VEABSetType(String r100, int r101) {
        super(r100, r101);
    }
}
