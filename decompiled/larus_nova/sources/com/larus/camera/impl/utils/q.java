package com.larus.camera.impl.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f322796a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f322796a, ((q) r100).f322796a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f322796a.hashCode();
    }

    public final String toString() {
        return "RouteSign(sdkInfo=" + this.f322796a + ')';
    }

    public q(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.x.d.D);
        this.f322796a = r100;
    }
}
