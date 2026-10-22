package x58;

import com.heytap.mcssdk.constant.b;
import com.larus.audio.j;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f562527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f562530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f562531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f562532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f562533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f562534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f562535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f562536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f562537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AudioRetransmitStrategy f562538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f562539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f562540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f562541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<? super String, String> f562542p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f562543q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f562544r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f562545s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f562546t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f562547u;

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r210, String r211, String r212, String r213, String r214, String r215, int r216, String r310, Integer r311, String r312, int r313, AudioRetransmitStrategy r314, boolean r315, boolean r316, j r317, Integer r318, boolean r319, boolean r410, boolean r411, boolean r412, int r413) {
        String r100 = "";
        if ((r413 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r413 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r413 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r413 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r413 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r413 & 32) != 0) goto L27;
        r100 = r215;
    L27:
        if ((r413 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r413 & 128) == 0) goto L33;
        String r110 = "flowV2";
    L34:
        t78.a r111 = null;
        Object[] r112 = 0;
        if ((r413 & 256) == 0) goto L37;
        Integer r113 = null;
    L39:
        if ((r413 & 1024) == 0) goto L41;
        int r114 = 10000;
    L42:
        int r115 = 1;
        if ((r413 & 2048) == 0) goto L45;
        AudioRetransmitStrategy r116 = new AudioRetransmitStrategy(r111, r115, r112 == true ? 1 : 0);
    L47:
        if ((r413 & 4096) == 0) goto L49;
        boolean r107 = false;
    L51:
        if ((r413 & 8192) == 0) goto L53;
        boolean r117 = false;
    L55:
        if ((r413 & 16384) == 0) goto L57;
        boolean r118 = true;
    L59:
        if ((r413 & 32768) == 0) goto L61;
        j r119 = null;
    L63:
        if ((r413 & 65536) == 0) goto L65;
        Integer r120 = null;
    L67:
        if ((r413 & 131072) == 0) goto L69;
        boolean r121 = false;
    L71:
        if ((r413 & 262144) == 0) goto L73;
        boolean r217 = false;
    L75:
        if ((r413 & 524288) == 0) goto L77;
        boolean r218 = false;
    L79:
        if ((r413 & 1048576) == 0) goto L81;
        boolean r122 = false;
    L82:
        Intrinsics.checkNotNullParameter(r101, b.f276376z);
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "header");
        Intrinsics.checkNotNullParameter(r104, "uid");
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r100, "appVersion");
        Intrinsics.checkNotNullParameter(r110, "businessInfo");
        Intrinsics.checkNotNullParameter(r116, "retransmitStrategy");
        this.f562527a = r101;
        this.f562528b = r102;
        this.f562529c = r103;
        this.f562530d = r104;
        this.f562531e = r105;
        this.f562532f = r100;
        this.f562533g = r106;
        this.f562534h = r110;
        this.f562535i = r113;
        this.f562536j = r312;
        this.f562537k = r114;
        this.f562538l = r116;
        this.f562539m = r107;
        this.f562540n = r117;
        this.f562541o = r118;
        this.f562542p = r119;
        this.f562543q = r120;
        this.f562544r = r121;
        this.f562545s = r217;
        this.f562546t = r218;
        this.f562547u = r122;
        return;
    L81:
        r122 = r412;
        goto L82
    L77:
        r218 = r411;
        goto L79
    L73:
        r217 = r410;
        goto L75
    L69:
        r121 = r319;
        goto L71
    L65:
        r120 = r318;
        goto L67
    L61:
        r119 = r317;
        goto L63
    L57:
        r118 = false;
        goto L59
    L53:
        r117 = r316;
        goto L55
    L49:
        r107 = r315;
        goto L51
    L45:
        r116 = r314;
        goto L47
    L41:
        r114 = r313;
        goto L42
    L37:
        r113 = r311;
        goto L39
    L33:
        r110 = r310;
        goto L34
    L29:
        r106 = r216;
        goto L31
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
        r101 = r210;
        goto L7
    }
}
