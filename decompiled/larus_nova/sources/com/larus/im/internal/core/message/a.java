package com.larus.im.internal.core.message;

import kotlin.jvm.internal.Intrinsics;
import yc9.f0;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f347781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f347782b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f347781a, r101.f347781a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347782b, r101.f347782b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f347781a.hashCode() * 31) + this.f347782b.hashCode();
    }

    public final String toString() {
        return "BatchSendData(request=" + this.f347781a + ", mode=" + this.f347782b + ')';
    }

    public a(f0 r100, x r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.f347781a = r100;
        this.f347782b = r101;
    }
}
