package com.bytedance.kmp.ec.yata.chain.trigger;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f251324a;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f251324a, ((e) r100).f251324a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f251324a.hashCode();
    }

    public final String toString() {
        return "EventDebugInfo(totalDebugParams=" + this.f251324a + ')';
    }

    public e(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "totalDebugParams");
        this.f251324a = r101;
    }
}
