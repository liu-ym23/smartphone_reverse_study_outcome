package ib8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<jc8.a> f489020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f489021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f489022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message f489023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f489024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeepThinkFoldStatus f489025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f489026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f489027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f489028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f489029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f489030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Integer> f489031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f489032m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f489033n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f489034o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f489035p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f489036q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Integer f489037r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer f489038s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f489039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f489040u;

    public c0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f489020a, r101.f489020a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489021b, r101.f489021b) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489022c, r101.f489022c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489023d, r101.f489023d) == true) goto L24;
        return false;
    L24:
        if (this.f489024e == r101.f489024e) goto L27;
        return false;
    L27:
        if (this.f489025f == r101.f489025f) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489026g, r101.f489026g) == true) goto L33;
        return false;
    L33:
        if (this.f489027h == r101.f489027h) goto L36;
        return false;
    L36:
        if (this.f489028i == r101.f489028i) goto L39;
        return false;
    L39:
        if (this.f489029j == r101.f489029j) goto L42;
        return false;
    L42:
        if (this.f489030k == r101.f489030k) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f489031l, r101.f489031l) == true) goto L48;
        return false;
    L48:
        if (this.f489032m == r101.f489032m) goto L51;
        return false;
    L51:
        if (this.f489033n == r101.f489033n) goto L54;
        return false;
    L54:
        if (this.f489034o == r101.f489034o) goto L57;
        return false;
    L57:
        if (this.f489035p == r101.f489035p) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f489036q, r101.f489036q) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f489037r, r101.f489037r) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f489038s, r101.f489038s) == true) goto L69;
        return false;
    L69:
        if (this.f489039t == r101.f489039t) goto L72;
        return false;
    L72:
        if (this.f489040u == r101.f489040u) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        List<jc8.a> r100 = this.f489020a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + 0) * 31;
        d0 r104 = this.f489021b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f489022c.hashCode()) * 31) + this.f489023d.hashCode()) * 31;
        int r107 = 1231;
        if (this.f489024e == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f489025f.hashCode()) * 31;
        Function0<Boolean> r110 = this.f489026g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f489027h == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f489028i == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f489029j == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.f489030k == false) goto L33;
        int r119 = 1231;
    L34:
        int r120 = (((r118 + r119) * 31) + this.f489031l.hashCode()) * 31;
        if (this.f489032m == false) goto L37;
        int r121 = 1231;
    L38:
        int r122 = (r120 + r121) * 31;
        if (this.f489033n == false) goto L41;
        int r123 = 1231;
    L42:
        int r124 = (r122 + r123) * 31;
        if (this.f489034o == false) goto L45;
        int r125 = 1231;
    L46:
        int r126 = (r124 + r125) * 31;
        if (this.f489035p == false) goto L49;
        int r127 = 1231;
    L50:
        int r128 = (r126 + r127) * 31;
        Integer r129 = this.f489036q;
        if (r129 != null) goto L53;
        int r130 = 0;
    L54:
        int r131 = (r128 + r130) * 31;
        Integer r132 = this.f489037r;
        if (r132 != null) goto L57;
        int r133 = 0;
    L58:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.f489038s;
        if (r135 == null) goto L62;
        r101 = r135.hashCode();
    L62:
        int r136 = (r134 + r101) * 31;
        if (this.f489039t == false) goto L65;
        int r137 = 1231;
    L66:
        int r138 = (r136 + r137) * 31;
        if (this.f489040u == true) goto L71;
        r107 = 1237;
    L71:
        return r138 + r107;
    L65:
        r137 = 1237;
        goto L66
    L57:
        r133 = r132.hashCode();
        goto L58
    L53:
        r130 = r129.hashCode();
        goto L54
    L49:
        r127 = 1237;
        goto L50
    L45:
        r125 = 1237;
        goto L46
    L41:
        r123 = 1237;
        goto L42
    L37:
        r121 = 1237;
        goto L38
    L33:
        r119 = 1237;
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FoldContainerVmData(animationBlockList=" + this.f489020a + ", providerBindContext=null, foldOrExpandAnimation=" + this.f489021b + ", headerInfo=" + this.f489022c + ", message=" + this.f489023d + ", isDeepThinkingTyping=" + this.f489024e + ", targetDeepThinkFoldStatus=" + this.f489025f + ", interceptClickCard=" + this.f489026g + ", disableFoldExpandClick=" + this.f489027h + ", thinkContentEmpty=" + this.f489028i + ", needTitleBottomMargin=" + this.f489029j + ", hideReferenceTitleBackground=" + this.f489030k + ", getAttachItemTopMargin=" + this.f489031l + ", forceRefreshContent=" + this.f489032m + ", hasReference=" + this.f489033n + ", showBottomSplitLine=" + this.f489034o + ", headerVisible=" + this.f489035p + ", expandAllDividerColor=" + this.f489036q + ", expandAllMaskRes=" + this.f489037r + ", halfFoldExpandHeight=" + this.f489038s + ", hideExpandAllDivider=" + this.f489039t + ", isCollectionMode=" + this.f489040u + ')';
    }

    public c0(List r210, d0 r211, m r212, Message r213, boolean r214, DeepThinkFoldStatus r215, eb8.v r310, boolean r311, boolean r312, boolean r313, boolean r314, Function0 r315, boolean r316, boolean r317, boolean r318, Integer r319, Integer r410, Integer r411, boolean r412, boolean r413, int r414) {
        if ((r414 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r414 & 4) == 0) goto L9;
        d0 r101 = null;
    L11:
        if ((r414 & 128) == 0) goto L13;
        eb8.v r102 = null;
    L15:
        if ((r414 & 256) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r414 & 512) == 0) goto L21;
        boolean r110 = true;
    L23:
        if ((r414 & 1024) == 0) goto L25;
        boolean r111 = false;
    L27:
        if ((r414 & 2048) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r414 & 4096) == 0) goto L33;
        Function0 r113 = new gw5.d();
    L35:
        if ((r414 & 16384) == 0) goto L37;
        boolean r104 = false;
    L39:
        if ((r414 & 32768) == 0) goto L41;
        boolean r114 = false;
    L43:
        if ((r414 & 65536) == 0) goto L45;
        boolean r115 = true;
    L47:
        if ((r414 & 131072) == 0) goto L49;
        Integer r116 = null;
    L51:
        if ((r414 & 262144) == 0) goto L53;
        Integer r216 = null;
    L55:
        if ((r414 & 524288) == 0) goto L57;
        Integer r217 = null;
    L59:
        if ((r414 & 1048576) == 0) goto L61;
        boolean r218 = false;
    L63:
        if ((r414 & 2097152) == 0) goto L65;
        boolean r105 = false;
    L66:
        Intrinsics.checkNotNullParameter(r212, "headerInfo");
        Intrinsics.checkNotNullParameter(r213, "message");
        Intrinsics.checkNotNullParameter(r215, "targetDeepThinkFoldStatus");
        Intrinsics.checkNotNullParameter(r113, "getAttachItemTopMargin");
        this.f489020a = r100;
        this.f489021b = r101;
        this.f489022c = r212;
        this.f489023d = r213;
        this.f489024e = r214;
        this.f489025f = r215;
        this.f489026g = r102;
        this.f489027h = r103;
        this.f489028i = r110;
        this.f489029j = r111;
        this.f489030k = r112;
        this.f489031l = r113;
        this.f489032m = false;
        this.f489033n = r104;
        this.f489034o = r114;
        this.f489035p = r115;
        this.f489036q = r116;
        this.f489037r = r216;
        this.f489038s = r217;
        this.f489039t = r218;
        this.f489040u = r105;
        return;
    L65:
        r105 = r413;
        goto L66
    L61:
        r218 = r412;
        goto L63
    L57:
        r217 = r411;
        goto L59
    L53:
        r216 = r410;
        goto L55
    L49:
        r116 = r319;
        goto L51
    L45:
        r115 = r318;
        goto L47
    L41:
        r114 = r317;
        goto L43
    L37:
        r104 = r316;
        goto L39
    L33:
        r113 = r315;
        goto L35
    L29:
        r112 = r314;
        goto L31
    L25:
        r111 = r313;
        goto L27
    L21:
        r110 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
