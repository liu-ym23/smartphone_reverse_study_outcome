package com.bytedance.ee.bear.office.space;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f236130d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSpaceTabAnchor f236131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeSpaceTabAnchor f236132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OfficeSpaceTabAlignment f236133c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f236131a == r101.f236131a) goto L12;
        return false;
    L12:
        if (this.f236132b == r101.f236132b) goto L15;
        return false;
    L15:
        if (this.f236133c == r101.f236133c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f236131a.hashCode() * 31) + this.f236132b.hashCode()) * 31) + this.f236133c.hashCode();
    }

    public final String toString() {
        return "OfficeSpaceTabLayoutRule(startAnchor=" + this.f236131a + ", endAnchor=" + this.f236132b + ", alignment=" + this.f236133c + ')';
    }

    public q(OfficeSpaceTabAnchor r100, OfficeSpaceTabAnchor r101, OfficeSpaceTabAlignment r102) {
        Intrinsics.checkNotNullParameter(r100, "startAnchor");
        Intrinsics.checkNotNullParameter(r101, "endAnchor");
        Intrinsics.checkNotNullParameter(r102, "alignment");
        this.f236131a = r100;
        this.f236132b = r101;
        this.f236133c = r102;
    }
}
