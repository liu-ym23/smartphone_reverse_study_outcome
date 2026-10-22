package com.larus.bmhome.chat.bubble.floating.report;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f297535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297536c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f297534a, r101.f297534a) == true) goto L12;
        return false;
    L12:
        if (this.f297535b == r101.f297535b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297536c, r101.f297536c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f297534a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.f297535b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f297536c;
        if (r105 == null) goto L11;
        r101 = r105.hashCode();
    L11:
        return r104 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BannerShowReportInput(bannerSource=" + this.f297534a + ", showTime=" + this.f297535b + ", serverRequired=" + this.f297536c + ')';
    }

    public a(String r100, long r101, String r102) {
        this.f297534a = r100;
        this.f297535b = r101;
        this.f297536c = r102;
    }
}
