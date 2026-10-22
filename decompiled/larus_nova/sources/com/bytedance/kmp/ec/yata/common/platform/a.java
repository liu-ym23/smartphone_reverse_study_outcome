package com.bytedance.kmp.ec.yata.common.platform;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f251506b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f251505a, r101.f251505a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251506b, r101.f251506b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f251505a.hashCode() * 31) + this.f251506b.hashCode();
    }

    public final String toString() {
        return "AssembleUrlResult(schema=" + this.f251505a + ", invalidQueryParams=" + this.f251506b + ')';
    }

    public a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "invalidQueryParams");
        this.f251505a = r100;
        this.f251506b = r101;
    }
}
