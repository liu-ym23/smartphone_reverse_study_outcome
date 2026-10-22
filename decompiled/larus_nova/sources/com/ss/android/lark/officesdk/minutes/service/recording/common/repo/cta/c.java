package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f434914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f434915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmQuotaData f434916c;

    public c() {
        h.b r100 = null;
        this(r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f434914a, r101.f434914a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434915b, r101.f434915b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434916c, r101.f434916c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f434914a.hashCode() * 31) + this.f434915b.hashCode()) * 31;
        MmQuotaData r101 = this.f434916c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingQuotaCtaEntity(asrCtaState=" + this.f434914a + ", summaryCtaState=" + this.f434915b + ", quotaData=" + this.f434916c + ')';
    }

    public c(h r100, h r101, MmQuotaData r102) {
        Intrinsics.checkNotNullParameter(r100, "asrCtaState");
        Intrinsics.checkNotNullParameter(r101, "summaryCtaState");
        this.f434914a = r100;
        this.f434915b = r101;
        this.f434916c = r102;
    }

    public /* synthetic */ c(h.b r100, h.b r101, int r102) {
        h r103 = r100;
        if ((r102 & 1) == 0) goto L5;
        r103 = h.a.f434921a;
    L5:
        h r104 = r101;
        if ((r102 & 2) == 0) goto L8;
        r104 = h.a.f434921a;
    L8:
        this(r103, r104, null);
    }
}
