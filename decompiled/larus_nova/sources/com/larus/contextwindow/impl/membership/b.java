package com.larus.contextwindow.impl.membership;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f330366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f330367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f330368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<String, String, String> f330369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<String, String> f330370h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f330363a, r101.f330363a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330364b, r101.f330364b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330365c, r101.f330365c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330366d, r101.f330366d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f330367e, r101.f330367e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f330368f, r101.f330368f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f330369g, r101.f330369g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f330370h, r101.f330370h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f330363a.hashCode() * 31) + this.f330364b.hashCode()) * 31) + this.f330365c.hashCode()) * 31) + this.f330366d.hashCode()) * 31) + this.f330367e.hashCode()) * 31) + this.f330368f.hashCode()) * 31) + this.f330369g.hashCode()) * 31) + this.f330370h.hashCode();
    }

    public final String toString() {
        return "ContextWindowSlashSummaryText(contextTitle=" + this.f330363a + ", currentPeriodTitle=" + this.f330364b + ", subscriptionTotalTitle=" + this.f330365c + ", exhaustedTitle=" + this.f330366d + ", unlimitedTitle=" + this.f330367e + ", unusedTitle=" + this.f330368f + ", absoluteUsage=" + this.f330369g + ", percentUsage=" + this.f330370h + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, com.larus.contextwindow.impl.service.c r106, com.larus.contextwindow.impl.service.d r107) {
        Intrinsics.checkNotNullParameter(r100, "contextTitle");
        Intrinsics.checkNotNullParameter(r101, "currentPeriodTitle");
        Intrinsics.checkNotNullParameter(r102, "subscriptionTotalTitle");
        Intrinsics.checkNotNullParameter(r103, "exhaustedTitle");
        Intrinsics.checkNotNullParameter(r104, "unlimitedTitle");
        Intrinsics.checkNotNullParameter(r105, "unusedTitle");
        Intrinsics.checkNotNullParameter(r106, "absoluteUsage");
        Intrinsics.checkNotNullParameter(r107, "percentUsage");
        this.f330363a = r100;
        this.f330364b = r101;
        this.f330365c = r102;
        this.f330366d = r103;
        this.f330367e = r104;
        this.f330368f = r105;
        this.f330369g = r106;
        this.f330370h = r107;
    }
}
