package com.larus.camera.impl.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f322795a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f322795a, ((p) r100).f322795a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f322795a.hashCode();
    }

    public final String toString() {
        return "Pay(sdkInfo=" + this.f322795a + ')';
    }

    public p(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.x.d.D);
        this.f322795a = r100;
    }
}
