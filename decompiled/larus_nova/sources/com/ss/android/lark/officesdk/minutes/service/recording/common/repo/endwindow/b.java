package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f434939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmEndWindowUnavailableReason f434940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f434941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmEndWindowUnavailableReason f434942d;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f434939a == r101.f434939a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434940b, r101.f434940b) == true) goto L15;
        return false;
    L15:
        if (this.f434941c == r101.f434941c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434942d, r101.f434942d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f434939a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f434940b.hashCode()) * 31;
        if (this.f434941c == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f434942d.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmEndWindowQuotaAvailability(aiSummaryHasQuota=" + this.f434939a + ", aiSummaryUnavailableReason=" + this.f434940b + ", subtitleHasQuota=" + this.f434941c + ", subtitleUnavailableReason=" + this.f434942d + ')';
    }

    public /* synthetic */ b(int r100) {
        this(true, new MmEndWindowUnavailableReason(0, null, 3, null), true, new MmEndWindowUnavailableReason(0, null, 3, null));
    }

    public b(boolean r100, MmEndWindowUnavailableReason r101, boolean r102, MmEndWindowUnavailableReason r103) {
        Intrinsics.checkNotNullParameter(r101, "aiSummaryUnavailableReason");
        Intrinsics.checkNotNullParameter(r103, "subtitleUnavailableReason");
        this.f434939a = r100;
        this.f434940b = r101;
        this.f434941c = r102;
        this.f434942d = r103;
    }
}
