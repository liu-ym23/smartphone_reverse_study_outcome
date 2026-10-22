package lc5;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f508442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f508446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f508449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f508450i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f508442a, r101.f508442a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508443b, r101.f508443b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508444c, r101.f508444c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508445d, r101.f508445d) == true) goto L21;
        return false;
    L21:
        if (this.f508446e == r101.f508446e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508447f, r101.f508447f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508448g, r101.f508448g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f508449h, r101.f508449h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f508450i, r101.f508450i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508442a.hashCode() * 31;
        String r101 = this.f508443b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508444c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f508445d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f508446e) * 31;
        String r111 = this.f508447f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f508448g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f508449h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f508450i;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
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
        return "PublicParams(params=" + this.f508442a + ", module=" + this.f508443b + ", subModule=" + this.f508444c + ", fileId=" + this.f508445d + ", fileType=" + this.f508446e + ", subFileType=" + this.f508447f + ", containerId=" + this.f508448g + ", containerType=" + this.f508449h + ", shortcutToken=" + this.f508450i + ')';
    }

    public g(JSONObject r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f508442a = r100;
        this.f508443b = r101;
        this.f508444c = r102;
        this.f508445d = r103;
        this.f508446e = r104;
        this.f508447f = r105;
        this.f508448g = r106;
        this.f508449h = r107;
        this.f508450i = r110;
    }
}
