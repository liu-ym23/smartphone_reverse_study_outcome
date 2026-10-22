package jx6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f500882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f500884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f500885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f500886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f500887h;

    public w() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f500880a, r101.f500880a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500881b, r101.f500881b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500882c, r101.f500882c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500883d, r101.f500883d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500884e, r101.f500884e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f500885f, r101.f500885f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f500886g, r101.f500886g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f500887h, r101.f500887h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f500880a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f500881b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f500882c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f500883d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f500884e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f500885f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f500886g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f500887h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "RateItemVO(nickname=" + this.f500880a + ", avatarUrl=" + this.f500881b + ", userLevelUrl=" + this.f500882c + ", userRateUrl=" + this.f500883d + ", content=" + this.f500884e + ", imageList=" + this.f500885f + ", uid=" + this.f500886g + ", itemId=" + this.f500887h + ')';
    }

    public w(String r100, String r101, String r102, String r103, String r104, List<String> r105, String r106, String r107) {
        this.f500880a = r100;
        this.f500881b = r101;
        this.f500882c = r102;
        this.f500883d = r103;
        this.f500884e = r104;
        this.f500885f = r105;
        this.f500886g = r106;
        this.f500887h = r107;
    }
}
