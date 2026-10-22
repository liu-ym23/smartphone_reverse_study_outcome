package o29;

import android.net.Uri;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f521810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f521811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f521812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f521813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f521814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f521815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f521816i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f521808a, r101.f521808a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521809b, r101.f521809b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f521810c, r101.f521810c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f521811d, r101.f521811d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f521812e, r101.f521812e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f521813f, r101.f521813f) == true) goto L27;
        return false;
    L27:
        if (this.f521814g == r101.f521814g) goto L30;
        return false;
    L30:
        if (this.f521815h == r101.f521815h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f521816i, r101.f521816i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f521808a.hashCode() * 31) + this.f521809b.hashCode()) * 31;
        String r101 = this.f521810c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f521811d.hashCode()) * 31;
        Uri r105 = this.f521812e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f521813f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f521814g == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f521815h == true) goto L22;
        r111 = 1237;
    L22:
        int r114 = (r113 + r111) * 31;
        Map<String, Object> r115 = this.f521816i;
        if (r115 == null) goto L27;
        r102 = r115.hashCode();
    L27:
        return r114 + r102;
    L17:
        r112 = 1237;
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
        return "QuickMenuItem(id=" + this.f521808a + ", title=" + this.f521809b + ", subtitle=" + this.f521810c + ", iconUri=" + this.f521811d + ", badgeUri=" + this.f521812e + ", bizTag=" + this.f521813f + ", showIconBorder=" + this.f521814g + ", isHighlighted=" + this.f521815h + ", extra=" + this.f521816i + ')';
    }

    public j(String r100, String r101, String r102, Uri r103, Uri r104, String r105, boolean r106, boolean r107, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "iconUri");
        this.f521808a = r100;
        this.f521809b = r101;
        this.f521810c = r102;
        this.f521811d = r103;
        this.f521812e = r104;
        this.f521813f = r105;
        this.f521814g = r106;
        this.f521815h = r107;
        this.f521816i = r110;
    }
}
