package com.larksuite.component.card.component.text;

import android.text.Layout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextProps f283609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout f283610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f283611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f283612d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f283609a, r101.f283609a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283610b, r101.f283610b) == true) goto L15;
        return false;
    L15:
        if (this.f283611c == r101.f283611c) goto L18;
        return false;
    L18:
        if (this.f283612d == r101.f283612d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        TextProps r100 = this.f283609a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.f283610b.hashCode()) * 31) + this.f283611c) * 31) + this.f283612d;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "TextUpdateData(textContent=" + this.f283609a + ", textLayout=" + this.f283610b + ", textColorBySpanParse=" + this.f283611c + ", textExtraPadding=" + this.f283612d + ')';
    }

    public c(TextProps r100, Layout r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "textLayout");
        this.f283609a = r100;
        this.f283610b = r101;
        this.f283611c = r102;
        this.f283612d = r103;
    }
}
