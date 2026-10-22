package gm8;

import android.graphics.RectF;
import com.larus.im.bean.message.block.Block;
import fh8.f;
import fh8.g;
import kotlin.jvm.internal.Intrinsics;
import lw8.d;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Block f481735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f481737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f481738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f481739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f481740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f481741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f481742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f481743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f481744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f481745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f481746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f481747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f481748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f481749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f481750p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f481751q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f481752r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f481753s;

    public a() {
        this(null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, false, null, null, 524287);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f481735a, r101.f481735a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481736b, r101.f481736b) == true) goto L15;
        return false;
    L15:
        if (this.f481737c == r101.f481737c) goto L18;
        return false;
    L18:
        if (this.f481738d == r101.f481738d) goto L21;
        return false;
    L21:
        if (this.f481739e == r101.f481739e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f481740f, r101.f481740f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f481741g, r101.f481741g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f481742h, r101.f481742h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f481743i, r101.f481743i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f481744j, r101.f481744j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f481745k, r101.f481745k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f481746l, r101.f481746l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f481747m, r101.f481747m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f481748n, r101.f481748n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f481749o, r101.f481749o) == true) goto L54;
        return false;
    L54:
        if (this.f481750p == r101.f481750p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f481751q, r101.f481751q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f481752r, r101.f481752r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f481753s, r101.f481753s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        Block r100 = this.f481735a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f481736b.hashCode()) * 31;
        int r104 = 1231;
        if (this.f481737c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f481738d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f481739e == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        Integer r111 = this.f481740f;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f481741g;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f481742h;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.f481743i;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        Boolean r123 = this.f481744j;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        Boolean r126 = this.f481745k;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        Boolean r129 = this.f481746l;
        if (r129 != null) goto L45;
        int r130 = 0;
    L46:
        int r131 = (r128 + r130) * 31;
        Boolean r132 = this.f481747m;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f481748n;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f481749o;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        if (this.f481750p == true) goto L62;
        r104 = 1237;
    L62:
        int r141 = (r140 + r104) * 31;
        RectF r142 = this.f481751q;
        if (r142 != null) goto L65;
        int r143 = 0;
    L66:
        int r144 = (r141 + r143) * 31;
        d r145 = this.f481752r;
        if (r145 == null) goto L71;
        r101 = r145.hashCode();
    L71:
        return ((r144 + r101) * 31) + this.f481753s.hashCode();
    L65:
        r143 = r142.hashCode();
        goto L66
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = r129.hashCode();
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
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
        return "MarkdownContainerVMData(block=" + this.f481735a + ", content=" + this.f481736b + ", isLastBlock=" + this.f481737c + ", failOrInterrupt=" + this.f481738d + ", finished=" + this.f481739e + ", textColor=" + this.f481740f + ", textSize=" + this.f481741g + ", lineHeight=" + this.f481742h + ", maxContentWidth=" + this.f481743i + ", disableMargin=" + this.f481744j + ", enableCodeBlockStroke=" + this.f481745k + ", enableCodeBlockHeaderBackground=" + this.f481746l + ", enableTableHeader=" + this.f481747m + ", messageId=" + this.f481748n + ", blockId=" + this.f481749o + ", isDeepThinkArea=" + this.f481750p + ", marginRectF=" + this.f481751q + ", customMarkdownInfo=" + this.f481752r + ", commonInputData=" + this.f481753s + ')';
    }

    public a(Block r210, String r211, boolean r212, boolean r213, boolean r214, Integer r215, Integer r216, Integer r217, Integer r310, Boolean r311, Boolean r312, Boolean r313, Boolean r314, String r315, String r316, boolean r317, RectF r318, d r319, int r410) {
        if ((r410 & 1) == 0) goto L5;
        Block r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = "";
    L10:
        boolean r102 = true;
        if ((r410 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r410 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r410 & 16) != 0) goto L23;
        r102 = r214;
    L23:
        if ((r410 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Integer r110 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Integer r111 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        Integer r112 = 0;
    L39:
        if ((r410 & 512) == 0) goto L41;
        Boolean r113 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Boolean r114 = Boolean.FALSE;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        Boolean r115 = Boolean.FALSE;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        Boolean r106 = null;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        String r218 = r107;
        if ((r410 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        RectF r117 = null;
    L71:
        if ((r410 & 131072) == 0) goto L73;
        d r219 = null;
    L75:
        if ((r410 & 262144) == 0) goto L77;
        f r109 = new g().a();
    L78:
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r109, "commonInputData");
        this.f481735a = r100;
        this.f481736b = r101;
        this.f481737c = r103;
        this.f481738d = r104;
        this.f481739e = r102;
        this.f481740f = r105;
        this.f481741g = r110;
        this.f481742h = r111;
        this.f481743i = r112;
        this.f481744j = r113;
        this.f481745k = r114;
        this.f481746l = r115;
        this.f481747m = r106;
        this.f481748n = r218;
        this.f481749o = r108;
        this.f481750p = r116;
        this.f481751q = r117;
        this.f481752r = r219;
        this.f481753s = r109;
        return;
    L77:
        r109 = null;
        goto L78
    L73:
        r219 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r107 = r315;
        goto L58
    L53:
        r106 = r314;
        goto L55
    L49:
        r115 = r313;
        goto L51
    L45:
        r114 = r312;
        goto L47
    L41:
        r113 = r311;
        goto L43
    L37:
        r112 = r310;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}
