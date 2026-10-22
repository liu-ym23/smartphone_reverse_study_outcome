package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f508558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f508562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f508563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f508564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f508565k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f508555a, r101.f508555a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508556b, r101.f508556b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508557c, r101.f508557c) == true) goto L18;
        return false;
    L18:
        if (this.f508558d == r101.f508558d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508559e, r101.f508559e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508560f, r101.f508560f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508561g, r101.f508561g) == true) goto L30;
        return false;
    L30:
        if (this.f508562h == r101.f508562h) goto L33;
        return false;
    L33:
        if (this.f508563i == r101.f508563i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f508564j, r101.f508564j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f508565k, r101.f508565k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508555a.hashCode() * 31;
        String r101 = this.f508556b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508557c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f508558d) * 31;
        String r108 = this.f508559e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f508560f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f508561g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        int r117 = 1231;
        if (this.f508562h == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (r116 + r118) * 31;
        if (this.f508563i == true) goto L30;
        r117 = 1237;
    L30:
        int r120 = (r119 + r117) * 31;
        String r121 = this.f508564j;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f508565k;
        if (r124 == null) goto L39;
        r102 = r124.hashCode();
    L39:
        return r123 + r102;
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
        return "ReportRightClickMenuParam(module=" + this.f508555a + ", subModule=" + this.f508556b + ", objToken=" + this.f508557c + ", type=" + this.f508558d + ", subFileType=" + this.f508559e + ", containerObjToken=" + this.f508560f + ", containerType=" + this.f508561g + ", isSharedFolder=" + this.f508562h + ", isFollow=" + this.f508563i + ", shortcutToken=" + this.f508564j + ", originalLocation=" + this.f508565k + ')';
    }

    public final int getType() {
        return this.f508558d;
    }

    public t(String r100, String r101, int r102, String r103, String r104, String r105, boolean r106, String r110, String r111) {
        Intrinsics.checkNotNullParameter("flow_space", EventConstant.Key.MODULE);
        this.f508555a = "flow_space";
        this.f508556b = r100;
        this.f508557c = r101;
        this.f508558d = r102;
        this.f508559e = r103;
        this.f508560f = r104;
        this.f508561g = r105;
        this.f508562h = r106;
        this.f508563i = false;
        this.f508564j = r110;
        this.f508565k = r111;
    }
}
