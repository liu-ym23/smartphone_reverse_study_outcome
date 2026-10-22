package com.bytedance.lighten.core;

/* JADX INFO: loaded from: classes20.dex */
public final class CircleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f254601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f254602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f254603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f254604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoundingMethod f254605e;

    public static final enum RoundingMethod extends Enum<RoundingMethod> {
        public static final RoundingMethod BITMAP_ONLY = null;
        public static final RoundingMethod OVERLAY_COLOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RoundingMethod[] f254606a = null;

        static {
            RoundingMethod r100 = new RoundingMethod("OVERLAY_COLOR", 0);
            OVERLAY_COLOR = r100;
            RoundingMethod r101 = new RoundingMethod("BITMAP_ONLY", 1);
            BITMAP_ONLY = r101;
            f254606a = new RoundingMethod[]{r100, r101};
        }

        public static RoundingMethod[] values() {
            return (RoundingMethod[]) f254606a.clone();
        }

        public static RoundingMethod valueOf(String r100) {
            return (RoundingMethod) r27.a.a(RoundingMethod.class, r100);
        }

        public RoundingMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f254607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f254608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f254609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f254610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RoundingMethod f254611e;

        public final CircleOptions a() {
            return new CircleOptions(this);
        }

        public a() {
            this.f254607a = false;
            this.f254608b = 0.0f;
            this.f254609c = 0;
            this.f254610d = 0.0f;
            this.f254611e = RoundingMethod.BITMAP_ONLY;
        }
    }

    public CircleOptions(a r100) {
        this.f254603c = r100.f254607a;
        this.f254601a = r100.f254608b;
        this.f254602b = r100.f254609c;
        this.f254604d = r100.f254610d;
        this.f254605e = r100.f254611e;
    }
}
