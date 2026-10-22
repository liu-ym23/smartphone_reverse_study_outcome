package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f508527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f508528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f508529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f508530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f508531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f508532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f508533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f508534n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f508521a, r101.f508521a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508522b, r101.f508522b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508523c, r101.f508523c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508524d, r101.f508524d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508525e, r101.f508525e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508526f, r101.f508526f) == true) goto L27;
        return false;
    L27:
        if (this.f508527g == r101.f508527g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f508528h, r101.f508528h) == true) goto L33;
        return false;
    L33:
        if (this.f508529i == r101.f508529i) goto L36;
        return false;
    L36:
        if (this.f508530j == r101.f508530j) goto L39;
        return false;
    L39:
        if (this.f508531k == r101.f508531k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f508532l, r101.f508532l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f508533m, r101.f508533m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f508534n, r101.f508534n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f508521a.hashCode() * 31) + this.f508522b.hashCode()) * 31;
        String r101 = this.f508523c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508524d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f508525e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f508526f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f508527g) * 31;
        String r114 = this.f508528h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        int r117 = 1231;
        if (this.f508529i == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (r116 + r118) * 31;
        if (this.f508530j == true) goto L30;
        r117 = 1237;
    L30:
        int r120 = (((r119 + r117) * 31) + this.f508531k) * 31;
        String r121 = this.f508532l;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f508533m;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f508534n;
        if (r127 == null) goto L43;
        r102 = r127.hashCode();
    L43:
        return r126 + r102;
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L25:
        r118 = 1237;
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
        return "ReportPageItemClickParam(event=" + this.f508521a + ", module=" + this.f508522b + ", subModule=" + this.f508523c + ", currentSubView=" + this.f508524d + ", parentToken=" + this.f508525e + ", objToken=" + this.f508526f + ", type=" + this.f508527g + ", subFileType=" + this.f508528h + ", isSharedFolder=" + this.f508529i + ", isSubFolder=" + this.f508530j + ", folderLevel=" + this.f508531k + ", shortcutToken=" + this.f508532l + ", containerEnv=" + this.f508533m + ", baseHpFrom=" + this.f508534n + ')';
    }

    public final int getType() {
        return this.f508527g;
    }

    public q(String r110, String r111, String r112, String r113, String r210, int r211, String r212, boolean r213, boolean r214, int r215, String r216) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        this(r110, r111, r112, "", r113, r210, r211, r212, r213, r214, r215, r216, null, null);
    }

    public q(String r100, String r101, String r102, String r103, String r104, String r105, int r106, String r107, boolean r110, boolean r111, int r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        this.f508521a = r100;
        this.f508522b = r101;
        this.f508523c = r102;
        this.f508524d = r103;
        this.f508525e = r104;
        this.f508526f = r105;
        this.f508527g = r106;
        this.f508528h = r107;
        this.f508529i = r110;
        this.f508530j = r111;
        this.f508531k = r112;
        this.f508532l = r113;
        this.f508533m = r114;
        this.f508534n = r115;
    }
}
