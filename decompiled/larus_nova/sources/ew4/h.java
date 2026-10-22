package ew4;

import com.amap.api.services.district.DistrictSearchQuery;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f474558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f474559h;

    public h() {
        this(null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f474552a, r101.f474552a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474553b, r101.f474553b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474554c, r101.f474554c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474555d, r101.f474555d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474556e, r101.f474556e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474557f, r101.f474557f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474558g, r101.f474558g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474559h, r101.f474559h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f474552a.hashCode() * 31) + this.f474553b.hashCode()) * 31) + this.f474554c.hashCode()) * 31) + this.f474555d.hashCode()) * 31) + this.f474556e.hashCode()) * 31) + this.f474557f.hashCode()) * 31) + this.f474558g.hashCode()) * 31) + this.f474559h.hashCode();
    }

    public final String toString() {
        return "CommonAddressComponent(country=" + this.f474552a + ", province=" + this.f474553b + ", city=" + this.f474554c + ", district=" + this.f474555d + ", township=" + this.f474556e + ", neighborhood=" + this.f474557f + ", building=" + this.f474558g + ", address=" + this.f474559h + ')';
    }

    public /* synthetic */ h(String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r111 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r111 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r111 & 64) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r111 & 128) == 0) goto L33;
        String r113 = "";
    L34:
        this(r100, r101, r102, r103, r104, r105, r112, r113);
        return;
    L33:
        r113 = r110;
        goto L34
    L29:
        r112 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
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

    public h(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, DistrictSearchQuery.KEYWORDS_COUNTRY);
        Intrinsics.checkNotNullParameter(r101, "province");
        Intrinsics.checkNotNullParameter(r102, "city");
        Intrinsics.checkNotNullParameter(r103, DistrictSearchQuery.KEYWORDS_DISTRICT);
        Intrinsics.checkNotNullParameter(r104, "township");
        Intrinsics.checkNotNullParameter(r105, "neighborhood");
        Intrinsics.checkNotNullParameter(r106, LocationConstants$NameType.BUILDING);
        Intrinsics.checkNotNullParameter(r107, "address");
        this.f474552a = r100;
        this.f474553b = r101;
        this.f474554c = r102;
        this.f474555d = r103;
        this.f474556e = r104;
        this.f474557f = r105;
        this.f474558g = r106;
        this.f474559h = r107;
    }
}
