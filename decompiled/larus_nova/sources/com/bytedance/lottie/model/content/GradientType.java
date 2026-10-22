package com.bytedance.lottie.model.content;

/* JADX INFO: loaded from: classes21.dex */
public final enum GradientType extends Enum<GradientType> {
    public static final GradientType Linear = null;
    public static final GradientType Radial = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GradientType[] f264455a = null;

    static {
        GradientType r100 = new GradientType("Linear", 0);
        Linear = r100;
        GradientType r101 = new GradientType("Radial", 1);
        Radial = r101;
        f264455a = new GradientType[]{r100, r101};
    }

    public static GradientType[] values() {
        return (GradientType[]) f264455a.clone();
    }

    public static GradientType valueOf(String r100) {
        return (GradientType) r27.a.a(GradientType.class, r100);
    }

    public GradientType(String r100, int r101) {
        super(r100, r101);
    }
}
