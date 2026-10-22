package com.ss.ugc.live.sdk.msg.dispatch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f458268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f458269b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f458268a, r101.f458268a) == true) goto L8;
        return false;
    L8:
        if (this.f458269b == r101.f458269b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f458268a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f458269b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "DispatchEnsure(method=" + this.f458268a + ", expectCountPerDispatch=" + this.f458269b + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f458268a = r100;
        this.f458269b = 2;
    }
}
