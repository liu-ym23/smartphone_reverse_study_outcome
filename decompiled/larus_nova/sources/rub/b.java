package rub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f539299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f539300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f539301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f539302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f539303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f539304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f539305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f539306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f539307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f539308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f539309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f539310m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Unit> f539311n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Object> f539312o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MmRecordingUILaunchMode f539313p;

    public b() {
        this(null, null, null, null, null, false, null, null, 65535);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f539298a, r101.f539298a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f539299b, r101.f539299b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539300c, r101.f539300c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f539301d, r101.f539301d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f539302e, r101.f539302e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f539303f, r101.f539303f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f539304g, r101.f539304g) == true) goto L30;
        return false;
    L30:
        if (this.f539305h == r101.f539305h) goto L33;
        return false;
    L33:
        if (this.f539306i == r101.f539306i) goto L36;
        return false;
    L36:
        if (this.f539307j == r101.f539307j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f539308k, r101.f539308k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f539309l, r101.f539309l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f539310m, r101.f539310m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f539311n, r101.f539311n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f539312o, r101.f539312o) == true) goto L54;
        return false;
    L54:
        if (this.f539313p == r101.f539313p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f539298a.hashCode() * 31;
        String r101 = this.f539299b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f539300c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f539301d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f539302e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f539303f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f539304g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        int r120 = 1231;
        if (this.f539305h == false) goto L29;
        int r121 = 1231;
    L30:
        int r122 = (r119 + r121) * 31;
        if (this.f539306i == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r122 + r123) * 31;
        if (this.f539307j == true) goto L38;
        r120 = 1237;
    L38:
        int r125 = (r124 + r120) * 31;
        Function0<Unit> r126 = this.f539308k;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        Function0<Unit> r129 = this.f539309l;
        if (r129 != null) goto L45;
        int r130 = 0;
    L46:
        int r131 = (r128 + r130) * 31;
        Function0<Unit> r132 = this.f539310m;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        Function0<Unit> r135 = this.f539311n;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        Map<String, Object> r138 = this.f539312o;
        if (r138 == null) goto L59;
        r102 = r138.hashCode();
    L59:
        return ((r137 + r102) * 31) + this.f539313p.hashCode();
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = r129.hashCode();
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L33:
        r123 = 1237;
        goto L34
    L29:
        r121 = 1237;
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmDialogConfig(id=" + this.f539298a + ", title=" + this.f539299b + ", content=" + this.f539300c + ", primaryButtonText=" + this.f539301d + ", secondaryButtonText=" + this.f539302e + ", primaryButtonTextColor=" + this.f539303f + ", secondaryButtonTextColor=" + this.f539304g + ", isCancelable=" + this.f539305h + ", dismissOnBackPress=" + this.f539306i + ", dismissOnClickOutside=" + this.f539307j + ", onPrimaryButtonClick=" + this.f539308k + ", onSecondaryButtonClick=" + this.f539309l + ", onDismiss=" + this.f539310m + ", onShow=" + this.f539311n + ", extraData=" + this.f539312o + ", uiLaunchMode=" + this.f539313p + ')';
    }

    public b(String r100, String r101, String r102, String r103, Integer r104, boolean r110, Function0 r111, MmRecordingUILaunchMode r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = "mm_default_dialog";
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 128) == 0) goto L20;
        r110 = true;
    L20:
        boolean r105 = false;
        if ((r113 & 256) == 0) goto L23;
        boolean r106 = r110;
    L25:
        if ((r113 & 512) == 0) goto L28;
        r105 = r110;
    L28:
        if ((r113 & 4096) == 0) goto L31;
        r111 = null;
    L31:
        if ((r113 & 32768) == 0) goto L33;
        r112 = MmRecordingUILaunchMode.UNKNOWN;
    L33:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r112, "uiLaunchMode");
        this.f539298a = r100;
        this.f539299b = r101;
        this.f539300c = r102;
        this.f539301d = r103;
        this.f539302e = null;
        this.f539303f = r104;
        this.f539304g = null;
        this.f539305h = r110;
        this.f539306i = r106;
        this.f539307j = r105;
        this.f539308k = null;
        this.f539309l = null;
        this.f539310m = r111;
        this.f539311n = null;
        this.f539312o = null;
        this.f539313p = r112;
        return;
    L23:
        r106 = false;
        goto L25
    }
}
