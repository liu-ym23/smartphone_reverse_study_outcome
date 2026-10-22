package com.ss.android.vesdk.constants;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VERotation extends Enum<VERotation> {
    public static final VERotation Rotation_0 = null;
    public static final VERotation Rotation_180 = null;
    public static final VERotation Rotation_270 = null;
    public static final VERotation Rotation_90 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VERotation[] f455762a = null;

    static {
        VERotation r100 = new VERotation("Rotation_0", 0);
        Rotation_0 = r100;
        VERotation r101 = new VERotation("Rotation_90", 1);
        Rotation_90 = r101;
        VERotation r102 = new VERotation("Rotation_180", 2);
        Rotation_180 = r102;
        VERotation r103 = new VERotation("Rotation_270", 3);
        Rotation_270 = r103;
        f455762a = new VERotation[]{r100, r101, r102, r103};
    }

    public static VERotation[] values() {
        return (VERotation[]) f455762a.clone();
    }

    public static VERotation valueOf(String r100) {
        return (VERotation) a.a(VERotation.class, r100);
    }

    public VERotation(String r100, int r101) {
        super(r100, r101);
    }
}
