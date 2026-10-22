package y58;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends w58.a {
    public final long A;
    public final String B;
    public x58.a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f566246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f566247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f566248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f566249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f566250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f566251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f566252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f566253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f566254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f566255n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f566256o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f566257p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f566258q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f566259r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f566260s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f566261t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f566262u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f566263v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f566264w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f566265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f566266y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d f566267z;

    /* JADX INFO: renamed from: y58.a$a, reason: collision with other inner class name */
    public static final class C8306a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, null, null, 0, null, 268435455);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f566242a, r101.f566242a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566243b, r101.f566243b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566244c, r101.f566244c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566245d, r101.f566245d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566246e, r101.f566246e) == true) goto L24;
        return false;
    L24:
        if (this.f566247f == r101.f566247f) goto L27;
        return false;
    L27:
        if (this.f566248g == r101.f566248g) goto L30;
        return false;
    L30:
        if (this.f566249h == r101.f566249h) goto L33;
        return false;
    L33:
        if (this.f566250i == r101.f566250i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f566251j, r101.f566251j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f566252k, r101.f566252k) == true) goto L42;
        return false;
    L42:
        if (this.f566253l == r101.f566253l) goto L45;
        return false;
    L45:
        if (this.f566254m == r101.f566254m) goto L48;
        return false;
    L48:
        if (this.f566255n == r101.f566255n) goto L51;
        return false;
    L51:
        if (this.f566256o == r101.f566256o) goto L54;
        return false;
    L54:
        if (this.f566257p == r101.f566257p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f566258q, r101.f566258q) == true) goto L60;
        return false;
    L60:
        if (this.f566259r == r101.f566259r) goto L63;
        return false;
    L63:
        if (this.f566260s == r101.f566260s) goto L66;
        return false;
    L66:
        if (this.f566261t == r101.f566261t) goto L69;
        return false;
    L69:
        if (this.f566262u == r101.f566262u) goto L72;
        return false;
    L72:
        if (this.f566263v == r101.f566263v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f566264w, r101.f566264w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f566265x, r101.f566265x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f566266y, r101.f566266y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f566267z, r101.f566267z) == true) goto L87;
        return false;
    L87:
        if (this.A == r101.A) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f566242a.hashCode() * 31) + this.f566243b.hashCode()) * 31) + this.f566244c.hashCode()) * 31) + this.f566245d.hashCode()) * 31) + this.f566246e.hashCode()) * 31;
        int r101 = 1231;
        if (this.f566247f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f566248g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f566249h == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f566250i == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        Long r110 = this.f566251j;
        int r111 = 0;
        if (r110 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r109 + r112) * 31;
        Long r114 = this.f566252k;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (((((((((((r113 + r115) * 31) + this.f566253l) * 31) + this.f566254m) * 31) + this.f566255n) * 31) + this.f566256o) * 31) + this.f566257p) * 31;
        Boolean r117 = this.f566258q;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (((((r116 + r118) * 31) + this.f566259r) * 31) + this.f566260s) * 31;
        if (this.f566261t == true) goto L34;
        r101 = 1237;
    L34:
        int r120 = (((((((((r119 + r101) * 31) + this.f566262u) * 31) + this.f566263v) * 31) + this.f566264w.hashCode()) * 31) + this.f566265x.hashCode()) * 31;
        String r121 = this.f566266y;
        if (r121 == null) goto L38;
        r111 = r121.hashCode();
    L38:
        int r122 = (((r120 + r111) * 31) + this.f566267z.hashCode()) * 31;
        long r123 = this.A;
        return ((r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31) + this.B.hashCode();
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r110.hashCode();
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrConfig(taskId=" + this.f566243b + ", conversationId=" + this.f566244c + ", language=" + this.f566245d + ", saveAudioFile=" + this.f566250i + ')';
    }

    public final String a() {
        return this.f566266y;
    }

    public final int b() {
        return this.f566259r;
    }

    public final String c() {
        return this.f566244c;
    }

    public final String d() {
        return this.f566246e;
    }

    public final String e() {
        return this.f566243b;
    }

    public final d f() {
        return this.f566267z;
    }

    public a(String r310, String r311, String r312, String r313, String r314, boolean r315, boolean r316, Long r317, Long r410, int r411, int r412, Boolean r413, int r414, int r415, boolean r416, int r417, int r418, String r419, String r510, String r511, d r512, long r513, String r514, int r515) {
        String r100 = "";
        if ((r515 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r515 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r515 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r515 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r515 & 16) != 0) goto L23;
        r100 = r314;
    L23:
        if ((r515 & 32) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r515 & 64) == 0) goto L29;
        boolean r110 = false;
    L31:
        if ((r515 & 128) == 0) goto L33;
        boolean r111 = true;
    L35:
        if ((r515 & 256) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r515 & 512) == 0) goto L41;
        Long r113 = null;
    L43:
        if ((r515 & 1024) == 0) goto L45;
        Long r114 = null;
    L47:
        if ((r515 & 2048) == 0) goto L49;
        int r106 = 1;
    L51:
        if ((r515 & 4096) == 0) goto L53;
        int r115 = 1;
    L55:
        if ((r515 & 8192) == 0) goto L57;
        int r107 = 1;
    L58:
        int r318 = r107;
        if ((r515 & 16384) == 0) goto L61;
        int r108 = 1920000;
    L63:
        if ((r515 & 65536) == 0) goto L65;
        Boolean r116 = null;
    L67:
        if ((r515 & 131072) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r515 & 262144) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r515 & 524288) == 0) goto L77;
        boolean r210 = false;
    L79:
        if ((r515 & 1048576) == 0) goto L81;
        int r211 = 16000;
    L83:
        if ((r515 & 2097152) == 0) goto L85;
        int r212 = 1;
    L87:
        if ((r515 & 4194304) == 0) goto L89;
        String r109 = "pcm";
    L91:
        if ((r515 & 8388608) == 0) goto L93;
        String r119 = SliceInitService.DEFAULT_SWITCH;
    L95:
        if ((r515 & 16777216) == 0) goto L97;
        String r213 = null;
    L99:
        if ((r515 & 33554432) == 0) goto L101;
        d r120 = new d(0);
    L103:
        if ((67108864 & r515) == 0) goto L105;
        long r214 = 500;
    L107:
        if ((r515 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        String r121 = "IM_SAMI";
    L110:
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "conversationId");
        Intrinsics.checkNotNullParameter(r104, "language");
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r109, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r119, "extraJsonConfig");
        Intrinsics.checkNotNullParameter(r120, "traceInfo");
        Intrinsics.checkNotNullParameter(r121, "scene");
        super(r109, r119);
        this.f566242a = r101;
        this.f566243b = r102;
        this.f566244c = r103;
        this.f566245d = r104;
        this.f566246e = r100;
        this.f566247f = r105;
        this.f566248g = r110;
        this.f566249h = r111;
        this.f566250i = r112;
        this.f566251j = r113;
        this.f566252k = r114;
        this.f566253l = r106;
        this.f566254m = r115;
        this.f566255n = r318;
        this.f566256o = r108;
        this.f566257p = 0;
        this.f566258q = r116;
        this.f566259r = r117;
        this.f566260s = r118;
        this.f566261t = r210;
        this.f566262u = r211;
        this.f566263v = r212;
        this.f566264w = r109;
        this.f566265x = r119;
        this.f566266y = r213;
        this.f566267z = r120;
        this.A = r214;
        this.B = r121;
        this.C = h.f512130a;
        return;
    L109:
        r121 = r514;
        goto L110
    L105:
        r214 = r513;
        goto L107
    L101:
        r120 = r512;
        goto L103
    L97:
        r213 = r511;
        goto L99
    L93:
        r119 = r510;
        goto L95
    L89:
        r109 = r419;
        goto L91
    L85:
        r212 = r418;
        goto L87
    L81:
        r211 = r417;
        goto L83
    L77:
        r210 = r416;
        goto L79
    L73:
        r118 = r415;
        goto L75
    L69:
        r117 = r414;
        goto L71
    L65:
        r116 = r413;
        goto L67
    L61:
        r108 = 0;
        goto L63
    L57:
        r107 = 0;
        goto L58
    L53:
        r115 = r412;
        goto L55
    L49:
        r106 = r411;
        goto L51
    L45:
        r114 = r410;
        goto L47
    L41:
        r113 = r317;
        goto L43
    L37:
        r112 = r316;
        goto L39
    L33:
        r111 = false;
        goto L35
    L29:
        r110 = r315;
        goto L31
    L25:
        r105 = false;
        goto L27
    L17:
        r104 = r313;
        goto L19
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }
}
