package com.larus.bmhome.view.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f1 implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f317276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f317277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f317278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f317279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f317280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f317281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f317282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f317283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f317284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f317285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Boolean, Unit> f317286k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (this.f317276a == r101.f317276a) goto L12;
        return false;
    L12:
        if (this.f317277b == r101.f317277b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f317278c, r101.f317278c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f317279d, r101.f317279d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f317280e, r101.f317280e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f317281f, r101.f317281f) == true) goto L27;
        return false;
    L27:
        if (this.f317282g == r101.f317282g) goto L30;
        return false;
    L30:
        if (this.f317283h == r101.f317283h) goto L33;
        return false;
    L33:
        if (this.f317284i == r101.f317284i) goto L36;
        return false;
    L36:
        if (this.f317285j == r101.f317285j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f317286k, r101.f317286k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f317276a * 31;
        int r101 = 1231;
        if (this.f317277b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f317278c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f317279d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f317280e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f317281f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f317282g == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f317283h == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f317284i == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f317285j == true) goto L38;
        r101 = 1237;
    L38:
        int r123 = (r122 + r101) * 31;
        Function1<Boolean, Unit> r124 = this.f317286k;
        if (r124 == null) goto L43;
        r105 = r124.hashCode();
    L43:
        return r123 + r105;
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
        return "SwitchMenu(id=" + this.f317276a + ", removeAroundDivider=" + this.f317277b + ", textString=" + this.f317278c + ", iconUrl=" + this.f317279d + ", textIcon=" + this.f317280e + ", textColor=" + this.f317281f + ", isSelected=" + this.f317282g + ", forbiddenDismissAfterClick=" + this.f317283h + ", switchStatus=" + this.f317284i + ", disableClick=" + this.f317285j + ", onTap=" + this.f317286k + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f317277b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f317276a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f1(int r100, boolean r101, String r102, String r103, Integer r104, Integer r105, boolean r106, boolean r107, boolean r108, boolean r110, Function1<? super Boolean, Unit> r111) {
        this.f317276a = r100;
        this.f317277b = r101;
        this.f317278c = r102;
        this.f317279d = r103;
        this.f317280e = r104;
        this.f317281f = r105;
        this.f317282g = r106;
        this.f317283h = r107;
        this.f317284i = r108;
        this.f317285j = r110;
        this.f317286k = r111;
    }
}
