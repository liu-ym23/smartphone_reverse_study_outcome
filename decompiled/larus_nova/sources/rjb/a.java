package rjb;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f538184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f538185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f538186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f538187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Activity f538188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f538189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f538190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f538191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f538192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f538193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f538194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f538195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f538196m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f538184a, r101.f538184a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538185b, r101.f538185b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f538186c, r101.f538186c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f538187d, r101.f538187d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f538188e, r101.f538188e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f538189f, r101.f538189f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f538190g, r101.f538190g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f538191h, r101.f538191h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f538192i, r101.f538192i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f538193j, r101.f538193j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f538194k, r101.f538194k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f538195l, r101.f538195l) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f538196m, r101.f538196m) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        b r100 = this.f538184a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        View r104 = this.f538185b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f538186c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f538187d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Activity r113 = this.f538188e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f538189f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f538190g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f538191h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f538192i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f538193j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        f r131 = this.f538194k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (((r130 + r132) * 31) + 0) * 31;
        Boolean r134 = this.f538195l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        PopupWindow.OnDismissListener r137 = this.f538196m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
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
        return "BuildParams(component=" + this.f538184a + ", anchorView=" + this.f538185b + ", outsideDismiss=" + this.f538186c + ", bgEnable=" + this.f538187d + ", activity=" + this.f538188e + ", bgAlpha=" + this.f538189f + ", bgColor=" + this.f538190g + ", highlightEnable=" + this.f538191h + ", highlightCorner=" + this.f538192i + ", highlightStyle=" + this.f538193j + ", highlightHandler=" + this.f538194k + ", onBackPressedListener=null, focusable=" + this.f538195l + ", onDismissListener=" + this.f538196m + ')';
    }

    public final Activity getActivity() {
        return this.f538188e;
    }

    public a(b r100, View r101, Boolean r102, Boolean r103, Activity r104, Integer r105, Integer r106, Boolean r107, Integer r108, Integer r110, f r111, Boolean r112, PopupWindow.OnDismissListener r113) {
        this.f538184a = r100;
        this.f538185b = r101;
        this.f538186c = r102;
        this.f538187d = r103;
        this.f538188e = r104;
        this.f538189f = r105;
        this.f538190g = r106;
        this.f538191h = r107;
        this.f538192i = r108;
        this.f538193j = r110;
        this.f538194k = r111;
        this.f538195l = r112;
        this.f538196m = r113;
    }
}
