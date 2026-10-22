package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f434844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f434845b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f434844a, r101.f434844a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434845b, r101.f434845b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        h r100 = this.f434844a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h r104 = this.f434845b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAINotePreviewImage(fullSource=" + this.f434844a + ", thumbSource=" + this.f434845b + ')';
    }

    public g(h r100, h r101) {
        this.f434844a = r100;
        this.f434845b = r101;
    }
}
