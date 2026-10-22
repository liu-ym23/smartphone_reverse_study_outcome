package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f285106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f285107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f285108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f285109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f285110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f285111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f285112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f285113h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f285114i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f285115j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f285116k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Color.m4828equalsimpl0(this.f285106a, r101.f285106a) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.f285107b, r101.f285107b) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.f285108c, r101.f285108c) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.f285109d, r101.f285109d) == true) goto L21;
        return false;
    L21:
        if (Color.m4828equalsimpl0(this.f285110e, r101.f285110e) == true) goto L24;
        return false;
    L24:
        if (Color.m4828equalsimpl0(this.f285111f, r101.f285111f) == true) goto L27;
        return false;
    L27:
        if (Color.m4828equalsimpl0(this.f285112g, r101.f285112g) == true) goto L30;
        return false;
    L30:
        if (Color.m4828equalsimpl0(this.f285113h, r101.f285113h) == true) goto L33;
        return false;
    L33:
        if (Color.m4828equalsimpl0(this.f285114i, r101.f285114i) == true) goto L36;
        return false;
    L36:
        if (Color.m4828equalsimpl0(this.f285115j, r101.f285115j) == true) goto L39;
        return false;
    L39:
        if (Color.m4828equalsimpl0(this.f285116k, r101.f285116k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((Color.m4834hashCodeimpl(this.f285106a) * 31) + Color.m4834hashCodeimpl(this.f285107b)) * 31) + Color.m4834hashCodeimpl(this.f285108c)) * 31) + Color.m4834hashCodeimpl(this.f285109d)) * 31) + Color.m4834hashCodeimpl(this.f285110e)) * 31) + Color.m4834hashCodeimpl(this.f285111f)) * 31) + Color.m4834hashCodeimpl(this.f285112g)) * 31) + Color.m4834hashCodeimpl(this.f285113h)) * 31) + Color.m4834hashCodeimpl(this.f285114i)) * 31) + Color.m4834hashCodeimpl(this.f285115j)) * 31) + Color.m4834hashCodeimpl(this.f285116k);
    }

    public final String toString() {
        return "UDMenuColors(container=" + Color.m4835toStringimpl(this.f285106a) + ", border=" + Color.m4835toStringimpl(this.f285107b) + ", itemPressed=" + Color.m4835toStringimpl(this.f285108c) + ", itemHover=" + Color.m4835toStringimpl(this.f285109d) + ", text=" + Color.m4835toStringimpl(this.f285110e) + ", description=" + Color.m4835toStringimpl(this.f285111f) + ", icon=" + Color.m4835toStringimpl(this.f285112g) + ", disabledText=" + Color.m4835toStringimpl(this.f285113h) + ", disabledIcon=" + Color.m4835toStringimpl(this.f285114i) + ", divider=" + Color.m4835toStringimpl(this.f285115j) + ", loading=" + Color.m4835toStringimpl(this.f285116k) + ')';
    }

    public a(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212) {
        this.f285106a = r100;
        this.f285107b = r101;
        this.f285108c = r102;
        this.f285109d = r110;
        this.f285110e = r111;
        this.f285111f = r112;
        this.f285112g = r113;
        this.f285113h = r114;
        this.f285114i = r210;
        this.f285115j = r211;
        this.f285116k = r212;
    }
}
