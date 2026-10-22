package z58;

import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w58.b;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x58.a f570115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f570116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f570117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f570118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f570119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f570120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f570121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f570122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f570123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f570124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f570125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f570126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f570127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f570128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f570129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f570130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f570131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f570132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f570133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f570134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f570135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f570136v;

    /* JADX INFO: renamed from: z58.a$a, reason: collision with other inner class name */
    public static final class C8422a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, false, false, null, null, 0.0f, 0, 0, null, 4194303);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f570115a, r101.f570115a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570116b, r101.f570116b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570117c, r101.f570117c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f570118d, r101.f570118d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f570119e, r101.f570119e) == true) goto L24;
        return false;
    L24:
        if (this.f570120f == r101.f570120f) goto L27;
        return false;
    L27:
        if (this.f570121g == r101.f570121g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f570122h, r101.f570122h) == true) goto L33;
        return false;
    L33:
        if (this.f570123i == r101.f570123i) goto L36;
        return false;
    L36:
        if (this.f570124j == r101.f570124j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f570125k, r101.f570125k) == true) goto L42;
        return false;
    L42:
        if (this.f570126l == r101.f570126l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f570127m, r101.f570127m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f570128n, r101.f570128n) == true) goto L51;
        return false;
    L51:
        if (Float.compare(this.f570129o, r101.f570129o) == 0) goto L54;
        return false;
    L54:
        if (this.f570130p == r101.f570130p) goto L57;
        return false;
    L57:
        if (this.f570131q == r101.f570131q) goto L60;
        return false;
    L60:
        if (this.f570132r == r101.f570132r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f570133s, r101.f570133s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f570134t, r101.f570134t) == true) goto L69;
        return false;
    L69:
        if (this.f570135u == r101.f570135u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f570136v, r101.f570136v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        x58.a r100 = this.f570115a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((((r102 * 31) + this.f570116b.hashCode()) * 31) + this.f570117c.hashCode()) * 31) + this.f570118d.hashCode()) * 31) + this.f570119e.hashCode()) * 31;
        int r104 = 1231;
        if (this.f570120f == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f570121g) * 31) + this.f570122h.hashCode()) * 31;
        if (this.f570123i == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f570124j == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((r108 + r109) * 31) + this.f570125k.hashCode()) * 31;
        if (this.f570126l == true) goto L22;
        r104 = 1237;
    L22:
        int r111 = (r110 + r104) * 31;
        Map<String, String> r112 = this.f570127m;
        if (r112 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (((((((((((((((((r111 + r113) * 31) + this.f570128n.hashCode()) * 31) + Float.floatToIntBits(this.f570129o)) * 31) + this.f570130p) * 31) + this.f570131q) * 31) + this.f570132r) * 31) + this.f570133s.hashCode()) * 31) + this.f570134t.hashCode()) * 31) + this.f570135u) * 31;
        String r115 = this.f570136v;
        if (r115 == null) goto L31;
        r101 = r115.hashCode();
    L31:
        return r114 + r101;
    L25:
        r113 = r112.hashCode();
        goto L26
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TtsConfig(taskId=" + this.f570116b + ", conversationId=" + this.f570118d + ", messageId=" + this.f570117c + ", styleId=" + this.f570119e + ", payloadChatExtParams=" + this.f570127m + ')';
    }

    public a(x58.a r210, String r211, String r212, String r213, String r214, String r310, boolean r311, boolean r312, Map r313, String r314, float r315, int r316, int r317, String r318, int r319) {
        if ((r319 & 1) == 0) goto L5;
        x58.a r100 = null;
    L6:
        String r101 = "";
        if ((r319 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r319 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r319 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r319 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r319 & 64) == 0) goto L25;
        int r106 = 32000;
    L27:
        if ((r319 & 128) == 0) goto L29;
        String r110 = "";
    L31:
        if ((r319 & 512) == 0) goto L33;
        boolean r111 = false;
    L35:
        if ((r319 & 1024) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r319 & 2048) == 0) goto L41;
        boolean r113 = false;
    L43:
        if ((r319 & 4096) == 0) goto L45;
        Map r114 = null;
    L47:
        if ((r319 & 8192) != 0) goto L51;
        r101 = r314;
    L51:
        if ((r319 & 16384) == 0) goto L53;
        float r107 = 0.0f;
    L55:
        if ((r319 & 32768) == 0) goto L57;
        int r115 = 0;
    L59:
        if ((r319 & 65536) == 0) goto L61;
        int r116 = 0;
    L63:
        if ((r319 & 131072) == 0) goto L65;
        int r215 = 24000;
    L67:
        if ((r319 & 262144) == 0) goto L69;
        String r117 = "pcm";
    L71:
        if ((r319 & 524288) == 0) goto L73;
        String r108 = SliceInitService.DEFAULT_SWITCH;
    L75:
        if ((r319 & 1048576) == 0) goto L77;
        int r216 = 1;
    L79:
        if ((r319 & 2097152) == 0) goto L81;
        String r118 = null;
    L82:
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "messageId");
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "styleId");
        Intrinsics.checkNotNullParameter(r110, "extra");
        Intrinsics.checkNotNullParameter(r112, "payloadSessionExtra");
        Intrinsics.checkNotNullParameter(r101, "audioMetrics");
        Intrinsics.checkNotNullParameter(r117, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r108, "extraJsonConfig");
        super(r117, r108);
        this.f570115a = r100;
        this.f570116b = r102;
        this.f570117c = r103;
        this.f570118d = r104;
        this.f570119e = r105;
        this.f570120f = false;
        this.f570121g = r106;
        this.f570122h = r110;
        this.f570123i = false;
        this.f570124j = r111;
        this.f570125k = r112;
        this.f570126l = r113;
        this.f570127m = r114;
        this.f570128n = r101;
        this.f570129o = r107;
        this.f570130p = r115;
        this.f570131q = r116;
        this.f570132r = r215;
        this.f570133s = r117;
        this.f570134t = r108;
        this.f570135u = r216;
        this.f570136v = r118;
        return;
    L81:
        r118 = r318;
        goto L82
    L77:
        r216 = 0;
        goto L79
    L73:
        r108 = null;
        goto L75
    L69:
        r117 = null;
        goto L71
    L65:
        r215 = 0;
        goto L67
    L61:
        r116 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r107 = r315;
        goto L55
    L45:
        r114 = r313;
        goto L47
    L41:
        r113 = r312;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = r311;
        goto L35
    L29:
        r110 = r310;
        goto L31
    L25:
        r106 = 0;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
