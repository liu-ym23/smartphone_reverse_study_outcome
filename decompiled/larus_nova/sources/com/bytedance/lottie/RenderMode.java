package com.bytedance.lottie;

/* JADX INFO: loaded from: classes21.dex */
public final enum RenderMode extends Enum<RenderMode> {
    public static final RenderMode AUTOMATIC = null;
    public static final RenderMode HARDWARE = null;
    public static final RenderMode SOFTWARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderMode[] f264421a = null;

    static {
        RenderMode r100 = new RenderMode("AUTOMATIC", 0);
        AUTOMATIC = r100;
        RenderMode r101 = new RenderMode("HARDWARE", 1);
        HARDWARE = r101;
        RenderMode r102 = new RenderMode("SOFTWARE", 2);
        SOFTWARE = r102;
        f264421a = new RenderMode[]{r100, r101, r102};
    }

    public static RenderMode[] values() {
        return (RenderMode[]) f264421a.clone();
    }

    public static RenderMode valueOf(String r100) {
        return (RenderMode) r27.a.a(RenderMode.class, r100);
    }

    public RenderMode(String r100, int r101) {
        super(r100, r101);
    }
}
