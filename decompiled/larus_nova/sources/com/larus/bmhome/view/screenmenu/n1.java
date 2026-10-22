package com.larus.bmhome.view.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n1 implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f317352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f317353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f317354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f317355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f317356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f317357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f317358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f317359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f317360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f317361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Boolean, Unit> f317362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<Boolean, Unit> f317363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f317364m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r101 = (n1) r100;
        if (this.f317352a == r101.f317352a) goto L12;
        return false;
    L12:
        if (this.f317353b == r101.f317353b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f317354c, r101.f317354c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f317355d, r101.f317355d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f317356e, r101.f317356e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f317357f, r101.f317357f) == true) goto L27;
        return false;
    L27:
        if (this.f317358g == r101.f317358g) goto L30;
        return false;
    L30:
        if (this.f317359h == r101.f317359h) goto L33;
        return false;
    L33:
        if (this.f317360i == r101.f317360i) goto L36;
        return false;
    L36:
        if (this.f317361j == r101.f317361j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f317362k, r101.f317362k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f317363l, r101.f317363l) == true) goto L45;
        return false;
    L45:
        if (this.f317364m == r101.f317364m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f317352a * 31;
        int r101 = 1231;
        if (this.f317353b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f317354c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f317355d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f317356e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f317357f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f317358g == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f317359h == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f317360i == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f317361j == false) goto L37;
        int r123 = 1231;
    L38:
        int r124 = (((r122 + r123) * 31) + this.f317362k.hashCode()) * 31;
        Function1<Boolean, Unit> r125 = this.f317363l;
        if (r125 == null) goto L42;
        r105 = r125.hashCode();
    L42:
        int r126 = (r124 + r105) * 31;
        if (this.f317364m == true) goto L47;
        r101 = 1237;
    L47:
        return r126 + r101;
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
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SwitchMenuV2(id=" + this.f317352a + ", removeAroundDivider=" + this.f317353b + ", textString=" + this.f317354c + ", iconUrl=" + this.f317355d + ", textIcon=" + this.f317356e + ", textColor=" + this.f317357f + ", isSelected=" + this.f317358g + ", forbiddenDismissAfterClick=" + this.f317359h + ", switchStatus=" + this.f317360i + ", disableClick=" + this.f317361j + ", onSwitchCheckStateChange=" + this.f317362k + ", onTap=" + this.f317363l + ", isGray=" + this.f317364m + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f317353b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f317352a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n1(int r100, boolean r101, String r102, String r103, Integer r104, Integer r105, boolean r106, boolean r107, boolean r110, boolean r111, Function1<? super Boolean, Unit> r112, Function1<? super Boolean, Unit> r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r112, "onSwitchCheckStateChange");
        this.f317352a = r100;
        this.f317353b = r101;
        this.f317354c = r102;
        this.f317355d = r103;
        this.f317356e = r104;
        this.f317357f = r105;
        this.f317358g = r106;
        this.f317359h = r107;
        this.f317360i = r110;
        this.f317361j = r111;
        this.f317362k = r112;
        this.f317363l = r113;
        this.f317364m = r114;
    }
}
