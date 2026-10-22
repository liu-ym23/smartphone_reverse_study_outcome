package com.larus.suggest.impl.wcb.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f370119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WcbTransportSource f370120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f370121c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f370119a, r101.f370119a) == true) goto L12;
        return false;
    L12:
        if (this.f370120b == r101.f370120b) goto L15;
        return false;
    L15:
        if (this.f370121c == r101.f370121c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f370119a.hashCode() * 31) + this.f370120b.hashCode()) * 31;
        if (this.f370121c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "WcbTransportEmission(result=" + this.f370119a + ", source=" + this.f370120b + ", refreshesPreviousTarget=" + this.f370121c + ')';
    }

    public g(e r100, WcbTransportSource r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f370119a = r100;
        this.f370120b = r101;
        this.f370121c = r102;
    }
}
