package hq9;

import android.app.Activity;
import com.larus.platform.model.NotificationType;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NotificationType f486708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f486709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f486710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f486711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q3 f486712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e4 f486713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f486714l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f486715m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Integer> f486716n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r3 f486717o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Activity f486718p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f486719q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<Unit> f486720r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f486721s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<Unit> f486722t;

    public n3() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n3) == true) goto L8;
        return false;
    L8:
        n3 r101 = (n3) r100;
        if (Intrinsics.areEqual(this.f486703a, r101.f486703a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486704b, r101.f486704b) == true) goto L15;
        return false;
    L15:
        if (this.f486705c == r101.f486705c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486706d, r101.f486706d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486707e, r101.f486707e) == true) goto L24;
        return false;
    L24:
        if (this.f486708f == r101.f486708f) goto L27;
        return false;
    L27:
        if (this.f486709g == r101.f486709g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f486710h, r101.f486710h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f486711i, r101.f486711i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f486712j, r101.f486712j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f486713k, r101.f486713k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f486714l, r101.f486714l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f486715m, r101.f486715m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f486716n, r101.f486716n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f486717o, r101.f486717o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f486718p, r101.f486718p) == true) goto L57;
        return false;
    L57:
        if (this.f486719q == r101.f486719q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f486720r, r101.f486720r) == true) goto L63;
        return false;
    L63:
        if (this.f486721s == r101.f486721s) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f486722t, r101.f486722t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f486703a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f486704b.hashCode()) * 31;
        int r104 = 1231;
        if (this.f486705c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.f486706d.hashCode()) * 31) + this.f486707e.hashCode()) * 31) + this.f486708f.hashCode()) * 31;
        long r107 = this.f486709g;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f486710h.hashCode()) * 31;
        List<String> r109 = this.f486711i;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        q3 r112 = this.f486712j;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        e4 r115 = this.f486713k;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (((((((r114 + r116) * 31) + this.f486714l.hashCode()) * 31) + this.f486715m.hashCode()) * 31) + this.f486716n.hashCode()) * 31;
        r3 r118 = this.f486717o;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        Activity r121 = this.f486718p;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        if (this.f486719q == false) goto L33;
        int r124 = 1231;
    L34:
        int r125 = (r123 + r124) * 31;
        Function0<Unit> r126 = this.f486720r;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        if (this.f486721s == true) goto L42;
        r104 = 1237;
    L42:
        int r129 = (r128 + r104) * 31;
        Function0<Unit> r130 = this.f486722t;
        if (r130 == null) goto L47;
        r101 = r130.hashCode();
    L47:
        return r129 + r101;
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = 1237;
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
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NotificationRequest(identity=" + this.f486703a + ", avatarUrl=" + this.f486704b + ", avatarRoundAsCircle=" + this.f486705c + ", title=" + this.f486706d + ", content=" + this.f486707e + ", type=" + this.f486708f + ", displayDuration=" + this.f486709g + ", business=" + this.f486710h + ", displayPageName=" + this.f486711i + ", clickCallBack=" + this.f486712j + ", rightTextAction=" + this.f486713k + ", leftImageLocalPath=" + this.f486714l + ", leftImageUrl=" + this.f486715m + ", rightImageResIdList=" + this.f486716n + ", clickImageCallBack=" + this.f486717o + ", targetActivity=" + this.f486718p + ", skipDisplayNameCheck=" + this.f486719q + ", cardClickAction=" + this.f486720r + ", enableSystemWindowFallback=" + this.f486721s + ", dismissCallback=" + this.f486722t + ')';
    }

    public final NotificationType getType() {
        return this.f486708f;
    }

    public n3(String r210, String r211, String r212, String r213, NotificationType r214, long r215, String r310, List r311, q3 r312, e4 r313, String r314, List r315, r3 r316, Activity r317, boolean r318, Function0 r410, boolean r411, Function0 r412, int r413) {
        if ((r413 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r413 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r413 & 4) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r413 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r413 & 16) == 0) goto L21;
        String r110 = "";
    L23:
        if ((r413 & 32) == 0) goto L25;
        NotificationType r111 = NotificationType.DEFAULT;
    L27:
        if ((r413 & 64) == 0) goto L29;
        long r112 = 5000;
    L31:
        if ((r413 & 256) == 0) goto L33;
        List r113 = null;
    L35:
        if ((r413 & 512) == 0) goto L37;
        q3 r114 = null;
    L39:
        if ((r413 & 1024) == 0) goto L41;
        e4 r104 = null;
    L43:
        if ((r413 & 2048) == 0) goto L45;
        String r105 = "";
    L47:
        if ((r413 & 4096) == 0) goto L49;
        String r106 = "";
    L50:
        e4 r115 = r104;
        if ((r413 & 8192) == 0) goto L53;
        List r107 = CollectionsKt.emptyList();
    L54:
        q3 r216 = r114;
        if ((r413 & 16384) == 0) goto L57;
        r3 r116 = null;
    L59:
        if ((r413 & 32768) == 0) goto L61;
        Activity r117 = null;
    L63:
        if ((r413 & 65536) == 0) goto L65;
        boolean r217 = false;
    L67:
        if ((r413 & 131072) == 0) goto L69;
        Function0 r218 = null;
    L71:
        if ((r413 & 262144) == 0) goto L73;
        boolean r219 = false;
    L75:
        if ((r413 & 524288) == 0) goto L77;
        Function0 r118 = null;
    L78:
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r310, "business");
        Intrinsics.checkNotNullParameter(r105, "leftImageLocalPath");
        Intrinsics.checkNotNullParameter(r106, "leftImageUrl");
        Intrinsics.checkNotNullParameter(r107, "rightImageResIdList");
        this.f486703a = r100;
        this.f486704b = r101;
        this.f486705c = r102;
        this.f486706d = r103;
        this.f486707e = r110;
        this.f486708f = r111;
        this.f486709g = r112;
        this.f486710h = r310;
        this.f486711i = r113;
        this.f486712j = r216;
        this.f486713k = r115;
        this.f486714l = r105;
        this.f486715m = r106;
        this.f486716n = r107;
        this.f486717o = r116;
        this.f486718p = r117;
        this.f486719q = r217;
        this.f486720r = r218;
        this.f486721s = r219;
        this.f486722t = r118;
        return;
    L77:
        r118 = r412;
        goto L78
    L73:
        r219 = r411;
        goto L75
    L69:
        r218 = r410;
        goto L71
    L65:
        r217 = r318;
        goto L67
    L61:
        r117 = r317;
        goto L63
    L57:
        r116 = r316;
        goto L59
    L53:
        r107 = r315;
        goto L54
    L49:
        r106 = r314;
        goto L50
    L45:
        r105 = null;
        goto L47
    L41:
        r104 = r313;
        goto L43
    L37:
        r114 = r312;
        goto L39
    L33:
        r113 = r311;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L21:
        r110 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
