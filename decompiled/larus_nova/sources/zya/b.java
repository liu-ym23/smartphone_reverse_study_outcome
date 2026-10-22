package zya;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yya.i;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f573987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f573988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f573989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f573990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f573991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f573992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f573993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f573994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f573995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f573996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f573997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f573998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i f573999n;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f573987b, r101.f573987b) == true) goto L12;
        return false;
    L12:
        if (this.f573988c == r101.f573988c) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573989d, r101.f573989d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573990e, r101.f573990e) == true) goto L21;
        return false;
    L21:
        if (this.f573991f == r101.f573991f) goto L24;
        return false;
    L24:
        if (this.f573992g == r101.f573992g) goto L27;
        return false;
    L27:
        if (this.f573993h == r101.f573993h) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f573994i, r101.f573994i) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f573995j, r101.f573995j) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f573996k, r101.f573996k) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f573997l, r101.f573997l) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f573998m, r101.f573998m) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f573999n, r101.f573999n) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f573987b.hashCode() * 31;
        int r101 = 1231;
        if (this.f573988c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Integer r104 = this.f573989d;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r103 + r106) * 31) + this.f573990e.hashCode()) * 31;
        if (this.f573991f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f573992g == true) goto L18;
        r101 = 1237;
    L18:
        int r110 = (((r109 + r101) * 31) + this.f573993h) * 31;
        View r111 = this.f573994i;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        d r114 = this.f573995j;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        List<b> r117 = this.f573996k;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        c r120 = this.f573997l;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f573998m;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        i r126 = this.f573999n;
        if (r126 == null) goto L43;
        r105 = r126.hashCode();
    L43:
        return r125 + r105;
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContentMessageActionItem(icon=" + this.f573987b + ", useCustomIconColor=" + this.f573988c + ", customTintColorRes=" + this.f573989d + ", label=" + this.f573990e + ", showRedDot=" + this.f573991f + ", enable=" + this.f573992g + ", itemType=" + this.f573993h + ", customView=" + this.f573994i + ", actionCallback=" + this.f573995j + ", childItems=" + this.f573996k + ", gridDisplayParam=" + this.f573997l + ", tag=" + this.f573998m + ", realAction=" + this.f573999n + ')';
    }

    @Override // zya.e
    public final int a() {
        return this.f573993h;
    }

    @Override // zya.e
    public final void b(int r100) {
        this.f573993h = r100;
    }

    public b(Drawable r100, boolean r101, Integer r102, String r103, boolean r104, boolean r105, int r106, View r107, d r108, List r110, i r111) {
        super(r106);
        this.f573987b = r100;
        this.f573988c = r101;
        this.f573989d = r102;
        this.f573990e = r103;
        this.f573991f = r104;
        this.f573992g = r105;
        this.f573993h = r106;
        this.f573994i = r107;
        this.f573995j = r108;
        this.f573996k = r110;
        this.f573997l = null;
        this.f573998m = null;
        this.f573999n = r111;
    }
}
