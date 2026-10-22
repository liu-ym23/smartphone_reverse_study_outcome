package ms9;

import android.graphics.Bitmap;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f515504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f515505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f515507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f515508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f515509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f515510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f515511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bitmap f515512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bitmap f515513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f515514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f515515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f515516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f515517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f515518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f515519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Uri f515520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f515521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f515522s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f515523t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final JSONObject f515524u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f515525v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f515526w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f515527x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f515528y;

    public a() {
        this(null, null, null, 33554431);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f515504a == r101.f515504a) goto L12;
        return false;
    L12:
        if (this.f515505b == r101.f515505b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f515506c, r101.f515506c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515507d, r101.f515507d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f515508e, r101.f515508e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f515509f, r101.f515509f) == true) goto L27;
        return false;
    L27:
        if (this.f515510g == r101.f515510g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f515511h, r101.f515511h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f515512i, r101.f515512i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f515513j, r101.f515513j) == true) goto L39;
        return false;
    L39:
        if (this.f515514k == r101.f515514k) goto L42;
        return false;
    L42:
        if (this.f515515l == r101.f515515l) goto L45;
        return false;
    L45:
        if (this.f515516m == r101.f515516m) goto L48;
        return false;
    L48:
        if (this.f515517n == r101.f515517n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f515518o, r101.f515518o) == true) goto L54;
        return false;
    L54:
        if (this.f515519p == r101.f515519p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f515520q, r101.f515520q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f515521r, r101.f515521r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f515522s, r101.f515522s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f515523t, r101.f515523t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f515524u, r101.f515524u) == true) goto L72;
        return false;
    L72:
        if (this.f515525v == r101.f515525v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f515526w, r101.f515526w) == true) goto L78;
        return false;
    L78:
        if (this.f515527x == r101.f515527x) goto L81;
        return false;
    L81:
        if (this.f515528y == r101.f515528y) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f515504a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f515505b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        String r105 = this.f515506c;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f515507d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f515508e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f515509f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (((r114 + r116) * 31) + this.f515510g) * 31;
        String r118 = this.f515511h;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        Bitmap r121 = this.f515512i;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        Bitmap r124 = this.f515513j;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (((r123 + r125) * 31) + this.f515514k) * 31;
        if (this.f515515l == false) goto L37;
        int r127 = 1231;
    L38:
        int r128 = (r126 + r127) * 31;
        if (this.f515516m == false) goto L41;
        int r129 = 1231;
    L42:
        int r130 = (r128 + r129) * 31;
        if (this.f515517n == false) goto L45;
        int r131 = 1231;
    L46:
        int r132 = (r130 + r131) * 31;
        String r133 = this.f515518o;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (((r132 + r134) * 31) + this.f515519p) * 31;
        Uri r136 = this.f515520q;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        String r139 = this.f515521r;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        String r142 = this.f515522s;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        String r145 = this.f515523t;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        JSONObject r148 = this.f515524u;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (((r147 + r149) * 31) + this.f515525v) * 31;
        String r151 = this.f515526w;
        if (r151 == null) goto L74;
        r106 = r151.hashCode();
    L74:
        int r152 = (((r150 + r106) * 31) + this.f515527x) * 31;
        if (this.f515528y == true) goto L79;
        r102 = 1237;
    L79:
        return r152 + r102;
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = 1237;
        goto L46
    L41:
        r129 = 1237;
        goto L42
    L37:
        r127 = 1237;
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowNotificationBody(id=" + this.f515504a + ", showWhen=" + this.f515505b + ", title=" + this.f515506c + ", content=" + this.f515507d + ", groupId=" + this.f515508e + ", channelId=" + this.f515509f + ", redBadgeNum=" + this.f515510g + ", imageUrl=" + this.f515511h + ", imageBitmap=" + this.f515512i + ", iconBitmap=" + this.f515513j + ", imageType=" + this.f515514k + ", useLED=" + this.f515515l + ", useSound=" + this.f515516m + ", useVibrator=" + this.f515517n + ", androidGroup=" + this.f515518o + ", groupFoldNum=" + this.f515519p + ", sound=" + this.f515520q + ", bdPushStr=" + this.f515521r + ", appName=" + this.f515522s + ", openUrl=" + this.f515523t + ", eventExtra=" + this.f515524u + ", channelImportance=" + this.f515525v + ", notificationCategory=" + this.f515526w + ", avatarDisplayMode=" + this.f515527x + ", forceSameWithIos=" + this.f515528y + ')';
    }

    public a(String r100, String r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 8) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 128) == 0) goto L11;
        r102 = null;
    L11:
        this.f515504a = 0;
        this.f515505b = false;
        this.f515506c = r100;
        this.f515507d = r101;
        this.f515508e = null;
        this.f515509f = null;
        this.f515510g = 0;
        this.f515511h = r102;
        this.f515512i = null;
        this.f515513j = null;
        this.f515514k = 0;
        this.f515515l = false;
        this.f515516m = false;
        this.f515517n = false;
        this.f515518o = null;
        this.f515519p = 0;
        this.f515520q = null;
        this.f515521r = null;
        this.f515522s = null;
        this.f515523t = null;
        this.f515524u = null;
        this.f515525v = 0;
        this.f515526w = null;
        this.f515527x = 0;
        this.f515528y = false;
    }
}
