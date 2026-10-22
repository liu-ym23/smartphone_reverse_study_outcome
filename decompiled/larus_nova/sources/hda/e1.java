package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryDataReviewModuleKey f484656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f484660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f484661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f484662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f484663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<h0> f484664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<d> f484665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<String> f484666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f484667m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f484668n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f484669o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f484670p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f484671q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<e1> f484672r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f484673s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f484674t;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r101 = (e1) r100;
        if (Intrinsics.areEqual(this.f484655a, r101.f484655a) == true) goto L12;
        return false;
    L12:
        if (this.f484656b == r101.f484656b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484657c, r101.f484657c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484658d, r101.f484658d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f484659e, r101.f484659e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f484660f, r101.f484660f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f484661g, r101.f484661g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f484662h, r101.f484662h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f484663i, r101.f484663i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f484664j, r101.f484664j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f484665k, r101.f484665k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f484666l, r101.f484666l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f484667m, r101.f484667m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f484668n, r101.f484668n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f484669o, r101.f484669o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f484670p, r101.f484670p) == true) goto L57;
        return false;
    L57:
        if (this.f484671q == r101.f484671q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f484672r, r101.f484672r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f484673s, r101.f484673s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f484674t, r101.f484674t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f484655a.hashCode() * 31) + this.f484656b.hashCode()) * 31) + this.f484657c.hashCode()) * 31) + this.f484658d.hashCode()) * 31) + this.f484659e.hashCode()) * 31;
        String r101 = this.f484660f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f484661g.hashCode()) * 31;
        String r105 = this.f484662h;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f484663i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((((r107 + r109) * 31) + this.f484664j.hashCode()) * 31) + this.f484665k.hashCode()) * 31) + this.f484666l.hashCode()) * 31;
        String r111 = this.f484667m;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f484668n;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f484669o;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f484670p;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((((((r119 + r121) * 31) + this.f484671q) * 31) + this.f484672r.hashCode()) * 31) + this.f484673s.hashCode()) * 31;
        String r123 = this.f484674t;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewUiModel(recordId=" + this.f484655a + ", module=" + this.f484656b + ", title=" + this.f484657c + ", summary=" + this.f484658d + ", previewText=" + this.f484659e + ", sourceEntityId=" + this.f484660f + ", timeLabel=" + this.f484661g + ", sourceAppName=" + this.f484662h + ", sourceAppPackageName=" + this.f484663i + ", imageRefs=" + this.f484664j + ", chatBubbles=" + this.f484665k + ", sourceTexts=" + this.f484666l + ", currentText=" + this.f484667m + ", oldText=" + this.f484668n + ", diffCurrentText=" + this.f484669o + ", diffOldText=" + this.f484670p + ", updateCount=" + this.f484671q + ", versions=" + this.f484672r + ", displayedCardJson=" + this.f484673s + ", traceJson=" + this.f484674t + ')';
    }

    public static e1 a(e1 r210, String r211, String r212, String r213, List r214, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r210.f484655a;
    L7:
        if ((r310 & 2) == 0) goto L9;
        MemoryDataReviewModuleKey r101 = r210.f484656b;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r210.f484657c;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r210.f484658d;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r210.f484659e;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r110 = r210.f484660f;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r111 = r210.f484661g;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r112 = r210.f484662h;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r113 = r210.f484663i;
    L39:
        if ((r310 & 512) == 0) goto L41;
        List<h0> r114 = r210.f484664j;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        List<d> r115 = r210.f484665k;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        List<String> r105 = r210.f484666l;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r116 = r210.f484667m;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r117 = r210.f484668n;
    L59:
        if ((r310 & 16384) == 0) goto L61;
        String r118 = r210.f484669o;
    L63:
        if ((32768 & r310) == 0) goto L65;
        String r215 = r210.f484670p;
    L67:
        if ((65536 & r310) == 0) goto L69;
        int r216 = r210.f484671q;
    L71:
        if ((131072 & r310) == 0) goto L73;
        List r106 = r210.f484672r;
    L75:
        if ((r310 & 262144) == 0) goto L77;
        String r107 = r210.f484673s;
    L79:
        if ((r310 & 524288) == 0) goto L81;
        String r217 = r210.f484674t;
    L82:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "summary");
        Intrinsics.checkNotNullParameter(r104, "previewText");
        Intrinsics.checkNotNullParameter(r111, "timeLabel");
        Intrinsics.checkNotNullParameter(r114, "imageRefs");
        Intrinsics.checkNotNullParameter(r115, "chatBubbles");
        Intrinsics.checkNotNullParameter(r105, "sourceTexts");
        Intrinsics.checkNotNullParameter(r106, "versions");
        Intrinsics.checkNotNullParameter(r107, "displayedCardJson");
        List<String> r119 = r105;
        return new e1(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r119, r116, r117, r118, r215, r216, r106, r107, r217);
    L81:
        r217 = null;
        goto L82
    L77:
        r107 = null;
        goto L79
    L73:
        r106 = r214;
        goto L75
    L69:
        r216 = 0;
        goto L71
    L65:
        r215 = null;
        goto L67
    L61:
        r118 = null;
        goto L63
    L57:
        r117 = null;
        goto L59
    L53:
        r116 = r213;
        goto L55
    L49:
        r105 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public e1(String r110, MemoryDataReviewModuleKey r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, List<h0> r213, List<d> r214, List<String> r215, String r216, String r217, String r218, String r219, int r310, List<e1> r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r110, "recordId");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r113, "summary");
        Intrinsics.checkNotNullParameter(r114, "previewText");
        Intrinsics.checkNotNullParameter(r210, "timeLabel");
        Intrinsics.checkNotNullParameter(r213, "imageRefs");
        Intrinsics.checkNotNullParameter(r214, "chatBubbles");
        Intrinsics.checkNotNullParameter(r215, "sourceTexts");
        Intrinsics.checkNotNullParameter(r311, "versions");
        Intrinsics.checkNotNullParameter(r312, "displayedCardJson");
        this.f484655a = r110;
        this.f484656b = r111;
        this.f484657c = r112;
        this.f484658d = r113;
        this.f484659e = r114;
        this.f484660f = r115;
        this.f484661g = r210;
        this.f484662h = r211;
        this.f484663i = r212;
        this.f484664j = r213;
        this.f484665k = r214;
        this.f484666l = r215;
        this.f484667m = r216;
        this.f484668n = r217;
        this.f484669o = r218;
        this.f484670p = r219;
        this.f484671q = r310;
        this.f484672r = r311;
        this.f484673s = r312;
        this.f484674t = r313;
    }
}
