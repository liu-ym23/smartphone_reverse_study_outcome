package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEQualityScoreType extends Enum<VEQualityScoreType> {
    public static final VEQualityScoreType VQScoreNone = null;
    public static final VEQualityScoreType VQScoreOmni = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEQualityScoreType[] f455636a = null;

    static {
        VEQualityScoreType r100 = new VEQualityScoreType("VQScoreNone", 0);
        VQScoreNone = r100;
        VEQualityScoreType r101 = new VEQualityScoreType("VQScoreOmni", 1);
        VQScoreOmni = r101;
        f455636a = new VEQualityScoreType[]{r100, r101};
    }

    public static VEQualityScoreType[] values() {
        return (VEQualityScoreType[]) f455636a.clone();
    }

    public static VEQualityScoreType valueOf(String r100) {
        return (VEQualityScoreType) r27.a.a(VEQualityScoreType.class, r100);
    }

    public VEQualityScoreType(String r100, int r101) {
        super(r100, r101);
    }
}
