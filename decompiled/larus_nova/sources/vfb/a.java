package vfb;

import android.graphics.Rect;
import android.view.View;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.enums.SidePattern;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wfb.b;
import wfb.c;
import wfb.d;
import wfb.f;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public f A;
    public wfb.a B;
    public final d C;
    public final b D;
    public final c E;
    public final Set<String> F;
    public final boolean G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f554606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f554607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f554608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f554609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f554610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f554611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f554612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f554613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f554614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f554615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f554616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f554617l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SidePattern f554618m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ShowPattern f554619n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f554620o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f554621p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f554622q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f554623r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f554624s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f554625t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f554626u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Pair<Integer, Integer> f554627v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f554628w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f554629x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Pair<Integer, Integer> f554630y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<Rect> f554631z;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f554606a, r101.f554606a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554607b, r101.f554607b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554608c, r101.f554608c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554609d, r101.f554609d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f554610e, r101.f554610e) == true) goto L24;
        return false;
    L24:
        if (this.f554611f == r101.f554611f) goto L27;
        return false;
    L27:
        if (this.f554612g == r101.f554612g) goto L30;
        return false;
    L30:
        if (this.f554613h == r101.f554613h) goto L33;
        return false;
    L33:
        if (this.f554614i == r101.f554614i) goto L36;
        return false;
    L36:
        if (this.f554615j == r101.f554615j) goto L39;
        return false;
    L39:
        if (this.f554616k == r101.f554616k) goto L42;
        return false;
    L42:
        if (this.f554617l == r101.f554617l) goto L45;
        return false;
    L45:
        if (this.f554618m == r101.f554618m) goto L48;
        return false;
    L48:
        if (this.f554619n == r101.f554619n) goto L51;
        return false;
    L51:
        if (this.f554620o == r101.f554620o) goto L54;
        return false;
    L54:
        if (this.f554621p == r101.f554621p) goto L57;
        return false;
    L57:
        if (this.f554622q == r101.f554622q) goto L60;
        return false;
    L60:
        if (Float.compare(this.f554623r, r101.f554623r) == 0) goto L63;
        return false;
    L63:
        if (this.f554624s == r101.f554624s) goto L66;
        return false;
    L66:
        if (this.f554625t == r101.f554625t) goto L69;
        return false;
    L69:
        if (this.f554626u == r101.f554626u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f554627v, r101.f554627v) == true) goto L75;
        return false;
    L75:
        if (this.f554628w == r101.f554628w) goto L78;
        return false;
    L78:
        if (this.f554629x == r101.f554629x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f554630y, r101.f554630y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f554631z, r101.f554631z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(null, null) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L108;
        return false;
    L108:
        if (this.G == r101.G) goto L111;
        return false;
    L111:
        if (this.H == r101.H) goto L113;
        return false;
    L113:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f554606a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        View r104 = this.f554607b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f554608c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f554609d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f554610e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((((r112 + r114) * 31) + this.f554611f) * 31) + this.f554612g) * 31;
        int r116 = 1231;
        if (this.f554613h == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f554614i == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f554615j == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f554616k == false) goto L37;
        int r123 = 1231;
    L38:
        int r124 = (r122 + r123) * 31;
        if (this.f554617l == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (((((r124 + r125) * 31) + this.f554618m.hashCode()) * 31) + this.f554619n.hashCode()) * 31;
        if (this.f554620o == false) goto L45;
        int r127 = 1231;
    L46:
        int r128 = (r126 + r127) * 31;
        if (this.f554621p == false) goto L49;
        int r129 = 1231;
    L50:
        int r130 = (r128 + r129) * 31;
        if (this.f554622q == false) goto L53;
        int r131 = 1231;
    L54:
        int r132 = (((r130 + r131) * 31) + Float.floatToIntBits(this.f554623r)) * 31;
        if (this.f554624s == false) goto L57;
        int r133 = 1231;
    L58:
        int r134 = (r132 + r133) * 31;
        if (this.f554625t == false) goto L61;
        int r135 = 1231;
    L62:
        int r136 = (((((((((((((r134 + r135) * 31) + this.f554626u) * 31) + this.f554627v.hashCode()) * 31) + this.f554628w) * 31) + this.f554629x) * 31) + this.f554630y.hashCode()) * 31) + this.f554631z.hashCode()) * 31;
        f r137 = this.A;
        if (r137 != null) goto L65;
        int r138 = 0;
    L66:
        int r139 = (((r136 + r138) * 31) + 0) * 31;
        wfb.a r140 = this.B;
        if (r140 != null) goto L69;
        int r141 = 0;
    L70:
        int r142 = (r139 + r141) * 31;
        d r143 = this.C;
        if (r143 != null) goto L73;
        int r144 = 0;
    L74:
        int r145 = (r142 + r144) * 31;
        b r146 = this.D;
        if (r146 == null) goto L78;
        r101 = r146.hashCode();
    L78:
        int r147 = (((((r145 + r101) * 31) + this.E.hashCode()) * 31) + this.F.hashCode()) * 31;
        if (this.G == false) goto L81;
        int r148 = 1231;
    L82:
        int r149 = (r147 + r148) * 31;
        if (this.H == true) goto L87;
        r116 = 1237;
    L87:
        return r149 + r116;
    L81:
        r148 = 1237;
        goto L82
    L73:
        r144 = r143.hashCode();
        goto L74
    L69:
        r141 = r140.hashCode();
        goto L70
    L65:
        r138 = r137.hashCode();
        goto L66
    L61:
        r135 = 1237;
        goto L62
    L57:
        r133 = 1237;
        goto L58
    L53:
        r131 = 1237;
        goto L54
    L49:
        r129 = 1237;
        goto L50
    L45:
        r127 = 1237;
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
        r117 = 1237;
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
        return "FloatConfig(layoutId=" + this.f554606a + ", layoutView=" + this.f554607b + ", containerView=" + this.f554608c + ", floatTag=" + this.f554609d + ", onlyVc=" + this.f554610e + ", vcSideHideBtnWidth=" + this.f554611f + ", vcShadowWidth=" + this.f554612g + ", dragEnable=" + this.f554613h + ", isDrag=" + this.f554614i + ", _isAnim=" + this.f554615j + ", isShow=" + this.f554616k + ", hasEditText=" + this.f554617l + ", sidePattern=" + this.f554618m + ", showPattern=" + this.f554619n + ", keepScreenOn=" + this.f554620o + ", hardwareAccelerated=" + this.f554621p + ", banRequestPermission=" + this.f554622q + ", dimBehind=" + this.f554623r + ", widthMatch=" + this.f554624s + ", heightMatch=" + this.f554625t + ", gravity=" + this.f554626u + ", offsetPair=" + this.f554627v + ", targetOffsetX=" + this.f554628w + ", targetOffsetY=" + this.f554629x + ", locationPair=" + this.f554630y + ", evictRects=" + this.f554631z + ", invokeView=" + this.A + ", callbacks=null, floatCallbacks=" + this.B + ", floatAnimator=" + this.C + ", appFloatAnimator=" + this.D + ", displayHeight=" + this.E + ", filterSet=" + this.F + ", filterSelf=" + this.G + ", needShow=" + this.H + ')';
    }

    public a(Object r110) {
        SidePattern r111 = SidePattern.DEFAULT;
        ShowPattern r100 = ShowPattern.CURRENT_ACTIVITY;
        Pair<Integer, Integer> r101 = new Pair(0, 0);
        Pair<Integer, Integer> r102 = new Pair(0, 0);
        List<Rect> r103 = CollectionsKt.emptyList();
        ufb.d r104 = new ufb.d();
        ufb.c r105 = new ufb.c();
        xfb.c r106 = new xfb.c();
        LinkedHashSet r107 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r111, "sidePattern");
        Intrinsics.checkNotNullParameter(r100, "showPattern");
        Intrinsics.checkNotNullParameter(r101, "offsetPair");
        Intrinsics.checkNotNullParameter(r102, "locationPair");
        Intrinsics.checkNotNullParameter(r103, "evictRects");
        Intrinsics.checkNotNullParameter(r106, "displayHeight");
        Intrinsics.checkNotNullParameter(r107, "filterSet");
        this.f554606a = null;
        this.f554607b = null;
        this.f554608c = null;
        this.f554609d = null;
        this.f554610e = null;
        this.f554611f = -1;
        this.f554612g = -1;
        this.f554613h = true;
        this.f554614i = false;
        this.f554615j = false;
        this.f554616k = false;
        this.f554617l = false;
        this.f554618m = r111;
        this.f554619n = r100;
        this.f554620o = false;
        this.f554621p = false;
        this.f554622q = false;
        this.f554623r = -1.0f;
        this.f554624s = false;
        this.f554625t = false;
        this.f554626u = 0;
        this.f554627v = r101;
        this.f554628w = 0;
        this.f554629x = 0;
        this.f554630y = r102;
        this.f554631z = r103;
        this.A = null;
        this.B = null;
        this.C = r104;
        this.D = r105;
        this.E = r106;
        this.F = r107;
        this.G = false;
        this.H = true;
    }
}
