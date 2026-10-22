package no9;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f519981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f519982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f519983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f519984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f519985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f519986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f519987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f519988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f519989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<String> f519990l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f519979a, r101.f519979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519980b, r101.f519980b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f519981c, r101.f519981c) == true) goto L18;
        return false;
    L18:
        if (this.f519982d == r101.f519982d) goto L21;
        return false;
    L21:
        if (this.f519983e == r101.f519983e) goto L24;
        return false;
    L24:
        if (this.f519984f == r101.f519984f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f519985g, r101.f519985g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f519986h, r101.f519986h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f519987i, r101.f519987i) == true) goto L36;
        return false;
    L36:
        if (this.f519988j == r101.f519988j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f519989k, r101.f519989k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f519990l, r101.f519990l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f519979a.hashCode() * 31) + this.f519980b.hashCode()) * 31) + this.f519981c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f519982d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f519983e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f519984f == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        a r107 = this.f519985g;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        a r111 = this.f519986h;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f519987i;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (((r113 + r115) * 31) + this.f519988j) * 31;
        Integer r117 = this.f519989k;
        if (r117 == null) goto L31;
        r108 = r117.hashCode();
    L31:
        return ((r116 + r108) * 31) + this.f519990l.hashCode();
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeishuFlowAIShowRequest(source=" + this.f519979a + ", text=" + this.f519980b + ", extra=" + this.f519981c + ", hasSelection=" + this.f519982d + ", hasCursor=" + this.f519983e + ", hasReferenceText=" + this.f519984f + ", sourceDocument=" + this.f519985g + ", transcript=" + this.f519986h + ", topicId=" + this.f519987i + ", writingAction=" + this.f519988j + ", recommendType=" + this.f519989k + ", contentContextKeys=" + this.f519990l + ')';
    }

    public b(String r100, String r101, Map<String, String> r102, boolean r103, boolean r104, boolean r105, a r106, a r107, String r110, int r111, Integer r112, List<String> r113) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r113, "contentContextKeys");
        this.f519979a = r100;
        this.f519980b = r101;
        this.f519981c = r102;
        this.f519982d = r103;
        this.f519983e = r104;
        this.f519984f = r105;
        this.f519985g = r106;
        this.f519986h = r107;
        this.f519987i = r110;
        this.f519988j = r111;
        this.f519989k = r112;
        this.f519990l = r113;
    }
}
