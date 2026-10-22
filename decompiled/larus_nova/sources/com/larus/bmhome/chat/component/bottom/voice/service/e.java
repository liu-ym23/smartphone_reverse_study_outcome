package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f300480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f300481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f300482c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f300480a, r101.f300480a) == true) goto L12;
        return false;
    L12:
        if (this.f300481b == r101.f300481b) goto L15;
        return false;
    L15:
        if (this.f300482c == r101.f300482c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f300480a.hashCode() * 31;
        if (this.f300481b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f300482c;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "NonStreamText(spannableStream=" + this.f300480a + ", isStream=" + this.f300481b + ", streamResultLength=" + this.f300482c + ')';
    }

    public e(CharSequence r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "spannableStream");
        this.f300480a = r100;
        this.f300481b = r101;
        this.f300482c = r102;
    }
}
