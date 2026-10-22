package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f300490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f300491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f300492c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f300490a, r101.f300490a) == true) goto L12;
        return false;
    L12:
        if (this.f300491b == r101.f300491b) goto L15;
        return false;
    L15:
        if (this.f300492c == r101.f300492c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f300490a.hashCode() * 31;
        int r101 = 1231;
        if (this.f300491b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f300492c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TextStream(spannableStream=" + this.f300490a + ", updateHint=" + this.f300491b + ", isEnd=" + this.f300492c + ')';
    }

    public h(CharSequence r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "spannableStream");
        this.f300490a = r100;
        this.f300491b = r101;
        this.f300492c = r102;
    }
}
