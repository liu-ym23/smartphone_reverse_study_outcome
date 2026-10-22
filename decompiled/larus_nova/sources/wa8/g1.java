package wa8;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationReferenceMediaType f558858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f558859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f558861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f558862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f558864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f558865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f558866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Double f558867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Double f558868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Double f558869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Double f558870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Long f558871n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (this.f558858a == r101.f558858a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558859b, r101.f558859b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558860c, r101.f558860c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558861d, r101.f558861d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558862e, r101.f558862e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558863f, r101.f558863f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558864g, r101.f558864g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f558865h, r101.f558865h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f558866i, r101.f558866i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f558867j, r101.f558867j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f558868k, r101.f558868k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f558869l, r101.f558869l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f558870m, r101.f558870m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f558871n, r101.f558871n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f558858a.hashCode() * 31;
        Integer r101 = this.f558859b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f558860c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Double r108 = this.f558861d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f558862e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f558863f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f558864g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.f558865h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f558866i;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Double r126 = this.f558867j;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Double r129 = this.f558868k;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Double r132 = this.f558869l;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        Double r135 = this.f558870m;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        Long r138 = this.f558871n;
        if (r138 == null) goto L55;
        r102 = r138.hashCode();
    L55:
        return r137 + r102;
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
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
        return "CreationReferenceMediaRule(type=" + this.f558858a + ", maxCount=" + this.f558859b + ", maxCountDisplayText=" + this.f558860c + ", maxTotalDuration=" + this.f558861d + ", maxTotalShowDuration=" + this.f558862e + ", maxTotalDurationDisplayText=" + this.f558863f + ", maxResolution=" + this.f558864g + ", minResolution=" + this.f558865h + ", maxResolutionDisplayText=" + this.f558866i + ", minRatio=" + this.f558867j + ", maxRatio=" + this.f558868k + ", minSingleDuration=" + this.f558869l + ", maxSingleDuration=" + this.f558870m + ", maxFileSize=" + this.f558871n + ')';
    }

    public final CreationReferenceMediaType getType() {
        return this.f558858a;
    }

    public g1(CreationReferenceMediaType r100, Integer r101, String r102, Double r103, Integer r104, String r105, Long r106, Long r107, String r110, Double r111, Double r112, Double r113, Double r114, Long r115) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f558858a = r100;
        this.f558859b = r101;
        this.f558860c = r102;
        this.f558861d = r103;
        this.f558862e = r104;
        this.f558863f = r105;
        this.f558864g = r106;
        this.f558865h = r107;
        this.f558866i = r110;
        this.f558867j = r111;
        this.f558868k = r112;
        this.f558869l = r113;
        this.f558870m = r114;
        this.f558871n = r115;
    }
}
