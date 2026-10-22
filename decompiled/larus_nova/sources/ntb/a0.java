package ntb;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f520548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f520549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f520550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f520551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f520552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f520553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f520554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f520555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f520556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<String, String> f520557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<String, Boolean> f520558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<String, Unit> f520559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f520560o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f520546a, r101.f520546a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520547b, r101.f520547b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f520548c, r101.f520548c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f520549d, r101.f520549d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f520550e, r101.f520550e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f520551f, r101.f520551f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f520552g, r101.f520552g) == true) goto L30;
        return false;
    L30:
        if (Float.compare(this.f520553h, r101.f520553h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.f520554i, r101.f520554i) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.f520555j, r101.f520555j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.f520556k, r101.f520556k) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f520557l, r101.f520557l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f520558m, r101.f520558m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f520559n, r101.f520559n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f520560o, r101.f520560o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f520546a.hashCode() * 31) + this.f520547b.hashCode()) * 31) + Float.floatToIntBits(this.f520548c)) * 31) + Float.floatToIntBits(this.f520549d)) * 31) + Float.floatToIntBits(this.f520550e)) * 31;
        String r101 = this.f520551f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((((((((r100 + r103) * 31) + this.f520552g.hashCode()) * 31) + Float.floatToIntBits(this.f520553h)) * 31) + Float.floatToIntBits(this.f520554i)) * 31) + Float.floatToIntBits(this.f520555j)) * 31) + Float.floatToIntBits(this.f520556k)) * 31) + this.f520557l.hashCode()) * 31;
        Function1<String, Boolean> r105 = this.f520558m;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f520559n.hashCode()) * 31;
        Function0<Unit> r108 = this.f520560o;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PanelMarkdownRenderConfig(markdown=" + this.f520546a + ", textColor=" + this.f520547b + ", textSizeSp=" + this.f520548c + ", lineHeightDp=" + this.f520549d + ", lineSpacingDp=" + this.f520550e + ", linkTextColor=" + this.f520551f + ", listMarkerColor=" + this.f520552g + ", listMarkerSizeDp=" + this.f520553h + ", paragraphGap=" + this.f520554i + ", listMarkerStartMarginDp=" + this.f520555j + ", listTextStartMarginDp=" + this.f520556k + ", resolveMarkdownLink=" + this.f520557l + ", onLinkClick=" + this.f520558m + ", openUrl=" + this.f520559n + ", onContentLayout=" + this.f520560o + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(String r100, String r101, float r110, float r111, float r112, String r113, String r114, float r115, float r116, float r117, float r118, Function1<? super String, String> r119, Function1<? super String, Boolean> r210, Function1<? super String, Unit> r211, Function0<Unit> r212) {
        Intrinsics.checkNotNullParameter(r100, "markdown");
        Intrinsics.checkNotNullParameter(r101, "textColor");
        Intrinsics.checkNotNullParameter(r114, "listMarkerColor");
        Intrinsics.checkNotNullParameter(r119, "resolveMarkdownLink");
        Intrinsics.checkNotNullParameter(r211, RuleConditionBean.OPEN_URL_KEY);
        this.f520546a = r100;
        this.f520547b = r101;
        this.f520548c = r110;
        this.f520549d = r111;
        this.f520550e = r112;
        this.f520551f = r113;
        this.f520552g = r114;
        this.f520553h = r115;
        this.f520554i = r116;
        this.f520555j = r117;
        this.f520556k = r118;
        this.f520557l = r119;
        this.f520558m = r210;
        this.f520559n = r211;
        this.f520560o = r212;
    }
}
