package com.bytedance.locallife.live.goodsshelves.repository;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f259835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f259836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f259837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f259838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f259839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f259840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.locallife.live.goodsshelves.manager.i f259841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f259842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f259843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f259844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f259845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f259846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f259847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f259848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f259849p;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f259834a, r101.f259834a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f259835b, r101.f259835b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f259836c, r101.f259836c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f259837d, r101.f259837d) == true) goto L21;
        return false;
    L21:
        if (this.f259838e == r101.f259838e) goto L24;
        return false;
    L24:
        if (this.f259839f == r101.f259839f) goto L27;
        return false;
    L27:
        if (this.f259840g == r101.f259840g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f259841h, r101.f259841h) == true) goto L33;
        return false;
    L33:
        if (this.f259842i == r101.f259842i) goto L36;
        return false;
    L36:
        if (this.f259843j == r101.f259843j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f259844k, r101.f259844k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f259845l, r101.f259845l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f259834a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f259835b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f259836c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f259837d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((((((((((((r109 + r111) * 31) + this.f259838e) * 31) + this.f259839f) * 31) + this.f259840g) * 31) + this.f259841h.hashCode()) * 31) + this.f259842i) * 31) + this.f259843j) * 31) + this.f259844k.hashCode()) * 31;
        Map<String, String> r113 = this.f259845l;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "GoodsShelvesRequestParams(roomAggCardId=" + this.f259834a + ", locationPermission=" + this.f259835b + ", roomId=" + this.f259836c + ", anchorId=" + this.f259837d + ", sourceType=" + this.f259838e + ", tabId=" + this.f259839f + ", requestType=" + this.f259840g + ", couponMigrationInfo=" + this.f259841h + ", pageSize=" + this.f259842i + ", firstPageSize=" + this.f259843j + ", scene=" + this.f259844k + ", requestData=" + this.f259845l + ')';
    }

    public l(String r100, String r101, String r102, String r103, int r104, int r105, com.bytedance.locallife.live.goodsshelves.manager.i r106, int r110, int r111, Map r112) {
        Intrinsics.checkNotNullParameter(r106, "couponMigrationInfo");
        Intrinsics.checkNotNullParameter("click", "scene");
        this.f259834a = r100;
        this.f259835b = r101;
        this.f259836c = r102;
        this.f259837d = r103;
        this.f259838e = r104;
        this.f259839f = r105;
        this.f259840g = 0;
        this.f259841h = r106;
        this.f259842i = r110;
        this.f259843j = r111;
        this.f259844k = "click";
        this.f259845l = r112;
        this.f259847n = "";
    }
}
