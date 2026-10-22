package com.bytedance.ee.bear.list.delete;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f227858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f227859b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f227858a == r101.f227858a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f227859b, r101.f227859b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f227858a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f227859b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DeleteResult(allSuccess=" + this.f227858a + ", failedTokenToCode=" + this.f227859b + ')';
    }

    public e(boolean r100, Map<String, Integer> r101) {
        Intrinsics.checkNotNullParameter(r101, "failedTokenToCode");
        this.f227858a = r100;
        this.f227859b = r101;
    }
}
