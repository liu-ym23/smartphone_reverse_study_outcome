package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Job f435247b;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f435246a == r101.f435246a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435247b, r101.f435247b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f435246a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Job r102 = this.f435247b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SubtitleFailedPendingState(hasPendingFailure=" + this.f435246a + ", timeoutJob=" + this.f435247b + ')';
    }

    public /* synthetic */ k(int r100) {
        this(false, null);
    }

    public k(boolean r100, Job r101) {
        this.f435246a = r100;
        this.f435247b = r101;
    }

    public static k a(k r100, boolean r101, Job r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f435246a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f435247b;
    L8:
        r100.getClass();
        return new k(r101, r102);
    }
}
