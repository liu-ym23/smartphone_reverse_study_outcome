package com.obric.assistant.settings;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g1 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f392061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f392062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f392063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Boolean, View, Unit> f392064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f392065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f392066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f392067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f392068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f392069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f392070k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (Intrinsics.areEqual(this.f392060a, r101.f392060a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392061b, r101.f392061b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392062c, r101.f392062c) == true) goto L18;
        return false;
    L18:
        if (this.f392063d == r101.f392063d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f392064e, r101.f392064e) == true) goto L24;
        return false;
    L24:
        if (this.f392065f == r101.f392065f) goto L27;
        return false;
    L27:
        if (this.f392066g == r101.f392066g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f392067h, r101.f392067h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f392068i, r101.f392068i) == true) goto L36;
        return false;
    L36:
        if (this.f392069j == r101.f392069j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f392070k, r101.f392070k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f392060a.hashCode() * 31) + this.f392061b.hashCode()) * 31;
        CharSequence r101 = this.f392062c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f392063d == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f392064e.hashCode()) * 31;
        if (this.f392065f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f392066g == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.f392067h;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f392068i;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        if (this.f392069j == true) goto L30;
        r105 = 1237;
    L30:
        int r118 = (r117 + r105) * 31;
        String r119 = this.f392070k;
        if (r119 == null) goto L35;
        r102 = r119.hashCode();
    L35:
        return r118 + r102;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
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
        return "SwitchUiModel(id=" + this.f392060a + ", title=" + this.f392061b + ", subtitle=" + this.f392062c + ", isChecked=" + this.f392063d + ", onCheckedChange=" + this.f392064e + ", showRedPot=" + this.f392065f + ", beta=" + this.f392066g + ", titleTagText=" + this.f392067h + ", tips=" + this.f392068i + ", enabled=" + this.f392069j + ", disabledToastText=" + this.f392070k + ')';
    }

    @Override // com.obric.assistant.settings.q0
    public final boolean a(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof g1) == true) goto L5;
        return false;
    L5:
        g1 r101 = (g1) r100;
        if (Intrinsics.areEqual(this.f392060a, r101.f392060a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f392061b.toString(), r101.f392061b.toString()) == false) goto L35;
        CharSequence r102 = this.f392062c;
        String r103 = null;
        if (r102 == null) goto L12;
        String r104 = r102.toString();
    L13:
        CharSequence r105 = r101.f392062c;
        if (r105 == null) goto L17;
        r103 = r105.toString();
    L17:
        if (Intrinsics.areEqual(r104, r103) == true) goto L19;
        return false;
    L19:
        if (this.f392063d == r101.f392063d) goto L21;
        return false;
    L21:
        if (this.f392065f == r101.f392065f) goto L23;
        return false;
    L23:
        if (this.f392066g == r101.f392066g) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.f392067h, r101.f392067h) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f392068i, r101.f392068i) == true) goto L29;
        return false;
    L29:
        if (this.f392069j == r101.f392069j) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.f392070k, r101.f392070k) == false) goto L43;
        return true;
    L43:
        return false;
    L12:
        r104 = null;
        goto L13
    L35:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g1(String r100, CharSequence r101, CharSequence r102, boolean r103, Function2<? super Boolean, ? super View, Unit> r104, boolean r105, boolean r106, String r107, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r104, "onCheckedChange");
        this.f392060a = r100;
        this.f392061b = r101;
        this.f392062c = r102;
        this.f392063d = r103;
        this.f392064e = r104;
        this.f392065f = r105;
        this.f392066g = r106;
        this.f392067h = r107;
        this.f392068i = r110;
        this.f392069j = r111;
        this.f392070k = r112;
    }
}
