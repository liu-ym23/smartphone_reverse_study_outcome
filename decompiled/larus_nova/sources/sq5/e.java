package sq5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f543013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f543014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f543016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f543017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f543018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f543019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f543020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f543021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f543022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f543023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f543024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f543025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f543026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f543027o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f543013a, r101.f543013a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543014b, r101.f543014b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f543015c, r101.f543015c) == true) goto L18;
        return false;
    L18:
        if (this.f543016d == r101.f543016d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f543017e, r101.f543017e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f543018f, r101.f543018f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f543019g, r101.f543019g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f543020h, r101.f543020h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f543021i, r101.f543021i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f543022j, r101.f543022j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f543023k, r101.f543023k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f543024l, r101.f543024l) == true) goto L45;
        return false;
    L45:
        if (this.f543025m == r101.f543025m) goto L48;
        return false;
    L48:
        if (this.f543026n == r101.f543026n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f543027o, r101.f543027o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Fragment r100 = this.f543013a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bundle r104 = this.f543014b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f543015c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f543016d) * 31;
        String r110 = this.f543017e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f543018f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f543019g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f543020h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f543021i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f543022j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f543023k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f543024l;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        long r134 = this.f543025m;
        int r135 = (r133 + ((int) (r134 ^ (r134 >>> 32)))) * 31;
        if (this.f543026n == false) goto L49;
        int r136 = 1231;
    L50:
        int r137 = (r135 + r136) * 31;
        a r138 = this.f543027o;
        if (r138 == null) goto L55;
        r101 = r138.hashCode();
    L55:
        return r137 + r101;
    L49:
        r136 = 1237;
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "WikiCopy2WikiCommandInitParams(fragment=" + this.f543013a + ", bundle=" + this.f543014b + ", srcWikiToken=" + this.f543015c + ", srcObjType=" + this.f543016d + ", srcSpaceId=" + this.f543017e + ", srcParentWikiToken=" + this.f543018f + ", srcTitle=" + this.f543019g + ", destParentWikiToken=" + this.f543020h + ", destSpaceId=" + this.f543021i + ", destSpaceName=" + this.f543022j + ", srcOriginWikiToken=" + this.f543023k + ", srcOriginSpaceId=" + this.f543024l + ", srcFileSize=" + this.f543025m + ", srcIsShortcut=" + this.f543026n + ", dependence=" + this.f543027o + ')';
    }

    public e(Fragment r100, Bundle r101, String r102, int r103, String r104, String r105, String r110, String r111, String r112, String r113, String r114, String r115, long r116, boolean r117, a r118) {
        this.f543013a = r100;
        this.f543014b = r101;
        this.f543015c = r102;
        this.f543016d = r103;
        this.f543017e = r104;
        this.f543018f = r105;
        this.f543019g = r110;
        this.f543020h = r111;
        this.f543021i = r112;
        this.f543022j = r113;
        this.f543023k = r114;
        this.f543024l = r115;
        this.f543025m = r116;
        this.f543026n = r117;
        this.f543027o = r118;
    }
}
