package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f508575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f508579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f508580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f508581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f508582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f508583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f508584m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f508572a, r101.f508572a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508573b, r101.f508573b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508574c, r101.f508574c) == true) goto L18;
        return false;
    L18:
        if (this.f508575d == r101.f508575d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508576e, r101.f508576e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508577f, r101.f508577f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508578g, r101.f508578g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f508579h, r101.f508579h) == true) goto L33;
        return false;
    L33:
        if (this.f508580i == r101.f508580i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f508581j, r101.f508581j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f508582k, r101.f508582k) == true) goto L42;
        return false;
    L42:
        if (this.f508583l == r101.f508583l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f508584m, r101.f508584m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508572a.hashCode() * 31;
        String r101 = this.f508573b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508574c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f508575d) * 31;
        String r108 = this.f508576e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f508577f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f508578g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f508579h;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        int r118 = (r116 + r102) * 31;
        int r119 = 1231;
        if (this.f508580i == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (((((r118 + r120) * 31) + this.f508581j.hashCode()) * 31) + this.f508582k.hashCode()) * 31;
        if (this.f508583l == true) goto L35;
        r119 = 1237;
    L35:
        return ((r121 + r119) * 31) + this.f508584m.hashCode();
    L29:
        r120 = 1237;
        goto L30
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
        return "ReportSpaceDeleteOrRemoveClick(module=" + this.f508572a + ", subModule=" + this.f508573b + ", objToken=" + this.f508574c + ", type=" + this.f508575d + ", subFileType=" + this.f508576e + ", containerObjToken=" + this.f508577f + ", containerType=" + this.f508578g + ", shortcutToken=" + this.f508579h + ", isSharedFolder=" + this.f508580i + ", click=" + this.f508581j + ", target=" + this.f508582k + ", isFolder=" + this.f508583l + ", viewTitle=" + this.f508584m + ')';
    }

    public final int getType() {
        return this.f508575d;
    }

    public v(String r100, String r101, String r102, int r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "click");
        Intrinsics.checkNotNullParameter(r106, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter("organic_delete", "viewTitle");
        this.f508572a = r100;
        this.f508573b = r101;
        this.f508574c = r102;
        this.f508575d = r103;
        this.f508576e = r104;
        this.f508577f = "";
        this.f508578g = "";
        this.f508579h = "";
        this.f508580i = false;
        this.f508581j = r105;
        this.f508582k = r106;
        this.f508583l = false;
        this.f508584m = "organic_delete";
    }
}
