package com.bytedance.lynx.webview.preparation;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import l17.m;

/* JADX INFO: loaded from: classes21.dex */
public final class PrepareInfoNG extends f17.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f265395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f265396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f265397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f265398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f265399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f265400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PreparePhase f265401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f265402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f265403k;

    public static final enum PreparePhase extends Enum<PreparePhase> {
        public static final PreparePhase COMPILED = null;
        public static final PreparePhase DECOMPRESSED = null;
        public static final PreparePhase DOWNLOADED = null;
        public static final PreparePhase NOT_STARTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PreparePhase[] f265404a = null;

        static {
            PreparePhase r100 = new PreparePhase("NOT_STARTED", 0);
            NOT_STARTED = r100;
            PreparePhase r101 = new PreparePhase("DOWNLOADED", 1);
            DOWNLOADED = r101;
            PreparePhase r102 = new PreparePhase("DECOMPRESSED", 2);
            DECOMPRESSED = r102;
            PreparePhase r103 = new PreparePhase("COMPILED", 3);
            COMPILED = r103;
            f265404a = new PreparePhase[]{r100, r101, r102, r103};
        }

        public static PreparePhase[] values() {
            return (PreparePhase[]) f265404a.clone();
        }

        public static PreparePhase valueOf(String r100) {
            return (PreparePhase) r27.a.a(PreparePhase.class, r100);
        }

        public PreparePhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final PreparePhase f() {
        if (b() == false) goto L7;
        return PreparePhase.COMPILED;
    L7:
        if (new PolarisFileWrapper(m.g(this.f475075b)).exists() == true) goto L9;
        PolarisFileWrapper r100 = new PolarisFileWrapper(m.m(this.f475075b));
        boolean r101 = j17.b.a().f496867a.getString("downloaded_so_md5", "").equals(this.f475075b);
        if (r100.exists() == false) goto L14;
        if (r101 == false) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L19;
        return PreparePhase.DOWNLOADED;
    L19:
        return PreparePhase.NOT_STARTED;
    L14:
        r102 = false;
        goto L15
    L9:
        return PreparePhase.DECOMPRESSED;
    }

    public PrepareInfoNG(String r100, String r101, String r102, String r103) {
        super(r100, r101);
        this.f265397e = 0;
        this.f265398f = false;
        this.f265399g = false;
        this.f265400h = 0;
        this.f265401i = PreparePhase.COMPILED;
        this.f265402j = 0;
        this.f265403k = "";
        this.f265395c = r102;
        this.f265396d = r103;
    }
}
