package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f285006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f285007b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Color.m4828equalsimpl0(this.f285006a, r101.f285006a) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.f285007b, r101.f285007b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Color.m4834hashCodeimpl(this.f285006a) * 31) + Color.m4834hashCodeimpl(this.f285007b);
    }

    public final String toString() {
        return "UDEmptyStateColors(titleColor=" + Color.m4835toStringimpl(this.f285006a) + ", descriptionColor=" + Color.m4835toStringimpl(this.f285007b) + ')';
    }

    public b(long r100, long r101) {
        this.f285006a = r100;
        this.f285007b = r101;
    }
}
