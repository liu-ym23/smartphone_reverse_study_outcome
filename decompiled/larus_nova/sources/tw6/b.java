package tw6;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f547766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f547767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f547768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f547769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f547770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Map<String, String>> f547771h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f547764a == r101.f547764a) goto L12;
        return false;
    L12:
        if (this.f547765b == r101.f547765b) goto L15;
        return false;
    L15:
        if (this.f547766c == r101.f547766c) goto L18;
        return false;
    L18:
        if (this.f547767d == r101.f547767d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f547768e, r101.f547768e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f547769f, r101.f547769f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f547770g, r101.f547770g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f547771h, r101.f547771h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f547764a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f547765b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f547766c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f547767d == true) goto L18;
        r100 = 1237;
    L18:
        int r107 = (((r106 + r100) * 31) + this.f547768e.hashCode()) * 31;
        Integer r108 = this.f547769f;
        int r109 = 0;
        if (r108 != null) goto L21;
        int r110 = 0;
    L22:
        int r111 = (r107 + r110) * 31;
        List<String> r112 = this.f547770g;
        if (r112 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r111 + r113) * 31;
        List<Map<String, String>> r115 = this.f547771h;
        if (r115 == null) goto L31;
        r109 = r115.hashCode();
    L31:
        return r114 + r109;
    L25:
        r113 = r112.hashCode();
        goto L26
    L21:
        r110 = r108.hashCode();
        goto L22
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PrecacheSwitch(enable=" + this.f547764a + ", enableOnPoiPath=" + this.f547765b + ", enableOnLivePath=" + this.f547766c + ", enableOnGoodsDetailPath=" + this.f547767d + ", allowList=" + this.f547768e + ", validTime=" + this.f547769f + ", routerKeys=" + this.f547770g + ", cacheBlockRulesList=" + this.f547771h + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r100, boolean r101, boolean r102, boolean r103, List<String> r104, Integer r105, List<String> r106, List<? extends Map<String, String>> r107) {
        Intrinsics.checkNotNullParameter(r104, "allowList");
        this.f547764a = r100;
        this.f547765b = r101;
        this.f547766c = r102;
        this.f547767d = r103;
        this.f547768e = r104;
        this.f547769f = r105;
        this.f547770g = r106;
        this.f547771h = r107;
    }
}
