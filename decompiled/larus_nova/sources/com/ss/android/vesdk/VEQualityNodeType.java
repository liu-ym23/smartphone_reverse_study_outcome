package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEQualityNodeType extends Enum<VEQualityNodeType> {
    public static final VEQualityNodeType ScoreCompile = null;
    public static final VEQualityNodeType ScoreOriginal = null;
    public static final VEQualityNodeType ScoreUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEQualityNodeType[] f455635a = null;

    static {
        VEQualityNodeType r100 = new VEQualityNodeType("ScoreUnknown", 0);
        ScoreUnknown = r100;
        VEQualityNodeType r101 = new VEQualityNodeType("ScoreOriginal", 1);
        ScoreOriginal = r101;
        VEQualityNodeType r102 = new VEQualityNodeType("ScoreCompile", 2);
        ScoreCompile = r102;
        f455635a = new VEQualityNodeType[]{r100, r101, r102};
    }

    public static VEQualityNodeType[] values() {
        return (VEQualityNodeType[]) f455635a.clone();
    }

    public static VEQualityNodeType valueOf(String r100) {
        return (VEQualityNodeType) r27.a.a(VEQualityNodeType.class, r100);
    }

    public VEQualityNodeType(String r100, int r101) {
        super(r100, r101);
    }
}
