package com.caverock.androidsvg;

/* JADX INFO: loaded from: classes22.dex */
public final class PreserveAspectRatio {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PreserveAspectRatio f272750c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PreserveAspectRatio f272751d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Alignment f272752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scale f272753b;

    public static final enum Alignment extends Enum<Alignment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Alignment[] f272754a = null;
        public static final Alignment none = null;
        public static final Alignment xMaxYMax = null;
        public static final Alignment xMaxYMid = null;
        public static final Alignment xMaxYMin = null;
        public static final Alignment xMidYMax = null;
        public static final Alignment xMidYMid = null;
        public static final Alignment xMidYMin = null;
        public static final Alignment xMinYMax = null;
        public static final Alignment xMinYMid = null;
        public static final Alignment xMinYMin = null;

        static {
            Alignment r100 = new Alignment("none", 0);
            none = r100;
            Alignment r101 = new Alignment("xMinYMin", 1);
            xMinYMin = r101;
            Alignment r102 = new Alignment("xMidYMin", 2);
            xMidYMin = r102;
            Alignment r103 = new Alignment("xMaxYMin", 3);
            xMaxYMin = r103;
            Alignment r104 = new Alignment("xMinYMid", 4);
            xMinYMid = r104;
            Alignment r105 = new Alignment("xMidYMid", 5);
            xMidYMid = r105;
            Alignment r110 = new Alignment("xMaxYMid", 6);
            xMaxYMid = r110;
            Alignment r111 = new Alignment("xMinYMax", 7);
            xMinYMax = r111;
            Alignment r112 = new Alignment("xMidYMax", 8);
            xMidYMax = r112;
            Alignment r113 = new Alignment("xMaxYMax", 9);
            xMaxYMax = r113;
            f272754a = new Alignment[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static Alignment[] values() {
            return (Alignment[]) f272754a.clone();
        }

        public static Alignment valueOf(String r100) {
            return (Alignment) r27.a.a(Alignment.class, r100);
        }

        public Alignment(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Scale extends Enum<Scale> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scale[] f272755a = null;
        public static final Scale meet = null;
        public static final Scale slice = null;

        static {
            Scale r100 = new Scale("meet", 0);
            meet = r100;
            Scale r101 = new Scale("slice", 1);
            slice = r101;
            f272755a = new Scale[]{r100, r101};
        }

        public static Scale[] values() {
            return (Scale[]) f272755a.clone();
        }

        public static Scale valueOf(String r100) {
            return (Scale) r27.a.a(Scale.class, r100);
        }

        public Scale(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f272750c = new PreserveAspectRatio(Alignment.none, null);
        f272751d = new PreserveAspectRatio(Alignment.xMidYMid, Scale.meet);
        Alignment r100 = Alignment.none;
        Alignment r101 = Alignment.none;
        Alignment r102 = Alignment.none;
        Alignment r103 = Alignment.none;
        Scale r104 = Scale.meet;
    }

    public final String toString() {
        return this.f272752a + " " + this.f272753b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (PreserveAspectRatio.class == r100.getClass()) goto L11;
        return false;
    L11:
        PreserveAspectRatio r101 = (PreserveAspectRatio) r100;
        if (this.f272752a == r101.f272752a) goto L14;
    L16:
        return false;
    L14:
        if (this.f272753b != r101.f272753b) goto L16;
        return true;
    }

    public PreserveAspectRatio(Alignment r100, Scale r101) {
        this.f272752a = r100;
        this.f272753b = r101;
    }
}
