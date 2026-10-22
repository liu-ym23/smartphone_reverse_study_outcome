package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f285193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f285194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f285195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f285196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f285197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f285198f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Color.m4828equalsimpl0(this.f285193a, r101.f285193a) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.f285194b, r101.f285194b) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.f285195c, r101.f285195c) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.f285196d, r101.f285196d) == true) goto L21;
        return false;
    L21:
        if (Color.m4828equalsimpl0(this.f285197e, r101.f285197e) == true) goto L24;
        return false;
    L24:
        if (Color.m4828equalsimpl0(this.f285198f, r101.f285198f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Color.m4834hashCodeimpl(this.f285193a) * 31) + Color.m4834hashCodeimpl(this.f285194b)) * 31) + Color.m4834hashCodeimpl(this.f285195c)) * 31) + Color.m4834hashCodeimpl(this.f285196d)) * 31) + Color.m4834hashCodeimpl(this.f285197e)) * 31) + Color.m4834hashCodeimpl(this.f285198f);
    }

    public final String toString() {
        return "UDNoticeColors(background=" + Color.m4835toStringimpl(this.f285193a) + ", text=" + Color.m4835toStringimpl(this.f285194b) + ", icon=" + Color.m4835toStringimpl(this.f285195c) + ", iconButton=" + Color.m4835toStringimpl(this.f285196d) + ", textButton=" + Color.m4835toStringimpl(this.f285197e) + ", textAction=" + Color.m4835toStringimpl(this.f285198f) + ')';
    }

    public b(long r100, long r101, long r102, long r103, long r104, long r110) {
        this.f285193a = r100;
        this.f285194b = r101;
        this.f285195c = r102;
        this.f285196d = r103;
        this.f285197e = r104;
        this.f285198f = r110;
    }
}
