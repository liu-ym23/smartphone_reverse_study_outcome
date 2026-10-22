package io.ktor.client.statement;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final isc.a f491795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f491796b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f491795a, r101.f491795a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f491796b, r101.f491796b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f491795a.hashCode() * 31) + this.f491796b.hashCode();
    }

    public final String toString() {
        return "HttpResponseContainer(expectedType=" + this.f491795a + ", response=" + this.f491796b + ')';
    }

    public c(isc.a r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "expectedType");
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f491795a = r100;
        this.f491796b = r101;
    }
}
