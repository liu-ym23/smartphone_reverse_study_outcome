package com.larus.audio.ttsV2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f289924b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f289923a, r101.f289923a) == true) goto L12;
        return false;
    L12:
        if (this.f289924b == r101.f289924b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f289923a.hashCode() * 31;
        long r101 = this.f289924b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "TtsClickBean(showFrom=" + this.f289923a + ", clickTime=" + this.f289924b + ')';
    }

    public g(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "showFrom");
        this.f289923a = r100;
        this.f289924b = r101;
    }
}
