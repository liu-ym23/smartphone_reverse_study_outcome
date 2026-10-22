package m0a;

import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommunityCreateLaunchModeKmp f511500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f511501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f511502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f511503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f511504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f511505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f511506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f511507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f511508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f511509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f511510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f511511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f511512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f511513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f511514o;

    public e() {
        this(null, 0, false, null, null, null, null, null, null, 0, null, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f511500a == r101.f511500a) goto L12;
        return false;
    L12:
        if (this.f511501b == r101.f511501b) goto L15;
        return false;
    L15:
        if (this.f511502c == r101.f511502c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511503d, r101.f511503d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f511504e, r101.f511504e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f511505f, r101.f511505f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f511506g, r101.f511506g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f511507h, r101.f511507h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f511508i, r101.f511508i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f511509j, r101.f511509j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f511510k, r101.f511510k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f511511l, r101.f511511l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f511512m, r101.f511512m) == true) goto L48;
        return false;
    L48:
        if (this.f511513n == r101.f511513n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f511514o, r101.f511514o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f511500a.hashCode() * 31) + this.f511501b) * 31;
        if (this.f511502c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f511503d;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f511504e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f511505f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f511506g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f511507h;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f511508i;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f511509j;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f511510k;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f511511l;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f511512m;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (((r130 + r132) * 31) + this.f511513n) * 31;
        String r134 = this.f511514o;
        if (r134 == null) goto L51;
        r104 = r134.hashCode();
    L51:
        return r133 + r104;
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
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommunityCreateInitParamsKmp(launchMode=" + this.f511500a + ", recommendType=" + this.f511501b + ", isMultiTab=" + this.f511502c + ", previousPage=" + this.f511503d + ", enterMethod=" + this.f511504e + ", enterFrom=" + this.f511505f + ", botId=" + this.f511506g + ", conversationId=" + this.f511507h + ", initRecommendation=" + this.f511508i + ", initRecommendCreationId=" + this.f511509j + ", defaultLandingTabId=" + this.f511510k + ", templatePageType=" + this.f511511l + ", multiTabTitleName=" + this.f511512m + ", topPadding=" + this.f511513n + ", overrideCurrentPage=" + this.f511514o + ')';
    }

    public e(CommunityCreateLaunchModeKmp r100, int r101, boolean r102, String r103, String r104, String r105, String r106, String r110, String r111, int r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = CommunityCreateLaunchModeKmp.STANDALONE;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r114 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r114 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r114 & 1024) == 0) goto L24;
        r106 = null;
    L24:
        if ((r114 & 2048) == 0) goto L27;
        r110 = null;
    L27:
        if ((r114 & 4096) == 0) goto L30;
        r111 = null;
    L30:
        if ((r114 & 8192) == 0) goto L33;
        r112 = -1;
    L33:
        if ((r114 & 16384) == 0) goto L35;
        r113 = null;
    L35:
        Intrinsics.checkNotNullParameter(r100, "launchMode");
        this.f511500a = r100;
        this.f511501b = r101;
        this.f511502c = r102;
        this.f511503d = r103;
        this.f511504e = r104;
        this.f511505f = null;
        this.f511506g = r105;
        this.f511507h = null;
        this.f511508i = null;
        this.f511509j = null;
        this.f511510k = r106;
        this.f511511l = r110;
        this.f511512m = r111;
        this.f511513n = r112;
        this.f511514o = r113;
    }
}
