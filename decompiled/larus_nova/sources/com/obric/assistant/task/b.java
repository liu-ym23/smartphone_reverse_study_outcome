package com.obric.assistant.task;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f393374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f393375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f393376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f393377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f393378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f393379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TaskStatus f393380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f393381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f393382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f393383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f393384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f393385l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f393386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f393387n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f393388o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f393389p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f393390q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f393374a, r101.f393374a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f393375b, r101.f393375b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f393376c, r101.f393376c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f393377d, r101.f393377d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f393378e, r101.f393378e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f393379f, r101.f393379f) == true) goto L27;
        return false;
    L27:
        if (this.f393380g == r101.f393380g) goto L30;
        return false;
    L30:
        if (this.f393381h == r101.f393381h) goto L33;
        return false;
    L33:
        if (this.f393382i == r101.f393382i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f393383j, r101.f393383j) == true) goto L39;
        return false;
    L39:
        if (this.f393384k == r101.f393384k) goto L42;
        return false;
    L42:
        if (this.f393385l == r101.f393385l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f393386m, r101.f393386m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f393387n, r101.f393387n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f393388o, r101.f393388o) == true) goto L54;
        return false;
    L54:
        if (this.f393389p == r101.f393389p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f393374a.hashCode() * 31) + this.f393375b.hashCode()) * 31) + this.f393376c.hashCode()) * 31) + this.f393377d.hashCode()) * 31;
        Drawable r101 = this.f393378e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Drawable r105 = this.f393379f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f393380g.hashCode()) * 31) + this.f393381h) * 31;
        int r108 = 1231;
        if (this.f393382i == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f393383j;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f393384k == false) goto L21;
        int r114 = 1231;
    L22:
        long r115 = this.f393385l;
        int r116 = (((r113 + r114) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        Function0<Unit> r117 = this.f393386m;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f393387n;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Function0<Unit> r123 = this.f393388o;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        int r124 = (r122 + r102) * 31;
        if (this.f393389p == true) goto L39;
        r108 = 1237;
    L39:
        return r124 + r108;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
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
        return "TaskEntry(id=" + this.f393374a + ", collapsedTitle=" + this.f393375b + ", expandedTitle=" + this.f393376c + ", description=" + this.f393377d + ", collapsedIcon=" + this.f393378e + ", expandedIcon=" + this.f393379f + ", status=" + this.f393380g + ", progress=" + this.f393381h + ", hideProgressWhenCollapsed=" + this.f393382i + ", statusText=" + this.f393383j + ", isHighlight=" + this.f393384k + ", timestamp=" + this.f393385l + ", clickAction=" + this.f393386m + ", swipeBtnText=" + this.f393387n + ", swipeAction=" + this.f393388o + ", completeSuccess=" + this.f393389p + ')';
    }

    public static b a(b r210, String r211, long r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = r210.f393374a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        CharSequence r101 = r210.f393375b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        CharSequence r102 = r210.f393376c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        CharSequence r103 = r210.f393377d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        Drawable r104 = r210.f393378e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Drawable r110 = r210.f393379f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        TaskStatus r111 = r210.f393380g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r112 = r210.f393381h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        boolean r113 = r210.f393382i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        String r114 = r210.f393383j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        boolean r115 = r210.f393384k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        long r116 = r210.f393385l;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        Function0<Unit> r105 = r210.f393386m;
    L55:
        if ((r213 & 8192) == 0) goto L57;
        String r117 = r210.f393387n;
    L59:
        if ((r213 & 16384) == 0) goto L61;
        Function0<Unit> r214 = r210.f393388o;
    L63:
        if ((r213 & 32768) == 0) goto L65;
        boolean r215 = r210.f393389p;
    L66:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "collapsedTitle");
        Intrinsics.checkNotNullParameter(r102, "expandedTitle");
        Intrinsics.checkNotNullParameter(r103, "description");
        Intrinsics.checkNotNullParameter(r111, "status");
        return new b(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r105, r117, r214, r215);
    L65:
        r215 = false;
        goto L66
    L61:
        r214 = null;
        goto L63
    L57:
        r117 = null;
        goto L59
    L53:
        r105 = null;
        goto L55
    L49:
        r116 = r212;
        goto L51
    L45:
        r115 = false;
        goto L47
    L41:
        r114 = r211;
        goto L43
    L37:
        r113 = false;
        goto L39
    L33:
        r112 = 0;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public b(String r100, CharSequence r101, CharSequence r110, CharSequence r111, Drawable r112, Drawable r113, TaskStatus r114, int r115, boolean r116, String r117, boolean r118, long r119, Function0<Unit> r210, String r211, Function0<Unit> r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "collapsedTitle");
        Intrinsics.checkNotNullParameter(r110, "expandedTitle");
        Intrinsics.checkNotNullParameter(r111, "description");
        Intrinsics.checkNotNullParameter(r114, "status");
        this.f393374a = r100;
        this.f393375b = r101;
        this.f393376c = r110;
        this.f393377d = r111;
        this.f393378e = r112;
        this.f393379f = r113;
        this.f393380g = r114;
        this.f393381h = r115;
        this.f393382i = r116;
        this.f393383j = r117;
        this.f393384k = r118;
        this.f393385l = r119;
        this.f393386m = r210;
        this.f393387n = r211;
        this.f393388o = r212;
        this.f393389p = r213;
        this.f393390q = SystemClock.elapsedRealtime();
    }
}
