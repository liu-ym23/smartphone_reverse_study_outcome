package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f431549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f431551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f431552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f431553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f431554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f431555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f431556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f431557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f431558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f431559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<String> f431560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f431561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f431562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f431563o;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f431549a == r101.f431549a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f431550b, r101.f431550b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f431551c, r101.f431551c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (this.f431552d == r101.f431552d) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f431553e, r101.f431553e) == true) goto L27;
        return false;
    L27:
        if (this.f431554f == r101.f431554f) goto L30;
        return false;
    L30:
        if (this.f431555g == r101.f431555g) goto L33;
        return false;
    L33:
        if (this.f431556h == r101.f431556h) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f431557i, r101.f431557i) == true) goto L39;
        return false;
    L39:
        if (this.f431558j == r101.f431558j) goto L42;
        return false;
    L42:
        if (this.f431559k == r101.f431559k) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f431560l, r101.f431560l) == true) goto L48;
        return false;
    L48:
        if (this.f431561m == r101.f431561m) goto L51;
        return false;
    L51:
        if (this.f431562n == r101.f431562n) goto L54;
        return false;
    L54:
        if (this.f431563o == r101.f431563o) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f431549a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.f431550b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        String r106 = this.f431551c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r105 + r107) * 31) + 0) * 31;
        if (this.f431552d == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((((((r108 + r109) * 31) + this.f431553e.hashCode()) * 31) + this.f431554f) * 31) + this.f431555g) * 31;
        long r111 = this.f431556h;
        int r112 = (((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.f431557i.hashCode()) * 31;
        if (this.f431558j == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f431559k == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (((((((r114 + r115) * 31) + this.f431560l.hashCode()) * 31) + this.f431561m) * 31) + this.f431562n) * 31;
        if (this.f431563o == true) goto L31;
        r100 = 1237;
    L31:
        return r116 + r100;
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CdnTemplateLoaderConfig(enabled=" + this.f431549a + ", cdnUrl=" + this.f431550b + ", cdnBaseUrl=" + this.f431551c + ", urlResolver=null, enableDiskCache=" + this.f431552d + ", cacheDirName=" + this.f431553e + ", connectTimeoutMillis=" + this.f431554f + ", readTimeoutMillis=" + this.f431555g + ", maxTemplateBytes=" + this.f431556h + ", requestHeaders=" + this.f431557i + ", cdnNoCache=" + this.f431558j + ", onlyLocal=" + this.f431559k + ", fallbackDomains=" + this.f431560l + ", shuffle=" + this.f431561m + ", loadRetryTimes=" + this.f431562n + ", isDebugPackage=" + this.f431563o + ')';
    }

    public f() {
        Map<String, String> r100 = MapsKt.emptyMap();
        List<String> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter("rl_resource_offline", "cacheDirName");
        Intrinsics.checkNotNullParameter(r100, "requestHeaders");
        Intrinsics.checkNotNullParameter(r101, "fallbackDomains");
        this.f431549a = true;
        this.f431550b = null;
        this.f431551c = null;
        this.f431552d = true;
        this.f431553e = "rl_resource_offline";
        this.f431554f = 10000;
        this.f431555g = 30000;
        this.f431556h = 52428800;
        this.f431557i = r100;
        this.f431558j = false;
        this.f431559k = false;
        this.f431560l = r101;
        this.f431561m = 0;
        this.f431562n = 0;
        this.f431563o = false;
    }
}
