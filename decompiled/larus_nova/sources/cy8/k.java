package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f465853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f465854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f465855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f465856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f465857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f465858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f465859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f465860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f465861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f465862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f465863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f465864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f465865m;

    public k() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f465853a, r101.f465853a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465854b, r101.f465854b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465855c, r101.f465855c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465856d, r101.f465856d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465857e, r101.f465857e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465858f, r101.f465858f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465859g, r101.f465859g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f465860h, r101.f465860h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465861i, r101.f465861i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f465862j, r101.f465862j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f465863k, r101.f465863k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f465864l, r101.f465864l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f465865m, r101.f465865m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f465853a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f465854b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f465855c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f465856d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f465857e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f465858f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f465859g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f465860h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f465861i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        d r128 = this.f465862j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<String> r131 = this.f465863k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f465864l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.f465865m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
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
        r111 = r110.hashCode();
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
        return "CanvasInfo(canvasId=" + this.f465853a + ", canvasSubId=" + this.f465854b + ", canvasType=" + this.f465855c + ", canvasStatus=" + this.f465856d + ", errorCode=" + this.f465857e + ", errorMsg=" + this.f465858f + ", effectMode=" + this.f465859g + ", replySubId=" + this.f465860h + ", taskType=" + this.f465861i + ", costTime=" + this.f465862j + ", prompt=" + this.f465863k + ", parentId=" + this.f465864l + ", canvasMaxCount=" + this.f465865m + ')';
    }

    public k(Long r100, Long r101, Integer r102, Integer r103, Long r104, String r105, Integer r106, String r107, Integer r108, d r110, List<String> r111, Long r112, Integer r113) {
        this.f465853a = r100;
        this.f465854b = r101;
        this.f465855c = r102;
        this.f465856d = r103;
        this.f465857e = r104;
        this.f465858f = r105;
        this.f465859g = r106;
        this.f465860h = r107;
        this.f465861i = r108;
        this.f465862j = r110;
        this.f465863k = r111;
        this.f465864l = r112;
        this.f465865m = r113;
    }
}
