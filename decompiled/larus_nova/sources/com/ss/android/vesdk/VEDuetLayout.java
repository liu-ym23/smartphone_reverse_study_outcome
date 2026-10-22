package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEDuetLayout extends Enum<VEDuetLayout> {
    public static final VEDuetLayout VEDuetLayoutGreenScreen = null;
    public static final VEDuetLayout VEDuetLayoutHorizontal = null;
    public static final VEDuetLayout VEDuetLayoutPictureInPicture = null;
    public static final VEDuetLayout VEDuetLayoutUnknown = null;
    public static final VEDuetLayout VEDuetLayoutVertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEDuetLayout[] f455537a = null;

    static {
        VEDuetLayout r100 = new VEDuetLayout("VEDuetLayoutUnknown", 0);
        VEDuetLayoutUnknown = r100;
        VEDuetLayout r101 = new VEDuetLayout("VEDuetLayoutHorizontal", 1);
        VEDuetLayoutHorizontal = r101;
        VEDuetLayout r102 = new VEDuetLayout("VEDuetLayoutVertical", 2);
        VEDuetLayoutVertical = r102;
        VEDuetLayout r103 = new VEDuetLayout("VEDuetLayoutPictureInPicture", 3);
        VEDuetLayoutPictureInPicture = r103;
        VEDuetLayout r104 = new VEDuetLayout("VEDuetLayoutGreenScreen", 4);
        VEDuetLayoutGreenScreen = r104;
        f455537a = new VEDuetLayout[]{r100, r101, r102, r103, r104};
    }

    public static VEDuetLayout[] values() {
        return (VEDuetLayout[]) f455537a.clone();
    }

    public static VEDuetLayout valueOf(String r100) {
        return (VEDuetLayout) r27.a.a(VEDuetLayout.class, r100);
    }

    public VEDuetLayout(String r100, int r101) {
        super(r100, r101);
    }
}
