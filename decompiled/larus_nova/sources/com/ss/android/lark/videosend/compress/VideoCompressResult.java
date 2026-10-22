package com.ss.android.lark.videosend.compress;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoCompressResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultType f444892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f444893b;

    public static final enum ResultType extends Enum<ResultType> {
        public static final ResultType ENCODE = null;
        public static final ResultType MUXER = null;
        public static final ResultType RAW = null;
        public static final ResultType REUSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResultType[] f444894a = null;
        private final String value;

        static {
            ResultType r100 = new ResultType("RAW", 0, "RAW");
            RAW = r100;
            ResultType r101 = new ResultType("REUSE", 1, "REUSE");
            REUSE = r101;
            ResultType r102 = new ResultType("MUXER", 2, "MUXER");
            MUXER = r102;
            ResultType r103 = new ResultType("ENCODE", 3, "ENCODE");
            ENCODE = r103;
            f444894a = new ResultType[]{r100, r101, r102, r103};
        }

        public static ResultType[] values() {
            return (ResultType[]) f444894a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static ResultType valueOf(String r100) {
            return (ResultType) r27.a.a(ResultType.class, r100);
        }

        public ResultType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f444895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f444896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f444897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f444898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f444899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f444900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f444901g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f444902h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f444903i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f444904j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f444905k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f444906l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f444907m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f444908n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f444909o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f444910p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f444911q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f444912r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f444913s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f444914t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f444915u;

        public a() {
            this.f444897c = "";
            this.f444898d = "";
            this.f444899e = "";
            this.f444903i = "";
            this.f444906l = "";
            this.f444908n = "";
            this.f444913s = "";
            this.f444914t = "";
        }
    }

    public final a a() {
        if (this.f444893b != null) goto L6;
        this.f444893b = new a();
    L6:
        return this.f444893b;
    }

    public VideoCompressResult(ResultType r100) {
        this.f444892a = r100;
    }
}
