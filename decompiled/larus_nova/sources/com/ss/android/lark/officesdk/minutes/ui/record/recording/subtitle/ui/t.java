package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f436533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h f436534b;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f436533a == r101.f436533a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f436534b, r101.f436534b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f436533a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f436534b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmSubtitleQuotaCtaRenderState(isSubtitleDegraded=" + this.f436533a + ", quotaCtaState=" + this.f436534b + ')';
    }

    public /* synthetic */ t(int r100) {
        this(false, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.f434921a);
    }

    public t(boolean r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r101) {
        Intrinsics.checkNotNullParameter(r101, "quotaCtaState");
        this.f436533a = r100;
        this.f436534b = r101;
    }
}
