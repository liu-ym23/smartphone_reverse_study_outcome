package uq5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f551295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f551296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f551297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WikiInfo f551298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f551299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f551300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f551301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f551302k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f551292a, r101.f551292a) == true) goto L12;
        return false;
    L12:
        if (this.f551293b == r101.f551293b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f551294c, r101.f551294c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f551295d, r101.f551295d) == true) goto L21;
        return false;
    L21:
        if (this.f551296e == r101.f551296e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f551297f, r101.f551297f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f551298g, r101.f551298g) == true) goto L30;
        return false;
    L30:
        if (this.f551299h == r101.f551299h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f551300i, r101.f551300i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f551301j, r101.f551301j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f551302k, r101.f551302k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f551292a.hashCode() * 31;
        int r101 = 1231;
        if (this.f551293b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f551294c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f551295d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f551296e == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        String r113 = this.f551297f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        WikiInfo r116 = this.f551298g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f551299h == true) goto L30;
        r101 = 1237;
    L30:
        int r119 = (r118 + r101) * 31;
        String r120 = this.f551300i;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f551301j;
        if (r123 == null) goto L39;
        r105 = r123.hashCode();
    L39:
        return ((r122 + r105) * 31) + this.f551302k.hashCode();
    L33:
        r121 = r120.hashCode();
        goto L34
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "NavigationParams(targetToken=" + this.f551292a + ", popLast=" + this.f551293b + ", targetSpace=" + this.f551294c + ", targetSpaceName=" + this.f551295d + ", dismissNow=" + this.f551296e + ", title=" + this.f551297f + ", wikiInfo=" + this.f551298g + ", forceLoad=" + this.f551299h + ", uniqueUiId=" + this.f551300i + ", from=" + this.f551301j + ", visibleSpaceId=" + this.f551302k + ')';
    }

    public a(String r100, boolean r101, String r102, String r103, String r104, WikiInfo r110, boolean r111, String r112, String r113, String r114, int r115) {
        boolean r105 = true;
        if ((r115 & 2) == 0) goto L6;
        r101 = true;
    L6:
        if ((r115 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r115 & 16) != 0) goto L16;
        r105 = false;
    L16:
        if ((r115 & 32) == 0) goto L19;
        r104 = null;
    L19:
        if ((r115 & 64) == 0) goto L22;
        r110 = null;
    L22:
        if ((r115 & 128) == 0) goto L25;
        r111 = false;
    L25:
        if ((r115 & 256) == 0) goto L28;
        r112 = null;
    L28:
        if ((r115 & 512) == 0) goto L31;
        r113 = null;
    L31:
        if ((r115 & 1024) == 0) goto L33;
        r114 = "";
    L33:
        Intrinsics.checkNotNullParameter(r100, "targetToken");
        Intrinsics.checkNotNullParameter(r114, "visibleSpaceId");
        this.f551292a = r100;
        this.f551293b = r101;
        this.f551294c = r102;
        this.f551295d = r103;
        this.f551296e = r105;
        this.f551297f = r104;
        this.f551298g = r110;
        this.f551299h = r111;
        this.f551300i = r112;
        this.f551301j = r113;
        this.f551302k = r114;
    }
}
