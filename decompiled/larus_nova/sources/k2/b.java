package k2;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements com.bytedance.assem.arch.extensions.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f501424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f501425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f501426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f501427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f501428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f501429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Callable<String> f501430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Callable<List<String>> f501431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f501432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f501433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f501434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j f501435n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public KClass<?> f501436o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f501437p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f501438q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f501439r;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f501422a, r101.f501422a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501423b, r101.f501423b) == true) goto L15;
        return false;
    L15:
        if (this.f501424c == r101.f501424c) goto L18;
        return false;
    L18:
        if (this.f501425d == r101.f501425d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f501426e, r101.f501426e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f501427f, r101.f501427f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f501428g, r101.f501428g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f501429h, r101.f501429h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f501430i, r101.f501430i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f501431j, r101.f501431j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f501432k, r101.f501432k) == true) goto L42;
        return false;
    L42:
        if (this.f501433l == r101.f501433l) goto L45;
        return false;
    L45:
        if (this.f501434m == r101.f501434m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f501435n, r101.f501435n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f501436o, r101.f501436o) == true) goto L54;
        return false;
    L54:
        if (this.f501437p == r101.f501437p) goto L57;
        return false;
    L57:
        if (this.f501438q == r101.f501438q) goto L60;
        return false;
    L60:
        if (this.f501439r == r101.f501439r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f501422a.hashCode() * 31;
        String r101 = this.f501423b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f501424c == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f501425d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((((((((r107 + r108) * 31) + this.f501426e.hashCode()) * 31) + this.f501427f.hashCode()) * 31) + this.f501428g.hashCode()) * 31) + this.f501429h.hashCode()) * 31;
        Callable<String> r110 = this.f501430i;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Callable<List<String>> r113 = this.f501431j;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f501432k.hashCode()) * 31;
        if (this.f501433l == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f501434m == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        j r120 = this.f501435n;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        KClass<?> r123 = this.f501436o;
        if (r123 == null) goto L38;
        r102 = r123.hashCode();
    L38:
        int r124 = (r122 + r102) * 31;
        if (this.f501437p == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (r124 + r125) * 31;
        if (this.f501438q == false) goto L45;
        int r127 = 1231;
    L46:
        int r128 = (r126 + r127) * 31;
        if (this.f501439r == true) goto L51;
        r105 = 1237;
    L51:
        return r128 + r105;
    L45:
        r127 = 1237;
        goto L46
    L41:
        r125 = 1237;
        goto L42
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIViewRenderData(schema=" + this.f501422a + ", url=" + this.f501423b + ", boeEnable=" + this.f501424c + ", ppeEnable=" + this.f501425d + ", boeEnv=" + this.f501426e + ", ppeEnv=" + this.f501427f + ", boeHost=" + this.f501428g + ", onlineHost=" + this.f501429h + ", xTTToken=" + this.f501430i + ", websiteHostWhiteList=" + this.f501431j + ", webWhiteList=" + this.f501432k + ", disableBounce=" + this.f501433l + ", useRelax=" + this.f501434m + ", aiContainer=" + this.f501435n + ", renderClass=" + this.f501436o + ", isPopup=" + this.f501437p + ", acceptPermissionRequest=" + this.f501438q + ", openHttpBySystem=" + this.f501439r + ')';
    }

    public b(String r100, String r101, boolean r102, boolean r103, String r104, String r105, String r106, String r107, Callable r110, Callable r111, List r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r104, "boeEnv");
        Intrinsics.checkNotNullParameter(r105, "ppeEnv");
        Intrinsics.checkNotNullParameter(r106, "boeHost");
        Intrinsics.checkNotNullParameter(r107, "onlineHost");
        Intrinsics.checkNotNullParameter(r112, "webWhiteList");
        this.f501422a = r100;
        this.f501423b = r101;
        this.f501424c = r102;
        this.f501425d = r103;
        this.f501426e = r104;
        this.f501427f = r105;
        this.f501428g = r106;
        this.f501429h = r107;
        this.f501430i = r110;
        this.f501431j = r111;
        this.f501432k = r112;
        this.f501433l = r113;
        this.f501434m = false;
        this.f501435n = null;
        this.f501436o = null;
        this.f501437p = false;
        this.f501438q = false;
        this.f501439r = false;
    }
}
