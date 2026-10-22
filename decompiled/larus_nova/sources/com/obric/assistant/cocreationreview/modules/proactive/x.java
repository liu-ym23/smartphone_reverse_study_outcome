package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.g5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f387526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g5 f387527b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f387526a == r101.f387526a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387527b, r101.f387527b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f387526a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f387527b.hashCode();
    }

    public final String toString() {
        return "ProactiveLoadTicket(sequence=" + this.f387526a + ", request=" + this.f387527b + ')';
    }

    public x(long r100, g5 r101) {
        Intrinsics.checkNotNullParameter(r101, "request");
        this.f387526a = r100;
        this.f387527b = r101;
    }
}
