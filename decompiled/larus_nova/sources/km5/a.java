package km5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f504064s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f504066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f504067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f504068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f504069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f504070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Integer> f504071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<Integer> f504072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f504073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f504074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f504075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f504076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IDocPublicPermission f504077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IDocUserPermission f504078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f504079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f504080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ShareScene f504081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Object f504082r;

    /* JADX INFO: renamed from: km5.a$a, reason: collision with other inner class name */
    public static final class C6573a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f504065a == r101.f504065a) goto L12;
        return false;
    L12:
        if (this.f504066b == r101.f504066b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f504067c, r101.f504067c) == true) goto L18;
        return false;
    L18:
        if (this.f504068d == r101.f504068d) goto L21;
        return false;
    L21:
        if (this.f504069e == r101.f504069e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f504070f, r101.f504070f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f504071g, r101.f504071g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f504072h, r101.f504072h) == true) goto L33;
        return false;
    L33:
        if (this.f504073i == r101.f504073i) goto L36;
        return false;
    L36:
        if (this.f504074j == r101.f504074j) goto L39;
        return false;
    L39:
        if (this.f504075k == r101.f504075k) goto L42;
        return false;
    L42:
        if (this.f504076l == r101.f504076l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f504077m, r101.f504077m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f504078n, r101.f504078n) == true) goto L51;
        return false;
    L51:
        if (this.f504079o == r101.f504079o) goto L54;
        return false;
    L54:
        if (this.f504080p == r101.f504080p) goto L57;
        return false;
    L57:
        if (this.f504081q == r101.f504081q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f504065a * 31) + this.f504066b) * 31;
        String r101 = this.f504067c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f504068d == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f504069e == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        String r110 = this.f504070f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ArrayList<Integer> r113 = this.f504071g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ArrayList<Integer> r116 = this.f504072h;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f504073i == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f504074j == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f504075k == false) goto L37;
        int r123 = 1231;
    L38:
        int r124 = (r122 + r123) * 31;
        if (this.f504076l == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (r124 + r125) * 31;
        IDocPublicPermission r127 = this.f504077m;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (r126 + r128) * 31;
        IDocUserPermission r130 = this.f504078n;
        if (r130 == null) goto L50;
        r102 = r130.hashCode();
    L50:
        int r131 = (r129 + r102) * 31;
        if (this.f504079o == false) goto L53;
        int r132 = 1231;
    L54:
        int r133 = (r131 + r132) * 31;
        if (this.f504080p == true) goto L59;
        r105 = 1237;
    L59:
        return ((r133 + r105) * 31) + this.f504081q.hashCode();
    L53:
        r132 = 1237;
        goto L54
    L45:
        r128 = r127.hashCode();
        goto L46
    L41:
        r125 = 1237;
        goto L42
    L37:
        r123 = 1237;
        goto L38
    L33:
        r121 = 1237;
        goto L34
    L29:
        r119 = 1237;
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
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DocumentShareItemModelParams(source=" + this.f504065a + ", type=" + this.f504066b + ", token=" + this.f504067c + ", isWiki=" + this.f504068d + ", canExport=" + this.f504069e + ", mindNoteViewType=" + this.f504070f + ", disabledShareTypes=" + this.f504071g + ", badgeShareTypes=" + this.f504072h + ", isAtVC=" + this.f504073i + ", adminPerceiveControl=" + this.f504074j + ", update=" + this.f504075k + ", isSpaceV2=" + this.f504076l + ", publicPermission=" + this.f504077m + ", userPermission=" + this.f504078n + ", isEditionDoc=" + this.f504079o + ", showExportImage=" + this.f504080p + ", shareScene=" + this.f504081q + ')';
    }

    public a(int r100, int r101, String r102, boolean r103, boolean r104, String r105, ArrayList<Integer> r110, ArrayList<Integer> r111, boolean r112, boolean r113, boolean r114, boolean r115, IDocPublicPermission r116, IDocUserPermission r117, boolean r118, boolean r119, ShareScene r210) {
        Intrinsics.checkNotNullParameter(r210, "shareScene");
        this.f504065a = r100;
        this.f504066b = r101;
        this.f504067c = r102;
        this.f504068d = r103;
        this.f504069e = r104;
        this.f504070f = r105;
        this.f504071g = r110;
        this.f504072h = r111;
        this.f504073i = r112;
        this.f504074j = r113;
        this.f504075k = r114;
        this.f504076l = r115;
        this.f504077m = r116;
        this.f504078n = r117;
        this.f504079o = r118;
        this.f504080p = r119;
        this.f504081q = r210;
    }

    public /* synthetic */ a(int r210, int r211, String r212, boolean r213, boolean r214, String r215, ArrayList r216, ArrayList r217, boolean r310, boolean r311, boolean r312, boolean r313, IDocPublicPermission r314, IDocUserPermission r315, boolean r316, boolean r317, ShareScene r318, int r319) {
        if ((r319 & 16384) == 0) goto L5;
        boolean r110 = false;
    L7:
        if ((32768 & r319) == 0) goto L9;
        boolean r111 = false;
    L11:
        if ((r319 & 65536) == 0) goto L13;
        ShareScene r218 = ShareScene.DOCUMENT;
    L14:
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r110, r111, r218);
        return;
    L13:
        r218 = r318;
        goto L14
    L9:
        r111 = r317;
        goto L11
    L5:
        r110 = r316;
        goto L7
    }
}
