package rub;

import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f539283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f539284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f539285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmBubbleDirection f539286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f539287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f539288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f539289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f539290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f539291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f539292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f539293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Point f539294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f539295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Unit> f539296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MmRecordingUILaunchMode f539297o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f539283a, r101.f539283a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f539284b, r101.f539284b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539285c, r101.f539285c) == true) goto L18;
        return false;
    L18:
        if (this.f539286d == r101.f539286d) goto L21;
        return false;
    L21:
        if (this.f539287e == r101.f539287e) goto L24;
        return false;
    L24:
        if (this.f539288f == r101.f539288f) goto L27;
        return false;
    L27:
        if (this.f539289g == r101.f539289g) goto L30;
        return false;
    L30:
        if (this.f539290h == r101.f539290h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f539291i, r101.f539291i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f539292j, r101.f539292j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f539293k, r101.f539293k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f539294l, r101.f539294l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f539295m, r101.f539295m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f539296n, r101.f539296n) == true) goto L51;
        return false;
    L51:
        if (this.f539297o == r101.f539297o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f539283a.hashCode() * 31;
        String r101 = this.f539284b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        CharSequence r105 = this.f539285c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f539286d.hashCode()) * 31;
        int r108 = 1231;
        if (this.f539287e == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f539288f == false) goto L17;
        int r111 = 1231;
    L18:
        long r112 = this.f539289g;
        int r113 = (((r110 + r111) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        if (this.f539290h == true) goto L22;
        r108 = 1237;
    L22:
        int r114 = (r113 + r108) * 31;
        Integer r115 = this.f539291i;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.f539292j;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f539293k;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Point r124 = this.f539294l;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Function0<Unit> r127 = this.f539295m;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        Function0<Unit> r130 = this.f539296n;
        if (r130 == null) goto L47;
        r102 = r130.hashCode();
    L47:
        return ((r129 + r102) * 31) + this.f539297o.hashCode();
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmBubbleConfig(anchorView=" + this.f539283a + ", title=" + this.f539284b + ", detail=" + this.f539285c + ", direction=" + this.f539286d + ", cancelable=" + this.f539287e + ", autoDismiss=" + this.f539288f + ", autoDismissTime=" + this.f539289g + ", showClose=" + this.f539290h + ", maxWidthPx=" + this.f539291i + ", detailMaxLines=" + this.f539292j + ", anchorMarginDp=" + this.f539293k + ", anchorOffsetPx=" + this.f539294l + ", onClose=" + this.f539295m + ", onDismiss=" + this.f539296n + ", uiLaunchMode=" + this.f539297o + ')';
    }

    public a(View r100, String r101, CharSequence r102, MmBubbleDirection r103, boolean r110, boolean r111, long r112, boolean r113, Integer r114, Integer r115, Integer r116, Point r117, Function0<Unit> r118, Function0<Unit> r210, MmRecordingUILaunchMode r211) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r103, "direction");
        Intrinsics.checkNotNullParameter(r211, "uiLaunchMode");
        this.f539283a = r100;
        this.f539284b = r101;
        this.f539285c = r102;
        this.f539286d = r103;
        this.f539287e = r110;
        this.f539288f = r111;
        this.f539289g = r112;
        this.f539290h = r113;
        this.f539291i = r114;
        this.f539292j = r115;
        this.f539293k = r116;
        this.f539294l = r117;
        this.f539295m = r118;
        this.f539296n = r210;
        this.f539297o = r211;
    }
}
