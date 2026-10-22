package pf9;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f528926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f528927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f528928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f528929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f528930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Long> f528931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f528932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f528933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f528934m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f528935n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f528936o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f528922a, r101.f528922a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528923b, r101.f528923b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528924c, r101.f528924c) == true) goto L18;
        return false;
    L18:
        if (this.f528925d == r101.f528925d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528926e, r101.f528926e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528927f, r101.f528927f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f528928g, r101.f528928g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f528929h, r101.f528929h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f528930i, r101.f528930i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f528931j, r101.f528931j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f528932k, r101.f528932k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f528933l, r101.f528933l) == true) goto L45;
        return false;
    L45:
        if (this.f528934m == r101.f528934m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f528935n, r101.f528935n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f528936o, r101.f528936o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f528922a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f528923b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f528924c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f528925d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f528926e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f528927f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f528928g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.f528929h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f528930i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<Long> r128 = this.f528931j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.f528932k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f528933l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        if (this.f528934m == true) goto L54;
        r110 = 1237;
    L54:
        int r137 = (r136 + r110) * 31;
        Map<String, String> r138 = this.f528935n;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        String r141 = this.f528936o;
        if (r141 == null) goto L63;
        r101 = r141.hashCode();
    L63:
        return r140 + r101;
    L57:
        r139 = r138.hashCode();
        goto L58
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLLMTextContent(content=" + this.f528922a + ", blockContent=" + this.f528923b + ", littleSubtitleContent=" + this.f528924c + ", isBlock=" + this.f528925d + ", seqId=" + this.f528926e + ", messageId=" + this.f528927f + ", conversationId=" + this.f528928g + ", firstTextGenDuration=" + this.f528929h + ", firstTextServSendTs=" + this.f528930i + ", lastVideoFrameTsList=" + this.f528931j + ", vlmReceiveTime=" + this.f528932k + ", vlmFirstTokenTs=" + this.f528933l + ", isPreQuery=" + this.f528934m + ", extra=" + this.f528935n + ", questionId=" + this.f528936o + ')';
    }

    public k0(String r100, String r101, String r102, boolean r103, String r104, String r105, String r106, Long r107, Long r108, List<Long> r110, Long r111, Long r112, boolean r113, Map<String, String> r114, String r115) {
        this.f528922a = r100;
        this.f528923b = r101;
        this.f528924c = r102;
        this.f528925d = r103;
        this.f528926e = r104;
        this.f528927f = r105;
        this.f528928g = r106;
        this.f528929h = r107;
        this.f528930i = r108;
        this.f528931j = r110;
        this.f528932k = r111;
        this.f528933l = r112;
        this.f528934m = r113;
        this.f528935n = r114;
        this.f528936o = r115;
    }
}
