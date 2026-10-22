package zp9;

import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.community.impl.adapter.LoadingItemDecoration;
import com.larus.community.impl.detail.StaggeredGridItemDecoration;
import com.larus.platform.api.creation.TabItemInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {
    public final String A;
    public final String B;
    public final String C;
    public final String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f573221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f573222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f573224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f573225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f573226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f573227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f573228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f573229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TabItemInfo f573230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f573231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f573232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f573233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f573234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f573235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f573236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f573237q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f573238r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RecyclerView.ItemDecoration f573239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RecyclerView.ItemDecoration f573240t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f573241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f573242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f573243w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Boolean f573244x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Integer f573245y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Boolean f573246z;

    public f(boolean r310, boolean r311, String r312, boolean r313, g r314, Integer r315, Integer r316, Integer r410, boolean r411, TabItemInfo r412, Integer r413, boolean r414, Integer r415, Integer r416, Integer r417, boolean r418, String r419, boolean r510, StaggeredGridItemDecoration r511, LoadingItemDecoration r512, boolean r513, boolean r514, Integer r515, Boolean r516, Integer r517, Boolean r518, String r519, String r610, String r611, String r612, int r613) {
        if ((r613 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r613 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r613 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r613 & 32) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r613 & 64) == 0) goto L21;
        Integer r110 = null;
    L23:
        if ((r613 & 128) == 0) goto L25;
        Integer r111 = null;
    L27:
        if ((r613 & 256) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r613 & 512) == 0) goto L33;
        TabItemInfo r113 = null;
    L35:
        if ((r613 & 1024) == 0) goto L37;
        Integer r114 = null;
    L39:
        if ((r613 & 2048) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r613 & 4096) == 0) goto L45;
        Integer r104 = null;
    L47:
        if ((r613 & 8192) == 0) goto L49;
        Integer r105 = null;
    L50:
        Integer r317 = r105;
        if ((r613 & 16384) == 0) goto L53;
        Integer r106 = null;
    L55:
        if ((r613 & 32768) == 0) goto L57;
        boolean r116 = true;
    L59:
        if ((r613 & 65536) == 0) goto L61;
        String r210 = null;
    L63:
        if ((r613 & 131072) == 0) goto L65;
        boolean r211 = true;
    L67:
        if ((r613 & 262144) == 0) goto L69;
        StaggeredGridItemDecoration r212 = null;
    L71:
        if ((r613 & 524288) == 0) goto L73;
        LoadingItemDecoration r213 = null;
    L75:
        if ((r613 & 1048576) == 0) goto L77;
        boolean r214 = false;
    L79:
        if ((r613 & 2097152) == 0) goto L81;
        boolean r215 = false;
    L83:
        if ((r613 & 4194304) == 0) goto L85;
        Integer r216 = null;
    L87:
        if ((r613 & 8388608) == 0) goto L89;
        Boolean r217 = Boolean.FALSE;
    L91:
        if ((r613 & 16777216) == 0) goto L93;
        Integer r218 = null;
    L95:
        if ((r613 & 33554432) == 0) goto L97;
        Boolean r219 = Boolean.FALSE;
    L99:
        if ((r613 & 67108864) == 0) goto L101;
        String r107 = "ugc_video";
    L103:
        if ((r613 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L105;
        String r108 = "message_card";
    L107:
        if ((r613 & 268435456) == 0) goto L109;
        String r117 = "ugc_video";
    L111:
        if ((r613 & 536870912) == 0) goto L113;
        String r109 = "immersive_preview";
    L114:
        Intrinsics.checkNotNullParameter(r312, "fpsTrackerTag");
        Intrinsics.checkNotNullParameter(r314, "trackParams");
        Intrinsics.checkNotNullParameter(r107, "videoEngineTag");
        Intrinsics.checkNotNullParameter(r108, "videoEngineSubTag");
        Intrinsics.checkNotNullParameter(r117, "detailVideoEngineTag");
        Intrinsics.checkNotNullParameter(r109, "detailVideoEngineSubTag");
        this.f573221a = r100;
        this.f573222b = r101;
        this.f573223c = r312;
        this.f573224d = r102;
        this.f573225e = r314;
        this.f573226f = r103;
        this.f573227g = r110;
        this.f573228h = r111;
        this.f573229i = r112;
        this.f573230j = r113;
        this.f573231k = r114;
        this.f573232l = r115;
        this.f573233m = r104;
        this.f573234n = r317;
        this.f573235o = r106;
        this.f573236p = r116;
        this.f573237q = r210;
        this.f573238r = r211;
        this.f573239s = r212;
        this.f573240t = r213;
        this.f573241u = r214;
        this.f573242v = r215;
        this.f573243w = r216;
        this.f573244x = r217;
        this.f573245y = r218;
        this.f573246z = r219;
        this.A = r107;
        this.B = r108;
        this.C = r117;
        this.D = r109;
        return;
    L113:
        r109 = r612;
        goto L114
    L109:
        r117 = r611;
        goto L111
    L105:
        r108 = r610;
        goto L107
    L101:
        r107 = r519;
        goto L103
    L97:
        r219 = r518;
        goto L99
    L93:
        r218 = r517;
        goto L95
    L89:
        r217 = r516;
        goto L91
    L85:
        r216 = r515;
        goto L87
    L81:
        r215 = r514;
        goto L83
    L77:
        r214 = r513;
        goto L79
    L73:
        r213 = r512;
        goto L75
    L69:
        r212 = r511;
        goto L71
    L65:
        r211 = r510;
        goto L67
    L61:
        r210 = r419;
        goto L63
    L57:
        r116 = r418;
        goto L59
    L53:
        r106 = r417;
        goto L55
    L49:
        r105 = r416;
        goto L50
    L45:
        r104 = r415;
        goto L47
    L41:
        r115 = r414;
        goto L43
    L37:
        r114 = r413;
        goto L39
    L33:
        r113 = r412;
        goto L35
    L29:
        r112 = r411;
        goto L31
    L25:
        r111 = r410;
        goto L27
    L21:
        r110 = r316;
        goto L23
    L17:
        r103 = r315;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
