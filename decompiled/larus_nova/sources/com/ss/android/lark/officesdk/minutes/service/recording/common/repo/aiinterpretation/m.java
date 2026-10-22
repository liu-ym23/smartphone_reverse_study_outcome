package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f434782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f434783b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f434782a, r101.f434782a) == true) goto L12;
        return false;
    L12:
        if (this.f434783b == r101.f434783b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f434782a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f434783b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmAIInterpretationStreamSyncInfo(seqId=" + this.f434782a + ", changeToOrigin=" + this.f434783b + ')';
    }

    public m(Long r100, boolean r101) {
        this.f434782a = r100;
        this.f434783b = r101;
    }
}
