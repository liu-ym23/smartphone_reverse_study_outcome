package com.larus.dora.impl.resource;

import com.larus.dora.api.DoraEnableScope;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraEnableScope f337838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, n> f337839b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f337838a == r101.f337838a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f337839b, r101.f337839b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f337838a.hashCode() * 31) + this.f337839b.hashCode();
    }

    public final String toString() {
        return "DoraDeviceResourceGrant(scope=" + this.f337838a + ", artifacts=" + this.f337839b + ')';
    }

    public c(DoraEnableScope r100, Map<String, n> r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "artifacts");
        this.f337838a = r100;
        this.f337839b = r101;
    }
}
