package tm8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f546779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f546781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f546782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f546783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f546784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f546785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f546786i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f546778a, r101.f546778a) == true) goto L12;
        return false;
    L12:
        if (this.f546779b == r101.f546779b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546780c, r101.f546780c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f546781d, r101.f546781d) == true) goto L21;
        return false;
    L21:
        if (this.f546782e == r101.f546782e) goto L24;
        return false;
    L24:
        if (this.f546783f == r101.f546783f) goto L27;
        return false;
    L27:
        if (this.f546784g == r101.f546784g) goto L30;
        return false;
    L30:
        if (this.f546785h == r101.f546785h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f546786i, r101.f546786i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f546778a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f546779b) * 31;
        String r104 = this.f546780c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f546781d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + this.f546782e) * 31) + this.f546783f) * 31;
        int r110 = 1231;
        if (this.f546784g == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f546785h == true) goto L22;
        r110 = 1237;
    L22:
        int r113 = (r112 + r110) * 31;
        Map<String, String> r114 = this.f546786i;
        if (r114 == null) goto L27;
        r101 = r114.hashCode();
    L27:
        return r113 + r101;
    L17:
        r111 = 1237;
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
        return "QuickReplyButtonViewInput(title=" + this.f546778a + ", trackIndex=" + this.f546779b + ", iconUrlLight=" + this.f546780c + ", iconUrlDark=" + this.f546781d + ", iconPos=" + this.f546782e + ", displayStyle=" + this.f546783f + ", fillParentWidth=" + this.f546784g + ", clickedButton=" + this.f546785h + ", extraParams=" + this.f546786i + ')';
    }

    public a(String r100, int r101, String r102, String r103, int r104, int r105, boolean r106, boolean r107, Map<String, String> r108) {
        this.f546778a = r100;
        this.f546779b = r101;
        this.f546780c = r102;
        this.f546781d = r103;
        this.f546782e = r104;
        this.f546783f = r105;
        this.f546784g = r106;
        this.f546785h = r107;
        this.f546786i = r108;
    }
}
