package xra;

import com.ss.android.ainote.model.AINoteBlockStatus;
import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.t;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f564896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f564897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AINoteCreateSource f564898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RichText f564899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f564900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RichText f564901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f564902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<b> f564903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AINoteType f564904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f564905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f564906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f564907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AINoteContentState f564908m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f564909n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f564910o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f564911p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f564912q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f564913r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f564914s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f564915t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AINoteBlockStatus f564916u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f564917v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f564918w;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f564896a == r101.f564896a) goto L12;
        return false;
    L12:
        if (this.f564897b == r101.f564897b) goto L15;
        return false;
    L15:
        if (this.f564898c == r101.f564898c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f564899d, r101.f564899d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f564900e, r101.f564900e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f564901f, r101.f564901f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f564902g, r101.f564902g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f564903h, r101.f564903h) == true) goto L33;
        return false;
    L33:
        if (this.f564904i == r101.f564904i) goto L36;
        return false;
    L36:
        if (this.f564905j == r101.f564905j) goto L39;
        return false;
    L39:
        if (this.f564906k == r101.f564906k) goto L42;
        return false;
    L42:
        if (this.f564907l == r101.f564907l) goto L45;
        return false;
    L45:
        if (this.f564908m == r101.f564908m) goto L48;
        return false;
    L48:
        if (this.f564909n == r101.f564909n) goto L51;
        return false;
    L51:
        if (this.f564910o == r101.f564910o) goto L54;
        return false;
    L54:
        if (this.f564911p == r101.f564911p) goto L57;
        return false;
    L57:
        if (this.f564912q == r101.f564912q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f564913r, r101.f564913r) == true) goto L63;
        return false;
    L63:
        if (this.f564914s == r101.f564914s) goto L66;
        return false;
    L66:
        if (this.f564915t == r101.f564915t) goto L69;
        return false;
    L69:
        if (this.f564916u == r101.f564916u) goto L72;
        return false;
    L72:
        if (this.f564917v == r101.f564917v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f564896a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f564897b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        AINoteCreateSource r104 = this.f564898c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        RichText r108 = this.f564899d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f564900e;
        if (r111 != null) goto L13;
        int r112 = 0;
    L14:
        int r113 = (r110 + r112) * 31;
        RichText r114 = this.f564901f;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f564902g;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (((((r116 + r118) * 31) + this.f564903h.hashCode()) * 31) + this.f564904i.hashCode()) * 31;
        long r120 = this.f564905j;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f564906k;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        long r124 = this.f564907l;
        int r125 = (((r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31) + this.f564908m.hashCode()) * 31;
        int r126 = 1231;
        if (this.f564909n == false) goto L25;
        int r127 = 1231;
    L26:
        int r128 = (r125 + r127) * 31;
        if (this.f564910o == false) goto L29;
        int r129 = 1231;
    L30:
        long r130 = this.f564911p;
        int r131 = (((r128 + r129) * 31) + ((int) (r130 ^ (r130 >>> 32)))) * 31;
        long r132 = this.f564912q;
        int r133 = (r131 + ((int) (r132 ^ (r132 >>> 32)))) * 31;
        String r134 = this.f564913r;
        if (r134 == null) goto L34;
        r105 = r134.hashCode();
    L34:
        long r135 = this.f564914s;
        int r136 = (((r133 + r105) * 31) + ((int) ((r135 >>> 32) ^ r135))) * 31;
        if (this.f564915t == false) goto L37;
        int r137 = 1231;
    L38:
        int r138 = (((r136 + r137) * 31) + this.f564916u.hashCode()) * 31;
        if (this.f564917v == true) goto L43;
        r126 = 1237;
    L43:
        return r138 + r126;
    L37:
        r137 = 1237;
        goto L38
    L29:
        r129 = 1237;
        goto L30
    L25:
        r127 = 1237;
        goto L26
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r112 = r111.hashCode();
        goto L14
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "AINoteBlockModel(cid=" + this.f564896a + ", sid=" + this.f564897b + ", noteSource=" + this.f564898c + ", inputRichText=" + this.f564899d + ", inputMarkdown=" + this.f564900e + ", aiRichText=" + this.f564901f + ", aiMarkdown=" + this.f564902g + ", galleryImages=" + this.f564903h + ", noteType=" + this.f564904i + ", version=" + this.f564905j + ", clientTime=" + this.f564906k + ", serverTime=" + this.f564907l + ", contentState=" + this.f564908m + ", polishEnabled=" + this.f564909n + ", deleted=" + this.f564910o + ", createRelMeetingTime=" + this.f564911p + ", createRelAudioTime=" + this.f564912q + ", markId=" + this.f564913r + ", audioLocationTime=" + this.f564914s + ", aiContentAck=" + this.f564915t + ", status=" + this.f564916u + ", hasRemoteUpdate=" + this.f564917v + ')';
    }

    public final String a() {
        RichText r100 = this.f564901f;
        if (r100 == null) goto L5;
        String r101 = r100.getInnerText();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final long c() {
        long r100 = this.f564897b;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return this.f564896a;
    }

    public final String d() {
        RichText r100 = this.f564899d;
        if (r100 == null) goto L5;
        String r101 = r100.getInnerText();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final void e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (r100.f564896a == this.f564896a) goto L5;
        return;
    L5:
        int r101 = d().length();
        int r102 = r100.d().length();
        if (r101 <= 0) goto L17;
        if (r102 != 0) goto L17;
        String r103 = r100.f564900e;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        int r105 = t.f407207a;
        t.e("AINoteBlockModel", "updateFrom overwrite input to empty? cid=" + this.f564896a + ", oldLen=" + r101 + ", sid=" + r100.f564897b + ", version=" + r100.f564905j);
        goto L17
    L11:
        if (StringsKt.isBlank(r103) == true) goto L14;
        r104 = false;
    L17:
        this.f564897b = r100.f564897b;
        this.f564898c = r100.f564898c;
        this.f564899d = r100.f564899d;
        this.f564900e = r100.f564900e;
        this.f564901f = r100.f564901f;
        this.f564902g = r100.f564902g;
        this.f564903h = r100.f564903h;
        this.f564904i = r100.f564904i;
        this.f564905j = r100.f564905j;
        this.f564906k = r100.f564906k;
        this.f564907l = r100.f564907l;
        this.f564908m = r100.f564908m;
        this.f564909n = r100.f564909n;
        this.f564910o = r100.f564910o;
        this.f564911p = r100.f564911p;
        this.f564912q = r100.f564912q;
        this.f564913r = r100.f564913r;
        this.f564914s = r100.f564914s;
        this.f564915t = r100.f564915t;
        this.f564916u = r100.f564916u;
        this.f564917v = r100.f564917v;
        this.f564918w = r100.f564918w;
    }

    public /* synthetic */ a(long r310, long r311, AINoteCreateSource r410, RichText r411, String r412, RichText r413, String r414, List r415, AINoteType r416, long r417, long r418, long r510, AINoteContentState r511, boolean r512, boolean r513, long r514, long r515, String r610, long r611, boolean r612, AINoteBlockStatus r613, int r614) {
        if ((r614 & 2) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r614 & 4) == 0) goto L9;
        AINoteCreateSource r101 = null;
    L11:
        if ((r614 & 8) == 0) goto L13;
        RichText r110 = null;
    L15:
        if ((r614 & 16) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r614 & 32) == 0) goto L21;
        RichText r112 = null;
    L23:
        if ((r614 & 64) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r614 & 128) == 0) goto L29;
        List r114 = CollectionsKt.emptyList();
    L31:
        if ((r614 & 256) == 0) goto L33;
        AINoteType r115 = AINoteType.REGULAR;
    L35:
        if ((r614 & 512) == 0) goto L37;
        long r116 = 0;
    L39:
        if ((r614 & 1024) == 0) goto L41;
        long r117 = 0;
    L43:
        if ((r614 & 2048) == 0) goto L45;
        long r210 = 0;
    L47:
        if ((r614 & 4096) == 0) goto L49;
        AINoteContentState r211 = AINoteContentState.NO_NEED;
    L51:
        if ((r614 & 8192) == 0) goto L53;
        boolean r212 = false;
    L55:
        if ((r614 & 16384) == 0) goto L57;
        boolean r213 = false;
    L59:
        if ((32768 & r614) == 0) goto L61;
        long r214 = 0;
    L63:
        if ((65536 & r614) == 0) goto L65;
        long r215 = 0;
    L67:
        if ((131072 & r614) == 0) goto L69;
        String r216 = null;
    L71:
        if ((262144 & r614) == 0) goto L73;
        long r312 = 0;
    L75:
        if ((524288 & r614) == 0) goto L77;
        boolean r313 = false;
    L79:
        if ((r614 & 1048576) == 0) goto L81;
        AINoteBlockStatus r314 = AINoteBlockStatus.NORMAL;
    L82:
        this(r310, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r312, r313, r314, false);
        return;
    L81:
        r314 = r613;
        goto L82
    L77:
        r313 = r612;
        goto L79
    L73:
        r312 = r611;
        goto L75
    L69:
        r216 = r610;
        goto L71
    L65:
        r215 = r515;
        goto L67
    L61:
        r214 = r514;
        goto L63
    L57:
        r213 = r513;
        goto L59
    L53:
        r212 = r512;
        goto L55
    L49:
        r211 = r511;
        goto L51
    L45:
        r210 = r510;
        goto L47
    L41:
        r117 = r418;
        goto L43
    L37:
        r116 = r417;
        goto L39
    L33:
        r115 = r416;
        goto L35
    L29:
        r114 = r415;
        goto L31
    L25:
        r113 = r414;
        goto L27
    L21:
        r112 = r413;
        goto L23
    L17:
        r111 = r412;
        goto L19
    L13:
        r110 = r411;
        goto L15
    L9:
        r101 = r410;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    public static a b(a r310, AINoteCreateSource r311, RichText r410, String r411, RichText r412, String r413, List r414, AINoteType r415, long r416, long r417, long r510, AINoteContentState r511, boolean r512, boolean r513, long r514, long r515, String r516, long r610, boolean r611, AINoteBlockStatus r612, boolean r613, int r614) {
        long r100 = 0;
        if ((r614 & 1) == 0) goto L5;
        long r101 = r310.f564896a;
    L7:
        if ((r614 & 2) == 0) goto L9;
        r100 = r310.f564897b;
    L9:
        long r110 = r100;
        if ((r614 & 4) == 0) goto L12;
        AINoteCreateSource r111 = r310.f564898c;
    L14:
        if ((r614 & 8) == 0) goto L16;
        RichText r112 = r310.f564899d;
    L18:
        if ((r614 & 16) == 0) goto L20;
        String r113 = r310.f564900e;
    L22:
        if ((r614 & 32) == 0) goto L24;
        RichText r114 = r310.f564901f;
    L26:
        if ((r614 & 64) == 0) goto L28;
        String r115 = r310.f564902g;
    L30:
        if ((r614 & 128) == 0) goto L32;
        List r102 = r310.f564903h;
    L34:
        if ((r614 & 256) == 0) goto L36;
        AINoteType r103 = r310.f564904i;
    L38:
        if ((r614 & 512) == 0) goto L40;
        long r116 = r310.f564905j;
    L42:
        if ((r614 & 1024) == 0) goto L44;
        long r210 = r310.f564906k;
    L46:
        if ((r614 & 2048) == 0) goto L48;
        long r211 = r310.f564907l;
    L50:
        if ((r614 & 4096) == 0) goto L52;
        AINoteContentState r104 = r310.f564908m;
    L54:
        if ((r614 & 8192) == 0) goto L56;
        boolean r212 = r310.f564909n;
    L58:
        if ((r614 & 16384) == 0) goto L60;
        boolean r213 = r310.f564910o;
    L62:
        if ((32768 & r614) == 0) goto L64;
        long r214 = r310.f564911p;
    L66:
        if ((65536 & r614) == 0) goto L68;
        long r312 = r310.f564912q;
    L70:
        if ((131072 & r614) == 0) goto L72;
        String r313 = r310.f564913r;
    L74:
        if ((262144 & r614) == 0) goto L76;
        long r314 = r310.f564914s;
    L78:
        if ((524288 & r614) == 0) goto L80;
        boolean r315 = r310.f564915t;
    L82:
        if ((1048576 & r614) == 0) goto L84;
        AINoteBlockStatus r105 = r310.f564916u;
    L86:
        if ((r614 & 2097152) == 0) goto L88;
        boolean r316 = r310.f564917v;
    L89:
        r310.getClass();
        Intrinsics.checkNotNullParameter(r102, "galleryImages");
        Intrinsics.checkNotNullParameter(r103, "noteType");
        Intrinsics.checkNotNullParameter(r104, "contentState");
        Intrinsics.checkNotNullParameter(r105, "status");
        return new a(r101, r110, r111, r112, r113, r114, r115, r102, r103, r116, r210, r211, r104, r212, r213, r214, r312, r313, r314, r315, r105, r316);
    L88:
        r316 = r613;
        goto L89
    L84:
        r105 = r612;
        goto L86
    L80:
        r315 = r611;
        goto L82
    L76:
        r314 = r610;
        goto L78
    L72:
        r313 = r516;
        goto L74
    L68:
        r312 = r515;
        goto L70
    L64:
        r214 = r514;
        goto L66
    L60:
        r213 = r513;
        goto L62
    L56:
        r212 = r512;
        goto L58
    L52:
        r104 = r511;
        goto L54
    L48:
        r211 = r510;
        goto L50
    L44:
        r210 = r417;
        goto L46
    L40:
        r116 = r416;
        goto L42
    L36:
        r103 = r415;
        goto L38
    L32:
        r102 = r414;
        goto L34
    L28:
        r115 = r413;
        goto L30
    L24:
        r114 = r412;
        goto L26
    L20:
        r113 = r411;
        goto L22
    L16:
        r112 = r410;
        goto L18
    L12:
        r111 = r311;
        goto L14
    L5:
        r101 = 0;
        goto L7
    }

    public a(long r100, long r110, AINoteCreateSource r111, RichText r112, String r113, RichText r114, String r115, List<b> r116, AINoteType r117, long r118, long r210, long r211, AINoteContentState r212, boolean r213, boolean r214, long r215, long r310, String r311, long r312, boolean r313, AINoteBlockStatus r314, boolean r315) {
        Intrinsics.checkNotNullParameter(r116, "galleryImages");
        Intrinsics.checkNotNullParameter(r117, "noteType");
        Intrinsics.checkNotNullParameter(r212, "contentState");
        Intrinsics.checkNotNullParameter(r314, "status");
        this.f564896a = r100;
        this.f564897b = r110;
        this.f564898c = r111;
        this.f564899d = r112;
        this.f564900e = r113;
        this.f564901f = r114;
        this.f564902g = r115;
        this.f564903h = r116;
        this.f564904i = r117;
        this.f564905j = r118;
        this.f564906k = r210;
        this.f564907l = r211;
        this.f564908m = r212;
        this.f564909n = r213;
        this.f564910o = r214;
        this.f564911p = r215;
        this.f564912q = r310;
        this.f564913r = r311;
        this.f564914s = r312;
        this.f564915t = r313;
        this.f564916u = r314;
        this.f564917v = r315;
    }
}
