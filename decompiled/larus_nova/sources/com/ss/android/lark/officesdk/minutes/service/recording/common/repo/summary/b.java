package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f435337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435338c;

    public b() {
        this(null, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f435336a, r101.f435336a) == true) goto L12;
        return false;
    L12:
        if (this.f435337b == r101.f435337b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435338c, r101.f435338c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f435336a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.f435337b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f435338c;
        if (r105 == null) goto L11;
        r101 = r105.hashCode();
    L11:
        return r104 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAISummary(richContent=" + this.f435336a + ", timestamp=" + this.f435337b + ", digest=" + this.f435338c + ')';
    }

    public b(String r100, long r101, String r102) {
        this.f435336a = r100;
        this.f435337b = r101;
        this.f435338c = r102;
    }
}
