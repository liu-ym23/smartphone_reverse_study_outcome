package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f508540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f508542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f508543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f508544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f508545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f508546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f508547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f508548n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f508535a, r101.f508535a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508536b, r101.f508536b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508537c, r101.f508537c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508538d, r101.f508538d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508539e, r101.f508539e) == true) goto L24;
        return false;
    L24:
        if (this.f508540f == r101.f508540f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508541g, r101.f508541g) == true) goto L30;
        return false;
    L30:
        if (this.f508542h == r101.f508542h) goto L33;
        return false;
    L33:
        if (this.f508543i == r101.f508543i) goto L36;
        return false;
    L36:
        if (this.f508544j == r101.f508544j) goto L39;
        return false;
    L39:
        if (this.f508545k == r101.f508545k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f508546l, r101.f508546l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f508547m, r101.f508547m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f508548n, r101.f508548n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f508535a.hashCode() * 31) + this.f508536b.hashCode()) * 31;
        String r101 = this.f508537c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508538d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f508539e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f508540f) * 31;
        String r111 = this.f508541g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        int r114 = 1231;
        if (this.f508542h == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f508543i == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f508544j == true) goto L30;
        r114 = 1237;
    L30:
        int r119 = (((r118 + r114) * 31) + this.f508545k) * 31;
        String r120 = this.f508546l;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f508547m;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f508548n;
        if (r126 == null) goto L43;
        r102 = r126.hashCode();
    L43:
        return r125 + r102;
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = 1237;
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
        return "ReportPageSwitchClickParam(event=" + this.f508535a + ", module=" + this.f508536b + ", subModule=" + this.f508537c + ", currentSubView=" + this.f508538d + ", objToken=" + this.f508539e + ", type=" + this.f508540f + ", subFileType=" + this.f508541g + ", isFolder=" + this.f508542h + ", isSharedFolder=" + this.f508543i + ", isSubFolder=" + this.f508544j + ", folderLevel=" + this.f508545k + ", parentToken=" + this.f508546l + ", containerEnv=" + this.f508547m + ", baseHpFrom=" + this.f508548n + ')';
    }

    public final int getType() {
        return this.f508540f;
    }

    public r(String r110, String r111, String r112, String r113, int r114, boolean r210, boolean r211, boolean r212, int r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        this(r110, r111, r112, "", r113, r114, r210, r211, r212, r213, r214, null, null);
    }

    public r(String r100, String r101, String r102, String r103, String r104, int r105, boolean r106, boolean r107, boolean r110, int r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        this.f508535a = r100;
        this.f508536b = r101;
        this.f508537c = r102;
        this.f508538d = r103;
        this.f508539e = r104;
        this.f508540f = r105;
        this.f508541g = "";
        this.f508542h = r106;
        this.f508543i = r107;
        this.f508544j = r110;
        this.f508545k = r111;
        this.f508546l = r112;
        this.f508547m = r113;
        this.f508548n = r114;
    }
}
