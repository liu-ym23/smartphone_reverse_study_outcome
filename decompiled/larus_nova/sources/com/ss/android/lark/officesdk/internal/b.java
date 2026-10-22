package com.ss.android.lark.officesdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f433357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f433358c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f433356a, r101.f433356a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433357b, r101.f433357b) == true) goto L15;
        return false;
    L15:
        if (this.f433358c == r101.f433358c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f433356a.hashCode() * 31) + this.f433357b.hashCode()) * 31;
        long r101 = this.f433358c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "OfficeSDKBootTaskTraceRecord(taskName=" + this.f433356a + ", phase=" + this.f433357b + ", costMs=" + this.f433358c + ')';
    }

    public b(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        Intrinsics.checkNotNullParameter(r101, "phase");
        this.f433356a = r100;
        this.f433357b = r101;
        this.f433358c = r102;
    }
}
