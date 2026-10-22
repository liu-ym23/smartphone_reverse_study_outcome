package kc8;

import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class v0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f502580p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f502581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f502582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f502583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f502584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f502585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f502586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f502587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<ow8.a, Unit> f502588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final bc8.b f502589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<ow8.a, Unit> f502590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<ow8.a, Unit> f502591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final jh8.b f502592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final lw8.d f502593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f502594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final jh8.a f502595o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f502596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f502597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f502598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f502599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f502600e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f502601f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public RectF f502602g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Function1<? super ow8.a, Unit> f502603h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public bc8.b f502604i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Function1<? super ow8.a, Unit> f502605j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Function1<? super ow8.a, Unit> f502606k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public jh8.a f502607l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public lw8.d f502608m;

        public a() {
        }

        public final v0 a() {
            Boolean r100 = this.f502596a;
            Integer r101 = this.f502597b;
            boolean r102 = this.f502598c;
            boolean r103 = this.f502599d;
            Boolean r104 = this.f502600e;
            Boolean r105 = this.f502601f;
            RectF r106 = this.f502602g;
            Function1<? super ow8.a, Unit> r107 = this.f502603h;
            bc8.b r110 = this.f502604i;
            Function1<? super ow8.a, Unit> r111 = this.f502605j;
            Function1<? super ow8.a, Unit> r112 = this.f502606k;
            jh8.a r108 = this.f502607l;
            return new v0(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, null, this.f502608m, null, r108, 32768);
        }
    }

    public static final class b {
    }

    static {
    }

    public v0(Boolean r110, Integer r210, boolean r211, boolean r212, Boolean r213, Boolean r214, RectF r215, Function1 r216, bc8.b r217, Function1 r218, Function1 r219, jh8.b r310, lw8.d r311, Boolean r312, jh8.a r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        Boolean r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Integer r101 = null;
    L10:
        boolean r102 = false;
        if ((r314 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r314 & 8) != 0) goto L19;
        r102 = r212;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Boolean r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        RectF r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Function1 r111 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        bc8.b r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Function1 r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Function1 r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        jh8.b r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        lw8.d r116 = null;
    L55:
        if ((r314 & 32768) == 0) goto L57;
        Boolean r107 = null;
    L59:
        if ((r314 & 65536) == 0) goto L61;
        jh8.a r108 = null;
    L62:
        this.f502581a = r100;
        this.f502582b = r101;
        this.f502583c = r103;
        this.f502584d = r102;
        this.f502585e = r104;
        this.f502586f = r105;
        this.f502587g = r106;
        this.f502588h = r111;
        this.f502589i = r112;
        this.f502590j = r113;
        this.f502591k = r114;
        this.f502592l = r115;
        this.f502593m = r116;
        this.f502594n = r107;
        this.f502595o = r108;
        return;
    L61:
        r108 = r313;
        goto L62
    L57:
        r107 = r312;
        goto L59
    L53:
        r116 = r311;
        goto L55
    L49:
        r115 = r310;
        goto L51
    L45:
        r114 = r219;
        goto L47
    L41:
        r113 = r218;
        goto L43
    L37:
        r112 = r217;
        goto L39
    L33:
        r111 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L13:
        r103 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
