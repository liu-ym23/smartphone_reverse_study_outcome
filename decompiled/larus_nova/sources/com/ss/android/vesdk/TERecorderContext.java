package com.ss.android.vesdk;

import java.util.Queue;

/* JADX INFO: loaded from: classes40.dex */
public final class TERecorderContext {
    public boolean A;
    public boolean B;
    public boolean C;
    public MicConfig D;
    public VESize E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f455476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f455477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f455478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Queue<String> f455479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Queue<String> f455480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f455481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f455482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f455483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f455484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f455485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f455486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f455487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f455488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f455489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f455490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f455491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f455492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f455493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f455494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f455495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f455496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f455497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f455498w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f455499x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f455500y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f455501z;

    public static final enum MicConfig extends Enum<MicConfig> {
        public static final MicConfig DEFAULT = null;
        public static final MicConfig DISABLE = null;
        public static final MicConfig ENABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MicConfig[] f455502a = null;

        static {
            MicConfig r100 = new MicConfig("DEFAULT", 0);
            DEFAULT = r100;
            MicConfig r101 = new MicConfig("DISABLE", 1);
            DISABLE = r101;
            MicConfig r102 = new MicConfig("ENABLE", 2);
            ENABLE = r102;
            f455502a = new MicConfig[]{r100, r101, r102};
        }

        public static MicConfig[] values() {
            return (MicConfig[]) f455502a.clone();
        }

        public static MicConfig valueOf(String r100) {
            return (MicConfig) r27.a.a(MicConfig.class, r100);
        }

        public MicConfig(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TERecorderContext() {
        this.f455477b = "";
        this.f455478c = "";
        this.f455481f = 0;
        this.f455482g = VEPreviewSettings.VERecordContentType.RecordFullContent.ordinal();
        this.f455483h = false;
        this.f455484i = false;
        this.f455485j = 1;
        this.f455486k = false;
        this.f455487l = true;
        this.f455488m = false;
        this.f455489n = true;
        this.f455490o = true;
        this.f455491p = false;
        this.f455492q = false;
        this.f455493r = false;
        this.f455494s = false;
        this.f455495t = false;
        this.f455496u = false;
        this.f455497v = false;
        this.f455498w = false;
        this.f455499x = false;
        this.f455500y = true;
        this.f455501z = 0;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = MicConfig.DEFAULT;
        this.E = new VESize(720, 1280);
    }
}
