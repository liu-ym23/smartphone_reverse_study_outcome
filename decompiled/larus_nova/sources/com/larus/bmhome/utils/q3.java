package com.larus.bmhome.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.network.http.a<wc9.e> f315103b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q3) == true) goto L8;
        return false;
    L8:
        q3 r101 = (q3) r100;
        if (Intrinsics.areEqual(this.f315102a, r101.f315102a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f315103b, r101.f315103b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f315102a.hashCode() * 31;
        com.larus.network.http.a<wc9.e> r101 = this.f315103b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SimpleConvInfo(convId=" + this.f315102a + ", remoteResp=" + this.f315103b + ')';
    }

    public q3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "convId");
        this.f315102a = r100;
        this.f315103b = null;
        StringsKt.contains$default(r100, "local", false, 2, null);
    }
}
