package com.larksuite.framework.http.v2.internal.rust.stream;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f285654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f285655b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f285654a, r101.f285654a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f285655b, r101.f285655b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f285654a.hashCode() * 31) + this.f285655b.hashCode();
    }

    public final String toString() {
        return "RequestBodyCacheKey(requestId=" + this.f285654a + ", url=" + this.f285655b + ')';
    }

    public h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f285654a = r100;
        this.f285655b = r101;
    }
}
