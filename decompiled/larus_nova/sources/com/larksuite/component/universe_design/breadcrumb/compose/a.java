package com.larksuite.component.universe_design.breadcrumb.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f284573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f284574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f284575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f284576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f284577e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Color.m4828equalsimpl0(this.f284573a, r101.f284573a) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.f284574b, r101.f284574b) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.f284575c, r101.f284575c) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.f284576d, r101.f284576d) == true) goto L21;
        return false;
    L21:
        if (Color.m4828equalsimpl0(this.f284577e, r101.f284577e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Color.m4834hashCodeimpl(this.f284573a) * 31) + Color.m4834hashCodeimpl(this.f284574b)) * 31) + Color.m4834hashCodeimpl(this.f284575c)) * 31) + Color.m4834hashCodeimpl(this.f284576d)) * 31) + Color.m4834hashCodeimpl(this.f284577e);
    }

    public final String toString() {
        return "UDBreadcrumbColors(itemText=" + Color.m4835toStringimpl(this.f284573a) + ", currentItemText=" + Color.m4835toStringimpl(this.f284574b) + ", separator=" + Color.m4835toStringimpl(this.f284575c) + ", itemPressedBackground=" + Color.m4835toStringimpl(this.f284576d) + ", itemHoverBackground=" + Color.m4835toStringimpl(this.f284577e) + ')';
    }

    public a(long r100, long r101, long r102, long r103, long r104) {
        this.f284573a = r100;
        this.f284574b = r101;
        this.f284575c = r102;
        this.f284576d = r103;
        this.f284577e = r104;
    }
}
